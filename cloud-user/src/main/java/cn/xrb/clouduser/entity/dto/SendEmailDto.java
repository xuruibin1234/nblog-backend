package cn.xrb.clouduser.entity.dto;

import lombok.Data;

@Data
public class SendEmailDto {

    String to;
    String subject;
    String content;

}
