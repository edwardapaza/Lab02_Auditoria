package r1;

import java.util.List;
import v1.l;
import v1.w;
/* loaded from: classes.dex */
public class h implements c {

    /* renamed from: a  reason: collision with root package name */
    private final l f7151a;

    /* renamed from: b  reason: collision with root package name */
    private final w f7152b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f7153c;

    /* renamed from: d  reason: collision with root package name */
    private final List<String> f7154d;

    public h(l lVar, w wVar, boolean z4, List<String> list) {
        this.f7151a = lVar;
        this.f7152b = wVar;
        this.f7153c = z4;
        this.f7154d = list;
    }

    public boolean a() {
        return this.f7153c;
    }

    public l b() {
        return this.f7151a;
    }

    public List<String> c() {
        return this.f7154d;
    }

    public w d() {
        return this.f7152b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        if (this.f7153c == hVar.f7153c && this.f7151a.equals(hVar.f7151a) && this.f7152b.equals(hVar.f7152b)) {
            return this.f7154d.equals(hVar.f7154d);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f7151a.hashCode() * 31) + this.f7152b.hashCode()) * 31) + (this.f7153c ? 1 : 0)) * 31) + this.f7154d.hashCode();
    }
}
