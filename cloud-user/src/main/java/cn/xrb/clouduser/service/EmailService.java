package cn.xrb.clouduser.service;

import cn.xrb.clouduser.entity.Email;
import cn.xrb.clouduser.entity.dto.SendEmailDto;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xrb
 * @since 2024-05-14
 */
public interface EmailService extends IService<Email> {
    boolean addEmail(Email email);
    boolean sendEmail(SendEmailDto sendEmailDto);
}
