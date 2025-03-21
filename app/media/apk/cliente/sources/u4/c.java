package u4;

import d4.q;
import e4.l;
import r4.h0;
import s3.t;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final q<Object, Object, Object, Object> f8087a = a.f8093a;

    /* renamed from: b  reason: collision with root package name */
    private static final h0 f8088b = new h0("STATE_REG");

    /* renamed from: c  reason: collision with root package name */
    private static final h0 f8089c = new h0("STATE_COMPLETED");

    /* renamed from: d  reason: collision with root package name */
    private static final h0 f8090d = new h0("STATE_CANCELLED");

    /* renamed from: e  reason: collision with root package name */
    private static final h0 f8091e = new h0("NO_RESULT");

    /* renamed from: f  reason: collision with root package name */
    private static final h0 f8092f = new h0("PARAM_CLAUSE_0");

    /* loaded from: classes.dex */
    static final class a extends l implements q {

        /* renamed from: a  reason: collision with root package name */
        public static final a f8093a = new a();

        a() {
            super(3);
        }

        @Override // d4.q
        /* renamed from: a */
        public final Void d(Object obj, Object obj2, Object obj3) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final d a(int i5) {
        if (i5 != 0) {
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 == 3) {
                        return d.ALREADY_SELECTED;
                    }
                    throw new IllegalStateException(("Unexpected internal result: " + i5).toString());
                }
                return d.CANCELLED;
            }
            return d.REREGISTER;
        }
        return d.SUCCESSFUL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h(m4.l<? super t> lVar, d4.l<? super Throwable, t> lVar2) {
        Object h5 = lVar.h(t.f7573a, null, lVar2);
        if (h5 == null) {
            return false;
        }
        lVar.s(h5);
        return true;
    }
}
