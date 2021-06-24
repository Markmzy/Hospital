package com.markmzy.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.markmzy.dao.ExchangeMapper;
import com.markmzy.model.Exchange;
import com.markmzy.service.IExchangeService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 调休记录信息  服务实现类
 * </p>
 *
 * @author Zhiyue Ma
 * @since 2021-06-22
 */
@Service
public class ExchangeServiceImpl extends ServiceImpl<ExchangeMapper, Exchange> implements IExchangeService
{

    @Override
    public IPage<Exchange> findListByPage(Integer page, Integer pageCount)
    {
        IPage<Exchange> wherePage = new Page<>(page, pageCount);
        Exchange where = new Exchange();

        return baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Exchange exchange)
    {
        return baseMapper.insert(exchange);
    }

    @Override
    public int delete(Long id)
    {
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Exchange exchange)
    {
        return baseMapper.updateById(exchange);
    }

    @Override
    public Exchange findById(Long id)
    {
        return baseMapper.selectById(id);
    }
}
