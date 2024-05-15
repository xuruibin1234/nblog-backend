package cn.xrb.clouduser.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Data
public class SendEmailDto {

    private String from;
    private String to;
    private String subject;
    private String content;


}
