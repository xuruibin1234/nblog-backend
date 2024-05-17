package cn.xrb.clouduser.common.response;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class SuccessActionResponse<T> extends BaseActionResponse {
    private int code = 200;
    private String message = "操作成功";
    private T data;
}
