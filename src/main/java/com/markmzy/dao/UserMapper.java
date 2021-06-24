package com.markmzy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.markmzy.model.User;
import org.springframework.stereotype.Component;

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
}
