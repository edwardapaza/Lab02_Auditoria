package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;
import t0.a;
/* loaded from: classes.dex */
public final class m extends zza {
    /* JADX INFO: Access modifiers changed from: package-private */
    public m(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    public final int a() {
        Parcel zzB = zzB(6, zza());
        int readInt = zzB.readInt();
        zzB.recycle();
        return readInt;
    }

    public final int b(t0.a aVar, String str, boolean z4) {
        Parcel zza = zza();
        zzc.zze(zza, aVar);
        zza.writeString(str);
        zza.writeInt(z4 ? 1 : 0);
        Parcel zzB = zzB(3, zza);
        int readInt = zzB.readInt();
        zzB.recycle();
        return readInt;
    }

    public final int f(t0.a aVar, String str, boolean z4) {
        Parcel zza = zza();
        zzc.zze(zza, aVar);
        zza.writeString(str);
        zza.writeInt(z4 ? 1 : 0);
        Parcel zzB = zzB(5, zza);
        int readInt = zzB.readInt();
        zzB.recycle();
        return readInt;
    }

    public final t0.a l(t0.a aVar, String str, int i5) {
        Parcel zza = zza();
        zzc.zze(zza, aVar);
        zza.writeString(str);
        zza.writeInt(i5);
        Parcel zzB = zzB(2, zza);
        t0.a a5 = a.AbstractBinderC0115a.a(zzB.readStrongBinder());
        zzB.recycle();
        return a5;
    }

    public final t0.a m(t0.a aVar, String str, int i5, t0.a aVar2) {
        Parcel zza = zza();
        zzc.zze(zza, aVar);
        zza.writeString(str);
        zza.writeInt(i5);
        zzc.zze(zza, aVar2);
        Parcel zzB = zzB(8, zza);
        t0.a a5 = a.AbstractBinderC0115a.a(zzB.readStrongBinder());
        zzB.recycle();
        return a5;
    }

    public final t0.a n(t0.a aVar, String str, int i5) {
        Parcel zza = zza();
        zzc.zze(zza, aVar);
        zza.writeString(str);
        zza.writeInt(i5);
        Parcel zzB = zzB(4, zza);
        t0.a a5 = a.AbstractBinderC0115a.a(zzB.readStrongBinder());
        zzB.recycle();
        return a5;
    }

    public final t0.a o(t0.a aVar, String str, boolean z4, long j5) {
        Parcel zza = zza();
        zzc.zze(zza, aVar);
        zza.writeString(str);
        zza.writeInt(z4 ? 1 : 0);
        zza.writeLong(j5);
        Parcel zzB = zzB(7, zza);
        t0.a a5 = a.AbstractBinderC0115a.a(zzB.readStrongBinder());
        zzB.recycle();
        return a5;
    }
}
