package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzaja;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztw  reason: invalid package */
/* loaded from: classes.dex */
public final class zztw extends zzaja<zztw, zza> implements zzakm {
    private static final zztw zzc;
    private static volatile zzakx<zztw> zzd;
    private int zze;
    private int zzf;
    private zzahm zzg = zzahm.zza;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zztw$zza */
    /* loaded from: classes.dex */
    public static final class zza extends zzaja.zzb<zztw, zza> implements zzakm {
        private zza() {
            super(zztw.zzc);
        }

        /* synthetic */ zza(zztv zztvVar) {
            this();
        }

        public final zza zza(zzahm zzahmVar) {
            zzh();
            ((zztw) this.zza).zza(zzahmVar);
            return this;
        }

        public final zza zza(zztx zztxVar) {
            zzh();
            ((zztw) this.zza).zza(zztxVar);
            return this;
        }

        public final zza zza(zzuc zzucVar) {
            zzh();
            ((zztw) this.zza).zza(zzucVar);
            return this;
        }
    }

    static {
        zztw zztwVar = new zztw();
        zzc = zztwVar;
        zzaja.zza(zztw.class, zztwVar);
    }

    private zztw() {
    }

    public static zza zza() {
        return zzc.zzl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzahm zzahmVar) {
        zzahmVar.getClass();
        this.zzg = zzahmVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zztx zztxVar) {
        this.zze = zztxVar.zza();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzuc zzucVar) {
        this.zzf = zzucVar.zza();
    }

    public static zztw zzc() {
        return zzc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaja
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zztv.zza[i5 - 1]) {
            case 1:
                return new zztw();
            case 2:
                return new zza(null);
            case 3:
                return zzaja.zza(zzc, "\u0000\u0003\u0000\u0000\u0001\u000b\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u000b\n", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzakx<zztw> zzakxVar = zzd;
                if (zzakxVar == null) {
                    synchronized (zztw.class) {
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

    public final zztx zzd() {
        zztx zza2 = zztx.zza(this.zze);
        return zza2 == null ? zztx.UNRECOGNIZED : zza2;
    }

    public final zzuc zze() {
        zzuc zza2 = zzuc.zza(this.zzf);
        return zza2 == null ? zzuc.UNRECOGNIZED : zza2;
    }

    public final zzahm zzf() {
        return this.zzg;
    }
}
