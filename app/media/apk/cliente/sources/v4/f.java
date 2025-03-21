package v4;

import java.util.concurrent.atomic.AtomicReferenceArray;
import r4.e0;
import r4.h0;
import v3.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f extends e0<f> {

    /* renamed from: e  reason: collision with root package name */
    private final AtomicReferenceArray f8206e;

    public f(long j5, f fVar, int i5) {
        super(j5, fVar, i5);
        int i6;
        i6 = e.f8205f;
        this.f8206e = new AtomicReferenceArray(i6);
    }

    @Override // r4.e0
    public int n() {
        int i5;
        i5 = e.f8205f;
        return i5;
    }

    @Override // r4.e0
    public void o(int i5, Throwable th, g gVar) {
        h0 h0Var;
        h0Var = e.f8204e;
        r().set(i5, h0Var);
        p();
    }

    public final AtomicReferenceArray r() {
        return this.f8206e;
    }

    public String toString() {
        return "SemaphoreSegment[id=" + this.f7187c + ", hashCode=" + hashCode() + ']';
    }
}
