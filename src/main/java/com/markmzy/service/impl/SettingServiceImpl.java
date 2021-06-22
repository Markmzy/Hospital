package com.markmzy.service.impl;

import com.markmzy.model.Setting;
import com.markmzy.dao.SettingMapper;
import com.markmzy.service.ISettingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 每月的自动生成排班设置，管理员可以根据生成的信息特殊处理 服务实现类
 * </p>
 *
 * @author Zhiyue Ma
 * @since 2021-06-22
 */
@Service
public class SettingServiceImpl extends ServiceImpl<SettingMapper, Setting> implements ISettingService {

    @Override
    public  IPage<Setting> findListByPage(Integer page, Integer pageCount){
        IPage<Setting> wherePage = new Page<>(page, pageCount);
        Setting where = new Setting();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Setting setting){
        return baseMapper.insert(setting);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Setting setting){
        return baseMapper.updateById(setting);
    }

    @Override
    public Setting findById(Long id){
        return  baseMapper.selectById(id);
    }
}
