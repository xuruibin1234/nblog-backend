package cn.xrb.clouduser.exception;

import lombok.Data;

@Data
public class EmailException extends RuntimeException{
    private int code;
    private String message;

    public EmailException(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
