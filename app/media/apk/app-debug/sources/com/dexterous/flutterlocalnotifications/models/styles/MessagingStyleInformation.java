package com.dexterous.flutterlocalnotifications.models.styles;

import com.dexterous.flutterlocalnotifications.models.MessageDetails;
import com.dexterous.flutterlocalnotifications.models.PersonDetails;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class MessagingStyleInformation extends DefaultStyleInformation {
    public String conversationTitle;
    public Boolean groupConversation;
    public ArrayList<MessageDetails> messages;
    public PersonDetails person;

    public MessagingStyleInformation(PersonDetails person, String conversationTitle, Boolean groupConversation, ArrayList<MessageDetails> messages, Boolean htmlFormatTitle, Boolean htmlFormatBody) {
        super(htmlFormatTitle, htmlFormatBody);
        this.person = person;
        this.conversationTitle = conversationTitle;
        this.groupConversation = groupConversation;
        this.messages = messages;
    }
}
