package com.web.spring.study.beans2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Test {
    
    public static void main(String[] args) {
        
        ApplicationContext ctx  = new AnnotationConfigApplicationContext(BeanConfig.class);
        HelloBean helloBean = (HelloBean)ctx.getBean("helloBean");
        System.out.println(helloBean.getName());
        
        
        Husband husband = ctx.getBean(Husband.class);
        System.out.println(husband.getName()+"娶了"+husband.getWife().getName());
    }
    
}
