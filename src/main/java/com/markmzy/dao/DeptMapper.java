package com.markmzy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.markmzy.model.Dept;

import java.util.List;

/**
 * <p>
 * 科室 Mapper 接口
 * </p>
 *
 * @author Zhiyue Ma
 * @since 2021-06-22
 */
public interface DeptMapper extends BaseMapper<Dept>
{
    /**
     * 查询所有记录
     */
    List<Dept> queryDeptAll(Dept dept);

    List<Dept> queryListByPid(Integer parentId);
}
