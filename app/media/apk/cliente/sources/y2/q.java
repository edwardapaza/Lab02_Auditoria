package y2;

import java.util.ArrayList;
import z2.j;
/* loaded from: classes.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public final z2.j f8759a;

    /* renamed from: b  reason: collision with root package name */
    private b f8760b;

    /* renamed from: c  reason: collision with root package name */
    public final j.c f8761c;

    /* loaded from: classes.dex */
    class a implements j.c {
        a() {
        }

        @Override // z2.j.c
        public void a(z2.i iVar, j.d dVar) {
            if (q.this.f8760b == null) {
                n2.b.f("SpellCheckChannel", "No SpellCheckeMethodHandler registered, call not forwarded to spell check API.");
                return;
            }
            String str = iVar.f9003a;
            Object obj = iVar.f9004b;
            n2.b.f("SpellCheckChannel", "Received '" + str + "' message.");
            str.hashCode();
            if (!str.equals("SpellCheck.initiateSpellCheck")) {
                dVar.c();
                return;
            }
            try {
                ArrayList arrayList = (ArrayList) obj;
                q.this.f8760b.a((String) arrayList.get(0), (String) arrayList.get(1), dVar);
            } catch (IllegalStateException e5) {
                dVar.b("error", e5.getMessage(), null);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(String str, String str2, j.d dVar);
    }

    public q(o2.a aVar) {
        a aVar2 = new a();
        this.f8761c = aVar2;
        z2.j jVar = new z2.j(aVar, "flutter/spellcheck", z2.q.f9018b);
        this.f8759a = jVar;
        jVar.e(aVar2);
    }

    public void b(b bVar) {
        this.f8760b = bVar;
    }
}
