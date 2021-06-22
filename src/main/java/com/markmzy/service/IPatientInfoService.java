package com.markmzy.service;

import com.markmzy.model.PatientInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 病人信息表 服务类
 * </p>
 *
 * @author Zhiyue Ma
 * @since 2021-06-22
 */
public interface IPatientInfoService extends IService<PatientInfo> {

    /**
     * 查询病人信息表分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<PatientInfo>
     */
    IPage<PatientInfo> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加病人信息表
     *
     * @param patientInfo 病人信息表
     * @return int
     */
    int add(PatientInfo patientInfo);

    /**
     * 删除病人信息表
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改病人信息表
     *
     * @param patientInfo 病人信息表
     * @return int
     */
    int updateData(PatientInfo patientInfo);

    /**
     * id查询数据
     *
     * @param id id
     * @return PatientInfo
     */
    PatientInfo findById(Long id);
}
