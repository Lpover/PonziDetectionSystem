package cn.qkl.consumer.service.notify;

/**
 * @Author sunxiaen
 * @Date 2023/6/28 17:28
 **/

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;
@Slf4j
@Service
public class EmailService {

    //邮件服务器主机名，腾讯企业邮箱
    private static String myEmailSMTPHost = "smtp.163.com";

    //发件人邮箱，腾讯企业邮箱
    private static String myEmailAccount = "sunxiaen@163.com";

    //发件人邮箱密码（授权码）
    //在开启SMTP服务时会获取到一个授权码，把授权码填在这里
    private static String myEmailPassword = "ICQXRNYBUEWZJRED";

    /**
     * 邮件单发（自由编辑短信，并发送，适用于私信）
     *
     * @param toEmailAddress 收件箱地址
     * @param emailTitle 邮件主题
     * @param emailContent 邮件内容
     * @throws Exception
     */
    public void sendEmail(String toEmailAddress, String emailTitle, String emailContent) {
        try {
            Properties props = new Properties();

            // 发送服务器需要身份验证
            props.setProperty("mail.smtp.auth", "true");
            // 端口号
            props.put("mail.smtp.port", 465);
            // 设置邮件服务器主机名
            props.setProperty("mail.smtp.host", myEmailSMTPHost);
            // 发送邮件协议名称
            props.put("mail.smtp.socketFactory.port", 465);
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.ssl.enable", true);

            //创建会话
            Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(myEmailAccount,myEmailPassword);
                    }
            });

            //获取邮件对象
            //发送的消息，基于观察者模式进行设计的
            Message msg = new MimeMessage(session);
            //设置邮件标题
            msg.setSubject(emailTitle);
            //设置收件人邮箱
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(toEmailAddress));
            //设置显示的发件时间
            msg.setSentDate(new Date());
            //设置邮件内容
            msg.setText(emailContent);
            //设置发件人邮箱
            // InternetAddress 的三个参数分别为: 发件人邮箱, 显示的昵称(只用于显示, 没有特别的要求), 昵称的字符集编码
            msg.setFrom(new InternetAddress(myEmailAccount,"态势感知系统预警邮箱", "UTF-8"));
            Transport.send(msg);
        }catch (Exception e){
            e.printStackTrace();
        }


    }


}


