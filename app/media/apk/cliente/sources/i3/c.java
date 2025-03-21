package i3;

import i3.k;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import z0.f;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: k  reason: collision with root package name */
    public static final c f3343k;

    /* renamed from: a  reason: collision with root package name */
    private final t f3344a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f3345b;

    /* renamed from: c  reason: collision with root package name */
    private final String f3346c;

    /* renamed from: d  reason: collision with root package name */
    private final i3.b f3347d;

    /* renamed from: e  reason: collision with root package name */
    private final String f3348e;

    /* renamed from: f  reason: collision with root package name */
    private final Object[][] f3349f;

    /* renamed from: g  reason: collision with root package name */
    private final List<k.a> f3350g;

    /* renamed from: h  reason: collision with root package name */
    private final Boolean f3351h;

    /* renamed from: i  reason: collision with root package name */
    private final Integer f3352i;

    /* renamed from: j  reason: collision with root package name */
    private final Integer f3353j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        t f3354a;

        /* renamed from: b  reason: collision with root package name */
        Executor f3355b;

        /* renamed from: c  reason: collision with root package name */
        String f3356c;

        /* renamed from: d  reason: collision with root package name */
        i3.b f3357d;

        /* renamed from: e  reason: collision with root package name */
        String f3358e;

        /* renamed from: f  reason: collision with root package name */
        Object[][] f3359f;

        /* renamed from: g  reason: collision with root package name */
        List<k.a> f3360g;

        /* renamed from: h  reason: collision with root package name */
        Boolean f3361h;

        /* renamed from: i  reason: collision with root package name */
        Integer f3362i;

        /* renamed from: j  reason: collision with root package name */
        Integer f3363j;

        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public c b() {
            return new c(this);
        }
    }

    /* renamed from: i3.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0069c<T> {

        /* renamed from: a  reason: collision with root package name */
        private final String f3364a;

        /* renamed from: b  reason: collision with root package name */
        private final T f3365b;

        private C0069c(String str, T t5) {
            this.f3364a = str;
            this.f3365b = t5;
        }

        public static <T> C0069c<T> b(String str) {
            z0.k.o(str, "debugString");
            return new C0069c<>(str, null);
        }

        public static <T> C0069c<T> c(String str, T t5) {
            z0.k.o(str, "debugString");
            return new C0069c<>(str, t5);
        }

        public String toString() {
            return this.f3364a;
        }
    }

    static {
        b bVar = new b();
        bVar.f3359f = (Object[][]) Array.newInstance(Object.class, 0, 2);
        bVar.f3360g = Collections.emptyList();
        f3343k = bVar.b();
    }

    private c(b bVar) {
        this.f3344a = bVar.f3354a;
        this.f3345b = bVar.f3355b;
        this.f3346c = bVar.f3356c;
        this.f3347d = bVar.f3357d;
        this.f3348e = bVar.f3358e;
        this.f3349f = bVar.f3359f;
        this.f3350g = bVar.f3360g;
        this.f3351h = bVar.f3361h;
        this.f3352i = bVar.f3362i;
        this.f3353j = bVar.f3363j;
    }

    private static b k(c cVar) {
        b bVar = new b();
        bVar.f3354a = cVar.f3344a;
        bVar.f3355b = cVar.f3345b;
        bVar.f3356c = cVar.f3346c;
        bVar.f3357d = cVar.f3347d;
        bVar.f3358e = cVar.f3348e;
        bVar.f3359f = cVar.f3349f;
        bVar.f3360g = cVar.f3350g;
        bVar.f3361h = cVar.f3351h;
        bVar.f3362i = cVar.f3352i;
        bVar.f3363j = cVar.f3353j;
        return bVar;
    }

    public String a() {
        return this.f3346c;
    }

    public String b() {
        return this.f3348e;
    }

    public i3.b c() {
        return this.f3347d;
    }

    public t d() {
        return this.f3344a;
    }

    public Executor e() {
        return this.f3345b;
    }

    public Integer f() {
        return this.f3352i;
    }

    public Integer g() {
        return this.f3353j;
    }

    public <T> T h(C0069c<T> c0069c) {
        z0.k.o(c0069c, "key");
        int i5 = 0;
        while (true) {
            Object[][] objArr = this.f3349f;
            if (i5 >= objArr.length) {
                return (T) ((C0069c) c0069c).f3365b;
            }
            if (c0069c.equals(objArr[i5][0])) {
                return (T) this.f3349f[i5][1];
            }
            i5++;
        }
    }

    public List<k.a> i() {
        return this.f3350g;
    }

    public boolean j() {
        return Boolean.TRUE.equals(this.f3351h);
    }

    public c l(i3.b bVar) {
        b k5 = k(this);
        k5.f3357d = bVar;
        return k5.b();
    }

    public c m(t tVar) {
        b k5 = k(this);
        k5.f3354a = tVar;
        return k5.b();
    }

    public c n(Executor executor) {
        b k5 = k(this);
        k5.f3355b = executor;
        return k5.b();
    }

    public c o(int i5) {
        z0.k.h(i5 >= 0, "invalid maxsize %s", i5);
        b k5 = k(this);
        k5.f3362i = Integer.valueOf(i5);
        return k5.b();
    }

    public c p(int i5) {
        z0.k.h(i5 >= 0, "invalid maxsize %s", i5);
        b k5 = k(this);
        k5.f3363j = Integer.valueOf(i5);
        return k5.b();
    }

    public <T> c q(C0069c<T> c0069c, T t5) {
        z0.k.o(c0069c, "key");
        z0.k.o(t5, "value");
        b k5 = k(this);
        int i5 = 0;
        while (true) {
            Object[][] objArr = this.f3349f;
            if (i5 >= objArr.length) {
                i5 = -1;
                break;
            } else if (c0069c.equals(objArr[i5][0])) {
                break;
            } else {
                i5++;
            }
        }
        Object[][] objArr2 = (Object[][]) Array.newInstance(Object.class, this.f3349f.length + (i5 == -1 ? 1 : 0), 2);
        k5.f3359f = objArr2;
        Object[][] objArr3 = this.f3349f;
        System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
        if (i5 == -1) {
            Object[][] objArr4 = k5.f3359f;
            int length = this.f3349f.length;
            Object[] objArr5 = new Object[2];
            objArr5[0] = c0069c;
            objArr5[1] = t5;
            objArr4[length] = objArr5;
        } else {
            Object[][] objArr6 = k5.f3359f;
            Object[] objArr7 = new Object[2];
            objArr7[0] = c0069c;
            objArr7[1] = t5;
            objArr6[i5] = objArr7;
        }
        return k5.b();
    }

    public c r(k.a aVar) {
        ArrayList arrayList = new ArrayList(this.f3350g.size() + 1);
        arrayList.addAll(this.f3350g);
        arrayList.add(aVar);
        b k5 = k(this);
        k5.f3360g = Collections.unmodifiableList(arrayList);
        return k5.b();
    }

    public c s() {
        b k5 = k(this);
        k5.f3361h = Boolean.TRUE;
        return k5.b();
    }

    public c t() {
        b k5 = k(this);
        k5.f3361h = Boolean.FALSE;
        return k5.b();
    }

    public String toString() {
        f.b d5 = z0.f.b(this).d("deadline", this.f3344a).d("authority", this.f3346c).d("callCredentials", this.f3347d);
        Executor executor = this.f3345b;
        return d5.d("executor", executor != null ? executor.getClass() : null).d("compressorName", this.f3348e).d("customOptions", Arrays.deepToString(this.f3349f)).e("waitForReady", j()).d("maxInboundMessageSize", this.f3352i).d("maxOutboundMessageSize", this.f3353j).d("streamTracerFactories", this.f3350g).toString();
    }
}
