package com.google.protobuf;

import com.google.protobuf.a;
import com.google.protobuf.a.AbstractC0043a;
import com.google.protobuf.i;
import com.google.protobuf.w0;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a<MessageType extends a<MessageType, BuilderType>, BuilderType extends AbstractC0043a<MessageType, BuilderType>> implements w0 {
    protected int memoizedHashCode = 0;

    /* renamed from: com.google.protobuf.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0043a<MessageType extends a<MessageType, BuilderType>, BuilderType extends AbstractC0043a<MessageType, BuilderType>> implements w0.a {
        protected static <T> void o(Iterable<T> iterable, List<? super T> list) {
            d0.a(iterable);
            if (!(iterable instanceof l0)) {
                if (iterable instanceof h1) {
                    list.addAll((Collection) iterable);
                    return;
                } else {
                    p(iterable, list);
                    return;
                }
            }
            List<?> f5 = ((l0) iterable).f();
            l0 l0Var = (l0) list;
            int size = list.size();
            for (Object obj : f5) {
                if (obj == null) {
                    String str = "Element at index " + (l0Var.size() - size) + " is null.";
                    for (int size2 = l0Var.size() - 1; size2 >= size; size2--) {
                        l0Var.remove(size2);
                    }
                    throw new NullPointerException(str);
                } else if (obj instanceof i) {
                    l0Var.c((i) obj);
                } else {
                    l0Var.add((String) obj);
                }
            }
        }

        private static <T> void p(Iterable<T> iterable, List<? super T> list) {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
            }
            int size = list.size();
            for (T t5 : iterable) {
                if (t5 == null) {
                    String str = "Element at index " + (list.size() - size) + " is null.";
                    for (int size2 = list.size() - 1; size2 >= size; size2--) {
                        list.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                list.add(t5);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public static v1 s(w0 w0Var) {
            return new v1(w0Var);
        }

        protected abstract BuilderType q(MessageType messagetype);

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.w0.a
        /* renamed from: r */
        public BuilderType g(w0 w0Var) {
            if (b().getClass().isInstance(w0Var)) {
                return (BuilderType) q((a) w0Var);
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T> void o(Iterable<T> iterable, List<? super T> list) {
        AbstractC0043a.o(iterable, list);
    }

    private String r(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    @Override // com.google.protobuf.w0
    public void d(OutputStream outputStream) {
        l f02 = l.f0(outputStream, l.J(a()));
        f(f02);
        f02.c0();
    }

    @Override // com.google.protobuf.w0
    public byte[] j() {
        try {
            byte[] bArr = new byte[a()];
            l g02 = l.g0(bArr);
            f(g02);
            g02.d();
            return bArr;
        } catch (IOException e5) {
            throw new RuntimeException(r("byte array"), e5);
        }
    }

    @Override // com.google.protobuf.w0
    public i l() {
        try {
            i.h z4 = i.z(a());
            f(z4.b());
            return z4.a();
        } catch (IOException e5) {
            throw new RuntimeException(r("ByteString"), e5);
        }
    }

    int p() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int q(o1 o1Var) {
        int p5 = p();
        if (p5 == -1) {
            int h5 = o1Var.h(this);
            t(h5);
            return h5;
        }
        return p5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public v1 s() {
        return new v1(this);
    }

    void t(int i5) {
        throw new UnsupportedOperationException();
    }
}
