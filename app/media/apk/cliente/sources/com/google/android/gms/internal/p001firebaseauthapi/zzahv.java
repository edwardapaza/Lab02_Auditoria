package com.google.android.gms.internal.p001firebaseauthapi;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahv  reason: invalid package */
/* loaded from: classes.dex */
public final class zzahv {
    private final zzaii zza;
    private final byte[] zzb;

    private zzahv(int i5) {
        byte[] bArr = new byte[i5];
        this.zzb = bArr;
        this.zza = zzaii.zzb(bArr);
    }

    public final zzahm zza() {
        this.zza.zzb();
        return new zzahw(this.zzb);
    }

    public final zzaii zzb() {
        return this.zza;
    }
}
