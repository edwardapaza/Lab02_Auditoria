package w4;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    final byte[] f8301a;

    /* renamed from: b  reason: collision with root package name */
    int f8302b;

    /* renamed from: c  reason: collision with root package name */
    int f8303c;

    /* renamed from: d  reason: collision with root package name */
    boolean f8304d;

    /* renamed from: e  reason: collision with root package name */
    boolean f8305e;

    /* renamed from: f  reason: collision with root package name */
    j f8306f;

    /* renamed from: g  reason: collision with root package name */
    j f8307g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j() {
        this.f8301a = new byte[8192];
        this.f8305e = true;
        this.f8304d = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(byte[] bArr, int i5, int i6, boolean z4, boolean z5) {
        this.f8301a = bArr;
        this.f8302b = i5;
        this.f8303c = i6;
        this.f8304d = z4;
        this.f8305e = z5;
    }

    public final void a() {
        j jVar = this.f8307g;
        if (jVar == this) {
            throw new IllegalStateException();
        }
        if (jVar.f8305e) {
            int i5 = this.f8303c - this.f8302b;
            if (i5 > (8192 - jVar.f8303c) + (jVar.f8304d ? 0 : jVar.f8302b)) {
                return;
            }
            f(jVar, i5);
            b();
            k.a(this);
        }
    }

    public final j b() {
        j jVar = this.f8306f;
        j jVar2 = jVar != this ? jVar : null;
        j jVar3 = this.f8307g;
        jVar3.f8306f = jVar;
        this.f8306f.f8307g = jVar3;
        this.f8306f = null;
        this.f8307g = null;
        return jVar2;
    }

    public final j c(j jVar) {
        jVar.f8307g = this;
        jVar.f8306f = this.f8306f;
        this.f8306f.f8307g = jVar;
        this.f8306f = jVar;
        return jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final j d() {
        this.f8304d = true;
        return new j(this.f8301a, this.f8302b, this.f8303c, true, false);
    }

    public final j e(int i5) {
        j b5;
        if (i5 <= 0 || i5 > this.f8303c - this.f8302b) {
            throw new IllegalArgumentException();
        }
        if (i5 >= 1024) {
            b5 = d();
        } else {
            b5 = k.b();
            System.arraycopy(this.f8301a, this.f8302b, b5.f8301a, 0, i5);
        }
        b5.f8303c = b5.f8302b + i5;
        this.f8302b += i5;
        this.f8307g.c(b5);
        return b5;
    }

    public final void f(j jVar, int i5) {
        if (!jVar.f8305e) {
            throw new IllegalArgumentException();
        }
        int i6 = jVar.f8303c;
        if (i6 + i5 > 8192) {
            if (jVar.f8304d) {
                throw new IllegalArgumentException();
            }
            int i7 = jVar.f8302b;
            if ((i6 + i5) - i7 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = jVar.f8301a;
            System.arraycopy(bArr, i7, bArr, 0, i6 - i7);
            jVar.f8303c -= jVar.f8302b;
            jVar.f8302b = 0;
        }
        System.arraycopy(this.f8301a, this.f8302b, jVar.f8301a, jVar.f8303c, i5);
        jVar.f8303c += i5;
        this.f8302b += i5;
    }
}
