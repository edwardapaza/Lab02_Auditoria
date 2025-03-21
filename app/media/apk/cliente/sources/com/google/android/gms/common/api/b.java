package com.google.android.gms.common.api;
/* loaded from: classes.dex */
public class b extends Exception {
    @Deprecated
    protected final Status mStatus;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public b(com.google.android.gms.common.api.Status r4) {
        /*
            r3 = this;
            int r0 = r4.u()
            java.lang.String r1 = r4.v()
            if (r1 == 0) goto Lf
            java.lang.String r1 = r4.v()
            goto L11
        Lf:
            java.lang.String r1 = ""
        L11:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r0 = ": "
            r2.append(r0)
            r2.append(r1)
            java.lang.String r0 = r2.toString()
            r3.<init>(r0)
            r3.mStatus = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.b.<init>(com.google.android.gms.common.api.Status):void");
    }

    public Status getStatus() {
        return this.mStatus;
    }

    public int getStatusCode() {
        return this.mStatus.u();
    }

    @Deprecated
    public String getStatusMessage() {
        return this.mStatus.v();
    }
}
