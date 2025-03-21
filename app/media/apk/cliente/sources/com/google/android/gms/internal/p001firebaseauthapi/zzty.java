package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzaja;
import java.io.InputStream;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzty  reason: invalid package */
/* loaded from: classes.dex */
public final class zzty extends zzaja<zzty, zza> implements zzakm {
    private static final zzty zzc;
    private static volatile zzakx<zzty> zzd;
    private int zze;
    private zzahm zzf = zzahm.zza;
    private zzvi zzg;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzty$zza */
    /* loaded from: classes.dex */
    public static final class zza extends zzaja.zzb<zzty, zza> implements zzakm {
        private zza() {
            super(zzty.zzc);
        }

        /* synthetic */ zza(zzua zzuaVar) {
            this();
        }

        public final zza zza() {
            zzh();
            ((zzty) this.zza).zzd();
            return this;
        }

        public final zza zza(zzahm zzahmVar) {
            zzh();
            ((zzty) this.zza).zza(zzahmVar);
            return this;
        }

        public final zza zza(zzvi zzviVar) {
            zzh();
            ((zzty) this.zza).zza(zzviVar);
            return this;
        }
    }

    static {
        zzty zztyVar = new zzty();
        zzc = zztyVar;
        zzaja.zza(zzty.class, zztyVar);
    }

    private zzty() {
    }

    public static zza zza() {
        return zzc.zzl();
    }

    public static zzty zza(InputStream inputStream, zzaip zzaipVar) {
        return (zzty) zzaja.zza(zzc, inputStream, zzaipVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzahm zzahmVar) {
        zzahmVar.getClass();
        this.zzf = zzahmVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzvi zzviVar) {
        zzviVar.getClass();
        this.zzg = zzviVar;
        this.zze |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzd() {
        this.zzg = null;
        this.zze &= -2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaja
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzua.zza[i5 - 1]) {
            case 1:
                return new zzty();
            case 2:
                return new zza(null);
            case 3:
                return zzaja.zza(zzc, "\u0000\u0002\u0000\u0001\u0002\u0003\u0002\u0000\u0000\u0000\u0002\n\u0003ဉ\u0000", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzty> zzakxVar = zzd;
                if (zzakxVar == null) {
                    synchronized (zzty.class) {
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

    public final zzahm zzc() {
        return this.zzf;
    }
}
