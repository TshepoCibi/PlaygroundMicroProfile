package com.example.playground.notification.sms;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class Data implements Serializable {
    private String responseCode;
    private String responseDesc;

}
