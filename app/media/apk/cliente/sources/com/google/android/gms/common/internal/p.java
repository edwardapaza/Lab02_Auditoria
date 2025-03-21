package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public final class p {

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List f1188a;

        /* renamed from: b  reason: collision with root package name */
        private final Object f1189b;

        /* synthetic */ a(Object obj, t0 t0Var) {
            q.k(obj);
            this.f1189b = obj;
            this.f1188a = new ArrayList();
        }

        public a a(String str, Object obj) {
            q.k(str);
            String valueOf = String.valueOf(obj);
            this.f1188a.add(str + "=" + valueOf);
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(100);
            sb.append(this.f1189b.getClass().getSimpleName());
            sb.append('{');
            int size = this.f1188a.size();
            for (int i5 = 0; i5 < size; i5++) {
                sb.append((String) this.f1188a.get(i5));
                if (i5 < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append('}');
            return sb.toString();
        }
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int b(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static a c(Object obj) {
        return new a(obj, null);
    }
}
