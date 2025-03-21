package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzaja;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsw  reason: invalid package */
/* loaded from: classes.dex */
public final class zzsw extends zzaja<zzsw, zza> implements zzakm {
    private static final zzsw zzc;
    private static volatile zzakx<zzsw> zzd;
    private int zze;
    private int zzf;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsw$zza */
    /* loaded from: classes.dex */
    public static final class zza extends zzaja.zzb<zzsw, zza> implements zzakm {
        private zza() {
            super(zzsw.zzc);
        }

        /* synthetic */ zza(zzsv zzsvVar) {
            this();
        }

        public final zza zza(int i5) {
            zzh();
            ((zzsw) this.zza).zza(i5);
            return this;
        }
    }

    static {
        zzsw zzswVar = new zzsw();
        zzc = zzswVar;
        zzaja.zza(zzsw.class, zzswVar);
    }

    private zzsw() {
    }

    public static zzsw zza(zzahm zzahmVar, zzaip zzaipVar) {
        return (zzsw) zzaja.zza(zzc, zzahmVar, zzaipVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(int i5) {
        this.zze = i5;
    }

    public static zza zzc() {
        return zzc.zzl();
    }

    public final int zza() {
        return this.zze;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaja
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzsv.zza[i5 - 1]) {
            case 1:
                return new zzsw();
            case 2:
                return new zza(null);
            case 3:
                return zzaja.zza(zzc, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzsw> zzakxVar = zzd;
                if (zzakxVar == null) {
                    synchronized (zzsw.class) {
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

    public final int zzb() {
        return this.zzf;
    }
}
