package r4;

import m4.b1;
import m4.f2;
import m4.s0;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class y extends f2 implements s0 {

    /* renamed from: c  reason: collision with root package name */
    private final Throwable f7246c;

    /* renamed from: d  reason: collision with root package name */
    private final String f7247d;

    public y(Throwable th, String str) {
        this.f7246c = th;
        this.f7247d = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0023, code lost:
        if (r1 == null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Void l0() {
        /*
            r4 = this;
            java.lang.Throwable r0 = r4.f7246c
            if (r0 == 0) goto L36
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Module with the Main dispatcher had failed to initialize"
            r0.append(r1)
            java.lang.String r1 = r4.f7247d
            if (r1 == 0) goto L25
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = ". "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            if (r1 != 0) goto L27
        L25:
            java.lang.String r1 = ""
        L27:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.Throwable r2 = r4.f7246c
            r1.<init>(r0, r2)
            throw r1
        L36:
            r4.x.d()
            s3.d r0 = new s3.d
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: r4.y.l0():java.lang.Void");
    }

    @Override // m4.g0
    public boolean g0(v3.g gVar) {
        l0();
        throw new s3.d();
    }

    @Override // m4.f2
    public f2 i0() {
        return this;
    }

    @Override // m4.g0
    /* renamed from: k0 */
    public Void f0(v3.g gVar, Runnable runnable) {
        l0();
        throw new s3.d();
    }

    @Override // m4.s0
    public b1 l(long j5, Runnable runnable, v3.g gVar) {
        l0();
        throw new s3.d();
    }

    @Override // m4.f2, m4.g0
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Dispatchers.Main[missing");
        if (this.f7246c != null) {
            str = ", cause=" + this.f7246c;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(']');
        return sb.toString();
    }
}
