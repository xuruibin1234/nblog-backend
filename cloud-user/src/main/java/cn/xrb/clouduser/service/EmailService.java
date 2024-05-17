package cn.xrb.clouduser.service;

import cn.xrb.clouduser.entity.Email;
import cn.xrb.clouduser.common.response.BaseActionResponse;
import cn.xrb.clouduser.entity.dto.SendEmailDto;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xrb
 * @since 2024-05-15
 */
public interface EmailService extends IService<Email> {
    BaseActionResponse<Email> addEmail(Email email);
    BaseActionResponse<Email> selectEmailById(Email email);
    void sendEmail(SendEmailDto sendEmailDto);


}
