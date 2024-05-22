package cn.xrb.clouduser.mapper;

import cn.xrb.clouduser.entity.TUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xrb
 * @since 2024-05-22
 */
public interface T_userMapper extends BaseMapper<TUser> {
    void register(@Param("userinfo") TUser tUser);
    Integer findUserByUsername(@Param("userinfo") TUser tUser);
    Integer findUserByEmail(@Param("userinfo") TUser tUser);
    Integer findUserByPhone(@Param("userinfo") TUser tUser);
    Integer findLastUserId();
}
