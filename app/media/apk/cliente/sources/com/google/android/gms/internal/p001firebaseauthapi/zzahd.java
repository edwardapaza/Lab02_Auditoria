package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzahd;
import com.google.android.gms.internal.p001firebaseauthapi.zzahf;
import java.io.IOException;
import java.io.OutputStream;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahd  reason: invalid package */
/* loaded from: classes.dex */
public abstract class zzahd<MessageType extends zzahd<MessageType, BuilderType>, BuilderType extends zzahf<MessageType, BuilderType>> implements zzakk {
    protected int zza = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public int zza(zzalc zzalcVar) {
        int zzh = zzh();
        if (zzh == -1) {
            int zza = zzalcVar.zza(this);
            zzb(zza);
            return zza;
        }
        return zzh;
    }

    public final void zza(OutputStream outputStream) {
        zzaii zza = zzaii.zza(outputStream, zzaii.zzd(zzk()));
        zza(zza);
        zza.zzc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zzb(int i5) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int zzh() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzakk
    public final zzahm zzi() {
        try {
            zzahv zzc = zzahm.zzc(zzk());
            zza(zzc.zzb());
            return zzc.zza();
        } catch (IOException e5) {
            String name = getClass().getName();
            throw new RuntimeException("Serializing " + name + " to a ByteString threw an IOException (should never happen).", e5);
        }
    }

    public final byte[] zzj() {
        try {
            byte[] bArr = new byte[zzk()];
            zzaii zzb = zzaii.zzb(bArr);
            zza(zzb);
            zzb.zzb();
            return bArr;
        } catch (IOException e5) {
            String name = getClass().getName();
            throw new RuntimeException("Serializing " + name + " to a byte array threw an IOException (should never happen).", e5);
        }
    }
}
