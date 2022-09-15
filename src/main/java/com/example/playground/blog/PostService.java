package com.example.playground.blog;

import com.example.playground.utils.Constants;
import com.example.playground.utils.PropertyProvider;
import org.eclipse.microprofile.rest.client.RestClientBuilder;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.net.ssl.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class PostService {

  @Inject
  JSONPlaceholderClient jsonPlaceholderClient;

  private Map<String, String> headers;
  private PropertyProvider propertyProvider;
//  JSONPlaceholderClient jsonApiClient;

  public PostService(PropertyProvider propertyProvider) {
    this.propertyProvider = propertyProvider;
  }
  public PostService() {
  }
  public void init(@Observes @Initialized(ApplicationScoped.class) Object init) throws URISyntaxException {
//    restClientBuilder();
//    getClientProducts();
//    getClientProducts();
//     getAllPosts();
    // getSinglePost();
    // createNewPost();
    // updateExistingPost();
    // deletePost();
  }

  public JSONPlaceholderClient restClientBuilder() throws URISyntaxException {
    System.out.println("------ Rest Client builder example ------");

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

    JSONPlaceholderClient jsonApiClient = RestClientBuilder.newBuilder()
      .baseUri(new URI("https://correspondence-domain-cit-ke.amol-api.roanprd-openshift.intra.absa.co.za/v1/correspondence/correspondence-operating-session/outbound/multiplenotification/initiation"))
      .register(ResponseLoggingFilter.class)
      .sslContext(sslContext)
      .connectTimeout(2, TimeUnit.SECONDS)
      .readTimeout(2, TimeUnit.SECONDS)
      .build(JSONPlaceholderClient.class);

    return jsonApiClient;
  }

  public Response getClientProducts() throws URISyntaxException {
//    JSONPlaceholderClient jsonApiClient = restClientBuilder();
    JsonObject clientPost = Json.createObjectBuilder()
            .add("eventDetailList", Json.createArrayBuilder().add(Json.createObjectBuilder()
                    .add("correspondenceAddressee",Json.createObjectBuilder()
                            .add("mobileContactType","8")
                            .add("mobileContactValue","918999757422").build())
                    .add("correspondenceContent",Json.createObjectBuilder()
                            .add("alertText","Dear Customer, 200 Rs credited into your account ")
                            .add("customerId","44556677").build())
                    .add("correspondenceMedia",Json.createObjectBuilder()
                            .add("deliveryMode","1")
                            .add("operationMode","").build())
                    .add("correspondenceTemplateReference",Json.createObjectBuilder()
                            .add("smsDestinationType","SMS")
                            .add("smsEventId","PAYMENT").build())
                    .add("productAndServiceType",Json.createObjectBuilder()
                            .add("eventIdentifier","1").build())))
            .build();

    System.out.println("response =====================");
    Response response = restClientBuilder().sms(clientPost);
    System.out.println(response.getStatus());
    System.out.println(response.readEntity(JsonObject.class));
    System.out.println("Done =====================");
  return response;
//    Response postClient = jsonApiClient.sms(clientPost);
  }

  public void sendSmsHeaders(Map<String, String> headers, String correlationId, String country, String consumeRef) {
    headers.put(Constants.CORRELATION_ID_FIELD, correlationId);
    headers.put(Constants.BUSINESS_ID_FIELD, country.concat(Constants.BUSINESS_ID));
    headers.put(Constants.COUNTRY_CODE_FIELD, country);
    headers.put(Constants.SYSTEM_ID_FIELD, Constants.SMS_SYSTEM_ID);
    headers.put(Constants.CONSUMER_UNIQUE_REF_ID_FIELD, Constants.CONSUMER_UNIQUE_REFERENCE_ID);
    headers.put(Constants.STAFF_ID_FIELD, Constants.STAFF_ID);
  }

}