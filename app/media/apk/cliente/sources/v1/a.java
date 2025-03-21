package v1;

import java.util.List;
import v1.q;
/* loaded from: classes.dex */
final class a extends q {

    /* renamed from: c  reason: collision with root package name */
    private final int f8103c;

    /* renamed from: d  reason: collision with root package name */
    private final String f8104d;

    /* renamed from: e  reason: collision with root package name */
    private final List<q.c> f8105e;

    /* renamed from: f  reason: collision with root package name */
    private final q.b f8106f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i5, String str, List<q.c> list, q.b bVar) {
        this.f8103c = i5;
        if (str == null) {
            throw new NullPointerException("Null collectionGroup");
        }
        this.f8104d = str;
        if (list == null) {
            throw new NullPointerException("Null segments");
        }
        this.f8105e = list;
        if (bVar == null) {
            throw new NullPointerException("Null indexState");
        }
        this.f8106f = bVar;
    }

    @Override // v1.q
    public String d() {
        return this.f8104d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof q) {
            q qVar = (q) obj;
            return this.f8103c == qVar.f() && this.f8104d.equals(qVar.d()) && this.f8105e.equals(qVar.h()) && this.f8106f.equals(qVar.g());
        }
        return false;
    }

    @Override // v1.q
    public int f() {
        return this.f8103c;
    }

    @Override // v1.q
    public q.b g() {
        return this.f8106f;
    }

    @Override // v1.q
    public List<q.c> h() {
        return this.f8105e;
    }

    public int hashCode() {
        return ((((((this.f8103c ^ 1000003) * 1000003) ^ this.f8104d.hashCode()) * 1000003) ^ this.f8105e.hashCode()) * 1000003) ^ this.f8106f.hashCode();
    }

    public String toString() {
        return "FieldIndex{indexId=" + this.f8103c + ", collectionGroup=" + this.f8104d + ", segments=" + this.f8105e + ", indexState=" + this.f8106f + "}";
    }
}
