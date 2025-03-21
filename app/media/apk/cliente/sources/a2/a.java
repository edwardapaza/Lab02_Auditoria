package a2;

import java.util.List;
/* loaded from: classes.dex */
final class a extends m {

    /* renamed from: a  reason: collision with root package name */
    private final String f64a;

    /* renamed from: b  reason: collision with root package name */
    private final List<String> f65b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(String str, List<String> list) {
        if (str == null) {
            throw new NullPointerException("Null userAgent");
        }
        this.f64a = str;
        if (list == null) {
            throw new NullPointerException("Null usedDates");
        }
        this.f65b = list;
    }

    @Override // a2.m
    public List<String> b() {
        return this.f65b;
    }

    @Override // a2.m
    public String c() {
        return this.f64a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof m) {
            m mVar = (m) obj;
            return this.f64a.equals(mVar.c()) && this.f65b.equals(mVar.b());
        }
        return false;
    }

    public int hashCode() {
        return ((this.f64a.hashCode() ^ 1000003) * 1000003) ^ this.f65b.hashCode();
    }

    public String toString() {
        return "HeartBeatResult{userAgent=" + this.f64a + ", usedDates=" + this.f65b + "}";
    }
}
