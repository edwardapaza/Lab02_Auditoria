package com.google.android.gms.internal.p001firebaseauthapi;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzala  reason: invalid package */
/* loaded from: classes.dex */
public final class zzala implements zzaki {
    private final zzakk zza;
    private final String zzb;
    private final Object[] zzc;
    private final int zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzala(zzakk zzakkVar, String str, Object[] objArr) {
        this.zza = zzakkVar;
        this.zzb = str;
        this.zzc = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.zzd = charAt;
            return;
        }
        int i5 = charAt & 8191;
        int i6 = 13;
        int i7 = 1;
        while (true) {
            int i8 = i7 + 1;
            char charAt2 = str.charAt(i7);
            if (charAt2 < 55296) {
                this.zzd = i5 | (charAt2 << i6);
                return;
            }
            i5 |= (charAt2 & 8191) << i6;
            i6 += 13;
            i7 = i8;
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaki
    public final zzakk zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaki
    public final zzakz zzb() {
        int i5 = this.zzd;
        return (i5 & 1) != 0 ? zzakz.PROTO2 : (i5 & 4) == 4 ? zzakz.EDITIONS : zzakz.PROTO3;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaki
    public final boolean zzc() {
        return (this.zzd & 2) == 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzd() {
        return this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object[] zze() {
        return this.zzc;
    }
}
