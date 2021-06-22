package com.markmzy.service.impl;

import com.markmzy.model.RecordInfo;
import com.markmzy.dao.RecordInfoMapper;
import com.markmzy.service.IRecordInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 就诊记录信息 服务实现类
 * </p>
 *
 * @author Zhiyue Ma
 * @since 2021-06-22
 */
@Service
public class RecordInfoServiceImpl extends ServiceImpl<RecordInfoMapper, RecordInfo> implements IRecordInfoService {

    @Override
    public  IPage<RecordInfo> findListByPage(Integer page, Integer pageCount){
        IPage<RecordInfo> wherePage = new Page<>(page, pageCount);
        RecordInfo where = new RecordInfo();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(RecordInfo recordInfo){
        return baseMapper.insert(recordInfo);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(RecordInfo recordInfo){
        return baseMapper.updateById(recordInfo);
    }

    @Override
    public RecordInfo findById(Long id){
        return  baseMapper.selectById(id);
    }
}
