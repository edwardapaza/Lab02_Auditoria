package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzaiu;
import i2.a0;
import i2.d0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzais  reason: invalid package */
/* loaded from: classes.dex */
public final class zzais<T extends zzaiu<T>> {
    private static final zzais zzb = new zzais(true);
    final zzalh<T, Object> zza;
    private boolean zzc;
    private boolean zzd;

    private zzais() {
        this.zza = zzalh.zza(16);
    }

    private zzais(zzalh<T, Object> zzalhVar) {
        this.zza = zzalhVar;
        zze();
    }

    private zzais(boolean z4) {
        this(zzalh.zza(0));
        zze();
    }

    public static int zza(zzaiu<?> zzaiuVar, Object obj) {
        zzamo zzb2 = zzaiuVar.zzb();
        int zza = zzaiuVar.zza();
        if (zzaiuVar.zze()) {
            List<Object> list = (List) obj;
            int i5 = 0;
            if (!zzaiuVar.zzd()) {
                for (Object obj2 : list) {
                    i5 += zza(zzb2, zza, obj2);
                }
                return i5;
            } else if (list.isEmpty()) {
                return 0;
            } else {
                for (Object obj3 : list) {
                    i5 += zza(zzb2, obj3);
                }
                return zzaii.zzg(zza) + i5 + zzaii.zzh(i5);
            }
        }
        return zza(zzb2, zza, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(zzamo zzamoVar, int i5, Object obj) {
        int zzg = zzaii.zzg(i5);
        if (zzamoVar == zzamo.zzj) {
            zzajc.zza((zzakk) obj);
            zzg <<= 1;
        }
        return zzg + zza(zzamoVar, obj);
    }

    private static int zza(zzamo zzamoVar, Object obj) {
        switch (zzaiv.zzb[zzamoVar.ordinal()]) {
            case 1:
                return zzaii.zza(((Double) obj).doubleValue());
            case 2:
                return zzaii.zza(((Float) obj).floatValue());
            case 3:
                return zzaii.zzb(((Long) obj).longValue());
            case 4:
                return zzaii.zze(((Long) obj).longValue());
            case 5:
                return zzaii.zzc(((Integer) obj).intValue());
            case 6:
                return zzaii.zza(((Long) obj).longValue());
            case 7:
                return zzaii.zzb(((Integer) obj).intValue());
            case 8:
                return zzaii.zza(((Boolean) obj).booleanValue());
            case d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                return zzaii.zza((zzakk) obj);
            case d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                return obj instanceof zzajk ? zzaii.zza((zzajk) obj) : zzaii.zzb((zzakk) obj);
            case 11:
                return obj instanceof zzahm ? zzaii.zza((zzahm) obj) : zzaii.zza((String) obj);
            case a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                return obj instanceof zzahm ? zzaii.zza((zzahm) obj) : zzaii.zza((byte[]) obj);
            case 13:
                return zzaii.zzh(((Integer) obj).intValue());
            case 14:
                return zzaii.zze(((Integer) obj).intValue());
            case 15:
                return zzaii.zzc(((Long) obj).longValue());
            case 16:
                return zzaii.zzf(((Integer) obj).intValue());
            case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                return zzaii.zzd(((Long) obj).longValue());
            case d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                return obj instanceof zzajf ? zzaii.zza(((zzajf) obj).zza()) : zzaii.zza(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private static int zza(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzc() != zzamy.MESSAGE || key.zze() || key.zzd()) {
            return zza((zzaiu<?>) key, value);
        }
        boolean z4 = value instanceof zzajk;
        int zza = entry.getKey().zza();
        return z4 ? zzaii.zza(zza, (zzajk) value) : zzaii.zza(zza, (zzakk) value);
    }

    private final Object zza(T t5) {
        Object obj = this.zza.get(t5);
        if (obj instanceof zzajk) {
            zzajk zzajkVar = (zzajk) obj;
            return zzajk.zza();
        }
        return obj;
    }

    private static Object zza(Object obj) {
        if (obj instanceof zzakt) {
            return ((zzakt) obj).zza();
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(zzaii zzaiiVar, zzamo zzamoVar, int i5, Object obj) {
        if (zzamoVar == zzamo.zzj) {
            zzakk zzakkVar = (zzakk) obj;
            zzajc.zza(zzakkVar);
            zzaiiVar.zzj(i5, 3);
            zzakkVar.zza(zzaiiVar);
            zzaiiVar.zzj(i5, 4);
            return;
        }
        zzaiiVar.zzj(i5, zzamoVar.zza());
        switch (zzaiv.zzb[zzamoVar.ordinal()]) {
            case 1:
                zzaiiVar.zzb(((Double) obj).doubleValue());
                return;
            case 2:
                zzaiiVar.zzb(((Float) obj).floatValue());
                return;
            case 3:
                zzaiiVar.zzh(((Long) obj).longValue());
                return;
            case 4:
                zzaiiVar.zzh(((Long) obj).longValue());
                return;
            case 5:
                zzaiiVar.zzj(((Integer) obj).intValue());
                return;
            case 6:
                zzaiiVar.zzf(((Long) obj).longValue());
                return;
            case 7:
                zzaiiVar.zzi(((Integer) obj).intValue());
                return;
            case 8:
                zzaiiVar.zzb(((Boolean) obj).booleanValue());
                return;
            case d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                ((zzakk) obj).zza(zzaiiVar);
                return;
            case d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                zzaiiVar.zzc((zzakk) obj);
                return;
            case 11:
                if (obj instanceof zzahm) {
                    zzaiiVar.zzb((zzahm) obj);
                    return;
                } else {
                    zzaiiVar.zzb((String) obj);
                    return;
                }
            case a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                if (obj instanceof zzahm) {
                    zzaiiVar.zzb((zzahm) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzaiiVar.zzb(bArr, 0, bArr.length);
                return;
            case 13:
                zzaiiVar.zzl(((Integer) obj).intValue());
                return;
            case 14:
                zzaiiVar.zzi(((Integer) obj).intValue());
                return;
            case 15:
                zzaiiVar.zzf(((Long) obj).longValue());
                return;
            case 16:
                zzaiiVar.zzk(((Integer) obj).intValue());
                return;
            case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                zzaiiVar.zzg(((Long) obj).longValue());
                return;
            case d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                if (obj instanceof zzajf) {
                    zzaiiVar.zzj(((zzajf) obj).zza());
                    return;
                } else {
                    zzaiiVar.zzj(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public static <T extends zzaiu<T>> zzais<T> zzb() {
        return zzb;
    }

    private final void zzb(T t5, Object obj) {
        if (!t5.zze()) {
            zzc(t5, obj);
        } else if (!(obj instanceof List)) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj2 = arrayList.get(i5);
                i5++;
                zzc(t5, obj2);
            }
            obj = arrayList;
        }
        if (obj instanceof zzajk) {
            this.zzd = true;
        }
        this.zza.zza((zzalh<T, Object>) t5, (T) obj);
    }

    private final void zzb(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        boolean z4 = value instanceof zzajk;
        if (key.zze()) {
            if (z4) {
                throw new IllegalStateException("Lazy fields can not be repeated");
            }
            Object zza = zza((zzais<T>) key);
            if (zza == null) {
                zza = new ArrayList();
            }
            for (Object obj : (List) value) {
                ((List) zza).add(zza(obj));
            }
            this.zza.zza((zzalh<T, Object>) key, (T) zza);
        } else if (key.zzc() != zzamy.MESSAGE) {
            if (z4) {
                throw new IllegalStateException("Lazy fields must be message-valued");
            }
            this.zza.zza((zzalh<T, Object>) key, (T) zza(value));
        } else {
            Object zza2 = zza((zzais<T>) key);
            if (zza2 == null) {
                this.zza.zza((zzalh<T, Object>) key, (T) zza(value));
                if (z4) {
                    this.zzd = true;
                    return;
                }
                return;
            }
            if (z4) {
                zzajk zzajkVar = (zzajk) value;
                value = zzajk.zza();
            }
            this.zza.zza((zzalh<T, Object>) key, (T) (zza2 instanceof zzakt ? key.zza((zzakt) zza2, (zzakt) value) : key.zza(((zzakk) zza2).zzq(), (zzakk) value).zzf()));
        }
    }

    private static boolean zzb(Object obj) {
        if (obj instanceof zzakm) {
            return ((zzakm) obj).zzu();
        }
        if (obj instanceof zzajk) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0029, code lost:
        if ((r6 instanceof com.google.android.gms.internal.p001firebaseauthapi.zzajf) == false) goto L3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
        if ((r6 instanceof byte[]) == false) goto L3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0020, code lost:
        if ((r6 instanceof com.google.android.gms.internal.p001firebaseauthapi.zzajk) == false) goto L3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void zzc(T r5, java.lang.Object r6) {
        /*
            com.google.android.gms.internal.firebase-auth-api.zzamo r0 = r5.zzb()
            com.google.android.gms.internal.p001firebaseauthapi.zzajc.zza(r6)
            int[] r1 = com.google.android.gms.internal.p001firebaseauthapi.zzaiv.zza
            com.google.android.gms.internal.firebase-auth-api.zzamy r0 = r0.zzb()
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            r2 = 0
            switch(r0) {
                case 1: goto L45;
                case 2: goto L42;
                case 3: goto L3f;
                case 4: goto L3c;
                case 5: goto L39;
                case 6: goto L36;
                case 7: goto L2c;
                case 8: goto L23;
                case 9: goto L1a;
                default: goto L18;
            }
        L18:
            r0 = 0
            goto L47
        L1a:
            boolean r0 = r6 instanceof com.google.android.gms.internal.p001firebaseauthapi.zzakk
            if (r0 != 0) goto L34
            boolean r0 = r6 instanceof com.google.android.gms.internal.p001firebaseauthapi.zzajk
            if (r0 == 0) goto L18
            goto L34
        L23:
            boolean r0 = r6 instanceof java.lang.Integer
            if (r0 != 0) goto L34
            boolean r0 = r6 instanceof com.google.android.gms.internal.p001firebaseauthapi.zzajf
            if (r0 == 0) goto L18
            goto L34
        L2c:
            boolean r0 = r6 instanceof com.google.android.gms.internal.p001firebaseauthapi.zzahm
            if (r0 != 0) goto L34
            boolean r0 = r6 instanceof byte[]
            if (r0 == 0) goto L18
        L34:
            r0 = 1
            goto L47
        L36:
            boolean r0 = r6 instanceof java.lang.String
            goto L47
        L39:
            boolean r0 = r6 instanceof java.lang.Boolean
            goto L47
        L3c:
            boolean r0 = r6 instanceof java.lang.Double
            goto L47
        L3f:
            boolean r0 = r6 instanceof java.lang.Float
            goto L47
        L42:
            boolean r0 = r6 instanceof java.lang.Long
            goto L47
        L45:
            boolean r0 = r6 instanceof java.lang.Integer
        L47:
            if (r0 == 0) goto L4a
            return
        L4a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]
            int r4 = r5.zza()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3[r2] = r4
            com.google.android.gms.internal.firebase-auth-api.zzamo r5 = r5.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzamy r5 = r5.zzb()
            r3[r1] = r5
            r5 = 2
            java.lang.Class r6 = r6.getClass()
            java.lang.String r6 = r6.getName()
            r3[r5] = r6
            java.lang.String r5 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r5 = java.lang.String.format(r5, r3)
            r0.<init>(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p001firebaseauthapi.zzais.zzc(com.google.android.gms.internal.firebase-auth-api.zzaiu, java.lang.Object):void");
    }

    private static <T extends zzaiu<T>> boolean zzc(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.zzc() == zzamy.MESSAGE) {
            boolean zze = key.zze();
            Object value = entry.getValue();
            if (zze) {
                for (Object obj : (List) value) {
                    if (!zzb(obj)) {
                        return false;
                    }
                }
                return true;
            }
            return zzb(value);
        }
        return true;
    }

    public final /* synthetic */ Object clone() {
        zzais zzaisVar = new zzais();
        for (int i5 = 0; i5 < this.zza.zzb(); i5++) {
            Map.Entry<T, Object> zzb2 = this.zza.zzb(i5);
            zzaisVar.zzb(zzb2.getKey(), zzb2.getValue());
        }
        for (Map.Entry<T, Object> entry : this.zza.zzc()) {
            zzaisVar.zzb(entry.getKey(), entry.getValue());
        }
        zzaisVar.zzd = this.zzd;
        return zzaisVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzais) {
            return this.zza.equals(((zzais) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final int zza() {
        int i5 = 0;
        for (int i6 = 0; i6 < this.zza.zzb(); i6++) {
            i5 += zza((Map.Entry) this.zza.zzb(i6));
        }
        for (Map.Entry<T, Object> entry : this.zza.zzc()) {
            i5 += zza((Map.Entry) entry);
        }
        return i5;
    }

    public final void zza(zzais<T> zzaisVar) {
        for (int i5 = 0; i5 < zzaisVar.zza.zzb(); i5++) {
            zzb((Map.Entry) zzaisVar.zza.zzb(i5));
        }
        for (Map.Entry<T, Object> entry : zzaisVar.zza.zzc()) {
            zzb((Map.Entry) entry);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Iterator<Map.Entry<T, Object>> zzc() {
        return this.zzd ? new zzajp(this.zza.zzd().iterator()) : this.zza.zzd().iterator();
    }

    public final Iterator<Map.Entry<T, Object>> zzd() {
        return this.zzd ? new zzajp(this.zza.entrySet().iterator()) : this.zza.entrySet().iterator();
    }

    public final void zze() {
        if (this.zzc) {
            return;
        }
        for (int i5 = 0; i5 < this.zza.zzb(); i5++) {
            Map.Entry<T, Object> zzb2 = this.zza.zzb(i5);
            if (zzb2.getValue() instanceof zzaja) {
                ((zzaja) zzb2.getValue()).zzs();
            }
        }
        this.zza.zza();
        this.zzc = true;
    }

    public final boolean zzf() {
        return this.zzc;
    }

    public final boolean zzg() {
        for (int i5 = 0; i5 < this.zza.zzb(); i5++) {
            if (!zzc(this.zza.zzb(i5))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> entry : this.zza.zzc()) {
            if (!zzc(entry)) {
                return false;
            }
        }
        return true;
    }
}
