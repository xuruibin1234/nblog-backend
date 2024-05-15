package cn.xrb.clouduser.common.config;

import cn.xrb.clouduser.entity.Response.FailActionResponse;
import cn.xrb.clouduser.entity.Response.SuccessActionResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ResponseConfig {

    @Bean
    public SuccessActionResponse successActionResponse(){
        SuccessActionResponse<Object> successActionResponse = new SuccessActionResponse<>();
        successActionResponse.setCode(200);
        successActionResponse.setMessage("操作成功");
        return successActionResponse;
    }

    @Bean
    public FailActionResponse failActionResponse(){
        FailActionResponse<Object> failActionResponse = new FailActionResponse<>();
        failActionResponse.setCode(500);
        failActionResponse.setMessage("操作失败");
        return failActionResponse;
    }

}
