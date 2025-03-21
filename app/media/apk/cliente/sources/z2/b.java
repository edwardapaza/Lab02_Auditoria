package z2;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public interface b {

    /* loaded from: classes.dex */
    public interface a {
        void a(ByteBuffer byteBuffer, InterfaceC0139b interfaceC0139b);
    }

    /* renamed from: z2.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0139b {
        void a(ByteBuffer byteBuffer);
    }

    /* loaded from: classes.dex */
    public interface c {
    }

    void a(String str, ByteBuffer byteBuffer, InterfaceC0139b interfaceC0139b);

    void b(String str, a aVar);

    void c(String str, ByteBuffer byteBuffer);

    void e(String str, a aVar, c cVar);
}
