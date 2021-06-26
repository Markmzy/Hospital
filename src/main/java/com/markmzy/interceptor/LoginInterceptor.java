package com.markmzy.interceptor;

import com.markmzy.jwt.JWTUtil;
import com.markmzy.model.vo.UserLoginVo;
import com.markmzy.service.IUserService;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor
{

    @Resource
    private IUserService userService;

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception
    {
        System.out.println("执行后,返回前");
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception
    {
        System.out.println("处理中。。。。。。。。。");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
//        // 获取token
//        String token = request.getHeader("token");
        //跨越与拦截器冲突问题
        if ("OPTIONS".equalsIgnoreCase(request.getMethod()))
        {
            return true;
        }
//        if (token == null)
//        {
//            response.setStatus(400);
//            return false;
//        }
//        else if (JWTUtil.checkJwt(token) == null)
//        {
//            response.setStatus(400);
//            return false;
//        }
//        else
//        {//不为空,验证token
//            //续期token
//            Integer userId = JWTUtil.getUserId(token);
//            String username = JWTUtil.getUserName(token);
//            String type = JWTUtil.getRoleName(token);
//            //生成新的token
//            UserLoginVo vo = new UserLoginVo();
//            vo.setId(userId);
//            vo.setUsername(username);
//            vo.setRoleName(type);
//            String newToken = JWTUtil.createJsonWebToken(vo);
//            response.setHeader("token", newToken);
//            response.setHeader("Access-Control-Expose-Headers", "token");
//            return true;
//        }

        return true;
    }
}
