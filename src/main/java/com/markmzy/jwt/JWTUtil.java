package com.markmzy.jwt;

import com.markmzy.model.vo.UserLoginVo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JWTUtil
{
    //设置密钥
    private static final String key = "Markmzy";
    //有效时间长度  60分钟
    private static final Long failTime = 1000 * 60 * 30L;

    /**
     * 生成token
     */
    public static String createJsonWebToken(UserLoginVo user)
    {
        //判断用户对象信息
        if (user == null || user.getId() == null || user.getUsername() == null)
        {
            return null;
        }

        //生成token对象

        return Jwts.builder()
                .claim("id", user.getId())
                .claim("username", user.getUsername())
                .claim("roleName", user.getRoleName())
                .setIssuedAt(new Date())//签发时间
                .setExpiration(new Date(System.currentTimeMillis() + failTime))
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();
    }

    /**
     * 验证token是否有效
     */
    public static Claims checkJwt(String token)
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
        Claims claims = JWTUtil.checkJwt(token);
        return (Integer) claims.get("id");
    }

    /**
     * 获取用户姓名
     */
    public static String getUserName(String token)
    {
        Claims claims = JWTUtil.checkJwt(token);
        return (String) claims.get("username");
    }

    /**
     * 获取用户姓名
     */
    public static String getRoleName(String token)
    {
        Claims claims = JWTUtil.checkJwt(token);
        return (String) claims.get("roleName");
    }

    /**
     * 判断token是否过期
     */
    public static boolean isTokenExpired(String token)
    {
        Claims claims = JWTUtil.checkJwt(token);
        Date times = claims.getExpiration();
        return times.before(new Date());
    }

}
