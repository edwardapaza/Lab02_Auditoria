package com.google.android.recaptcha.internal;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzlv {
    static final long zza;
    static final boolean zzb;
    private static final Unsafe zzc;
    private static final Class zzd;
    private static final boolean zze;
    private static final zzlu zzf;
    private static final boolean zzg;
    private static final boolean zzh;

    /* JADX WARN: Removed duplicated region for block: B:22:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0134  */
    static {
        /*
            Method dump skipped, instructions count: 312
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzlv.<clinit>():void");
    }

    private zzlv() {
    }

    private static int zzA(Class cls) {
        if (zzh) {
            return zzf.zza.arrayIndexScale(cls);
        }
        return -1;
    }

    private static Field zzB() {
        int i5 = zzgi.zza;
        Field zzC = zzC(Buffer.class, "effectiveDirectAddress");
        if (zzC == null) {
            Field zzC2 = zzC(Buffer.class, "address");
            if (zzC2 == null || zzC2.getType() != Long.TYPE) {
                return null;
            }
            return zzC2;
        }
        return zzC;
    }

    private static Field zzC(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzD(Object obj, long j5, byte b5) {
        zzlu zzluVar = zzf;
        long j6 = (-4) & j5;
        int i5 = zzluVar.zza.getInt(obj, j6);
        int i6 = ((~((int) j5)) & 3) << 3;
        zzluVar.zza.putInt(obj, j6, ((255 & b5) << i6) | (i5 & (~(255 << i6))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzE(Object obj, long j5, byte b5) {
        zzlu zzluVar = zzf;
        long j6 = (-4) & j5;
        int i5 = (((int) j5) & 3) << 3;
        zzluVar.zza.putInt(obj, j6, ((255 & b5) << i5) | (zzluVar.zza.getInt(obj, j6) & (~(255 << i5))));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double zza(Object obj, long j5) {
        return zzf.zza(obj, j5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float zzb(Object obj, long j5) {
        return zzf.zzb(obj, j5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(Object obj, long j5) {
        return zzf.zza.getInt(obj, j5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zzd(Object obj, long j5) {
        return zzf.zza.getLong(obj, j5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zze(Class cls) {
        try {
            return zzc.allocateInstance(cls);
        } catch (InstantiationException e5) {
            throw new IllegalStateException(e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzf(Object obj, long j5) {
        return zzf.zza.getObject(obj, j5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Unsafe zzg() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzlr());
        } catch (Throwable unused) {
            return null;
        }
    }

    static /* bridge */ /* synthetic */ void zzh(Throwable th) {
        Logger.getLogger(zzlv.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(th.toString()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzm(Object obj, long j5, boolean z4) {
        zzf.zzc(obj, j5, z4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzn(byte[] bArr, long j5, byte b5) {
        zzf.zzd(bArr, zza + j5, b5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzo(Object obj, long j5, double d5) {
        zzf.zze(obj, j5, d5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzp(Object obj, long j5, float f5) {
        zzf.zzf(obj, j5, f5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzq(Object obj, long j5, int i5) {
        zzf.zza.putInt(obj, j5, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzr(Object obj, long j5, long j6) {
        zzf.zza.putLong(obj, j5, j6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzs(Object obj, long j5, Object obj2) {
        zzf.zza.putObject(obj, j5, obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ boolean zzt(Object obj, long j5) {
        return ((byte) ((zzf.zza.getInt(obj, (-4) & j5) >>> ((int) (((~j5) & 3) << 3))) & 255)) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ boolean zzu(Object obj, long j5) {
        return ((byte) ((zzf.zza.getInt(obj, (-4) & j5) >>> ((int) ((j5 & 3) << 3))) & 255)) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static boolean zzv(Class cls) {
        int i5 = zzgi.zza;
        try {
            Class cls2 = zzd;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzw(Object obj, long j5) {
        return zzf.zzg(obj, j5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzx() {
        return zzh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzy() {
        return zzg;
    }

    private static int zzz(Class cls) {
        if (zzh) {
            return zzf.zza.arrayBaseOffset(cls);
        }
        return -1;
    }
}
