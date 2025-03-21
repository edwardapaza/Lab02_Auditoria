package b4;

import e4.k;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes.dex */
public final class a {
    public static final long a(InputStream inputStream, OutputStream outputStream, int i5) {
        k.e(inputStream, "<this>");
        k.e(outputStream, "out");
        byte[] bArr = new byte[i5];
        int read = inputStream.read(bArr);
        long j5 = 0;
        while (read >= 0) {
            outputStream.write(bArr, 0, read);
            j5 += read;
            read = inputStream.read(bArr);
        }
        return j5;
    }

    public static /* synthetic */ long b(InputStream inputStream, OutputStream outputStream, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i5 = 8192;
        }
        return a(inputStream, outputStream, i5);
    }
}
