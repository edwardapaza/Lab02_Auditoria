package w4;

import java.io.Closeable;
import java.io.Flushable;
/* loaded from: classes.dex */
public interface m extends Closeable, Flushable {
    void Z(c cVar, long j5);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void flush();
}
