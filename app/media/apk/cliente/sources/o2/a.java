package o2;

import android.content.res.AssetManager;
import io.flutter.embedding.engine.FlutterJNI;
import java.nio.ByteBuffer;
import java.util.List;
import z2.b;
import z2.r;
/* loaded from: classes.dex */
public class a implements z2.b {

    /* renamed from: a  reason: collision with root package name */
    private final FlutterJNI f6739a;

    /* renamed from: b  reason: collision with root package name */
    private final AssetManager f6740b;

    /* renamed from: c  reason: collision with root package name */
    private final o2.c f6741c;

    /* renamed from: d  reason: collision with root package name */
    private final z2.b f6742d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f6743e;

    /* renamed from: f  reason: collision with root package name */
    private String f6744f;

    /* renamed from: g  reason: collision with root package name */
    private d f6745g;

    /* renamed from: h  reason: collision with root package name */
    private final b.a f6746h;

    /* renamed from: o2.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0103a implements b.a {
        C0103a() {
        }

        @Override // z2.b.a
        public void a(ByteBuffer byteBuffer, b.InterfaceC0139b interfaceC0139b) {
            a.this.f6744f = r.f9021b.b(byteBuffer);
            if (a.this.f6745g != null) {
                a.this.f6745g.a(a.this.f6744f);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f6748a;

        /* renamed from: b  reason: collision with root package name */
        public final String f6749b;

        /* renamed from: c  reason: collision with root package name */
        public final String f6750c;

        public b(String str, String str2) {
            this.f6748a = str;
            this.f6749b = null;
            this.f6750c = str2;
        }

        public b(String str, String str2, String str3) {
            this.f6748a = str;
            this.f6749b = str2;
            this.f6750c = str3;
        }

        public static b a() {
            q2.d c5 = n2.a.e().c();
            if (c5.i()) {
                return new b(c5.g(), "main");
            }
            throw new AssertionError("DartEntrypoints can only be created once a FlutterEngine is created.");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f6748a.equals(bVar.f6748a)) {
                return this.f6750c.equals(bVar.f6750c);
            }
            return false;
        }

        public int hashCode() {
            return (this.f6748a.hashCode() * 31) + this.f6750c.hashCode();
        }

        public String toString() {
            return "DartEntrypoint( bundle path: " + this.f6748a + ", function: " + this.f6750c + " )";
        }
    }

    /* loaded from: classes.dex */
    private static class c implements z2.b {

        /* renamed from: a  reason: collision with root package name */
        private final o2.c f6751a;

        private c(o2.c cVar) {
            this.f6751a = cVar;
        }

        /* synthetic */ c(o2.c cVar, C0103a c0103a) {
            this(cVar);
        }

        @Override // z2.b
        public void a(String str, ByteBuffer byteBuffer, b.InterfaceC0139b interfaceC0139b) {
            this.f6751a.a(str, byteBuffer, interfaceC0139b);
        }

        @Override // z2.b
        public void b(String str, b.a aVar) {
            this.f6751a.b(str, aVar);
        }

        @Override // z2.b
        public void c(String str, ByteBuffer byteBuffer) {
            this.f6751a.a(str, byteBuffer, null);
        }

        @Override // z2.b
        public void e(String str, b.a aVar, b.c cVar) {
            this.f6751a.e(str, aVar, cVar);
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(String str);
    }

    public a(FlutterJNI flutterJNI, AssetManager assetManager) {
        this.f6743e = false;
        C0103a c0103a = new C0103a();
        this.f6746h = c0103a;
        this.f6739a = flutterJNI;
        this.f6740b = assetManager;
        o2.c cVar = new o2.c(flutterJNI);
        this.f6741c = cVar;
        cVar.b("flutter/isolate", c0103a);
        this.f6742d = new c(cVar, null);
        if (flutterJNI.isAttached()) {
            this.f6743e = true;
        }
    }

    @Override // z2.b
    @Deprecated
    public void a(String str, ByteBuffer byteBuffer, b.InterfaceC0139b interfaceC0139b) {
        this.f6742d.a(str, byteBuffer, interfaceC0139b);
    }

    @Override // z2.b
    @Deprecated
    public void b(String str, b.a aVar) {
        this.f6742d.b(str, aVar);
    }

    @Override // z2.b
    @Deprecated
    public void c(String str, ByteBuffer byteBuffer) {
        this.f6742d.c(str, byteBuffer);
    }

    @Override // z2.b
    @Deprecated
    public void e(String str, b.a aVar, b.c cVar) {
        this.f6742d.e(str, aVar, cVar);
    }

    public void h(b bVar, List<String> list) {
        if (this.f6743e) {
            n2.b.g("DartExecutor", "Attempted to run a DartExecutor that is already running.");
            return;
        }
        h3.e j5 = h3.e.j("DartExecutor#executeDartEntrypoint");
        try {
            n2.b.f("DartExecutor", "Executing Dart entrypoint: " + bVar);
            this.f6739a.runBundleAndSnapshotFromLibrary(bVar.f6748a, bVar.f6750c, bVar.f6749b, this.f6740b, list);
            this.f6743e = true;
            if (j5 != null) {
                j5.close();
            }
        } catch (Throwable th) {
            if (j5 != null) {
                try {
                    j5.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public boolean i() {
        return this.f6743e;
    }

    public void j() {
        if (this.f6739a.isAttached()) {
            this.f6739a.notifyLowMemoryWarning();
        }
    }

    public void k() {
        n2.b.f("DartExecutor", "Attached to JNI. Registering the platform message handler for this Dart execution context.");
        this.f6739a.setPlatformMessageHandler(this.f6741c);
    }

    public void l() {
        n2.b.f("DartExecutor", "Detached from JNI. De-registering the platform message handler for this Dart execution context.");
        this.f6739a.setPlatformMessageHandler(null);
    }
}
