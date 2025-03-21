package com.google.protobuf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    static final Class<?> f2090a = c();

    public static q a() {
        q b5 = b("getEmptyRegistry");
        return b5 != null ? b5 : q.f2100d;
    }

    private static final q b(String str) {
        Class<?> cls = f2090a;
        if (cls == null) {
            return null;
        }
        try {
            return (q) cls.getDeclaredMethod(str, new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static Class<?> c() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
