package com.google.firebase.firestore;
/* loaded from: classes.dex */
public final class h1 {

    /* renamed from: b  reason: collision with root package name */
    static final h1 f1708b = new b().a();

    /* renamed from: a  reason: collision with root package name */
    private final int f1709a;

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private int f1710a = 5;

        public h1 a() {
            return new h1(this.f1710a);
        }

        public b b(int i5) {
            if (i5 >= 1) {
                this.f1710a = i5;
                return this;
            }
            throw new IllegalArgumentException("Max attempts must be at least 1");
        }
    }

    private h1(int i5) {
        this.f1709a = i5;
    }

    public int a() {
        return this.f1709a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && h1.class == obj.getClass() && this.f1709a == ((h1) obj).f1709a;
    }

    public int hashCode() {
        return this.f1709a;
    }

    public String toString() {
        return "TransactionOptions{maxAttempts=" + this.f1709a + '}';
    }
}
