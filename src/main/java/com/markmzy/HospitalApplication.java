package com.markmzy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HospitalApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(HospitalApplication.class, args);
        System.out.println("后台启动成功:)");
    }

}
