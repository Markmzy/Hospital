package com.markmzy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.markmzy.dao")
public class HospitalApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(HospitalApplication.class, args);
        System.out.println("后台启动成功:)");
    }

}
