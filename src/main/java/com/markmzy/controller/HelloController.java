package com.markmzy.controller;

import com.markmzy.model.entity.User;
import com.markmzy.service.IUserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class HelloController
{
    @Autowired
    private IUserService userService;

    @RequestMapping("/hello")
    public String helloController()
    {
        return "Hello:)";
    }

    @RequestMapping("/queryUserList")
    public List<User> queryUserList()
    {
        List<User> userList = userService.list();
        return userList;
    }
}
