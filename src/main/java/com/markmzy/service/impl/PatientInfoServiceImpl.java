package com.markmzy.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.markmzy.dao.PatientInfoMapper;
import com.markmzy.model.PatientInfo;
import com.markmzy.service.IPatientInfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 病人信息表 服务实现类
 * </p>
 *
 * @author Zhiyue Ma
 * @since 2021-06-22
 */
@Service
public class PatientInfoServiceImpl extends ServiceImpl<PatientInfoMapper, PatientInfo> implements IPatientInfoService
{

    @Override
    public IPage<PatientInfo> findListByPage(Integer page, Integer pageCount)
    {
        IPage<PatientInfo> wherePage = new Page<>(page, pageCount);
        PatientInfo where = new PatientInfo();

        return baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(PatientInfo patientInfo)
    {
        return baseMapper.insert(patientInfo);
    }

    @Override
    public int delete(Long id)
    {
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(PatientInfo patientInfo)
    {
        return baseMapper.updateById(patientInfo);
    }

    @Override
    public PatientInfo findById(Long id)
    {
        return baseMapper.selectById(id);
    }
}
