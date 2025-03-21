package com.google.protobuf;

import com.google.android.gms.common.api.a;
import com.google.protobuf.a;
import com.google.protobuf.c2;
import com.google.protobuf.d0;
import com.google.protobuf.f;
import com.google.protobuf.v;
import com.google.protobuf.w0;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public abstract class z<MessageType extends z<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends com.google.protobuf.a<MessageType, BuilderType> {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Object, z<?, ?>> defaultInstanceMap = new ConcurrentHashMap();
    private int memoizedSerializedSize = -1;
    protected x1 unknownFields = x1.c();

    /* loaded from: classes.dex */
    public static abstract class a<MessageType extends z<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends a.AbstractC0043a<MessageType, BuilderType> {

        /* renamed from: a  reason: collision with root package name */
        private final MessageType f2202a;

        /* renamed from: b  reason: collision with root package name */
        protected MessageType f2203b;

        /* JADX INFO: Access modifiers changed from: protected */
        public a(MessageType messagetype) {
            this.f2202a = messagetype;
            if (messagetype.N()) {
                throw new IllegalArgumentException("Default instance must be immutable.");
            }
            this.f2203b = D();
        }

        private static <MessageType> void C(MessageType messagetype, MessageType messagetype2) {
            j1.a().d(messagetype).a(messagetype, messagetype2);
        }

        private MessageType D() {
            return (MessageType) this.f2202a.T();
        }

        @Override // com.google.protobuf.w0.a
        /* renamed from: A */
        public BuilderType h(j jVar, q qVar) {
            w();
            try {
                j1.a().d(this.f2203b).e(this.f2203b, k.Q(jVar), qVar);
                return this;
            } catch (RuntimeException e5) {
                if (e5.getCause() instanceof IOException) {
                    throw ((IOException) e5.getCause());
                }
                throw e5;
            }
        }

        public BuilderType B(MessageType messagetype) {
            if (b().equals(messagetype)) {
                return this;
            }
            w();
            C(this.f2203b, messagetype);
            return this;
        }

        @Override // com.google.protobuf.x0
        public final boolean n() {
            return z.M(this.f2203b, false);
        }

        @Override // com.google.protobuf.w0.a
        /* renamed from: t */
        public final MessageType build() {
            MessageType i5 = i();
            if (i5.n()) {
                return i5;
            }
            throw a.AbstractC0043a.s(i5);
        }

        @Override // com.google.protobuf.w0.a
        /* renamed from: u */
        public MessageType i() {
            if (this.f2203b.N()) {
                this.f2203b.O();
                return this.f2203b;
            }
            return this.f2203b;
        }

        /* renamed from: v */
        public BuilderType clone() {
            BuilderType buildertype = (BuilderType) b().k();
            buildertype.f2203b = i();
            return buildertype;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void w() {
            if (this.f2203b.N()) {
                return;
            }
            x();
        }

        protected void x() {
            MessageType D = D();
            C(D, this.f2203b);
            this.f2203b = D;
        }

        @Override // com.google.protobuf.x0
        /* renamed from: y */
        public MessageType b() {
            return this.f2202a;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.a.AbstractC0043a
        /* renamed from: z */
        public BuilderType q(MessageType messagetype) {
            return B(messagetype);
        }
    }

    /* loaded from: classes.dex */
    protected static class b<T extends z<T, ?>> extends com.google.protobuf.b<T> {

        /* renamed from: b  reason: collision with root package name */
        private final T f2204b;

        public b(T t5) {
            this.f2204b = t5;
        }

        @Override // com.google.protobuf.g1
        /* renamed from: i */
        public T c(j jVar, q qVar) {
            return (T) z.Y(this.f2204b, jVar, qVar);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class c<MessageType extends c<MessageType, BuilderType>, BuilderType> extends z<MessageType, BuilderType> implements x0 {
        protected v<d> extensions = v.h();

        /* JADX INFO: Access modifiers changed from: package-private */
        public v<d> d0() {
            if (this.extensions.o()) {
                this.extensions = this.extensions.clone();
            }
            return this.extensions;
        }
    }

    /* loaded from: classes.dex */
    static final class d implements v.b<d> {

        /* renamed from: a  reason: collision with root package name */
        final d0.d<?> f2205a;

        /* renamed from: b  reason: collision with root package name */
        final int f2206b;

        /* renamed from: c  reason: collision with root package name */
        final c2.b f2207c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f2208d;

        /* renamed from: e  reason: collision with root package name */
        final boolean f2209e;

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(d dVar) {
            return this.f2206b - dVar.f2206b;
        }

        @Override // com.google.protobuf.v.b
        public int b() {
            return this.f2206b;
        }

        public d0.d<?> c() {
            return this.f2205a;
        }

        @Override // com.google.protobuf.v.b
        public boolean f() {
            return this.f2208d;
        }

        @Override // com.google.protobuf.v.b
        public c2.b g() {
            return this.f2207c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.v.b
        public w0.a i(w0.a aVar, w0 w0Var) {
            return ((a) aVar).B((z) w0Var);
        }

        @Override // com.google.protobuf.v.b
        public c2.c j() {
            return this.f2207c.a();
        }

        @Override // com.google.protobuf.v.b
        public boolean l() {
            return this.f2209e;
        }
    }

    /* loaded from: classes.dex */
    public static class e<ContainingType extends w0, Type> extends o<ContainingType, Type> {

        /* renamed from: a  reason: collision with root package name */
        final w0 f2210a;

        /* renamed from: b  reason: collision with root package name */
        final d f2211b;

        public c2.b a() {
            return this.f2211b.g();
        }

        public w0 b() {
            return this.f2210a;
        }

        public int c() {
            return this.f2211b.b();
        }

        public boolean d() {
            return this.f2211b.f2208d;
        }
    }

    /* loaded from: classes.dex */
    public enum f {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static d0.g F() {
        return c0.m();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> d0.i<E> G() {
        return k1.i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends z<?, ?>> T H(Class<T> cls) {
        z<?, ?> zVar = defaultInstanceMap.get(cls);
        if (zVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zVar = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e5) {
                throw new IllegalStateException("Class initialization cannot fail.", e5);
            }
        }
        if (zVar == null) {
            zVar = (T) ((z) a2.l(cls)).b();
            if (zVar == null) {
                throw new IllegalStateException();
            }
            defaultInstanceMap.put(cls, zVar);
        }
        return (T) zVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object L(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e5) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e5);
        } catch (InvocationTargetException e6) {
            Throwable cause = e6.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    protected static final <T extends z<T, ?>> boolean M(T t5, boolean z4) {
        byte byteValue = ((Byte) t5.C(f.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean d5 = j1.a().d(t5).d(t5);
        if (z4) {
            t5.D(f.SET_MEMOIZED_IS_INITIALIZED, d5 ? t5 : null);
        }
        return d5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> d0.i<E> Q(d0.i<E> iVar) {
        int size = iVar.size();
        return iVar.b(size == 0 ? 10 : size * 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object S(w0 w0Var, String str, Object[] objArr) {
        return new l1(w0Var, str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends z<T, ?>> T U(T t5, i iVar) {
        return (T) v(V(t5, iVar, q.b()));
    }

    protected static <T extends z<T, ?>> T V(T t5, i iVar, q qVar) {
        return (T) v(X(t5, iVar, qVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends z<T, ?>> T W(T t5, byte[] bArr) {
        return (T) v(Z(t5, bArr, 0, bArr.length, q.b()));
    }

    private static <T extends z<T, ?>> T X(T t5, i iVar, q qVar) {
        j A = iVar.A();
        T t6 = (T) Y(t5, A, qVar);
        try {
            A.a(0);
            return t6;
        } catch (e0 e5) {
            throw e5.k(t6);
        }
    }

    static <T extends z<T, ?>> T Y(T t5, j jVar, q qVar) {
        T t6 = (T) t5.T();
        try {
            o1 d5 = j1.a().d(t6);
            d5.e(t6, k.Q(jVar), qVar);
            d5.c(t6);
            return t6;
        } catch (e0 e5) {
            e = e5;
            if (e.a()) {
                e = new e0(e);
            }
            throw e.k(t6);
        } catch (v1 e6) {
            throw e6.a().k(t6);
        } catch (IOException e7) {
            if (e7.getCause() instanceof e0) {
                throw ((e0) e7.getCause());
            }
            throw new e0(e7).k(t6);
        } catch (RuntimeException e8) {
            if (e8.getCause() instanceof e0) {
                throw ((e0) e8.getCause());
            }
            throw e8;
        }
    }

    private static <T extends z<T, ?>> T Z(T t5, byte[] bArr, int i5, int i6, q qVar) {
        T t6 = (T) t5.T();
        try {
            o1 d5 = j1.a().d(t6);
            d5.g(t6, bArr, i5, i5 + i6, new f.b(qVar));
            d5.c(t6);
            return t6;
        } catch (e0 e5) {
            e = e5;
            if (e.a()) {
                e = new e0(e);
            }
            throw e.k(t6);
        } catch (v1 e6) {
            throw e6.a().k(t6);
        } catch (IOException e7) {
            if (e7.getCause() instanceof e0) {
                throw ((e0) e7.getCause());
            }
            throw new e0(e7).k(t6);
        } catch (IndexOutOfBoundsException unused) {
            throw e0.m().k(t6);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends z<?, ?>> void a0(Class<T> cls, T t5) {
        t5.P();
        defaultInstanceMap.put(cls, t5);
    }

    private static <T extends z<T, ?>> T v(T t5) {
        if (t5 == null || t5.n()) {
            return t5;
        }
        throw t5.s().a().k(t5);
    }

    private int z(o1<?> o1Var) {
        return o1Var == null ? j1.a().d(this).h(this) : o1Var.h(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <MessageType extends z<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> BuilderType A() {
        return (BuilderType) C(f.NEW_BUILDER);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <MessageType extends z<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> BuilderType B(MessageType messagetype) {
        return (BuilderType) A().B(messagetype);
    }

    protected Object C(f fVar) {
        return E(fVar, null, null);
    }

    protected Object D(f fVar, Object obj) {
        return E(fVar, obj, null);
    }

    protected abstract Object E(f fVar, Object obj, Object obj2);

    @Override // com.google.protobuf.x0
    /* renamed from: I */
    public final MessageType b() {
        return (MessageType) C(f.GET_DEFAULT_INSTANCE);
    }

    int J() {
        return this.memoizedHashCode;
    }

    boolean K() {
        return J() == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean N() {
        return (this.memoizedSerializedSize & MUTABLE_FLAG_MASK) != 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void O() {
        j1.a().d(this).c(this);
        P();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P() {
        this.memoizedSerializedSize &= a.e.API_PRIORITY_OTHER;
    }

    @Override // com.google.protobuf.w0
    /* renamed from: R */
    public final BuilderType k() {
        return (BuilderType) C(f.NEW_BUILDER);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MessageType T() {
        return (MessageType) C(f.NEW_MUTABLE_INSTANCE);
    }

    @Override // com.google.protobuf.w0
    public int a() {
        return q(null);
    }

    void b0(int i5) {
        this.memoizedHashCode = i5;
    }

    @Override // com.google.protobuf.w0
    /* renamed from: c0 */
    public final BuilderType c() {
        return (BuilderType) ((a) C(f.NEW_BUILDER)).B(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return j1.a().d(this).f(this, (z) obj);
        }
        return false;
    }

    @Override // com.google.protobuf.w0
    public void f(l lVar) {
        j1.a().d(this).b(this, m.P(lVar));
    }

    public int hashCode() {
        if (N()) {
            return y();
        }
        if (K()) {
            b0(y());
        }
        return J();
    }

    @Override // com.google.protobuf.w0
    public final g1<MessageType> m() {
        return (g1) C(f.GET_PARSER);
    }

    @Override // com.google.protobuf.x0
    public final boolean n() {
        return M(this, true);
    }

    @Override // com.google.protobuf.a
    int p() {
        return this.memoizedSerializedSize & a.e.API_PRIORITY_OTHER;
    }

    @Override // com.google.protobuf.a
    int q(o1 o1Var) {
        if (!N()) {
            if (p() != Integer.MAX_VALUE) {
                return p();
            }
            int z4 = z(o1Var);
            t(z4);
            return z4;
        }
        int z5 = z(o1Var);
        if (z5 >= 0) {
            return z5;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + z5);
    }

    @Override // com.google.protobuf.a
    void t(int i5) {
        if (i5 >= 0) {
            this.memoizedSerializedSize = (i5 & a.e.API_PRIORITY_OTHER) | (this.memoizedSerializedSize & MUTABLE_FLAG_MASK);
            return;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + i5);
    }

    public String toString() {
        return y0.f(this, super.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object u() {
        return C(f.BUILD_MESSAGE_INFO);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w() {
        this.memoizedHashCode = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x() {
        t(a.e.API_PRIORITY_OTHER);
    }

    int y() {
        return j1.a().d(this).j(this);
    }
}
