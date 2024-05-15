package cn.xrb.clouduser.entity.Response;

import lombok.Data;

@Data
public class BaseActionResponse<T> {
    private int code;
    private String message;
    private T data;
}
