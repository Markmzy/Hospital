package com.markmzy.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.markmzy.model.PatientInfo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 病人信息表 服务类
 * </p>
 *
 * @author Zhiyue Ma
 * @since 2021-06-22
 */
public interface IPatientInfoService extends IService<PatientInfo>
{

    PageInfo<PatientInfo> findUserAll(int page, int pageSize, PatientInfo patientInfo);

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
    int delete(Integer id);

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
    PatientInfo findById(Integer id);

    /**
     * 查询所有病人
     */
    PageInfo<PatientInfo> queryPatientAll(PatientInfo patient, int pageNum, int pageSize);

    PatientInfo queryPatByUsernameAndPassword(String username, String password);

    PatientInfo queryPatByName(@Param("username") String username);
}
