package com.google.protobuf;
/* loaded from: classes.dex */
final class d {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f1907a;

    /* renamed from: b  reason: collision with root package name */
    private static final Class<?> f1908b = a("libcore.io.Memory");

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f1909c;

    static {
        f1909c = (f1907a || a("org.robolectric.Robolectric") == null) ? false : true;
    }

    private static <T> Class<T> a(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class<?> b() {
        return f1908b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c() {
        return f1907a || !(f1908b == null || f1909c);
    }
}
