package cn.xrb.clouduser.common.handler;

import cn.xrb.clouduser.common.exception.UserException;
import cn.xrb.clouduser.common.response.FailActionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private FailActionResponse failActionResponse;

    @ExceptionHandler(UserException.class)
    @ResponseBody
    public FailActionResponse handleCustomException(UserException e) {
        failActionResponse.setCode(200);
        failActionResponse.setMessage("用户操作异常, 信息如下: "+e.getMessage());
        return failActionResponse;
    }
}
