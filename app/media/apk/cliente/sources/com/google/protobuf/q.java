package com.google.protobuf;

import com.google.protobuf.z;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class q {

    /* renamed from: b  reason: collision with root package name */
    private static boolean f2098b = true;

    /* renamed from: c  reason: collision with root package name */
    private static volatile q f2099c;

    /* renamed from: d  reason: collision with root package name */
    static final q f2100d = new q(true);

    /* renamed from: a  reason: collision with root package name */
    private final Map<a, z.e<?, ?>> f2101a;

    /* loaded from: classes.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Object f2102a;

        /* renamed from: b  reason: collision with root package name */
        private final int f2103b;

        a(Object obj, int i5) {
            this.f2102a = obj;
            this.f2103b = i5;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.f2102a == aVar.f2102a && this.f2103b == aVar.f2103b;
            }
            return false;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f2102a) * 65535) + this.f2103b;
        }
    }

    q() {
        this.f2101a = new HashMap();
    }

    q(boolean z4) {
        this.f2101a = Collections.emptyMap();
    }

    public static q b() {
        if (f2098b) {
            q qVar = f2099c;
            if (qVar == null) {
                synchronized (q.class) {
                    qVar = f2099c;
                    if (qVar == null) {
                        qVar = p.a();
                        f2099c = qVar;
                    }
                }
            }
            return qVar;
        }
        return f2100d;
    }

    public <ContainingType extends w0> z.e<ContainingType, ?> a(ContainingType containingtype, int i5) {
        return (z.e<ContainingType, ?>) this.f2101a.get(new a(containingtype, i5));
    }
}
