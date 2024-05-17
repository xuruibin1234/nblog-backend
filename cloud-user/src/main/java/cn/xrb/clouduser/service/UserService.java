package cn.xrb.clouduser.service;

import cn.xrb.clouduser.common.response.BaseActionResponse;
import cn.xrb.clouduser.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xrb
 * @since 2024-05-15
 */
public interface UserService extends IService<User> {
    BaseActionResponse<User> login(User user);
    BaseActionResponse<User> register(User user);
    BaseActionResponse<User> findUsernameByEmail(User user);
    BaseActionResponse<User> findPasswordByEmail(User user);
    ResponseEntity<BufferedImage> generateCaptcha(HttpServletResponse response) throws IOException;
    ResponseEntity<String> captchaSixNumber() throws IOException;

}
