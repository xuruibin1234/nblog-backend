package cn.xrb.clouduser.service.impl;

import cn.xrb.clouduser.entity.Email;
import cn.xrb.clouduser.entity.Response.BaseActionResponse;
import cn.xrb.clouduser.entity.Response.FailActionResponse;
import cn.xrb.clouduser.entity.Response.SuccessActionResponse;
import cn.xrb.clouduser.entity.dto.SendEmailDto;
import cn.xrb.clouduser.mapper.EmailMapper;
import cn.xrb.clouduser.service.EmailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xrb
 * @since 2024-05-15
 */
@Service
public class EmailServiceImpl extends ServiceImpl<EmailMapper, Email> implements EmailService {

    @Autowired
    private EmailMapper emailMapper;

    @Autowired
    private SuccessActionResponse successActionResponse;

    @Autowired
    private FailActionResponse failActionResponse;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public BaseActionResponse<Email> addEmail(Email email) {
        int inserted = emailMapper.insert(email);
        if (inserted>0) {
            return successActionResponse;
        } else {
            return failActionResponse;
        }
    }

    @Override
    public BaseActionResponse<Email> selectEmailById(Email email) {
        Integer emailId = email.getId();
        Email selectById = emailMapper.selectById(emailId);
        if (selectById!=null) {
            successActionResponse.setData(selectById);
            return successActionResponse;
        } else {
            return failActionResponse;
        }
    }

    @Override
    public void sendEmail(SendEmailDto sendEmailDto) {
        String to = sendEmailDto.getTo();
        String subject = sendEmailDto.getSubject();
        String text = sendEmailDto.getContent();
        String from = sendEmailDto.getFrom();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }


}
