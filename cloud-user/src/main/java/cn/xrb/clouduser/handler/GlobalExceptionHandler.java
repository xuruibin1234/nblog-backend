package cn.xrb.clouduser.handler;

import cn.xrb.clouduser.exception.UserException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserException.class)
    @ResponseBody
    public String handleCustomException(UserException e) {
        return "错误码：" + e.getCode() + "，错误信息：" + e.getMessage();
    }

}
