package com.google.android.gms.internal.p001firebaseauthapi;

import java.io.OutputStream;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbj  reason: invalid package */
/* loaded from: classes.dex */
public final class zzbj implements zzce {
    private final OutputStream zza;

    private zzbj(OutputStream outputStream) {
        this.zza = outputStream;
    }

    public static zzce zza(OutputStream outputStream) {
        return new zzbj(outputStream);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzce
    public final void zza(zzty zztyVar) {
        try {
            ((zzty) ((zzaja) zztyVar.zzm().zza().zzf())).zza(this.zza);
        } finally {
            this.zza.close();
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzce
    public final void zza(zzvh zzvhVar) {
        try {
            zzvhVar.zza(this.zza);
        } finally {
            this.zza.close();
        }
    }
}
