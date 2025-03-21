package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzaja;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzue  reason: invalid package */
/* loaded from: classes.dex */
public final class zzue extends zzaja<zzue, zza> implements zzakm {
    private static final zzue zzc;
    private static volatile zzakx<zzue> zzd;
    private int zze;
    private int zzf;
    private zzui zzg;
    private zzahm zzh = zzahm.zza;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzue$zza */
    /* loaded from: classes.dex */
    public static final class zza extends zzaja.zzb<zzue, zza> implements zzakm {
        private zza() {
            super(zzue.zzc);
        }

        /* synthetic */ zza(zzud zzudVar) {
            this();
        }

        public final zza zza(int i5) {
            zzh();
            ((zzue) this.zza).zza(i5);
            return this;
        }

        public final zza zza(zzahm zzahmVar) {
            zzh();
            ((zzue) this.zza).zza(zzahmVar);
            return this;
        }

        public final zza zza(zzui zzuiVar) {
            zzh();
            ((zzue) this.zza).zza(zzuiVar);
            return this;
        }
    }

    static {
        zzue zzueVar = new zzue();
        zzc = zzueVar;
        zzaja.zza(zzue.class, zzueVar);
    }

    private zzue() {
    }

    public static zzue zza(zzahm zzahmVar, zzaip zzaipVar) {
        return (zzue) zzaja.zza(zzc, zzahmVar, zzaipVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(int i5) {
        this.zzf = i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzahm zzahmVar) {
        zzahmVar.getClass();
        this.zzh = zzahmVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzui zzuiVar) {
        zzuiVar.getClass();
        this.zzg = zzuiVar;
        this.zze |= 1;
    }

    public static zza zzb() {
        return zzc.zzl();
    }

    public static zzue zzd() {
        return zzc;
    }

    public final int zza() {
        return this.zzf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaja
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzud.zza[i5 - 1]) {
            case 1:
                return new zzue();
            case 2:
                return new zza(null);
            case 3:
                return zzaja.zza(zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzue> zzakxVar = zzd;
                if (zzakxVar == null) {
                    synchronized (zzue.class) {
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

    public final zzui zze() {
        zzui zzuiVar = this.zzg;
        return zzuiVar == null ? zzui.zze() : zzuiVar;
    }

    public final zzahm zzf() {
        return this.zzh;
    }
}
