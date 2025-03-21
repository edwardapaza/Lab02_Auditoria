package com.dexterous.flutterlocalnotifications.models;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class MessageDetails implements Serializable {
    public String dataMimeType;
    public String dataUri;
    public PersonDetails person;
    public String text;
    public Long timestamp;

    public MessageDetails(String text, Long timestamp, PersonDetails person, String dataMimeType, String dataUri) {
        this.text = text;
        this.timestamp = timestamp;
        this.person = person;
        this.dataMimeType = dataMimeType;
        this.dataUri = dataUri;
    }
}
