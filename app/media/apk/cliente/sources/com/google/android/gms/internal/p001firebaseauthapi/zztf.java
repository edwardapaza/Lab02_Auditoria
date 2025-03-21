package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzaja;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztf  reason: invalid package */
/* loaded from: classes.dex */
public final class zztf extends zzaja<zztf, zza> implements zzakm {
    private static final zztf zzc;
    private static volatile zzakx<zztf> zzd;
    private int zze;
    private zzahm zzf = zzahm.zza;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zztf$zza */
    /* loaded from: classes.dex */
    public static final class zza extends zzaja.zzb<zztf, zza> implements zzakm {
        private zza() {
            super(zztf.zzc);
        }

        /* synthetic */ zza(zztg zztgVar) {
            this();
        }

        public final zza zza(zzahm zzahmVar) {
            zzh();
            ((zztf) this.zza).zza(zzahmVar);
            return this;
        }
    }

    static {
        zztf zztfVar = new zztf();
        zzc = zztfVar;
        zzaja.zza(zztf.class, zztfVar);
    }

    private zztf() {
    }

    public static zztf zza(zzahm zzahmVar, zzaip zzaipVar) {
        return (zztf) zzaja.zza(zzc, zzahmVar, zzaipVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzahm zzahmVar) {
        zzahmVar.getClass();
        this.zzf = zzahmVar;
    }

    public static zza zzb() {
        return zzc.zzl();
    }

    public static zzakx<zztf> zze() {
        return (zzakx) zzc.zza(zzaja.zze.zzg, (Object) null, (Object) null);
    }

    public final int zza() {
        return this.zze;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaja
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zztg.zza[i5 - 1]) {
            case 1:
                return new zztf();
            case 2:
                return new zza(null);
            case 3:
                return zzaja.zza(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzakx<zztf> zzakxVar = zzd;
                if (zzakxVar == null) {
                    synchronized (zztf.class) {
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

    public final zzahm zzd() {
        return this.zzf;
    }
}
