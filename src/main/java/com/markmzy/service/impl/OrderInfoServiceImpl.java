package com.markmzy.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.markmzy.dao.OrderInfoMapper;
import com.markmzy.model.OrderInfo;
import com.markmzy.service.IOrderInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 病人的预约记录 服务实现类
 * </p>
 *
 * @author Zhiyue Ma
 * @since 2021-06-22
 */
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements IOrderInfoService
{
    @Resource
    private OrderInfoMapper orderInfoMapper;


    @Override
    public OrderInfo queryByRecordInfo(OrderInfo orderInfo)
    {
        return orderInfoMapper.queryByOrderInfo2(orderInfo);
    }

    @Override
    public PageInfo<OrderInfo> findOrderInfoAll(int page, int limit, OrderInfo orderInfo)
    {
        PageHelper.startPage(page, limit);
        List<OrderInfo> list = orderInfoMapper.queryOrderInfoByAll(orderInfo);
        PageInfo<OrderInfo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public IPage<OrderInfo> findListByPage(Integer page, Integer pageCount)
    {
        IPage<OrderInfo> wherePage = new Page<>(page, pageCount);
        OrderInfo where = new OrderInfo();

        return baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(OrderInfo orderInfo)
    {
        return baseMapper.insert(orderInfo);
    }

    @Override
    public int delete(Long id)
    {
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(OrderInfo orderInfo)
    {
        return baseMapper.updateById(orderInfo);
    }

    @Override
    public OrderInfo findById(Long id)
    {
        return baseMapper.selectById(id);
    }
}
