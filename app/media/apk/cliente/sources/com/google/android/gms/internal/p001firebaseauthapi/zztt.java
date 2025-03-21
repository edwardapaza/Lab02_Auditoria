package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzaja;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztt  reason: invalid package */
/* loaded from: classes.dex */
public final class zztt extends zzaja<zztt, zza> implements zzakm {
    private static final zztt zzc;
    private static volatile zzakx<zztt> zzd;
    private int zze;
    private int zzf;
    private zztp zzg;
    private zzahm zzh;
    private zzahm zzi;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zztt$zza */
    /* loaded from: classes.dex */
    public static final class zza extends zzaja.zzb<zztt, zza> implements zzakm {
        private zza() {
            super(zztt.zzc);
        }

        /* synthetic */ zza(zztu zztuVar) {
            this();
        }

        public final zza zza(int i5) {
            zzh();
            ((zztt) this.zza).zza(0);
            return this;
        }

        public final zza zza(zzahm zzahmVar) {
            zzh();
            ((zztt) this.zza).zza(zzahmVar);
            return this;
        }

        public final zza zza(zztp zztpVar) {
            zzh();
            ((zztt) this.zza).zza(zztpVar);
            return this;
        }

        public final zza zzb(zzahm zzahmVar) {
            zzh();
            ((zztt) this.zza).zzb(zzahmVar);
            return this;
        }
    }

    static {
        zztt zzttVar = new zztt();
        zzc = zzttVar;
        zzaja.zza(zztt.class, zzttVar);
    }

    private zztt() {
        zzahm zzahmVar = zzahm.zza;
        this.zzh = zzahmVar;
        this.zzi = zzahmVar;
    }

    public static zztt zza(zzahm zzahmVar, zzaip zzaipVar) {
        return (zztt) zzaja.zza(zzc, zzahmVar, zzaipVar);
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
    public final void zza(zztp zztpVar) {
        zztpVar.getClass();
        this.zzg = zztpVar;
        this.zze |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzb(zzahm zzahmVar) {
        zzahmVar.getClass();
        this.zzi = zzahmVar;
    }

    public static zza zzc() {
        return zzc.zzl();
    }

    public static zztt zze() {
        return zzc;
    }

    public final int zza() {
        return this.zzf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaja
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zztu.zza[i5 - 1]) {
            case 1:
                return new zztt();
            case 2:
                return new zza(null);
            case 3:
                return zzaja.zza(zzc, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n\u0004\n", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
            case 4:
                return zzc;
            case 5:
                zzakx<zztt> zzakxVar = zzd;
                if (zzakxVar == null) {
                    synchronized (zztt.class) {
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

    public final zztp zzb() {
        zztp zztpVar = this.zzg;
        return zztpVar == null ? zztp.zze() : zztpVar;
    }

    public final zzahm zzf() {
        return this.zzh;
    }

    public final zzahm zzg() {
        return this.zzi;
    }
}
