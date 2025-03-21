package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzaja;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuf  reason: invalid package */
/* loaded from: classes.dex */
public final class zzuf extends zzaja<zzuf, zza> implements zzakm {
    private static final zzuf zzc;
    private static volatile zzakx<zzuf> zzd;
    private int zze;
    private zzui zzf;
    private int zzg;
    private int zzh;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuf$zza */
    /* loaded from: classes.dex */
    public static final class zza extends zzaja.zzb<zzuf, zza> implements zzakm {
        private zza() {
            super(zzuf.zzc);
        }

        /* synthetic */ zza(zzug zzugVar) {
            this();
        }

        public final zza zza(int i5) {
            zzh();
            ((zzuf) this.zza).zza(i5);
            return this;
        }

        public final zza zza(zzui zzuiVar) {
            zzh();
            ((zzuf) this.zza).zza(zzuiVar);
            return this;
        }
    }

    static {
        zzuf zzufVar = new zzuf();
        zzc = zzufVar;
        zzaja.zza(zzuf.class, zzufVar);
    }

    private zzuf() {
    }

    public static zzuf zza(zzahm zzahmVar, zzaip zzaipVar) {
        return (zzuf) zzaja.zza(zzc, zzahmVar, zzaipVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(int i5) {
        this.zzg = i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzui zzuiVar) {
        zzuiVar.getClass();
        this.zzf = zzuiVar;
        this.zze |= 1;
    }

    public static zza zzc() {
        return zzc.zzl();
    }

    public static zzuf zze() {
        return zzc;
    }

    public final int zza() {
        return this.zzg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaja
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzug.zza[i5 - 1]) {
            case 1:
                return new zzuf();
            case 2:
                return new zza(null);
            case 3:
                return zzaja.zza(zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b\u0003\u000b", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzuf> zzakxVar = zzd;
                if (zzakxVar == null) {
                    synchronized (zzuf.class) {
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
        return this.zzh;
    }

    public final zzui zzf() {
        zzui zzuiVar = this.zzf;
        return zzuiVar == null ? zzui.zze() : zzuiVar;
    }
}
