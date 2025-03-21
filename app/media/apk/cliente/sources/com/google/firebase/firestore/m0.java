package com.google.firebase.firestore;
/* loaded from: classes.dex */
public final class m0 implements n0 {

    /* loaded from: classes.dex */
    public static class b {
        private b() {
        }

        public m0 a() {
            return new m0();
        }
    }

    private m0() {
    }

    public static b a() {
        return new b();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && m0.class == obj.getClass();
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return "MemoryEagerGcSettings{}";
    }
}
