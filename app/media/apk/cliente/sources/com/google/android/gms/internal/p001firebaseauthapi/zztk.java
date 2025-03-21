package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzaja;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztk  reason: invalid package */
/* loaded from: classes.dex */
public final class zztk extends zzaja<zztk, zza> implements zzakm {
    private static final zztk zzc;
    private static volatile zzakx<zztk> zzd;
    private int zze;
    private zzvd zzf;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zztk$zza */
    /* loaded from: classes.dex */
    public static final class zza extends zzaja.zzb<zztk, zza> implements zzakm {
        private zza() {
            super(zztk.zzc);
        }

        /* synthetic */ zza(zztm zztmVar) {
            this();
        }

        public final zza zza(zzvd zzvdVar) {
            zzh();
            ((zztk) this.zza).zza(zzvdVar);
            return this;
        }
    }

    static {
        zztk zztkVar = new zztk();
        zzc = zztkVar;
        zzaja.zza(zztk.class, zztkVar);
    }

    private zztk() {
    }

    public static zza zza() {
        return zzc.zzl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzvd zzvdVar) {
        zzvdVar.getClass();
        this.zzf = zzvdVar;
        this.zze |= 1;
    }

    public static zztk zzc() {
        return zzc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaja
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zztm.zza[i5 - 1]) {
            case 1:
                return new zztk();
            case 2:
                return new zza(null);
            case 3:
                return zzaja.zza(zzc, "\u0000\u0001\u0000\u0001\u0002\u0002\u0001\u0000\u0000\u0000\u0002ဉ\u0000", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzakx<zztk> zzakxVar = zzd;
                if (zzakxVar == null) {
                    synchronized (zztk.class) {
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

    public final zzvd zzd() {
        zzvd zzvdVar = this.zzf;
        return zzvdVar == null ? zzvd.zzc() : zzvdVar;
    }
}
