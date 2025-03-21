package s2;

import android.content.Context;
import io.flutter.embedding.engine.d;
import io.flutter.plugin.platform.k;
import io.flutter.view.TextureRegistry;
/* loaded from: classes.dex */
public interface a {

    /* renamed from: s2.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0113a {
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Context f7549a;

        /* renamed from: b  reason: collision with root package name */
        private final io.flutter.embedding.engine.a f7550b;

        /* renamed from: c  reason: collision with root package name */
        private final z2.b f7551c;

        /* renamed from: d  reason: collision with root package name */
        private final TextureRegistry f7552d;

        /* renamed from: e  reason: collision with root package name */
        private final k f7553e;

        /* renamed from: f  reason: collision with root package name */
        private final InterfaceC0113a f7554f;

        /* renamed from: g  reason: collision with root package name */
        private final d f7555g;

        public b(Context context, io.flutter.embedding.engine.a aVar, z2.b bVar, TextureRegistry textureRegistry, k kVar, InterfaceC0113a interfaceC0113a, d dVar) {
            this.f7549a = context;
            this.f7550b = aVar;
            this.f7551c = bVar;
            this.f7552d = textureRegistry;
            this.f7553e = kVar;
            this.f7554f = interfaceC0113a;
            this.f7555g = dVar;
        }

        public Context a() {
            return this.f7549a;
        }

        public z2.b b() {
            return this.f7551c;
        }
    }

    void b(b bVar);

    void t(b bVar);
}
