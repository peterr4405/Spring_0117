package com.web.spring.study.di3;

import com.web.spring.study.di2.Family;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/java/com/web/spring/study/di3/applicationConfig.xml");
        UserDao userDao = (UserDao) ctx.getBean("userDao");
        System.out.println(userDao);

        Login login = (Login) ctx.getBean("login");

        Scanner sc = new Scanner(System.in);
        System.out.println("請輸入帳號:");
        String user = sc.next();
        System.out.println("請輸入密碼:");
        String pass = sc.next();
        System.out.println("login:" + login.check(user, pass));

        System.out.println(userDao.get("admin"));
        userDao.updatePassword(user, "4578");
        System.out.println(userDao.get(user));
        System.out.println(userDao.getUsers());
        userDao.delUser(user);
        System.out.println(userDao.getUsers());
    }
}
