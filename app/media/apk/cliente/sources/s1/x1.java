package s1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import s1.m;
/* loaded from: classes.dex */
public class x1 {

    /* renamed from: a  reason: collision with root package name */
    private final a1 f7522a;

    /* renamed from: b  reason: collision with root package name */
    private final v1.n f7523b;

    /* renamed from: c  reason: collision with root package name */
    private final v1.n f7524c;

    /* renamed from: d  reason: collision with root package name */
    private final List<m> f7525d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f7526e;

    /* renamed from: f  reason: collision with root package name */
    private final m1.e<v1.l> f7527f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f7528g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f7529h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f7530i;

    /* loaded from: classes.dex */
    public enum a {
        NONE,
        LOCAL,
        SYNCED
    }

    public x1(a1 a1Var, v1.n nVar, v1.n nVar2, List<m> list, boolean z4, m1.e<v1.l> eVar, boolean z5, boolean z6, boolean z7) {
        this.f7522a = a1Var;
        this.f7523b = nVar;
        this.f7524c = nVar2;
        this.f7525d = list;
        this.f7526e = z4;
        this.f7527f = eVar;
        this.f7528g = z5;
        this.f7529h = z6;
        this.f7530i = z7;
    }

    public static x1 c(a1 a1Var, v1.n nVar, m1.e<v1.l> eVar, boolean z4, boolean z5, boolean z6) {
        ArrayList arrayList = new ArrayList();
        Iterator<v1.i> it = nVar.iterator();
        while (it.hasNext()) {
            arrayList.add(m.a(m.a.ADDED, it.next()));
        }
        return new x1(a1Var, nVar, v1.n.i(a1Var.c()), arrayList, z4, eVar, true, z5, z6);
    }

    public boolean a() {
        return this.f7528g;
    }

    public boolean b() {
        return this.f7529h;
    }

    public List<m> d() {
        return this.f7525d;
    }

    public v1.n e() {
        return this.f7523b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof x1) {
            x1 x1Var = (x1) obj;
            if (this.f7526e == x1Var.f7526e && this.f7528g == x1Var.f7528g && this.f7529h == x1Var.f7529h && this.f7522a.equals(x1Var.f7522a) && this.f7527f.equals(x1Var.f7527f) && this.f7523b.equals(x1Var.f7523b) && this.f7524c.equals(x1Var.f7524c) && this.f7530i == x1Var.f7530i) {
                return this.f7525d.equals(x1Var.f7525d);
            }
            return false;
        }
        return false;
    }

    public m1.e<v1.l> f() {
        return this.f7527f;
    }

    public v1.n g() {
        return this.f7524c;
    }

    public a1 h() {
        return this.f7522a;
    }

    public int hashCode() {
        return (((((((((((((((this.f7522a.hashCode() * 31) + this.f7523b.hashCode()) * 31) + this.f7524c.hashCode()) * 31) + this.f7525d.hashCode()) * 31) + this.f7527f.hashCode()) * 31) + (this.f7526e ? 1 : 0)) * 31) + (this.f7528g ? 1 : 0)) * 31) + (this.f7529h ? 1 : 0)) * 31) + (this.f7530i ? 1 : 0);
    }

    public boolean i() {
        return this.f7530i;
    }

    public boolean j() {
        return !this.f7527f.isEmpty();
    }

    public boolean k() {
        return this.f7526e;
    }

    public String toString() {
        return "ViewSnapshot(" + this.f7522a + ", " + this.f7523b + ", " + this.f7524c + ", " + this.f7525d + ", isFromCache=" + this.f7526e + ", mutatedKeys=" + this.f7527f.size() + ", didSyncStateChange=" + this.f7528g + ", excludesMetadataChanges=" + this.f7529h + ", hasCachedResults=" + this.f7530i + ")";
    }
}
