package com.markmzy.service;

import com.markmzy.model.Exchange;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 调休记录信息  服务类
 * </p>
 *
 * @author Zhiyue Ma
 * @since 2021-06-22
 */
public interface IExchangeService extends IService<Exchange> {

    /**
     * 查询调休记录信息 分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Exchange>
     */
    IPage<Exchange> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加调休记录信息 
     *
     * @param exchange 调休记录信息 
     * @return int
     */
    int add(Exchange exchange);

    /**
     * 删除调休记录信息 
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改调休记录信息 
     *
     * @param exchange 调休记录信息 
     * @return int
     */
    int updateData(Exchange exchange);

    /**
     * id查询数据
     *
     * @param id id
     * @return Exchange
     */
    Exchange findById(Long id);
}
