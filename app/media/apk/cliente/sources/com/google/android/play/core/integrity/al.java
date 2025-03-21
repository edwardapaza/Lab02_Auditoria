package com.google.android.play.core.integrity;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.integrity.StandardIntegrityManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class al implements StandardIntegrityManager {

    /* renamed from: a  reason: collision with root package name */
    private final ax f1268a;

    /* renamed from: b  reason: collision with root package name */
    private final bd f1269b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ax axVar, bd bdVar) {
        this.f1268a = axVar;
        this.f1269b = bdVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task a(StandardIntegrityManager.PrepareIntegrityTokenRequest prepareIntegrityTokenRequest, Long l5) {
        final bd bdVar = this.f1269b;
        final long a5 = prepareIntegrityTokenRequest.a();
        final long longValue = l5.longValue();
        return Tasks.forResult(new StandardIntegrityManager.StandardIntegrityTokenProvider() { // from class: com.google.android.play.core.integrity.bc
            @Override // com.google.android.play.core.integrity.StandardIntegrityManager.StandardIntegrityTokenProvider
            public final Task request(StandardIntegrityManager.StandardIntegrityTokenRequest standardIntegrityTokenRequest) {
                return bd.this.a(a5, longValue, standardIntegrityTokenRequest);
            }
        });
    }

    @Override // com.google.android.play.core.integrity.StandardIntegrityManager
    public final Task<StandardIntegrityManager.StandardIntegrityTokenProvider> prepareIntegrityToken(final StandardIntegrityManager.PrepareIntegrityTokenRequest prepareIntegrityTokenRequest) {
        return this.f1268a.d(prepareIntegrityTokenRequest.a()).onSuccessTask(new SuccessContinuation() { // from class: com.google.android.play.core.integrity.ak
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return al.this.a(prepareIntegrityTokenRequest, (Long) obj);
            }
        });
    }
}
