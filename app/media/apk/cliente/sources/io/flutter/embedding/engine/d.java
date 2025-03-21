package io.flutter.embedding.engine;

import android.content.Context;
import io.flutter.embedding.engine.a;
import io.flutter.plugin.platform.w;
import java.util.ArrayList;
import java.util.List;
import o2.a;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    final List<io.flutter.embedding.engine.a> f3831a = new ArrayList();

    /* loaded from: classes.dex */
    class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ io.flutter.embedding.engine.a f3832a;

        a(io.flutter.embedding.engine.a aVar) {
            this.f3832a = aVar;
        }

        @Override // io.flutter.embedding.engine.a.b
        public void a() {
            d.this.f3831a.remove(this.f3832a);
        }

        @Override // io.flutter.embedding.engine.a.b
        public void b() {
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private Context f3834a;

        /* renamed from: b  reason: collision with root package name */
        private a.b f3835b;

        /* renamed from: c  reason: collision with root package name */
        private String f3836c;

        /* renamed from: d  reason: collision with root package name */
        private List<String> f3837d;

        /* renamed from: e  reason: collision with root package name */
        private w f3838e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f3839f = true;

        /* renamed from: g  reason: collision with root package name */
        private boolean f3840g = false;

        public b(Context context) {
            this.f3834a = context;
        }

        public boolean a() {
            return this.f3839f;
        }

        public Context b() {
            return this.f3834a;
        }

        public a.b c() {
            return this.f3835b;
        }

        public List<String> d() {
            return this.f3837d;
        }

        public String e() {
            return this.f3836c;
        }

        public w f() {
            return this.f3838e;
        }

        public boolean g() {
            return this.f3840g;
        }

        public b h(boolean z4) {
            this.f3839f = z4;
            return this;
        }

        public b i(a.b bVar) {
            this.f3835b = bVar;
            return this;
        }

        public b j(List<String> list) {
            this.f3837d = list;
            return this;
        }

        public b k(String str) {
            this.f3836c = str;
            return this;
        }

        public b l(boolean z4) {
            this.f3840g = z4;
            return this;
        }
    }

    public d(Context context, String[] strArr) {
        q2.d c5 = n2.a.e().c();
        if (c5.i()) {
            return;
        }
        c5.k(context.getApplicationContext());
        c5.f(context.getApplicationContext(), strArr);
    }

    public io.flutter.embedding.engine.a a(b bVar) {
        io.flutter.embedding.engine.a A;
        Context b5 = bVar.b();
        a.b c5 = bVar.c();
        String e5 = bVar.e();
        List<String> d5 = bVar.d();
        w f5 = bVar.f();
        if (f5 == null) {
            f5 = new w();
        }
        w wVar = f5;
        boolean a5 = bVar.a();
        boolean g5 = bVar.g();
        a.b a6 = c5 == null ? a.b.a() : c5;
        if (this.f3831a.size() == 0) {
            A = b(b5, wVar, a5, g5);
            if (e5 != null) {
                A.o().c(e5);
            }
            A.k().h(a6, d5);
        } else {
            A = this.f3831a.get(0).A(b5, a6, e5, d5, wVar, a5, g5);
        }
        this.f3831a.add(A);
        A.e(new a(A));
        return A;
    }

    io.flutter.embedding.engine.a b(Context context, w wVar, boolean z4, boolean z5) {
        return new io.flutter.embedding.engine.a(context, null, null, wVar, null, z4, z5, this);
    }
}
