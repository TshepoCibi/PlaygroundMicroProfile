package com.example.playground.utils;

import com.example.playground.blog.EmailClient;
import com.example.playground.blog.SmsClient;
import com.example.playground.blog.ResponseLoggingFilter;
import org.eclipse.microprofile.rest.client.RestClientBuilder;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

public class Connection {

    public SmsClient connect(String baseURL) throws URISyntaxException {

        SmsClient jsonApiClient = RestClientBuilder.newBuilder()
                .baseUri(new URI(baseURL))
                .register(ResponseLoggingFilter.class)
                .sslContext(ssl())
                .connectTimeout(2, TimeUnit.SECONDS)
                .readTimeout(2, TimeUnit.SECONDS)
                .build(SmsClient.class);

        return jsonApiClient;
    }

    public EmailClient connectEmail(String baseURL) throws URISyntaxException {

        EmailClient jsonApiClient = RestClientBuilder.newBuilder()
                .baseUri(new URI(baseURL))
                .register(ResponseLoggingFilter.class)
                .sslContext(ssl())
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build(EmailClient.class);

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
