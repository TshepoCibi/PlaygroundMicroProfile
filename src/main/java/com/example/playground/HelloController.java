package com.example.playground;

import com.example.playground.blog.PostService;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;

/**
 *
 */
@Path("/hello")
@Singleton
public class HelloController {

    @Inject
    PostService postService;

//    @GET
//    public String sayHello() {
//        return "Hello World jjnj";
//    }
    @GET
    public Response sendSMS() throws URISyntaxException {

       Response response = postService.getClientProducts();
        return Response.ok(response).build();
    }
}
