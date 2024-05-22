package cn.xrb.clouduser.controller;


import cn.xrb.clouduser.entity.TUser;
import cn.xrb.clouduser.service.T_userService;
import org.apache.ibatis.annotations.Param;
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
 * @since 2024-05-22
 */
@RestController
@RequestMapping("/t-user")
public class T_userController {

    @Autowired
    private T_userService tUserService;

    @PostMapping("/register")
    public String register(@RequestBody TUser tUser){
        String result = tUserService.register(tUser);
        return result;
    }

}

