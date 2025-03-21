package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;
import t0.a;
/* loaded from: classes.dex */
public final class n extends zza {
    /* JADX INFO: Access modifiers changed from: package-private */
    public n(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    public final t0.a a(t0.a aVar, String str, int i5, t0.a aVar2) {
        Parcel zza = zza();
        zzc.zze(zza, aVar);
        zza.writeString(str);
        zza.writeInt(i5);
        zzc.zze(zza, aVar2);
        Parcel zzB = zzB(2, zza);
        t0.a a5 = a.AbstractBinderC0115a.a(zzB.readStrongBinder());
        zzB.recycle();
        return a5;
    }

    public final t0.a b(t0.a aVar, String str, int i5, t0.a aVar2) {
        Parcel zza = zza();
        zzc.zze(zza, aVar);
        zza.writeString(str);
        zza.writeInt(i5);
        zzc.zze(zza, aVar2);
        Parcel zzB = zzB(3, zza);
        t0.a a5 = a.AbstractBinderC0115a.a(zzB.readStrongBinder());
        zzB.recycle();
        return a5;
    }
}
