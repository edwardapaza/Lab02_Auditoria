package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzaja;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvz  reason: invalid package */
/* loaded from: classes.dex */
public final class zzvz extends zzaja<zzvz, zza> implements zzakm {
    private static final zzvz zzc;
    private static volatile zzakx<zzvz> zzd;
    private int zze;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvz$zza */
    /* loaded from: classes.dex */
    public static final class zza extends zzaja.zzb<zzvz, zza> implements zzakm {
        private zza() {
            super(zzvz.zzc);
        }

        /* synthetic */ zza(zzvy zzvyVar) {
            this();
        }
    }

    static {
        zzvz zzvzVar = new zzvz();
        zzc = zzvzVar;
        zzaja.zza(zzvz.class, zzvzVar);
    }

    private zzvz() {
    }

    public static zzvz zza(zzahm zzahmVar, zzaip zzaipVar) {
        return (zzvz) zzaja.zza(zzc, zzahmVar, zzaipVar);
    }

    public static zzvz zzc() {
        return zzc;
    }

    public final int zza() {
        return this.zze;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaja
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzvy.zza[i5 - 1]) {
            case 1:
                return new zzvz();
            case 2:
                return new zza(null);
            case 3:
                return zzaja.zza(zzc, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zze"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzvz> zzakxVar = zzd;
                if (zzakxVar == null) {
                    synchronized (zzvz.class) {
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
