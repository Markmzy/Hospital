package com.markmzy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.markmzy.dao.UserMapper;
import com.markmzy.model.entity.User;
import com.markmzy.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImlp extends ServiceImpl<UserMapper, User> implements IUserService
{

}
