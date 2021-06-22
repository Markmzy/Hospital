package com.markmzy.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.markmzy.service.ISettingService;
import com.markmzy.model.Setting;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 每月的自动生成排班设置，管理员可以根据生成的信息特殊处理 前端控制器
 * </p>
 *
 * @author Zhiyue Ma
 * @since 2021-06-22
 */
@Api(tags = {"每月的自动生成排班设置，管理员可以根据生成的信息特殊处理"})
@RestController
@RequestMapping("/setting")
public class SettingController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private ISettingService settingService;


    @ApiOperation(value = "新增每月的自动生成排班设置，管理员可以根据生成的信息特殊处理")
    @PostMapping()
    public int add(@RequestBody Setting setting){
        return settingService.add(setting);
    }

    @ApiOperation(value = "删除每月的自动生成排班设置，管理员可以根据生成的信息特殊处理")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return settingService.delete(id);
    }

    @ApiOperation(value = "更新每月的自动生成排班设置，管理员可以根据生成的信息特殊处理")
    @PutMapping()
    public int update(@RequestBody Setting setting){
        return settingService.updateData(setting);
    }

    @ApiOperation(value = "查询每月的自动生成排班设置，管理员可以根据生成的信息特殊处理分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Setting> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return settingService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询每月的自动生成排班设置，管理员可以根据生成的信息特殊处理")
    @GetMapping("{id}")
    public Setting findById(@PathVariable Long id){
        return settingService.findById(id);
    }

}
