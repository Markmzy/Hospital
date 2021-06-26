package com.markmzy.jwt;

import com.markmzy.model.vo.UserLoginVo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JWTUtil
{
    // 有效时间
    private static final Long expireTime = 1000 * 60 * 60L;

    // 密钥
    private static final String key = "Markmzy";

    /**
     * 生成token
     */
    public static String creatJWT(UserLoginVo userLoginVo)
    {
        // 判断用户信息
        if (userLoginVo == null || userLoginVo.getId() == null || userLoginVo.getUsername() == null)
            return null;

        return Jwts.builder()
                .claim("id", userLoginVo.getId())
                .claim("id", userLoginVo.getUsername())
                .claim("id", userLoginVo.getRoleName())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expireTime))
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();
    }

    /**
     * 验证token
     */

    public static Claims checkJWT(String token)
    {
        try
        {
            return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 获取用户id
     */

    public static Integer getUserId(String token)
    {
        Claims claims = JWTUtil.checkJWT(token);
        if (claims != null)
            return (Integer) claims.get("id");
        else
            return null;
    }

    /**
     * 获取用户姓名
     */

    public static String getUserName(String token)
    {
        Claims claims = JWTUtil.checkJWT(token);
        if (claims != null)
            return (String) claims.get("username");
        else
            return null;
    }

    /**
     * 获取用户类型
     */
    public static String getRoleName(String token)
    {
        Claims claims = JWTUtil.checkJWT(token);
        if (claims != null)
            return (String) claims.get("roleName");
        else
            return null;
    }

    /**
     * 验证token是否过期
     */
    public static boolean isTokenExpired(Date times)
    {
        return times.before(new Date());
    }


//    public static void main(String[] args)
//    {
//        UserLoginVo userVo = new UserLoginVo();
//        userVo.setId(14);
//        userVo.setUsername("saisai");
//        userVo.setRoleName("1");
//        String token = creatJWT(userVo);
//        System.out.println(token);
//    }
}
