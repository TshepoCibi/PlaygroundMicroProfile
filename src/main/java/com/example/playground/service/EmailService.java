package com.example.playground.service;

import com.example.playground.blog.EmailClient;
import com.example.playground.blog.SmsClient;
import com.example.playground.notification.email.EmailNotificationDTO;
import com.example.playground.notification.sms.ResponseDTO;
import com.example.playground.notification.sms.SmsNotificationDTO;
import com.example.playground.utils.Connection;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import java.net.URISyntaxException;

public class EmailService {

    @Inject
    @ConfigProperty(name = "sms.url.value")
    private String emailURL;

    private EmailClient emailClient;
    Connection connection = new Connection();
        {
            try {
                emailClient = connection.connectEmail("https://correspondence-domain-cit-ke.amol-api.roanprd-openshift.intra.absa.co.za/v1/correspondence/correspondence-operating-session/outbound/multiplenotification/initiation");
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }

    public ResponseDTO sendEmail(EmailNotificationDTO request){
        System.out.println("in Service =====================");
        ResponseDTO responseDTO = emailClient.email(request);
        responseDTO.setMessage(responseDTO.getMessage() + " Approved by business service");
        System.out.println(responseDTO.getStatus());
        return responseDTO;
    }
}
