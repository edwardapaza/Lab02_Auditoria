package d3;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class a1 {

    /* loaded from: classes.dex */
    public enum a {
        UNKNOWN(0),
        PASSWORD_RESET(1),
        VERIFY_EMAIL(2),
        RECOVER_EMAIL(3),
        EMAIL_SIGN_IN(4),
        VERIFY_AND_CHANGE_EMAIL(5),
        REVERT_SECOND_FACTOR_ADDITION(6);
        

        /* renamed from: a  reason: collision with root package name */
        final int f2261a;

        a(int i5) {
            this.f2261a = i5;
        }
    }

    /* loaded from: classes.dex */
    public static final class a0 {

        /* renamed from: a  reason: collision with root package name */
        private b0 f2262a;

        /* renamed from: b  reason: collision with root package name */
        private r f2263b;

        /* renamed from: c  reason: collision with root package name */
        private s f2264c;

        /* loaded from: classes.dex */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            private b0 f2265a;

            /* renamed from: b  reason: collision with root package name */
            private r f2266b;

            /* renamed from: c  reason: collision with root package name */
            private s f2267c;

            public a0 a() {
                a0 a0Var = new a0();
                a0Var.d(this.f2265a);
                a0Var.b(this.f2266b);
                a0Var.c(this.f2267c);
                return a0Var;
            }

            public a b(r rVar) {
                this.f2266b = rVar;
                return this;
            }

            public a c(s sVar) {
                this.f2267c = sVar;
                return this;
            }

            public a d(b0 b0Var) {
                this.f2265a = b0Var;
                return this;
            }
        }

        static a0 a(ArrayList<Object> arrayList) {
            a0 a0Var = new a0();
            a0Var.d((b0) arrayList.get(0));
            a0Var.b((r) arrayList.get(1));
            a0Var.c((s) arrayList.get(2));
            return a0Var;
        }

        public void b(r rVar) {
            this.f2263b = rVar;
        }

        public void c(s sVar) {
            this.f2264c = sVar;
        }

        public void d(b0 b0Var) {
            this.f2262a = b0Var;
        }

        ArrayList<Object> e() {
            ArrayList<Object> arrayList = new ArrayList<>(3);
            arrayList.add(this.f2262a);
            arrayList.add(this.f2263b);
            arrayList.add(this.f2264c);
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private String f2268a;

        /* renamed from: b  reason: collision with root package name */
        private String f2269b;

        /* renamed from: c  reason: collision with root package name */
        private String f2270c;

        b() {
        }

        static b a(ArrayList<Object> arrayList) {
            b bVar = new b();
            bVar.e((String) arrayList.get(0));
            bVar.g((String) arrayList.get(1));
            bVar.f((String) arrayList.get(2));
            return bVar;
        }

        public String b() {
            return this.f2268a;
        }

        public String c() {
            return this.f2270c;
        }

        public String d() {
            return this.f2269b;
        }

        public void e(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"appName\" is null.");
            }
            this.f2268a = str;
        }

        public void f(String str) {
            this.f2270c = str;
        }

        public void g(String str) {
            this.f2269b = str;
        }

        ArrayList<Object> h() {
            ArrayList<Object> arrayList = new ArrayList<>(3);
            arrayList.add(this.f2268a);
            arrayList.add(this.f2269b);
            arrayList.add(this.f2270c);
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public static final class b0 {

        /* renamed from: a  reason: collision with root package name */
        private c0 f2271a;

        /* renamed from: b  reason: collision with root package name */
        private List<Map<Object, Object>> f2272b;

        /* loaded from: classes.dex */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            private c0 f2273a;

            /* renamed from: b  reason: collision with root package name */
            private List<Map<Object, Object>> f2274b;

            public b0 a() {
                b0 b0Var = new b0();
                b0Var.e(this.f2273a);
                b0Var.d(this.f2274b);
                return b0Var;
            }

            public a b(List<Map<Object, Object>> list) {
                this.f2274b = list;
                return this;
            }

            public a c(c0 c0Var) {
                this.f2273a = c0Var;
                return this;
            }
        }

        b0() {
        }

        static b0 a(ArrayList<Object> arrayList) {
            b0 b0Var = new b0();
            b0Var.e((c0) arrayList.get(0));
            b0Var.d((List) arrayList.get(1));
            return b0Var;
        }

        public List<Map<Object, Object>> b() {
            return this.f2272b;
        }

        public c0 c() {
            return this.f2271a;
        }

        public void d(List<Map<Object, Object>> list) {
            if (list == null) {
                throw new IllegalStateException("Nonnull field \"providerData\" is null.");
            }
            this.f2272b = list;
        }

        public void e(c0 c0Var) {
            if (c0Var == null) {
                throw new IllegalStateException("Nonnull field \"userInfo\" is null.");
            }
            this.f2271a = c0Var;
        }

        ArrayList<Object> f() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            arrayList.add(this.f2271a);
            arrayList.add(this.f2272b);
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void B(b bVar, y yVar, f0<a0> f0Var);

        void a(b bVar, String str, String str2, f0<a0> f0Var);

        void c(b bVar, String str, f0<a0> f0Var);

        void d(b bVar, f0<String> f0Var);

        void e(b bVar, String str, g0 g0Var);

        void f(b bVar, String str, g0 g0Var);

        void g(b bVar, String str, f0<o> f0Var);

        void h(b bVar, Map<String, Object> map, f0<a0> f0Var);

        void i(b bVar, f0<String> f0Var);

        void k(b bVar, String str, q qVar, g0 g0Var);

        void l(b bVar, f0<a0> f0Var);

        void m(b bVar, e0 e0Var, f0<String> f0Var);

        void n(b bVar, String str, Long l5, g0 g0Var);

        void o(b bVar, t tVar, g0 g0Var);

        void p(b bVar, String str, String str2, g0 g0Var);

        void q(b bVar, String str, String str2, f0<a0> f0Var);

        void s(b bVar, g0 g0Var);

        void u(b bVar, String str, f0<String> f0Var);

        void v(b bVar, String str, f0<List<String>> f0Var);

        void w(b bVar, String str, f0<String> f0Var);

        void x(b bVar, String str, q qVar, g0 g0Var);

        void y(b bVar, String str, String str2, f0<a0> f0Var);
    }

    /* loaded from: classes.dex */
    public static final class c0 {

        /* renamed from: a  reason: collision with root package name */
        private String f2275a;

        /* renamed from: b  reason: collision with root package name */
        private String f2276b;

        /* renamed from: c  reason: collision with root package name */
        private String f2277c;

        /* renamed from: d  reason: collision with root package name */
        private String f2278d;

        /* renamed from: e  reason: collision with root package name */
        private String f2279e;

        /* renamed from: f  reason: collision with root package name */
        private Boolean f2280f;

        /* renamed from: g  reason: collision with root package name */
        private Boolean f2281g;

        /* renamed from: h  reason: collision with root package name */
        private String f2282h;

        /* renamed from: i  reason: collision with root package name */
        private String f2283i;

        /* renamed from: j  reason: collision with root package name */
        private String f2284j;

        /* renamed from: k  reason: collision with root package name */
        private Long f2285k;

        /* renamed from: l  reason: collision with root package name */
        private Long f2286l;

        /* loaded from: classes.dex */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            private String f2287a;

            /* renamed from: b  reason: collision with root package name */
            private String f2288b;

            /* renamed from: c  reason: collision with root package name */
            private String f2289c;

            /* renamed from: d  reason: collision with root package name */
            private String f2290d;

            /* renamed from: e  reason: collision with root package name */
            private String f2291e;

            /* renamed from: f  reason: collision with root package name */
            private Boolean f2292f;

            /* renamed from: g  reason: collision with root package name */
            private Boolean f2293g;

            /* renamed from: h  reason: collision with root package name */
            private String f2294h;

            /* renamed from: i  reason: collision with root package name */
            private String f2295i;

            /* renamed from: j  reason: collision with root package name */
            private String f2296j;

            /* renamed from: k  reason: collision with root package name */
            private Long f2297k;

            /* renamed from: l  reason: collision with root package name */
            private Long f2298l;

            public c0 a() {
                c0 c0Var = new c0();
                c0Var.m(this.f2287a);
                c0Var.d(this.f2288b);
                c0Var.c(this.f2289c);
                c0Var.i(this.f2290d);
                c0Var.h(this.f2291e);
                c0Var.e(this.f2292f);
                c0Var.f(this.f2293g);
                c0Var.j(this.f2294h);
                c0Var.l(this.f2295i);
                c0Var.k(this.f2296j);
                c0Var.b(this.f2297k);
                c0Var.g(this.f2298l);
                return c0Var;
            }

            public a b(Long l5) {
                this.f2297k = l5;
                return this;
            }

            public a c(String str) {
                this.f2289c = str;
                return this;
            }

            public a d(String str) {
                this.f2288b = str;
                return this;
            }

            public a e(Boolean bool) {
                this.f2292f = bool;
                return this;
            }

            public a f(Boolean bool) {
                this.f2293g = bool;
                return this;
            }

            public a g(Long l5) {
                this.f2298l = l5;
                return this;
            }

            public a h(String str) {
                this.f2291e = str;
                return this;
            }

            public a i(String str) {
                this.f2290d = str;
                return this;
            }

            public a j(String str) {
                this.f2295i = str;
                return this;
            }

            public a k(String str) {
                this.f2287a = str;
                return this;
            }
        }

        c0() {
        }

        static c0 a(ArrayList<Object> arrayList) {
            Long valueOf;
            c0 c0Var = new c0();
            c0Var.m((String) arrayList.get(0));
            c0Var.d((String) arrayList.get(1));
            c0Var.c((String) arrayList.get(2));
            c0Var.i((String) arrayList.get(3));
            c0Var.h((String) arrayList.get(4));
            c0Var.e((Boolean) arrayList.get(5));
            c0Var.f((Boolean) arrayList.get(6));
            c0Var.j((String) arrayList.get(7));
            c0Var.l((String) arrayList.get(8));
            c0Var.k((String) arrayList.get(9));
            Object obj = arrayList.get(10);
            Long l5 = null;
            if (obj == null) {
                valueOf = null;
            } else {
                valueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            c0Var.b(valueOf);
            Object obj2 = arrayList.get(11);
            if (obj2 != null) {
                l5 = Long.valueOf(obj2 instanceof Integer ? ((Integer) obj2).intValue() : ((Long) obj2).longValue());
            }
            c0Var.g(l5);
            return c0Var;
        }

        public void b(Long l5) {
            this.f2285k = l5;
        }

        public void c(String str) {
            this.f2277c = str;
        }

        public void d(String str) {
            this.f2276b = str;
        }

        public void e(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"isAnonymous\" is null.");
            }
            this.f2280f = bool;
        }

        public void f(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"isEmailVerified\" is null.");
            }
            this.f2281g = bool;
        }

        public void g(Long l5) {
            this.f2286l = l5;
        }

        public void h(String str) {
            this.f2279e = str;
        }

        public void i(String str) {
            this.f2278d = str;
        }

        public void j(String str) {
            this.f2282h = str;
        }

        public void k(String str) {
            this.f2284j = str;
        }

        public void l(String str) {
            this.f2283i = str;
        }

        public void m(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"uid\" is null.");
            }
            this.f2275a = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public ArrayList<Object> n() {
            ArrayList<Object> arrayList = new ArrayList<>(12);
            arrayList.add(this.f2275a);
            arrayList.add(this.f2276b);
            arrayList.add(this.f2277c);
            arrayList.add(this.f2278d);
            arrayList.add(this.f2279e);
            arrayList.add(this.f2280f);
            arrayList.add(this.f2281g);
            arrayList.add(this.f2282h);
            arrayList.add(this.f2283i);
            arrayList.add(this.f2284j);
            arrayList.add(this.f2285k);
            arrayList.add(this.f2286l);
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d extends z2.p {

        /* renamed from: d  reason: collision with root package name */
        public static final d f2299d = new d();

        private d() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // z2.p
        public Object g(byte b5, ByteBuffer byteBuffer) {
            switch (b5) {
                case Byte.MIN_VALUE:
                    return b.a((ArrayList) f(byteBuffer));
                case -127:
                    return o.a((ArrayList) f(byteBuffer));
                case -126:
                    return p.a((ArrayList) f(byteBuffer));
                case -125:
                    return q.a((ArrayList) f(byteBuffer));
                case -124:
                    return r.a((ArrayList) f(byteBuffer));
                case -123:
                    return s.a((ArrayList) f(byteBuffer));
                case -122:
                    return t.a((ArrayList) f(byteBuffer));
                case -121:
                    return u.a((ArrayList) f(byteBuffer));
                case -120:
                    return v.a((ArrayList) f(byteBuffer));
                case -119:
                    return w.a((ArrayList) f(byteBuffer));
                case -118:
                    return x.a((ArrayList) f(byteBuffer));
                case -117:
                    return y.a((ArrayList) f(byteBuffer));
                case -116:
                    return z.a((ArrayList) f(byteBuffer));
                case -115:
                    return a0.a((ArrayList) f(byteBuffer));
                case -114:
                    return b0.a((ArrayList) f(byteBuffer));
                case -113:
                    return c0.a((ArrayList) f(byteBuffer));
                case -112:
                    return d0.a((ArrayList) f(byteBuffer));
                case -111:
                    return e0.a((ArrayList) f(byteBuffer));
                default:
                    return super.g(b5, byteBuffer);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // z2.p
        public void p(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            ArrayList<Object> j5;
            if (obj instanceof b) {
                byteArrayOutputStream.write(128);
                j5 = ((b) obj).h();
            } else if (obj instanceof o) {
                byteArrayOutputStream.write(129);
                j5 = ((o) obj).d();
            } else if (obj instanceof p) {
                byteArrayOutputStream.write(130);
                j5 = ((p) obj).d();
            } else if (obj instanceof q) {
                byteArrayOutputStream.write(131);
                j5 = ((q) obj).p();
            } else if (obj instanceof r) {
                byteArrayOutputStream.write(132);
                j5 = ((r) obj).g();
            } else if (obj instanceof s) {
                byteArrayOutputStream.write(133);
                j5 = ((s) obj).f();
            } else if (obj instanceof t) {
                byteArrayOutputStream.write(134);
                j5 = ((t) obj).k();
            } else if (obj instanceof u) {
                byteArrayOutputStream.write(135);
                j5 = ((u) obj).i();
            } else if (obj instanceof v) {
                byteArrayOutputStream.write(136);
                j5 = ((v) obj).g();
            } else if (obj instanceof w) {
                byteArrayOutputStream.write(137);
                j5 = ((w) obj).c();
            } else if (obj instanceof x) {
                byteArrayOutputStream.write(138);
                j5 = ((x) obj).f();
            } else if (obj instanceof y) {
                byteArrayOutputStream.write(139);
                j5 = ((y) obj).h();
            } else if (obj instanceof z) {
                byteArrayOutputStream.write(140);
                j5 = ((z) obj).g();
            } else if (obj instanceof a0) {
                byteArrayOutputStream.write(141);
                j5 = ((a0) obj).e();
            } else if (obj instanceof b0) {
                byteArrayOutputStream.write(142);
                j5 = ((b0) obj).f();
            } else if (obj instanceof c0) {
                byteArrayOutputStream.write(143);
                j5 = ((c0) obj).n();
            } else if (!(obj instanceof d0)) {
                if (!(obj instanceof e0)) {
                    super.p(byteArrayOutputStream, obj);
                    return;
                }
                byteArrayOutputStream.write(145);
                p(byteArrayOutputStream, ((e0) obj).n());
                return;
            } else {
                byteArrayOutputStream.write(144);
                j5 = ((d0) obj).j();
            }
            p(byteArrayOutputStream, j5);
        }
    }

    /* loaded from: classes.dex */
    public static final class d0 {

        /* renamed from: a  reason: collision with root package name */
        private String f2300a;

        /* renamed from: b  reason: collision with root package name */
        private String f2301b;

        /* renamed from: c  reason: collision with root package name */
        private Boolean f2302c;

        /* renamed from: d  reason: collision with root package name */
        private Boolean f2303d;

        d0() {
        }

        static d0 a(ArrayList<Object> arrayList) {
            d0 d0Var = new d0();
            d0Var.f((String) arrayList.get(0));
            d0Var.h((String) arrayList.get(1));
            d0Var.g((Boolean) arrayList.get(2));
            d0Var.i((Boolean) arrayList.get(3));
            return d0Var;
        }

        public String b() {
            return this.f2300a;
        }

        public Boolean c() {
            return this.f2302c;
        }

        public String d() {
            return this.f2301b;
        }

        public Boolean e() {
            return this.f2303d;
        }

        public void f(String str) {
            this.f2300a = str;
        }

        public void g(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"displayNameChanged\" is null.");
            }
            this.f2302c = bool;
        }

        public void h(String str) {
            this.f2301b = str;
        }

        public void i(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"photoUrlChanged\" is null.");
            }
            this.f2303d = bool;
        }

        ArrayList<Object> j() {
            ArrayList<Object> arrayList = new ArrayList<>(4);
            arrayList.add(this.f2300a);
            arrayList.add(this.f2301b);
            arrayList.add(this.f2302c);
            arrayList.add(this.f2303d);
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(b bVar, String str, f0<b0> f0Var);

        void b(b bVar, Map<String, Object> map, f0<b0> f0Var);

        void c(b bVar, Map<String, Object> map, f0<a0> f0Var);

        void d(b bVar, Map<String, Object> map, f0<a0> f0Var);

        void e(b bVar, y yVar, f0<a0> f0Var);

        void f(b bVar, y yVar, f0<a0> f0Var);

        void g(b bVar, String str, q qVar, g0 g0Var);

        void h(b bVar, String str, f0<a0> f0Var);

        void i(b bVar, f0<b0> f0Var);

        void j(b bVar, q qVar, g0 g0Var);

        void k(b bVar, g0 g0Var);

        void l(b bVar, String str, f0<b0> f0Var);

        void m(b bVar, d0 d0Var, f0<b0> f0Var);

        void n(b bVar, Boolean bool, f0<u> f0Var);
    }

    /* loaded from: classes.dex */
    public static final class e0 {

        /* renamed from: a  reason: collision with root package name */
        private String f2304a;

        /* renamed from: b  reason: collision with root package name */
        private Long f2305b;

        /* renamed from: c  reason: collision with root package name */
        private Long f2306c;

        /* renamed from: d  reason: collision with root package name */
        private String f2307d;

        /* renamed from: e  reason: collision with root package name */
        private String f2308e;

        /* renamed from: f  reason: collision with root package name */
        private String f2309f;

        e0() {
        }

        static e0 a(ArrayList<Object> arrayList) {
            Long valueOf;
            e0 e0Var = new e0();
            e0Var.l((String) arrayList.get(0));
            Object obj = arrayList.get(1);
            Long l5 = null;
            if (obj == null) {
                valueOf = null;
            } else {
                valueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            e0Var.m(valueOf);
            Object obj2 = arrayList.get(2);
            if (obj2 != null) {
                l5 = Long.valueOf(obj2 instanceof Integer ? ((Integer) obj2).intValue() : ((Long) obj2).longValue());
            }
            e0Var.i(l5);
            e0Var.h((String) arrayList.get(3));
            e0Var.j((String) arrayList.get(4));
            e0Var.k((String) arrayList.get(5));
            return e0Var;
        }

        public String b() {
            return this.f2307d;
        }

        public Long c() {
            return this.f2306c;
        }

        public String d() {
            return this.f2308e;
        }

        public String e() {
            return this.f2309f;
        }

        public String f() {
            return this.f2304a;
        }

        public Long g() {
            return this.f2305b;
        }

        public void h(String str) {
            this.f2307d = str;
        }

        public void i(Long l5) {
            this.f2306c = l5;
        }

        public void j(String str) {
            this.f2308e = str;
        }

        public void k(String str) {
            this.f2309f = str;
        }

        public void l(String str) {
            this.f2304a = str;
        }

        public void m(Long l5) {
            if (l5 == null) {
                throw new IllegalStateException("Nonnull field \"timeout\" is null.");
            }
            this.f2305b = l5;
        }

        ArrayList<Object> n() {
            ArrayList<Object> arrayList = new ArrayList<>(6);
            arrayList.add(this.f2304a);
            arrayList.add(this.f2305b);
            arrayList.add(this.f2306c);
            arrayList.add(this.f2307d);
            arrayList.add(this.f2308e);
            arrayList.add(this.f2309f);
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class f extends z2.p {

        /* renamed from: d  reason: collision with root package name */
        public static final f f2310d = new f();

        private f() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // z2.p
        public Object g(byte b5, ByteBuffer byteBuffer) {
            switch (b5) {
                case Byte.MIN_VALUE:
                    return b.a((ArrayList) f(byteBuffer));
                case -127:
                    return o.a((ArrayList) f(byteBuffer));
                case -126:
                    return p.a((ArrayList) f(byteBuffer));
                case -125:
                    return q.a((ArrayList) f(byteBuffer));
                case -124:
                    return r.a((ArrayList) f(byteBuffer));
                case -123:
                    return s.a((ArrayList) f(byteBuffer));
                case -122:
                    return t.a((ArrayList) f(byteBuffer));
                case -121:
                    return u.a((ArrayList) f(byteBuffer));
                case -120:
                    return v.a((ArrayList) f(byteBuffer));
                case -119:
                    return w.a((ArrayList) f(byteBuffer));
                case -118:
                    return x.a((ArrayList) f(byteBuffer));
                case -117:
                    return y.a((ArrayList) f(byteBuffer));
                case -116:
                    return z.a((ArrayList) f(byteBuffer));
                case -115:
                    return a0.a((ArrayList) f(byteBuffer));
                case -114:
                    return b0.a((ArrayList) f(byteBuffer));
                case -113:
                    return c0.a((ArrayList) f(byteBuffer));
                case -112:
                    return d0.a((ArrayList) f(byteBuffer));
                case -111:
                    return e0.a((ArrayList) f(byteBuffer));
                default:
                    return super.g(b5, byteBuffer);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // z2.p
        public void p(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            ArrayList<Object> j5;
            if (obj instanceof b) {
                byteArrayOutputStream.write(128);
                j5 = ((b) obj).h();
            } else if (obj instanceof o) {
                byteArrayOutputStream.write(129);
                j5 = ((o) obj).d();
            } else if (obj instanceof p) {
                byteArrayOutputStream.write(130);
                j5 = ((p) obj).d();
            } else if (obj instanceof q) {
                byteArrayOutputStream.write(131);
                j5 = ((q) obj).p();
            } else if (obj instanceof r) {
                byteArrayOutputStream.write(132);
                j5 = ((r) obj).g();
            } else if (obj instanceof s) {
                byteArrayOutputStream.write(133);
                j5 = ((s) obj).f();
            } else if (obj instanceof t) {
                byteArrayOutputStream.write(134);
                j5 = ((t) obj).k();
            } else if (obj instanceof u) {
                byteArrayOutputStream.write(135);
                j5 = ((u) obj).i();
            } else if (obj instanceof v) {
                byteArrayOutputStream.write(136);
                j5 = ((v) obj).g();
            } else if (obj instanceof w) {
                byteArrayOutputStream.write(137);
                j5 = ((w) obj).c();
            } else if (obj instanceof x) {
                byteArrayOutputStream.write(138);
                j5 = ((x) obj).f();
            } else if (obj instanceof y) {
                byteArrayOutputStream.write(139);
                j5 = ((y) obj).h();
            } else if (obj instanceof z) {
                byteArrayOutputStream.write(140);
                j5 = ((z) obj).g();
            } else if (obj instanceof a0) {
                byteArrayOutputStream.write(141);
                j5 = ((a0) obj).e();
            } else if (obj instanceof b0) {
                byteArrayOutputStream.write(142);
                j5 = ((b0) obj).f();
            } else if (obj instanceof c0) {
                byteArrayOutputStream.write(143);
                j5 = ((c0) obj).n();
            } else if (!(obj instanceof d0)) {
                if (!(obj instanceof e0)) {
                    super.p(byteArrayOutputStream, obj);
                    return;
                }
                byteArrayOutputStream.write(145);
                p(byteArrayOutputStream, ((e0) obj).n());
                return;
            } else {
                byteArrayOutputStream.write(144);
                j5 = ((d0) obj).j();
            }
            p(byteArrayOutputStream, j5);
        }
    }

    /* loaded from: classes.dex */
    public interface f0<T> {
        void a(T t5);

        void b(Throwable th);
    }

    /* loaded from: classes.dex */
    public static class g extends RuntimeException {

        /* renamed from: a  reason: collision with root package name */
        public final String f2311a;

        /* renamed from: b  reason: collision with root package name */
        public final Object f2312b;

        public g(String str, String str2, Object obj) {
            super(str2);
            this.f2311a = str;
            this.f2312b = obj;
        }
    }

    /* loaded from: classes.dex */
    public interface g0 {
        void a();

        void b(Throwable th);
    }

    /* loaded from: classes.dex */
    public interface h {
        void b(String str, x xVar, String str2, f0<a0> f0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class i extends z2.p {

        /* renamed from: d  reason: collision with root package name */
        public static final i f2313d = new i();

        private i() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // z2.p
        public Object g(byte b5, ByteBuffer byteBuffer) {
            switch (b5) {
                case Byte.MIN_VALUE:
                    return r.a((ArrayList) f(byteBuffer));
                case -127:
                    return s.a((ArrayList) f(byteBuffer));
                case -126:
                    return x.a((ArrayList) f(byteBuffer));
                case -125:
                    return a0.a((ArrayList) f(byteBuffer));
                case -124:
                    return b0.a((ArrayList) f(byteBuffer));
                case -123:
                    return c0.a((ArrayList) f(byteBuffer));
                default:
                    return super.g(b5, byteBuffer);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // z2.p
        public void p(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            ArrayList<Object> f5;
            if (obj instanceof r) {
                byteArrayOutputStream.write(128);
                f5 = ((r) obj).g();
            } else if (obj instanceof s) {
                byteArrayOutputStream.write(129);
                f5 = ((s) obj).f();
            } else if (obj instanceof x) {
                byteArrayOutputStream.write(130);
                f5 = ((x) obj).f();
            } else if (obj instanceof a0) {
                byteArrayOutputStream.write(131);
                f5 = ((a0) obj).e();
            } else if (!(obj instanceof b0)) {
                if (!(obj instanceof c0)) {
                    super.p(byteArrayOutputStream, obj);
                    return;
                }
                byteArrayOutputStream.write(133);
                p(byteArrayOutputStream, ((c0) obj).n());
                return;
            } else {
                byteArrayOutputStream.write(132);
                f5 = ((b0) obj).f();
            }
            p(byteArrayOutputStream, f5);
        }
    }

    /* loaded from: classes.dex */
    public interface j {
        void a(String str, f0<z> f0Var);

        void b(String str, String str2, f0<String> f0Var);

        void c(String str, String str2, f0<String> f0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class k extends z2.p {

        /* renamed from: d  reason: collision with root package name */
        public static final k f2314d = new k();

        private k() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // z2.p
        public Object g(byte b5, ByteBuffer byteBuffer) {
            return b5 != Byte.MIN_VALUE ? super.g(b5, byteBuffer) : z.a((ArrayList) f(byteBuffer));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // z2.p
        public void p(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (!(obj instanceof z)) {
                super.p(byteArrayOutputStream, obj);
                return;
            }
            byteArrayOutputStream.write(128);
            p(byteArrayOutputStream, ((z) obj).g());
        }
    }

    /* loaded from: classes.dex */
    public interface l {
        void a(String str, String str2, String str3, f0<String> f0Var);

        void b(String str, String str2, g0 g0Var);
    }

    /* loaded from: classes.dex */
    public interface m {
        void a(b bVar, f0<List<v>> f0Var);

        void c(b bVar, String str, String str2, g0 g0Var);

        void d(b bVar, f0<w> f0Var);

        void e(b bVar, x xVar, String str, g0 g0Var);

        void f(b bVar, String str, g0 g0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class n extends z2.p {

        /* renamed from: d  reason: collision with root package name */
        public static final n f2315d = new n();

        private n() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // z2.p
        public Object g(byte b5, ByteBuffer byteBuffer) {
            switch (b5) {
                case Byte.MIN_VALUE:
                    return b.a((ArrayList) f(byteBuffer));
                case -127:
                    return v.a((ArrayList) f(byteBuffer));
                case -126:
                    return w.a((ArrayList) f(byteBuffer));
                case -125:
                    return x.a((ArrayList) f(byteBuffer));
                default:
                    return super.g(b5, byteBuffer);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // z2.p
        public void p(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            ArrayList<Object> f5;
            if (obj instanceof b) {
                byteArrayOutputStream.write(128);
                f5 = ((b) obj).h();
            } else if (obj instanceof v) {
                byteArrayOutputStream.write(129);
                f5 = ((v) obj).g();
            } else if (obj instanceof w) {
                byteArrayOutputStream.write(130);
                f5 = ((w) obj).c();
            } else if (!(obj instanceof x)) {
                super.p(byteArrayOutputStream, obj);
                return;
            } else {
                byteArrayOutputStream.write(131);
                f5 = ((x) obj).f();
            }
            p(byteArrayOutputStream, f5);
        }
    }

    /* loaded from: classes.dex */
    public static final class o {

        /* renamed from: a  reason: collision with root package name */
        private a f2316a;

        /* renamed from: b  reason: collision with root package name */
        private p f2317b;

        /* loaded from: classes.dex */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            private a f2318a;

            /* renamed from: b  reason: collision with root package name */
            private p f2319b;

            public o a() {
                o oVar = new o();
                oVar.c(this.f2318a);
                oVar.b(this.f2319b);
                return oVar;
            }

            public a b(p pVar) {
                this.f2319b = pVar;
                return this;
            }

            public a c(a aVar) {
                this.f2318a = aVar;
                return this;
            }
        }

        o() {
        }

        static o a(ArrayList<Object> arrayList) {
            o oVar = new o();
            oVar.c(a.values()[((Integer) arrayList.get(0)).intValue()]);
            oVar.b((p) arrayList.get(1));
            return oVar;
        }

        public void b(p pVar) {
            if (pVar == null) {
                throw new IllegalStateException("Nonnull field \"data\" is null.");
            }
            this.f2317b = pVar;
        }

        public void c(a aVar) {
            if (aVar == null) {
                throw new IllegalStateException("Nonnull field \"operation\" is null.");
            }
            this.f2316a = aVar;
        }

        ArrayList<Object> d() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            a aVar = this.f2316a;
            arrayList.add(aVar == null ? null : Integer.valueOf(aVar.f2261a));
            arrayList.add(this.f2317b);
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public static final class p {

        /* renamed from: a  reason: collision with root package name */
        private String f2320a;

        /* renamed from: b  reason: collision with root package name */
        private String f2321b;

        /* loaded from: classes.dex */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            private String f2322a;

            /* renamed from: b  reason: collision with root package name */
            private String f2323b;

            public p a() {
                p pVar = new p();
                pVar.b(this.f2322a);
                pVar.c(this.f2323b);
                return pVar;
            }

            public a b(String str) {
                this.f2322a = str;
                return this;
            }

            public a c(String str) {
                this.f2323b = str;
                return this;
            }
        }

        static p a(ArrayList<Object> arrayList) {
            p pVar = new p();
            pVar.b((String) arrayList.get(0));
            pVar.c((String) arrayList.get(1));
            return pVar;
        }

        public void b(String str) {
            this.f2320a = str;
        }

        public void c(String str) {
            this.f2321b = str;
        }

        ArrayList<Object> d() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            arrayList.add(this.f2320a);
            arrayList.add(this.f2321b);
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public static final class q {

        /* renamed from: a  reason: collision with root package name */
        private String f2324a;

        /* renamed from: b  reason: collision with root package name */
        private String f2325b;

        /* renamed from: c  reason: collision with root package name */
        private Boolean f2326c;

        /* renamed from: d  reason: collision with root package name */
        private String f2327d;

        /* renamed from: e  reason: collision with root package name */
        private String f2328e;

        /* renamed from: f  reason: collision with root package name */
        private Boolean f2329f;

        /* renamed from: g  reason: collision with root package name */
        private String f2330g;

        q() {
        }

        static q a(ArrayList<Object> arrayList) {
            q qVar = new q();
            qVar.o((String) arrayList.get(0));
            qVar.l((String) arrayList.get(1));
            qVar.m((Boolean) arrayList.get(2));
            qVar.n((String) arrayList.get(3));
            qVar.k((String) arrayList.get(4));
            qVar.i((Boolean) arrayList.get(5));
            qVar.j((String) arrayList.get(6));
            return qVar;
        }

        public Boolean b() {
            return this.f2329f;
        }

        public String c() {
            return this.f2330g;
        }

        public String d() {
            return this.f2328e;
        }

        public String e() {
            return this.f2325b;
        }

        public Boolean f() {
            return this.f2326c;
        }

        public String g() {
            return this.f2327d;
        }

        public String h() {
            return this.f2324a;
        }

        public void i(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"androidInstallApp\" is null.");
            }
            this.f2329f = bool;
        }

        public void j(String str) {
            this.f2330g = str;
        }

        public void k(String str) {
            this.f2328e = str;
        }

        public void l(String str) {
            this.f2325b = str;
        }

        public void m(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"handleCodeInApp\" is null.");
            }
            this.f2326c = bool;
        }

        public void n(String str) {
            this.f2327d = str;
        }

        public void o(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"url\" is null.");
            }
            this.f2324a = str;
        }

        ArrayList<Object> p() {
            ArrayList<Object> arrayList = new ArrayList<>(7);
            arrayList.add(this.f2324a);
            arrayList.add(this.f2325b);
            arrayList.add(this.f2326c);
            arrayList.add(this.f2327d);
            arrayList.add(this.f2328e);
            arrayList.add(this.f2329f);
            arrayList.add(this.f2330g);
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public static final class r {

        /* renamed from: a  reason: collision with root package name */
        private Boolean f2331a;

        /* renamed from: b  reason: collision with root package name */
        private String f2332b;

        /* renamed from: c  reason: collision with root package name */
        private String f2333c;

        /* renamed from: d  reason: collision with root package name */
        private String f2334d;

        /* renamed from: e  reason: collision with root package name */
        private Map<String, Object> f2335e;

        /* loaded from: classes.dex */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            private Boolean f2336a;

            /* renamed from: b  reason: collision with root package name */
            private String f2337b;

            /* renamed from: c  reason: collision with root package name */
            private String f2338c;

            /* renamed from: d  reason: collision with root package name */
            private String f2339d;

            /* renamed from: e  reason: collision with root package name */
            private Map<String, Object> f2340e;

            public r a() {
                r rVar = new r();
                rVar.c(this.f2336a);
                rVar.e(this.f2337b);
                rVar.f(this.f2338c);
                rVar.b(this.f2339d);
                rVar.d(this.f2340e);
                return rVar;
            }

            public a b(Boolean bool) {
                this.f2336a = bool;
                return this;
            }

            public a c(Map<String, Object> map) {
                this.f2340e = map;
                return this;
            }

            public a d(String str) {
                this.f2337b = str;
                return this;
            }

            public a e(String str) {
                this.f2338c = str;
                return this;
            }
        }

        r() {
        }

        static r a(ArrayList<Object> arrayList) {
            r rVar = new r();
            rVar.c((Boolean) arrayList.get(0));
            rVar.e((String) arrayList.get(1));
            rVar.f((String) arrayList.get(2));
            rVar.b((String) arrayList.get(3));
            rVar.d((Map) arrayList.get(4));
            return rVar;
        }

        public void b(String str) {
            this.f2334d = str;
        }

        public void c(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"isNewUser\" is null.");
            }
            this.f2331a = bool;
        }

        public void d(Map<String, Object> map) {
            this.f2335e = map;
        }

        public void e(String str) {
            this.f2332b = str;
        }

        public void f(String str) {
            this.f2333c = str;
        }

        ArrayList<Object> g() {
            ArrayList<Object> arrayList = new ArrayList<>(5);
            arrayList.add(this.f2331a);
            arrayList.add(this.f2332b);
            arrayList.add(this.f2333c);
            arrayList.add(this.f2334d);
            arrayList.add(this.f2335e);
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public static final class s {

        /* renamed from: a  reason: collision with root package name */
        private String f2341a;

        /* renamed from: b  reason: collision with root package name */
        private String f2342b;

        /* renamed from: c  reason: collision with root package name */
        private Long f2343c;

        /* renamed from: d  reason: collision with root package name */
        private String f2344d;

        /* loaded from: classes.dex */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            private String f2345a;

            /* renamed from: b  reason: collision with root package name */
            private String f2346b;

            /* renamed from: c  reason: collision with root package name */
            private Long f2347c;

            /* renamed from: d  reason: collision with root package name */
            private String f2348d;

            public s a() {
                s sVar = new s();
                sVar.d(this.f2345a);
                sVar.e(this.f2346b);
                sVar.c(this.f2347c);
                sVar.b(this.f2348d);
                return sVar;
            }

            public a b(String str) {
                this.f2348d = str;
                return this;
            }

            public a c(Long l5) {
                this.f2347c = l5;
                return this;
            }

            public a d(String str) {
                this.f2345a = str;
                return this;
            }

            public a e(String str) {
                this.f2346b = str;
                return this;
            }
        }

        s() {
        }

        static s a(ArrayList<Object> arrayList) {
            Long valueOf;
            s sVar = new s();
            sVar.d((String) arrayList.get(0));
            sVar.e((String) arrayList.get(1));
            Object obj = arrayList.get(2);
            if (obj == null) {
                valueOf = null;
            } else {
                valueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            sVar.c(valueOf);
            sVar.b((String) arrayList.get(3));
            return sVar;
        }

        public void b(String str) {
            this.f2344d = str;
        }

        public void c(Long l5) {
            if (l5 == null) {
                throw new IllegalStateException("Nonnull field \"nativeId\" is null.");
            }
            this.f2343c = l5;
        }

        public void d(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"providerId\" is null.");
            }
            this.f2341a = str;
        }

        public void e(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"signInMethod\" is null.");
            }
            this.f2342b = str;
        }

        ArrayList<Object> f() {
            ArrayList<Object> arrayList = new ArrayList<>(4);
            arrayList.add(this.f2341a);
            arrayList.add(this.f2342b);
            arrayList.add(this.f2343c);
            arrayList.add(this.f2344d);
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public static final class t {

        /* renamed from: a  reason: collision with root package name */
        private Boolean f2349a;

        /* renamed from: b  reason: collision with root package name */
        private String f2350b;

        /* renamed from: c  reason: collision with root package name */
        private String f2351c;

        /* renamed from: d  reason: collision with root package name */
        private String f2352d;

        /* renamed from: e  reason: collision with root package name */
        private Boolean f2353e;

        t() {
        }

        static t a(ArrayList<Object> arrayList) {
            t tVar = new t();
            tVar.f((Boolean) arrayList.get(0));
            tVar.j((String) arrayList.get(1));
            tVar.h((String) arrayList.get(2));
            tVar.i((String) arrayList.get(3));
            tVar.g((Boolean) arrayList.get(4));
            return tVar;
        }

        public Boolean b() {
            return this.f2349a;
        }

        public Boolean c() {
            return this.f2353e;
        }

        public String d() {
            return this.f2351c;
        }

        public String e() {
            return this.f2352d;
        }

        public void f(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"appVerificationDisabledForTesting\" is null.");
            }
            this.f2349a = bool;
        }

        public void g(Boolean bool) {
            this.f2353e = bool;
        }

        public void h(String str) {
            this.f2351c = str;
        }

        public void i(String str) {
            this.f2352d = str;
        }

        public void j(String str) {
            this.f2350b = str;
        }

        ArrayList<Object> k() {
            ArrayList<Object> arrayList = new ArrayList<>(5);
            arrayList.add(this.f2349a);
            arrayList.add(this.f2350b);
            arrayList.add(this.f2351c);
            arrayList.add(this.f2352d);
            arrayList.add(this.f2353e);
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public static final class u {

        /* renamed from: a  reason: collision with root package name */
        private String f2354a;

        /* renamed from: b  reason: collision with root package name */
        private Long f2355b;

        /* renamed from: c  reason: collision with root package name */
        private Long f2356c;

        /* renamed from: d  reason: collision with root package name */
        private Long f2357d;

        /* renamed from: e  reason: collision with root package name */
        private String f2358e;

        /* renamed from: f  reason: collision with root package name */
        private Map<String, Object> f2359f;

        /* renamed from: g  reason: collision with root package name */
        private String f2360g;

        /* loaded from: classes.dex */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            private String f2361a;

            /* renamed from: b  reason: collision with root package name */
            private Long f2362b;

            /* renamed from: c  reason: collision with root package name */
            private Long f2363c;

            /* renamed from: d  reason: collision with root package name */
            private Long f2364d;

            /* renamed from: e  reason: collision with root package name */
            private String f2365e;

            /* renamed from: f  reason: collision with root package name */
            private Map<String, Object> f2366f;

            /* renamed from: g  reason: collision with root package name */
            private String f2367g;

            public u a() {
                u uVar = new u();
                uVar.h(this.f2361a);
                uVar.d(this.f2362b);
                uVar.b(this.f2363c);
                uVar.e(this.f2364d);
                uVar.f(this.f2365e);
                uVar.c(this.f2366f);
                uVar.g(this.f2367g);
                return uVar;
            }

            public a b(Long l5) {
                this.f2363c = l5;
                return this;
            }

            public a c(Map<String, Object> map) {
                this.f2366f = map;
                return this;
            }

            public a d(Long l5) {
                this.f2362b = l5;
                return this;
            }

            public a e(Long l5) {
                this.f2364d = l5;
                return this;
            }

            public a f(String str) {
                this.f2365e = str;
                return this;
            }

            public a g(String str) {
                this.f2367g = str;
                return this;
            }

            public a h(String str) {
                this.f2361a = str;
                return this;
            }
        }

        static u a(ArrayList<Object> arrayList) {
            Long valueOf;
            Long valueOf2;
            u uVar = new u();
            uVar.h((String) arrayList.get(0));
            Object obj = arrayList.get(1);
            Long l5 = null;
            if (obj == null) {
                valueOf = null;
            } else {
                valueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            uVar.d(valueOf);
            Object obj2 = arrayList.get(2);
            if (obj2 == null) {
                valueOf2 = null;
            } else {
                valueOf2 = Long.valueOf(obj2 instanceof Integer ? ((Integer) obj2).intValue() : ((Long) obj2).longValue());
            }
            uVar.b(valueOf2);
            Object obj3 = arrayList.get(3);
            if (obj3 != null) {
                l5 = Long.valueOf(obj3 instanceof Integer ? ((Integer) obj3).intValue() : ((Long) obj3).longValue());
            }
            uVar.e(l5);
            uVar.f((String) arrayList.get(4));
            uVar.c((Map) arrayList.get(5));
            uVar.g((String) arrayList.get(6));
            return uVar;
        }

        public void b(Long l5) {
            this.f2356c = l5;
        }

        public void c(Map<String, Object> map) {
            this.f2359f = map;
        }

        public void d(Long l5) {
            this.f2355b = l5;
        }

        public void e(Long l5) {
            this.f2357d = l5;
        }

        public void f(String str) {
            this.f2358e = str;
        }

        public void g(String str) {
            this.f2360g = str;
        }

        public void h(String str) {
            this.f2354a = str;
        }

        ArrayList<Object> i() {
            ArrayList<Object> arrayList = new ArrayList<>(7);
            arrayList.add(this.f2354a);
            arrayList.add(this.f2355b);
            arrayList.add(this.f2356c);
            arrayList.add(this.f2357d);
            arrayList.add(this.f2358e);
            arrayList.add(this.f2359f);
            arrayList.add(this.f2360g);
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public static final class v {

        /* renamed from: a  reason: collision with root package name */
        private String f2368a;

        /* renamed from: b  reason: collision with root package name */
        private Double f2369b;

        /* renamed from: c  reason: collision with root package name */
        private String f2370c;

        /* renamed from: d  reason: collision with root package name */
        private String f2371d;

        /* renamed from: e  reason: collision with root package name */
        private String f2372e;

        /* loaded from: classes.dex */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            private String f2373a;

            /* renamed from: b  reason: collision with root package name */
            private Double f2374b;

            /* renamed from: c  reason: collision with root package name */
            private String f2375c;

            /* renamed from: d  reason: collision with root package name */
            private String f2376d;

            /* renamed from: e  reason: collision with root package name */
            private String f2377e;

            public v a() {
                v vVar = new v();
                vVar.b(this.f2373a);
                vVar.c(this.f2374b);
                vVar.d(this.f2375c);
                vVar.f(this.f2376d);
                vVar.e(this.f2377e);
                return vVar;
            }

            public a b(String str) {
                this.f2373a = str;
                return this;
            }

            public a c(Double d5) {
                this.f2374b = d5;
                return this;
            }

            public a d(String str) {
                this.f2375c = str;
                return this;
            }

            public a e(String str) {
                this.f2377e = str;
                return this;
            }

            public a f(String str) {
                this.f2376d = str;
                return this;
            }
        }

        v() {
        }

        static v a(ArrayList<Object> arrayList) {
            v vVar = new v();
            vVar.b((String) arrayList.get(0));
            vVar.c((Double) arrayList.get(1));
            vVar.d((String) arrayList.get(2));
            vVar.f((String) arrayList.get(3));
            vVar.e((String) arrayList.get(4));
            return vVar;
        }

        public void b(String str) {
            this.f2368a = str;
        }

        public void c(Double d5) {
            if (d5 == null) {
                throw new IllegalStateException("Nonnull field \"enrollmentTimestamp\" is null.");
            }
            this.f2369b = d5;
        }

        public void d(String str) {
            this.f2370c = str;
        }

        public void e(String str) {
            this.f2372e = str;
        }

        public void f(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"uid\" is null.");
            }
            this.f2371d = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public ArrayList<Object> g() {
            ArrayList<Object> arrayList = new ArrayList<>(5);
            arrayList.add(this.f2368a);
            arrayList.add(this.f2369b);
            arrayList.add(this.f2370c);
            arrayList.add(this.f2371d);
            arrayList.add(this.f2372e);
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public static final class w {

        /* renamed from: a  reason: collision with root package name */
        private String f2378a;

        /* loaded from: classes.dex */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            private String f2379a;

            public w a() {
                w wVar = new w();
                wVar.b(this.f2379a);
                return wVar;
            }

            public a b(String str) {
                this.f2379a = str;
                return this;
            }
        }

        w() {
        }

        static w a(ArrayList<Object> arrayList) {
            w wVar = new w();
            wVar.b((String) arrayList.get(0));
            return wVar;
        }

        public void b(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"id\" is null.");
            }
            this.f2378a = str;
        }

        ArrayList<Object> c() {
            ArrayList<Object> arrayList = new ArrayList<>(1);
            arrayList.add(this.f2378a);
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public static final class x {

        /* renamed from: a  reason: collision with root package name */
        private String f2380a;

        /* renamed from: b  reason: collision with root package name */
        private String f2381b;

        x() {
        }

        static x a(ArrayList<Object> arrayList) {
            x xVar = new x();
            xVar.e((String) arrayList.get(0));
            xVar.d((String) arrayList.get(1));
            return xVar;
        }

        public String b() {
            return this.f2381b;
        }

        public String c() {
            return this.f2380a;
        }

        public void d(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"verificationCode\" is null.");
            }
            this.f2381b = str;
        }

        public void e(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"verificationId\" is null.");
            }
            this.f2380a = str;
        }

        ArrayList<Object> f() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            arrayList.add(this.f2380a);
            arrayList.add(this.f2381b);
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: a  reason: collision with root package name */
        private String f2382a;

        /* renamed from: b  reason: collision with root package name */
        private List<String> f2383b;

        /* renamed from: c  reason: collision with root package name */
        private Map<String, String> f2384c;

        y() {
        }

        static y a(ArrayList<Object> arrayList) {
            y yVar = new y();
            yVar.f((String) arrayList.get(0));
            yVar.g((List) arrayList.get(1));
            yVar.e((Map) arrayList.get(2));
            return yVar;
        }

        public Map<String, String> b() {
            return this.f2384c;
        }

        public String c() {
            return this.f2382a;
        }

        public List<String> d() {
            return this.f2383b;
        }

        public void e(Map<String, String> map) {
            this.f2384c = map;
        }

        public void f(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"providerId\" is null.");
            }
            this.f2382a = str;
        }

        public void g(List<String> list) {
            this.f2383b = list;
        }

        ArrayList<Object> h() {
            ArrayList<Object> arrayList = new ArrayList<>(3);
            arrayList.add(this.f2382a);
            arrayList.add(this.f2383b);
            arrayList.add(this.f2384c);
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public static final class z {

        /* renamed from: a  reason: collision with root package name */
        private Long f2385a;

        /* renamed from: b  reason: collision with root package name */
        private Long f2386b;

        /* renamed from: c  reason: collision with root package name */
        private Long f2387c;

        /* renamed from: d  reason: collision with root package name */
        private String f2388d;

        /* renamed from: e  reason: collision with root package name */
        private String f2389e;

        /* loaded from: classes.dex */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            private Long f2390a;

            /* renamed from: b  reason: collision with root package name */
            private Long f2391b;

            /* renamed from: c  reason: collision with root package name */
            private Long f2392c;

            /* renamed from: d  reason: collision with root package name */
            private String f2393d;

            /* renamed from: e  reason: collision with root package name */
            private String f2394e;

            public z a() {
                z zVar = new z();
                zVar.b(this.f2390a);
                zVar.c(this.f2391b);
                zVar.d(this.f2392c);
                zVar.e(this.f2393d);
                zVar.f(this.f2394e);
                return zVar;
            }

            public a b(Long l5) {
                this.f2390a = l5;
                return this;
            }

            public a c(Long l5) {
                this.f2391b = l5;
                return this;
            }

            public a d(Long l5) {
                this.f2392c = l5;
                return this;
            }

            public a e(String str) {
                this.f2393d = str;
                return this;
            }

            public a f(String str) {
                this.f2394e = str;
                return this;
            }
        }

        z() {
        }

        static z a(ArrayList<Object> arrayList) {
            Long valueOf;
            Long valueOf2;
            z zVar = new z();
            Object obj = arrayList.get(0);
            Long l5 = null;
            if (obj == null) {
                valueOf = null;
            } else {
                valueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            zVar.b(valueOf);
            Object obj2 = arrayList.get(1);
            if (obj2 == null) {
                valueOf2 = null;
            } else {
                valueOf2 = Long.valueOf(obj2 instanceof Integer ? ((Integer) obj2).intValue() : ((Long) obj2).longValue());
            }
            zVar.c(valueOf2);
            Object obj3 = arrayList.get(2);
            if (obj3 != null) {
                l5 = Long.valueOf(obj3 instanceof Integer ? ((Integer) obj3).intValue() : ((Long) obj3).longValue());
            }
            zVar.d(l5);
            zVar.e((String) arrayList.get(3));
            zVar.f((String) arrayList.get(4));
            return zVar;
        }

        public void b(Long l5) {
            this.f2385a = l5;
        }

        public void c(Long l5) {
            this.f2386b = l5;
        }

        public void d(Long l5) {
            this.f2387c = l5;
        }

        public void e(String str) {
            this.f2388d = str;
        }

        public void f(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"secretKey\" is null.");
            }
            this.f2389e = str;
        }

        ArrayList<Object> g() {
            ArrayList<Object> arrayList = new ArrayList<>(5);
            arrayList.add(this.f2385a);
            arrayList.add(this.f2386b);
            arrayList.add(this.f2387c);
            arrayList.add(this.f2388d);
            arrayList.add(this.f2389e);
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static ArrayList<Object> a(Throwable th) {
        Object obj;
        ArrayList<Object> arrayList = new ArrayList<>(3);
        if (th instanceof g) {
            g gVar = (g) th;
            arrayList.add(gVar.f2311a);
            arrayList.add(gVar.getMessage());
            obj = gVar.f2312b;
        } else {
            arrayList.add(th.toString());
            arrayList.add(th.getClass().getSimpleName());
            obj = "Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th);
        }
        arrayList.add(obj);
        return arrayList;
    }
}
