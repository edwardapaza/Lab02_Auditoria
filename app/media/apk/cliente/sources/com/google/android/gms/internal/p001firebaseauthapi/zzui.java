package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzaja;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzui  reason: invalid package */
/* loaded from: classes.dex */
public final class zzui extends zzaja<zzui, zza> implements zzakm {
    private static final zzui zzc;
    private static volatile zzakx<zzui> zzd;
    private int zze;
    private int zzf;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzui$zza */
    /* loaded from: classes.dex */
    public static final class zza extends zzaja.zzb<zzui, zza> implements zzakm {
        private zza() {
            super(zzui.zzc);
        }

        /* synthetic */ zza(zzuh zzuhVar) {
            this();
        }

        public final zza zza(int i5) {
            zzh();
            ((zzui) this.zza).zza(i5);
            return this;
        }

        public final zza zza(zzuc zzucVar) {
            zzh();
            ((zzui) this.zza).zza(zzucVar);
            return this;
        }
    }

    static {
        zzui zzuiVar = new zzui();
        zzc = zzuiVar;
        zzaja.zza(zzui.class, zzuiVar);
    }

    private zzui() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(int i5) {
        this.zzf = i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzuc zzucVar) {
        this.zze = zzucVar.zza();
    }

    public static zza zzc() {
        return zzc.zzl();
    }

    public static zzui zze() {
        return zzc;
    }

    public final int zza() {
        return this.zzf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaja
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzuh.zza[i5 - 1]) {
            case 1:
                return new zzui();
            case 2:
                return new zza(null);
            case 3:
                return zzaja.zza(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzui> zzakxVar = zzd;
                if (zzakxVar == null) {
                    synchronized (zzui.class) {
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

    public final zzuc zzb() {
        zzuc zza2 = zzuc.zza(this.zze);
        return zza2 == null ? zzuc.UNRECOGNIZED : zza2;
    }
}
