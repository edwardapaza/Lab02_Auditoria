package com.google.android.gms.internal.p001firebaseauthapi;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzamh  reason: invalid package */
/* loaded from: classes.dex */
public final class zzamh {
    static final boolean zza;
    private static final Unsafe zzb;
    private static final Class<?> zzc;
    private static final boolean zzd;
    private static final boolean zze;
    private static final zzb zzf;
    private static final boolean zzg;
    private static final boolean zzh;
    private static final long zzi;
    private static final long zzj;
    private static final long zzk;
    private static final long zzl;
    private static final long zzm;
    private static final long zzn;
    private static final long zzo;
    private static final long zzp;
    private static final long zzq;
    private static final long zzr;
    private static final long zzs;
    private static final long zzt;
    private static final long zzu;
    private static final long zzv;
    private static final int zzw;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzamh$zza */
    /* loaded from: classes.dex */
    private static final class zza extends zzb {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzb
        public final double zza(Object obj, long j5) {
            return Double.longBitsToDouble(zze(obj, j5));
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzb
        public final void zza(Object obj, long j5, byte b5) {
            if (zzamh.zza) {
                zzamh.zzc(obj, j5, b5);
            } else {
                zzamh.zzd(obj, j5, b5);
            }
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzb
        public final void zza(Object obj, long j5, double d5) {
            zza(obj, j5, Double.doubleToLongBits(d5));
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzb
        public final void zza(Object obj, long j5, float f5) {
            zza(obj, j5, Float.floatToIntBits(f5));
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzb
        public final void zza(Object obj, long j5, boolean z4) {
            if (zzamh.zza) {
                zzamh.zza(obj, j5, z4);
            } else {
                zzamh.zzb(obj, j5, z4);
            }
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzb
        public final float zzb(Object obj, long j5) {
            return Float.intBitsToFloat(zzd(obj, j5));
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzb
        public final boolean zzc(Object obj, long j5) {
            return zzamh.zza ? zzamh.zzf(obj, j5) : zzamh.zzg(obj, j5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzamh$zzb */
    /* loaded from: classes.dex */
    public static abstract class zzb {
        Unsafe zza;

        zzb(Unsafe unsafe) {
            this.zza = unsafe;
        }

        public abstract double zza(Object obj, long j5);

        public abstract void zza(Object obj, long j5, byte b5);

        public abstract void zza(Object obj, long j5, double d5);

        public abstract void zza(Object obj, long j5, float f5);

        public final void zza(Object obj, long j5, int i5) {
            this.zza.putInt(obj, j5, i5);
        }

        public final void zza(Object obj, long j5, long j6) {
            this.zza.putLong(obj, j5, j6);
        }

        public abstract void zza(Object obj, long j5, boolean z4);

        public final boolean zza() {
            Unsafe unsafe = this.zza;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("arrayBaseOffset", Class.class);
                cls.getMethod("arrayIndexScale", Class.class);
                Class<?> cls2 = Long.TYPE;
                cls.getMethod("getInt", Object.class, cls2);
                cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
                cls.getMethod("getLong", Object.class, cls2);
                cls.getMethod("putLong", Object.class, cls2, cls2);
                cls.getMethod("getObject", Object.class, cls2);
                cls.getMethod("putObject", Object.class, cls2, Object.class);
                return true;
            } catch (Throwable th) {
                zzamh.zza(th);
                return false;
            }
        }

        public abstract float zzb(Object obj, long j5);

        public final boolean zzb() {
            Unsafe unsafe = this.zza;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("getLong", Object.class, Long.TYPE);
                return zzamh.zza() != null;
            } catch (Throwable th) {
                zzamh.zza(th);
                return false;
            }
        }

        public abstract boolean zzc(Object obj, long j5);

        public final int zzd(Object obj, long j5) {
            return this.zza.getInt(obj, j5);
        }

        public final long zze(Object obj, long j5) {
            return this.zza.getLong(obj, j5);
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzamh$zzc */
    /* loaded from: classes.dex */
    private static final class zzc extends zzb {
        zzc(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzb
        public final double zza(Object obj, long j5) {
            return Double.longBitsToDouble(zze(obj, j5));
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzb
        public final void zza(Object obj, long j5, byte b5) {
            if (zzamh.zza) {
                zzamh.zzc(obj, j5, b5);
            } else {
                zzamh.zzd(obj, j5, b5);
            }
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzb
        public final void zza(Object obj, long j5, double d5) {
            zza(obj, j5, Double.doubleToLongBits(d5));
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzb
        public final void zza(Object obj, long j5, float f5) {
            zza(obj, j5, Float.floatToIntBits(f5));
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzb
        public final void zza(Object obj, long j5, boolean z4) {
            if (zzamh.zza) {
                zzamh.zza(obj, j5, z4);
            } else {
                zzamh.zzb(obj, j5, z4);
            }
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzb
        public final float zzb(Object obj, long j5) {
            return Float.intBitsToFloat(zzd(obj, j5));
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzb
        public final boolean zzc(Object obj, long j5) {
            return zzamh.zza ? zzamh.zzf(obj, j5) : zzamh.zzg(obj, j5);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d1  */
    static {
        /*
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            java.lang.Class<double[]> r1 = double[].class
            java.lang.Class<float[]> r2 = float[].class
            java.lang.Class<long[]> r3 = long[].class
            java.lang.Class<int[]> r4 = int[].class
            java.lang.Class<boolean[]> r5 = boolean[].class
            sun.misc.Unsafe r6 = zzb()
            com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzb = r6
            java.lang.Class r7 = com.google.android.gms.internal.p001firebaseauthapi.zzahj.zza()
            com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzc = r7
            java.lang.Class r7 = java.lang.Long.TYPE
            boolean r7 = zzd(r7)
            com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzd = r7
            java.lang.Class r8 = java.lang.Integer.TYPE
            boolean r8 = zzd(r8)
            com.google.android.gms.internal.p001firebaseauthapi.zzamh.zze = r8
            if (r6 == 0) goto L3a
            if (r7 == 0) goto L32
            com.google.android.gms.internal.firebase-auth-api.zzamh$zzc r7 = new com.google.android.gms.internal.firebase-auth-api.zzamh$zzc
            r7.<init>(r6)
            goto L3b
        L32:
            if (r8 == 0) goto L3a
            com.google.android.gms.internal.firebase-auth-api.zzamh$zza r7 = new com.google.android.gms.internal.firebase-auth-api.zzamh$zza
            r7.<init>(r6)
            goto L3b
        L3a:
            r7 = 0
        L3b:
            com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzf = r7
            r6 = 0
            if (r7 != 0) goto L42
            r8 = 0
            goto L46
        L42:
            boolean r8 = r7.zzb()
        L46:
            com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzg = r8
            if (r7 != 0) goto L4c
            r8 = 0
            goto L50
        L4c:
            boolean r8 = r7.zza()
        L50:
            com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzh = r8
            java.lang.Class<byte[]> r8 = byte[].class
            int r8 = zzb(r8)
            long r8 = (long) r8
            com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzi = r8
            int r10 = zzb(r5)
            long r10 = (long) r10
            com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzj = r10
            int r5 = zzc(r5)
            long r10 = (long) r5
            com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzk = r10
            int r5 = zzb(r4)
            long r10 = (long) r5
            com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzl = r10
            int r4 = zzc(r4)
            long r4 = (long) r4
            com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzm = r4
            int r4 = zzb(r3)
            long r4 = (long) r4
            com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzn = r4
            int r3 = zzc(r3)
            long r3 = (long) r3
            com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzo = r3
            int r3 = zzb(r2)
            long r3 = (long) r3
            com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzp = r3
            int r2 = zzc(r2)
            long r2 = (long) r2
            com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzq = r2
            int r2 = zzb(r1)
            long r2 = (long) r2
            com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzr = r2
            int r1 = zzc(r1)
            long r1 = (long) r1
            com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzs = r1
            int r1 = zzb(r0)
            long r1 = (long) r1
            com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzt = r1
            int r0 = zzc(r0)
            long r0 = (long) r0
            com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzu = r0
            java.lang.reflect.Field r0 = zze()
            if (r0 == 0) goto Lbf
            if (r7 != 0) goto Lb8
            goto Lbf
        Lb8:
            sun.misc.Unsafe r1 = r7.zza
            long r0 = r1.objectFieldOffset(r0)
            goto Lc1
        Lbf:
            r0 = -1
        Lc1:
            com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzv = r0
            r0 = 7
            long r0 = r0 & r8
            int r1 = (int) r0
            com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzw = r1
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto Ld2
            r6 = 1
        Ld2:
            com.google.android.gms.internal.p001firebaseauthapi.zzamh.zza = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p001firebaseauthapi.zzamh.<clinit>():void");
    }

    private zzamh() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double zza(Object obj, long j5) {
        return zzf.zza(obj, j5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T zza(Class<T> cls) {
        try {
            return (T) zzb.allocateInstance(cls);
        } catch (InstantiationException e5) {
            throw new IllegalStateException(e5);
        }
    }

    static /* synthetic */ Field zza() {
        return zze();
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(Object obj, long j5, double d5) {
        zzf.zza(obj, j5, d5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(Object obj, long j5, float f5) {
        zzf.zza(obj, j5, f5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(Object obj, long j5, int i5) {
        zzf.zza(obj, j5, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(Object obj, long j5, long j6) {
        zzf.zza(obj, j5, j6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(Object obj, long j5, Object obj2) {
        zzf.zza.putObject(obj, j5, obj2);
    }

    static /* synthetic */ void zza(Object obj, long j5, boolean z4) {
        zzc(obj, j5, z4 ? (byte) 1 : (byte) 0);
    }

    static /* synthetic */ void zza(Throwable th) {
        Logger logger = Logger.getLogger(zzamh.class.getName());
        Level level = Level.WARNING;
        String valueOf = String.valueOf(th);
        logger.logp(level, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: " + valueOf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(byte[] bArr, long j5, byte b5) {
        zzf.zza((Object) bArr, zzi + j5, b5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float zzb(Object obj, long j5) {
        return zzf.zzb(obj, j5);
    }

    private static int zzb(Class<?> cls) {
        if (zzh) {
            return zzf.zza.arrayBaseOffset(cls);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Unsafe zzb() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzamj());
        } catch (Throwable unused) {
            return null;
        }
    }

    static /* synthetic */ void zzb(Object obj, long j5, boolean z4) {
        zzd(obj, j5, z4 ? (byte) 1 : (byte) 0);
    }

    private static int zzc(Class<?> cls) {
        if (zzh) {
            return zzf.zza.arrayIndexScale(cls);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(Object obj, long j5) {
        return zzf.zzd(obj, j5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzc(Object obj, long j5, byte b5) {
        long j6 = (-4) & j5;
        int zzc2 = zzc(obj, j6);
        int i5 = ((~((int) j5)) & 3) << 3;
        zza(obj, j6, ((255 & b5) << i5) | (zzc2 & (~(255 << i5))));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzc(Object obj, long j5, boolean z4) {
        zzf.zza(obj, j5, z4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzc() {
        return zzh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zzd(Object obj, long j5) {
        return zzf.zze(obj, j5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzd(Object obj, long j5, byte b5) {
        long j6 = (-4) & j5;
        int i5 = (((int) j5) & 3) << 3;
        zza(obj, j6, ((255 & b5) << i5) | (zzc(obj, j6) & (~(255 << i5))));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzd() {
        return zzg;
    }

    private static boolean zzd(Class<?> cls) {
        try {
            Class<?> cls2 = zzc;
            Class<?> cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class<?> cls4 = Integer.TYPE;
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
    public static Object zze(Object obj, long j5) {
        return zzf.zza.getObject(obj, j5);
    }

    private static Field zze() {
        Field zza2 = zza(Buffer.class, "effectiveDirectAddress");
        if (zza2 != null) {
            return zza2;
        }
        Field zza3 = zza(Buffer.class, "address");
        if (zza3 == null || zza3.getType() != Long.TYPE) {
            return null;
        }
        return zza3;
    }

    static /* synthetic */ boolean zzf(Object obj, long j5) {
        return ((byte) (zzc(obj, (-4) & j5) >>> ((int) (((~j5) & 3) << 3)))) != 0;
    }

    static /* synthetic */ boolean zzg(Object obj, long j5) {
        return ((byte) (zzc(obj, (-4) & j5) >>> ((int) ((j5 & 3) << 3)))) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzh(Object obj, long j5) {
        return zzf.zzc(obj, j5);
    }
}
