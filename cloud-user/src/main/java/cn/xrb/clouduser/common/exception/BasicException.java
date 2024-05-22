package cn.xrb.clouduser.common.exception;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class BasicException extends RuntimeException{
     int code;
     String message;
}
