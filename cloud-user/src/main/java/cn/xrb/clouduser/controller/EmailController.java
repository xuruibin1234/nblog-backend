package cn.xrb.clouduser.controller;


import cn.xrb.clouduser.entity.Email;
import cn.xrb.clouduser.entity.dto.SendEmailDto;
import cn.xrb.clouduser.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xrb
 * @since 2024-05-14
 */
@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/addEmail")
    String addEmail(@RequestBody Email email) {
        boolean added = emailService.addEmail(email);
        if (added) {
            return  "邮箱插入成功";
        } else {
            return  "邮箱插入失败";
        }
    }

    @PostMapping("/sendEmail")
    String sendEmail(@RequestBody SendEmailDto sendEmailDto) {
        boolean sendEmail = emailService.sendEmail(sendEmailDto);
        if (sendEmail) {
            return  "邮件发送成功";
        } else {
            return  "邮件发送失败";
        }
    }

}

