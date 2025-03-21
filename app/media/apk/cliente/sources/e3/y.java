package e3;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class y {

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private d f2812a;

        /* renamed from: b  reason: collision with root package name */
        private String f2813b;

        a() {
        }

        static a a(ArrayList<Object> arrayList) {
            a aVar = new a();
            aVar.e(d.values()[((Integer) arrayList.get(0)).intValue()]);
            aVar.d((String) arrayList.get(1));
            return aVar;
        }

        public String b() {
            return this.f2813b;
        }

        public d c() {
            return this.f2812a;
        }

        public void d(String str) {
            this.f2813b = str;
        }

        public void e(d dVar) {
            if (dVar == null) {
                throw new IllegalStateException("Nonnull field \"type\" is null.");
            }
            this.f2812a = dVar;
        }

        public ArrayList<Object> f() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            d dVar = this.f2812a;
            arrayList.add(dVar == null ? null : Integer.valueOf(dVar.f2827a));
            arrayList.add(this.f2813b);
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private d f2814a;

        /* renamed from: b  reason: collision with root package name */
        private String f2815b;

        /* renamed from: c  reason: collision with root package name */
        private Double f2816c;

        /* loaded from: classes.dex */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            private d f2817a;

            /* renamed from: b  reason: collision with root package name */
            private String f2818b;

            /* renamed from: c  reason: collision with root package name */
            private Double f2819c;

            public b a() {
                b bVar = new b();
                bVar.c(this.f2817a);
                bVar.b(this.f2818b);
                bVar.d(this.f2819c);
                return bVar;
            }

            public a b(String str) {
                this.f2818b = str;
                return this;
            }

            public a c(d dVar) {
                this.f2817a = dVar;
                return this;
            }

            public a d(Double d5) {
                this.f2819c = d5;
                return this;
            }
        }

        b() {
        }

        static b a(ArrayList<Object> arrayList) {
            b bVar = new b();
            bVar.c(d.values()[((Integer) arrayList.get(0)).intValue()]);
            bVar.b((String) arrayList.get(1));
            bVar.d((Double) arrayList.get(2));
            return bVar;
        }

        public void b(String str) {
            this.f2815b = str;
        }

        public void c(d dVar) {
            if (dVar == null) {
                throw new IllegalStateException("Nonnull field \"type\" is null.");
            }
            this.f2814a = dVar;
        }

        public void d(Double d5) {
            this.f2816c = d5;
        }

        public ArrayList<Object> e() {
            ArrayList<Object> arrayList = new ArrayList<>(3);
            d dVar = this.f2814a;
            arrayList.add(dVar == null ? null : Integer.valueOf(dVar.f2827a));
            arrayList.add(this.f2815b);
            arrayList.add(this.f2816c);
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public enum c {
        SERVER(0);
        

        /* renamed from: a  reason: collision with root package name */
        final int f2822a;

        c(int i5) {
            this.f2822a = i5;
        }
    }

    /* loaded from: classes.dex */
    public enum d {
        COUNT(0),
        SUM(1),
        AVERAGE(2);
        

        /* renamed from: a  reason: collision with root package name */
        final int f2827a;

        d(int i5) {
            this.f2827a = i5;
        }
    }

    /* loaded from: classes.dex */
    public enum e {
        ADDED(0),
        MODIFIED(1),
        REMOVED(2);
        

        /* renamed from: a  reason: collision with root package name */
        final int f2832a;

        e(int i5) {
            this.f2832a = i5;
        }
    }

    /* loaded from: classes.dex */
    public static final class f {

        /* renamed from: a  reason: collision with root package name */
        private String f2833a;

        /* renamed from: b  reason: collision with root package name */
        private Map<Object, Object> f2834b;

        /* renamed from: c  reason: collision with root package name */
        private m f2835c;

        /* renamed from: d  reason: collision with root package name */
        private EnumC0049y f2836d;

        /* renamed from: e  reason: collision with root package name */
        private x f2837e;

        f() {
        }

        static f a(ArrayList<Object> arrayList) {
            f fVar = new f();
            fVar.i((String) arrayList.get(0));
            fVar.g((Map) arrayList.get(1));
            Object obj = arrayList.get(2);
            fVar.h(obj == null ? null : m.a((ArrayList) obj));
            Object obj2 = arrayList.get(3);
            fVar.k(obj2 == null ? null : EnumC0049y.values()[((Integer) obj2).intValue()]);
            Object obj3 = arrayList.get(4);
            fVar.j(obj3 != null ? x.values()[((Integer) obj3).intValue()] : null);
            return fVar;
        }

        public Map<Object, Object> b() {
            return this.f2834b;
        }

        public m c() {
            return this.f2835c;
        }

        public String d() {
            return this.f2833a;
        }

        public x e() {
            return this.f2837e;
        }

        public EnumC0049y f() {
            return this.f2836d;
        }

        public void g(Map<Object, Object> map) {
            this.f2834b = map;
        }

        public void h(m mVar) {
            this.f2835c = mVar;
        }

        public void i(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"path\" is null.");
            }
            this.f2833a = str;
        }

        public void j(x xVar) {
            this.f2837e = xVar;
        }

        public void k(EnumC0049y enumC0049y) {
            this.f2836d = enumC0049y;
        }

        public ArrayList<Object> l() {
            ArrayList<Object> arrayList = new ArrayList<>(5);
            arrayList.add(this.f2833a);
            arrayList.add(this.f2834b);
            m mVar = this.f2835c;
            arrayList.add(mVar == null ? null : mVar.f());
            EnumC0049y enumC0049y = this.f2836d;
            arrayList.add(enumC0049y == null ? null : Integer.valueOf(enumC0049y.f2913a));
            x xVar = this.f2837e;
            arrayList.add(xVar != null ? Integer.valueOf(xVar.f2908a) : null);
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public interface g {
        void B(i iVar, f fVar, Boolean bool, k kVar, w<String> wVar);

        void a(i iVar, w<String> wVar);

        void c(i iVar, f fVar, w<n> wVar);

        void d(i iVar, List<t> list, w<Void> wVar);

        void e(i iVar, String str, Boolean bool, q qVar, p pVar, Boolean bool2, k kVar, w<String> wVar);

        void f(i iVar, f fVar, w<Void> wVar);

        void g(i iVar, String str, q qVar, c cVar, List<a> list, Boolean bool, w<List<b>> wVar);

        void h(i iVar, String str, p pVar, w<r> wVar);

        void i(i iVar, String str, String str2, w<n> wVar);

        void k(i iVar, w<Void> wVar);

        void l(i iVar, String str, w<Void> wVar);

        void m(i iVar, w<Void> wVar);

        void n(i iVar, String str, Boolean bool, q qVar, p pVar, w<r> wVar);

        void o(Boolean bool, w<Void> wVar);

        void p(i iVar, byte[] bArr, w<String> wVar);

        void q(String str, u uVar, List<t> list, w<Void> wVar);

        void s(i iVar, w<Void> wVar);

        void u(i iVar, f fVar, w<Void> wVar);

        void v(i iVar, f fVar, w<Void> wVar);

        void w(i iVar, Long l5, Long l6, w<String> wVar);

        void x(i iVar, w<Void> wVar);

        void y(i iVar, w<Void> wVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class h extends e3.c {

        /* renamed from: e  reason: collision with root package name */
        public static final h f2838e = new h();

        private h() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // e3.c, z2.p
        public Object g(byte b5, ByteBuffer byteBuffer) {
            switch (b5) {
                case Byte.MIN_VALUE:
                    return a.a((ArrayList) f(byteBuffer));
                case -127:
                    return b.a((ArrayList) f(byteBuffer));
                case -126:
                    return f.a((ArrayList) f(byteBuffer));
                case -125:
                    return i.a((ArrayList) f(byteBuffer));
                case -124:
                    return l.a((ArrayList) f(byteBuffer));
                case -123:
                    return m.a((ArrayList) f(byteBuffer));
                case -122:
                    return n.a((ArrayList) f(byteBuffer));
                case -121:
                    return o.a((ArrayList) f(byteBuffer));
                case -120:
                    return p.a((ArrayList) f(byteBuffer));
                case -119:
                    return q.a((ArrayList) f(byteBuffer));
                case -118:
                    return r.a((ArrayList) f(byteBuffer));
                case -117:
                    return s.a((ArrayList) f(byteBuffer));
                case -116:
                    return t.a((ArrayList) f(byteBuffer));
                default:
                    return super.g(b5, byteBuffer);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // e3.c, z2.p
        public void p(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            ArrayList<Object> d5;
            if (obj instanceof a) {
                byteArrayOutputStream.write(128);
                d5 = ((a) obj).f();
            } else if (obj instanceof b) {
                byteArrayOutputStream.write(129);
                d5 = ((b) obj).e();
            } else if (obj instanceof f) {
                byteArrayOutputStream.write(130);
                d5 = ((f) obj).l();
            } else if (obj instanceof i) {
                byteArrayOutputStream.write(131);
                d5 = ((i) obj).h();
            } else if (obj instanceof l) {
                byteArrayOutputStream.write(132);
                d5 = ((l) obj).f();
            } else if (obj instanceof m) {
                byteArrayOutputStream.write(133);
                d5 = ((m) obj).f();
            } else if (obj instanceof n) {
                byteArrayOutputStream.write(134);
                d5 = ((n) obj).e();
            } else if (obj instanceof o) {
                byteArrayOutputStream.write(135);
                d5 = ((o) obj).k();
            } else if (obj instanceof p) {
                byteArrayOutputStream.write(136);
                d5 = ((p) obj).f();
            } else if (obj instanceof q) {
                byteArrayOutputStream.write(137);
                d5 = ((q) obj).t();
            } else if (obj instanceof r) {
                byteArrayOutputStream.write(138);
                d5 = ((r) obj).e();
            } else if (!(obj instanceof s)) {
                if (!(obj instanceof t)) {
                    super.p(byteArrayOutputStream, obj);
                    return;
                }
                byteArrayOutputStream.write(140);
                p(byteArrayOutputStream, ((t) obj).j());
                return;
            } else {
                byteArrayOutputStream.write(139);
                d5 = ((s) obj).d();
            }
            p(byteArrayOutputStream, d5);
        }
    }

    /* loaded from: classes.dex */
    public static final class i {

        /* renamed from: a  reason: collision with root package name */
        private String f2839a;

        /* renamed from: b  reason: collision with root package name */
        private o f2840b;

        /* renamed from: c  reason: collision with root package name */
        private String f2841c;

        i() {
        }

        static i a(ArrayList<Object> arrayList) {
            i iVar = new i();
            iVar.e((String) arrayList.get(0));
            Object obj = arrayList.get(1);
            iVar.g(obj == null ? null : o.a((ArrayList) obj));
            iVar.f((String) arrayList.get(2));
            return iVar;
        }

        public String b() {
            return this.f2839a;
        }

        public String c() {
            return this.f2841c;
        }

        public o d() {
            return this.f2840b;
        }

        public void e(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"appName\" is null.");
            }
            this.f2839a = str;
        }

        public void f(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"databaseURL\" is null.");
            }
            this.f2841c = str;
        }

        public void g(o oVar) {
            if (oVar == null) {
                throw new IllegalStateException("Nonnull field \"settings\" is null.");
            }
            this.f2840b = oVar;
        }

        public ArrayList<Object> h() {
            ArrayList<Object> arrayList = new ArrayList<>(3);
            arrayList.add(this.f2839a);
            o oVar = this.f2840b;
            arrayList.add(oVar == null ? null : oVar.k());
            arrayList.add(this.f2841c);
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public static class j extends RuntimeException {

        /* renamed from: a  reason: collision with root package name */
        public final String f2842a;

        /* renamed from: b  reason: collision with root package name */
        public final Object f2843b;

        public j(String str, String str2, Object obj) {
            super(str2);
            this.f2842a = str;
            this.f2843b = obj;
        }
    }

    /* loaded from: classes.dex */
    public enum k {
        DEFAULT_SOURCE(0),
        CACHE(1);
        

        /* renamed from: a  reason: collision with root package name */
        final int f2847a;

        k(int i5) {
            this.f2847a = i5;
        }
    }

    /* loaded from: classes.dex */
    public static final class l {

        /* renamed from: a  reason: collision with root package name */
        private e f2848a;

        /* renamed from: b  reason: collision with root package name */
        private n f2849b;

        /* renamed from: c  reason: collision with root package name */
        private Long f2850c;

        /* renamed from: d  reason: collision with root package name */
        private Long f2851d;

        /* loaded from: classes.dex */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            private e f2852a;

            /* renamed from: b  reason: collision with root package name */
            private n f2853b;

            /* renamed from: c  reason: collision with root package name */
            private Long f2854c;

            /* renamed from: d  reason: collision with root package name */
            private Long f2855d;

            public l a() {
                l lVar = new l();
                lVar.e(this.f2852a);
                lVar.b(this.f2853b);
                lVar.d(this.f2854c);
                lVar.c(this.f2855d);
                return lVar;
            }

            public a b(n nVar) {
                this.f2853b = nVar;
                return this;
            }

            public a c(Long l5) {
                this.f2855d = l5;
                return this;
            }

            public a d(Long l5) {
                this.f2854c = l5;
                return this;
            }

            public a e(e eVar) {
                this.f2852a = eVar;
                return this;
            }
        }

        l() {
        }

        static l a(ArrayList<Object> arrayList) {
            Long valueOf;
            l lVar = new l();
            lVar.e(e.values()[((Integer) arrayList.get(0)).intValue()]);
            Object obj = arrayList.get(1);
            Long l5 = null;
            lVar.b(obj == null ? null : n.a((ArrayList) obj));
            Object obj2 = arrayList.get(2);
            if (obj2 == null) {
                valueOf = null;
            } else {
                valueOf = Long.valueOf(obj2 instanceof Integer ? ((Integer) obj2).intValue() : ((Long) obj2).longValue());
            }
            lVar.d(valueOf);
            Object obj3 = arrayList.get(3);
            if (obj3 != null) {
                l5 = Long.valueOf(obj3 instanceof Integer ? ((Integer) obj3).intValue() : ((Long) obj3).longValue());
            }
            lVar.c(l5);
            return lVar;
        }

        public void b(n nVar) {
            if (nVar == null) {
                throw new IllegalStateException("Nonnull field \"document\" is null.");
            }
            this.f2849b = nVar;
        }

        public void c(Long l5) {
            if (l5 == null) {
                throw new IllegalStateException("Nonnull field \"newIndex\" is null.");
            }
            this.f2851d = l5;
        }

        public void d(Long l5) {
            if (l5 == null) {
                throw new IllegalStateException("Nonnull field \"oldIndex\" is null.");
            }
            this.f2850c = l5;
        }

        public void e(e eVar) {
            if (eVar == null) {
                throw new IllegalStateException("Nonnull field \"type\" is null.");
            }
            this.f2848a = eVar;
        }

        public ArrayList<Object> f() {
            ArrayList<Object> arrayList = new ArrayList<>(4);
            e eVar = this.f2848a;
            arrayList.add(eVar == null ? null : Integer.valueOf(eVar.f2832a));
            n nVar = this.f2849b;
            arrayList.add(nVar != null ? nVar.e() : null);
            arrayList.add(this.f2850c);
            arrayList.add(this.f2851d);
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public static final class m {

        /* renamed from: a  reason: collision with root package name */
        private Boolean f2856a;

        /* renamed from: b  reason: collision with root package name */
        private List<List<String>> f2857b;

        static m a(ArrayList<Object> arrayList) {
            m mVar = new m();
            mVar.d((Boolean) arrayList.get(0));
            mVar.e((List) arrayList.get(1));
            return mVar;
        }

        public Boolean b() {
            return this.f2856a;
        }

        public List<List<String>> c() {
            return this.f2857b;
        }

        public void d(Boolean bool) {
            this.f2856a = bool;
        }

        public void e(List<List<String>> list) {
            this.f2857b = list;
        }

        public ArrayList<Object> f() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            arrayList.add(this.f2856a);
            arrayList.add(this.f2857b);
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public static final class n {

        /* renamed from: a  reason: collision with root package name */
        private String f2858a;

        /* renamed from: b  reason: collision with root package name */
        private Map<String, Object> f2859b;

        /* renamed from: c  reason: collision with root package name */
        private s f2860c;

        /* loaded from: classes.dex */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            private String f2861a;

            /* renamed from: b  reason: collision with root package name */
            private Map<String, Object> f2862b;

            /* renamed from: c  reason: collision with root package name */
            private s f2863c;

            public n a() {
                n nVar = new n();
                nVar.d(this.f2861a);
                nVar.b(this.f2862b);
                nVar.c(this.f2863c);
                return nVar;
            }

            public a b(Map<String, Object> map) {
                this.f2862b = map;
                return this;
            }

            public a c(s sVar) {
                this.f2863c = sVar;
                return this;
            }

            public a d(String str) {
                this.f2861a = str;
                return this;
            }
        }

        n() {
        }

        static n a(ArrayList<Object> arrayList) {
            n nVar = new n();
            nVar.d((String) arrayList.get(0));
            nVar.b((Map) arrayList.get(1));
            Object obj = arrayList.get(2);
            nVar.c(obj == null ? null : s.a((ArrayList) obj));
            return nVar;
        }

        public void b(Map<String, Object> map) {
            this.f2859b = map;
        }

        public void c(s sVar) {
            if (sVar == null) {
                throw new IllegalStateException("Nonnull field \"metadata\" is null.");
            }
            this.f2860c = sVar;
        }

        public void d(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"path\" is null.");
            }
            this.f2858a = str;
        }

        public ArrayList<Object> e() {
            ArrayList<Object> arrayList = new ArrayList<>(3);
            arrayList.add(this.f2858a);
            arrayList.add(this.f2859b);
            s sVar = this.f2860c;
            arrayList.add(sVar == null ? null : sVar.d());
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public static final class o {

        /* renamed from: a  reason: collision with root package name */
        private Boolean f2864a;

        /* renamed from: b  reason: collision with root package name */
        private String f2865b;

        /* renamed from: c  reason: collision with root package name */
        private Boolean f2866c;

        /* renamed from: d  reason: collision with root package name */
        private Long f2867d;

        /* renamed from: e  reason: collision with root package name */
        private Boolean f2868e;

        o() {
        }

        static o a(ArrayList<Object> arrayList) {
            Long valueOf;
            o oVar = new o();
            oVar.i((Boolean) arrayList.get(0));
            oVar.g((String) arrayList.get(1));
            oVar.j((Boolean) arrayList.get(2));
            Object obj = arrayList.get(3);
            if (obj == null) {
                valueOf = null;
            } else {
                valueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            oVar.f(valueOf);
            oVar.h((Boolean) arrayList.get(4));
            return oVar;
        }

        public Long b() {
            return this.f2867d;
        }

        public String c() {
            return this.f2865b;
        }

        public Boolean d() {
            return this.f2864a;
        }

        public Boolean e() {
            return this.f2866c;
        }

        public void f(Long l5) {
            this.f2867d = l5;
        }

        public void g(String str) {
            this.f2865b = str;
        }

        public void h(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"ignoreUndefinedProperties\" is null.");
            }
            this.f2868e = bool;
        }

        public void i(Boolean bool) {
            this.f2864a = bool;
        }

        public void j(Boolean bool) {
            this.f2866c = bool;
        }

        public ArrayList<Object> k() {
            ArrayList<Object> arrayList = new ArrayList<>(5);
            arrayList.add(this.f2864a);
            arrayList.add(this.f2865b);
            arrayList.add(this.f2866c);
            arrayList.add(this.f2867d);
            arrayList.add(this.f2868e);
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public static final class p {

        /* renamed from: a  reason: collision with root package name */
        private EnumC0049y f2869a;

        /* renamed from: b  reason: collision with root package name */
        private x f2870b;

        p() {
        }

        static p a(ArrayList<Object> arrayList) {
            p pVar = new p();
            pVar.e(EnumC0049y.values()[((Integer) arrayList.get(0)).intValue()]);
            pVar.d(x.values()[((Integer) arrayList.get(1)).intValue()]);
            return pVar;
        }

        public x b() {
            return this.f2870b;
        }

        public EnumC0049y c() {
            return this.f2869a;
        }

        public void d(x xVar) {
            if (xVar == null) {
                throw new IllegalStateException("Nonnull field \"serverTimestampBehavior\" is null.");
            }
            this.f2870b = xVar;
        }

        public void e(EnumC0049y enumC0049y) {
            if (enumC0049y == null) {
                throw new IllegalStateException("Nonnull field \"source\" is null.");
            }
            this.f2869a = enumC0049y;
        }

        public ArrayList<Object> f() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            EnumC0049y enumC0049y = this.f2869a;
            arrayList.add(enumC0049y == null ? null : Integer.valueOf(enumC0049y.f2913a));
            x xVar = this.f2870b;
            arrayList.add(xVar != null ? Integer.valueOf(xVar.f2908a) : null);
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public static final class q {

        /* renamed from: a  reason: collision with root package name */
        private List<List<Object>> f2871a;

        /* renamed from: b  reason: collision with root package name */
        private List<List<Object>> f2872b;

        /* renamed from: c  reason: collision with root package name */
        private Long f2873c;

        /* renamed from: d  reason: collision with root package name */
        private Long f2874d;

        /* renamed from: e  reason: collision with root package name */
        private List<Object> f2875e;

        /* renamed from: f  reason: collision with root package name */
        private List<Object> f2876f;

        /* renamed from: g  reason: collision with root package name */
        private List<Object> f2877g;

        /* renamed from: h  reason: collision with root package name */
        private List<Object> f2878h;

        /* renamed from: i  reason: collision with root package name */
        private Map<String, Object> f2879i;

        static q a(ArrayList<Object> arrayList) {
            Long valueOf;
            q qVar = new q();
            qVar.s((List) arrayList.get(0));
            qVar.p((List) arrayList.get(1));
            Object obj = arrayList.get(2);
            Long l5 = null;
            if (obj == null) {
                valueOf = null;
            } else {
                valueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            qVar.n(valueOf);
            Object obj2 = arrayList.get(3);
            if (obj2 != null) {
                l5 = Long.valueOf(obj2 instanceof Integer ? ((Integer) obj2).intValue() : ((Long) obj2).longValue());
            }
            qVar.o(l5);
            qVar.r((List) arrayList.get(4));
            qVar.q((List) arrayList.get(5));
            qVar.k((List) arrayList.get(6));
            qVar.l((List) arrayList.get(7));
            qVar.m((Map) arrayList.get(8));
            return qVar;
        }

        public List<Object> b() {
            return this.f2877g;
        }

        public List<Object> c() {
            return this.f2878h;
        }

        public Map<String, Object> d() {
            return this.f2879i;
        }

        public Long e() {
            return this.f2873c;
        }

        public Long f() {
            return this.f2874d;
        }

        public List<List<Object>> g() {
            return this.f2872b;
        }

        public List<Object> h() {
            return this.f2876f;
        }

        public List<Object> i() {
            return this.f2875e;
        }

        public List<List<Object>> j() {
            return this.f2871a;
        }

        public void k(List<Object> list) {
            this.f2877g = list;
        }

        public void l(List<Object> list) {
            this.f2878h = list;
        }

        public void m(Map<String, Object> map) {
            this.f2879i = map;
        }

        public void n(Long l5) {
            this.f2873c = l5;
        }

        public void o(Long l5) {
            this.f2874d = l5;
        }

        public void p(List<List<Object>> list) {
            this.f2872b = list;
        }

        public void q(List<Object> list) {
            this.f2876f = list;
        }

        public void r(List<Object> list) {
            this.f2875e = list;
        }

        public void s(List<List<Object>> list) {
            this.f2871a = list;
        }

        public ArrayList<Object> t() {
            ArrayList<Object> arrayList = new ArrayList<>(9);
            arrayList.add(this.f2871a);
            arrayList.add(this.f2872b);
            arrayList.add(this.f2873c);
            arrayList.add(this.f2874d);
            arrayList.add(this.f2875e);
            arrayList.add(this.f2876f);
            arrayList.add(this.f2877g);
            arrayList.add(this.f2878h);
            arrayList.add(this.f2879i);
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public static final class r {

        /* renamed from: a  reason: collision with root package name */
        private List<n> f2880a;

        /* renamed from: b  reason: collision with root package name */
        private List<l> f2881b;

        /* renamed from: c  reason: collision with root package name */
        private s f2882c;

        /* loaded from: classes.dex */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            private List<n> f2883a;

            /* renamed from: b  reason: collision with root package name */
            private List<l> f2884b;

            /* renamed from: c  reason: collision with root package name */
            private s f2885c;

            public r a() {
                r rVar = new r();
                rVar.c(this.f2883a);
                rVar.b(this.f2884b);
                rVar.d(this.f2885c);
                return rVar;
            }

            public a b(List<l> list) {
                this.f2884b = list;
                return this;
            }

            public a c(List<n> list) {
                this.f2883a = list;
                return this;
            }

            public a d(s sVar) {
                this.f2885c = sVar;
                return this;
            }
        }

        r() {
        }

        static r a(ArrayList<Object> arrayList) {
            r rVar = new r();
            rVar.c((List) arrayList.get(0));
            rVar.b((List) arrayList.get(1));
            Object obj = arrayList.get(2);
            rVar.d(obj == null ? null : s.a((ArrayList) obj));
            return rVar;
        }

        public void b(List<l> list) {
            if (list == null) {
                throw new IllegalStateException("Nonnull field \"documentChanges\" is null.");
            }
            this.f2881b = list;
        }

        public void c(List<n> list) {
            if (list == null) {
                throw new IllegalStateException("Nonnull field \"documents\" is null.");
            }
            this.f2880a = list;
        }

        public void d(s sVar) {
            if (sVar == null) {
                throw new IllegalStateException("Nonnull field \"metadata\" is null.");
            }
            this.f2882c = sVar;
        }

        public ArrayList<Object> e() {
            ArrayList<Object> arrayList = new ArrayList<>(3);
            arrayList.add(this.f2880a);
            arrayList.add(this.f2881b);
            s sVar = this.f2882c;
            arrayList.add(sVar == null ? null : sVar.d());
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public static final class s {

        /* renamed from: a  reason: collision with root package name */
        private Boolean f2886a;

        /* renamed from: b  reason: collision with root package name */
        private Boolean f2887b;

        /* loaded from: classes.dex */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            private Boolean f2888a;

            /* renamed from: b  reason: collision with root package name */
            private Boolean f2889b;

            public s a() {
                s sVar = new s();
                sVar.b(this.f2888a);
                sVar.c(this.f2889b);
                return sVar;
            }

            public a b(Boolean bool) {
                this.f2888a = bool;
                return this;
            }

            public a c(Boolean bool) {
                this.f2889b = bool;
                return this;
            }
        }

        s() {
        }

        static s a(ArrayList<Object> arrayList) {
            s sVar = new s();
            sVar.b((Boolean) arrayList.get(0));
            sVar.c((Boolean) arrayList.get(1));
            return sVar;
        }

        public void b(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"hasPendingWrites\" is null.");
            }
            this.f2886a = bool;
        }

        public void c(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"isFromCache\" is null.");
            }
            this.f2887b = bool;
        }

        public ArrayList<Object> d() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            arrayList.add(this.f2886a);
            arrayList.add(this.f2887b);
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public static final class t {

        /* renamed from: a  reason: collision with root package name */
        private v f2890a;

        /* renamed from: b  reason: collision with root package name */
        private String f2891b;

        /* renamed from: c  reason: collision with root package name */
        private Map<String, Object> f2892c;

        /* renamed from: d  reason: collision with root package name */
        private m f2893d;

        t() {
        }

        static t a(ArrayList<Object> arrayList) {
            t tVar = new t();
            tVar.i(v.values()[((Integer) arrayList.get(0)).intValue()]);
            tVar.h((String) arrayList.get(1));
            tVar.f((Map) arrayList.get(2));
            Object obj = arrayList.get(3);
            tVar.g(obj == null ? null : m.a((ArrayList) obj));
            return tVar;
        }

        public Map<String, Object> b() {
            return this.f2892c;
        }

        public m c() {
            return this.f2893d;
        }

        public String d() {
            return this.f2891b;
        }

        public v e() {
            return this.f2890a;
        }

        public void f(Map<String, Object> map) {
            this.f2892c = map;
        }

        public void g(m mVar) {
            this.f2893d = mVar;
        }

        public void h(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"path\" is null.");
            }
            this.f2891b = str;
        }

        public void i(v vVar) {
            if (vVar == null) {
                throw new IllegalStateException("Nonnull field \"type\" is null.");
            }
            this.f2890a = vVar;
        }

        public ArrayList<Object> j() {
            ArrayList<Object> arrayList = new ArrayList<>(4);
            v vVar = this.f2890a;
            arrayList.add(vVar == null ? null : Integer.valueOf(vVar.f2903a));
            arrayList.add(this.f2891b);
            arrayList.add(this.f2892c);
            m mVar = this.f2893d;
            arrayList.add(mVar != null ? mVar.f() : null);
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public enum u {
        SUCCESS(0),
        FAILURE(1);
        

        /* renamed from: a  reason: collision with root package name */
        final int f2897a;

        u(int i5) {
            this.f2897a = i5;
        }
    }

    /* loaded from: classes.dex */
    public enum v {
        GET(0),
        UPDATE(1),
        SET(2),
        DELETE_TYPE(3);
        

        /* renamed from: a  reason: collision with root package name */
        final int f2903a;

        v(int i5) {
            this.f2903a = i5;
        }
    }

    /* loaded from: classes.dex */
    public interface w<T> {
        void a(T t5);

        void b(Throwable th);
    }

    /* loaded from: classes.dex */
    public enum x {
        NONE(0),
        ESTIMATE(1),
        PREVIOUS(2);
        

        /* renamed from: a  reason: collision with root package name */
        final int f2908a;

        x(int i5) {
            this.f2908a = i5;
        }
    }

    /* renamed from: e3.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public enum EnumC0049y {
        SERVER_AND_CACHE(0),
        SERVER(1),
        CACHE(2);
        

        /* renamed from: a  reason: collision with root package name */
        final int f2913a;

        EnumC0049y(int i5) {
            this.f2913a = i5;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static ArrayList<Object> a(Throwable th) {
        Object obj;
        ArrayList<Object> arrayList = new ArrayList<>(3);
        if (th instanceof j) {
            j jVar = (j) th;
            arrayList.add(jVar.f2842a);
            arrayList.add(jVar.getMessage());
            obj = jVar.f2843b;
        } else {
            arrayList.add(th.toString());
            arrayList.add(th.getClass().getSimpleName());
            obj = "Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th);
        }
        arrayList.add(obj);
        return arrayList;
    }
}
