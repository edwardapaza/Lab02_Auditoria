package z0;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
/* loaded from: classes.dex */
public final class f {

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final String f8869a;

        /* renamed from: b  reason: collision with root package name */
        private final C0136b f8870b;

        /* renamed from: c  reason: collision with root package name */
        private C0136b f8871c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f8872d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f8873e;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class a extends C0136b {
            private a() {
                super();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: z0.f$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0136b {

            /* renamed from: a  reason: collision with root package name */
            String f8874a;

            /* renamed from: b  reason: collision with root package name */
            Object f8875b;

            /* renamed from: c  reason: collision with root package name */
            C0136b f8876c;

            private C0136b() {
            }
        }

        private b(String str) {
            C0136b c0136b = new C0136b();
            this.f8870b = c0136b;
            this.f8871c = c0136b;
            this.f8872d = false;
            this.f8873e = false;
            this.f8869a = (String) k.n(str);
        }

        private C0136b f() {
            C0136b c0136b = new C0136b();
            this.f8871c.f8876c = c0136b;
            this.f8871c = c0136b;
            return c0136b;
        }

        private b g(String str, Object obj) {
            C0136b f5 = f();
            f5.f8875b = obj;
            f5.f8874a = (String) k.n(str);
            return this;
        }

        private a h() {
            a aVar = new a();
            this.f8871c.f8876c = aVar;
            this.f8871c = aVar;
            return aVar;
        }

        private b i(String str, Object obj) {
            a h5 = h();
            h5.f8875b = obj;
            h5.f8874a = (String) k.n(str);
            return this;
        }

        private static boolean j(Object obj) {
            return obj instanceof CharSequence ? ((CharSequence) obj).length() == 0 : obj instanceof Collection ? ((Collection) obj).isEmpty() : obj instanceof Map ? ((Map) obj).isEmpty() : obj instanceof h ? !((h) obj).a() : obj.getClass().isArray() && Array.getLength(obj) == 0;
        }

        public b a(String str, double d5) {
            return i(str, String.valueOf(d5));
        }

        public b b(String str, int i5) {
            return i(str, String.valueOf(i5));
        }

        public b c(String str, long j5) {
            return i(str, String.valueOf(j5));
        }

        public b d(String str, Object obj) {
            return g(str, obj);
        }

        public b e(String str, boolean z4) {
            return i(str, String.valueOf(z4));
        }

        public b k() {
            this.f8872d = true;
            return this;
        }

        public String toString() {
            boolean z4 = this.f8872d;
            boolean z5 = this.f8873e;
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.f8869a);
            sb.append('{');
            String str = "";
            for (C0136b c0136b = this.f8870b.f8876c; c0136b != null; c0136b = c0136b.f8876c) {
                Object obj = c0136b.f8875b;
                if (!(c0136b instanceof a)) {
                    if (obj == null) {
                        if (z4) {
                        }
                    } else if (z5 && j(obj)) {
                    }
                }
                sb.append(str);
                String str2 = c0136b.f8874a;
                if (str2 != null) {
                    sb.append(str2);
                    sb.append('=');
                }
                if (obj == null || !obj.getClass().isArray()) {
                    sb.append(obj);
                } else {
                    String deepToString = Arrays.deepToString(new Object[]{obj});
                    sb.append((CharSequence) deepToString, 1, deepToString.length() - 1);
                }
                str = ", ";
            }
            sb.append('}');
            return sb.toString();
        }
    }

    public static b a(Class<?> cls) {
        return new b(cls.getSimpleName());
    }

    public static b b(Object obj) {
        return new b(obj.getClass().getSimpleName());
    }
}
