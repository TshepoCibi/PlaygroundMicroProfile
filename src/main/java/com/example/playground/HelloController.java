package com.example.playground;

import com.example.playground.blog.JSONPlaceholderClient;
import com.example.playground.blog.ResponseLoggingFilter;
import com.example.playground.notification.sms.ResponseDTO;
import com.example.playground.notification.sms.SmsNotificationDTO;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.RestClientBuilder;
import javax.inject.Singleton;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

/**
 *
 */
@Path("/hello")
@Singleton
public class HelloController {

    JSONPlaceholderClient jsonApiClient = RestClientBuilder.newBuilder()
            .baseUri(new URI("https://correspondence-domain-cit-ke.amol-api.roanprd-openshift.intra.absa.co.za/v1/correspondence/correspondence-operating-session/outbound/multiplenotification/initiation"))
            .register(ResponseLoggingFilter.class)
            .sslContext(ssl())
            .connectTimeout(2, TimeUnit.SECONDS)
            .readTimeout(2, TimeUnit.SECONDS)
            .build(JSONPlaceholderClient.class);

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
    public ResponseDTO getClientProducts(@RequestBody SmsNotificationDTO request){
        System.out.println("response =====================");
        ResponseDTO responseDTO = jsonApiClient.sms(request);
        System.out.println(responseDTO.getStatus());
        System.out.println("Done =====================");
        return responseDTO;
    }

    public SSLContext ssl(){
        SSLContext sslContext = null;
        try {
            sslContext = SSLContext.getInstance("SSL");
            TrustManager tm = new X509TrustManager() {
                @Override
                public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                }
                @Override
                public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                }
                @Override
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return new java.security.cert.X509Certificate[]{};
                }
            };
            sslContext.init(null, new TrustManager[] {
                    tm
            }, null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sslContext;
    }
}
