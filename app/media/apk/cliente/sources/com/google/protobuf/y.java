package com.google.protobuf;
/* loaded from: classes.dex */
class y implements v0 {

    /* renamed from: a  reason: collision with root package name */
    private static final y f2200a = new y();

    private y() {
    }

    public static y c() {
        return f2200a;
    }

    @Override // com.google.protobuf.v0
    public u0 a(Class<?> cls) {
        if (!z.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: " + cls.getName());
        }
        try {
            return (u0) z.H(cls.asSubclass(z.class)).u();
        } catch (Exception e5) {
            throw new RuntimeException("Unable to get message info for " + cls.getName(), e5);
        }
    }

    @Override // com.google.protobuf.v0
    public boolean b(Class<?> cls) {
        return z.class.isAssignableFrom(cls);
    }
}
