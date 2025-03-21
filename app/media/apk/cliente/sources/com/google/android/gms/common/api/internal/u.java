package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.g;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class u implements g.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BasePendingResult f1046a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ w f1047b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(w wVar, BasePendingResult basePendingResult) {
        this.f1047b = wVar;
        this.f1046a = basePendingResult;
    }

    @Override // com.google.android.gms.common.api.g.a
    public final void a(Status status) {
        Map map;
        map = this.f1047b.f1058a;
        map.remove(this.f1046a);
    }
}
