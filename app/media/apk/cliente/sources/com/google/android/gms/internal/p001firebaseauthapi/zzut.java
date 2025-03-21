package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzaja;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzut  reason: invalid package */
/* loaded from: classes.dex */
public final class zzut extends zzaja<zzut, zza> implements zzakm {
    private static final zzut zzc;
    private static volatile zzakx<zzut> zzd;
    private int zze;
    private int zzf;
    private zzuw zzg;
    private zzahm zzh = zzahm.zza;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzut$zza */
    /* loaded from: classes.dex */
    public static final class zza extends zzaja.zzb<zzut, zza> implements zzakm {
        private zza() {
            super(zzut.zzc);
        }

        /* synthetic */ zza(zzuu zzuuVar) {
            this();
        }

        public final zza zza(int i5) {
            zzh();
            ((zzut) this.zza).zza(0);
            return this;
        }

        public final zza zza(zzahm zzahmVar) {
            zzh();
            ((zzut) this.zza).zza(zzahmVar);
            return this;
        }

        public final zza zza(zzuw zzuwVar) {
            zzh();
            ((zzut) this.zza).zza(zzuwVar);
            return this;
        }
    }

    static {
        zzut zzutVar = new zzut();
        zzc = zzutVar;
        zzaja.zza(zzut.class, zzutVar);
    }

    private zzut() {
    }

    public static zzut zza(zzahm zzahmVar, zzaip zzaipVar) {
        return (zzut) zzaja.zza(zzc, zzahmVar, zzaipVar);
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
    public final void zza(zzuw zzuwVar) {
        zzuwVar.getClass();
        this.zzg = zzuwVar;
        this.zze |= 1;
    }

    public static zza zzb() {
        return zzc.zzl();
    }

    public final int zza() {
        return this.zzf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaja
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzuu.zza[i5 - 1]) {
            case 1:
                return new zzut();
            case 2:
                return new zza(null);
            case 3:
                return zzaja.zza(zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzut> zzakxVar = zzd;
                if (zzakxVar == null) {
                    synchronized (zzut.class) {
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

    public final zzuw zzd() {
        zzuw zzuwVar = this.zzg;
        return zzuwVar == null ? zzuw.zze() : zzuwVar;
    }

    public final zzahm zze() {
        return this.zzh;
    }

    public final boolean zzf() {
        return (this.zze & 1) != 0;
    }
}
