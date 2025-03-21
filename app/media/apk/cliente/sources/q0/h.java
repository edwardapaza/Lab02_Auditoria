package q0;
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f6931a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f6932b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(byte[] bArr) {
        return b(bArr, false);
    }

    public static String b(byte[] bArr, boolean z4) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(length + length);
        for (int i5 = 0; i5 < length && (!z4 || i5 != length - 1 || (bArr[i5] & 255) != 0); i5++) {
            char[] cArr = f6931a;
            sb.append(cArr[(bArr[i5] & 240) >>> 4]);
            sb.append(cArr[bArr[i5] & 15]);
        }
        return sb.toString();
    }
}
