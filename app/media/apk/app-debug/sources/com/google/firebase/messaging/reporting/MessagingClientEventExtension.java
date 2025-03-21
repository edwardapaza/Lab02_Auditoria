package com.google.firebase.messaging.reporting;

import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.messaging.ProtoEncoderDoNotUse;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes.dex */
public final class MessagingClientEventExtension {
    private static final MessagingClientEventExtension DEFAULT_INSTANCE = new Builder().build();
    private final MessagingClientEvent messaging_client_event_;

    MessagingClientEventExtension(MessagingClientEvent messaging_client_event_) {
        this.messaging_client_event_ = messaging_client_event_;
    }

    public byte[] toByteArray() {
        return ProtoEncoderDoNotUse.encode(this);
    }

    public void writeTo(OutputStream output) throws IOException {
        ProtoEncoderDoNotUse.encode(this, output);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Encodable.Ignore
    public MessagingClientEvent getMessagingClientEvent() {
        MessagingClientEvent messagingClientEvent = this.messaging_client_event_;
        return messagingClientEvent == null ? MessagingClientEvent.getDefaultInstance() : messagingClientEvent;
    }

    @Encodable.Field(name = "messagingClientEvent")
    public MessagingClientEvent getMessagingClientEventInternal() {
        return this.messaging_client_event_;
    }

    public static MessagingClientEventExtension getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        private MessagingClientEvent messaging_client_event_ = null;

        Builder() {
        }

        public MessagingClientEventExtension build() {
            return new MessagingClientEventExtension(this.messaging_client_event_);
        }

        public Builder setMessagingClientEvent(MessagingClientEvent messaging_client_event_) {
            this.messaging_client_event_ = messaging_client_event_;
            return this;
        }
    }
}
