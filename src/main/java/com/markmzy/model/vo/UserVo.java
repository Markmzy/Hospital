package com.markmzy.model.vo;

import lombok.Data;

/**
 * <p>
 * 用户信息Vo表
 * </p>
 *
 * @author Zhiyue Ma
 * @since 2021-06-23
 */

@Data
public class UserVo
{
    private Integer id;
    private String username;
    private String roleName;
}
