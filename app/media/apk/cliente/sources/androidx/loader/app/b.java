package androidx.loader.app;

import android.os.Bundle;
import android.util.Log;
import androidx.collection.g;
import androidx.lifecycle.h0;
import androidx.lifecycle.i0;
import androidx.lifecycle.j0;
import androidx.lifecycle.l0;
import androidx.lifecycle.m;
import androidx.lifecycle.s;
import androidx.lifecycle.t;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends androidx.loader.app.a {

    /* renamed from: c  reason: collision with root package name */
    static boolean f615c = false;

    /* renamed from: a  reason: collision with root package name */
    private final m f616a;

    /* renamed from: b  reason: collision with root package name */
    private final C0023b f617b;

    /* loaded from: classes.dex */
    public static class a<D> extends s<D> {

        /* renamed from: l  reason: collision with root package name */
        private final int f618l;

        /* renamed from: m  reason: collision with root package name */
        private final Bundle f619m;

        /* renamed from: n  reason: collision with root package name */
        private m f620n;

        @Override // androidx.lifecycle.q
        protected void f() {
            if (b.f615c) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            throw null;
        }

        @Override // androidx.lifecycle.q
        protected void g() {
            if (b.f615c) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            throw null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.q
        public void h(t<? super D> tVar) {
            super.h(tVar);
            this.f620n = null;
        }

        @Override // androidx.lifecycle.s, androidx.lifecycle.q
        public void i(D d5) {
            super.i(d5);
        }

        s.a<D> j(boolean z4) {
            if (b.f615c) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            throw null;
        }

        public void k(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f618l);
            printWriter.print(" mArgs=");
            printWriter.println(this.f619m);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println((Object) null);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("  ");
            throw null;
        }

        void l() {
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f618l);
            sb.append(" : ");
            k.b.a(null, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    /* renamed from: androidx.loader.app.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0023b extends h0 {

        /* renamed from: f  reason: collision with root package name */
        private static final i0.b f621f = new a();

        /* renamed from: d  reason: collision with root package name */
        private g<a> f622d = new g<>();

        /* renamed from: e  reason: collision with root package name */
        private boolean f623e = false;

        /* renamed from: androidx.loader.app.b$b$a */
        /* loaded from: classes.dex */
        static class a implements i0.b {
            a() {
            }

            @Override // androidx.lifecycle.i0.b
            public <T extends h0> T a(Class<T> cls) {
                return new C0023b();
            }

            @Override // androidx.lifecycle.i0.b
            public /* synthetic */ h0 b(Class cls, r.a aVar) {
                return j0.b(this, cls, aVar);
            }
        }

        C0023b() {
        }

        static C0023b e(l0 l0Var) {
            return (C0023b) new i0(l0Var, f621f).a(C0023b.class);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.lifecycle.h0
        public void c() {
            super.c();
            int e5 = this.f622d.e();
            for (int i5 = 0; i5 < e5; i5++) {
                this.f622d.f(i5).j(true);
            }
            this.f622d.a();
        }

        public void d(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f622d.e() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i5 = 0; i5 < this.f622d.e(); i5++) {
                    a f5 = this.f622d.f(i5);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f622d.d(i5));
                    printWriter.print(": ");
                    printWriter.println(f5.toString());
                    f5.k(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        void f() {
            int e5 = this.f622d.e();
            for (int i5 = 0; i5 < e5; i5++) {
                this.f622d.f(i5).l();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(m mVar, l0 l0Var) {
        this.f616a = mVar;
        this.f617b = C0023b.e(l0Var);
    }

    @Override // androidx.loader.app.a
    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f617b.d(str, fileDescriptor, printWriter, strArr);
    }

    @Override // androidx.loader.app.a
    public void c() {
        this.f617b.f();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        k.b.a(this.f616a, sb);
        sb.append("}}");
        return sb.toString();
    }
}
