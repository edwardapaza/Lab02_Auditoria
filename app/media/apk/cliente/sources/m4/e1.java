package m4;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e1 implements p1 {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f6220a;

    public e1(boolean z4) {
        this.f6220a = z4;
    }

    @Override // m4.p1
    public boolean c() {
        return this.f6220a;
    }

    @Override // m4.p1
    public g2 f() {
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        sb.append(c() ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}
