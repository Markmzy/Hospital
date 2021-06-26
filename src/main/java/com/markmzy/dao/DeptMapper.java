package com.markmzy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.markmzy.model.Dept;
import com.markmzy.model.Node;
import com.markmzy.model.vo.DeptVo;

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
    List<DeptVo> queryDeptAll();

    /**
     * 通过父id查所有子科室
     */
    List<Dept> queryListByPid(Integer parentId);

    /**
     * 查询部门树
     */
    List<Node> queryDeptTree();

}
