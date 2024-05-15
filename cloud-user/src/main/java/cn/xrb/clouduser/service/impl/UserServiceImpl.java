package cn.xrb.clouduser.service.impl;

import cn.xrb.clouduser.common.exception.UserException;
import cn.xrb.clouduser.entity.Email;
import cn.xrb.clouduser.entity.Response.BaseActionResponse;
import cn.xrb.clouduser.entity.Response.FailActionResponse;
import cn.xrb.clouduser.entity.Response.SuccessActionResponse;
import cn.xrb.clouduser.entity.User;
import cn.xrb.clouduser.mapper.UserMapper;
import cn.xrb.clouduser.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xrb
 * @since 2024-05-15
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SuccessActionResponse<User> successActionResponse;

    @Autowired
    private FailActionResponse<User> failActionResponse;

    @Override
    public BaseActionResponse<User> login(User user) {
        User logined = userMapper.login(user);
        if (logined!=null) {
            successActionResponse.setData(logined);
            return successActionResponse;
        } else {
            return failActionResponse;
        }
    }

    @Override
    public BaseActionResponse<User> register(User user) {
        int inserted = userMapper.insert(user);
        if (inserted > 0) {
            successActionResponse.setData(user);
            return successActionResponse;
        } else {
            return failActionResponse;
        }
    }

    @Override
    public BaseActionResponse<User> findUsernameByEmail(User user) {

        String username= userMapper.findUsernameByEmai(user);
        if (username!=null && !username.equals("") ) {
            user.setUsername(username);
            successActionResponse.setData(user);
            return successActionResponse;
        }
        else {
            return failActionResponse;
        }
    }

    @Override
    public BaseActionResponse<User> findPasswordByEmail(User user) {

        String username= userMapper.findUsernameByEmai(user);
        if (!username.equals("") && username!=null) {
            user.setUsername(username);
            successActionResponse.setData(user);
            return successActionResponse;
        }
        else {
            return failActionResponse;
        }
    }

    @Override
    public ResponseEntity<BufferedImage> generateCaptcha(HttpServletResponse response){
        try {
            int width = 160;
            int height = 40;
            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics = bufferedImage.createGraphics();
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, width, height);
            graphics.setFont(new Font("Arial", Font.BOLD, 20));
            Random random = new Random();
            String captcha = "";
            for (int i = 0; i < 4; i++) {
                int number = random.nextInt(10);
                captcha += number;
                graphics.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
                graphics.drawString(String.valueOf(number), 30 * i + 20, 25);
            }
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/png");
            ImageIO.write(bufferedImage, "png", response.getOutputStream());
            return new ResponseEntity<>(bufferedImage, HttpStatus.OK);
        } catch (IOException e) {
            throw new UserException(500,e.getMessage());
        }
    }

    @Override
    public ResponseEntity<String> captchaSixNumber() throws IOException {
        Random random = new Random();
        String captcha = "";
        for (int i = 0; i < 6; i++) {
            int number = random.nextInt(10);
            captcha += number;
        }
        return new ResponseEntity<>(captcha,HttpStatus.OK);
    }
}
