package cn.xrb.clouduser.mapper;

import cn.xrb.clouduser.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xrb
 * @since 2024-05-15
 */
public interface UserMapper extends BaseMapper<User> {
    User login(@Param("userInfo") User user);
    String findUsernameByEmai(@Param("userInfo") User user);
    String findPasswordByEmail(@Param("userInfo") User user);
}
