package com.markmzy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.markmzy.model.PatientInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 病人信息表 Mapper 接口
 * </p>
 *
 * @author Zhiyue Ma
 * @since 2021-06-22
 */
public interface PatientInfoMapper extends BaseMapper<PatientInfo>
{
    List<PatientInfo> queryPatientAll(PatientInfo patient);

    PatientInfo queryPatByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    PatientInfo queryPatByName(@Param("username") String username);
}
