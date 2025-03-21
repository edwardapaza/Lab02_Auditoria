package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzaja;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvm  reason: invalid package */
/* loaded from: classes.dex */
public final class zzvm extends zzaja<zzvm, zza> implements zzakm {
    private static final zzvm zzc;
    private static volatile zzakx<zzvm> zzd;
    private String zze = "";

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvm$zza */
    /* loaded from: classes.dex */
    public static final class zza extends zzaja.zzb<zzvm, zza> implements zzakm {
        private zza() {
            super(zzvm.zzc);
        }

        /* synthetic */ zza(zzvn zzvnVar) {
            this();
        }

        public final zza zza(String str) {
            zzh();
            ((zzvm) this.zza).zza(str);
            return this;
        }
    }

    static {
        zzvm zzvmVar = new zzvm();
        zzc = zzvmVar;
        zzaja.zza(zzvm.class, zzvmVar);
    }

    private zzvm() {
    }

    public static zza zza() {
        return zzc.zzl();
    }

    public static zzvm zza(zzahm zzahmVar, zzaip zzaipVar) {
        return (zzvm) zzaja.zza(zzc, zzahmVar, zzaipVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(String str) {
        str.getClass();
        this.zze = str;
    }

    public static zzvm zzc() {
        return zzc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaja
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzvn.zza[i5 - 1]) {
            case 1:
                return new zzvm();
            case 2:
                return new zza(null);
            case 3:
                return zzaja.zza(zzc, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zze"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzvm> zzakxVar = zzd;
                if (zzakxVar == null) {
                    synchronized (zzvm.class) {
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

    public final String zzd() {
        return this.zze;
    }
}
