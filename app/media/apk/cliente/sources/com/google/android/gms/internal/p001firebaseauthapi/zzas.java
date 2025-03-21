package com.google.android.gms.internal.p001firebaseauthapi;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzas  reason: invalid package */
/* loaded from: classes.dex */
public final class zzas<E> extends zzak<E> {
    private final zzaq<E> zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzas(zzaq<E> zzaqVar, int i5) {
        super(zzaqVar.size(), i5);
        this.zza = zzaqVar;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzak
    protected final E zza(int i5) {
        return this.zza.get(i5);
    }
}
