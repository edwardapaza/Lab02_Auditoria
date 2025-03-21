package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzaja;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsk  reason: invalid package */
/* loaded from: classes.dex */
public final class zzsk extends zzaja<zzsk, zza> implements zzakm {
    private static final zzsk zzc;
    private static volatile zzakx<zzsk> zzd;
    private int zze;
    private zzsl zzf;
    private int zzg;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsk$zza */
    /* loaded from: classes.dex */
    public static final class zza extends zzaja.zzb<zzsk, zza> implements zzakm {
        private zza() {
            super(zzsk.zzc);
        }

        /* synthetic */ zza(zzsj zzsjVar) {
            this();
        }

        public final zza zza(int i5) {
            zzh();
            ((zzsk) this.zza).zza(i5);
            return this;
        }

        public final zza zza(zzsl zzslVar) {
            zzh();
            ((zzsk) this.zza).zza(zzslVar);
            return this;
        }
    }

    static {
        zzsk zzskVar = new zzsk();
        zzc = zzskVar;
        zzaja.zza(zzsk.class, zzskVar);
    }

    private zzsk() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(int i5) {
        this.zzg = i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzsl zzslVar) {
        zzslVar.getClass();
        this.zzf = zzslVar;
        this.zze |= 1;
    }

    public static zza zzb() {
        return zzc.zzl();
    }

    public static zzsk zzd() {
        return zzc;
    }

    public final int zza() {
        return this.zzg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaja
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzsj.zza[i5 - 1]) {
            case 1:
                return new zzsk();
            case 2:
                return new zza(null);
            case 3:
                return zzaja.zza(zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzsk> zzakxVar = zzd;
                if (zzakxVar == null) {
                    synchronized (zzsk.class) {
                        zzakxVar = zzd;
                        if (zzakxVar == null) {
                            zzakxVar = new zzaja.zza<>(zzc);
                            zzd = zzakxVar;
                        }
                    }
                }
                return zzakxVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final zzsl zze() {
        zzsl zzslVar = this.zzf;
        return zzslVar == null ? zzsl.zzd() : zzslVar;
    }
}
