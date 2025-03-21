package q4;

import m4.u1;
import r4.d0;
import v3.g;
/* loaded from: classes.dex */
public final class n {

    /* loaded from: classes.dex */
    static final class a extends e4.l implements d4.p<Integer, g.b, Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l<?> f7116a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(l<?> lVar) {
            super(2);
            this.f7116a = lVar;
        }

        public final Integer a(int i5, g.b bVar) {
            g.c<?> key = bVar.getKey();
            g.b d5 = this.f7116a.f7109b.d(key);
            if (key != u1.f6282h) {
                return Integer.valueOf(bVar != d5 ? Integer.MIN_VALUE : i5 + 1);
            }
            u1 u1Var = (u1) d5;
            e4.k.c(bVar, "null cannot be cast to non-null type kotlinx.coroutines.Job");
            u1 b5 = n.b((u1) bVar, u1Var);
            if (b5 == u1Var) {
                if (u1Var != null) {
                    i5++;
                }
                return Integer.valueOf(i5);
            }
            throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + b5 + ", expected child of " + u1Var + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
        }

        @Override // d4.p
        public /* bridge */ /* synthetic */ Integer invoke(Integer num, g.b bVar) {
            return a(num.intValue(), bVar);
        }
    }

    public static final void a(l<?> lVar, v3.g gVar) {
        if (((Number) gVar.e0(0, new a(lVar))).intValue() == lVar.f7110c) {
            return;
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + lVar.f7109b + ",\n\t\tbut emission happened in " + gVar + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
    }

    public static final u1 b(u1 u1Var, u1 u1Var2) {
        while (u1Var != null) {
            if (u1Var == u1Var2 || !(u1Var instanceof d0)) {
                return u1Var;
            }
            u1Var = u1Var.getParent();
        }
        return null;
    }
}
