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
 * 菜单信息表
 * </p>
 *
 * @author Zhiyue Ma
 * @since 2021-06-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Menu对象", description="菜单信息表")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    @ApiModelProperty(value = "1:导航  2 按钮 ")
    private Integer type;

    @ApiModelProperty(value = "0 代表女 1 代表男")
    private Integer sort;

    private Integer status;

    private String url;

    private String permission;

    private String icon;

    private Date createTime;

    private String createBy;

    private Date updateTime;


}
