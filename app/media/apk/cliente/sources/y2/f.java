package y2;

import java.util.HashMap;
import java.util.Map;
import z2.j;
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final z2.j f8611a;

    /* renamed from: b  reason: collision with root package name */
    private b f8612b;

    /* renamed from: c  reason: collision with root package name */
    public final j.c f8613c;

    /* loaded from: classes.dex */
    class a implements j.c {

        /* renamed from: a  reason: collision with root package name */
        Map<Long, Long> f8614a = new HashMap();

        a() {
        }

        @Override // z2.j.c
        public void a(z2.i iVar, j.d dVar) {
            if (f.this.f8612b != null) {
                String str = iVar.f9003a;
                str.hashCode();
                if (!str.equals("getKeyboardState")) {
                    dVar.c();
                    return;
                }
                try {
                    this.f8614a = f.this.f8612b.a();
                } catch (IllegalStateException e5) {
                    dVar.b("error", e5.getMessage(), null);
                }
            }
            dVar.a(this.f8614a);
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        Map<Long, Long> a();
    }

    public f(z2.b bVar) {
        a aVar = new a();
        this.f8613c = aVar;
        z2.j jVar = new z2.j(bVar, "flutter/keyboard", z2.q.f9018b);
        this.f8611a = jVar;
        jVar.e(aVar);
    }

    public void b(b bVar) {
        this.f8612b = bVar;
    }
}
