package cn.xrb.clouduser.common.response;

import lombok.Data;

@Data
public abstract class BaseActionResponse<T> {
    private int code;
    private String message;
}
