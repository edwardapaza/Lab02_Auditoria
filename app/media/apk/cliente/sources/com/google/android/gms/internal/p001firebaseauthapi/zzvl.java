package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzaja;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvl  reason: invalid package */
/* loaded from: classes.dex */
public final class zzvl extends zzaja<zzvl, zza> implements zzakm {
    private static final zzvl zzc;
    private static volatile zzakx<zzvl> zzd;
    private int zze;
    private int zzf;
    private zzvm zzg;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvl$zza */
    /* loaded from: classes.dex */
    public static final class zza extends zzaja.zzb<zzvl, zza> implements zzakm {
        private zza() {
            super(zzvl.zzc);
        }

        /* synthetic */ zza(zzvk zzvkVar) {
            this();
        }

        public final zza zza(zzvm zzvmVar) {
            zzh();
            ((zzvl) this.zza).zza(zzvmVar);
            return this;
        }
    }

    static {
        zzvl zzvlVar = new zzvl();
        zzc = zzvlVar;
        zzaja.zza(zzvl.class, zzvlVar);
    }

    private zzvl() {
    }

    public static zzvl zza(zzahm zzahmVar, zzaip zzaipVar) {
        return (zzvl) zzaja.zza(zzc, zzahmVar, zzaipVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzvm zzvmVar) {
        zzvmVar.getClass();
        this.zzg = zzvmVar;
        this.zze |= 1;
    }

    public static zza zzb() {
        return zzc.zzl();
    }

    public static zzakx<zzvl> zze() {
        return (zzakx) zzc.zza(zzaja.zze.zzg, (Object) null, (Object) null);
    }

    public final int zza() {
        return this.zzf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaja
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzvk.zza[i5 - 1]) {
            case 1:
                return new zzvl();
            case 2:
                return new zza(null);
            case 3:
                return zzaja.zza(zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzvl> zzakxVar = zzd;
                if (zzakxVar == null) {
                    synchronized (zzvl.class) {
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

    public final zzvm zzd() {
        zzvm zzvmVar = this.zzg;
        return zzvmVar == null ? zzvm.zzc() : zzvmVar;
    }
}
