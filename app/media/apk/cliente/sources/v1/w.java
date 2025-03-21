package v1;
/* loaded from: classes.dex */
public final class w implements Comparable<w> {

    /* renamed from: b  reason: collision with root package name */
    public static final w f8154b = new w(new f1.q(0, 0));

    /* renamed from: a  reason: collision with root package name */
    private final f1.q f8155a;

    public w(f1.q qVar) {
        this.f8155a = qVar;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(w wVar) {
        return this.f8155a.compareTo(wVar.f8155a);
    }

    public f1.q c() {
        return this.f8155a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof w) && compareTo((w) obj) == 0;
    }

    public int hashCode() {
        return c().hashCode();
    }

    public String toString() {
        return "SnapshotVersion(seconds=" + this.f8155a.n() + ", nanos=" + this.f8155a.h() + ")";
    }
}
