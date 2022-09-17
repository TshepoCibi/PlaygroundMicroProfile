package com.example.playground.blog;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.ext.ClientHeadersFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

@ApplicationScoped
public class SmsClientHeaders implements ClientHeadersFactory {

  @Inject
  @ConfigProperty(name = "secrets.value")
  private String secretValue;

  @Override
  public MultivaluedMap<String, String> update(MultivaluedMap<String, String> incomingHeaders, MultivaluedMap<String, String> clientOutgoingHeaders) {

    System.out.println("--- Incoming headers of the JAX-RS environment");
    incomingHeaders.forEach((k, v) -> System.out.println(k + ":" + v));

    System.out.println("--- Specified outgoing headers of the Rest Client");
    clientOutgoingHeaders.add("Correlation-Id","abcdabcd-abcd-abcd-abcd-Abcdabcdabcf");
    clientOutgoingHeaders.add("Business-Id","KEBRB");
    clientOutgoingHeaders.add("Staff-Id","IFE");
    clientOutgoingHeaders.add("Country-Code","KE");
    clientOutgoingHeaders.add("ConsumerUniqueReference-Id","334456677888");
    clientOutgoingHeaders.add("System-Id","IB");
    clientOutgoingHeaders.forEach((k, v) -> System.out.println(k + ":" + v));

    MultivaluedMap<String, String> resultHeader = new MultivaluedHashMap();
//    resultHeader.putAll(incomingHeaders);
    resultHeader.putAll(clientOutgoingHeaders);

    System.out.println("--- Header of the Rest Client after merging");
    resultHeader.forEach((k, v) -> System.out.println(k + ":" + v));

    return resultHeader;
  }


}
