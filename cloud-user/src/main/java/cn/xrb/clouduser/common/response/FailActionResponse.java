package cn.xrb.clouduser.common.response;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class FailActionResponse<T> extends BaseActionResponse {
    private int code = 200;
    private String message = "操作失败";
}
