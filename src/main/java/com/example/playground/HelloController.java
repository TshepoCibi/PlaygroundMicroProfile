package com.example.playground;

import com.example.playground.notification.email.EmailNotificationDTO;
import com.example.playground.notification.sms.ResponseDTO;
import com.example.playground.notification.sms.SmsNotificationDTO;
import com.example.playground.service.NotificationService;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 *
 */
@Path("/hello")
@Singleton
public class HelloController {

    @Inject
    NotificationService notificationService;

    public HelloController() {
    }


    @POST
    @Path("/hi")
    public String sayHello(@RequestBody Req req) {
        System.out.println(req);
        System.out.println(req.getName());
        return "Hello World "+ req.getName();
    }

    @POST
    @Path("/sms")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseDTO sendSMS(@RequestBody SmsNotificationDTO request){
        System.out.println("in Controller =====================");
        return notificationService.sendSMS(request);
    }

    @POST
    @Path("/email")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseDTO sendEmail(@RequestBody EmailNotificationDTO request){
        System.out.println("in Controller =====================");
        return notificationService.sendEmail(request);
    }
}
