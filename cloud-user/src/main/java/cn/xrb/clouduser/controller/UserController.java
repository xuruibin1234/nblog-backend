package cn.xrb.clouduser.controller;


import cn.xrb.clouduser.common.response.SuccessActionResponse;
import cn.xrb.clouduser.common.exception.UserException;
import cn.xrb.clouduser.common.response.BaseActionResponse;
import cn.xrb.clouduser.entity.User;
import cn.xrb.clouduser.entity.dto.SendEmailDto;
import cn.xrb.clouduser.service.EmailService;
import cn.xrb.clouduser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xrb
 * @since 2024-05-15
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @PostMapping("login")
    BaseActionResponse<User> login(@RequestBody User user) {
        return userService.login(user);
    }

    @PostMapping("register")
    BaseActionResponse<User> register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("findUsernameByEmail")
    BaseActionResponse<User> findUsernameByEmail(@RequestBody User user) {
        BaseActionResponse findUsernameByEmail = userService.findUsernameByEmail(user);
        if (findUsernameByEmail instanceof SuccessActionResponse) {
            SuccessActionResponse successActionResponse = (SuccessActionResponse) findUsernameByEmail;
            User data = (User) successActionResponse.getData();
            String username = data.getUsername();
            String email = user.getEmail();
            SendEmailDto sendEmailDto = new SendEmailDto("17815708315@163.com",email, "nblog登录用户名找回", "您好，邮箱用户: " + email + ", 您的用户名是: " + username);
            emailService.sendEmail(sendEmailDto);
            return findUsernameByEmail;
        }
        else {
            return findUsernameByEmail;
        }
    }

    @PostMapping("findPasswordByEmail")
    BaseActionResponse<User> findPasswordByEmail(@RequestBody User user) {
        try {
            BaseActionResponse findUsernameByEmail = userService.findUsernameByEmail(user);
            if (findUsernameByEmail instanceof SuccessActionResponse) {
                SuccessActionResponse successActionResponse = (SuccessActionResponse) findUsernameByEmail;
                // 生成验证码
                ResponseEntity<String> responseEntity = userService.captchaSixNumber();
                String body = responseEntity.getBody();
                User data = (User) successActionResponse.getData();
                String username = data.getUsername();
                String email = user.getEmail();
                SendEmailDto sendEmailDto = new SendEmailDto("17815708315@163.com",email, "nblog找回密码邮箱验证", "您好，您正在找回登录用户名为 "+ username+"的NBlog账号的密码" +
                        "\n您的验证码为: "+body+"\n如果不是本人操作，请忽略。\n \n nblog - 博客");
                emailService.sendEmail(sendEmailDto);
            }
            return findUsernameByEmail;
        } catch (IOException e) {
            throw new UserException(500,e.getMessage());
        }
    }

//  生成图形验证码
    @PostMapping("captcha")
    public ResponseEntity<BufferedImage> generateCaptcha(HttpServletResponse response) throws IOException {
        return userService.generateCaptcha(response);
}
//  生成六位数字验证码
    @PostMapping("captchaSixNumber")
    public ResponseEntity<String> captchaSixNumber(HttpServletResponse response) throws IOException {
        ResponseEntity<String> responseEntity = userService.captchaSixNumber();
        return responseEntity;
    }
}

