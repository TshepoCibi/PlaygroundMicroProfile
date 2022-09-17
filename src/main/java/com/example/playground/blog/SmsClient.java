package com.example.playground.blog;

import com.example.playground.notification.sms.ResponseDTO;
import com.example.playground.notification.sms.SmsNotificationDTO;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RegisterProvider(ResponseLoggingFilter.class)
@RegisterClientHeaders(SmsClientHeaders.class)
public interface SmsClient {

  @POST
  @Path("")
  ResponseDTO sms(@RequestBody SmsNotificationDTO clientPost);

}
