package com.markmzy.model;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author Zhiyue Ma
 * @since 2021-06-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="User对象", description="用户信息表")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String username;

    private String password;

    private Integer deptId;

    private String roleName;

    private String images;

    private String realname;

    private String sex;

    private String tel;

    private String email;

    private String avatar;

    @ApiModelProperty(value = "职称")
    private String jobTitle;

    private Integer status;

    private String info;

    private Integer sort;

    private Integer delFlag;

    private String createBy;

    private Date updateTime;

    private Date createTime;


}
