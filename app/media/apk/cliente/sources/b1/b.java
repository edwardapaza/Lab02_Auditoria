package b1;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import z0.k;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final OutputStream f753a = new a();

    /* loaded from: classes.dex */
    class a extends OutputStream {
        a() {
        }

        public String toString() {
            return "ByteStreams.nullOutputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i5) {
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
            k.n(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i5, int i6) {
            k.n(bArr);
            k.s(i5, i6 + i5, bArr.length);
        }
    }

    private static byte[] a(Queue<byte[]> queue, int i5) {
        if (queue.isEmpty()) {
            return new byte[0];
        }
        byte[] remove = queue.remove();
        if (remove.length == i5) {
            return remove;
        }
        int length = i5 - remove.length;
        byte[] copyOf = Arrays.copyOf(remove, i5);
        while (length > 0) {
            byte[] remove2 = queue.remove();
            int min = Math.min(length, remove2.length);
            System.arraycopy(remove2, 0, copyOf, i5 - length, min);
            length -= min;
        }
        return copyOf;
    }

    public static long b(InputStream inputStream, OutputStream outputStream) {
        k.n(inputStream);
        k.n(outputStream);
        byte[] c5 = c();
        long j5 = 0;
        while (true) {
            int read = inputStream.read(c5);
            if (read == -1) {
                return j5;
            }
            outputStream.write(c5, 0, read);
            j5 += read;
        }
    }

    static byte[] c() {
        return new byte[8192];
    }

    public static byte[] d(InputStream inputStream) {
        k.n(inputStream);
        return e(inputStream, new ArrayDeque(20), 0);
    }

    private static byte[] e(InputStream inputStream, Queue<byte[]> queue, int i5) {
        int min = Math.min(8192, Math.max(128, Integer.highestOneBit(i5) * 2));
        while (i5 < 2147483639) {
            int min2 = Math.min(min, 2147483639 - i5);
            byte[] bArr = new byte[min2];
            queue.add(bArr);
            int i6 = 0;
            while (i6 < min2) {
                int read = inputStream.read(bArr, i6, min2 - i6);
                if (read == -1) {
                    return a(queue, i5);
                }
                i6 += read;
                i5 += read;
            }
            min = c1.a.e(min, min < 4096 ? 4 : 2);
        }
        if (inputStream.read() == -1) {
            return a(queue, 2147483639);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }
}
