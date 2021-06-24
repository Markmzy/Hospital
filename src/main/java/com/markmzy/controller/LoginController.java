package com.markmzy.controller;

import com.markmzy.jwt.JWTUtil;
import com.markmzy.model.User;
import com.markmzy.model.vo.UserVo;
import com.markmzy.service.IUserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController
{
    @Resource
    IUserService userService;

    @RequestMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> map)
    {
        Map<String, String> m = new HashMap();
        // 接收前端传过来的信息
        String username = map.get("username");
        String password = map.get("password");
        String roleName = map.get("roleName");

        // 根据信息判断用户是否存在
        if (roleName.equals("0") || roleName.equals("1")) // 医生或者管理员
        {
            // 调用service层的方法
            User u = new User();
            u.setUsername(username);
            u.setPassword(password);
            u.setRoleName(roleName);

            User user = userService.findUserByNameAndPwd(u);
            if (user != null)
            {
                // 生成token信息
                UserVo userVo = new UserVo();
                userVo.setId(user.getId());
                userVo.setUsername(username);
                userVo.setRoleName(roleName);

                String token = JWTUtil.creatJWT(userVo);
                m.put("token", token);
                m.put("username", username);
                m.put("roleName", roleName);

                // 登陆成功
                m.put("code", "200");
                m.put("msg", "登陆成功");
            }
            else // 登陆失败
            {
                m.put("code", "400");
                m.put("msg", "该用户不存在登陆失败");
            }

            return m;

        }
        else //患者
        {
            return m;
        }

    }
}
