package androidx.profileinstaller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Map;
import java.util.TreeMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    static final byte[] f665a = {112, 114, 111, 0};

    /* renamed from: b  reason: collision with root package name */
    static final byte[] f666b = {112, 114, 109, 0};

    private static void A(InputStream inputStream) {
        e.h(inputStream);
        int j5 = e.j(inputStream);
        if (j5 == 6 || j5 == 7) {
            return;
        }
        while (j5 > 0) {
            e.j(inputStream);
            for (int j6 = e.j(inputStream); j6 > 0; j6--) {
                e.h(inputStream);
            }
            j5--;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean B(OutputStream outputStream, byte[] bArr, d[] dVarArr) {
        if (Arrays.equals(bArr, p.f677a)) {
            N(outputStream, dVarArr);
            return true;
        } else if (Arrays.equals(bArr, p.f678b)) {
            M(outputStream, dVarArr);
            return true;
        } else if (Arrays.equals(bArr, p.f680d)) {
            K(outputStream, dVarArr);
            return true;
        } else if (Arrays.equals(bArr, p.f679c)) {
            L(outputStream, dVarArr);
            return true;
        } else if (Arrays.equals(bArr, p.f681e)) {
            J(outputStream, dVarArr);
            return true;
        } else {
            return false;
        }
    }

    private static void C(OutputStream outputStream, d dVar) {
        int i5 = 0;
        for (int i6 : dVar.f646h) {
            Integer valueOf = Integer.valueOf(i6);
            e.p(outputStream, valueOf.intValue() - i5);
            i5 = valueOf.intValue();
        }
    }

    private static q D(d[] dVarArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            e.p(byteArrayOutputStream, dVarArr.length);
            int i5 = 2;
            for (d dVar : dVarArr) {
                e.q(byteArrayOutputStream, dVar.f641c);
                e.q(byteArrayOutputStream, dVar.f642d);
                e.q(byteArrayOutputStream, dVar.f645g);
                String j5 = j(dVar.f639a, dVar.f640b, p.f677a);
                int k5 = e.k(j5);
                e.p(byteArrayOutputStream, k5);
                i5 = i5 + 4 + 4 + 4 + 2 + (k5 * 1);
                e.n(byteArrayOutputStream, j5);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (i5 == byteArray.length) {
                q qVar = new q(f.DEX_FILES, i5, byteArray, false);
                byteArrayOutputStream.close();
                return qVar;
            }
            throw e.c("Expected size " + i5 + ", does not match actual size " + byteArray.length);
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void E(OutputStream outputStream, byte[] bArr) {
        outputStream.write(f665a);
        outputStream.write(bArr);
    }

    private static void F(OutputStream outputStream, d dVar) {
        I(outputStream, dVar);
        C(outputStream, dVar);
        H(outputStream, dVar);
    }

    private static void G(OutputStream outputStream, d dVar, String str) {
        e.p(outputStream, e.k(str));
        e.p(outputStream, dVar.f643e);
        e.q(outputStream, dVar.f644f);
        e.q(outputStream, dVar.f641c);
        e.q(outputStream, dVar.f645g);
        e.n(outputStream, str);
    }

    private static void H(OutputStream outputStream, d dVar) {
        byte[] bArr = new byte[k(dVar.f645g)];
        for (Map.Entry<Integer, Integer> entry : dVar.f647i.entrySet()) {
            int intValue = entry.getKey().intValue();
            int intValue2 = entry.getValue().intValue();
            if ((intValue2 & 2) != 0) {
                z(bArr, 2, intValue, dVar);
            }
            if ((intValue2 & 4) != 0) {
                z(bArr, 4, intValue, dVar);
            }
        }
        outputStream.write(bArr);
    }

    private static void I(OutputStream outputStream, d dVar) {
        int i5 = 0;
        for (Map.Entry<Integer, Integer> entry : dVar.f647i.entrySet()) {
            int intValue = entry.getKey().intValue();
            if ((entry.getValue().intValue() & 1) != 0) {
                e.p(outputStream, intValue - i5);
                e.p(outputStream, 0);
                i5 = intValue;
            }
        }
    }

    private static void J(OutputStream outputStream, d[] dVarArr) {
        e.p(outputStream, dVarArr.length);
        for (d dVar : dVarArr) {
            String j5 = j(dVar.f639a, dVar.f640b, p.f681e);
            e.p(outputStream, e.k(j5));
            e.p(outputStream, dVar.f647i.size());
            e.p(outputStream, dVar.f646h.length);
            e.q(outputStream, dVar.f641c);
            e.n(outputStream, j5);
            for (Integer num : dVar.f647i.keySet()) {
                e.p(outputStream, num.intValue());
            }
            for (int i5 : dVar.f646h) {
                e.p(outputStream, i5);
            }
        }
    }

    private static void K(OutputStream outputStream, d[] dVarArr) {
        e.r(outputStream, dVarArr.length);
        for (d dVar : dVarArr) {
            String j5 = j(dVar.f639a, dVar.f640b, p.f680d);
            e.p(outputStream, e.k(j5));
            e.p(outputStream, dVar.f646h.length);
            e.q(outputStream, dVar.f647i.size() * 4);
            e.q(outputStream, dVar.f641c);
            e.n(outputStream, j5);
            for (Integer num : dVar.f647i.keySet()) {
                e.p(outputStream, num.intValue());
                e.p(outputStream, 0);
            }
            for (int i5 : dVar.f646h) {
                e.p(outputStream, i5);
            }
        }
    }

    private static void L(OutputStream outputStream, d[] dVarArr) {
        byte[] b5 = b(dVarArr, p.f679c);
        e.r(outputStream, dVarArr.length);
        e.m(outputStream, b5);
    }

    private static void M(OutputStream outputStream, d[] dVarArr) {
        byte[] b5 = b(dVarArr, p.f678b);
        e.r(outputStream, dVarArr.length);
        e.m(outputStream, b5);
    }

    private static void N(OutputStream outputStream, d[] dVarArr) {
        O(outputStream, dVarArr);
    }

    private static void O(OutputStream outputStream, d[] dVarArr) {
        int length;
        ArrayList arrayList = new ArrayList(3);
        ArrayList arrayList2 = new ArrayList(3);
        arrayList.add(D(dVarArr));
        arrayList.add(c(dVarArr));
        arrayList.add(d(dVarArr));
        long length2 = p.f677a.length + f665a.length + 4 + (arrayList.size() * 16);
        e.q(outputStream, arrayList.size());
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            q qVar = (q) arrayList.get(i5);
            e.q(outputStream, qVar.f684a.c());
            e.q(outputStream, length2);
            if (qVar.f687d) {
                byte[] bArr = qVar.f686c;
                byte[] b5 = e.b(bArr);
                arrayList2.add(b5);
                e.q(outputStream, b5.length);
                e.q(outputStream, bArr.length);
                length = b5.length;
            } else {
                arrayList2.add(qVar.f686c);
                e.q(outputStream, qVar.f686c.length);
                e.q(outputStream, 0L);
                length = qVar.f686c.length;
            }
            length2 += length;
        }
        for (int i6 = 0; i6 < arrayList2.size(); i6++) {
            outputStream.write((byte[]) arrayList2.get(i6));
        }
    }

    private static int a(d dVar) {
        int i5 = 0;
        for (Map.Entry<Integer, Integer> entry : dVar.f647i.entrySet()) {
            i5 |= entry.getValue().intValue();
        }
        return i5;
    }

    private static byte[] b(d[] dVarArr, byte[] bArr) {
        int i5 = 0;
        int i6 = 0;
        for (d dVar : dVarArr) {
            i6 += e.k(j(dVar.f639a, dVar.f640b, bArr)) + 16 + (dVar.f643e * 2) + dVar.f644f + k(dVar.f645g);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i6);
        if (Arrays.equals(bArr, p.f679c)) {
            int length = dVarArr.length;
            while (i5 < length) {
                d dVar2 = dVarArr[i5];
                G(byteArrayOutputStream, dVar2, j(dVar2.f639a, dVar2.f640b, bArr));
                F(byteArrayOutputStream, dVar2);
                i5++;
            }
        } else {
            for (d dVar3 : dVarArr) {
                G(byteArrayOutputStream, dVar3, j(dVar3.f639a, dVar3.f640b, bArr));
            }
            int length2 = dVarArr.length;
            while (i5 < length2) {
                F(byteArrayOutputStream, dVarArr[i5]);
                i5++;
            }
        }
        if (byteArrayOutputStream.size() == i6) {
            return byteArrayOutputStream.toByteArray();
        }
        throw e.c("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + i6);
    }

    private static q c(d[] dVarArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i5 = 0;
        for (int i6 = 0; i6 < dVarArr.length; i6++) {
            try {
                d dVar = dVarArr[i6];
                e.p(byteArrayOutputStream, i6);
                e.p(byteArrayOutputStream, dVar.f643e);
                i5 = i5 + 2 + 2 + (dVar.f643e * 2);
                C(byteArrayOutputStream, dVar);
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i5 == byteArray.length) {
            q qVar = new q(f.CLASSES, i5, byteArray, true);
            byteArrayOutputStream.close();
            return qVar;
        }
        throw e.c("Expected size " + i5 + ", does not match actual size " + byteArray.length);
    }

    private static q d(d[] dVarArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i5 = 0;
        for (int i6 = 0; i6 < dVarArr.length; i6++) {
            try {
                d dVar = dVarArr[i6];
                int a5 = a(dVar);
                byte[] e5 = e(dVar);
                byte[] f5 = f(dVar);
                e.p(byteArrayOutputStream, i6);
                int length = e5.length + 2 + f5.length;
                e.q(byteArrayOutputStream, length);
                e.p(byteArrayOutputStream, a5);
                byteArrayOutputStream.write(e5);
                byteArrayOutputStream.write(f5);
                i5 = i5 + 2 + 4 + length;
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i5 == byteArray.length) {
            q qVar = new q(f.METHODS, i5, byteArray, true);
            byteArrayOutputStream.close();
            return qVar;
        }
        throw e.c("Expected size " + i5 + ", does not match actual size " + byteArray.length);
    }

    private static byte[] e(d dVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            H(byteArrayOutputStream, dVar);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static byte[] f(d dVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            I(byteArrayOutputStream, dVar);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static String g(String str, String str2) {
        return "!".equals(str2) ? str.replace(":", "!") : ":".equals(str2) ? str.replace("!", ":") : str;
    }

    private static String h(String str) {
        int indexOf = str.indexOf("!");
        if (indexOf < 0) {
            indexOf = str.indexOf(":");
        }
        return indexOf > 0 ? str.substring(indexOf + 1) : str;
    }

    private static d i(d[] dVarArr, String str) {
        if (dVarArr.length <= 0) {
            return null;
        }
        String h5 = h(str);
        for (int i5 = 0; i5 < dVarArr.length; i5++) {
            if (dVarArr[i5].f640b.equals(h5)) {
                return dVarArr[i5];
            }
        }
        return null;
    }

    private static String j(String str, String str2, byte[] bArr) {
        String a5 = p.a(bArr);
        if (str.length() <= 0) {
            return g(str2, a5);
        }
        if (str2.equals("classes.dex")) {
            return str;
        }
        if (str2.contains("!") || str2.contains(":")) {
            return g(str2, a5);
        }
        if (str2.endsWith(".apk")) {
            return str2;
        }
        return str + p.a(bArr) + str2;
    }

    private static int k(int i5) {
        return y(i5 * 2) / 8;
    }

    private static int l(int i5, int i6, int i7) {
        if (i5 != 1) {
            if (i5 != 2) {
                if (i5 == 4) {
                    return i6 + i7;
                }
                throw e.c("Unexpected flag: " + i5);
            }
            return i6;
        }
        throw e.c("HOT methods are not stored in the bitmap");
    }

    private static int[] m(InputStream inputStream, int i5) {
        int[] iArr = new int[i5];
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            i6 += e.h(inputStream);
            iArr[i7] = i6;
        }
        return iArr;
    }

    private static int n(BitSet bitSet, int i5, int i6) {
        int i7 = bitSet.get(l(2, i5, i6)) ? 2 : 0;
        return bitSet.get(l(4, i5, i6)) ? i7 | 4 : i7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] o(InputStream inputStream, byte[] bArr) {
        if (Arrays.equals(bArr, e.d(inputStream, bArr.length))) {
            return e.d(inputStream, p.f678b.length);
        }
        throw e.c("Invalid magic");
    }

    private static void p(InputStream inputStream, d dVar) {
        int available = inputStream.available() - dVar.f644f;
        int i5 = 0;
        while (inputStream.available() > available) {
            i5 += e.h(inputStream);
            dVar.f647i.put(Integer.valueOf(i5), 1);
            for (int h5 = e.h(inputStream); h5 > 0; h5--) {
                A(inputStream);
            }
        }
        if (inputStream.available() != available) {
            throw e.c("Read too much data during profile line parse");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d[] q(InputStream inputStream, byte[] bArr, byte[] bArr2, d[] dVarArr) {
        if (Arrays.equals(bArr, p.f682f)) {
            if (Arrays.equals(p.f677a, bArr2)) {
                throw e.c("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
            }
            return r(inputStream, bArr, dVarArr);
        } else if (Arrays.equals(bArr, p.f683g)) {
            return t(inputStream, bArr2, dVarArr);
        } else {
            throw e.c("Unsupported meta version");
        }
    }

    static d[] r(InputStream inputStream, byte[] bArr, d[] dVarArr) {
        if (Arrays.equals(bArr, p.f682f)) {
            int j5 = e.j(inputStream);
            byte[] e5 = e.e(inputStream, (int) e.i(inputStream), (int) e.i(inputStream));
            if (inputStream.read() <= 0) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(e5);
                try {
                    d[] s5 = s(byteArrayInputStream, j5, dVarArr);
                    byteArrayInputStream.close();
                    return s5;
                } catch (Throwable th) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
            throw e.c("Content found after the end of file");
        }
        throw e.c("Unsupported meta version");
    }

    private static d[] s(InputStream inputStream, int i5, d[] dVarArr) {
        if (inputStream.available() == 0) {
            return new d[0];
        }
        if (i5 == dVarArr.length) {
            String[] strArr = new String[i5];
            int[] iArr = new int[i5];
            for (int i6 = 0; i6 < i5; i6++) {
                int h5 = e.h(inputStream);
                iArr[i6] = e.h(inputStream);
                strArr[i6] = e.f(inputStream, h5);
            }
            for (int i7 = 0; i7 < i5; i7++) {
                d dVar = dVarArr[i7];
                if (!dVar.f640b.equals(strArr[i7])) {
                    throw e.c("Order of dexfiles in metadata did not match baseline");
                }
                int i8 = iArr[i7];
                dVar.f643e = i8;
                dVar.f646h = m(inputStream, i8);
            }
            return dVarArr;
        }
        throw e.c("Mismatched number of dex files found in metadata");
    }

    static d[] t(InputStream inputStream, byte[] bArr, d[] dVarArr) {
        int h5 = e.h(inputStream);
        byte[] e5 = e.e(inputStream, (int) e.i(inputStream), (int) e.i(inputStream));
        if (inputStream.read() <= 0) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(e5);
            try {
                d[] u5 = u(byteArrayInputStream, bArr, h5, dVarArr);
                byteArrayInputStream.close();
                return u5;
            } catch (Throwable th) {
                try {
                    byteArrayInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        throw e.c("Content found after the end of file");
    }

    private static d[] u(InputStream inputStream, byte[] bArr, int i5, d[] dVarArr) {
        if (inputStream.available() == 0) {
            return new d[0];
        }
        if (i5 == dVarArr.length) {
            for (int i6 = 0; i6 < i5; i6++) {
                e.h(inputStream);
                String f5 = e.f(inputStream, e.h(inputStream));
                long i7 = e.i(inputStream);
                int h5 = e.h(inputStream);
                d i8 = i(dVarArr, f5);
                if (i8 == null) {
                    throw e.c("Missing profile key: " + f5);
                }
                i8.f642d = i7;
                int[] m5 = m(inputStream, h5);
                if (Arrays.equals(bArr, p.f681e)) {
                    i8.f643e = h5;
                    i8.f646h = m5;
                }
            }
            return dVarArr;
        }
        throw e.c("Mismatched number of dex files found in metadata");
    }

    private static void v(InputStream inputStream, d dVar) {
        BitSet valueOf = BitSet.valueOf(e.d(inputStream, e.a(dVar.f645g * 2)));
        int i5 = 0;
        while (true) {
            int i6 = dVar.f645g;
            if (i5 >= i6) {
                return;
            }
            int n5 = n(valueOf, i5, i6);
            if (n5 != 0) {
                Integer num = dVar.f647i.get(Integer.valueOf(i5));
                if (num == null) {
                    num = 0;
                }
                dVar.f647i.put(Integer.valueOf(i5), Integer.valueOf(n5 | num.intValue()));
            }
            i5++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d[] w(InputStream inputStream, byte[] bArr, String str) {
        if (Arrays.equals(bArr, p.f678b)) {
            int j5 = e.j(inputStream);
            byte[] e5 = e.e(inputStream, (int) e.i(inputStream), (int) e.i(inputStream));
            if (inputStream.read() <= 0) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(e5);
                try {
                    d[] x4 = x(byteArrayInputStream, str, j5);
                    byteArrayInputStream.close();
                    return x4;
                } catch (Throwable th) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
            throw e.c("Content found after the end of file");
        }
        throw e.c("Unsupported version");
    }

    private static d[] x(InputStream inputStream, String str, int i5) {
        if (inputStream.available() == 0) {
            return new d[0];
        }
        d[] dVarArr = new d[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            int h5 = e.h(inputStream);
            int h6 = e.h(inputStream);
            long i7 = e.i(inputStream);
            dVarArr[i6] = new d(str, e.f(inputStream, h5), e.i(inputStream), 0L, h6, (int) i7, (int) e.i(inputStream), new int[h6], new TreeMap());
        }
        for (int i8 = 0; i8 < i5; i8++) {
            d dVar = dVarArr[i8];
            p(inputStream, dVar);
            dVar.f646h = m(inputStream, dVar.f643e);
            v(inputStream, dVar);
        }
        return dVarArr;
    }

    private static int y(int i5) {
        return ((i5 + 8) - 1) & (-8);
    }

    private static void z(byte[] bArr, int i5, int i6, d dVar) {
        int l5 = l(i5, i6, dVar.f645g);
        int i7 = l5 / 8;
        bArr[i7] = (byte) ((1 << (l5 % 8)) | bArr[i7]);
    }
}
