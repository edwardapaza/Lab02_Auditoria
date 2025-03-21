package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzaja;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzti  reason: invalid package */
/* loaded from: classes.dex */
public final class zzti extends zzaja<zzti, zza> implements zzakm {
    private static final zzti zzc;
    private static volatile zzakx<zzti> zzd;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzti$zza */
    /* loaded from: classes.dex */
    public static final class zza extends zzaja.zzb<zzti, zza> implements zzakm {
        private zza() {
            super(zzti.zzc);
        }

        /* synthetic */ zza(zzth zzthVar) {
            this();
        }
    }

    static {
        zzti zztiVar = new zzti();
        zzc = zztiVar;
        zzaja.zza(zzti.class, zztiVar);
    }

    private zzti() {
    }

    public static zzti zza(zzahm zzahmVar, zzaip zzaipVar) {
        return (zzti) zzaja.zza(zzc, zzahmVar, zzaipVar);
    }

    public static zzti zzb() {
        return zzc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaja
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzth.zza[i5 - 1]) {
            case 1:
                return new zzti();
            case 2:
                return new zza(null);
            case 3:
                return zzaja.zza(zzc, "\u0000\u0000", (Object[]) null);
            case 4:
                return zzc;
            case 5:
                zzakx<zzti> zzakxVar = zzd;
                if (zzakxVar == null) {
                    synchronized (zzti.class) {
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
