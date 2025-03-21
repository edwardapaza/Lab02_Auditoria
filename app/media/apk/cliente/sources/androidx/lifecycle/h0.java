package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public abstract class h0 {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, Object> f541a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Set<Closeable> f542b = new LinkedHashSet();

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f543c = false;

    private static void b(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e5) {
                throw new RuntimeException(e5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        this.f543c = true;
        Map<String, Object> map = this.f541a;
        if (map != null) {
            synchronized (map) {
                for (Object obj : this.f541a.values()) {
                    b(obj);
                }
            }
        }
        Set<Closeable> set = this.f542b;
        if (set != null) {
            synchronized (set) {
                for (Closeable closeable : this.f542b) {
                    b(closeable);
                }
            }
            this.f542b.clear();
        }
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
    }
}
