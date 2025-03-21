package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class w {

    /* renamed from: a  reason: collision with root package name */
    private final Map<BasePendingResult<?>, Boolean> f1058a = Collections.synchronizedMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    private final Map<TaskCompletionSource<?>, Boolean> f1059b = Collections.synchronizedMap(new WeakHashMap());

    private final void h(boolean z4, Status status) {
        HashMap hashMap;
        HashMap hashMap2;
        synchronized (this.f1058a) {
            hashMap = new HashMap(this.f1058a);
        }
        synchronized (this.f1059b) {
            hashMap2 = new HashMap(this.f1059b);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (z4 || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).c(status);
            }
        }
        for (Map.Entry entry2 : hashMap2.entrySet()) {
            if (z4 || ((Boolean) entry2.getValue()).booleanValue()) {
                ((TaskCompletionSource) entry2.getKey()).trySetException(new com.google.android.gms.common.api.b(status));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(BasePendingResult<? extends com.google.android.gms.common.api.j> basePendingResult, boolean z4) {
        this.f1058a.put(basePendingResult, Boolean.valueOf(z4));
        basePendingResult.a(new u(this, basePendingResult));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final <TResult> void d(TaskCompletionSource<TResult> taskCompletionSource, boolean z4) {
        this.f1059b.put(taskCompletionSource, Boolean.valueOf(z4));
        taskCompletionSource.getTask().addOnCompleteListener(new v(this, taskCompletionSource));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(int r4, java.lang.String r5) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "The connection to Google Play services was lost"
            r0.<init>(r1)
            r1 = 1
            if (r4 != r1) goto L10
            java.lang.String r4 = " due to service disconnection."
        Lc:
            r0.append(r4)
            goto L16
        L10:
            r2 = 3
            if (r4 != r2) goto L16
            java.lang.String r4 = " due to dead object exception."
            goto Lc
        L16:
            if (r5 == 0) goto L20
            java.lang.String r4 = " Last reason for disconnect: "
            r0.append(r4)
            r0.append(r5)
        L20:
            com.google.android.gms.common.api.Status r4 = new com.google.android.gms.common.api.Status
            r5 = 20
            java.lang.String r0 = r0.toString()
            r4.<init>(r5, r0)
            r3.h(r1, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.w.e(int, java.lang.String):void");
    }

    public final void f() {
        h(false, f.f930r);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean g() {
        return (this.f1058a.isEmpty() && this.f1059b.isEmpty()) ? false : true;
    }
}
