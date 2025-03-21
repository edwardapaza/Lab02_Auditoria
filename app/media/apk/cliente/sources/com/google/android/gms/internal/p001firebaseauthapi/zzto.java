package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzaja;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzto  reason: invalid package */
/* loaded from: classes.dex */
public final class zzto extends zzaja<zzto, zza> implements zzakm {
    private static final zzto zzc;
    private static volatile zzakx<zzto> zzd;
    private int zze;
    private zztp zzf;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzto$zza */
    /* loaded from: classes.dex */
    public static final class zza extends zzaja.zzb<zzto, zza> implements zzakm {
        private zza() {
            super(zzto.zzc);
        }

        /* synthetic */ zza(zztn zztnVar) {
            this();
        }

        public final zza zza(zztp zztpVar) {
            zzh();
            ((zzto) this.zza).zza(zztpVar);
            return this;
        }
    }

    static {
        zzto zztoVar = new zzto();
        zzc = zztoVar;
        zzaja.zza(zzto.class, zztoVar);
    }

    private zzto() {
    }

    public static zza zza() {
        return zzc.zzl();
    }

    public static zzto zza(zzahm zzahmVar, zzaip zzaipVar) {
        return (zzto) zzaja.zza(zzc, zzahmVar, zzaipVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zztp zztpVar) {
        zztpVar.getClass();
        this.zzf = zztpVar;
        this.zze |= 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaja
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zztn.zza[i5 - 1]) {
            case 1:
                return new zzto();
            case 2:
                return new zza(null);
            case 3:
                return zzaja.zza(zzc, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzto> zzakxVar = zzd;
                if (zzakxVar == null) {
                    synchronized (zzto.class) {
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

    public final zztp zzc() {
        zztp zztpVar = this.zzf;
        return zztpVar == null ? zztp.zze() : zztpVar;
    }
}
