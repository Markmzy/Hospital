package com.markmzy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.markmzy.model.Setting;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 每月的自动生成排班设置，管理员可以根据生成的信息特殊处理 Mapper 接口
 * </p>
 *
 * @author Zhiyue Ma
 * @since 2021-06-22
 */
public interface SettingMapper extends BaseMapper<Setting>
{
    /**
     * 根据用户id 获取默认的设置信息
     */
    List<Setting> querySettingListByUserId(@Param("userId") Integer userId);

    //根据用户id删除排班设置信息
    int deleteByUserId(@Param("userId") Integer userId);

    /**
     * 根据用户id  时间  时间段 获取它的 数据信息
     */
    int getCountsBySet(Setting setting);
}
