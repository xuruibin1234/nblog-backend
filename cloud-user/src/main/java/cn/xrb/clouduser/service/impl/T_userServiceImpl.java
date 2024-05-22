package cn.xrb.clouduser.service.impl;

import cn.xrb.clouduser.common.exception.CustomException;
import cn.xrb.clouduser.common.exception.UserException;
import cn.xrb.clouduser.entity.TUser;
import cn.xrb.clouduser.mapper.T_userMapper;
import cn.xrb.clouduser.mapper.T_user_roleMapper;
import cn.xrb.clouduser.service.T_userService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xrb
 * @since 2024-05-22
 */
@Service
public class T_userServiceImpl extends ServiceImpl<T_userMapper, TUser> implements T_userService {

    @Autowired
    private T_userMapper tUserMapper;

    @Override
    public String register(TUser tUser) {
        try {
            LocalDateTime now = LocalDateTime.now();
            tUser.setCreatedAt(now);
//          查询最后一条的id
            Integer lastUserId = tUserMapper.findLastUserId();
            if (lastUserId == null) {
                lastUserId = 1;
            } else {
                lastUserId++;
            }
            tUser.setId(lastUserId);
            tUserMapper.register(tUser);
            return "用户注册成功";
        } catch (Exception e) {
            Integer findUserByUsername = tUserMapper.findUserByUsername(tUser);
            if (findUserByUsername!=null) {
                return "用户名已存在,清重新输入";
            }
            Integer findUserByEmail = tUserMapper.findUserByEmail(tUser);
            if (findUserByEmail!=null) {
                return "邮箱已存在,清重新输入";
            }
            Integer findUserByPhone = tUserMapper.findUserByPhone(tUser);
            if (findUserByPhone!=null) {
                return "手机号码已存在,清重新输入";
            }
        }
            return "用户注册失败";
    }
}
