package b4;

import e4.k;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import s3.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends e {
    public static byte[] a(File file) {
        k.e(file, "<this>");
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            long length = file.length();
            if (length > 2147483647L) {
                throw new OutOfMemoryError("File " + file + " is too big (" + length + " bytes) to fit in memory.");
            }
            int i5 = (int) length;
            byte[] bArr = new byte[i5];
            int i6 = i5;
            int i7 = 0;
            while (i6 > 0) {
                int read = fileInputStream.read(bArr, i7, i6);
                if (read < 0) {
                    break;
                }
                i6 -= read;
                i7 += read;
            }
            if (i6 > 0) {
                bArr = Arrays.copyOf(bArr, i7);
                k.d(bArr, "copyOf(this, newSize)");
            } else {
                int read2 = fileInputStream.read();
                if (read2 != -1) {
                    c cVar = new c(8193);
                    cVar.write(read2);
                    a.b(fileInputStream, cVar, 0, 2, null);
                    int size = cVar.size() + i5;
                    if (size < 0) {
                        throw new OutOfMemoryError("File " + file + " is too big to fit in memory.");
                    }
                    byte[] c5 = cVar.c();
                    byte[] copyOf = Arrays.copyOf(bArr, size);
                    k.d(copyOf, "copyOf(this, newSize)");
                    bArr = t3.g.c(c5, copyOf, i5, 0, cVar.size());
                }
            }
            b.a(fileInputStream, null);
            return bArr;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                b.a(fileInputStream, th);
                throw th2;
            }
        }
    }

    public static void b(File file, byte[] bArr) {
        k.e(file, "<this>");
        k.e(bArr, "array");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(bArr);
            t tVar = t.f7573a;
            b.a(fileOutputStream, null);
        } finally {
        }
    }
}
