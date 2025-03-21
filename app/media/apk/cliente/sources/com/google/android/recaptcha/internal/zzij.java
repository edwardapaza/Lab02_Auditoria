package com.google.android.recaptcha.internal;

import i2.a0;
import i2.d0;
import java.util.Iterator;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzij {
    private static final zzij zzb = new zzij(true);
    final zzle zza = new zzku(16);
    private boolean zzc;
    private boolean zzd;

    private zzij() {
    }

    private zzij(boolean z4) {
        zzg();
        zzg();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int zza(zzii zziiVar, Object obj) {
        long longValue;
        int intValue;
        int zza;
        int intValue2;
        zzmb zzd = zziiVar.zzd();
        int zza2 = zziiVar.zza();
        zziiVar.zzg();
        int zzy = zzhh.zzy(zza2 << 3);
        if (zzd == zzmb.zzj) {
            zzke zzkeVar = (zzke) obj;
            byte[] bArr = zzjc.zzd;
            if (zzkeVar instanceof zzgg) {
                zzgg zzggVar = (zzgg) zzkeVar;
                throw null;
            }
            zzy += zzy;
        }
        zzmc zzmcVar = zzmc.INT;
        int i5 = 4;
        switch (zzd.ordinal()) {
            case 0:
                ((Double) obj).doubleValue();
                i5 = 8;
                break;
            case 1:
                ((Float) obj).floatValue();
                break;
            case 2:
            case 3:
                longValue = ((Long) obj).longValue();
                i5 = zzhh.zzz(longValue);
                break;
            case 4:
                intValue = ((Integer) obj).intValue();
                i5 = zzhh.zzu(intValue);
                break;
            case 5:
            case 15:
                ((Long) obj).longValue();
                i5 = 8;
                break;
            case 6:
            case 14:
                ((Integer) obj).intValue();
                break;
            case 7:
                ((Boolean) obj).booleanValue();
                i5 = 1;
                break;
            case 8:
                if (!(obj instanceof zzgw)) {
                    i5 = zzhh.zzx((String) obj);
                    break;
                }
                zza = ((zzgw) obj).zzd();
                i5 = zzhh.zzy(zza) + zza;
                break;
            case d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                i5 = ((zzke) obj).zzn();
                break;
            case d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                if (!(obj instanceof zzjj)) {
                    i5 = zzhh.zzv((zzke) obj);
                    break;
                } else {
                    zza = ((zzjj) obj).zza();
                    i5 = zzhh.zzy(zza) + zza;
                    break;
                }
            case 11:
                if (!(obj instanceof zzgw)) {
                    zza = ((byte[]) obj).length;
                    i5 = zzhh.zzy(zza) + zza;
                    break;
                }
                zza = ((zzgw) obj).zzd();
                i5 = zzhh.zzy(zza) + zza;
            case a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                intValue2 = ((Integer) obj).intValue();
                i5 = zzhh.zzy(intValue2);
                break;
            case 13:
                if (obj instanceof zziv) {
                    intValue = ((zziv) obj).zza();
                    i5 = zzhh.zzu(intValue);
                    break;
                }
                intValue = ((Integer) obj).intValue();
                i5 = zzhh.zzu(intValue);
            case 16:
                int intValue3 = ((Integer) obj).intValue();
                intValue2 = (intValue3 >> 31) ^ (intValue3 + intValue3);
                i5 = zzhh.zzy(intValue2);
                break;
            case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                long longValue2 = ((Long) obj).longValue();
                longValue = (longValue2 >> 63) ^ (longValue2 + longValue2);
                i5 = zzhh.zzz(longValue);
                break;
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
        return zzy + i5;
    }

    public static zzij zzd() {
        return zzb;
    }

    private static Object zzl(Object obj) {
        if (obj instanceof zzkj) {
            return ((zzkj) obj).zzd();
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            int length = bArr.length;
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 0, bArr2, 0, length);
            return bArr2;
        }
        return obj;
    }

    private final void zzm(Map.Entry entry) {
        zzke zzj;
        zzii zziiVar = (zzii) entry.getKey();
        Object value = entry.getValue();
        boolean z4 = value instanceof zzjj;
        zziiVar.zzg();
        if (zziiVar.zze() != zzmc.MESSAGE) {
            if (z4) {
                throw new IllegalStateException("Lazy fields must be message-valued");
            }
            this.zza.put(zziiVar, zzl(value));
            return;
        }
        Object zze = zze(zziiVar);
        if (zze == null) {
            this.zza.put(zziiVar, zzl(value));
            if (z4) {
                this.zzd = true;
            }
        } else if (z4) {
            zzjj zzjjVar = (zzjj) value;
            throw null;
        } else {
            if (zze instanceof zzkj) {
                zzj = zziiVar.zzc((zzkj) zze, (zzkj) value);
            } else {
                zzkd zzX = ((zzke) zze).zzX();
                zziiVar.zzb(zzX, (zzke) value);
                zzj = zzX.zzj();
            }
            this.zza.put(zziiVar, zzj);
        }
    }

    private static boolean zzn(Map.Entry entry) {
        zzii zziiVar = (zzii) entry.getKey();
        if (zziiVar.zze() == zzmc.MESSAGE) {
            zziiVar.zzg();
            Object value = entry.getValue();
            if (value instanceof zzkf) {
                return ((zzkf) value).zzo();
            }
            if (value instanceof zzjj) {
                return true;
            }
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        return true;
    }

    private static final int zzo(Map.Entry entry) {
        zzii zziiVar = (zzii) entry.getKey();
        Object value = entry.getValue();
        if (zziiVar.zze() == zzmc.MESSAGE) {
            zziiVar.zzg();
            zziiVar.zzf();
            boolean z4 = value instanceof zzjj;
            int zza = ((zzii) entry.getKey()).zza();
            if (!z4) {
                int zzy = zzhh.zzy(zza);
                int zzy2 = zzhh.zzy(24) + zzhh.zzv((zzke) value);
                int zzy3 = zzhh.zzy(16);
                int zzy4 = zzhh.zzy(8);
                return zzy4 + zzy4 + zzy3 + zzy + zzy2;
            }
            int zzy5 = zzhh.zzy(zza);
            int zza2 = ((zzjj) value).zza();
            int zzy6 = zzhh.zzy(zza2) + zza2;
            int zzy7 = zzhh.zzy(24);
            int zzy8 = zzhh.zzy(16);
            int zzy9 = zzhh.zzy(8);
            return zzy9 + zzy9 + zzy8 + zzy5 + zzy7 + zzy6;
        }
        return zza(zziiVar, value);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzij) {
            return this.zza.equals(((zzij) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final int zzb() {
        int i5 = 0;
        for (int i6 = 0; i6 < this.zza.zzb(); i6++) {
            i5 += zzo(this.zza.zzg(i6));
        }
        for (Map.Entry entry : this.zza.zzc()) {
            i5 += zzo(entry);
        }
        return i5;
    }

    /* renamed from: zzc */
    public final zzij clone() {
        zzij zzijVar = new zzij();
        for (int i5 = 0; i5 < this.zza.zzb(); i5++) {
            Map.Entry zzg = this.zza.zzg(i5);
            zzijVar.zzi((zzii) zzg.getKey(), zzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzc()) {
            zzijVar.zzi((zzii) entry.getKey(), entry.getValue());
        }
        zzijVar.zzd = this.zzd;
        return zzijVar;
    }

    public final Object zze(zzii zziiVar) {
        Object obj = this.zza.get(zziiVar);
        if (obj instanceof zzjj) {
            zzjj zzjjVar = (zzjj) obj;
            throw null;
        }
        return obj;
    }

    public final Iterator zzf() {
        return this.zzd ? new zzji(this.zza.entrySet().iterator()) : this.zza.entrySet().iterator();
    }

    public final void zzg() {
        if (this.zzc) {
            return;
        }
        for (int i5 = 0; i5 < this.zza.zzb(); i5++) {
            Map.Entry zzg = this.zza.zzg(i5);
            if (zzg.getValue() instanceof zzit) {
                ((zzit) zzg.getValue()).zzB();
            }
        }
        this.zza.zza();
        this.zzc = true;
    }

    public final void zzh(zzij zzijVar) {
        for (int i5 = 0; i5 < zzijVar.zza.zzb(); i5++) {
            zzm(zzijVar.zza.zzg(i5));
        }
        for (Map.Entry entry : zzijVar.zza.zzc()) {
            zzm(entry);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002c, code lost:
        if ((r7 instanceof com.google.android.recaptcha.internal.zziv) == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
        if ((r7 instanceof byte[]) == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0049, code lost:
        if (r0 == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0023, code lost:
        if ((r7 instanceof com.google.android.recaptcha.internal.zzjj) == false) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzi(com.google.android.recaptcha.internal.zzii r6, java.lang.Object r7) {
        /*
            r5 = this;
            r6.zzg()
            com.google.android.recaptcha.internal.zzmb r0 = r6.zzd()
            byte[] r1 = com.google.android.recaptcha.internal.zzjc.zzd
            r7.getClass()
            com.google.android.recaptcha.internal.zzmb r1 = com.google.android.recaptcha.internal.zzmb.zza
            com.google.android.recaptcha.internal.zzmc r1 = com.google.android.recaptcha.internal.zzmc.INT
            com.google.android.recaptcha.internal.zzmc r0 = r0.zza()
            int r0 = r0.ordinal()
            r1 = 1
            switch(r0) {
                case 0: goto L47;
                case 1: goto L44;
                case 2: goto L41;
                case 3: goto L3e;
                case 4: goto L3b;
                case 5: goto L38;
                case 6: goto L2f;
                case 7: goto L26;
                case 8: goto L1d;
                default: goto L1c;
            }
        L1c:
            goto L57
        L1d:
            boolean r0 = r7 instanceof com.google.android.recaptcha.internal.zzke
            if (r0 != 0) goto L4b
            boolean r0 = r7 instanceof com.google.android.recaptcha.internal.zzjj
            if (r0 == 0) goto L57
            goto L4b
        L26:
            boolean r0 = r7 instanceof java.lang.Integer
            if (r0 != 0) goto L4b
            boolean r0 = r7 instanceof com.google.android.recaptcha.internal.zziv
            if (r0 == 0) goto L57
            goto L4b
        L2f:
            boolean r0 = r7 instanceof com.google.android.recaptcha.internal.zzgw
            if (r0 != 0) goto L4b
            boolean r0 = r7 instanceof byte[]
            if (r0 == 0) goto L57
            goto L4b
        L38:
            boolean r0 = r7 instanceof java.lang.String
            goto L49
        L3b:
            boolean r0 = r7 instanceof java.lang.Boolean
            goto L49
        L3e:
            boolean r0 = r7 instanceof java.lang.Double
            goto L49
        L41:
            boolean r0 = r7 instanceof java.lang.Float
            goto L49
        L44:
            boolean r0 = r7 instanceof java.lang.Long
            goto L49
        L47:
            boolean r0 = r7 instanceof java.lang.Integer
        L49:
            if (r0 == 0) goto L57
        L4b:
            boolean r0 = r7 instanceof com.google.android.recaptcha.internal.zzjj
            if (r0 == 0) goto L51
            r5.zzd = r1
        L51:
            com.google.android.recaptcha.internal.zzle r0 = r5.zza
            r0.put(r6, r7)
            return
        L57:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            int r4 = r6.zza()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r2[r3] = r4
            com.google.android.recaptcha.internal.zzmb r6 = r6.zzd()
            com.google.android.recaptcha.internal.zzmc r6 = r6.zza()
            r2[r1] = r6
            r6 = 2
            java.lang.Class r7 = r7.getClass()
            java.lang.String r7 = r7.getName()
            r2[r6] = r7
            java.lang.String r6 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r6 = java.lang.String.format(r6, r2)
            r0.<init>(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzij.zzi(com.google.android.recaptcha.internal.zzii, java.lang.Object):void");
    }

    public final boolean zzj() {
        return this.zzc;
    }

    public final boolean zzk() {
        for (int i5 = 0; i5 < this.zza.zzb(); i5++) {
            if (!zzn(this.zza.zzg(i5))) {
                return false;
            }
        }
        for (Map.Entry entry : this.zza.zzc()) {
            if (!zzn(entry)) {
                return false;
            }
        }
        return true;
    }
}
