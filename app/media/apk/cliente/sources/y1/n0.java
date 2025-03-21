package y1;

import java.util.Map;
import java.util.Set;
import u1.h1;
/* loaded from: classes.dex */
public final class n0 {

    /* renamed from: a  reason: collision with root package name */
    private final v1.w f8449a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<Integer, v0> f8450b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<Integer, h1> f8451c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<v1.l, v1.s> f8452d;

    /* renamed from: e  reason: collision with root package name */
    private final Set<v1.l> f8453e;

    public n0(v1.w wVar, Map<Integer, v0> map, Map<Integer, h1> map2, Map<v1.l, v1.s> map3, Set<v1.l> set) {
        this.f8449a = wVar;
        this.f8450b = map;
        this.f8451c = map2;
        this.f8452d = map3;
        this.f8453e = set;
    }

    public Map<v1.l, v1.s> a() {
        return this.f8452d;
    }

    public Set<v1.l> b() {
        return this.f8453e;
    }

    public v1.w c() {
        return this.f8449a;
    }

    public Map<Integer, v0> d() {
        return this.f8450b;
    }

    public Map<Integer, h1> e() {
        return this.f8451c;
    }

    public String toString() {
        return "RemoteEvent{snapshotVersion=" + this.f8449a + ", targetChanges=" + this.f8450b + ", targetMismatches=" + this.f8451c + ", documentUpdates=" + this.f8452d + ", resolvedLimboDocuments=" + this.f8453e + '}';
    }
}
