package com.markmzy.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.markmzy.model.PatientInfo;
import com.markmzy.service.IPatientInfoService;
import com.markmzy.util.JsonObject;
import com.markmzy.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 病人信息表 前端控制器
 * </p>
 *
 * @author Zhiyue Ma
 * @since 2021-06-22
 */
@Api(tags = {"病人信息表"})
@RestController
@RequestMapping("/patient")
public class PatientInfoController
{

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IPatientInfoService patientInfoService;

    @ApiOperation(value = "新增病人信息表")
    @RequestMapping("/add")
    public R add(@RequestBody PatientInfo patientInfo)
    {
        if(patientInfoService.add(patientInfo) > 0)
        {
            return R.ok("注册成功");
        }

        return R.fail("注册失败");
    }

    @ApiOperation(value = "删除病人信息表")
    @RequestMapping("/deleteByIds")
    public R delete(Integer[] ids)
    {
        int n = 0;
        for(Integer id : ids)
        {
            n += patientInfoService.delete(id);
        }

        if(n > 0)
            return R.ok("删除病人成功");

        return R.fail("删除病人失败");
    }

    @RequestMapping("/getUserByName")
    public Map getUserByName(@RequestBody Map<String, String> map)
    {
        Map m = new HashMap<>();
        PatientInfo info = patientInfoService.queryPatByName(map.get("username"));
        if(info != null)
        {
            m.put("code", 100);
            m.put("msg", "该用户名已存在");
        }
        else
        {
            m.put("code", 101);
            m.put("msg", "此用户名可以使用");
        }
        return m;
    }

    @ApiOperation(value = "更新病人信息表")
    @PutMapping()
    public int update(@RequestBody PatientInfo patientInfo)
    {
        return patientInfoService.updateData(patientInfo);
    }

    @ApiOperation(value = "查询病人信息表分页数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码"),
            @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<PatientInfo> findListByPage(@RequestParam Integer page,
                                             @RequestParam Integer pageCount)
    {
        return patientInfoService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询病人信息表")
    @GetMapping("{id}")
    public PatientInfo findById(@PathVariable Integer id)
    {
        return patientInfoService.findById(id);
    }

    @ApiOperation(value = "分页查询所有病人")
    @RequestMapping("/queryPatientAll")
    public JsonObject queryPatientAll(PatientInfo patient, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "15") int pageSize)
    {
        PageInfo<PatientInfo> pageInfo = patientInfoService.queryPatientAll(patient, pageNum, pageSize);
        JsonObject object = new JsonObject();
        object.setMsg("ok");
        object.setCode(0);
        object.setCount(pageInfo.getTotal());
        object.setData(pageInfo.getList());
        return object;
    }

    @RequestMapping("/queryPatientInfoAll")
    public List<PatientInfo> queryPatientInfoAll()
    {
        PageInfo<PatientInfo> pageInfo = patientInfoService.findUserAll(1, 10, null);
        return pageInfo.getList();
    }

}
