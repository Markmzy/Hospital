package com.markmzy.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.markmzy.model.PatientInfo;
import com.markmzy.model.vo.UserDeptVo;
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
import java.util.Arrays;
import java.util.List;

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

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IPatientInfoService patientInfoService;

    @ApiOperation(value = "新增病人信息表")
    @PostMapping()
    public int add(@RequestBody PatientInfo patientInfo)
    {
        return patientInfoService.add(patientInfo);
    }

    @ApiOperation(value = "删除病人信息表")
    @RequestMapping("/deleteByIds")
    public R delete(Integer ids)
    {
        // 把字符串转成集合对象
        List<Integer> list = Arrays.asList(ids);

        int n = 0;
        for (Integer i : list)
        {
            n += patientInfoService.delete(i);
        }

        if (n > 0)
            return R.ok("删除病人成功");

        return R.fail("删除病人失败");
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

}
