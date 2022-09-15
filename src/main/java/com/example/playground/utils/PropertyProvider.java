package com.example.playground.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import org.eclipse.microprofile.config.Config;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.ObjectInputFilter;

@Getter
@Setter
@ApplicationScoped
public class PropertyProvider {

    private String AMOL_SMS_NOTIFICATION_URL = "https://domain-api-cit.nprd-amol.intra.absa.co.za:443/v1/correspondence/correspondence-operating-session/outbound/multiplenotification/initiation";

    private String AMOL_SMS_NOTIFICATION_APP_ID = "b5db93ea";

    private String AMOL_SMS_NOTIFICATION_APP_KEY = "6864b0cbeedac3ea02643b579d1a2291";

    private String AMOL_EMAIL_NOTIFICATION_URL = "https://correspondence-domain-cit-zm.amol-api.roanprd-openshift.intra.absa.co.za/v1/correspondence/correspondence-operating-session/outbound/multiplenotification/initiation";

}
