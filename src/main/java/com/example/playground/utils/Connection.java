package com.example.playground.utils;

import com.example.playground.blog.NotificationClient;
//import com.example.playground.blog.SmsClient;
import com.example.playground.blog.ResponseLoggingFilter;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.rest.client.RestClientBuilder;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;
@ApplicationScoped
public class Connection {

    Config config = ConfigProvider.getConfig();
//    public SmsClient connect(String baseURL) throws URISyntaxException {
//
//        SmsClient jsonApiClient = RestClientBuilder.newBuilder()
//                .baseUri(new URI(baseURL))
//                .register(ResponseLoggingFilter.class)
//                .sslContext(ssl())
//                .connectTimeout(2, TimeUnit.SECONDS)
//                .readTimeout(2, TimeUnit.SECONDS)
//                .build(SmsClient.class);
//
//        return jsonApiClient;
//    }
//
//    public NotificationClient connectEmail(String baseURL) throws URISyntaxException {
//
//        NotificationClient jsonApiClient = RestClientBuilder.newBuilder()
//                .baseUri(new URI(baseURL))
//                .register(ResponseLoggingFilter.class)
//                .sslContext(ssl())
//                .connectTimeout(60, TimeUnit.SECONDS)
//                .readTimeout(60, TimeUnit.SECONDS)
//                .build(NotificationClient.class);
//
//        return jsonApiClient;
//    }

//    public void init(@Observes @Initialized(ApplicationScoped.class) Object init) throws URISyntaxException {
//        System.out.println("in connection ======");
//        NotificationClient jsonApiClient = RestClientBuilder.newBuilder()
//                .baseUri(new URI( config.getValues("notification.url.value", String.class).get(0)))
//                .register(ResponseLoggingFilter.class)
//                .sslContext(ssl())
//                .connectTimeout(60, TimeUnit.SECONDS)
//                .readTimeout(60, TimeUnit.SECONDS)
//                .build(NotificationClient.class);
//        notificationClient = jsonApiClient;
////        return jsonApiClient;
//    }
    public NotificationClient globalConnetion() throws URISyntaxException {
        System.out.println("in connection ======");
        NotificationClient jsonApiClient = RestClientBuilder.newBuilder()
                .baseUri(new URI( config.getValues("notification.url.value", String.class).get(0)))
                .register(ResponseLoggingFilter.class)
                .sslContext(ssl())
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build(NotificationClient.class);

        return jsonApiClient;
    }

    private SSLContext ssl(){
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
