package com.markmzy.service.impl;

import com.markmzy.model.RoleMenu;
import com.markmzy.dao.RoleMenuMapper;
import com.markmzy.service.IRoleMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 角色菜单关联表 服务实现类
 * </p>
 *
 * @author Zhiyue Ma
 * @since 2021-06-22
 */
@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements IRoleMenuService {

    @Override
    public  IPage<RoleMenu> findListByPage(Integer page, Integer pageCount){
        IPage<RoleMenu> wherePage = new Page<>(page, pageCount);
        RoleMenu where = new RoleMenu();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(RoleMenu roleMenu){
        return baseMapper.insert(roleMenu);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(RoleMenu roleMenu){
        return baseMapper.updateById(roleMenu);
    }

    @Override
    public RoleMenu findById(Long id){
        return  baseMapper.selectById(id);
    }
}
