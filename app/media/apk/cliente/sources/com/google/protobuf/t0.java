package com.google.protobuf;
/* loaded from: classes.dex */
final class t0 {

    /* renamed from: a  reason: collision with root package name */
    private static final r0 f2139a = c();

    /* renamed from: b  reason: collision with root package name */
    private static final r0 f2140b = new s0();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static r0 a() {
        return f2139a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static r0 b() {
        return f2140b;
    }

    private static r0 c() {
        try {
            return (r0) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
