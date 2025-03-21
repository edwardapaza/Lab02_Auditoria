package w4;

import java.nio.channels.ReadableByteChannel;
/* loaded from: classes.dex */
public interface e extends n, ReadableByteChannel {
    c B();

    boolean C();

    byte[] G(long j5);

    void Y(long j5);

    f k(long j5);

    byte readByte();

    int readInt();

    short readShort();

    void skip(long j5);
}
