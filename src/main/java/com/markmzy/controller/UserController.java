package com.markmzy.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.markmzy.model.TongJi;
import com.markmzy.model.User;
import com.markmzy.model.vo.UserDeptVo;
import com.markmzy.service.IUserService;
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
import java.util.List;

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

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IUserService userService;


    @ApiOperation(value = "新增用户信息")
    @RequestMapping("/add")
    public R add(@RequestBody User user)
    {
        if (userService.add(user) > 0)
            return R.ok("添加用户成功");

        return R.fail("添加用户失败");

    }

    @ApiOperation(value = "删除用户信息")
    @RequestMapping("/deleteByIds")
    public R delete(Integer[] ids)
    {
        int n = 0;
        for(Integer id : ids)
        {
            n += userService.delete(id);
        }

        if(n > 0)
            return R.ok("删除用户成功");

        return R.fail("删除用户失败");
    }

    @ApiOperation(value = "修改用户信息")
    @RequestMapping("/update")
    public R update(@RequestBody User user)
    {
        int nums = userService.updateData(user);
        if (nums > 0)
            return R.ok("修改用户成功");

        return R.fail("修改用户失败");
    }

    @ApiOperation(value = "查询用户信息分页数据")
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

    @ApiOperation(value = "id查询用户信息")
    @GetMapping("{id}")
    public User findById(@PathVariable Integer id)
    {
        return userService.findById(id);
    }

    @ApiOperation(value = "分页查询所有用户")
    @RequestMapping("/queryUserAll")
    public JsonObject queryUserAll(UserDeptVo userDeptVo, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "15") int pageSize)
    {
        PageInfo<UserDeptVo> pageInfo = userService.queryUserAll(userDeptVo, pageNum, pageSize);
        JsonObject object = new JsonObject();
        object.setMsg("ok");
        object.setCode(0);
        object.setCount(pageInfo.getTotal());
        object.setData(pageInfo.getList());
        return object;
    }

    @RequestMapping("/queryUserInfoAll")
    public List<UserDeptVo> queryUserInfoAll()
    {
        PageInfo<UserDeptVo> pageInfo = userService.queryUserAll(null, 1, 15);
        return pageInfo.getList();
    }

    /**
     * 统计接口
     *
     * @param
     * @return
     */
    @RequestMapping("/queryTongjiList")
    public List<TongJi> queryTongjiList()
    {
        return userService.queryTongjiCounts();
    }


}
