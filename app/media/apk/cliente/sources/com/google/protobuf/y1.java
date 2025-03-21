package com.google.protobuf;
/* loaded from: classes.dex */
class y1 extends w1<x1, x1> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.w1
    /* renamed from: A */
    public x1 g(Object obj) {
        return ((z) obj).unknownFields;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.w1
    /* renamed from: B */
    public int h(x1 x1Var) {
        return x1Var.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.w1
    /* renamed from: C */
    public int i(x1 x1Var) {
        return x1Var.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.w1
    /* renamed from: D */
    public x1 k(x1 x1Var, x1 x1Var2) {
        return x1.c().equals(x1Var2) ? x1Var : x1.c().equals(x1Var) ? x1.j(x1Var, x1Var2) : x1Var.i(x1Var2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.w1
    /* renamed from: E */
    public x1 n() {
        return x1.k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.w1
    /* renamed from: F */
    public void o(Object obj, x1 x1Var) {
        p(obj, x1Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.w1
    /* renamed from: G */
    public void p(Object obj, x1 x1Var) {
        ((z) obj).unknownFields = x1Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.w1
    /* renamed from: H */
    public x1 r(x1 x1Var) {
        x1Var.h();
        return x1Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.w1
    /* renamed from: I */
    public void s(x1 x1Var, d2 d2Var) {
        x1Var.p(d2Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.w1
    /* renamed from: J */
    public void t(x1 x1Var, d2 d2Var) {
        x1Var.r(d2Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.w1
    public void j(Object obj) {
        g(obj).h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.w1
    public boolean q(m1 m1Var) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.w1
    /* renamed from: u */
    public void a(x1 x1Var, int i5, int i6) {
        x1Var.n(c2.c(i5, 5), Integer.valueOf(i6));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.w1
    /* renamed from: v */
    public void b(x1 x1Var, int i5, long j5) {
        x1Var.n(c2.c(i5, 1), Long.valueOf(j5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.w1
    /* renamed from: w */
    public void c(x1 x1Var, int i5, x1 x1Var2) {
        x1Var.n(c2.c(i5, 3), x1Var2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.w1
    /* renamed from: x */
    public void d(x1 x1Var, int i5, i iVar) {
        x1Var.n(c2.c(i5, 2), iVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.w1
    /* renamed from: y */
    public void e(x1 x1Var, int i5, long j5) {
        x1Var.n(c2.c(i5, 0), Long.valueOf(j5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.w1
    /* renamed from: z */
    public x1 f(Object obj) {
        x1 g5 = g(obj);
        if (g5 == x1.c()) {
            x1 k5 = x1.k();
            p(obj, k5);
            return k5;
        }
        return g5;
    }
}
