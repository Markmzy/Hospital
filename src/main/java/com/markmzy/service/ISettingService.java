package com.markmzy.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.markmzy.model.Setting;

/**
 * <p>
 * 每月的自动生成排班设置，管理员可以根据生成的信息特殊处理 服务类
 * </p>
 *
 * @author Zhiyue Ma
 * @since 2021-06-22
 */
public interface ISettingService extends IService<Setting>
{

    /**
     * 查询每月的自动生成排班设置，管理员可以根据生成的信息特殊处理分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Setting>
     */
    IPage<Setting> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加每月的自动生成排班设置，管理员可以根据生成的信息特殊处理
     *
     * @param setting 每月的自动生成排班设置，管理员可以根据生成的信息特殊处理
     * @return int
     */
    int add(Setting setting);

    /**
     * 删除每月的自动生成排班设置，管理员可以根据生成的信息特殊处理
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改每月的自动生成排班设置，管理员可以根据生成的信息特殊处理
     *
     * @param setting 每月的自动生成排班设置，管理员可以根据生成的信息特殊处理
     * @return int
     */
    int updateData(Setting setting);

    /**
     * id查询数据
     *
     * @param id id
     * @return Setting
     */
    Setting findById(Long id);
}
