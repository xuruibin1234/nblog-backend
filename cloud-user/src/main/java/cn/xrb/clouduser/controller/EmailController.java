package cn.xrb.clouduser.controller;


import cn.xrb.clouduser.entity.Email;
import cn.xrb.clouduser.entity.Response.BaseActionResponse;
import cn.xrb.clouduser.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xrb
 * @since 2024-05-15
 */
@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("addEmail")
    BaseActionResponse<Email> addEmail(@RequestBody Email email){
        return emailService.addEmail(email);
    }
    @PostMapping("selectEmailById")
    BaseActionResponse<Email> selectEmailById(@RequestBody Email email){
        return emailService.selectEmailById(email);
    }
}

