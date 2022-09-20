package com.example.playground;

import com.example.playground.notification.email.EmailNotificationDTO;
import com.example.playground.notification.sms.ResponseDTO;
import com.example.playground.notification.sms.SmsNotificationDTO;
import com.example.playground.service.NotificationService;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
    public Response sendSMS(@RequestBody @Valid SmsNotificationDTO request){
    if(request.equals(null)){
        return Response.serverError().status(Response.Status.BAD_REQUEST).build();
    }
        System.out.println("in Controller =====================");
    ResponseDTO res =notificationService.sendSMS(request);
        System.out.println("Res ===========> ");
        System.out.println(Response.ok().entity(res).build());
        System.out.println(Response.ok(res).build().getMetadata());
        System.out.println(Response.ok(res).build().getEntity());
        return Response.ok(res).build();
    }

    @POST
    @Path("/email")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response sendEmail(@RequestBody EmailNotificationDTO request){
        System.out.println("in Controller =====================");
        return Response.ok(notificationService.sendEmail(request)).build();
    }
}
