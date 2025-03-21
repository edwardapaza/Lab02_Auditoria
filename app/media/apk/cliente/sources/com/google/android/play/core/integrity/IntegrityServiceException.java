package com.google.android.play.core.integrity;

import com.google.android.gms.common.api.Status;
import java.util.Locale;
/* loaded from: classes.dex */
public class IntegrityServiceException extends com.google.android.gms.common.api.b {

    /* renamed from: a  reason: collision with root package name */
    private final Throwable f1243a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IntegrityServiceException(int i5, Throwable th) {
        super(new Status(i5, String.format(Locale.ROOT, "Integrity API error (%d): %s.", Integer.valueOf(i5), com.google.android.play.core.integrity.model.a.a(i5))));
        if (i5 == 0) {
            throw new IllegalArgumentException("ErrorCode should not be 0.");
        }
        this.f1243a = th;
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable getCause() {
        return this.f1243a;
    }

    public int getErrorCode() {
        return super.getStatusCode();
    }
}
