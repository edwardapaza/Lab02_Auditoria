package y2;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import y2.m;
import z2.j;
/* loaded from: classes.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private final z2.j f8689a;

    /* renamed from: b  reason: collision with root package name */
    private g f8690b;

    /* renamed from: c  reason: collision with root package name */
    private final j.c f8691c;

    /* loaded from: classes.dex */
    class a implements j.c {
        a() {
        }

        private void c(z2.i iVar, j.d dVar) {
            try {
                m.this.f8690b.f(((Integer) iVar.a()).intValue());
                dVar.a(null);
            } catch (IllegalStateException e5) {
                dVar.b("error", m.c(e5), null);
            }
        }

        private void d(z2.i iVar, j.d dVar) {
            Map map = (Map) iVar.a();
            boolean z4 = true;
            boolean z5 = map.containsKey("hybrid") && ((Boolean) map.get("hybrid")).booleanValue();
            ByteBuffer wrap = map.containsKey("params") ? ByteBuffer.wrap((byte[]) map.get("params")) : null;
            try {
                if (z5) {
                    m.this.f8690b.a(new d(((Integer) map.get("id")).intValue(), (String) map.get("viewType"), 0.0d, 0.0d, 0.0d, 0.0d, ((Integer) map.get("direction")).intValue(), d.a.HYBRID_ONLY, wrap));
                } else {
                    if (!map.containsKey("hybridFallback") || !((Boolean) map.get("hybridFallback")).booleanValue()) {
                        z4 = false;
                    }
                    long i5 = m.this.f8690b.i(new d(((Integer) map.get("id")).intValue(), (String) map.get("viewType"), map.containsKey("top") ? ((Double) map.get("top")).doubleValue() : 0.0d, map.containsKey("left") ? ((Double) map.get("left")).doubleValue() : 0.0d, ((Double) map.get("width")).doubleValue(), ((Double) map.get("height")).doubleValue(), ((Integer) map.get("direction")).intValue(), z4 ? d.a.TEXTURE_WITH_HYBRID_FALLBACK : d.a.TEXTURE_WITH_VIRTUAL_FALLBACK, wrap));
                    if (i5 != -2) {
                        dVar.a(Long.valueOf(i5));
                        return;
                    } else if (!z4) {
                        throw new AssertionError("Platform view attempted to fall back to hybrid mode when not requested.");
                    }
                }
                dVar.a(null);
            } catch (IllegalStateException e5) {
                dVar.b("error", m.c(e5), null);
            }
        }

        private void e(z2.i iVar, j.d dVar) {
            try {
                m.this.f8690b.h(((Integer) ((Map) iVar.a()).get("id")).intValue());
                dVar.a(null);
            } catch (IllegalStateException e5) {
                dVar.b("error", m.c(e5), null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void f(j.d dVar, c cVar) {
            if (cVar == null) {
                dVar.b("error", "Failed to resize the platform view", null);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("width", Double.valueOf(cVar.f8693a));
            hashMap.put("height", Double.valueOf(cVar.f8694b));
            dVar.a(hashMap);
        }

        private void g(z2.i iVar, j.d dVar) {
            Map map = (Map) iVar.a();
            try {
                m.this.f8690b.c(((Integer) map.get("id")).intValue(), ((Double) map.get("top")).doubleValue(), ((Double) map.get("left")).doubleValue());
                dVar.a(null);
            } catch (IllegalStateException e5) {
                dVar.b("error", m.c(e5), null);
            }
        }

        private void h(z2.i iVar, final j.d dVar) {
            Map map = (Map) iVar.a();
            try {
                m.this.f8690b.g(new e(((Integer) map.get("id")).intValue(), ((Double) map.get("width")).doubleValue(), ((Double) map.get("height")).doubleValue()), new b() { // from class: y2.l
                    @Override // y2.m.b
                    public final void a(m.c cVar) {
                        m.a.f(j.d.this, cVar);
                    }
                });
            } catch (IllegalStateException e5) {
                dVar.b("error", m.c(e5), null);
            }
        }

        private void i(z2.i iVar, j.d dVar) {
            Map map = (Map) iVar.a();
            try {
                m.this.f8690b.d(((Integer) map.get("id")).intValue(), ((Integer) map.get("direction")).intValue());
                dVar.a(null);
            } catch (IllegalStateException e5) {
                dVar.b("error", m.c(e5), null);
            }
        }

        private void j(z2.i iVar, j.d dVar) {
            try {
                m.this.f8690b.b(((Boolean) iVar.a()).booleanValue());
                dVar.a(null);
            } catch (IllegalStateException e5) {
                dVar.b("error", m.c(e5), null);
            }
        }

        private void k(z2.i iVar, j.d dVar) {
            j.d dVar2;
            List list = (List) iVar.a();
            try {
                m.this.f8690b.e(new f(((Integer) list.get(0)).intValue(), (Number) list.get(1), (Number) list.get(2), ((Integer) list.get(3)).intValue(), ((Integer) list.get(4)).intValue(), list.get(5), list.get(6), ((Integer) list.get(7)).intValue(), ((Integer) list.get(8)).intValue(), (float) ((Double) list.get(9)).doubleValue(), (float) ((Double) list.get(10)).doubleValue(), ((Integer) list.get(11)).intValue(), ((Integer) list.get(12)).intValue(), ((Integer) list.get(13)).intValue(), ((Integer) list.get(14)).intValue(), ((Number) list.get(15)).longValue()));
                dVar2 = dVar;
            } catch (IllegalStateException e5) {
                e = e5;
                dVar2 = dVar;
            }
            try {
                dVar2.a(null);
            } catch (IllegalStateException e6) {
                e = e6;
                dVar2.b("error", m.c(e), null);
            }
        }

        @Override // z2.j.c
        public void a(z2.i iVar, j.d dVar) {
            if (m.this.f8690b == null) {
                return;
            }
            n2.b.f("PlatformViewsChannel", "Received '" + iVar.f9003a + "' message.");
            String str = iVar.f9003a;
            str.hashCode();
            char c5 = 65535;
            switch (str.hashCode()) {
                case -1352294148:
                    if (str.equals("create")) {
                        c5 = 0;
                        break;
                    }
                    break;
                case -1019779949:
                    if (str.equals("offset")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case -934437708:
                    if (str.equals("resize")) {
                        c5 = 2;
                        break;
                    }
                    break;
                case -756050293:
                    if (str.equals("clearFocus")) {
                        c5 = 3;
                        break;
                    }
                    break;
                case -308988850:
                    if (str.equals("synchronizeToNativeViewHierarchy")) {
                        c5 = 4;
                        break;
                    }
                    break;
                case 110550847:
                    if (str.equals("touch")) {
                        c5 = 5;
                        break;
                    }
                    break;
                case 576796989:
                    if (str.equals("setDirection")) {
                        c5 = 6;
                        break;
                    }
                    break;
                case 1671767583:
                    if (str.equals("dispose")) {
                        c5 = 7;
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    d(iVar, dVar);
                    return;
                case 1:
                    g(iVar, dVar);
                    return;
                case 2:
                    h(iVar, dVar);
                    return;
                case 3:
                    c(iVar, dVar);
                    return;
                case 4:
                    j(iVar, dVar);
                    return;
                case 5:
                    k(iVar, dVar);
                    return;
                case 6:
                    i(iVar, dVar);
                    return;
                case 7:
                    e(iVar, dVar);
                    return;
                default:
                    dVar.c();
                    return;
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(c cVar);
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final int f8693a;

        /* renamed from: b  reason: collision with root package name */
        public final int f8694b;

        public c(int i5, int i6) {
            this.f8693a = i5;
            this.f8694b = i6;
        }
    }

    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final int f8695a;

        /* renamed from: b  reason: collision with root package name */
        public final String f8696b;

        /* renamed from: c  reason: collision with root package name */
        public final double f8697c;

        /* renamed from: d  reason: collision with root package name */
        public final double f8698d;

        /* renamed from: e  reason: collision with root package name */
        public final double f8699e;

        /* renamed from: f  reason: collision with root package name */
        public final double f8700f;

        /* renamed from: g  reason: collision with root package name */
        public final int f8701g;

        /* renamed from: h  reason: collision with root package name */
        public final a f8702h;

        /* renamed from: i  reason: collision with root package name */
        public final ByteBuffer f8703i;

        /* loaded from: classes.dex */
        public enum a {
            TEXTURE_WITH_VIRTUAL_FALLBACK,
            TEXTURE_WITH_HYBRID_FALLBACK,
            HYBRID_ONLY
        }

        public d(int i5, String str, double d5, double d6, double d7, double d8, int i6, a aVar, ByteBuffer byteBuffer) {
            this.f8695a = i5;
            this.f8696b = str;
            this.f8699e = d5;
            this.f8700f = d6;
            this.f8697c = d7;
            this.f8698d = d8;
            this.f8701g = i6;
            this.f8702h = aVar;
            this.f8703i = byteBuffer;
        }
    }

    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public final int f8708a;

        /* renamed from: b  reason: collision with root package name */
        public final double f8709b;

        /* renamed from: c  reason: collision with root package name */
        public final double f8710c;

        public e(int i5, double d5, double d6) {
            this.f8708a = i5;
            this.f8709b = d5;
            this.f8710c = d6;
        }
    }

    /* loaded from: classes.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public final int f8711a;

        /* renamed from: b  reason: collision with root package name */
        public final Number f8712b;

        /* renamed from: c  reason: collision with root package name */
        public final Number f8713c;

        /* renamed from: d  reason: collision with root package name */
        public final int f8714d;

        /* renamed from: e  reason: collision with root package name */
        public final int f8715e;

        /* renamed from: f  reason: collision with root package name */
        public final Object f8716f;

        /* renamed from: g  reason: collision with root package name */
        public final Object f8717g;

        /* renamed from: h  reason: collision with root package name */
        public final int f8718h;

        /* renamed from: i  reason: collision with root package name */
        public final int f8719i;

        /* renamed from: j  reason: collision with root package name */
        public final float f8720j;

        /* renamed from: k  reason: collision with root package name */
        public final float f8721k;

        /* renamed from: l  reason: collision with root package name */
        public final int f8722l;

        /* renamed from: m  reason: collision with root package name */
        public final int f8723m;

        /* renamed from: n  reason: collision with root package name */
        public final int f8724n;

        /* renamed from: o  reason: collision with root package name */
        public final int f8725o;

        /* renamed from: p  reason: collision with root package name */
        public final long f8726p;

        public f(int i5, Number number, Number number2, int i6, int i7, Object obj, Object obj2, int i8, int i9, float f5, float f6, int i10, int i11, int i12, int i13, long j5) {
            this.f8711a = i5;
            this.f8712b = number;
            this.f8713c = number2;
            this.f8714d = i6;
            this.f8715e = i7;
            this.f8716f = obj;
            this.f8717g = obj2;
            this.f8718h = i8;
            this.f8719i = i9;
            this.f8720j = f5;
            this.f8721k = f6;
            this.f8722l = i10;
            this.f8723m = i11;
            this.f8724n = i12;
            this.f8725o = i13;
            this.f8726p = j5;
        }
    }

    /* loaded from: classes.dex */
    public interface g {
        void a(d dVar);

        void b(boolean z4);

        void c(int i5, double d5, double d6);

        void d(int i5, int i6);

        void e(f fVar);

        void f(int i5);

        void g(e eVar, b bVar);

        void h(int i5);

        long i(d dVar);
    }

    public m(o2.a aVar) {
        a aVar2 = new a();
        this.f8691c = aVar2;
        z2.j jVar = new z2.j(aVar, "flutter/platform_views", z2.q.f9018b);
        this.f8689a = jVar;
        jVar.e(aVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String c(Exception exc) {
        return n2.b.d(exc);
    }

    public void d(int i5) {
        z2.j jVar = this.f8689a;
        if (jVar == null) {
            return;
        }
        jVar.c("viewFocused", Integer.valueOf(i5));
    }

    public void e(g gVar) {
        this.f8690b = gVar;
    }
}
