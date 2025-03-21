package y2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import z2.j;
/* loaded from: classes.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public final z2.j f8638a;

    /* renamed from: b  reason: collision with root package name */
    private h f8639b;

    /* renamed from: c  reason: collision with root package name */
    final j.c f8640c;

    /* loaded from: classes.dex */
    class a implements j.c {
        a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:69:0x0143 A[Catch: JSONException -> 0x024c, TryCatch #11 {JSONException -> 0x024c, blocks: (B:6:0x002c, B:7:0x0030, B:56:0x00db, B:57:0x00e0, B:58:0x00eb, B:59:0x00f0, B:60:0x0109, B:61:0x0119, B:63:0x011d, B:67:0x0137, B:69:0x0143, B:65:0x0122, B:70:0x0150, B:71:0x015a, B:80:0x018c, B:81:0x0197, B:109:0x0218, B:114:0x0232, B:78:0x0183, B:79:0x0187, B:88:0x01bb, B:95:0x01d9, B:100:0x01f5, B:107:0x0212, B:112:0x022c, B:117:0x0246, B:9:0x0035, B:12:0x0040, B:15:0x004b, B:18:0x0057, B:21:0x0063, B:24:0x006e, B:27:0x0079, B:30:0x0083, B:33:0x008d, B:36:0x0097, B:39:0x00a1, B:42:0x00ab, B:45:0x00b6, B:48:0x00c1, B:51:0x00cc, B:97:0x01de), top: B:130:0x002c, inners: #1, #2, #5, #8 }] */
        @Override // z2.j.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void a(z2.i r6, z2.j.d r7) {
            /*
                Method dump skipped, instructions count: 710
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: y2.k.a.a(z2.i, z2.j$d):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f8642a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f8643b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f8644c;

        static {
            int[] iArr = new int[EnumC0132k.values().length];
            f8644c = iArr;
            try {
                iArr[EnumC0132k.LEAN_BACK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8644c[EnumC0132k.IMMERSIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8644c[EnumC0132k.IMMERSIVE_STICKY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8644c[EnumC0132k.EDGE_TO_EDGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[l.values().length];
            f8643b = iArr2;
            try {
                iArr2[l.TOP_OVERLAYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8643b[l.BOTTOM_OVERLAYS.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr3 = new int[f.values().length];
            f8642a = iArr3;
            try {
                iArr3[f.PORTRAIT_UP.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f8642a[f.PORTRAIT_DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f8642a[f.LANDSCAPE_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f8642a[f.LANDSCAPE_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final int f8645a;

        /* renamed from: b  reason: collision with root package name */
        public final String f8646b;

        public c(int i5, String str) {
            this.f8645a = i5;
            this.f8646b = str;
        }
    }

    /* loaded from: classes.dex */
    public enum d {
        LIGHT("Brightness.light"),
        DARK("Brightness.dark");
        

        /* renamed from: a  reason: collision with root package name */
        private String f8650a;

        d(String str) {
            this.f8650a = str;
        }

        static d c(String str) {
            d[] values;
            for (d dVar : values()) {
                if (dVar.f8650a.equals(str)) {
                    return dVar;
                }
            }
            throw new NoSuchFieldException("No such Brightness: " + str);
        }
    }

    /* loaded from: classes.dex */
    public enum e {
        PLAIN_TEXT("text/plain");
        

        /* renamed from: a  reason: collision with root package name */
        private String f8653a;

        e(String str) {
            this.f8653a = str;
        }

        static e c(String str) {
            e[] values;
            for (e eVar : values()) {
                if (eVar.f8653a.equals(str)) {
                    return eVar;
                }
            }
            throw new NoSuchFieldException("No such ClipboardContentFormat: " + str);
        }
    }

    /* loaded from: classes.dex */
    public enum f {
        PORTRAIT_UP("DeviceOrientation.portraitUp"),
        PORTRAIT_DOWN("DeviceOrientation.portraitDown"),
        LANDSCAPE_LEFT("DeviceOrientation.landscapeLeft"),
        LANDSCAPE_RIGHT("DeviceOrientation.landscapeRight");
        

        /* renamed from: a  reason: collision with root package name */
        private String f8659a;

        f(String str) {
            this.f8659a = str;
        }

        static f c(String str) {
            f[] values;
            for (f fVar : values()) {
                if (fVar.f8659a.equals(str)) {
                    return fVar;
                }
            }
            throw new NoSuchFieldException("No such DeviceOrientation: " + str);
        }
    }

    /* loaded from: classes.dex */
    public enum g {
        STANDARD(null),
        LIGHT_IMPACT("HapticFeedbackType.lightImpact"),
        MEDIUM_IMPACT("HapticFeedbackType.mediumImpact"),
        HEAVY_IMPACT("HapticFeedbackType.heavyImpact"),
        SELECTION_CLICK("HapticFeedbackType.selectionClick");
        

        /* renamed from: a  reason: collision with root package name */
        private final String f8666a;

        g(String str) {
            this.f8666a = str;
        }

        static g c(String str) {
            g[] values;
            for (g gVar : values()) {
                String str2 = gVar.f8666a;
                if ((str2 == null && str == null) || (str2 != null && str2.equals(str))) {
                    return gVar;
                }
            }
            throw new NoSuchFieldException("No such HapticFeedbackType: " + str);
        }
    }

    /* loaded from: classes.dex */
    public interface h {
        void a(i iVar);

        void b();

        void c(c cVar);

        void d(List<l> list);

        void e();

        void f();

        void g(boolean z4);

        void h(String str);

        CharSequence i(e eVar);

        void j(j jVar);

        void k(EnumC0132k enumC0132k);

        void l(int i5);

        void m(g gVar);

        void n(String str);

        boolean o();
    }

    /* loaded from: classes.dex */
    public enum i {
        CLICK("SystemSoundType.click"),
        ALERT("SystemSoundType.alert");
        

        /* renamed from: a  reason: collision with root package name */
        private final String f8670a;

        i(String str) {
            this.f8670a = str;
        }

        static i c(String str) {
            i[] values;
            for (i iVar : values()) {
                if (iVar.f8670a.equals(str)) {
                    return iVar;
                }
            }
            throw new NoSuchFieldException("No such SoundType: " + str);
        }
    }

    /* loaded from: classes.dex */
    public static class j {

        /* renamed from: a  reason: collision with root package name */
        public final Integer f8671a;

        /* renamed from: b  reason: collision with root package name */
        public final d f8672b;

        /* renamed from: c  reason: collision with root package name */
        public final Boolean f8673c;

        /* renamed from: d  reason: collision with root package name */
        public final Integer f8674d;

        /* renamed from: e  reason: collision with root package name */
        public final d f8675e;

        /* renamed from: f  reason: collision with root package name */
        public final Integer f8676f;

        /* renamed from: g  reason: collision with root package name */
        public final Boolean f8677g;

        public j(Integer num, d dVar, Boolean bool, Integer num2, d dVar2, Integer num3, Boolean bool2) {
            this.f8671a = num;
            this.f8672b = dVar;
            this.f8673c = bool;
            this.f8674d = num2;
            this.f8675e = dVar2;
            this.f8676f = num3;
            this.f8677g = bool2;
        }
    }

    /* renamed from: y2.k$k  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public enum EnumC0132k {
        LEAN_BACK("SystemUiMode.leanBack"),
        IMMERSIVE("SystemUiMode.immersive"),
        IMMERSIVE_STICKY("SystemUiMode.immersiveSticky"),
        EDGE_TO_EDGE("SystemUiMode.edgeToEdge");
        

        /* renamed from: a  reason: collision with root package name */
        private String f8683a;

        EnumC0132k(String str) {
            this.f8683a = str;
        }

        static EnumC0132k c(String str) {
            EnumC0132k[] values;
            for (EnumC0132k enumC0132k : values()) {
                if (enumC0132k.f8683a.equals(str)) {
                    return enumC0132k;
                }
            }
            throw new NoSuchFieldException("No such SystemUiMode: " + str);
        }
    }

    /* loaded from: classes.dex */
    public enum l {
        TOP_OVERLAYS("SystemUiOverlay.top"),
        BOTTOM_OVERLAYS("SystemUiOverlay.bottom");
        

        /* renamed from: a  reason: collision with root package name */
        private String f8687a;

        l(String str) {
            this.f8687a = str;
        }

        static l c(String str) {
            l[] values;
            for (l lVar : values()) {
                if (lVar.f8687a.equals(str)) {
                    return lVar;
                }
            }
            throw new NoSuchFieldException("No such SystemUiOverlay: " + str);
        }
    }

    public k(o2.a aVar) {
        a aVar2 = new a();
        this.f8640c = aVar2;
        z2.j jVar = new z2.j(aVar, "flutter/platform", z2.f.f9002a);
        this.f8638a = jVar;
        jVar.e(aVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c g(JSONObject jSONObject) {
        int i5 = jSONObject.getInt("primaryColor");
        if (i5 != 0) {
            i5 |= -16777216;
        }
        return new c(i5, jSONObject.getString("label"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0053 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int h(org.json.JSONArray r10) {
        /*
            r9 = this;
            r0 = 0
            r1 = 0
            r2 = 0
            r3 = 0
        L4:
            int r4 = r10.length()
            r5 = 4
            r6 = 2
            r7 = 1
            if (r1 >= r4) goto L38
            java.lang.String r4 = r10.getString(r1)
            y2.k$f r4 = y2.k.f.c(r4)
            int[] r8 = y2.k.b.f8642a
            int r4 = r4.ordinal()
            r4 = r8[r4]
            if (r4 == r7) goto L30
            if (r4 == r6) goto L2d
            r6 = 3
            if (r4 == r6) goto L2a
            if (r4 == r5) goto L27
            goto L32
        L27:
            r2 = r2 | 8
            goto L32
        L2a:
            r2 = r2 | 2
            goto L32
        L2d:
            r2 = r2 | 4
            goto L32
        L30:
            r2 = r2 | 1
        L32:
            if (r3 != 0) goto L35
            r3 = r2
        L35:
            int r1 = r1 + 1
            goto L4
        L38:
            if (r2 == 0) goto L57
            r10 = 9
            r1 = 8
            switch(r2) {
                case 2: goto L56;
                case 3: goto L4d;
                case 4: goto L4c;
                case 5: goto L4a;
                case 6: goto L4d;
                case 7: goto L4d;
                case 8: goto L49;
                case 9: goto L4d;
                case 10: goto L46;
                case 11: goto L45;
                case 12: goto L4d;
                case 13: goto L4d;
                case 14: goto L4d;
                case 15: goto L42;
                default: goto L41;
            }
        L41:
            goto L53
        L42:
            r10 = 13
            return r10
        L45:
            return r6
        L46:
            r10 = 11
            return r10
        L49:
            return r1
        L4a:
            r10 = 12
        L4c:
            return r10
        L4d:
            if (r3 == r6) goto L56
            if (r3 == r5) goto L55
            if (r3 == r1) goto L54
        L53:
            return r7
        L54:
            return r1
        L55:
            return r10
        L56:
            return r0
        L57:
            r10 = -1
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.k.h(org.json.JSONArray):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public j i(JSONObject jSONObject) {
        return new j(!jSONObject.isNull("statusBarColor") ? Integer.valueOf(jSONObject.getInt("statusBarColor")) : null, !jSONObject.isNull("statusBarIconBrightness") ? d.c(jSONObject.getString("statusBarIconBrightness")) : null, !jSONObject.isNull("systemStatusBarContrastEnforced") ? Boolean.valueOf(jSONObject.getBoolean("systemStatusBarContrastEnforced")) : null, !jSONObject.isNull("systemNavigationBarColor") ? Integer.valueOf(jSONObject.getInt("systemNavigationBarColor")) : null, !jSONObject.isNull("systemNavigationBarIconBrightness") ? d.c(jSONObject.getString("systemNavigationBarIconBrightness")) : null, !jSONObject.isNull("systemNavigationBarDividerColor") ? Integer.valueOf(jSONObject.getInt("systemNavigationBarDividerColor")) : null, jSONObject.isNull("systemNavigationBarContrastEnforced") ? null : Boolean.valueOf(jSONObject.getBoolean("systemNavigationBarContrastEnforced")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EnumC0132k j(String str) {
        int i5 = b.f8644c[EnumC0132k.c(str).ordinal()];
        return i5 != 1 ? i5 != 2 ? i5 != 3 ? i5 != 4 ? EnumC0132k.EDGE_TO_EDGE : EnumC0132k.EDGE_TO_EDGE : EnumC0132k.IMMERSIVE_STICKY : EnumC0132k.IMMERSIVE : EnumC0132k.LEAN_BACK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<l> k(JSONArray jSONArray) {
        l lVar;
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < jSONArray.length(); i5++) {
            int i6 = b.f8643b[l.c(jSONArray.getString(i5)).ordinal()];
            if (i6 == 1) {
                lVar = l.TOP_OVERLAYS;
            } else if (i6 == 2) {
                lVar = l.BOTTOM_OVERLAYS;
            }
            arrayList.add(lVar);
        }
        return arrayList;
    }

    public void l(h hVar) {
        this.f8639b = hVar;
    }

    public void m(boolean z4) {
        n2.b.f("PlatformChannel", "Sending 'systemUIChange' message.");
        this.f8638a.c("SystemChrome.systemUIChange", Arrays.asList(Boolean.valueOf(z4)));
    }
}
