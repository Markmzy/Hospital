package com.markmzy.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.markmzy.dao.WorkSettingMapper;
import com.markmzy.model.WorkSetting;
import com.markmzy.service.IWorkSettingService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 医生排班的默认设置，用来初始化处理信息，主要按周1到周五排班配置，后续每月周一到周五均按照这个初始化医生上班时间 服务实现类
 * </p>
 *
 * @author Zhiyue Ma
 * @since 2021-06-22
 */
@Service
public class WorkSettingServiceImpl extends ServiceImpl<WorkSettingMapper, WorkSetting> implements IWorkSettingService
{

    @Override
    public IPage<WorkSetting> findListByPage(Integer page, Integer pageCount)
    {
        IPage<WorkSetting> wherePage = new Page<>(page, pageCount);
        WorkSetting where = new WorkSetting();

        return baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(WorkSetting workSetting)
    {
        return baseMapper.insert(workSetting);
    }

    @Override
    public int delete(Long id)
    {
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(WorkSetting workSetting)
    {
        return baseMapper.updateById(workSetting);
    }

    @Override
    public WorkSetting findById(Long id)
    {
        return baseMapper.selectById(id);
    }
}
