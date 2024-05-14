package cn.xrb.clouduser.service;

import cn.xrb.clouduser.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xrb
 * @since 2024-05-14
 */
public interface UserService extends IService<User> {
    boolean registerUser(@RequestBody User user);
}
