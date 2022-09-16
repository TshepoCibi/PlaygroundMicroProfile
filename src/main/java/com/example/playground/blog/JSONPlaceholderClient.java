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
@RegisterClientHeaders(GlobalClientHeaders.class)
public interface JSONPlaceholderClient {

//  @GET
//  @Path("/posts")
//  JsonArray getAllPosts(@QueryParam("orderBy") String orderDirection);
//
//  @GET
//  @Path("/posts/{id}")
//  CompletionStage<JsonObject> getPostById(@PathParam("id") String id);
//
//  @GET
//  @Path("/posts/{id}/comments")
//  JsonArray getCommentsForPostByPostId(@PathParam("id") String id);
//
//  @POST
//  @Path("/posts")
//  Response createPost(JsonObject post);
//
//  @DELETE
//  @Path("/posts/{id}")
//  Response deletePostById(@PathParam("id") String id);
//
//  @PUT
//  @ClientHeaderParam(name = "Authorization", value = "{generateAuthHeader}")
//  @Path("/posts/{id}")
//  Response updatePostById(@PathParam("id") String id, JsonObject post, @HeaderParam("X-Request-Id") String requestIdHeader);

  @POST
  @Path("")
  ResponseDTO sms(@RequestBody SmsNotificationDTO clientPost);

//  default String generateAuthHeader() {
//    return "Basic " + new String(Base64.getEncoder().encode("duke:SECRET".getBytes()));
//  }

}
