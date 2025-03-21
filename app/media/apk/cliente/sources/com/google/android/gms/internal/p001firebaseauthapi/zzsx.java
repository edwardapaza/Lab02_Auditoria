package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzaja;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsx  reason: invalid package */
/* loaded from: classes.dex */
public final class zzsx extends zzaja<zzsx, zza> implements zzakm {
    private static final zzsx zzc;
    private static volatile zzakx<zzsx> zzd;
    private int zze;
    private zzahm zzf = zzahm.zza;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsx$zza */
    /* loaded from: classes.dex */
    public static final class zza extends zzaja.zzb<zzsx, zza> implements zzakm {
        private zza() {
            super(zzsx.zzc);
        }

        /* synthetic */ zza(zzsy zzsyVar) {
            this();
        }

        public final zza zza(zzahm zzahmVar) {
            zzh();
            ((zzsx) this.zza).zza(zzahmVar);
            return this;
        }
    }

    static {
        zzsx zzsxVar = new zzsx();
        zzc = zzsxVar;
        zzaja.zza(zzsx.class, zzsxVar);
    }

    private zzsx() {
    }

    public static zzsx zza(zzahm zzahmVar, zzaip zzaipVar) {
        return (zzsx) zzaja.zza(zzc, zzahmVar, zzaipVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzahm zzahmVar) {
        zzahmVar.getClass();
        this.zzf = zzahmVar;
    }

    public static zza zzb() {
        return zzc.zzl();
    }

    public static zzakx<zzsx> zze() {
        return (zzakx) zzc.zza(zzaja.zze.zzg, (Object) null, (Object) null);
    }

    public final int zza() {
        return this.zze;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaja
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzsy.zza[i5 - 1]) {
            case 1:
                return new zzsx();
            case 2:
                return new zza(null);
            case 3:
                return zzaja.zza(zzc, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzsx> zzakxVar = zzd;
                if (zzakxVar == null) {
                    synchronized (zzsx.class) {
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

    public final zzahm zzd() {
        return this.zzf;
    }
}
