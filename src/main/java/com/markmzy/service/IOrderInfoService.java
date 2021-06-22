package com.markmzy.service;

import com.markmzy.model.OrderInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 病人的预约记录 服务类
 * </p>
 *
 * @author Zhiyue Ma
 * @since 2021-06-22
 */
public interface IOrderInfoService extends IService<OrderInfo> {

    /**
     * 查询病人的预约记录分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<OrderInfo>
     */
    IPage<OrderInfo> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加病人的预约记录
     *
     * @param orderInfo 病人的预约记录
     * @return int
     */
    int add(OrderInfo orderInfo);

    /**
     * 删除病人的预约记录
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改病人的预约记录
     *
     * @param orderInfo 病人的预约记录
     * @return int
     */
    int updateData(OrderInfo orderInfo);

    /**
     * id查询数据
     *
     * @param id id
     * @return OrderInfo
     */
    OrderInfo findById(Long id);
}
