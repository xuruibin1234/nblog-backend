package cn.xrb.clouduser.mapper;

import cn.xrb.clouduser.entity.Email;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xrb
 * @since 2024-05-14
 */
public interface EmailMapper extends BaseMapper<Email> {
    Email findEmailById(Integer id);
}
