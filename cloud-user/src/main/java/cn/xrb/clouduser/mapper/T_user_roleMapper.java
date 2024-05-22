package cn.xrb.clouduser.mapper;

import cn.xrb.clouduser.entity.TUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xrb
 * @since 2024-05-22
 */
public interface T_user_roleMapper extends BaseMapper<TUserRole> {
    int addRole(@Param("userRole") TUserRole tUserRole);
    int delRoleById(@Param("userRole") TUserRole tUserRole);
    int updateRoleById(@Param("userRole") TUserRole tUserRole);
    TUserRole findRoleById(@Param("userRole") TUserRole tUserRole);
    Integer findRoleLastId();
}
