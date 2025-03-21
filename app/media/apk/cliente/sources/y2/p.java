package y2;

import android.os.Build;
import android.util.DisplayMetrics;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import z2.a;
/* loaded from: classes.dex */
public class p {

    /* renamed from: b  reason: collision with root package name */
    private static final a f8742b = new a();

    /* renamed from: a  reason: collision with root package name */
    public final z2.a<Object> f8743a;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final ConcurrentLinkedQueue<b> f8744a = new ConcurrentLinkedQueue<>();

        /* renamed from: b  reason: collision with root package name */
        private b f8745b;

        /* renamed from: c  reason: collision with root package name */
        private b f8746c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: y2.p$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0133a implements a.e {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f8747a;

            C0133a(b bVar) {
                this.f8747a = bVar;
            }

            @Override // z2.a.e
            public void a(Object obj) {
                a.this.f8744a.remove(this.f8747a);
                if (a.this.f8744a.isEmpty()) {
                    return;
                }
                n2.b.b("SettingsChannel", "The queue becomes empty after removing config generation " + String.valueOf(this.f8747a.f8750a));
            }
        }

        /* loaded from: classes.dex */
        public static class b {

            /* renamed from: c  reason: collision with root package name */
            private static int f8749c = Integer.MIN_VALUE;

            /* renamed from: a  reason: collision with root package name */
            public final int f8750a;

            /* renamed from: b  reason: collision with root package name */
            private final DisplayMetrics f8751b;

            public b(DisplayMetrics displayMetrics) {
                int i5 = f8749c;
                f8749c = i5 + 1;
                this.f8750a = i5;
                this.f8751b = displayMetrics;
            }
        }

        public a.e b(b bVar) {
            this.f8744a.add(bVar);
            b bVar2 = this.f8746c;
            this.f8746c = bVar;
            if (bVar2 == null) {
                return null;
            }
            return new C0133a(bVar2);
        }

        public b c(int i5) {
            b bVar;
            StringBuilder sb;
            String valueOf;
            if (this.f8745b == null) {
                this.f8745b = this.f8744a.poll();
            }
            while (true) {
                bVar = this.f8745b;
                if (bVar == null || bVar.f8750a >= i5) {
                    break;
                }
                this.f8745b = this.f8744a.poll();
            }
            if (bVar == null) {
                sb = new StringBuilder();
                sb.append("Cannot find config with generation: ");
                sb.append(String.valueOf(i5));
                valueOf = ", after exhausting the queue.";
            } else if (bVar.f8750a == i5) {
                return bVar;
            } else {
                sb = new StringBuilder();
                sb.append("Cannot find config with generation: ");
                sb.append(String.valueOf(i5));
                sb.append(", the oldest config is now: ");
                valueOf = String.valueOf(this.f8745b.f8750a);
            }
            sb.append(valueOf);
            n2.b.b("SettingsChannel", sb.toString());
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final z2.a<Object> f8752a;

        /* renamed from: b  reason: collision with root package name */
        private Map<String, Object> f8753b = new HashMap();

        /* renamed from: c  reason: collision with root package name */
        private DisplayMetrics f8754c;

        b(z2.a<Object> aVar) {
            this.f8752a = aVar;
        }

        public void a() {
            n2.b.f("SettingsChannel", "Sending message: \ntextScaleFactor: " + this.f8753b.get("textScaleFactor") + "\nalwaysUse24HourFormat: " + this.f8753b.get("alwaysUse24HourFormat") + "\nplatformBrightness: " + this.f8753b.get("platformBrightness"));
            DisplayMetrics displayMetrics = this.f8754c;
            if (!p.c() || displayMetrics == null) {
                this.f8752a.c(this.f8753b);
                return;
            }
            a.b bVar = new a.b(displayMetrics);
            a.e<Object> b5 = p.f8742b.b(bVar);
            this.f8753b.put("configurationId", Integer.valueOf(bVar.f8750a));
            this.f8752a.d(this.f8753b, b5);
        }

        public b b(boolean z4) {
            this.f8753b.put("brieflyShowPassword", Boolean.valueOf(z4));
            return this;
        }

        public b c(DisplayMetrics displayMetrics) {
            this.f8754c = displayMetrics;
            return this;
        }

        public b d(boolean z4) {
            this.f8753b.put("nativeSpellCheckServiceDefined", Boolean.valueOf(z4));
            return this;
        }

        public b e(c cVar) {
            this.f8753b.put("platformBrightness", cVar.f8758a);
            return this;
        }

        public b f(float f5) {
            this.f8753b.put("textScaleFactor", Float.valueOf(f5));
            return this;
        }

        public b g(boolean z4) {
            this.f8753b.put("alwaysUse24HourFormat", Boolean.valueOf(z4));
            return this;
        }
    }

    /* loaded from: classes.dex */
    public enum c {
        light("light"),
        dark("dark");
        

        /* renamed from: a  reason: collision with root package name */
        public String f8758a;

        c(String str) {
            this.f8758a = str;
        }
    }

    public p(o2.a aVar) {
        this.f8743a = new z2.a<>(aVar, "flutter/settings", z2.e.f9001a);
    }

    public static DisplayMetrics b(int i5) {
        a.b c5 = f8742b.c(i5);
        if (c5 == null) {
            return null;
        }
        return c5.f8751b;
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 34;
    }

    public b d() {
        return new b(this.f8743a);
    }
}
