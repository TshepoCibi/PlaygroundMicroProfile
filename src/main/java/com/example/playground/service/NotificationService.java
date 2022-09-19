package com.example.playground.service;

import com.example.playground.blog.NotificationClient;
import com.example.playground.notification.email.EmailNotificationDTO;
import com.example.playground.notification.sms.ResponseDTO;
import com.example.playground.notification.sms.SmsNotificationDTO;
import com.example.playground.utils.Connection;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.net.URISyntaxException;
@ApplicationScoped
public class NotificationService {

    private NotificationClient notificationClient;

    Connection connection = new Connection();
        {
            try {
                notificationClient = connection.globalConnetion();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }

    public ResponseDTO sendEmail(EmailNotificationDTO request){
        System.out.println("in Service =====================");
        ResponseDTO responseDTO = notificationClient.email(request);
        responseDTO.setMessage(responseDTO.getMessage() + " Approved by business service");
        System.out.println(responseDTO.getStatus());
        return responseDTO;
    }

    public ResponseDTO sendSMS(SmsNotificationDTO request){
        System.out.println("in Service =====================");
        ResponseDTO responseDTO = notificationClient.sms(request);
        responseDTO.setMessage(responseDTO.getMessage() + " Approved by business service");
        System.out.println(responseDTO.getStatus());
        return responseDTO;
    }
}
