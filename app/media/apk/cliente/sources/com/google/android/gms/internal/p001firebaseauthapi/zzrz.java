package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzaja;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrz  reason: invalid package */
/* loaded from: classes.dex */
public final class zzrz extends zzaja<zzrz, zza> implements zzakm {
    private static final zzrz zzc;
    private static volatile zzakx<zzrz> zzd;
    private int zze;
    private int zzf;
    private zzsc zzg;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrz$zza */
    /* loaded from: classes.dex */
    public static final class zza extends zzaja.zzb<zzrz, zza> implements zzakm {
        private zza() {
            super(zzrz.zzc);
        }

        /* synthetic */ zza(zzsa zzsaVar) {
            this();
        }

        public final zza zza(int i5) {
            zzh();
            ((zzrz) this.zza).zza(i5);
            return this;
        }

        public final zza zza(zzsc zzscVar) {
            zzh();
            ((zzrz) this.zza).zza(zzscVar);
            return this;
        }
    }

    static {
        zzrz zzrzVar = new zzrz();
        zzc = zzrzVar;
        zzaja.zza(zzrz.class, zzrzVar);
    }

    private zzrz() {
    }

    public static zzrz zza(zzahm zzahmVar, zzaip zzaipVar) {
        return (zzrz) zzaja.zza(zzc, zzahmVar, zzaipVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(int i5) {
        this.zzf = i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzsc zzscVar) {
        zzscVar.getClass();
        this.zzg = zzscVar;
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
        switch (zzsa.zza[i5 - 1]) {
            case 1:
                return new zzrz();
            case 2:
                return new zza(null);
            case 3:
                return zzaja.zza(zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzrz> zzakxVar = zzd;
                if (zzakxVar == null) {
                    synchronized (zzrz.class) {
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

    public final zzsc zzd() {
        zzsc zzscVar = this.zzg;
        return zzscVar == null ? zzsc.zzd() : zzscVar;
    }
}
