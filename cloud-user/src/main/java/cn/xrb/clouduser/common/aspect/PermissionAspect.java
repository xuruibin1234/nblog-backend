package cn.xrb.clouduser.common.aspect;

import cn.xrb.clouduser.common.annotation.PermissionRequired;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PermissionAspect {
    @Before("@annotation(permissionRequired)")
    public void checkPermission(JoinPoint joinPoint, PermissionRequired permissionRequired) {
        // 获取当前用户的权限信息
        String userRole = getUserRole(); // 假设有一个方法可以获取当前用户的角色信息

        // 检查用户是否具有所需的权限
        if (!hasPermission(userRole, permissionRequired.value())) {
            throw new RuntimeException("无权限访问");
        }
    }

    private boolean hasPermission(String userRole, String requiredPermission) {
        // 根据用户角色和所需权限进行判断，返回是否具有权限
        // 这里可以根据实际需求进行逻辑判断，例如查询数据库或调用其他服务接口
        return true; // 假设用户具有所需的权限
    }

    private String getUserRole() {
        // 获取当前用户的角色信息，可以从请求头、会话或其他途径获取
        return "admin"; // 假设当前用户是管理员角色
    }
}