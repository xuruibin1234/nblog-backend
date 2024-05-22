package cn.xrb.clouduser.common.exception;

import lombok.Data;


public class UserException extends BasicException{

    public UserException(int code, String message) {
        super(code, message);
    }
}
