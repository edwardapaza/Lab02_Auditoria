package io.grpc.internal;

import i3.e0;
import i3.f;
import java.text.MessageFormat;
import java.util.logging.Level;
/* loaded from: classes.dex */
final class p extends i3.f {

    /* renamed from: a  reason: collision with root package name */
    private final q f5083a;

    /* renamed from: b  reason: collision with root package name */
    private final q2 f5084b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5085a;

        static {
            int[] iArr = new int[f.a.values().length];
            f5085a = iArr;
            try {
                iArr[f.a.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5085a[f.a.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5085a[f.a.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(q qVar, q2 q2Var) {
        this.f5083a = (q) z0.k.o(qVar, "tracer");
        this.f5084b = (q2) z0.k.o(q2Var, "time");
    }

    private boolean c(f.a aVar) {
        return aVar != f.a.DEBUG && this.f5083a.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(i3.j0 j0Var, f.a aVar, String str) {
        Level f5 = f(aVar);
        if (q.f5098f.isLoggable(f5)) {
            q.d(j0Var, f5, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(i3.j0 j0Var, f.a aVar, String str, Object... objArr) {
        Level f5 = f(aVar);
        if (q.f5098f.isLoggable(f5)) {
            q.d(j0Var, f5, MessageFormat.format(str, objArr));
        }
    }

    private static Level f(f.a aVar) {
        int i5 = a.f5085a[aVar.ordinal()];
        return (i5 == 1 || i5 == 2) ? Level.FINE : i5 != 3 ? Level.FINEST : Level.FINER;
    }

    private static e0.b g(f.a aVar) {
        int i5 = a.f5085a[aVar.ordinal()];
        return i5 != 1 ? i5 != 2 ? e0.b.CT_INFO : e0.b.CT_WARNING : e0.b.CT_ERROR;
    }

    private void h(f.a aVar, String str) {
        if (aVar == f.a.DEBUG) {
            return;
        }
        this.f5083a.f(new e0.a().b(str).c(g(aVar)).e(this.f5084b.a()).a());
    }

    @Override // i3.f
    public void a(f.a aVar, String str) {
        d(this.f5083a.b(), aVar, str);
        if (c(aVar)) {
            h(aVar, str);
        }
    }

    @Override // i3.f
    public void b(f.a aVar, String str, Object... objArr) {
        a(aVar, (c(aVar) || q.f5098f.isLoggable(f(aVar))) ? MessageFormat.format(str, objArr) : null);
    }
}
