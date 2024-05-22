package cn.xrb.clouduser.common.exception;

import com.alibaba.fastjson2.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;


public class CustomException extends BasicException{
    public CustomException(int code, String message) {
        super(code, message);
    }

    @Override
    public String toString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",code);
        jsonObject.put("message",message);
        return jsonObject.toString();
    }
}
