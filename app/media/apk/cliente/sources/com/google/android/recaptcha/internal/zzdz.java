package com.google.android.recaptcha.internal;

import h4.f;
import h4.l;
import java.util.ArrayList;
import java.util.Iterator;
import k4.c;
import t3.c0;
import t3.q;
import t3.x;
/* loaded from: classes.dex */
public final class zzdz implements zzdd {
    public static final zzdz zza = new zzdz();

    private zzdz() {
    }

    @Override // com.google.android.recaptcha.internal.zzdd
    public final void zza(int i5, zzcj zzcjVar, zzpq... zzpqVarArr) {
        if (zzpqVarArr.length != 2) {
            throw new zzae(4, 3, null);
        }
        Object zza2 = zzcjVar.zzc().zza(zzpqVarArr[0]);
        if (true != (zza2 instanceof Object)) {
            zza2 = null;
        }
        if (zza2 == null) {
            throw new zzae(4, 5, null);
        }
        Object zza3 = zzcjVar.zzc().zza(zzpqVarArr[1]);
        if (true != (zza3 instanceof Object)) {
            zza3 = null;
        }
        if (zza3 == null) {
            throw new zzae(4, 5, null);
        }
        zzcjVar.zzc().zzf(i5, zzb(zza2, zza3));
    }

    public final Object zzb(Object obj, Object obj2) {
        f h5;
        int k5;
        f h6;
        int k6;
        f h7;
        int k7;
        f h8;
        int k8;
        int[] G;
        byte[] E;
        boolean z4 = obj instanceof Byte;
        if (z4 && (obj2 instanceof Byte)) {
            return Byte.valueOf((byte) (((Number) obj).byteValue() ^ ((Number) obj2).byteValue()));
        }
        boolean z5 = obj instanceof Short;
        if (z5 && (obj2 instanceof Short)) {
            return Short.valueOf((short) (((Number) obj).shortValue() ^ ((Number) obj2).shortValue()));
        }
        boolean z6 = obj instanceof Integer;
        if (z6 && (obj2 instanceof Integer)) {
            return Integer.valueOf(((Number) obj).intValue() ^ ((Number) obj2).intValue());
        }
        boolean z7 = obj instanceof Long;
        if (z7 && (obj2 instanceof Long)) {
            return Long.valueOf(((Number) obj2).longValue() ^ ((Number) obj).longValue());
        }
        int i5 = 0;
        if (obj instanceof String) {
            if (obj2 instanceof Byte) {
                byte[] bytes = ((String) obj).getBytes(c.f5831b);
                int length = bytes.length;
                ArrayList arrayList = new ArrayList(length);
                while (i5 < length) {
                    arrayList.add(Byte.valueOf((byte) (bytes[i5] ^ ((Number) obj2).byteValue())));
                    i5++;
                }
                E = x.E(arrayList);
                return E;
            } else if (obj2 instanceof Integer) {
                char[] charArray = ((String) obj).toCharArray();
                int length2 = charArray.length;
                ArrayList arrayList2 = new ArrayList(length2);
                while (i5 < length2) {
                    arrayList2.add(Integer.valueOf(charArray[i5] ^ ((Number) obj2).intValue()));
                    i5++;
                }
                G = x.G(arrayList2);
                return G;
            }
        }
        if (z4 && (obj2 instanceof byte[])) {
            byte[] bArr = (byte[]) obj2;
            ArrayList arrayList3 = new ArrayList(bArr.length);
            for (byte b5 : bArr) {
                arrayList3.add(Byte.valueOf((byte) (b5 ^ ((Number) obj).byteValue())));
            }
            return arrayList3.toArray(new Byte[0]);
        } else if (z5 && (obj2 instanceof short[])) {
            short[] sArr = (short[]) obj2;
            ArrayList arrayList4 = new ArrayList(sArr.length);
            for (short s5 : sArr) {
                arrayList4.add(Short.valueOf((short) (s5 ^ ((Number) obj).shortValue())));
            }
            return arrayList4.toArray(new Short[0]);
        } else if (z6 && (obj2 instanceof int[])) {
            int[] iArr = (int[]) obj2;
            ArrayList arrayList5 = new ArrayList(iArr.length);
            for (int i6 : iArr) {
                arrayList5.add(Integer.valueOf(i6 ^ ((Number) obj).intValue()));
            }
            return arrayList5.toArray(new Integer[0]);
        } else if (z7 && (obj2 instanceof long[])) {
            long[] jArr = (long[]) obj2;
            ArrayList arrayList6 = new ArrayList(jArr.length);
            for (long j5 : jArr) {
                arrayList6.add(Long.valueOf(j5 ^ ((Number) obj).longValue()));
            }
            return arrayList6.toArray(new Long[0]);
        } else {
            boolean z8 = obj instanceof byte[];
            if (z8 && (obj2 instanceof Byte)) {
                byte[] bArr2 = (byte[]) obj;
                ArrayList arrayList7 = new ArrayList(bArr2.length);
                for (byte b6 : bArr2) {
                    arrayList7.add(Byte.valueOf((byte) (b6 ^ ((Number) obj2).byteValue())));
                }
                return arrayList7.toArray(new Byte[0]);
            }
            boolean z9 = obj instanceof short[];
            if (z9 && (obj2 instanceof Short)) {
                short[] sArr2 = (short[]) obj;
                ArrayList arrayList8 = new ArrayList(sArr2.length);
                for (short s6 : sArr2) {
                    arrayList8.add(Short.valueOf((short) (s6 ^ ((Number) obj2).shortValue())));
                }
                return arrayList8.toArray(new Short[0]);
            }
            boolean z10 = obj instanceof int[];
            if (z10 && (obj2 instanceof Integer)) {
                int[] iArr2 = (int[]) obj;
                ArrayList arrayList9 = new ArrayList(iArr2.length);
                for (int i7 : iArr2) {
                    arrayList9.add(Integer.valueOf(i7 ^ ((Number) obj2).intValue()));
                }
                return arrayList9.toArray(new Integer[0]);
            }
            boolean z11 = obj instanceof long[];
            if (z11 && (obj2 instanceof Long)) {
                long[] jArr2 = (long[]) obj;
                ArrayList arrayList10 = new ArrayList(jArr2.length);
                for (long j6 : jArr2) {
                    arrayList10.add(Long.valueOf(j6 ^ ((Number) obj2).longValue()));
                }
                return arrayList10.toArray(new Long[0]);
            } else if (z8 && (obj2 instanceof byte[])) {
                byte[] bArr3 = (byte[]) obj;
                int length3 = bArr3.length;
                byte[] bArr4 = (byte[]) obj2;
                zzdc.zza(this, length3, bArr4.length);
                h8 = l.h(0, length3);
                k8 = q.k(h8, 10);
                ArrayList arrayList11 = new ArrayList(k8);
                Iterator<Integer> it = h8.iterator();
                while (it.hasNext()) {
                    int nextInt = ((c0) it).nextInt();
                    arrayList11.add(Byte.valueOf((byte) (bArr4[nextInt] ^ bArr3[nextInt])));
                }
                return arrayList11.toArray(new Byte[0]);
            } else if (z9 && (obj2 instanceof short[])) {
                short[] sArr3 = (short[]) obj;
                int length4 = sArr3.length;
                short[] sArr4 = (short[]) obj2;
                zzdc.zza(this, length4, sArr4.length);
                h7 = l.h(0, length4);
                k7 = q.k(h7, 10);
                ArrayList arrayList12 = new ArrayList(k7);
                Iterator<Integer> it2 = h7.iterator();
                while (it2.hasNext()) {
                    int nextInt2 = ((c0) it2).nextInt();
                    arrayList12.add(Short.valueOf((short) (sArr4[nextInt2] ^ sArr3[nextInt2])));
                }
                return arrayList12.toArray(new Short[0]);
            } else if (z10 && (obj2 instanceof int[])) {
                int[] iArr3 = (int[]) obj;
                int length5 = iArr3.length;
                int[] iArr4 = (int[]) obj2;
                zzdc.zza(this, length5, iArr4.length);
                h6 = l.h(0, length5);
                k6 = q.k(h6, 10);
                ArrayList arrayList13 = new ArrayList(k6);
                Iterator<Integer> it3 = h6.iterator();
                while (it3.hasNext()) {
                    int nextInt3 = ((c0) it3).nextInt();
                    arrayList13.add(Integer.valueOf(iArr4[nextInt3] ^ iArr3[nextInt3]));
                }
                return arrayList13.toArray(new Integer[0]);
            } else if (z11 && (obj2 instanceof long[])) {
                long[] jArr3 = (long[]) obj;
                int length6 = jArr3.length;
                long[] jArr4 = (long[]) obj2;
                zzdc.zza(this, length6, jArr4.length);
                h5 = l.h(0, length6);
                k5 = q.k(h5, 10);
                ArrayList arrayList14 = new ArrayList(k5);
                Iterator<Integer> it4 = h5.iterator();
                while (it4.hasNext()) {
                    int nextInt4 = ((c0) it4).nextInt();
                    arrayList14.add(Long.valueOf(jArr3[nextInt4] ^ jArr4[nextInt4]));
                }
                return arrayList14.toArray(new Long[0]);
            } else {
                throw new zzae(4, 5, null);
            }
        }
    }
}
