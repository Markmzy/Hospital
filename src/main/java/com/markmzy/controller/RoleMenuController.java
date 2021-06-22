package com.markmzy.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.markmzy.service.IRoleMenuService;
import com.markmzy.model.RoleMenu;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 角色菜单关联表 前端控制器
 * </p>
 *
 * @author Zhiyue Ma
 * @since 2021-06-22
 */
@Api(tags = {"角色菜单关联表"})
@RestController
@RequestMapping("/role-menu")
public class RoleMenuController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IRoleMenuService roleMenuService;


    @ApiOperation(value = "新增角色菜单关联表")
    @PostMapping()
    public int add(@RequestBody RoleMenu roleMenu){
        return roleMenuService.add(roleMenu);
    }

    @ApiOperation(value = "删除角色菜单关联表")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return roleMenuService.delete(id);
    }

    @ApiOperation(value = "更新角色菜单关联表")
    @PutMapping()
    public int update(@RequestBody RoleMenu roleMenu){
        return roleMenuService.updateData(roleMenu);
    }

    @ApiOperation(value = "查询角色菜单关联表分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<RoleMenu> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return roleMenuService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询角色菜单关联表")
    @GetMapping("{id}")
    public RoleMenu findById(@PathVariable Long id){
        return roleMenuService.findById(id);
    }

}
