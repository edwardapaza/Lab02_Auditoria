package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzaja;
@Deprecated
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvv  reason: invalid package */
/* loaded from: classes.dex */
public final class zzvv extends zzaja<zzvv, zza> implements zzakm {
    private static final zzvv zzc;
    private static volatile zzakx<zzvv> zzd;
    private String zze = "";
    private zzajg<zzve> zzf = zzaja.zzo();

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvv$zza */
    /* loaded from: classes.dex */
    public static final class zza extends zzaja.zzb<zzvv, zza> implements zzakm {
        private zza() {
            super(zzvv.zzc);
        }

        /* synthetic */ zza(zzvu zzvuVar) {
            this();
        }
    }

    static {
        zzvv zzvvVar = new zzvv();
        zzc = zzvvVar;
        zzaja.zza(zzvv.class, zzvvVar);
    }

    private zzvv() {
    }

    public static zzvv zzb() {
        return zzc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaja
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzvu.zza[i5 - 1]) {
            case 1:
                return new zzvv();
            case 2:
                return new zza(null);
            case 3:
                return zzaja.zza(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zze", "zzf", zzve.class});
            case 4:
                return zzc;
            case 5:
                zzakx<zzvv> zzakxVar = zzd;
                if (zzakxVar == null) {
                    synchronized (zzvv.class) {
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
