package com.example.playground.notification.sms;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class ResponseDTO {
    public String code;
    public String message;
    public String sourceInfo;
    public String status;
    public Data data;
}
