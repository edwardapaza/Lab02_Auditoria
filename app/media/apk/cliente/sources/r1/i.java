package r1;

import s1.a1;
import s1.f1;
/* loaded from: classes.dex */
public class i implements c {

    /* renamed from: a  reason: collision with root package name */
    private final f1 f7155a;

    /* renamed from: b  reason: collision with root package name */
    private final a1.a f7156b;

    public i(f1 f1Var, a1.a aVar) {
        this.f7155a = f1Var;
        this.f7156b = aVar;
    }

    public a1.a a() {
        return this.f7156b;
    }

    public f1 b() {
        return this.f7155a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return this.f7155a.equals(iVar.f7155a) && this.f7156b == iVar.f7156b;
    }

    public int hashCode() {
        return (this.f7155a.hashCode() * 31) + this.f7156b.hashCode();
    }
}
