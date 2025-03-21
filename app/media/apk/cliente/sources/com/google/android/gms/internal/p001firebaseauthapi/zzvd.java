package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzaja;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvd  reason: invalid package */
/* loaded from: classes.dex */
public final class zzvd extends zzaja<zzvd, zza> implements zzakm {
    private static final zzvd zzc;
    private static volatile zzakx<zzvd> zzd;
    private String zze = "";
    private zzahm zzf = zzahm.zza;
    private int zzg;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvd$zza */
    /* loaded from: classes.dex */
    public static final class zza extends zzaja.zzb<zzvd, zza> implements zzakm {
        private zza() {
            super(zzvd.zzc);
        }

        /* synthetic */ zza(zzvc zzvcVar) {
            this();
        }

        public final zza zza(zzahm zzahmVar) {
            zzh();
            ((zzvd) this.zza).zza(zzahmVar);
            return this;
        }

        public final zza zza(zzvt zzvtVar) {
            zzh();
            ((zzvd) this.zza).zza(zzvtVar);
            return this;
        }

        public final zza zza(String str) {
            zzh();
            ((zzvd) this.zza).zza(str);
            return this;
        }
    }

    static {
        zzvd zzvdVar = new zzvd();
        zzc = zzvdVar;
        zzaja.zza(zzvd.class, zzvdVar);
    }

    private zzvd() {
    }

    public static zza zza() {
        return zzc.zzl();
    }

    public static zzvd zza(byte[] bArr, zzaip zzaipVar) {
        return (zzvd) zzaja.zza(zzc, bArr, zzaipVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzahm zzahmVar) {
        zzahmVar.getClass();
        this.zzf = zzahmVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzvt zzvtVar) {
        this.zzg = zzvtVar.zza();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(String str) {
        str.getClass();
        this.zze = str;
    }

    public static zzvd zzc() {
        return zzc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaja
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzvc.zza[i5 - 1]) {
            case 1:
                return new zzvd();
            case 2:
                return new zza(null);
            case 3:
                return zzaja.zza(zzc, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzvd> zzakxVar = zzd;
                if (zzakxVar == null) {
                    synchronized (zzvd.class) {
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

    public final zzvt zzd() {
        zzvt zza2 = zzvt.zza(this.zzg);
        return zza2 == null ? zzvt.UNRECOGNIZED : zza2;
    }

    public final zzahm zze() {
        return this.zzf;
    }

    public final String zzf() {
        return this.zze;
    }
}
