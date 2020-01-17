package com.web.spring.study.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class Test {
    
    public static void main(String[] args) {
        
        ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/java/com/web/spring/study/beans/beans-config.xml");
        HelloBean helloBean = ctx.getBean(HelloBean.class);
        System.out.println(helloBean.getName());
        
        RoundBean roundBean = ctx.getBean(RoundBean.class);
        System.out.println(roundBean.getRundArea());
        
        Husband husband = ctx.getBean(Husband.class);
        System.out.println(husband.getName()+"娶了"+husband.getWife().getName());
        
    }
    
}
