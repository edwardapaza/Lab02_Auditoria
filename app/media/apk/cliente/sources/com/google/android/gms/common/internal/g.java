package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public abstract class g<T extends IInterface> extends c<T> implements a.f {
    private static volatile Executor zaa;
    private final d zab;
    private final Set<Scope> zac;
    private final Account zad;

    protected g(Context context, Handler handler, int i5, d dVar) {
        super(context, handler, h.b(context), l0.f.m(), i5, null, null);
        this.zab = (d) q.k(dVar);
        this.zad = dVar.a();
        this.zac = zaa(dVar.c());
    }

    protected g(Context context, Looper looper, int i5, d dVar) {
        this(context, looper, h.b(context), l0.f.m(), i5, dVar, null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Deprecated
    public g(Context context, Looper looper, int i5, d dVar, f.a aVar, f.b bVar) {
        this(context, looper, i5, dVar, (com.google.android.gms.common.api.internal.e) aVar, (com.google.android.gms.common.api.internal.m) bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context, Looper looper, int i5, d dVar, com.google.android.gms.common.api.internal.e eVar, com.google.android.gms.common.api.internal.m mVar) {
        this(context, looper, h.b(context), l0.f.m(), i5, dVar, (com.google.android.gms.common.api.internal.e) q.k(eVar), (com.google.android.gms.common.api.internal.m) q.k(mVar));
    }

    protected g(Context context, Looper looper, h hVar, l0.f fVar, int i5, d dVar, com.google.android.gms.common.api.internal.e eVar, com.google.android.gms.common.api.internal.m mVar) {
        super(context, looper, hVar, fVar, i5, eVar == null ? null : new g0(eVar), mVar == null ? null : new h0(mVar), dVar.h());
        this.zab = dVar;
        this.zad = dVar.a();
        this.zac = zaa(dVar.c());
    }

    private final Set<Scope> zaa(Set<Scope> set) {
        Set<Scope> validateScopes = validateScopes(set);
        for (Scope scope : validateScopes) {
            if (!set.contains(scope)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return validateScopes;
    }

    @Override // com.google.android.gms.common.internal.c
    public final Account getAccount() {
        return this.zad;
    }

    @Override // com.google.android.gms.common.internal.c
    protected final Executor getBindServiceExecutor() {
        return null;
    }

    protected final d getClientSettings() {
        return this.zab;
    }

    public l0.c[] getRequiredFeatures() {
        return new l0.c[0];
    }

    @Override // com.google.android.gms.common.internal.c
    protected final Set<Scope> getScopes() {
        return this.zac;
    }

    @Override // com.google.android.gms.common.api.a.f
    public Set<Scope> getScopesForConnectionlessNonSignIn() {
        return requiresSignIn() ? this.zac : Collections.emptySet();
    }

    protected Set<Scope> validateScopes(Set<Scope> set) {
        return set;
    }
}
