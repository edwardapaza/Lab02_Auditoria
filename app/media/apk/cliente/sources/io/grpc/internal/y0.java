package io.grpc.internal;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
/* loaded from: classes.dex */
public abstract class y0<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Set<T> f5320a = Collections.newSetFromMap(new IdentityHashMap());

    public final boolean a(Object... objArr) {
        for (Object obj : objArr) {
            if (this.f5320a.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    protected abstract void b();

    protected abstract void c();

    public final boolean d() {
        return !this.f5320a.isEmpty();
    }

    public final void e(T t5, boolean z4) {
        int size = this.f5320a.size();
        if (z4) {
            this.f5320a.add(t5);
            if (size == 0) {
                b();
            }
        } else if (this.f5320a.remove(t5) && size == 1) {
            c();
        }
    }
}
