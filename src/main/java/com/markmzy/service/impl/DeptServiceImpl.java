package com.markmzy.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.markmzy.dao.DeptMapper;
import com.markmzy.model.Dept;
import com.markmzy.service.IDeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 科室 服务实现类
 * </p>
 *
 * @author Zhiyue Ma
 * @since 2021-06-22
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService
{

    @Resource
    private DeptMapper deptMapper;

    @Override
    public PageInfo<Dept> queryDeptAll(int pageNum, int pageSize, Dept dept)
    {
        PageHelper.startPage(pageNum, pageSize);
        List<Dept> list = deptMapper.queryDeptAll(dept);
        return new PageInfo<>(list);
    }

    @Override
    public IPage<Dept> findListByPage(Integer page, Integer pageCount)
    {
        IPage<Dept> wherePage = new Page<>(page, pageCount);
        Dept where = new Dept();

        return baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Dept dept)
    {
        return baseMapper.insert(dept);
    }

    @Override
    public int delete(Integer id)
    {
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Dept dept)
    {
        return baseMapper.updateById(dept);
    }

    @Override
    public Dept findById(Integer id)
    {
        return baseMapper.selectById(id);
    }

    @Override
    public List<Dept> queryListByPid(Integer parentId)
    {
        return deptMapper.queryListByPid(parentId);
    }
}
