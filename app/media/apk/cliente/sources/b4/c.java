package b4;

import e4.k;
import java.io.ByteArrayOutputStream;
/* loaded from: classes.dex */
final class c extends ByteArrayOutputStream {
    public c(int i5) {
        super(i5);
    }

    public final byte[] c() {
        byte[] bArr = ((ByteArrayOutputStream) this).buf;
        k.d(bArr, "buf");
        return bArr;
    }
}
