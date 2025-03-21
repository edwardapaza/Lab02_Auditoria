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
public final class zzdn implements zzdd {
    public static final zzdn zza = new zzdn();

    private zzdn() {
    }

    private final Object zzb(Object obj, Object obj2) {
        boolean z4;
        boolean z5;
        f h5;
        int k5;
        f h6;
        int k6;
        f h7;
        int k7;
        f h8;
        int k8;
        f h9;
        int k9;
        f h10;
        int k10;
        int[] G;
        int[] G2;
        byte[] E;
        boolean z6 = obj instanceof Byte;
        if ((z6 && (obj2 instanceof Byte)) || ((((z4 = obj instanceof Short)) && (obj2 instanceof Short)) || (((z5 = obj instanceof Integer)) && (obj2 instanceof Integer)))) {
            return Integer.valueOf(((Number) obj).intValue() % ((Number) obj2).intValue());
        }
        boolean z7 = obj instanceof Long;
        if (z7 && (obj2 instanceof Long)) {
            return Long.valueOf(((Number) obj).longValue() % ((Number) obj2).longValue());
        }
        boolean z8 = obj instanceof Float;
        if (z8 && (obj2 instanceof Float)) {
            return Float.valueOf(((Number) obj).floatValue() % ((Number) obj2).floatValue());
        }
        boolean z9 = obj instanceof Double;
        if (z9 && (obj2 instanceof Double)) {
            return Double.valueOf(((Number) obj).doubleValue() % ((Number) obj2).doubleValue());
        }
        int i5 = 0;
        if (obj instanceof String) {
            if (obj2 instanceof Byte) {
                byte[] bytes = ((String) obj).getBytes(c.f5831b);
                int length = bytes.length;
                ArrayList arrayList = new ArrayList(length);
                while (i5 < length) {
                    arrayList.add(Byte.valueOf((byte) (bytes[i5] % ((Number) obj2).intValue())));
                    i5++;
                }
                E = x.E(arrayList);
                return new String(E, c.f5831b);
            } else if (obj2 instanceof Integer) {
                char[] charArray = ((String) obj).toCharArray();
                int length2 = charArray.length;
                ArrayList arrayList2 = new ArrayList(length2);
                while (i5 < length2) {
                    arrayList2.add(Integer.valueOf(charArray[i5] % ((Number) obj2).intValue()));
                    i5++;
                }
                G2 = x.G(arrayList2);
                return G2;
            }
        }
        if (z6 && (obj2 instanceof byte[])) {
            byte[] bArr = (byte[]) obj2;
            ArrayList arrayList3 = new ArrayList(bArr.length);
            for (byte b5 : bArr) {
                arrayList3.add(Integer.valueOf(b5 % ((Number) obj).intValue()));
            }
            return arrayList3.toArray(new Integer[0]);
        } else if (z4 && (obj2 instanceof short[])) {
            short[] sArr = (short[]) obj2;
            ArrayList arrayList4 = new ArrayList(sArr.length);
            for (short s5 : sArr) {
                arrayList4.add(Integer.valueOf(s5 % ((Number) obj).intValue()));
            }
            return arrayList4.toArray(new Integer[0]);
        } else if (z5 && (obj2 instanceof int[])) {
            int[] iArr = (int[]) obj2;
            ArrayList arrayList5 = new ArrayList(iArr.length);
            for (int i6 : iArr) {
                arrayList5.add(Integer.valueOf(i6 % ((Number) obj).intValue()));
            }
            return arrayList5.toArray(new Integer[0]);
        } else if (z7 && (obj2 instanceof long[])) {
            long[] jArr = (long[]) obj2;
            ArrayList arrayList6 = new ArrayList(jArr.length);
            for (long j5 : jArr) {
                arrayList6.add(Long.valueOf(j5 % ((Number) obj).longValue()));
            }
            return arrayList6.toArray(new Long[0]);
        } else if (z8 && (obj2 instanceof float[])) {
            float[] fArr = (float[]) obj2;
            ArrayList arrayList7 = new ArrayList(fArr.length);
            for (float f5 : fArr) {
                arrayList7.add(Float.valueOf(f5 % ((Number) obj).floatValue()));
            }
            return arrayList7.toArray(new Float[0]);
        } else if (z9 && (obj2 instanceof double[])) {
            double[] dArr = (double[]) obj2;
            ArrayList arrayList8 = new ArrayList(dArr.length);
            for (double d5 : dArr) {
                arrayList8.add(Double.valueOf(d5 % ((Number) obj).doubleValue()));
            }
            return arrayList8.toArray(new Double[0]);
        } else {
            boolean z10 = obj instanceof byte[];
            if (z10 && (obj2 instanceof Byte)) {
                byte[] bArr2 = (byte[]) obj;
                ArrayList arrayList9 = new ArrayList(bArr2.length);
                for (byte b6 : bArr2) {
                    arrayList9.add(Integer.valueOf(b6 % ((Number) obj2).intValue()));
                }
                return arrayList9.toArray(new Integer[0]);
            }
            boolean z11 = obj instanceof short[];
            if (z11 && (obj2 instanceof Short)) {
                short[] sArr2 = (short[]) obj;
                ArrayList arrayList10 = new ArrayList(sArr2.length);
                for (short s6 : sArr2) {
                    arrayList10.add(Integer.valueOf(s6 % ((Number) obj2).intValue()));
                }
                return arrayList10.toArray(new Integer[0]);
            }
            boolean z12 = obj instanceof int[];
            if (z12 && (obj2 instanceof Integer)) {
                int[] iArr2 = (int[]) obj;
                int length3 = iArr2.length;
                ArrayList arrayList11 = new ArrayList(length3);
                while (i5 < length3) {
                    arrayList11.add(Integer.valueOf(iArr2[i5] % ((Number) obj2).intValue()));
                    i5++;
                }
                G = x.G(arrayList11);
                return G;
            }
            boolean z13 = obj instanceof long[];
            if (z13 && (obj2 instanceof Long)) {
                long[] jArr2 = (long[]) obj;
                ArrayList arrayList12 = new ArrayList(jArr2.length);
                for (long j6 : jArr2) {
                    arrayList12.add(Long.valueOf(j6 % ((Number) obj2).longValue()));
                }
                return arrayList12.toArray(new Long[0]);
            }
            boolean z14 = obj instanceof float[];
            if (z14 && (obj2 instanceof Float)) {
                float[] fArr2 = (float[]) obj;
                ArrayList arrayList13 = new ArrayList(fArr2.length);
                for (float f6 : fArr2) {
                    arrayList13.add(Float.valueOf(f6 % ((Number) obj2).floatValue()));
                }
                return arrayList13.toArray(new Float[0]);
            }
            boolean z15 = obj instanceof double[];
            if (z15 && (obj2 instanceof Double)) {
                double[] dArr2 = (double[]) obj;
                ArrayList arrayList14 = new ArrayList(dArr2.length);
                for (double d6 : dArr2) {
                    arrayList14.add(Double.valueOf(d6 % ((Number) obj2).doubleValue()));
                }
                return arrayList14.toArray(new Double[0]);
            } else if (z10 && (obj2 instanceof byte[])) {
                byte[] bArr3 = (byte[]) obj;
                int length4 = bArr3.length;
                byte[] bArr4 = (byte[]) obj2;
                zzdc.zza(this, length4, bArr4.length);
                h10 = l.h(0, length4);
                k10 = q.k(h10, 10);
                ArrayList arrayList15 = new ArrayList(k10);
                Iterator<Integer> it = h10.iterator();
                while (it.hasNext()) {
                    int nextInt = ((c0) it).nextInt();
                    arrayList15.add(Integer.valueOf(bArr3[nextInt] % bArr4[nextInt]));
                }
                return arrayList15.toArray(new Integer[0]);
            } else if (z11 && (obj2 instanceof short[])) {
                short[] sArr3 = (short[]) obj;
                int length5 = sArr3.length;
                short[] sArr4 = (short[]) obj2;
                zzdc.zza(this, length5, sArr4.length);
                h9 = l.h(0, length5);
                k9 = q.k(h9, 10);
                ArrayList arrayList16 = new ArrayList(k9);
                Iterator<Integer> it2 = h9.iterator();
                while (it2.hasNext()) {
                    int nextInt2 = ((c0) it2).nextInt();
                    arrayList16.add(Integer.valueOf(sArr3[nextInt2] % sArr4[nextInt2]));
                }
                return arrayList16.toArray(new Integer[0]);
            } else if (z12 && (obj2 instanceof int[])) {
                int[] iArr3 = (int[]) obj;
                int length6 = iArr3.length;
                int[] iArr4 = (int[]) obj2;
                zzdc.zza(this, length6, iArr4.length);
                h8 = l.h(0, length6);
                k8 = q.k(h8, 10);
                ArrayList arrayList17 = new ArrayList(k8);
                Iterator<Integer> it3 = h8.iterator();
                while (it3.hasNext()) {
                    int nextInt3 = ((c0) it3).nextInt();
                    arrayList17.add(Integer.valueOf(iArr3[nextInt3] % iArr4[nextInt3]));
                }
                return arrayList17.toArray(new Integer[0]);
            } else if (z13 && (obj2 instanceof long[])) {
                long[] jArr3 = (long[]) obj;
                int length7 = jArr3.length;
                long[] jArr4 = (long[]) obj2;
                zzdc.zza(this, length7, jArr4.length);
                h7 = l.h(0, length7);
                k7 = q.k(h7, 10);
                ArrayList arrayList18 = new ArrayList(k7);
                Iterator<Integer> it4 = h7.iterator();
                while (it4.hasNext()) {
                    int nextInt4 = ((c0) it4).nextInt();
                    arrayList18.add(Long.valueOf(jArr3[nextInt4] % jArr4[nextInt4]));
                }
                return arrayList18.toArray(new Long[0]);
            } else if (z14 && (obj2 instanceof float[])) {
                float[] fArr3 = (float[]) obj;
                int length8 = fArr3.length;
                float[] fArr4 = (float[]) obj2;
                zzdc.zza(this, length8, fArr4.length);
                h6 = l.h(0, length8);
                k6 = q.k(h6, 10);
                ArrayList arrayList19 = new ArrayList(k6);
                Iterator<Integer> it5 = h6.iterator();
                while (it5.hasNext()) {
                    int nextInt5 = ((c0) it5).nextInt();
                    arrayList19.add(Float.valueOf(fArr3[nextInt5] % fArr4[nextInt5]));
                }
                return arrayList19.toArray(new Float[0]);
            } else if (z15 && (obj2 instanceof double[])) {
                double[] dArr3 = (double[]) obj;
                int length9 = dArr3.length;
                double[] dArr4 = (double[]) obj2;
                zzdc.zza(this, length9, dArr4.length);
                h5 = l.h(0, length9);
                k5 = q.k(h5, 10);
                ArrayList arrayList20 = new ArrayList(k5);
                Iterator<Integer> it6 = h5.iterator();
                while (it6.hasNext()) {
                    int nextInt6 = ((c0) it6).nextInt();
                    arrayList20.add(Double.valueOf(dArr3[nextInt6] % dArr4[nextInt6]));
                }
                return arrayList20.toArray(new Double[0]);
            } else {
                throw new zzae(4, 5, null);
            }
        }
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
        try {
            zzcjVar.zzc().zzf(i5, zzb(zza2, zza3));
        } catch (ArithmeticException e5) {
            throw new zzae(4, 6, e5);
        }
    }
}
