package com.google.android.recaptcha.internal;

import sun.misc.Unsafe;
/* loaded from: classes.dex */
final class zzls extends zzlu {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzls(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.recaptcha.internal.zzlu
    public final double zza(Object obj, long j5) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j5));
    }

    @Override // com.google.android.recaptcha.internal.zzlu
    public final float zzb(Object obj, long j5) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j5));
    }

    @Override // com.google.android.recaptcha.internal.zzlu
    public final void zzc(Object obj, long j5, boolean z4) {
        if (zzlv.zzb) {
            zzlv.zzD(obj, j5, r3 ? (byte) 1 : (byte) 0);
        } else {
            zzlv.zzE(obj, j5, r3 ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.recaptcha.internal.zzlu
    public final void zzd(Object obj, long j5, byte b5) {
        if (zzlv.zzb) {
            zzlv.zzD(obj, j5, b5);
        } else {
            zzlv.zzE(obj, j5, b5);
        }
    }

    @Override // com.google.android.recaptcha.internal.zzlu
    public final void zze(Object obj, long j5, double d5) {
        this.zza.putLong(obj, j5, Double.doubleToLongBits(d5));
    }

    @Override // com.google.android.recaptcha.internal.zzlu
    public final void zzf(Object obj, long j5, float f5) {
        this.zza.putInt(obj, j5, Float.floatToIntBits(f5));
    }

    @Override // com.google.android.recaptcha.internal.zzlu
    public final boolean zzg(Object obj, long j5) {
        return zzlv.zzb ? zzlv.zzt(obj, j5) : zzlv.zzu(obj, j5);
    }
}
