package s1;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import s1.m;
/* loaded from: classes.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private final TreeMap<v1.l, m> f7399a = new TreeMap<>();

    public void a(m mVar) {
        v1.l key = mVar.b().getKey();
        m mVar2 = this.f7399a.get(key);
        if (mVar2 == null) {
            this.f7399a.put(key, mVar);
            return;
        }
        m.a c5 = mVar2.c();
        m.a c6 = mVar.c();
        m.a aVar = m.a.ADDED;
        if (c6 == aVar || c5 != m.a.METADATA) {
            if (c6 != m.a.METADATA || c5 == m.a.REMOVED) {
                m.a aVar2 = m.a.MODIFIED;
                if (c6 != aVar2 || c5 != aVar2) {
                    if (c6 == aVar2 && c5 == aVar) {
                        mVar = m.a(aVar, mVar.b());
                    } else {
                        m.a aVar3 = m.a.REMOVED;
                        if (c6 == aVar3 && c5 == aVar) {
                            this.f7399a.remove(key);
                            return;
                        } else if (c6 == aVar3 && c5 == aVar2) {
                            mVar = m.a(aVar3, mVar2.b());
                        } else if (c6 != aVar || c5 != aVar3) {
                            throw z1.b.a("Unsupported combination of changes %s after %s", c6, c5);
                        }
                    }
                }
                mVar = m.a(aVar2, mVar.b());
            } else {
                mVar = m.a(c5, mVar.b());
            }
        }
        this.f7399a.put(key, mVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<m> b() {
        return new ArrayList(this.f7399a.values());
    }
}
