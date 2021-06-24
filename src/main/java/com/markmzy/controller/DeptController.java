package com.markmzy.controller;

import com.github.pagehelper.PageInfo;
import com.markmzy.model.Dept;
import com.markmzy.service.IDeptService;
import com.markmzy.util.JsonObject;
import com.markmzy.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 科室 前端控制器
 * </p>
 *
 * @author Zhiyue Ma
 * @since 2021-06-22
 */
@Api(tags = {"科室"})
@RestController
@RequestMapping("/dept")
public class DeptController
{

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IDeptService deptService;

    @ApiOperation(value = "新增科室")
    @RequestMapping("/add")
    public R add(@RequestBody Dept dept)
    {
        if (deptService.add(dept) > 0)
            return R.ok();

        return R.fail("新增科室失败");
    }

    @ApiOperation(value = "删除科室")
    @RequestMapping("/delete")
    public R delete(@RequestBody Map<String, String> map)
    {
        String idValue = map.get("id");
        //根据id获取当前id的记录信息
        Dept dept = deptService.findById(Integer.parseInt(idValue));
        if (dept.getType() == 1)
        {//科室 删除该科室以及下面的子节点  部门

            //获取当前节点下的子节点的列表信息
            List<Dept> list = deptService.queryListByPid(Integer.parseInt(idValue));
            for (Dept d : list)
            {
                Integer ids = d.getId();
                deptService.delete(ids);

            }

            if(deptService.delete(Integer.parseInt(idValue)) > 0)//当前节点
                return R.ok();
        }
        else
        {
            if(deptService.delete(Integer.parseInt(idValue)) > 0)
                return R.ok();
        }
        return R.fail("删除科室失败");
    }

    @ApiOperation(value = "更新科室")
    @RequestMapping("/update")
    public R update(@RequestBody Dept dept)
    {
        int nums = deptService.updateData(dept);
        if (nums > 0)
            return R.ok();

        return R.fail("修改科室失败");
    }

    @RequestMapping("/queryDeptAll")
    public JsonObject queryDeptAll(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "15") int pageSize, Dept dept)
    {
        PageInfo<Dept> pageInfo = deptService.queryDeptAll(pageNum, pageSize, dept);
        JsonObject object = new JsonObject();
        object.setData(pageInfo.getList());
        return object;
    }

    @ApiOperation(value = "id查询科室")
    @GetMapping("{id}")
    public Dept findById(@PathVariable Integer id)
    {
        return deptService.findById(id);
    }

}
