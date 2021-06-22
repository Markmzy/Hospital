package com.markmzy.service.impl;

import com.markmzy.model.TitleInfo;
import com.markmzy.dao.TitleInfoMapper;
import com.markmzy.service.ITitleInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 医生职称信息表 服务实现类
 * </p>
 *
 * @author Zhiyue Ma
 * @since 2021-06-22
 */
@Service
public class TitleInfoServiceImpl extends ServiceImpl<TitleInfoMapper, TitleInfo> implements ITitleInfoService {

    @Override
    public  IPage<TitleInfo> findListByPage(Integer page, Integer pageCount){
        IPage<TitleInfo> wherePage = new Page<>(page, pageCount);
        TitleInfo where = new TitleInfo();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(TitleInfo titleInfo){
        return baseMapper.insert(titleInfo);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(TitleInfo titleInfo){
        return baseMapper.updateById(titleInfo);
    }

    @Override
    public TitleInfo findById(Long id){
        return  baseMapper.selectById(id);
    }
}
