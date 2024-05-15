package cn.xrb.clouduser.common.handler;

import cn.xrb.clouduser.entity.Response.BaseActionResponse;
import cn.xrb.clouduser.common.exception.UserException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserException.class)
    @ResponseBody
    public BaseActionResponse handleCustomException(UserException e) {
        BaseActionResponse baseEmailResponse = new BaseActionResponse();
        baseEmailResponse.setCode(500);
        baseEmailResponse.setMessage(e.getMessage());
        return baseEmailResponse;
    }
}
