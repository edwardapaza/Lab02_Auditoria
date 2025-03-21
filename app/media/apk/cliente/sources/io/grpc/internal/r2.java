package io.grpc.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;
/* loaded from: classes.dex */
public final class r2 {

    /* renamed from: a  reason: collision with root package name */
    private static final Logger f5155a = Logger.getLogger(r2.class.getName());

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f5156b = "-bin".getBytes(z0.b.f8862a);

    private r2() {
    }

    private static boolean a(byte[] bArr, byte[] bArr2) {
        int length = bArr.length - bArr2.length;
        if (length < 0) {
            return false;
        }
        for (int i5 = length; i5 < bArr.length; i5++) {
            if (bArr[i5] != bArr2[i5 - length]) {
                return false;
            }
        }
        return true;
    }

    private static boolean b(byte[] bArr) {
        for (byte b5 : bArr) {
            if (b5 < 32 || b5 > 126) {
                return false;
            }
        }
        return true;
    }

    private static byte[][] c(byte[][] bArr, int i5) {
        ArrayList arrayList = new ArrayList(bArr.length + 10);
        for (int i6 = 0; i6 < i5; i6++) {
            arrayList.add(bArr[i6]);
        }
        while (i5 < bArr.length) {
            byte[] bArr2 = bArr[i5];
            byte[] bArr3 = bArr[i5 + 1];
            if (a(bArr2, f5156b)) {
                int i7 = 0;
                for (int i8 = 0; i8 <= bArr3.length; i8++) {
                    if (i8 == bArr3.length || bArr3[i8] == 44) {
                        byte[] b5 = b1.a.a().b(new String(bArr3, i7, i8 - i7, z0.b.f8862a));
                        arrayList.add(bArr2);
                        arrayList.add(b5);
                        i7 = i8 + 1;
                    }
                }
            } else {
                arrayList.add(bArr2);
                arrayList.add(bArr3);
            }
            i5 += 2;
        }
        return (byte[][]) arrayList.toArray(new byte[0]);
    }

    public static byte[][] d(i3.y0 y0Var) {
        byte[][] d5 = i3.m0.d(y0Var);
        if (d5 == null) {
            return new byte[0];
        }
        int i5 = 0;
        for (int i6 = 0; i6 < d5.length; i6 += 2) {
            byte[] bArr = d5[i6];
            byte[] bArr2 = d5[i6 + 1];
            if (a(bArr, f5156b)) {
                d5[i5] = bArr;
                d5[i5 + 1] = i3.m0.f3500b.e(bArr2).getBytes(z0.b.f8862a);
            } else if (b(bArr2)) {
                d5[i5] = bArr;
                d5[i5 + 1] = bArr2;
            } else {
                String str = new String(bArr, z0.b.f8862a);
                Logger logger = f5155a;
                logger.warning("Metadata key=" + str + ", value=" + Arrays.toString(bArr2) + " contains invalid ASCII characters");
            }
            i5 += 2;
        }
        return i5 == d5.length ? d5 : (byte[][]) Arrays.copyOfRange(d5, 0, i5);
    }

    public static byte[][] e(byte[][] bArr) {
        for (int i5 = 0; i5 < bArr.length; i5 += 2) {
            byte[] bArr2 = bArr[i5];
            int i6 = i5 + 1;
            byte[] bArr3 = bArr[i6];
            if (a(bArr2, f5156b)) {
                for (byte b5 : bArr3) {
                    if (b5 == 44) {
                        return c(bArr, i5);
                    }
                }
                bArr[i6] = b1.a.a().b(new String(bArr3, z0.b.f8862a));
            }
        }
        return bArr;
    }
}
