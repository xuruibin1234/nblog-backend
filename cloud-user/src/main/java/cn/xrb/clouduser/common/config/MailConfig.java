package cn.xrb.clouduser.common.config;

import cn.xrb.clouduser.entity.Email;
import cn.xrb.clouduser.mapper.EmailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {

//    private EmailMapper emailMapper;
    @Autowired
    private EmailMapper emailMapper;

    @Bean
    JavaMailSender javaMailSender(){
        Email selectById = emailMapper.selectById(1);
        String host = selectById.getHost();
        String port = selectById.getPort();
        String username = selectById.getUsername();
        String password = selectById.getPassword();
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(host);
        mailSender.setPort(Integer.parseInt(port));
//         如果需要身份验证，取消下面两行的注释并设置正确的用户名和密码
         mailSender.setUsername(username);
         mailSender.setPassword(password);
        return mailSender;
    }



}
