package com.markmzy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.markmzy.model.OrderInfo;

import java.util.List;

/**
 * <p>
 * 病人的预约记录 Mapper 接口
 * </p>
 *
 * @author Zhiyue Ma
 * @since 2021-06-22
 */
public interface OrderInfoMapper extends BaseMapper<OrderInfo>
{
    /**
     * 查询预约记录信息
     */
    List<OrderInfo> queryOrderInfoByAll(OrderInfo orderInfo);

    OrderInfo queryByOrderInfo2(OrderInfo orderInfo);
}
