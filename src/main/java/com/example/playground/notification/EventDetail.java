package com.example.playground.notification;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
@Getter
@Setter
public class EventDetail {

    private CorrespondenceAddressee correspondenceAddressee;
    private CorrespondenceContent correspondenceContent;
    private CorrespondenceMedia correspondenceMedia;
    private CorrespondenceTemplateReference correspondenceTemplateReference;
    private ProductAndServiceType productAndServiceType;
}
