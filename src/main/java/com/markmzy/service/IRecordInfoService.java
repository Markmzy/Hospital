package com.markmzy.service;

import com.markmzy.model.RecordInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 就诊记录信息 服务类
 * </p>
 *
 * @author Zhiyue Ma
 * @since 2021-06-22
 */
public interface IRecordInfoService extends IService<RecordInfo> {

    /**
     * 查询就诊记录信息分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<RecordInfo>
     */
    IPage<RecordInfo> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加就诊记录信息
     *
     * @param recordInfo 就诊记录信息
     * @return int
     */
    int add(RecordInfo recordInfo);

    /**
     * 删除就诊记录信息
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改就诊记录信息
     *
     * @param recordInfo 就诊记录信息
     * @return int
     */
    int updateData(RecordInfo recordInfo);

    /**
     * id查询数据
     *
     * @param id id
     * @return RecordInfo
     */
    RecordInfo findById(Long id);
}
