package com.markmzy.model.vo;


import lombok.Data;

/**
 * <p>
 * 科室信息Vo表
 * </p>
 *
 * @author Zhiyue Ma
 * @since 2021-06-23
 */

@Data
public class DeptVo
{
    private Integer id;

    private String name;

    private Integer parentId;

    private Integer type;

    private Integer status;

    private Integer num;

    private String building;

    private Integer room;

}
