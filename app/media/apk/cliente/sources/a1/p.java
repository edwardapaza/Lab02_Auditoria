package a1;

import java.util.Map;
/* loaded from: classes.dex */
public final class p {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes.dex */
    private static abstract class a implements z0.d<Map.Entry<?, ?>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f36a = new C0003a("KEY", 0);

        /* renamed from: b  reason: collision with root package name */
        public static final a f37b = new b("VALUE", 1);

        /* renamed from: c  reason: collision with root package name */
        private static final /* synthetic */ a[] f38c = a();

        /* renamed from: a1.p$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        enum C0003a extends a {
            C0003a(String str, int i5) {
                super(str, i5, null);
            }

            @Override // z0.d
            /* renamed from: c */
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getKey();
            }
        }

        /* loaded from: classes.dex */
        enum b extends a {
            b(String str, int i5) {
                super(str, i5, null);
            }

            @Override // z0.d
            /* renamed from: c */
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getValue();
            }
        }

        private a(String str, int i5) {
        }

        /* synthetic */ a(String str, int i5, o oVar) {
            this(str, i5);
        }

        private static /* synthetic */ a[] a() {
            return new a[]{f36a, f37b};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f38c.clone();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Map<?, ?> map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(Map<?, ?> map) {
        StringBuilder a5 = d.a(map.size());
        a5.append('{');
        boolean z4 = true;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (!z4) {
                a5.append(", ");
            }
            z4 = false;
            a5.append(entry.getKey());
            a5.append('=');
            a5.append(entry.getValue());
        }
        a5.append('}');
        return a5.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <V> z0.d<Map.Entry<?, V>, V> c() {
        return a.f37b;
    }
}
