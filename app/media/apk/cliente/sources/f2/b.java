package f2;

import com.google.firebase.components.ComponentRegistrar;
import java.util.ArrayList;
import java.util.List;
import k1.e;
import k1.h;
import k1.j;
/* loaded from: classes.dex */
public class b implements j {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object c(String str, k1.c cVar, e eVar) {
        try {
            c.b(str);
            return cVar.h().a(eVar);
        } finally {
            c.a();
        }
    }

    @Override // k1.j
    public List<k1.c<?>> a(ComponentRegistrar componentRegistrar) {
        ArrayList arrayList = new ArrayList();
        for (final k1.c<?> cVar : componentRegistrar.getComponents()) {
            final String i5 = cVar.i();
            if (i5 != null) {
                cVar = cVar.t(new h() { // from class: f2.a
                    @Override // k1.h
                    public final Object a(e eVar) {
                        Object c5;
                        c5 = b.c(i5, cVar, eVar);
                        return c5;
                    }
                });
            }
            arrayList.add(cVar);
        }
        return arrayList;
    }
}
