package com.markmzy.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 用户部门Vo表
 * </p>
 *
 * @author Zhiyue Ma
 * @since 2021-06-24
 */

@Data
public class UserDeptVo
{
    private Integer id;

    private String username;

    private String password;

    private Integer deptId;

    private String deptName; // 为了拿到名字

    private String roleName;

    private String images;

    private String realname;

    private String sex;

    private String dateOfBirth;

    private String tel;

    private String email;

    @ApiModelProperty(value = "职称")
    private String jobTitle;

    private String info;

    private String createBy;

    private Date updateTime;

    private Date createTime;

}
