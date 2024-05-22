package cn.xrb.clouduser.controller;


import cn.xrb.clouduser.entity.TUserRole;
import cn.xrb.clouduser.service.T_user_roleService;
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
@RequestMapping("/t-user-role")
public class T_user_roleController {

    @Autowired
    private T_user_roleService tUserRoleService;

    @PostMapping("addRole")
    String addRole(@RequestBody TUserRole tUserRole){
        String addedRole = tUserRoleService.addRole(tUserRole);
        return addedRole;
    }

    @PostMapping("delRoleById")
    String delRoleById(@RequestBody TUserRole tUserRole){
        String delRoleById = tUserRoleService.delRoleById(tUserRole);
        return delRoleById;
    }

    @PostMapping("updateRoleById")
    String updateRoleById(@RequestBody TUserRole tUserRole){
        String updateRoleById = tUserRoleService.updateRoleById(tUserRole);
        return updateRoleById;
    }

    @PostMapping("findRoleById")
    TUserRole findRoleById(@RequestBody TUserRole tUserRole){
        TUserRole findRoleById = tUserRoleService.findRoleById(tUserRole);
        return findRoleById;
    }



}

