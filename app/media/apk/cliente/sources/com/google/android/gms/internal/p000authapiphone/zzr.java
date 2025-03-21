package com.google.android.gms.internal.p000authapiphone;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.e;
import com.google.android.gms.common.api.internal.m;
import com.google.android.gms.common.internal.d;
/* renamed from: com.google.android.gms.internal.auth-api-phone.zzr  reason: invalid package */
/* loaded from: classes.dex */
final class zzr extends a.AbstractC0036a<zzv, a.d.c> {
    @Override // com.google.android.gms.common.api.a.AbstractC0036a
    public final /* synthetic */ zzv buildClient(Context context, Looper looper, d dVar, a.d.c cVar, e eVar, m mVar) {
        return new zzv(context, looper, dVar, eVar, mVar);
    }
}
