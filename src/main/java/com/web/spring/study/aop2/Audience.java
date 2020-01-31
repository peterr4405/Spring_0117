package com.web.spring.study.aop2;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Audience {

    @Before(value = "execution(* com.web.spring.study.aop2.Actor.show(..))")
    public void before() throws Throwable{
        System.out.println("找位置");
    }

    @After(value = "execution(* com.web.spring.study.aop2.Actor.show(..))")
    public void after() throws Throwable{
        System.out.println("鼓掌");
    }
}
