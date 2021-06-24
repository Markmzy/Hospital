package com.markmzy.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 病人的预约记录
 * </p>
 *
 * @author Zhiyue Ma
 * @since 2021-06-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "OrderInfo对象", description = "病人的预约记录")
public class OrderInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String userId;

    private Date day;

    private String dayTime;

    private Integer patientId;

    private Integer status;

    private Integer deptId;


}
