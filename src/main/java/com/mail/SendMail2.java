package com.mail;

import java.io.File;
import java.util.Properties;
import java.util.Scanner;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail2 {

    public static void main(String[] args) throws Exception {
        
        File file1 = new File("src\\main\\java\\com\\mail\\content.html");
        String content = new Scanner(file1, "UTF-8").useDelimiter("\\A").next();
        content = String.format(content, "親愛的");
        File file2 = new File("src\\main\\java\\com\\mail\\to.properties");
        String to = new Scanner(file2, "UTF-8").useDelimiter("\\A").next();
        
        final String username = "xxx@gmail.com";
        final String password = "xxxx"; // 授權碼, 不是 email 的密碼
        
        System.out.println(content);
        System.out.println(to);
        // 發信...
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        // 會話建立與 smtp 溝通
        Session session;
        session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        Message message = new MimeMessage(session);

        // 發文者 一定會是你的 username
        InternetAddress ia = new InternetAddress("from@gmail.com");
        ia.setPersonal("HaHaHa");
        message.setFrom(ia);

        // 受文者
        message.setRecipients(
                Message.RecipientType.TO,
                InternetAddress.parse(to)
        );

        // Email 抬頭
        message.setSubject("測試信件");

        // Email 內容純文字
        //message.setText("Dear ,\n\n Please do not spam my email!");
        // Email 內容 HTML
        message.setContent(content, "text/html;charset=utf-8");

        // 發送 email
        Transport.send(message);

        System.out.println("信件發送成功 !");

    }

}
