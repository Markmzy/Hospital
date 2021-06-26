package com.markmzy.model.vo;

import lombok.Data;

/**
 * <p>
 * 用户登陆Vo表
 * </p>
 *
 * @author Zhiyue Ma
 * @since 2021-06-23
 */

@Data
public class UserLoginVo
{
    private Integer id;
    private String username;
    private String roleName;
}
