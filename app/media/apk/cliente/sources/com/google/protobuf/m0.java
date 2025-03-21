package com.google.protobuf;

import com.google.protobuf.d0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
abstract class m0 {

    /* renamed from: a  reason: collision with root package name */
    private static final m0 f2066a = new b();

    /* renamed from: b  reason: collision with root package name */
    private static final m0 f2067b = new c();

    /* loaded from: classes.dex */
    private static final class b extends m0 {

        /* renamed from: c  reason: collision with root package name */
        private static final Class<?> f2068c = Collections.unmodifiableList(Collections.emptyList()).getClass();

        private b() {
            super();
        }

        static <E> List<E> f(Object obj, long j5) {
            return (List) a2.G(obj, j5);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static <L> List<L> g(Object obj, long j5, int i5) {
            List<L> b5;
            k0 k0Var;
            List<L> f5 = f(obj, j5);
            if (!f5.isEmpty()) {
                if (f2068c.isAssignableFrom(f5.getClass())) {
                    ArrayList arrayList = new ArrayList(f5.size() + i5);
                    arrayList.addAll(f5);
                    k0Var = arrayList;
                } else if (f5 instanceof z1) {
                    k0 k0Var2 = new k0(f5.size() + i5);
                    k0Var2.addAll((z1) f5);
                    k0Var = k0Var2;
                } else if (!(f5 instanceof h1) || !(f5 instanceof d0.i)) {
                    return f5;
                } else {
                    d0.i iVar = (d0.i) f5;
                    if (iVar.j()) {
                        return f5;
                    }
                    b5 = iVar.b(f5.size() + i5);
                }
                a2.V(obj, j5, k0Var);
                return k0Var;
            }
            b5 = f5 instanceof l0 ? new k0(i5) : ((f5 instanceof h1) && (f5 instanceof d0.i)) ? ((d0.i) f5).b(i5) : new ArrayList<>(i5);
            a2.V(obj, j5, b5);
            return b5;
        }

        @Override // com.google.protobuf.m0
        void c(Object obj, long j5) {
            Object unmodifiableList;
            List list = (List) a2.G(obj, j5);
            if (list instanceof l0) {
                unmodifiableList = ((l0) list).d();
            } else if (f2068c.isAssignableFrom(list.getClass())) {
                return;
            } else {
                if ((list instanceof h1) && (list instanceof d0.i)) {
                    d0.i iVar = (d0.i) list;
                    if (iVar.j()) {
                        iVar.a();
                        return;
                    }
                    return;
                }
                unmodifiableList = Collections.unmodifiableList(list);
            }
            a2.V(obj, j5, unmodifiableList);
        }

        @Override // com.google.protobuf.m0
        <E> void d(Object obj, Object obj2, long j5) {
            List f5 = f(obj2, j5);
            List g5 = g(obj, j5, f5.size());
            int size = g5.size();
            int size2 = f5.size();
            if (size > 0 && size2 > 0) {
                g5.addAll(f5);
            }
            if (size > 0) {
                f5 = g5;
            }
            a2.V(obj, j5, f5);
        }

        @Override // com.google.protobuf.m0
        <L> List<L> e(Object obj, long j5) {
            return g(obj, j5, 10);
        }
    }

    /* loaded from: classes.dex */
    private static final class c extends m0 {
        private c() {
            super();
        }

        static <E> d0.i<E> f(Object obj, long j5) {
            return (d0.i) a2.G(obj, j5);
        }

        @Override // com.google.protobuf.m0
        void c(Object obj, long j5) {
            f(obj, j5).a();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
        @Override // com.google.protobuf.m0
        <E> void d(Object obj, Object obj2, long j5) {
            d0.i<E> f5 = f(obj, j5);
            d0.i<E> f6 = f(obj2, j5);
            int size = f5.size();
            int size2 = f6.size();
            d0.i<E> iVar = f5;
            iVar = f5;
            if (size > 0 && size2 > 0) {
                boolean j6 = f5.j();
                d0.i<E> iVar2 = f5;
                if (!j6) {
                    iVar2 = f5.b(size2 + size);
                }
                iVar2.addAll(f6);
                iVar = iVar2;
            }
            if (size > 0) {
                f6 = iVar;
            }
            a2.V(obj, j5, f6);
        }

        @Override // com.google.protobuf.m0
        <L> List<L> e(Object obj, long j5) {
            d0.i f5 = f(obj, j5);
            if (f5.j()) {
                return f5;
            }
            int size = f5.size();
            d0.i b5 = f5.b(size == 0 ? 10 : size * 2);
            a2.V(obj, j5, b5);
            return b5;
        }
    }

    private m0() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static m0 a() {
        return f2066a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static m0 b() {
        return f2067b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void c(Object obj, long j5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <L> void d(Object obj, Object obj2, long j5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <L> List<L> e(Object obj, long j5);
}
