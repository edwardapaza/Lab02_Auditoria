package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzaja;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztp  reason: invalid package */
/* loaded from: classes.dex */
public final class zztp extends zzaja<zztp, zza> implements zzakm {
    private static final zztp zzc;
    private static volatile zzakx<zztp> zzd;
    private int zze;
    private zztw zzf;
    private zztk zzg;
    private int zzh;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zztp$zza */
    /* loaded from: classes.dex */
    public static final class zza extends zzaja.zzb<zztp, zza> implements zzakm {
        private zza() {
            super(zztp.zzc);
        }

        /* synthetic */ zza(zztq zztqVar) {
            this();
        }

        public final zza zza(zztj zztjVar) {
            zzh();
            ((zztp) this.zza).zza(zztjVar);
            return this;
        }

        public final zza zza(zztk zztkVar) {
            zzh();
            ((zztp) this.zza).zza(zztkVar);
            return this;
        }

        public final zza zza(zztw zztwVar) {
            zzh();
            ((zztp) this.zza).zza(zztwVar);
            return this;
        }
    }

    static {
        zztp zztpVar = new zztp();
        zzc = zztpVar;
        zzaja.zza(zztp.class, zztpVar);
    }

    private zztp() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zztj zztjVar) {
        this.zzh = zztjVar.zza();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zztk zztkVar) {
        zztkVar.getClass();
        this.zzg = zztkVar;
        this.zze |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zztw zztwVar) {
        zztwVar.getClass();
        this.zzf = zztwVar;
        this.zze |= 1;
    }

    public static zza zzc() {
        return zzc.zzl();
    }

    public static zztp zze() {
        return zzc;
    }

    public final zztj zza() {
        zztj zza2 = zztj.zza(this.zzh);
        return zza2 == null ? zztj.UNRECOGNIZED : zza2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaja
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zztq.zza[i5 - 1]) {
            case 1:
                return new zztp();
            case 2:
                return new zza(null);
            case 3:
                return zzaja.zza(zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\f", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzakx<zztp> zzakxVar = zzd;
                if (zzakxVar == null) {
                    synchronized (zztp.class) {
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

    public final zztk zzb() {
        zztk zztkVar = this.zzg;
        return zztkVar == null ? zztk.zzc() : zztkVar;
    }

    public final zztw zzf() {
        zztw zztwVar = this.zzf;
        return zztwVar == null ? zztw.zzc() : zztwVar;
    }
}
