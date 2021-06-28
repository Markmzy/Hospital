package com.markmzy.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.markmzy.dao.UserMapper;
import com.markmzy.model.TongJi;
import com.markmzy.model.User;
import com.markmzy.model.vo.UserDeptVo;
import com.markmzy.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author Zhiyue Ma
 * @since 2021-06-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService
{
    @Resource
    private UserMapper userMapper;

    @Override
    public IPage<User> findListByPage(Integer page, Integer pageCount)
    {
        IPage<User> wherePage = new Page<>(page, pageCount);
        User where = new User();

        return baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(User user)
    {
        return baseMapper.insert(user);
    }

    @Override
    public int delete(Integer id)
    {
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(User user)
    {
        return baseMapper.updateById(user);
    }

    @Override
    public User findById(Integer id)
    {
        return baseMapper.selectById(id);
    }

    @Override
    public User findUserByNameAndPwd(User user)
    {
        return userMapper.findUserByNameAndPwd(user);
    }

    @Override
    public PageInfo<UserDeptVo> queryUserAll(UserDeptVo userDeptVo, int pageNum, int pageSize)
    {
        PageHelper.startPage(pageNum, pageSize);
        List<UserDeptVo> list = userMapper.queryUserAll(userDeptVo);
        return new PageInfo<>(list);
    }

    @Override
    public List<TongJi> queryTongjiCounts()
    {
        return userMapper.queryTongjiCounts();
    }
}
