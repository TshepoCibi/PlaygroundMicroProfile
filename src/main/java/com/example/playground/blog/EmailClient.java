package com.example.playground.blog;

import com.example.playground.notification.email.EmailNotificationDTO;
import com.example.playground.notification.sms.ResponseDTO;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RegisterProvider(ResponseLoggingFilter.class)
@RegisterClientHeaders(EmailClientHeaders.class)
public interface EmailClient {


  @POST
  @Path("")
  ResponseDTO email(@RequestBody EmailNotificationDTO emailNotificationDTO);

}
