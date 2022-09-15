package com.example.playground.blog;

import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Base64;
import java.util.concurrent.CompletionStage;

@RegisterRestClient(baseUri = "https://correspondence-domain-cit-ke.amol-api.roanprd-openshift.intra.absa.co.za/v1/correspondence/correspondence-operating-session/outbound/multiplenotification/initiation")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RegisterProvider(ResponseLoggingFilter.class)
@RegisterClientHeaders(GlobalClientHeaders.class)
@ClientHeaderParam(name = "X-Application-Name", value = "MP-blog")
@ApplicationScoped
public interface JSONPlaceholderClient {

  @GET
  @Path("/posts")
  JsonArray getAllPosts(@QueryParam("orderBy") String orderDirection);

  @GET
  @Path("/posts/{id}")
  CompletionStage<JsonObject> getPostById(@PathParam("id") String id);

  @GET
  @Path("/posts/{id}/comments")
  JsonArray getCommentsForPostByPostId(@PathParam("id") String id);

  @POST
  @Path("/posts")
  Response createPost(JsonObject post);

  @DELETE
  @Path("/posts/{id}")
  Response deletePostById(@PathParam("id") String id);

  @PUT
  @ClientHeaderParam(name = "Authorization", value = "{generateAuthHeader}")
  @Path("/posts/{id}")
  Response updatePostById(@PathParam("id") String id, JsonObject post, @HeaderParam("X-Request-Id") String requestIdHeader);

  @POST
  @Path("")
  Response sms(JsonObject clientPost);

  default String generateAuthHeader() {
    return "Basic " + new String(Base64.getEncoder().encode("duke:SECRET".getBytes()));
  }

}
