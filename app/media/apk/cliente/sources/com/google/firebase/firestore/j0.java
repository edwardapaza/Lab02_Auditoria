package com.google.firebase.firestore;
/* loaded from: classes.dex */
public final class j0 {

    /* renamed from: g  reason: collision with root package name */
    static final j0 f1720g = new j0(0, 0, 0, 0, null, a.SUCCESS);

    /* renamed from: a  reason: collision with root package name */
    private final int f1721a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1722b;

    /* renamed from: c  reason: collision with root package name */
    private final long f1723c;

    /* renamed from: d  reason: collision with root package name */
    private final long f1724d;

    /* renamed from: e  reason: collision with root package name */
    private final a f1725e;

    /* renamed from: f  reason: collision with root package name */
    private final Exception f1726f;

    /* loaded from: classes.dex */
    public enum a {
        ERROR,
        RUNNING,
        SUCCESS
    }

    public j0(int i5, int i6, long j5, long j6, Exception exc, a aVar) {
        this.f1721a = i5;
        this.f1722b = i6;
        this.f1723c = j5;
        this.f1724d = j6;
        this.f1725e = aVar;
        this.f1726f = exc;
    }

    public static j0 a(r1.e eVar) {
        return new j0(0, eVar.e(), 0L, eVar.d(), null, a.RUNNING);
    }

    public static j0 b(r1.e eVar) {
        return new j0(eVar.e(), eVar.e(), eVar.d(), eVar.d(), null, a.SUCCESS);
    }

    public long c() {
        return this.f1723c;
    }

    public int d() {
        return this.f1721a;
    }

    public a e() {
        return this.f1725e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j0.class != obj.getClass()) {
            return false;
        }
        j0 j0Var = (j0) obj;
        if (this.f1721a == j0Var.f1721a && this.f1722b == j0Var.f1722b && this.f1723c == j0Var.f1723c && this.f1724d == j0Var.f1724d && this.f1725e == j0Var.f1725e) {
            Exception exc = this.f1726f;
            Exception exc2 = j0Var.f1726f;
            return exc != null ? exc.equals(exc2) : exc2 == null;
        }
        return false;
    }

    public long f() {
        return this.f1724d;
    }

    public int g() {
        return this.f1722b;
    }

    public int hashCode() {
        long j5 = this.f1723c;
        long j6 = this.f1724d;
        int hashCode = ((((((((this.f1721a * 31) + this.f1722b) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31) + ((int) (j6 ^ (j6 >>> 32)))) * 31) + this.f1725e.hashCode()) * 31;
        Exception exc = this.f1726f;
        return hashCode + (exc != null ? exc.hashCode() : 0);
    }
}
