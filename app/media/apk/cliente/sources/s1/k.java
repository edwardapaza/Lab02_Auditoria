package s1;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class k extends q {

    /* renamed from: a  reason: collision with root package name */
    private final List<q> f7368a;

    /* renamed from: b  reason: collision with root package name */
    private final a f7369b;

    /* renamed from: c  reason: collision with root package name */
    private List<p> f7370c;

    /* loaded from: classes.dex */
    public enum a {
        AND("and"),
        OR("or");
        

        /* renamed from: a  reason: collision with root package name */
        private final String f7374a;

        a(String str) {
            this.f7374a = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.f7374a;
        }
    }

    public k(List<q> list, a aVar) {
        this.f7368a = new ArrayList(list);
        this.f7369b = aVar;
    }

    @Override // s1.q
    public String a() {
        StringBuilder sb = new StringBuilder();
        if (i()) {
            for (q qVar : this.f7368a) {
                sb.append(qVar.a());
            }
            return sb.toString();
        }
        sb.append(this.f7369b.toString() + "(");
        sb.append(TextUtils.join(",", this.f7368a));
        sb.append(")");
        return sb.toString();
    }

    @Override // s1.q
    public List<q> b() {
        return Collections.unmodifiableList(this.f7368a);
    }

    @Override // s1.q
    public List<p> c() {
        List<p> list = this.f7370c;
        if (list != null) {
            return Collections.unmodifiableList(list);
        }
        this.f7370c = new ArrayList();
        for (q qVar : this.f7368a) {
            this.f7370c.addAll(qVar.c());
        }
        return Collections.unmodifiableList(this.f7370c);
    }

    @Override // s1.q
    public boolean d(v1.i iVar) {
        if (f()) {
            for (q qVar : this.f7368a) {
                if (!qVar.d(iVar)) {
                    return false;
                }
            }
            return true;
        }
        for (q qVar2 : this.f7368a) {
            if (qVar2.d(iVar)) {
                return true;
            }
        }
        return false;
    }

    public a e() {
        return this.f7369b;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f7369b == kVar.f7369b && this.f7368a.equals(kVar.f7368a);
    }

    public boolean f() {
        return this.f7369b == a.AND;
    }

    public boolean g() {
        return this.f7369b == a.OR;
    }

    public boolean h() {
        for (q qVar : this.f7368a) {
            if (qVar instanceof k) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return ((1147 + this.f7369b.hashCode()) * 31) + this.f7368a.hashCode();
    }

    public boolean i() {
        return h() && f();
    }

    public k j(List<q> list) {
        ArrayList arrayList = new ArrayList(this.f7368a);
        arrayList.addAll(list);
        return new k(arrayList, this.f7369b);
    }

    public String toString() {
        return a();
    }
}
