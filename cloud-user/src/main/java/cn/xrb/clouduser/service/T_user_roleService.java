package cn.xrb.clouduser.service;

import cn.xrb.clouduser.entity.TUserRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xrb
 * @since 2024-05-22
 */
public interface T_user_roleService extends IService<TUserRole> {
    String addRole(TUserRole tUserRole);
    String delRoleById(TUserRole tUserRole);
    String updateRoleById(TUserRole tUserRole);
    TUserRole findRoleById(TUserRole tUserRole);
}
