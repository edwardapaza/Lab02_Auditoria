package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzaja;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuo  reason: invalid package */
/* loaded from: classes.dex */
public final class zzuo extends zzaja<zzuo, zza> implements zzakm {
    private static final zzuo zzc;
    private static volatile zzakx<zzuo> zzd;
    private int zze;
    private zzus zzf;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuo$zza */
    /* loaded from: classes.dex */
    public static final class zza extends zzaja.zzb<zzuo, zza> implements zzakm {
        private zza() {
            super(zzuo.zzc);
        }

        /* synthetic */ zza(zzuq zzuqVar) {
            this();
        }

        public final zza zza(zzus zzusVar) {
            zzh();
            ((zzuo) this.zza).zza(zzusVar);
            return this;
        }
    }

    static {
        zzuo zzuoVar = new zzuo();
        zzc = zzuoVar;
        zzaja.zza(zzuo.class, zzuoVar);
    }

    private zzuo() {
    }

    public static zza zza() {
        return zzc.zzl();
    }

    public static zzuo zza(zzahm zzahmVar, zzaip zzaipVar) {
        return (zzuo) zzaja.zza(zzc, zzahmVar, zzaipVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzus zzusVar) {
        zzusVar.getClass();
        this.zzf = zzusVar;
        this.zze |= 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaja
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzuq.zza[i5 - 1]) {
            case 1:
                return new zzuo();
            case 2:
                return new zza(null);
            case 3:
                return zzaja.zza(zzc, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzuo> zzakxVar = zzd;
                if (zzakxVar == null) {
                    synchronized (zzuo.class) {
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

    public final zzus zzc() {
        zzus zzusVar = this.zzf;
        return zzusVar == null ? zzus.zzf() : zzusVar;
    }
}
