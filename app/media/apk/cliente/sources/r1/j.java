package r1;

import v1.w;
/* loaded from: classes.dex */
public class j implements c {

    /* renamed from: a  reason: collision with root package name */
    private final String f7157a;

    /* renamed from: b  reason: collision with root package name */
    private final i f7158b;

    /* renamed from: c  reason: collision with root package name */
    private final w f7159c;

    public j(String str, i iVar, w wVar) {
        this.f7157a = str;
        this.f7158b = iVar;
        this.f7159c = wVar;
    }

    public i a() {
        return this.f7158b;
    }

    public String b() {
        return this.f7157a;
    }

    public w c() {
        return this.f7159c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        if (this.f7157a.equals(jVar.f7157a) && this.f7158b.equals(jVar.f7158b)) {
            return this.f7159c.equals(jVar.f7159c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f7157a.hashCode() * 31) + this.f7158b.hashCode()) * 31) + this.f7159c.hashCode();
    }
}
