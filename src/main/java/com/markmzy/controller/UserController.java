package com.markmzy.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.markmzy.model.User;
import com.markmzy.service.IUserService;
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
 * 用户信息表 前端控制器
 * </p>
 *
 * @author Zhiyue Ma
 * @since 2021-06-22
 */
@Api(tags = {"用户信息表"})
@RestController
@RequestMapping("/user")
public class UserController
{

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IUserService userService;


    @ApiOperation(value = "新增用户信息表")
    @PostMapping()
    public int add(@RequestBody User user)
    {
        return userService.add(user);
    }

    @ApiOperation(value = "删除用户信息表")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Integer id)
    {
        return userService.delete(id);
    }

    @ApiOperation(value = "更新用户信息表")
    @PutMapping()
    public int update(@RequestBody User user)
    {
        return userService.updateData(user);
    }

    @ApiOperation(value = "查询用户信息表分页数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码"),
            @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<User> findListByPage(@RequestParam Integer page,
                                      @RequestParam Integer pageCount)
    {
        return userService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询用户信息表")
    @GetMapping("{id}")
    public User findById(@PathVariable Integer id)
    {
        return userService.findById(id);
    }

}
