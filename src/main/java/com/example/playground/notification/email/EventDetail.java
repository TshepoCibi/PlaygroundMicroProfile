package com.example.playground.notification.email;

import lombok.*;

import java.util.Set;


@Getter
@Setter
public class EventDetail {
    private CorrespondenceAddressee correspondenceAddressee;
    private CorrespondenceContent correspondenceContent;
    private CorrespondenceMedia correspondenceMedia;
    private CorrespondenceTemplateReference correspondenceTemplateReference;
    private Set<DynamicField> dynamicFields;
    private Set<Attachment> attachments;
}
