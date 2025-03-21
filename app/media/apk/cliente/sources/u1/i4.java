package u1;

import java.util.Objects;
/* loaded from: classes.dex */
public final class i4 {

    /* renamed from: a  reason: collision with root package name */
    private final s1.f1 f7877a;

    /* renamed from: b  reason: collision with root package name */
    private final int f7878b;

    /* renamed from: c  reason: collision with root package name */
    private final long f7879c;

    /* renamed from: d  reason: collision with root package name */
    private final h1 f7880d;

    /* renamed from: e  reason: collision with root package name */
    private final v1.w f7881e;

    /* renamed from: f  reason: collision with root package name */
    private final v1.w f7882f;

    /* renamed from: g  reason: collision with root package name */
    private final com.google.protobuf.i f7883g;

    /* renamed from: h  reason: collision with root package name */
    private final Integer f7884h;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public i4(s1.f1 r11, int r12, long r13, u1.h1 r15) {
        /*
            r10 = this;
            v1.w r7 = v1.w.f8154b
            com.google.protobuf.i r8 = y1.a1.f8355t
            r9 = 0
            r0 = r10
            r1 = r11
            r2 = r12
            r3 = r13
            r5 = r15
            r6 = r7
            r0.<init>(r1, r2, r3, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: u1.i4.<init>(s1.f1, int, long, u1.h1):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i4(s1.f1 f1Var, int i5, long j5, h1 h1Var, v1.w wVar, v1.w wVar2, com.google.protobuf.i iVar, Integer num) {
        this.f7877a = (s1.f1) z1.y.b(f1Var);
        this.f7878b = i5;
        this.f7879c = j5;
        this.f7882f = wVar2;
        this.f7880d = h1Var;
        this.f7881e = (v1.w) z1.y.b(wVar);
        this.f7883g = (com.google.protobuf.i) z1.y.b(iVar);
        this.f7884h = num;
    }

    public Integer a() {
        return this.f7884h;
    }

    public v1.w b() {
        return this.f7882f;
    }

    public h1 c() {
        return this.f7880d;
    }

    public com.google.protobuf.i d() {
        return this.f7883g;
    }

    public long e() {
        return this.f7879c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i4.class != obj.getClass()) {
            return false;
        }
        i4 i4Var = (i4) obj;
        return this.f7877a.equals(i4Var.f7877a) && this.f7878b == i4Var.f7878b && this.f7879c == i4Var.f7879c && this.f7880d.equals(i4Var.f7880d) && this.f7881e.equals(i4Var.f7881e) && this.f7882f.equals(i4Var.f7882f) && this.f7883g.equals(i4Var.f7883g) && Objects.equals(this.f7884h, i4Var.f7884h);
    }

    public v1.w f() {
        return this.f7881e;
    }

    public s1.f1 g() {
        return this.f7877a;
    }

    public int h() {
        return this.f7878b;
    }

    public int hashCode() {
        return (((((((((((((this.f7877a.hashCode() * 31) + this.f7878b) * 31) + ((int) this.f7879c)) * 31) + this.f7880d.hashCode()) * 31) + this.f7881e.hashCode()) * 31) + this.f7882f.hashCode()) * 31) + this.f7883g.hashCode()) * 31) + Objects.hashCode(this.f7884h);
    }

    public i4 i(Integer num) {
        return new i4(this.f7877a, this.f7878b, this.f7879c, this.f7880d, this.f7881e, this.f7882f, this.f7883g, num);
    }

    public i4 j(v1.w wVar) {
        return new i4(this.f7877a, this.f7878b, this.f7879c, this.f7880d, this.f7881e, wVar, this.f7883g, this.f7884h);
    }

    public i4 k(com.google.protobuf.i iVar, v1.w wVar) {
        return new i4(this.f7877a, this.f7878b, this.f7879c, this.f7880d, wVar, this.f7882f, iVar, null);
    }

    public i4 l(long j5) {
        return new i4(this.f7877a, this.f7878b, j5, this.f7880d, this.f7881e, this.f7882f, this.f7883g, this.f7884h);
    }

    public String toString() {
        return "TargetData{target=" + this.f7877a + ", targetId=" + this.f7878b + ", sequenceNumber=" + this.f7879c + ", purpose=" + this.f7880d + ", snapshotVersion=" + this.f7881e + ", lastLimboFreeSnapshotVersion=" + this.f7882f + ", resumeToken=" + this.f7883g + ", expectedCount=" + this.f7884h + '}';
    }
}
