package com.google.firebase.firestore;
/* loaded from: classes.dex */
public class f implements Comparable<f> {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.protobuf.i f1690a;

    private f(com.google.protobuf.i iVar) {
        this.f1690a = iVar;
    }

    public static f c(com.google.protobuf.i iVar) {
        z1.y.c(iVar, "Provided ByteString must not be null.");
        return new f(iVar);
    }

    public static f d(byte[] bArr) {
        z1.y.c(bArr, "Provided bytes array must not be null.");
        return new f(com.google.protobuf.i.p(bArr));
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        return z1.h0.j(this.f1690a, fVar.f1690a);
    }

    public com.google.protobuf.i e() {
        return this.f1690a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && this.f1690a.equals(((f) obj).f1690a);
    }

    public byte[] h() {
        return this.f1690a.G();
    }

    public int hashCode() {
        return this.f1690a.hashCode();
    }

    public String toString() {
        return "Blob { bytes=" + z1.h0.A(this.f1690a) + " }";
    }
}
