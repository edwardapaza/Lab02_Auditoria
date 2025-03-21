package com.google.android.play.core.integrity;

import com.google.android.gms.tasks.Task;
import com.google.android.play.core.integrity.StandardIntegrityManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bd {

    /* renamed from: a  reason: collision with root package name */
    private final ax f1304a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(ax axVar) {
        this.f1304a = axVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task a(long j5, long j6, StandardIntegrityManager.StandardIntegrityTokenRequest standardIntegrityTokenRequest) {
        return this.f1304a.c(standardIntegrityTokenRequest.a(), j5, j6);
    }
}
