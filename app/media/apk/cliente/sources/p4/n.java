package p4;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import s3.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n<T> extends q4.a<p> implements j<T>, c, q4.i<T> {

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f6904e = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "_state");
    private volatile Object _state;

    /* renamed from: d  reason: collision with root package name */
    private int f6905d;

    /* JADX INFO: Access modifiers changed from: package-private */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.StateFlowImpl", f = "StateFlow.kt", l = {384, 396, 401}, m = "collect")
    /* loaded from: classes.dex */
    public static final class a extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f6906a;

        /* renamed from: b  reason: collision with root package name */
        Object f6907b;

        /* renamed from: c  reason: collision with root package name */
        Object f6908c;

        /* renamed from: d  reason: collision with root package name */
        Object f6909d;

        /* renamed from: e  reason: collision with root package name */
        Object f6910e;

        /* renamed from: f  reason: collision with root package name */
        /* synthetic */ Object f6911f;

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ n<T> f6912k;

        /* renamed from: l  reason: collision with root package name */
        int f6913l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(n<T> nVar, v3.d<? super a> dVar) {
            super(dVar);
            this.f6912k = nVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.f6911f = obj;
            this.f6913l |= Integer.MIN_VALUE;
            return this.f6912k.b(null, this);
        }
    }

    public n(Object obj) {
        this._state = obj;
    }

    private final boolean k(Object obj, Object obj2) {
        int i5;
        p[] h5;
        synchronized (this) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6904e;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj != null && !e4.k.a(obj3, obj)) {
                return false;
            }
            if (e4.k.a(obj3, obj2)) {
                return true;
            }
            atomicReferenceFieldUpdater.set(this, obj2);
            int i6 = this.f6905d;
            if ((i6 & 1) != 0) {
                this.f6905d = i6 + 2;
                return true;
            }
            int i7 = i6 + 1;
            this.f6905d = i7;
            p[] h6 = h();
            t tVar = t.f7573a;
            while (true) {
                p[] pVarArr = h6;
                if (pVarArr != null) {
                    for (p pVar : pVarArr) {
                        if (pVar != null) {
                            pVar.g();
                        }
                    }
                }
                synchronized (this) {
                    i5 = this.f6905d;
                    if (i5 == i7) {
                        this.f6905d = i7 + 1;
                        return true;
                    }
                    h5 = h();
                    t tVar2 = t.f7573a;
                }
                h6 = h5;
                i7 = i5;
            }
        }
    }

    @Override // q4.i
    public c<T> a(v3.g gVar, int i5, o4.a aVar) {
        return o.d(this, gVar, i5, aVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b7, code lost:
        if (e4.k.a(r11, r12) == false) goto L26;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ae A[Catch: all -> 0x0073, TryCatch #0 {all -> 0x0073, blocks: (B:14:0x003e, B:34:0x00a6, B:36:0x00ae, B:38:0x00b3, B:48:0x00d4, B:50:0x00da, B:40:0x00b9, B:44:0x00c0, B:19:0x005c, B:22:0x006f, B:33:0x0097), top: B:57:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b3 A[Catch: all -> 0x0073, TryCatch #0 {all -> 0x0073, blocks: (B:14:0x003e, B:34:0x00a6, B:36:0x00ae, B:38:0x00b3, B:48:0x00d4, B:50:0x00da, B:40:0x00b9, B:44:0x00c0, B:19:0x005c, B:22:0x006f, B:33:0x0097), top: B:57:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00da A[Catch: all -> 0x0073, TRY_LEAVE, TryCatch #0 {all -> 0x0073, blocks: (B:14:0x003e, B:34:0x00a6, B:36:0x00ae, B:38:0x00b3, B:48:0x00d4, B:50:0x00da, B:40:0x00b9, B:44:0x00c0, B:19:0x005c, B:22:0x006f, B:33:0x0097), top: B:57:0x0024 }] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v2, types: [q4.c] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00d8 -> B:34:0x00a6). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00ea -> B:34:0x00a6). Please submit an issue!!! */
    @Override // p4.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(p4.d<? super T> r11, v3.d<?> r12) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p4.n.b(p4.d, v3.d):java.lang.Object");
    }

    @Override // p4.d
    public Object c(T t5, v3.d<? super t> dVar) {
        setValue(t5);
        return t.f7573a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // q4.a
    /* renamed from: i */
    public p e() {
        return new p();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // q4.a
    /* renamed from: j */
    public p[] f(int i5) {
        return new p[i5];
    }

    @Override // p4.j
    public void setValue(T t5) {
        if (t5 == null) {
            t5 = (T) q4.k.f7105a;
        }
        k(null, t5);
    }
}
