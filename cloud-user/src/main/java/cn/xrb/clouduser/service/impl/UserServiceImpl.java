package cn.xrb.clouduser.service.impl;

import cn.xrb.clouduser.entity.User;
import cn.xrb.clouduser.exception.UserException;
import cn.xrb.clouduser.mapper.UserMapper;
import cn.xrb.clouduser.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xrb
 * @since 2024-05-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean registerUser(User user) {
        try {
            Date updatedAt = new Date(0);
            user.setUpdatedAt(updatedAt);
            int rows = userMapper.insert(user);
            if (rows > 0) {
                return  true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new UserException(500,"数据库记录重复");
        }
    }
}
