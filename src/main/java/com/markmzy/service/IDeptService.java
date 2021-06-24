package com.markmzy.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.markmzy.model.Dept;

import java.util.List;

/**
 * <p>
 * 科室 服务类
 * </p>
 *
 * @author Zhiyue Ma
 * @since 2021-06-22
 */
public interface IDeptService extends IService<Dept>
{

    PageInfo<Dept> queryDeptAll(int pageNum, int pageSize, Dept dept);

    /**
     * 查询科室分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Dept>
     */
    IPage<Dept> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加科室
     *
     * @param dept 科室
     * @return int
     */
    int add(Dept dept);

    /**
     * 删除科室
     *
     * @param id 主键
     * @return int
     */
    int delete(Integer id);

    /**
     * 修改科室
     *
     * @param dept 科室
     * @return int
     */
    int updateData(Dept dept);

    /**
     * id查询数据
     *
     * @param id id
     * @return Dept
     */
    Dept findById(Integer id);


    List<Dept> queryListByPid(Integer parentId);
}
