package com.example.playground.blog;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.ext.ClientHeadersFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

@ApplicationScoped
public class GlobalClientHeaders implements ClientHeadersFactory {

  Config config = ConfigProvider.getConfig();

  @Override
  public MultivaluedMap<String, String> update(MultivaluedMap<String, String> incomingHeaders, MultivaluedMap<String, String> clientOutgoingHeaders) {

    System.out.println("--- Incoming headers of the JAX-RS environment");
    incomingHeaders.forEach((k, v) -> System.out.println(k + ":" + v));

    System.out.println("--- Specified outgoing headers of the Rest Client");
    clientOutgoingHeaders.add("Correlation-Id",incomingHeaders.getFirst("Correlation-Id"));
    clientOutgoingHeaders.add("Staff-Id",incomingHeaders.getFirst("Staff-Id"));
    clientOutgoingHeaders.add("Business-Id",config.getValue("county.code",String.class) + "BRB");
    clientOutgoingHeaders.add("Country-Code", config.getValue("county.code",String.class));
    clientOutgoingHeaders.add("ConsumerUniqueReference-Id", incomingHeaders.getFirst("ConsumerUniqueReference-Id"));
    clientOutgoingHeaders.add("System-Id", incomingHeaders.getFirst("System-Id"));


    clientOutgoingHeaders.forEach((k, v) -> System.out.println(k + ":" + v));

    MultivaluedMap<String, String> resultHeader = new MultivaluedHashMap();
//    resultHeader.putAll(incomingHeaders);
    resultHeader.putAll(clientOutgoingHeaders);

    System.out.println("--- Header of the Rest Client after merging");
    resultHeader.forEach((k, v) -> System.out.println(k + ":" + v));

    return resultHeader;
  }


}
