package com.google.android.recaptcha.internal;

import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
final class zzki implements zzkr {
    private final zzke zza;
    private final zzll zzb;
    private final boolean zzc;
    private final zzif zzd;

    private zzki(zzll zzllVar, zzif zzifVar, zzke zzkeVar) {
        this.zzb = zzllVar;
        this.zzc = zzifVar.zzj(zzkeVar);
        this.zzd = zzifVar;
        this.zza = zzkeVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzki zzc(zzll zzllVar, zzif zzifVar, zzke zzkeVar) {
        return new zzki(zzllVar, zzifVar, zzkeVar);
    }

    @Override // com.google.android.recaptcha.internal.zzkr
    public final int zza(Object obj) {
        zzll zzllVar = this.zzb;
        int zzb = zzllVar.zzb(zzllVar.zzd(obj));
        return this.zzc ? zzb + this.zzd.zzb(obj).zzb() : zzb;
    }

    @Override // com.google.android.recaptcha.internal.zzkr
    public final int zzb(Object obj) {
        int hashCode = this.zzb.zzd(obj).hashCode();
        return this.zzc ? (hashCode * 53) + this.zzd.zzb(obj).zza.hashCode() : hashCode;
    }

    @Override // com.google.android.recaptcha.internal.zzkr
    public final Object zze() {
        zzke zzkeVar = this.zza;
        return zzkeVar instanceof zzit ? ((zzit) zzkeVar).zzs() : zzkeVar.zzW().zzk();
    }

    @Override // com.google.android.recaptcha.internal.zzkr
    public final void zzf(Object obj) {
        this.zzb.zzm(obj);
        this.zzd.zzf(obj);
    }

    @Override // com.google.android.recaptcha.internal.zzkr
    public final void zzg(Object obj, Object obj2) {
        zzkt.zzr(this.zzb, obj, obj2);
        if (this.zzc) {
            zzkt.zzq(this.zzd, obj, obj2);
        }
    }

    @Override // com.google.android.recaptcha.internal.zzkr
    public final void zzh(Object obj, zzkq zzkqVar, zzie zzieVar) {
        boolean zzO;
        zzll zzllVar = this.zzb;
        Object zzc = zzllVar.zzc(obj);
        zzif zzifVar = this.zzd;
        zzij zzc2 = zzifVar.zzc(obj);
        while (zzkqVar.zzc() != Integer.MAX_VALUE) {
            try {
                int zzd = zzkqVar.zzd();
                if (zzd != 11) {
                    if ((zzd & 7) == 2) {
                        Object zzd2 = zzifVar.zzd(zzieVar, this.zza, zzd >>> 3);
                        if (zzd2 != null) {
                            zzifVar.zzg(zzkqVar, zzd2, zzieVar, zzc2);
                        } else {
                            zzO = zzllVar.zzr(zzc, zzkqVar);
                        }
                    } else {
                        zzO = zzkqVar.zzO();
                    }
                    if (!zzO) {
                        break;
                    }
                } else {
                    int i5 = 0;
                    Object obj2 = null;
                    zzgw zzgwVar = null;
                    while (zzkqVar.zzc() != Integer.MAX_VALUE) {
                        int zzd3 = zzkqVar.zzd();
                        if (zzd3 == 16) {
                            i5 = zzkqVar.zzj();
                            obj2 = zzifVar.zzd(zzieVar, this.zza, i5);
                        } else if (zzd3 == 26) {
                            if (obj2 != null) {
                                zzifVar.zzg(zzkqVar, obj2, zzieVar, zzc2);
                            } else {
                                zzgwVar = zzkqVar.zzp();
                            }
                        } else if (!zzkqVar.zzO()) {
                            break;
                        }
                    }
                    if (zzkqVar.zzd() != 12) {
                        throw zzje.zzb();
                    } else if (zzgwVar != null) {
                        if (obj2 != null) {
                            zzifVar.zzh(zzgwVar, obj2, zzieVar, zzc2);
                        } else {
                            zzllVar.zzk(zzc, i5, zzgwVar);
                        }
                    }
                }
            } finally {
                zzllVar.zzn(obj, zzc);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0088 A[EDGE_INSN: B:56:0x0088->B:34:0x0088 ?: BREAK  , SYNTHETIC] */
    @Override // com.google.android.recaptcha.internal.zzkr
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzi(java.lang.Object r10, byte[] r11, int r12, int r13, com.google.android.recaptcha.internal.zzgj r14) {
        /*
            r9 = this;
            r0 = r10
            com.google.android.recaptcha.internal.zzit r0 = (com.google.android.recaptcha.internal.zzit) r0
            com.google.android.recaptcha.internal.zzlm r1 = r0.zzc
            com.google.android.recaptcha.internal.zzlm r2 = com.google.android.recaptcha.internal.zzlm.zzc()
            if (r1 != r2) goto L11
            com.google.android.recaptcha.internal.zzlm r1 = com.google.android.recaptcha.internal.zzlm.zzf()
            r0.zzc = r1
        L11:
            com.google.android.recaptcha.internal.zzip r10 = (com.google.android.recaptcha.internal.zzip) r10
            r10.zzi()
            r10 = 0
            r0 = r10
        L18:
            if (r12 >= r13) goto L92
            int r4 = com.google.android.recaptcha.internal.zzgk.zzi(r11, r12, r14)
            int r2 = r14.zza
            r12 = 11
            r3 = 2
            if (r2 == r12) goto L48
            r12 = r2 & 7
            if (r12 != r3) goto L43
            com.google.android.recaptcha.internal.zzif r12 = r9.zzd
            com.google.android.recaptcha.internal.zzie r0 = r14.zzd
            com.google.android.recaptcha.internal.zzke r3 = r9.zza
            int r5 = r2 >>> 3
            java.lang.Object r0 = r12.zzd(r0, r3, r5)
            if (r0 != 0) goto L40
            r3 = r11
            r5 = r13
            r6 = r1
            r7 = r14
            int r12 = com.google.android.recaptcha.internal.zzgk.zzh(r2, r3, r4, r5, r6, r7)
            goto L18
        L40:
            int r11 = com.google.android.recaptcha.internal.zzkn.zza
            throw r10
        L43:
            int r12 = com.google.android.recaptcha.internal.zzgk.zzo(r2, r11, r4, r13, r14)
            goto L18
        L48:
            r12 = 0
            r2 = r10
        L4a:
            if (r4 >= r13) goto L88
            int r4 = com.google.android.recaptcha.internal.zzgk.zzi(r11, r4, r14)
            int r5 = r14.zza
            int r6 = r5 >>> 3
            r7 = r5 & 7
            if (r6 == r3) goto L6c
            r8 = 3
            if (r6 == r8) goto L5c
            goto L7f
        L5c:
            if (r0 != 0) goto L69
            if (r7 != r3) goto L7f
            int r4 = com.google.android.recaptcha.internal.zzgk.zza(r11, r4, r14)
            java.lang.Object r2 = r14.zzc
            com.google.android.recaptcha.internal.zzgw r2 = (com.google.android.recaptcha.internal.zzgw) r2
            goto L4a
        L69:
            int r11 = com.google.android.recaptcha.internal.zzkn.zza
            throw r10
        L6c:
            if (r7 != 0) goto L7f
            int r4 = com.google.android.recaptcha.internal.zzgk.zzi(r11, r4, r14)
            int r12 = r14.zza
            com.google.android.recaptcha.internal.zzif r0 = r9.zzd
            com.google.android.recaptcha.internal.zzie r5 = r14.zzd
            com.google.android.recaptcha.internal.zzke r6 = r9.zza
            java.lang.Object r0 = r0.zzd(r5, r6, r12)
            goto L4a
        L7f:
            r6 = 12
            if (r5 == r6) goto L88
            int r4 = com.google.android.recaptcha.internal.zzgk.zzo(r5, r11, r4, r13, r14)
            goto L4a
        L88:
            if (r2 == 0) goto L90
            int r12 = r12 << 3
            r12 = r12 | r3
            r1.zzj(r12, r2)
        L90:
            r12 = r4
            goto L18
        L92:
            if (r12 != r13) goto L95
            return
        L95:
            com.google.android.recaptcha.internal.zzje r10 = com.google.android.recaptcha.internal.zzje.zzg()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzki.zzi(java.lang.Object, byte[], int, int, com.google.android.recaptcha.internal.zzgj):void");
    }

    @Override // com.google.android.recaptcha.internal.zzkr
    public final void zzj(Object obj, zzmd zzmdVar) {
        Iterator zzf = this.zzd.zzb(obj).zzf();
        while (zzf.hasNext()) {
            Map.Entry entry = (Map.Entry) zzf.next();
            zzii zziiVar = (zzii) entry.getKey();
            if (zziiVar.zze() != zzmc.MESSAGE) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            zziiVar.zzg();
            zziiVar.zzf();
            zzmdVar.zzw(zziiVar.zza(), entry instanceof zzjh ? ((zzjh) entry).zza().zzb() : entry.getValue());
        }
        zzll zzllVar = this.zzb;
        zzllVar.zzp(zzllVar.zzd(obj), zzmdVar);
    }

    @Override // com.google.android.recaptcha.internal.zzkr
    public final boolean zzk(Object obj, Object obj2) {
        zzll zzllVar = this.zzb;
        if (zzllVar.zzd(obj).equals(zzllVar.zzd(obj2))) {
            if (this.zzc) {
                return this.zzd.zzb(obj).equals(this.zzd.zzb(obj2));
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.recaptcha.internal.zzkr
    public final boolean zzl(Object obj) {
        return this.zzd.zzb(obj).zzk();
    }
}
