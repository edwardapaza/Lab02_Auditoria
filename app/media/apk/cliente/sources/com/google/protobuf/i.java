package com.google.protobuf;

import com.google.android.gms.common.api.a;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;
/* loaded from: classes.dex */
public abstract class i implements Iterable<Byte>, Serializable {

    /* renamed from: b  reason: collision with root package name */
    public static final i f1961b = new j(d0.f1913d);

    /* renamed from: c  reason: collision with root package name */
    private static final f f1962c;

    /* renamed from: d  reason: collision with root package name */
    private static final Comparator<i> f1963d;

    /* renamed from: a  reason: collision with root package name */
    private int f1964a = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends c {

        /* renamed from: a  reason: collision with root package name */
        private int f1965a = 0;

        /* renamed from: b  reason: collision with root package name */
        private final int f1966b;

        a() {
            this.f1966b = i.this.size();
        }

        @Override // com.google.protobuf.i.g
        public byte a() {
            int i5 = this.f1965a;
            if (i5 < this.f1966b) {
                this.f1965a = i5 + 1;
                return i.this.v(i5);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1965a < this.f1966b;
        }
    }

    /* loaded from: classes.dex */
    class b implements Comparator<i> {
        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(i iVar, i iVar2) {
            g it = iVar.iterator();
            g it2 = iVar2.iterator();
            while (it.hasNext() && it2.hasNext()) {
                int compareTo = Integer.valueOf(i.H(it.a())).compareTo(Integer.valueOf(i.H(it2.a())));
                if (compareTo != 0) {
                    return compareTo;
                }
            }
            return Integer.valueOf(iVar.size()).compareTo(Integer.valueOf(iVar2.size()));
        }
    }

    /* loaded from: classes.dex */
    static abstract class c implements g {
        @Override // java.util.Iterator
        /* renamed from: b */
        public final Byte next() {
            return Byte.valueOf(a());
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes.dex */
    private static final class d implements f {
        private d() {
        }

        /* synthetic */ d(a aVar) {
            this();
        }

        @Override // com.google.protobuf.i.f
        public byte[] a(byte[] bArr, int i5, int i6) {
            return Arrays.copyOfRange(bArr, i5, i6 + i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class e extends j {

        /* renamed from: f  reason: collision with root package name */
        private final int f1968f;

        /* renamed from: k  reason: collision with root package name */
        private final int f1969k;

        e(byte[] bArr, int i5, int i6) {
            super(bArr);
            i.m(i5, i5 + i6, bArr.length);
            this.f1968f = i5;
            this.f1969k = i6;
        }

        @Override // com.google.protobuf.i.j
        protected int R() {
            return this.f1968f;
        }

        @Override // com.google.protobuf.i.j, com.google.protobuf.i
        public byte k(int i5) {
            i.l(i5, size());
            return this.f1972e[this.f1968f + i5];
        }

        @Override // com.google.protobuf.i.j, com.google.protobuf.i
        public int size() {
            return this.f1969k;
        }

        @Override // com.google.protobuf.i.j, com.google.protobuf.i
        protected void t(byte[] bArr, int i5, int i6, int i7) {
            System.arraycopy(this.f1972e, R() + i5, bArr, i6, i7);
        }

        @Override // com.google.protobuf.i.j, com.google.protobuf.i
        byte v(int i5) {
            return this.f1972e[this.f1968f + i5];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface f {
        byte[] a(byte[] bArr, int i5, int i6);
    }

    /* loaded from: classes.dex */
    public interface g extends Iterator<Byte> {
        byte a();
    }

    /* loaded from: classes.dex */
    static final class h {

        /* renamed from: a  reason: collision with root package name */
        private final l f1970a;

        /* renamed from: b  reason: collision with root package name */
        private final byte[] f1971b;

        private h(int i5) {
            byte[] bArr = new byte[i5];
            this.f1971b = bArr;
            this.f1970a = l.g0(bArr);
        }

        /* synthetic */ h(int i5, a aVar) {
            this(i5);
        }

        public i a() {
            this.f1970a.d();
            return new j(this.f1971b);
        }

        public l b() {
            return this.f1970a;
        }
    }

    /* renamed from: com.google.protobuf.i$i  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static abstract class AbstractC0045i extends i {
        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract boolean Q(i iVar, int i5, int i6);

        @Override // com.google.protobuf.i
        protected final int u() {
            return 0;
        }

        @Override // com.google.protobuf.i
        protected final boolean w() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j extends AbstractC0045i {

        /* renamed from: e  reason: collision with root package name */
        protected final byte[] f1972e;

        j(byte[] bArr) {
            bArr.getClass();
            this.f1972e = bArr;
        }

        @Override // com.google.protobuf.i
        public final com.google.protobuf.j A() {
            return com.google.protobuf.j.l(this.f1972e, R(), size(), true);
        }

        @Override // com.google.protobuf.i
        protected final int B(int i5, int i6, int i7) {
            return d0.i(i5, this.f1972e, R() + i6, i7);
        }

        @Override // com.google.protobuf.i
        protected final int C(int i5, int i6, int i7) {
            int R = R() + i6;
            return b2.v(i5, this.f1972e, R, i7 + R);
        }

        @Override // com.google.protobuf.i
        public final i F(int i5, int i6) {
            int m5 = i.m(i5, i6, size());
            return m5 == 0 ? i.f1961b : new e(this.f1972e, R() + i5, m5);
        }

        @Override // com.google.protobuf.i
        protected final String J(Charset charset) {
            return new String(this.f1972e, R(), size(), charset);
        }

        @Override // com.google.protobuf.i
        final void P(com.google.protobuf.h hVar) {
            hVar.b(this.f1972e, R(), size());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.protobuf.i.AbstractC0045i
        public final boolean Q(i iVar, int i5, int i6) {
            if (i6 > iVar.size()) {
                throw new IllegalArgumentException("Length too large: " + i6 + size());
            }
            int i7 = i5 + i6;
            if (i7 > iVar.size()) {
                throw new IllegalArgumentException("Ran off end of other: " + i5 + ", " + i6 + ", " + iVar.size());
            } else if (iVar instanceof j) {
                j jVar = (j) iVar;
                byte[] bArr = this.f1972e;
                byte[] bArr2 = jVar.f1972e;
                int R = R() + i6;
                int R2 = R();
                int R3 = jVar.R() + i5;
                while (R2 < R) {
                    if (bArr[R2] != bArr2[R3]) {
                        return false;
                    }
                    R2++;
                    R3++;
                }
                return true;
            } else {
                return iVar.F(i5, i7).equals(F(0, i6));
            }
        }

        protected int R() {
            return 0;
        }

        @Override // com.google.protobuf.i
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if ((obj instanceof i) && size() == ((i) obj).size()) {
                if (size() == 0) {
                    return true;
                }
                if (obj instanceof j) {
                    j jVar = (j) obj;
                    int D = D();
                    int D2 = jVar.D();
                    if (D == 0 || D2 == 0 || D == D2) {
                        return Q(jVar, 0, size());
                    }
                    return false;
                }
                return obj.equals(this);
            }
            return false;
        }

        @Override // com.google.protobuf.i
        public final ByteBuffer h() {
            return ByteBuffer.wrap(this.f1972e, R(), size()).asReadOnlyBuffer();
        }

        @Override // com.google.protobuf.i
        public byte k(int i5) {
            return this.f1972e[i5];
        }

        @Override // com.google.protobuf.i
        public int size() {
            return this.f1972e.length;
        }

        @Override // com.google.protobuf.i
        protected void t(byte[] bArr, int i5, int i6, int i7) {
            System.arraycopy(this.f1972e, i5, bArr, i6, i7);
        }

        @Override // com.google.protobuf.i
        byte v(int i5) {
            return this.f1972e[i5];
        }

        @Override // com.google.protobuf.i
        public final boolean x() {
            int R = R();
            return b2.t(this.f1972e, R, size() + R);
        }
    }

    /* loaded from: classes.dex */
    private static final class k implements f {
        private k() {
        }

        /* synthetic */ k(a aVar) {
            this();
        }

        @Override // com.google.protobuf.i.f
        public byte[] a(byte[] bArr, int i5, int i6) {
            byte[] bArr2 = new byte[i6];
            System.arraycopy(bArr, i5, bArr2, 0, i6);
            return bArr2;
        }
    }

    static {
        f1962c = com.google.protobuf.d.c() ? new k(null) : new d(null);
        f1963d = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int H(byte b5) {
        return b5 & 255;
    }

    private String L() {
        if (size() <= 50) {
            return t1.a(this);
        }
        return t1.a(F(0, 47)) + "...";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i M(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return O(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
        }
        return new e1(byteBuffer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i N(byte[] bArr) {
        return new j(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i O(byte[] bArr, int i5, int i6) {
        return new e(bArr, i5, i6);
    }

    private static i i(Iterator<i> it, int i5) {
        if (i5 >= 1) {
            if (i5 == 1) {
                return it.next();
            }
            int i6 = i5 >>> 1;
            return i(it, i6).n(i(it, i5 - i6));
        }
        throw new IllegalArgumentException(String.format("length (%s) must be >= 1", Integer.valueOf(i5)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void l(int i5, int i6) {
        if (((i6 - (i5 + 1)) | i5) < 0) {
            if (i5 < 0) {
                throw new ArrayIndexOutOfBoundsException("Index < 0: " + i5);
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i5 + ", " + i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int m(int i5, int i6, int i7) {
        int i8 = i6 - i5;
        if ((i5 | i6 | i8 | (i7 - i6)) < 0) {
            if (i5 < 0) {
                throw new IndexOutOfBoundsException("Beginning index: " + i5 + " < 0");
            } else if (i6 < i5) {
                throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i5 + ", " + i6);
            } else {
                throw new IndexOutOfBoundsException("End index: " + i6 + " >= " + i7);
            }
        }
        return i8;
    }

    public static i o(Iterable<i> iterable) {
        int size;
        if (iterable instanceof Collection) {
            size = ((Collection) iterable).size();
        } else {
            size = 0;
            Iterator<i> it = iterable.iterator();
            while (it.hasNext()) {
                it.next();
                size++;
            }
        }
        return size == 0 ? f1961b : i(iterable.iterator(), size);
    }

    public static i p(byte[] bArr) {
        return q(bArr, 0, bArr.length);
    }

    public static i q(byte[] bArr, int i5, int i6) {
        m(i5, i5 + i6, bArr.length);
        return new j(f1962c.a(bArr, i5, i6));
    }

    public static i r(String str) {
        return new j(str.getBytes(d0.f1911b));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static h z(int i5) {
        return new h(i5, null);
    }

    public abstract com.google.protobuf.j A();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int B(int i5, int i6, int i7);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int C(int i5, int i6, int i7);

    /* JADX INFO: Access modifiers changed from: protected */
    public final int D() {
        return this.f1964a;
    }

    public final i E(int i5) {
        return F(i5, size());
    }

    public abstract i F(int i5, int i6);

    public final byte[] G() {
        int size = size();
        if (size == 0) {
            return d0.f1913d;
        }
        byte[] bArr = new byte[size];
        t(bArr, 0, 0, size);
        return bArr;
    }

    public final String I(Charset charset) {
        return size() == 0 ? "" : J(charset);
    }

    protected abstract String J(Charset charset);

    public final String K() {
        return I(d0.f1911b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void P(com.google.protobuf.h hVar);

    public abstract boolean equals(Object obj);

    public abstract ByteBuffer h();

    public final int hashCode() {
        int i5 = this.f1964a;
        if (i5 == 0) {
            int size = size();
            i5 = B(size, 0, size);
            if (i5 == 0) {
                i5 = 1;
            }
            this.f1964a = i5;
        }
        return i5;
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public abstract byte k(int i5);

    public final i n(i iVar) {
        if (a.e.API_PRIORITY_OTHER - size() >= iVar.size()) {
            return n1.T(this, iVar);
        }
        throw new IllegalArgumentException("ByteString would be too long: " + size() + "+" + iVar.size());
    }

    @Deprecated
    public final void s(byte[] bArr, int i5, int i6, int i7) {
        m(i5, i5 + i7, size());
        m(i6, i6 + i7, bArr.length);
        if (i7 > 0) {
            t(bArr, i5, i6, i7);
        }
    }

    public abstract int size();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void t(byte[] bArr, int i5, int i6, int i7);

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()), L());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int u();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte v(int i5);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean w();

    public abstract boolean x();

    @Override // java.lang.Iterable
    /* renamed from: y */
    public g iterator() {
        return new a();
    }
}
