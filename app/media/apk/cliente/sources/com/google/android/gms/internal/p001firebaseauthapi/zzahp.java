package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.NoSuchElementException;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahp  reason: invalid package */
/* loaded from: classes.dex */
public final class zzahp extends zzahr {
    private int zza = 0;
    private final int zzb;
    private final /* synthetic */ zzahm zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzahp(zzahm zzahmVar) {
        this.zzc = zzahmVar;
        this.zzb = zzahmVar.zzb();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza < this.zzb;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzahs
    public final byte zza() {
        int i5 = this.zza;
        if (i5 < this.zzb) {
            this.zza = i5 + 1;
            return this.zzc.zzb(i5);
        }
        throw new NoSuchElementException();
    }
}
