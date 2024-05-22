package cn.xrb.clouduser.service.impl;

import cn.xrb.clouduser.common.exception.CustomException;
import cn.xrb.clouduser.entity.TUserRole;
import cn.xrb.clouduser.mapper.T_user_roleMapper;
import cn.xrb.clouduser.service.T_user_roleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xrb
 * @since 2024-05-22
 */
@Service
public class T_user_roleServiceImpl extends ServiceImpl<T_user_roleMapper, TUserRole> implements T_user_roleService {

    @Autowired
    private T_user_roleMapper tUserRoleMapper;

    @Override
    public String addRole(TUserRole tUserRole) {
        try {
            Integer lastId = tUserRoleMapper.findRoleLastId();
            if (lastId != null) {
                lastId++;
            } else {
                lastId = 1;
            }
            tUserRole.setId(lastId);
            int addedRole = tUserRoleMapper.addRole(tUserRole);
            if (addedRole > 0) {
                return "权限添加成功";
            } else {
                return "权限添加失败";
            }
        } catch (Exception e) {
            CustomException customException = new CustomException(200, e.getMessage());
            return   customException.toString();
        }
    }

    @Override
    public String delRoleById(TUserRole tUserRole) {
        try {
            int delRoleById = tUserRoleMapper.delRoleById(tUserRole);
            if (delRoleById > 0) {
                return "权限删除成功";
            } else {
                return "权限删除失败";
            }
        } catch (Exception e) {
            throw new CustomException(200,e.getMessage());
        }

    }

    @Override
    public String updateRoleById(TUserRole tUserRole) {
        try {
            int updateRoleById = tUserRoleMapper.updateRoleById(tUserRole);
            if (updateRoleById > 0) {
                return "权限更新成功";
            } else {
                return "权限更新失败";
            }
        } catch (Exception e) {
            throw new CustomException(200,e.getMessage());
        }

    }

    @Override
    public TUserRole findRoleById(TUserRole tUserRole) {
        try {
            TUserRole findRoleById = tUserRoleMapper.findRoleById(tUserRole);
            if (findRoleById != null) {
                return findRoleById;
            } else {
                throw new CustomException(200,"权限查询失败");
            }
        } catch (Exception e) {
            throw new CustomException(200,e.getMessage());
        }
    }
}
