package com.markmzy.service;

import com.markmzy.model.WorkSetting;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 医生排班的默认设置，用来初始化处理信息，主要按周1到周五排班配置，后续每月周一到周五均按照这个初始化医生上班时间 服务类
 * </p>
 *
 * @author Zhiyue Ma
 * @since 2021-06-22
 */
public interface IWorkSettingService extends IService<WorkSetting> {

    /**
     * 查询医生排班的默认设置，用来初始化处理信息，主要按周1到周五排班配置，后续每月周一到周五均按照这个初始化医生上班时间分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<WorkSetting>
     */
    IPage<WorkSetting> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加医生排班的默认设置，用来初始化处理信息，主要按周1到周五排班配置，后续每月周一到周五均按照这个初始化医生上班时间
     *
     * @param workSetting 医生排班的默认设置，用来初始化处理信息，主要按周1到周五排班配置，后续每月周一到周五均按照这个初始化医生上班时间
     * @return int
     */
    int add(WorkSetting workSetting);

    /**
     * 删除医生排班的默认设置，用来初始化处理信息，主要按周1到周五排班配置，后续每月周一到周五均按照这个初始化医生上班时间
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改医生排班的默认设置，用来初始化处理信息，主要按周1到周五排班配置，后续每月周一到周五均按照这个初始化医生上班时间
     *
     * @param workSetting 医生排班的默认设置，用来初始化处理信息，主要按周1到周五排班配置，后续每月周一到周五均按照这个初始化医生上班时间
     * @return int
     */
    int updateData(WorkSetting workSetting);

    /**
     * id查询数据
     *
     * @param id id
     * @return WorkSetting
     */
    WorkSetting findById(Long id);
}
