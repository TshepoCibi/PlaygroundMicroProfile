package com.example.playground.notification.sms;

import lombok.*;

@Getter
@Setter
public class EventDetail {

    private CorrespondenceAddressee correspondenceAddressee;
    private CorrespondenceContent correspondenceContent;
    private CorrespondenceMedia correspondenceMedia;
    private CorrespondenceTemplateReference correspondenceTemplateReference;
    private ProductAndServiceType productAndServiceType;
}
