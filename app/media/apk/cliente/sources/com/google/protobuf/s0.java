package com.google.protobuf;

import com.google.protobuf.p0;
import java.util.Map;
/* loaded from: classes.dex */
class s0 implements r0 {
    private static <K, V> int i(int i5, Object obj, Object obj2) {
        q0 q0Var = (q0) obj;
        p0 p0Var = (p0) obj2;
        int i6 = 0;
        if (q0Var.isEmpty()) {
            return 0;
        }
        for (Map.Entry<K, V> entry : q0Var.entrySet()) {
            i6 += p0Var.a(i5, entry.getKey(), entry.getValue());
        }
        return i6;
    }

    private static <K, V> q0<K, V> j(Object obj, Object obj2) {
        q0<K, V> q0Var = (q0) obj;
        q0<K, V> q0Var2 = (q0) obj2;
        if (!q0Var2.isEmpty()) {
            if (!q0Var.k()) {
                q0Var = q0Var.n();
            }
            q0Var.m(q0Var2);
        }
        return q0Var;
    }

    @Override // com.google.protobuf.r0
    public Object a(Object obj, Object obj2) {
        return j(obj, obj2);
    }

    @Override // com.google.protobuf.r0
    public Object b(Object obj) {
        return q0.d().n();
    }

    @Override // com.google.protobuf.r0
    public int c(int i5, Object obj, Object obj2) {
        return i(i5, obj, obj2);
    }

    @Override // com.google.protobuf.r0
    public boolean d(Object obj) {
        return !((q0) obj).k();
    }

    @Override // com.google.protobuf.r0
    public Object e(Object obj) {
        ((q0) obj).l();
        return obj;
    }

    @Override // com.google.protobuf.r0
    public p0.a<?, ?> f(Object obj) {
        return ((p0) obj).c();
    }

    @Override // com.google.protobuf.r0
    public Map<?, ?> g(Object obj) {
        return (q0) obj;
    }

    @Override // com.google.protobuf.r0
    public Map<?, ?> h(Object obj) {
        return (q0) obj;
    }
}
