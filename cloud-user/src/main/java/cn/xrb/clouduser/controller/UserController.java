package cn.xrb.clouduser.controller;


import cn.xrb.clouduser.entity.User;
import cn.xrb.clouduser.service.UserService;
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
 * @since 2024-05-14
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "registerUser")
    String registerUser(@RequestBody User user) {
        String result = new String();
        boolean registerUser = userService.registerUser(user);
        if (registerUser) {
            result = "注册成功";
        } else {
            result = "注册失败";
        }
        return  result;
    }
}

