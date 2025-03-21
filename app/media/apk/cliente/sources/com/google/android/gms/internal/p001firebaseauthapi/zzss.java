package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzaja;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzss  reason: invalid package */
/* loaded from: classes.dex */
public final class zzss extends zzaja<zzss, zza> implements zzakm {
    private static final zzss zzc;
    private static volatile zzakx<zzss> zzd;
    private int zze;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzss$zza */
    /* loaded from: classes.dex */
    public static final class zza extends zzaja.zzb<zzss, zza> implements zzakm {
        private zza() {
            super(zzss.zzc);
        }

        /* synthetic */ zza(zzsr zzsrVar) {
            this();
        }

        public final zza zza(int i5) {
            zzh();
            ((zzss) this.zza).zza(i5);
            return this;
        }
    }

    static {
        zzss zzssVar = new zzss();
        zzc = zzssVar;
        zzaja.zza(zzss.class, zzssVar);
    }

    private zzss() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(int i5) {
        this.zze = i5;
    }

    public static zza zzb() {
        return zzc.zzl();
    }

    public static zzss zzd() {
        return zzc;
    }

    public final int zza() {
        return this.zze;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaja
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzsr.zza[i5 - 1]) {
            case 1:
                return new zzss();
            case 2:
                return new zza(null);
            case 3:
                return zzaja.zza(zzc, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zze"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzss> zzakxVar = zzd;
                if (zzakxVar == null) {
                    synchronized (zzss.class) {
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
}
