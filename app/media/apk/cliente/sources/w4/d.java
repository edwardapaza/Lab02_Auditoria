package w4;

import java.nio.channels.WritableByteChannel;
/* loaded from: classes.dex */
public interface d extends m, WritableByteChannel {
    d b0(String str);

    @Override // w4.m, java.io.Flushable
    void flush();

    d write(byte[] bArr);

    d writeByte(int i5);

    d writeInt(int i5);

    d writeShort(int i5);
}
