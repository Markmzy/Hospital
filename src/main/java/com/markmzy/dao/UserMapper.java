package com.markmzy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.markmzy.model.TongJi;
import com.markmzy.model.User;
import com.markmzy.model.vo.UserDeptVo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author Zhiyue Ma
 * @since 2021-06-22
 */
@Component
public interface UserMapper extends BaseMapper<User>
{
    /**
     * 根据用户名和密码判断用户是否存在
     */

    User findUserByNameAndPwd(User user);

    /**
     * 查询所有用户
     */
    List<UserDeptVo> queryUserAll(UserDeptVo userDeptVo);

    /**
     * 统计
     */
    List<TongJi> queryTongjiCounts();
}
