package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzaja;
@Deprecated
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzve  reason: invalid package */
/* loaded from: classes.dex */
public final class zzve extends zzaja<zzve, zza> implements zzakm {
    private static final zzve zzc;
    private static volatile zzakx<zzve> zzd;
    private int zzg;
    private boolean zzh;
    private String zze = "";
    private String zzf = "";
    private String zzi = "";

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzve$zza */
    /* loaded from: classes.dex */
    public static final class zza extends zzaja.zzb<zzve, zza> implements zzakm {
        private zza() {
            super(zzve.zzc);
        }

        /* synthetic */ zza(zzvf zzvfVar) {
            this();
        }
    }

    static {
        zzve zzveVar = new zzve();
        zzc = zzveVar;
        zzaja.zza(zzve.class, zzveVar);
    }

    private zzve() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaja
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzvf.zza[i5 - 1]) {
            case 1:
                return new zzve();
            case 2:
                return new zza(null);
            case 3:
                return zzaja.zza(zzc, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u000b\u0004\u0007\u0005Ȉ", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzve> zzakxVar = zzd;
                if (zzakxVar == null) {
                    synchronized (zzve.class) {
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
