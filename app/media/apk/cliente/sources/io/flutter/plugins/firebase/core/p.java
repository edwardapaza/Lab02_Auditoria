package io.flutter.plugins.firebase.core;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class p {

    /* loaded from: classes.dex */
    public interface a {
        void e(String str, Boolean bool, g<Void> gVar);

        void f(String str, Boolean bool, g<Void> gVar);

        void g(String str, g<Void> gVar);
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(String str, e eVar, g<f> gVar);

        void c(g<List<f>> gVar);

        void d(g<e> gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends z2.p {

        /* renamed from: d  reason: collision with root package name */
        public static final c f4138d = new c();

        private c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // z2.p
        public Object g(byte b5, ByteBuffer byteBuffer) {
            return b5 != Byte.MIN_VALUE ? b5 != -127 ? super.g(b5, byteBuffer) : f.a((ArrayList) f(byteBuffer)) : e.a((ArrayList) f(byteBuffer));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // z2.p
        public void p(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            ArrayList<Object> f5;
            if (obj instanceof e) {
                byteArrayOutputStream.write(128);
                f5 = ((e) obj).x();
            } else if (!(obj instanceof f)) {
                super.p(byteArrayOutputStream, obj);
                return;
            } else {
                byteArrayOutputStream.write(129);
                f5 = ((f) obj).f();
            }
            p(byteArrayOutputStream, f5);
        }
    }

    /* loaded from: classes.dex */
    public static class d extends RuntimeException {

        /* renamed from: a  reason: collision with root package name */
        public final String f4139a;

        /* renamed from: b  reason: collision with root package name */
        public final Object f4140b;
    }

    /* loaded from: classes.dex */
    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        private String f4141a;

        /* renamed from: b  reason: collision with root package name */
        private String f4142b;

        /* renamed from: c  reason: collision with root package name */
        private String f4143c;

        /* renamed from: d  reason: collision with root package name */
        private String f4144d;

        /* renamed from: e  reason: collision with root package name */
        private String f4145e;

        /* renamed from: f  reason: collision with root package name */
        private String f4146f;

        /* renamed from: g  reason: collision with root package name */
        private String f4147g;

        /* renamed from: h  reason: collision with root package name */
        private String f4148h;

        /* renamed from: i  reason: collision with root package name */
        private String f4149i;

        /* renamed from: j  reason: collision with root package name */
        private String f4150j;

        /* renamed from: k  reason: collision with root package name */
        private String f4151k;

        /* renamed from: l  reason: collision with root package name */
        private String f4152l;

        /* renamed from: m  reason: collision with root package name */
        private String f4153m;

        /* renamed from: n  reason: collision with root package name */
        private String f4154n;

        /* loaded from: classes.dex */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            private String f4155a;

            /* renamed from: b  reason: collision with root package name */
            private String f4156b;

            /* renamed from: c  reason: collision with root package name */
            private String f4157c;

            /* renamed from: d  reason: collision with root package name */
            private String f4158d;

            /* renamed from: e  reason: collision with root package name */
            private String f4159e;

            /* renamed from: f  reason: collision with root package name */
            private String f4160f;

            /* renamed from: g  reason: collision with root package name */
            private String f4161g;

            /* renamed from: h  reason: collision with root package name */
            private String f4162h;

            /* renamed from: i  reason: collision with root package name */
            private String f4163i;

            /* renamed from: j  reason: collision with root package name */
            private String f4164j;

            /* renamed from: k  reason: collision with root package name */
            private String f4165k;

            /* renamed from: l  reason: collision with root package name */
            private String f4166l;

            /* renamed from: m  reason: collision with root package name */
            private String f4167m;

            /* renamed from: n  reason: collision with root package name */
            private String f4168n;

            public e a() {
                e eVar = new e();
                eVar.k(this.f4155a);
                eVar.m(this.f4156b);
                eVar.t(this.f4157c);
                eVar.u(this.f4158d);
                eVar.n(this.f4159e);
                eVar.o(this.f4160f);
                eVar.v(this.f4161g);
                eVar.s(this.f4162h);
                eVar.w(this.f4163i);
                eVar.p(this.f4164j);
                eVar.j(this.f4165k);
                eVar.r(this.f4166l);
                eVar.q(this.f4167m);
                eVar.l(this.f4168n);
                return eVar;
            }

            public a b(String str) {
                this.f4155a = str;
                return this;
            }

            public a c(String str) {
                this.f4156b = str;
                return this;
            }

            public a d(String str) {
                this.f4160f = str;
                return this;
            }

            public a e(String str) {
                this.f4157c = str;
                return this;
            }

            public a f(String str) {
                this.f4158d = str;
                return this;
            }

            public a g(String str) {
                this.f4161g = str;
                return this;
            }

            public a h(String str) {
                this.f4163i = str;
                return this;
            }
        }

        e() {
        }

        static e a(ArrayList<Object> arrayList) {
            e eVar = new e();
            eVar.k((String) arrayList.get(0));
            eVar.m((String) arrayList.get(1));
            eVar.t((String) arrayList.get(2));
            eVar.u((String) arrayList.get(3));
            eVar.n((String) arrayList.get(4));
            eVar.o((String) arrayList.get(5));
            eVar.v((String) arrayList.get(6));
            eVar.s((String) arrayList.get(7));
            eVar.w((String) arrayList.get(8));
            eVar.p((String) arrayList.get(9));
            eVar.j((String) arrayList.get(10));
            eVar.r((String) arrayList.get(11));
            eVar.q((String) arrayList.get(12));
            eVar.l((String) arrayList.get(13));
            return eVar;
        }

        public String b() {
            return this.f4141a;
        }

        public String c() {
            return this.f4142b;
        }

        public String d() {
            return this.f4145e;
        }

        public String e() {
            return this.f4146f;
        }

        public String f() {
            return this.f4143c;
        }

        public String g() {
            return this.f4144d;
        }

        public String h() {
            return this.f4147g;
        }

        public String i() {
            return this.f4149i;
        }

        public void j(String str) {
            this.f4151k = str;
        }

        public void k(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"apiKey\" is null.");
            }
            this.f4141a = str;
        }

        public void l(String str) {
            this.f4154n = str;
        }

        public void m(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"appId\" is null.");
            }
            this.f4142b = str;
        }

        public void n(String str) {
            this.f4145e = str;
        }

        public void o(String str) {
            this.f4146f = str;
        }

        public void p(String str) {
            this.f4150j = str;
        }

        public void q(String str) {
            this.f4153m = str;
        }

        public void r(String str) {
            this.f4152l = str;
        }

        public void s(String str) {
            this.f4148h = str;
        }

        public void t(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"messagingSenderId\" is null.");
            }
            this.f4143c = str;
        }

        public void u(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"projectId\" is null.");
            }
            this.f4144d = str;
        }

        public void v(String str) {
            this.f4147g = str;
        }

        public void w(String str) {
            this.f4149i = str;
        }

        public ArrayList<Object> x() {
            ArrayList<Object> arrayList = new ArrayList<>(14);
            arrayList.add(this.f4141a);
            arrayList.add(this.f4142b);
            arrayList.add(this.f4143c);
            arrayList.add(this.f4144d);
            arrayList.add(this.f4145e);
            arrayList.add(this.f4146f);
            arrayList.add(this.f4147g);
            arrayList.add(this.f4148h);
            arrayList.add(this.f4149i);
            arrayList.add(this.f4150j);
            arrayList.add(this.f4151k);
            arrayList.add(this.f4152l);
            arrayList.add(this.f4153m);
            arrayList.add(this.f4154n);
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public static final class f {

        /* renamed from: a  reason: collision with root package name */
        private String f4169a;

        /* renamed from: b  reason: collision with root package name */
        private e f4170b;

        /* renamed from: c  reason: collision with root package name */
        private Boolean f4171c;

        /* renamed from: d  reason: collision with root package name */
        private Map<String, Object> f4172d;

        /* loaded from: classes.dex */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            private String f4173a;

            /* renamed from: b  reason: collision with root package name */
            private e f4174b;

            /* renamed from: c  reason: collision with root package name */
            private Boolean f4175c;

            /* renamed from: d  reason: collision with root package name */
            private Map<String, Object> f4176d;

            public f a() {
                f fVar = new f();
                fVar.c(this.f4173a);
                fVar.d(this.f4174b);
                fVar.b(this.f4175c);
                fVar.e(this.f4176d);
                return fVar;
            }

            public a b(Boolean bool) {
                this.f4175c = bool;
                return this;
            }

            public a c(String str) {
                this.f4173a = str;
                return this;
            }

            public a d(e eVar) {
                this.f4174b = eVar;
                return this;
            }

            public a e(Map<String, Object> map) {
                this.f4176d = map;
                return this;
            }
        }

        f() {
        }

        static f a(ArrayList<Object> arrayList) {
            f fVar = new f();
            fVar.c((String) arrayList.get(0));
            Object obj = arrayList.get(1);
            fVar.d(obj == null ? null : e.a((ArrayList) obj));
            fVar.b((Boolean) arrayList.get(2));
            fVar.e((Map) arrayList.get(3));
            return fVar;
        }

        public void b(Boolean bool) {
            this.f4171c = bool;
        }

        public void c(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"name\" is null.");
            }
            this.f4169a = str;
        }

        public void d(e eVar) {
            if (eVar == null) {
                throw new IllegalStateException("Nonnull field \"options\" is null.");
            }
            this.f4170b = eVar;
        }

        public void e(Map<String, Object> map) {
            if (map == null) {
                throw new IllegalStateException("Nonnull field \"pluginConstants\" is null.");
            }
            this.f4172d = map;
        }

        public ArrayList<Object> f() {
            ArrayList<Object> arrayList = new ArrayList<>(4);
            arrayList.add(this.f4169a);
            e eVar = this.f4170b;
            arrayList.add(eVar == null ? null : eVar.x());
            arrayList.add(this.f4171c);
            arrayList.add(this.f4172d);
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public interface g<T> {
        void a(T t5);

        void b(Throwable th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static ArrayList<Object> a(Throwable th) {
        Object obj;
        ArrayList<Object> arrayList = new ArrayList<>(3);
        if (th instanceof d) {
            d dVar = (d) th;
            arrayList.add(dVar.f4139a);
            arrayList.add(dVar.getMessage());
            obj = dVar.f4140b;
        } else {
            arrayList.add(th.toString());
            arrayList.add(th.getClass().getSimpleName());
            obj = "Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th);
        }
        arrayList.add(obj);
        return arrayList;
    }
}
