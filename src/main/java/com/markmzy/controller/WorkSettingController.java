package com.markmzy.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.markmzy.model.WorkSetting;
import com.markmzy.service.IWorkSettingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 医生排班的默认设置，用来初始化处理信息，主要按周1到周五排班配置，后续每月周一到周五均按照这个初始化医生上班时间 前端控制器
 * </p>
 *
 * @author Zhiyue Ma
 * @since 2021-06-22
 */
@Api(tags = {"医生排班的默认设置，用来初始化处理信息，主要按周1到周五排班配置，后续每月周一到周五均按照这个初始化医生上班时间"})
@RestController
@RequestMapping("/work-setting")
public class WorkSettingController
{

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IWorkSettingService workSettingService;


    @ApiOperation(value = "新增医生排班的默认设置，用来初始化处理信息，主要按周1到周五排班配置，后续每月周一到周五均按照这个初始化医生上班时间")
    @PostMapping()
    public int add(@RequestBody WorkSetting workSetting)
    {
        return workSettingService.add(workSetting);
    }

    @ApiOperation(value = "删除医生排班的默认设置，用来初始化处理信息，主要按周1到周五排班配置，后续每月周一到周五均按照这个初始化医生上班时间")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id)
    {
        return workSettingService.delete(id);
    }

    @ApiOperation(value = "更新医生排班的默认设置，用来初始化处理信息，主要按周1到周五排班配置，后续每月周一到周五均按照这个初始化医生上班时间")
    @PutMapping()
    public int update(@RequestBody WorkSetting workSetting)
    {
        return workSettingService.updateData(workSetting);
    }

    @ApiOperation(value = "查询医生排班的默认设置，用来初始化处理信息，主要按周1到周五排班配置，后续每月周一到周五均按照这个初始化医生上班时间分页数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码"),
            @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<WorkSetting> findListByPage(@RequestParam Integer page,
                                             @RequestParam Integer pageCount)
    {
        return workSettingService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询医生排班的默认设置，用来初始化处理信息，主要按周1到周五排班配置，后续每月周一到周五均按照这个初始化医生上班时间")
    @GetMapping("{id}")
    public WorkSetting findById(@PathVariable Long id)
    {
        return workSettingService.findById(id);
    }

}
