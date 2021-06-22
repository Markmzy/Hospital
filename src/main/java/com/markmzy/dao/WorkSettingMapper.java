package com.markmzy.dao;

import com.markmzy.model.WorkSetting;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 医生排班的默认设置，用来初始化处理信息，主要按周1到周五排班配置，后续每月周一到周五均按照这个初始化医生上班时间 Mapper 接口
 * </p>
 *
 * @author Zhiyue Ma
 * @since 2021-06-22
 */
public interface WorkSettingMapper extends BaseMapper<WorkSetting> {

}
