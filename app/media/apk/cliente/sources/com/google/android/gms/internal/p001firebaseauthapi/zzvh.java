package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzaja;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvh  reason: invalid package */
/* loaded from: classes.dex */
public final class zzvh extends zzaja<zzvh, zzb> implements zzakm {
    private static final zzvh zzc;
    private static volatile zzakx<zzvh> zzd;
    private int zze;
    private zzajg<zza> zzf = zzaja.zzo();

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvh$zza */
    /* loaded from: classes.dex */
    public static final class zza extends zzaja<zza, C0041zza> implements zzakm {
        private static final zza zzc;
        private static volatile zzakx<zza> zzd;
        private int zze;
        private zzux zzf;
        private int zzg;
        private int zzh;
        private int zzi;

        /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvh$zza$zza  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0041zza extends zzaja.zzb<zza, C0041zza> implements zzakm {
            private C0041zza() {
                super(zza.zzc);
            }

            /* synthetic */ C0041zza(zzvg zzvgVar) {
                this();
            }

            public final C0041zza zza(int i5) {
                zzh();
                ((zza) this.zza).zza(i5);
                return this;
            }

            public final C0041zza zza(zzux zzuxVar) {
                zzh();
                ((zza) this.zza).zza(zzuxVar);
                return this;
            }

            public final C0041zza zza(zzvb zzvbVar) {
                zzh();
                ((zza) this.zza).zza(zzvbVar);
                return this;
            }

            public final C0041zza zza(zzvt zzvtVar) {
                zzh();
                ((zza) this.zza).zza(zzvtVar);
                return this;
            }
        }

        static {
            zza zzaVar = new zza();
            zzc = zzaVar;
            zzaja.zza(zza.class, zzaVar);
        }

        private zza() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(int i5) {
            this.zzh = i5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzux zzuxVar) {
            zzuxVar.getClass();
            this.zzf = zzuxVar;
            this.zze |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzvb zzvbVar) {
            this.zzg = zzvbVar.zza();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzvt zzvtVar) {
            this.zzi = zzvtVar.zza();
        }

        public static C0041zza zzd() {
            return zzc.zzl();
        }

        public final int zza() {
            return this.zzh;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaja
        public final Object zza(int i5, Object obj, Object obj2) {
            switch (zzvg.zza[i5 - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0041zza(null);
                case 3:
                    return zzaja.zza(zzc, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002\f\u0003\u000b\u0004\f", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzc;
                case 5:
                    zzakx<zza> zzakxVar = zzd;
                    if (zzakxVar == null) {
                        synchronized (zza.class) {
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

        public final zzux zzb() {
            zzux zzuxVar = this.zzf;
            return zzuxVar == null ? zzux.zzd() : zzuxVar;
        }

        public final zzvb zzc() {
            zzvb zza = zzvb.zza(this.zzg);
            return zza == null ? zzvb.UNRECOGNIZED : zza;
        }

        public final zzvt zzf() {
            zzvt zza = zzvt.zza(this.zzi);
            return zza == null ? zzvt.UNRECOGNIZED : zza;
        }

        public final boolean zzg() {
            return (this.zze & 1) != 0;
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvh$zzb */
    /* loaded from: classes.dex */
    public static final class zzb extends zzaja.zzb<zzvh, zzb> implements zzakm {
        private zzb() {
            super(zzvh.zzc);
        }

        /* synthetic */ zzb(zzvg zzvgVar) {
            this();
        }

        public final int zza() {
            return ((zzvh) this.zza).zza();
        }

        public final zzb zza(int i5) {
            zzh();
            ((zzvh) this.zza).zzc(i5);
            return this;
        }

        public final zzb zza(zza zzaVar) {
            zzh();
            ((zzvh) this.zza).zza(zzaVar);
            return this;
        }

        public final zza zzb(int i5) {
            return ((zzvh) this.zza).zza(i5);
        }

        public final List<zza> zzb() {
            return Collections.unmodifiableList(((zzvh) this.zza).zze());
        }
    }

    static {
        zzvh zzvhVar = new zzvh();
        zzc = zzvhVar;
        zzaja.zza(zzvh.class, zzvhVar);
    }

    private zzvh() {
    }

    public static zzvh zza(InputStream inputStream, zzaip zzaipVar) {
        return (zzvh) zzaja.zza(zzc, inputStream, zzaipVar);
    }

    public static zzvh zza(byte[] bArr, zzaip zzaipVar) {
        return (zzvh) zzaja.zza(zzc, bArr, zzaipVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zza zzaVar) {
        zzaVar.getClass();
        zzajg<zza> zzajgVar = this.zzf;
        if (!zzajgVar.zzc()) {
            this.zzf = zzaja.zza(zzajgVar);
        }
        this.zzf.add(zzaVar);
    }

    public static zzb zzc() {
        return zzc.zzl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzc(int i5) {
        this.zze = i5;
    }

    public final int zza() {
        return this.zzf.size();
    }

    public final zza zza(int i5) {
        return this.zzf.get(i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaja
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzvg.zza[i5 - 1]) {
            case 1:
                return new zzvh();
            case 2:
                return new zzb(null);
            case 3:
                return zzaja.zza(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zze", "zzf", zza.class});
            case 4:
                return zzc;
            case 5:
                zzakx<zzvh> zzakxVar = zzd;
                if (zzakxVar == null) {
                    synchronized (zzvh.class) {
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

    public final int zzb() {
        return this.zze;
    }

    public final List<zza> zze() {
        return this.zzf;
    }
}
