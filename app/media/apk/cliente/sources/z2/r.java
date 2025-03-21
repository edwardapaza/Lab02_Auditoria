package z2;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
/* loaded from: classes.dex */
public final class r implements h<String> {

    /* renamed from: a  reason: collision with root package name */
    private static final Charset f9020a = Charset.forName("UTF8");

    /* renamed from: b  reason: collision with root package name */
    public static final r f9021b = new r();

    private r() {
    }

    @Override // z2.h
    /* renamed from: c */
    public String b(ByteBuffer byteBuffer) {
        byte[] bArr;
        int i5;
        if (byteBuffer == null) {
            return null;
        }
        int remaining = byteBuffer.remaining();
        if (byteBuffer.hasArray()) {
            bArr = byteBuffer.array();
            i5 = byteBuffer.arrayOffset();
        } else {
            bArr = new byte[remaining];
            byteBuffer.get(bArr);
            i5 = 0;
        }
        return new String(bArr, i5, remaining, f9020a);
    }

    @Override // z2.h
    /* renamed from: d */
    public ByteBuffer a(String str) {
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes(f9020a);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bytes.length);
        allocateDirect.put(bytes);
        return allocateDirect;
    }
}
