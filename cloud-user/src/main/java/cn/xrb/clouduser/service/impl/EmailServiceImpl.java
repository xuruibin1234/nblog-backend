package cn.xrb.clouduser.service.impl;

import cn.xrb.clouduser.entity.Email;
import cn.xrb.clouduser.entity.User;
import cn.xrb.clouduser.entity.dto.SendEmailDto;
import cn.xrb.clouduser.exception.UserException;
import cn.xrb.clouduser.mapper.EmailMapper;
import cn.xrb.clouduser.service.EmailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xrb
 * @since 2024-05-14
 */
@Service
public class EmailServiceImpl extends ServiceImpl<EmailMapper, Email> implements EmailService {

    @Autowired
    private EmailMapper emailMapper;

    @Transactional(rollbackFor = UserException.class)
    @Override
    public boolean sendEmail(SendEmailDto sendEmailDto) {
        // 配置邮件服务器信息
        Properties properties = new Properties();
        Email email = emailMapper.findEmailById(1);
        String host = email.getHost();
        String port = email.getPort();
        String auth = email.getAuth();
        String username = email.getUsername();
        String password = email.getPassword();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", auth);

        // 创建认证对象
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        };

        // 获取邮件会话对象
        Session session = Session.getInstance(properties, authenticator);

        try {
            // 创建邮件对象
            MimeMessage message = new MimeMessage(session);
            String to = sendEmailDto.getTo();
            String subject = sendEmailDto.getSubject();
            String content = sendEmailDto.getContent();
            message.setFrom(new InternetAddress(username));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setContent(content, "text/html;charset=UTF-8");

            // 发送邮件
            Transport.send(message);
        } catch (MessagingException e) {
            throw new UserException(500,e.getMessage());
        }
        return true;
    }

    @Transactional(rollbackFor = UserException.class)
    @Override
    public boolean addEmail(Email email) {
        try {
            int inserted = emailMapper.insert(email);
            if (inserted > 0) {
                return true;
            }
            else {
                return false;
            }
        }
        catch (Exception e) {
            throw new UserException(500,e.getMessage());
        }
    }
}
