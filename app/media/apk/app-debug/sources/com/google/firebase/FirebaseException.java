package com.google.firebase;

import com.google.android.gms.common.internal.Preconditions;
/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
public class FirebaseException extends Exception {
    /* JADX INFO: Access modifiers changed from: protected */
    @Deprecated
    public FirebaseException() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FirebaseException(String detailMessage) {
        super(detailMessage);
        Preconditions.checkNotEmpty(detailMessage, "Detail message must not be empty");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FirebaseException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
        Preconditions.checkNotEmpty(detailMessage, "Detail message must not be empty");
    }
}
