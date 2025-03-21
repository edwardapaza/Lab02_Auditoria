package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.api.a;
import i2.a0;
import i2.d0;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaig  reason: invalid package */
/* loaded from: classes.dex */
public final class zzaig implements zzald {
    private final zzaib zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zzaig(zzaib zzaibVar) {
        zzaib zzaibVar2 = (zzaib) zzajc.zza(zzaibVar, "input");
        this.zza = zzaibVar2;
        zzaibVar2.zzd = this;
    }

    public static zzaig zza(zzaib zzaibVar) {
        zzaig zzaigVar = zzaibVar.zzd;
        return zzaigVar != null ? zzaigVar : new zzaig(zzaibVar);
    }

    private final <T> T zza(zzalc<T> zzalcVar, zzaip zzaipVar) {
        T zza = zzalcVar.zza();
        zzc(zza, zzalcVar, zzaipVar);
        zzalcVar.zzc(zza);
        return zza;
    }

    private final Object zza(zzamo zzamoVar, Class<?> cls, zzaip zzaipVar) {
        switch (zzaij.zza[zzamoVar.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzs());
            case 2:
                return zzp();
            case 3:
                return Double.valueOf(zza());
            case 4:
                return Integer.valueOf(zze());
            case 5:
                return Integer.valueOf(zzf());
            case 6:
                return Long.valueOf(zzk());
            case 7:
                return Float.valueOf(zzb());
            case 8:
                return Integer.valueOf(zzg());
            case d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                return Long.valueOf(zzl());
            case d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                zzb(2);
                return zzb(zzaky.zza().zza((Class) cls), zzaipVar);
            case 11:
                return Integer.valueOf(zzh());
            case a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                return Long.valueOf(zzm());
            case 13:
                return Integer.valueOf(zzi());
            case 14:
                return Long.valueOf(zzn());
            case 15:
                return zzr();
            case 16:
                return Integer.valueOf(zzj());
            case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                return Long.valueOf(zzo());
            default:
                throw new IllegalArgumentException("unsupported field type.");
        }
    }

    private final void zza(int i5) {
        if (this.zza.zzc() != i5) {
            throw zzajj.zzi();
        }
    }

    private final void zza(List<String> list, boolean z4) {
        int zzi;
        int zzi2;
        if ((this.zzb & 7) != 2) {
            throw zzajj.zza();
        }
        if (!(list instanceof zzajq) || z4) {
            do {
                list.add(z4 ? zzr() : zzq());
                if (this.zza.zzt()) {
                    return;
                }
                zzi = this.zza.zzi();
            } while (zzi == this.zzb);
            this.zzd = zzi;
            return;
        }
        zzajq zzajqVar = (zzajq) list;
        do {
            zzajqVar.zza(zzp());
            if (this.zza.zzt()) {
                return;
            }
            zzi2 = this.zza.zzi();
        } while (zzi2 == this.zzb);
        this.zzd = zzi2;
    }

    private final <T> T zzb(zzalc<T> zzalcVar, zzaip zzaipVar) {
        T zza = zzalcVar.zza();
        zzd(zza, zzalcVar, zzaipVar);
        zzalcVar.zzc(zza);
        return zza;
    }

    private final void zzb(int i5) {
        if ((this.zzb & 7) != i5) {
            throw zzajj.zza();
        }
    }

    private static void zzc(int i5) {
        if ((i5 & 3) != 0) {
            throw zzajj.zzg();
        }
    }

    private final <T> void zzc(T t5, zzalc<T> zzalcVar, zzaip zzaipVar) {
        int i5 = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            zzalcVar.zza(t5, this, zzaipVar);
            if (this.zzb == this.zzc) {
                return;
            }
            throw zzajj.zzg();
        } finally {
            this.zzc = i5;
        }
    }

    private static void zzd(int i5) {
        if ((i5 & 7) != 0) {
            throw zzajj.zzg();
        }
    }

    private final <T> void zzd(T t5, zzalc<T> zzalcVar, zzaip zzaipVar) {
        zzaib zzaibVar;
        int zzj = this.zza.zzj();
        zzaib zzaibVar2 = this.zza;
        if (zzaibVar2.zza >= zzaibVar2.zzb) {
            throw new zzajj("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int zza = zzaibVar2.zza(zzj);
        this.zza.zza++;
        zzalcVar.zza(t5, this, zzaipVar);
        this.zza.zzb(0);
        zzaibVar.zza--;
        this.zza.zzc(zza);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzald
    public final double zza() {
        zzb(1);
        return this.zza.zza();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzald
    public final <T> void zza(T t5, zzalc<T> zzalcVar, zzaip zzaipVar) {
        zzb(3);
        zzc(t5, zzalcVar, zzaipVar);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzald
    public final void zza(List<Boolean> list) {
        int zzi;
        int zzi2;
        if (!(list instanceof zzahk)) {
            int i5 = this.zzb & 7;
            if (i5 == 0) {
                do {
                    list.add(Boolean.valueOf(this.zza.zzu()));
                    if (this.zza.zzt()) {
                        return;
                    }
                    zzi = this.zza.zzi();
                } while (zzi == this.zzb);
                this.zzd = zzi;
                return;
            } else if (i5 != 2) {
                throw zzajj.zza();
            } else {
                int zzc = this.zza.zzc() + this.zza.zzj();
                do {
                    list.add(Boolean.valueOf(this.zza.zzu()));
                } while (this.zza.zzc() < zzc);
                zza(zzc);
                return;
            }
        }
        zzahk zzahkVar = (zzahk) list;
        int i6 = this.zzb & 7;
        if (i6 == 0) {
            do {
                zzahkVar.zza(this.zza.zzu());
                if (this.zza.zzt()) {
                    return;
                }
                zzi2 = this.zza.zzi();
            } while (zzi2 == this.zzb);
            this.zzd = zzi2;
        } else if (i6 != 2) {
            throw zzajj.zza();
        } else {
            int zzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                zzahkVar.zza(this.zza.zzu());
            } while (this.zza.zzc() < zzc2);
            zza(zzc2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzald
    @Deprecated
    public final <T> void zza(List<T> list, zzalc<T> zzalcVar, zzaip zzaipVar) {
        int zzi;
        int i5 = this.zzb;
        if ((i5 & 7) != 3) {
            throw zzajj.zza();
        }
        do {
            list.add(zza(zzalcVar, zzaipVar));
            if (this.zza.zzt() || this.zzd != 0) {
                return;
            }
            zzi = this.zza.zzi();
        } while (zzi == i5);
        this.zzd = zzi;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x005b, code lost:
        r8.put(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0063, code lost:
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzald
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <K, V> void zza(java.util.Map<K, V> r8, com.google.android.gms.internal.p001firebaseauthapi.zzakf<K, V> r9, com.google.android.gms.internal.p001firebaseauthapi.zzaip r10) {
        /*
            r7 = this;
            r0 = 2
            r7.zzb(r0)
            com.google.android.gms.internal.firebase-auth-api.zzaib r1 = r7.zza
            int r1 = r1.zzj()
            com.google.android.gms.internal.firebase-auth-api.zzaib r2 = r7.zza
            int r1 = r2.zza(r1)
            K r2 = r9.zzb
            V r3 = r9.zzd
        L14:
            int r4 = r7.zzc()     // Catch: java.lang.Throwable -> L64
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L5b
            com.google.android.gms.internal.firebase-auth-api.zzaib r5 = r7.zza     // Catch: java.lang.Throwable -> L64
            boolean r5 = r5.zzt()     // Catch: java.lang.Throwable -> L64
            if (r5 != 0) goto L5b
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L46
            if (r4 == r0) goto L39
            boolean r4 = r7.zzt()     // Catch: com.google.android.gms.internal.p001firebaseauthapi.zzaji -> L4e java.lang.Throwable -> L64
            if (r4 == 0) goto L33
            goto L14
        L33:
            com.google.android.gms.internal.firebase-auth-api.zzajj r4 = new com.google.android.gms.internal.firebase-auth-api.zzajj     // Catch: com.google.android.gms.internal.p001firebaseauthapi.zzaji -> L4e java.lang.Throwable -> L64
            r4.<init>(r6)     // Catch: com.google.android.gms.internal.p001firebaseauthapi.zzaji -> L4e java.lang.Throwable -> L64
            throw r4     // Catch: com.google.android.gms.internal.p001firebaseauthapi.zzaji -> L4e java.lang.Throwable -> L64
        L39:
            com.google.android.gms.internal.firebase-auth-api.zzamo r4 = r9.zzc     // Catch: com.google.android.gms.internal.p001firebaseauthapi.zzaji -> L4e java.lang.Throwable -> L64
            V r5 = r9.zzd     // Catch: com.google.android.gms.internal.p001firebaseauthapi.zzaji -> L4e java.lang.Throwable -> L64
            java.lang.Class r5 = r5.getClass()     // Catch: com.google.android.gms.internal.p001firebaseauthapi.zzaji -> L4e java.lang.Throwable -> L64
            java.lang.Object r3 = r7.zza(r4, r5, r10)     // Catch: com.google.android.gms.internal.p001firebaseauthapi.zzaji -> L4e java.lang.Throwable -> L64
            goto L14
        L46:
            com.google.android.gms.internal.firebase-auth-api.zzamo r4 = r9.zza     // Catch: com.google.android.gms.internal.p001firebaseauthapi.zzaji -> L4e java.lang.Throwable -> L64
            r5 = 0
            java.lang.Object r2 = r7.zza(r4, r5, r5)     // Catch: com.google.android.gms.internal.p001firebaseauthapi.zzaji -> L4e java.lang.Throwable -> L64
            goto L14
        L4e:
            boolean r4 = r7.zzt()     // Catch: java.lang.Throwable -> L64
            if (r4 == 0) goto L55
            goto L14
        L55:
            com.google.android.gms.internal.firebase-auth-api.zzajj r8 = new com.google.android.gms.internal.firebase-auth-api.zzajj     // Catch: java.lang.Throwable -> L64
            r8.<init>(r6)     // Catch: java.lang.Throwable -> L64
            throw r8     // Catch: java.lang.Throwable -> L64
        L5b:
            r8.put(r2, r3)     // Catch: java.lang.Throwable -> L64
            com.google.android.gms.internal.firebase-auth-api.zzaib r8 = r7.zza
            r8.zzc(r1)
            return
        L64:
            r8 = move-exception
            com.google.android.gms.internal.firebase-auth-api.zzaib r9 = r7.zza
            r9.zzc(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p001firebaseauthapi.zzaig.zza(java.util.Map, com.google.android.gms.internal.firebase-auth-api.zzakf, com.google.android.gms.internal.firebase-auth-api.zzaip):void");
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzald
    public final float zzb() {
        zzb(5);
        return this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzald
    public final <T> void zzb(T t5, zzalc<T> zzalcVar, zzaip zzaipVar) {
        zzb(2);
        zzd(t5, zzalcVar, zzaipVar);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzald
    public final void zzb(List<zzahm> list) {
        int zzi;
        if ((this.zzb & 7) != 2) {
            throw zzajj.zza();
        }
        do {
            list.add(zzp());
            if (this.zza.zzt()) {
                return;
            }
            zzi = this.zza.zzi();
        } while (zzi == this.zzb);
        this.zzd = zzi;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzald
    public final <T> void zzb(List<T> list, zzalc<T> zzalcVar, zzaip zzaipVar) {
        int zzi;
        int i5 = this.zzb;
        if ((i5 & 7) != 2) {
            throw zzajj.zza();
        }
        do {
            list.add(zzb(zzalcVar, zzaipVar));
            if (this.zza.zzt() || this.zzd != 0) {
                return;
            }
            zzi = this.zza.zzi();
        } while (zzi == i5);
        this.zzd = zzi;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzald
    public final int zzc() {
        int i5 = this.zzd;
        if (i5 != 0) {
            this.zzb = i5;
            this.zzd = 0;
        } else {
            this.zzb = this.zza.zzi();
        }
        int i6 = this.zzb;
        return (i6 == 0 || i6 == this.zzc) ? a.e.API_PRIORITY_OTHER : i6 >>> 3;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzald
    public final void zzc(List<Double> list) {
        int zzi;
        int zzi2;
        if (!(list instanceof zzain)) {
            int i5 = this.zzb & 7;
            if (i5 == 1) {
                do {
                    list.add(Double.valueOf(this.zza.zza()));
                    if (this.zza.zzt()) {
                        return;
                    }
                    zzi = this.zza.zzi();
                } while (zzi == this.zzb);
                this.zzd = zzi;
                return;
            } else if (i5 != 2) {
                throw zzajj.zza();
            } else {
                int zzj = this.zza.zzj();
                zzd(zzj);
                int zzc = this.zza.zzc() + zzj;
                do {
                    list.add(Double.valueOf(this.zza.zza()));
                } while (this.zza.zzc() < zzc);
                return;
            }
        }
        zzain zzainVar = (zzain) list;
        int i6 = this.zzb & 7;
        if (i6 == 1) {
            do {
                zzainVar.zza(this.zza.zza());
                if (this.zza.zzt()) {
                    return;
                }
                zzi2 = this.zza.zzi();
            } while (zzi2 == this.zzb);
            this.zzd = zzi2;
        } else if (i6 != 2) {
            throw zzajj.zza();
        } else {
            int zzj2 = this.zza.zzj();
            zzd(zzj2);
            int zzc2 = this.zza.zzc() + zzj2;
            do {
                zzainVar.zza(this.zza.zza());
            } while (this.zza.zzc() < zzc2);
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzald
    public final int zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzald
    public final void zzd(List<Integer> list) {
        int zzi;
        int zzi2;
        if (!(list instanceof zzajd)) {
            int i5 = this.zzb & 7;
            if (i5 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzd()));
                    if (this.zza.zzt()) {
                        return;
                    }
                    zzi = this.zza.zzi();
                } while (zzi == this.zzb);
                this.zzd = zzi;
                return;
            } else if (i5 != 2) {
                throw zzajj.zza();
            } else {
                int zzc = this.zza.zzc() + this.zza.zzj();
                do {
                    list.add(Integer.valueOf(this.zza.zzd()));
                } while (this.zza.zzc() < zzc);
                zza(zzc);
                return;
            }
        }
        zzajd zzajdVar = (zzajd) list;
        int i6 = this.zzb & 7;
        if (i6 == 0) {
            do {
                zzajdVar.zzc(this.zza.zzd());
                if (this.zza.zzt()) {
                    return;
                }
                zzi2 = this.zza.zzi();
            } while (zzi2 == this.zzb);
            this.zzd = zzi2;
        } else if (i6 != 2) {
            throw zzajj.zza();
        } else {
            int zzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                zzajdVar.zzc(this.zza.zzd());
            } while (this.zza.zzc() < zzc2);
            zza(zzc2);
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzald
    public final int zze() {
        zzb(0);
        return this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzald
    public final void zze(List<Integer> list) {
        int zzi;
        int zzi2;
        if (!(list instanceof zzajd)) {
            int i5 = this.zzb & 7;
            if (i5 == 2) {
                int zzj = this.zza.zzj();
                zzc(zzj);
                int zzc = this.zza.zzc() + zzj;
                do {
                    list.add(Integer.valueOf(this.zza.zze()));
                } while (this.zza.zzc() < zzc);
                return;
            } else if (i5 != 5) {
                throw zzajj.zza();
            } else {
                do {
                    list.add(Integer.valueOf(this.zza.zze()));
                    if (this.zza.zzt()) {
                        return;
                    }
                    zzi = this.zza.zzi();
                } while (zzi == this.zzb);
                this.zzd = zzi;
                return;
            }
        }
        zzajd zzajdVar = (zzajd) list;
        int i6 = this.zzb & 7;
        if (i6 == 2) {
            int zzj2 = this.zza.zzj();
            zzc(zzj2);
            int zzc2 = this.zza.zzc() + zzj2;
            do {
                zzajdVar.zzc(this.zza.zze());
            } while (this.zza.zzc() < zzc2);
        } else if (i6 != 5) {
            throw zzajj.zza();
        } else {
            do {
                zzajdVar.zzc(this.zza.zze());
                if (this.zza.zzt()) {
                    return;
                }
                zzi2 = this.zza.zzi();
            } while (zzi2 == this.zzb);
            this.zzd = zzi2;
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzald
    public final int zzf() {
        zzb(5);
        return this.zza.zze();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzald
    public final void zzf(List<Long> list) {
        int zzi;
        int zzi2;
        if (!(list instanceof zzajz)) {
            int i5 = this.zzb & 7;
            if (i5 == 1) {
                do {
                    list.add(Long.valueOf(this.zza.zzk()));
                    if (this.zza.zzt()) {
                        return;
                    }
                    zzi = this.zza.zzi();
                } while (zzi == this.zzb);
                this.zzd = zzi;
                return;
            } else if (i5 != 2) {
                throw zzajj.zza();
            } else {
                int zzj = this.zza.zzj();
                zzd(zzj);
                int zzc = this.zza.zzc() + zzj;
                do {
                    list.add(Long.valueOf(this.zza.zzk()));
                } while (this.zza.zzc() < zzc);
                return;
            }
        }
        zzajz zzajzVar = (zzajz) list;
        int i6 = this.zzb & 7;
        if (i6 == 1) {
            do {
                zzajzVar.zza(this.zza.zzk());
                if (this.zza.zzt()) {
                    return;
                }
                zzi2 = this.zza.zzi();
            } while (zzi2 == this.zzb);
            this.zzd = zzi2;
        } else if (i6 != 2) {
            throw zzajj.zza();
        } else {
            int zzj2 = this.zza.zzj();
            zzd(zzj2);
            int zzc2 = this.zza.zzc() + zzj2;
            do {
                zzajzVar.zza(this.zza.zzk());
            } while (this.zza.zzc() < zzc2);
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzald
    public final int zzg() {
        zzb(0);
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzald
    public final void zzg(List<Float> list) {
        int zzi;
        int zzi2;
        if (!(list instanceof zzaiy)) {
            int i5 = this.zzb & 7;
            if (i5 == 2) {
                int zzj = this.zza.zzj();
                zzc(zzj);
                int zzc = this.zza.zzc() + zzj;
                do {
                    list.add(Float.valueOf(this.zza.zzb()));
                } while (this.zza.zzc() < zzc);
                return;
            } else if (i5 != 5) {
                throw zzajj.zza();
            } else {
                do {
                    list.add(Float.valueOf(this.zza.zzb()));
                    if (this.zza.zzt()) {
                        return;
                    }
                    zzi = this.zza.zzi();
                } while (zzi == this.zzb);
                this.zzd = zzi;
                return;
            }
        }
        zzaiy zzaiyVar = (zzaiy) list;
        int i6 = this.zzb & 7;
        if (i6 == 2) {
            int zzj2 = this.zza.zzj();
            zzc(zzj2);
            int zzc2 = this.zza.zzc() + zzj2;
            do {
                zzaiyVar.zza(this.zza.zzb());
            } while (this.zza.zzc() < zzc2);
        } else if (i6 != 5) {
            throw zzajj.zza();
        } else {
            do {
                zzaiyVar.zza(this.zza.zzb());
                if (this.zza.zzt()) {
                    return;
                }
                zzi2 = this.zza.zzi();
            } while (zzi2 == this.zzb);
            this.zzd = zzi2;
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzald
    public final int zzh() {
        zzb(5);
        return this.zza.zzg();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzald
    public final void zzh(List<Integer> list) {
        int zzi;
        int zzi2;
        if (!(list instanceof zzajd)) {
            int i5 = this.zzb & 7;
            if (i5 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzf()));
                    if (this.zza.zzt()) {
                        return;
                    }
                    zzi = this.zza.zzi();
                } while (zzi == this.zzb);
                this.zzd = zzi;
                return;
            } else if (i5 != 2) {
                throw zzajj.zza();
            } else {
                int zzc = this.zza.zzc() + this.zza.zzj();
                do {
                    list.add(Integer.valueOf(this.zza.zzf()));
                } while (this.zza.zzc() < zzc);
                zza(zzc);
                return;
            }
        }
        zzajd zzajdVar = (zzajd) list;
        int i6 = this.zzb & 7;
        if (i6 == 0) {
            do {
                zzajdVar.zzc(this.zza.zzf());
                if (this.zza.zzt()) {
                    return;
                }
                zzi2 = this.zza.zzi();
            } while (zzi2 == this.zzb);
            this.zzd = zzi2;
        } else if (i6 != 2) {
            throw zzajj.zza();
        } else {
            int zzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                zzajdVar.zzc(this.zza.zzf());
            } while (this.zza.zzc() < zzc2);
            zza(zzc2);
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzald
    public final int zzi() {
        zzb(0);
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzald
    public final void zzi(List<Long> list) {
        int zzi;
        int zzi2;
        if (!(list instanceof zzajz)) {
            int i5 = this.zzb & 7;
            if (i5 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzl()));
                    if (this.zza.zzt()) {
                        return;
                    }
                    zzi = this.zza.zzi();
                } while (zzi == this.zzb);
                this.zzd = zzi;
                return;
            } else if (i5 != 2) {
                throw zzajj.zza();
            } else {
                int zzc = this.zza.zzc() + this.zza.zzj();
                do {
                    list.add(Long.valueOf(this.zza.zzl()));
                } while (this.zza.zzc() < zzc);
                zza(zzc);
                return;
            }
        }
        zzajz zzajzVar = (zzajz) list;
        int i6 = this.zzb & 7;
        if (i6 == 0) {
            do {
                zzajzVar.zza(this.zza.zzl());
                if (this.zza.zzt()) {
                    return;
                }
                zzi2 = this.zza.zzi();
            } while (zzi2 == this.zzb);
            this.zzd = zzi2;
        } else if (i6 != 2) {
            throw zzajj.zza();
        } else {
            int zzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                zzajzVar.zza(this.zza.zzl());
            } while (this.zza.zzc() < zzc2);
            zza(zzc2);
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzald
    public final int zzj() {
        zzb(0);
        return this.zza.zzj();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzald
    public final void zzj(List<Integer> list) {
        int zzi;
        int zzi2;
        if (!(list instanceof zzajd)) {
            int i5 = this.zzb & 7;
            if (i5 == 2) {
                int zzj = this.zza.zzj();
                zzc(zzj);
                int zzc = this.zza.zzc() + zzj;
                do {
                    list.add(Integer.valueOf(this.zza.zzg()));
                } while (this.zza.zzc() < zzc);
                return;
            } else if (i5 != 5) {
                throw zzajj.zza();
            } else {
                do {
                    list.add(Integer.valueOf(this.zza.zzg()));
                    if (this.zza.zzt()) {
                        return;
                    }
                    zzi = this.zza.zzi();
                } while (zzi == this.zzb);
                this.zzd = zzi;
                return;
            }
        }
        zzajd zzajdVar = (zzajd) list;
        int i6 = this.zzb & 7;
        if (i6 == 2) {
            int zzj2 = this.zza.zzj();
            zzc(zzj2);
            int zzc2 = this.zza.zzc() + zzj2;
            do {
                zzajdVar.zzc(this.zza.zzg());
            } while (this.zza.zzc() < zzc2);
        } else if (i6 != 5) {
            throw zzajj.zza();
        } else {
            do {
                zzajdVar.zzc(this.zza.zzg());
                if (this.zza.zzt()) {
                    return;
                }
                zzi2 = this.zza.zzi();
            } while (zzi2 == this.zzb);
            this.zzd = zzi2;
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzald
    public final long zzk() {
        zzb(1);
        return this.zza.zzk();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzald
    public final void zzk(List<Long> list) {
        int zzi;
        int zzi2;
        if (!(list instanceof zzajz)) {
            int i5 = this.zzb & 7;
            if (i5 == 1) {
                do {
                    list.add(Long.valueOf(this.zza.zzn()));
                    if (this.zza.zzt()) {
                        return;
                    }
                    zzi = this.zza.zzi();
                } while (zzi == this.zzb);
                this.zzd = zzi;
                return;
            } else if (i5 != 2) {
                throw zzajj.zza();
            } else {
                int zzj = this.zza.zzj();
                zzd(zzj);
                int zzc = this.zza.zzc() + zzj;
                do {
                    list.add(Long.valueOf(this.zza.zzn()));
                } while (this.zza.zzc() < zzc);
                return;
            }
        }
        zzajz zzajzVar = (zzajz) list;
        int i6 = this.zzb & 7;
        if (i6 == 1) {
            do {
                zzajzVar.zza(this.zza.zzn());
                if (this.zza.zzt()) {
                    return;
                }
                zzi2 = this.zza.zzi();
            } while (zzi2 == this.zzb);
            this.zzd = zzi2;
        } else if (i6 != 2) {
            throw zzajj.zza();
        } else {
            int zzj2 = this.zza.zzj();
            zzd(zzj2);
            int zzc2 = this.zza.zzc() + zzj2;
            do {
                zzajzVar.zza(this.zza.zzn());
            } while (this.zza.zzc() < zzc2);
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzald
    public final long zzl() {
        zzb(0);
        return this.zza.zzl();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzald
    public final void zzl(List<Integer> list) {
        int zzi;
        int zzi2;
        if (!(list instanceof zzajd)) {
            int i5 = this.zzb & 7;
            if (i5 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzh()));
                    if (this.zza.zzt()) {
                        return;
                    }
                    zzi = this.zza.zzi();
                } while (zzi == this.zzb);
                this.zzd = zzi;
                return;
            } else if (i5 != 2) {
                throw zzajj.zza();
            } else {
                int zzc = this.zza.zzc() + this.zza.zzj();
                do {
                    list.add(Integer.valueOf(this.zza.zzh()));
                } while (this.zza.zzc() < zzc);
                zza(zzc);
                return;
            }
        }
        zzajd zzajdVar = (zzajd) list;
        int i6 = this.zzb & 7;
        if (i6 == 0) {
            do {
                zzajdVar.zzc(this.zza.zzh());
                if (this.zza.zzt()) {
                    return;
                }
                zzi2 = this.zza.zzi();
            } while (zzi2 == this.zzb);
            this.zzd = zzi2;
        } else if (i6 != 2) {
            throw zzajj.zza();
        } else {
            int zzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                zzajdVar.zzc(this.zza.zzh());
            } while (this.zza.zzc() < zzc2);
            zza(zzc2);
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzald
    public final long zzm() {
        zzb(1);
        return this.zza.zzn();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzald
    public final void zzm(List<Long> list) {
        int zzi;
        int zzi2;
        if (!(list instanceof zzajz)) {
            int i5 = this.zzb & 7;
            if (i5 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzo()));
                    if (this.zza.zzt()) {
                        return;
                    }
                    zzi = this.zza.zzi();
                } while (zzi == this.zzb);
                this.zzd = zzi;
                return;
            } else if (i5 != 2) {
                throw zzajj.zza();
            } else {
                int zzc = this.zza.zzc() + this.zza.zzj();
                do {
                    list.add(Long.valueOf(this.zza.zzo()));
                } while (this.zza.zzc() < zzc);
                zza(zzc);
                return;
            }
        }
        zzajz zzajzVar = (zzajz) list;
        int i6 = this.zzb & 7;
        if (i6 == 0) {
            do {
                zzajzVar.zza(this.zza.zzo());
                if (this.zza.zzt()) {
                    return;
                }
                zzi2 = this.zza.zzi();
            } while (zzi2 == this.zzb);
            this.zzd = zzi2;
        } else if (i6 != 2) {
            throw zzajj.zza();
        } else {
            int zzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                zzajzVar.zza(this.zza.zzo());
            } while (this.zza.zzc() < zzc2);
            zza(zzc2);
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzald
    public final long zzn() {
        zzb(0);
        return this.zza.zzo();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzald
    public final void zzn(List<String> list) {
        zza(list, false);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzald
    public final long zzo() {
        zzb(0);
        return this.zza.zzp();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzald
    public final void zzo(List<String> list) {
        zza(list, true);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzald
    public final zzahm zzp() {
        zzb(2);
        return this.zza.zzq();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzald
    public final void zzp(List<Integer> list) {
        int zzi;
        int zzi2;
        if (!(list instanceof zzajd)) {
            int i5 = this.zzb & 7;
            if (i5 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzj()));
                    if (this.zza.zzt()) {
                        return;
                    }
                    zzi = this.zza.zzi();
                } while (zzi == this.zzb);
                this.zzd = zzi;
                return;
            } else if (i5 != 2) {
                throw zzajj.zza();
            } else {
                int zzc = this.zza.zzc() + this.zza.zzj();
                do {
                    list.add(Integer.valueOf(this.zza.zzj()));
                } while (this.zza.zzc() < zzc);
                zza(zzc);
                return;
            }
        }
        zzajd zzajdVar = (zzajd) list;
        int i6 = this.zzb & 7;
        if (i6 == 0) {
            do {
                zzajdVar.zzc(this.zza.zzj());
                if (this.zza.zzt()) {
                    return;
                }
                zzi2 = this.zza.zzi();
            } while (zzi2 == this.zzb);
            this.zzd = zzi2;
        } else if (i6 != 2) {
            throw zzajj.zza();
        } else {
            int zzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                zzajdVar.zzc(this.zza.zzj());
            } while (this.zza.zzc() < zzc2);
            zza(zzc2);
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzald
    public final String zzq() {
        zzb(2);
        return this.zza.zzr();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzald
    public final void zzq(List<Long> list) {
        int zzi;
        int zzi2;
        if (!(list instanceof zzajz)) {
            int i5 = this.zzb & 7;
            if (i5 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzp()));
                    if (this.zza.zzt()) {
                        return;
                    }
                    zzi = this.zza.zzi();
                } while (zzi == this.zzb);
                this.zzd = zzi;
                return;
            } else if (i5 != 2) {
                throw zzajj.zza();
            } else {
                int zzc = this.zza.zzc() + this.zza.zzj();
                do {
                    list.add(Long.valueOf(this.zza.zzp()));
                } while (this.zza.zzc() < zzc);
                zza(zzc);
                return;
            }
        }
        zzajz zzajzVar = (zzajz) list;
        int i6 = this.zzb & 7;
        if (i6 == 0) {
            do {
                zzajzVar.zza(this.zza.zzp());
                if (this.zza.zzt()) {
                    return;
                }
                zzi2 = this.zza.zzi();
            } while (zzi2 == this.zzb);
            this.zzd = zzi2;
        } else if (i6 != 2) {
            throw zzajj.zza();
        } else {
            int zzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                zzajzVar.zza(this.zza.zzp());
            } while (this.zza.zzc() < zzc2);
            zza(zzc2);
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzald
    public final String zzr() {
        zzb(2);
        return this.zza.zzs();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzald
    public final boolean zzs() {
        zzb(0);
        return this.zza.zzu();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzald
    public final boolean zzt() {
        int i5;
        if (this.zza.zzt() || (i5 = this.zzb) == this.zzc) {
            return false;
        }
        return this.zza.zzd(i5);
    }
}
