package cn.xrb.clouduser.service;

import cn.xrb.clouduser.entity.TUser;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xrb
 * @since 2024-05-22
 */
public interface T_userService extends IService<TUser> {
    public String register(@RequestBody TUser tUser);
}
