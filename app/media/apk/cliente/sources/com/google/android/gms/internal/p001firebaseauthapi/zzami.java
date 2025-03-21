package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Iterator;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzami  reason: invalid package */
/* loaded from: classes.dex */
final class zzami implements Iterator<String> {
    private Iterator<String> zza;
    private final /* synthetic */ zzamg zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzami(zzamg zzamgVar) {
        zzajq zzajqVar;
        this.zzb = zzamgVar;
        zzajqVar = zzamgVar.zza;
        this.zza = zzajqVar.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.zza.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
