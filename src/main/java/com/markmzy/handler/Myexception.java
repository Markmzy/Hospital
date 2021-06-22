package com.markmzy.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.HandlerMethod;

public class Myexception
{
    @ExceptionHandler(value = Exception.class)
    public String exceptionHandler(Exception e, HandlerMethod method)
    {
        System.out.println(e);
        System.out.println(method.getMethod().getName());
        return e.getMessage();
    }
}
