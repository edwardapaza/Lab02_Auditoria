package com.google.protobuf;
/* loaded from: classes.dex */
final class d1 {

    /* renamed from: a  reason: collision with root package name */
    private static final b1 f1916a = c();

    /* renamed from: b  reason: collision with root package name */
    private static final b1 f1917b = new c1();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b1 a() {
        return f1916a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b1 b() {
        return f1917b;
    }

    private static b1 c() {
        try {
            return (b1) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
