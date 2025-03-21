package s1;

import java.util.List;
/* loaded from: classes.dex */
public class r1 {

    /* renamed from: a  reason: collision with root package name */
    private final v1.t f7472a;

    /* renamed from: b  reason: collision with root package name */
    private final w1.d f7473b;

    /* renamed from: c  reason: collision with root package name */
    private final List<w1.e> f7474c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r1(v1.t tVar, w1.d dVar, List<w1.e> list) {
        this.f7472a = tVar;
        this.f7473b = dVar;
        this.f7474c = list;
    }

    public w1.f a(v1.l lVar, w1.m mVar) {
        w1.d dVar = this.f7473b;
        return dVar != null ? new w1.l(lVar, this.f7472a, dVar, mVar, this.f7474c) : new w1.o(lVar, this.f7472a, mVar, this.f7474c);
    }
}
