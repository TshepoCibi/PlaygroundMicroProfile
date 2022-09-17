package com.example.playground;

import com.example.playground.notification.email.EmailNotificationDTO;
import com.example.playground.notification.sms.ResponseDTO;
import com.example.playground.notification.sms.SmsNotificationDTO;
import com.example.playground.service.EmailService;
import com.example.playground.service.SmsService;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.net.URISyntaxException;

/**
 *
 */
@Path("/hello")
@Singleton
public class HelloController {

//    JSONPlaceholderClient jsonApiClient = RestClientBuilder.newBuilder()
//            .baseUri(new URI("https://correspondence-domain-cit-ke.amol-api.roanprd-openshift.intra.absa.co.za/v1/correspondence/correspondence-operating-session/outbound/multiplenotification/initiation"))
//            .register(ResponseLoggingFilter.class)
//            .sslContext(ssl())
//            .connectTimeout(2, TimeUnit.SECONDS)
//            .readTimeout(2, TimeUnit.SECONDS)
//            .build(JSONPlaceholderClient.class);

    @Inject
    SmsService smsService;

    @Inject
    EmailService emailService;

    public HelloController() throws URISyntaxException {
    }

//    public void restClientBuilder() throws URISyntaxException {
//        System.out.println("------ Rest Client builder example ------");
//         jsonApiClient = RestClientBuilder.newBuilder()
//                .baseUri(new URI("https://correspondence-domain-cit-ke.amol-api.roanprd-openshift.intra.absa.co.za/v1/correspondence/correspondence-operating-session/outbound/multiplenotification/initiation"))
//                .register(ResponseLoggingFilter.class)
//                .sslContext(ssl())
//                .connectTimeout(2, TimeUnit.SECONDS)
//                .readTimeout(2, TimeUnit.SECONDS)
//                .build(JSONPlaceholderClient.class);
//    }

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
        return smsService.sendSMS(request);
    }

    @POST
    @Path("/email")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseDTO sendEmail(@RequestBody EmailNotificationDTO request){
        System.out.println("in Controller =====================");
        return emailService.sendEmail(request);
    }

//    public SSLContext ssl(){
//        SSLContext sslContext = null;
//        try {
//            sslContext = SSLContext.getInstance("SSL");
//            TrustManager tm = new X509TrustManager() {
//                @Override
//                public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) {
//                }
//                @Override
//                public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) {
//                }
//                @Override
//                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
//                    return new java.security.cert.X509Certificate[]{};
//                }
//            };
//            sslContext.init(null, new TrustManager[] {
//                    tm
//            }, null);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return sslContext;
//    }
}
