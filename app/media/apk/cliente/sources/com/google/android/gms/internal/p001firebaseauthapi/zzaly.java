package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzaja;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaly  reason: invalid package */
/* loaded from: classes.dex */
public final class zzaly extends zzaja<zzaly, zza> implements zzakm {
    private static final zzaly zzc;
    private static volatile zzakx<zzaly> zzd;
    private long zze;
    private int zzf;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaly$zza */
    /* loaded from: classes.dex */
    public static final class zza extends zzaja.zzb<zzaly, zza> implements zzakm {
        private zza() {
            super(zzaly.zzc);
        }

        /* synthetic */ zza(zzama zzamaVar) {
            this();
        }

        public final zza zza(int i5) {
            if (!this.zza.zzv()) {
                zzi();
            }
            ((zzaly) this.zza).zza(i5);
            return this;
        }

        public final zza zza(long j5) {
            if (!this.zza.zzv()) {
                zzi();
            }
            ((zzaly) this.zza).zza(j5);
            return this;
        }
    }

    static {
        zzaly zzalyVar = new zzaly();
        zzc = zzalyVar;
        zzaja.zza(zzaly.class, zzalyVar);
    }

    private zzaly() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(int i5) {
        this.zzf = i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(long j5) {
        this.zze = j5;
    }

    public static zza zzc() {
        return zzc.zzl();
    }

    public final int zza() {
        return this.zzf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaja
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzama.zza[i5 - 1]) {
            case 1:
                return new zzaly();
            case 2:
                return new zza(null);
            case 3:
                return zzaja.zza(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0004", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzaly> zzakxVar = zzd;
                if (zzakxVar == null) {
                    synchronized (zzaly.class) {
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

    public final long zzb() {
        return this.zze;
    }
}
