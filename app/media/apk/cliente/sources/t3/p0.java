package t3;

import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public final class p0 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    @kotlin.coroutines.jvm.internal.f(c = "kotlin.collections.SlidingWindowKt$windowedIterator$1", f = "SlidingWindow.kt", l = {34, 40, 49, 55, 58}, m = "invokeSuspend")
    /* loaded from: classes.dex */
    public static final class a<T> extends kotlin.coroutines.jvm.internal.k implements d4.p<j4.d<? super List<? extends T>>, v3.d<? super s3.t>, Object> {

        /* renamed from: b  reason: collision with root package name */
        Object f7631b;

        /* renamed from: c  reason: collision with root package name */
        Object f7632c;

        /* renamed from: d  reason: collision with root package name */
        int f7633d;

        /* renamed from: e  reason: collision with root package name */
        int f7634e;

        /* renamed from: f  reason: collision with root package name */
        private /* synthetic */ Object f7635f;

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ int f7636k;

        /* renamed from: l  reason: collision with root package name */
        final /* synthetic */ int f7637l;

        /* renamed from: m  reason: collision with root package name */
        final /* synthetic */ Iterator<T> f7638m;

        /* renamed from: n  reason: collision with root package name */
        final /* synthetic */ boolean f7639n;

        /* renamed from: o  reason: collision with root package name */
        final /* synthetic */ boolean f7640o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(int i5, int i6, Iterator<? extends T> it, boolean z4, boolean z5, v3.d<? super a> dVar) {
            super(2, dVar);
            this.f7636k = i5;
            this.f7637l = i6;
            this.f7638m = it;
            this.f7639n = z4;
            this.f7640o = z5;
        }

        @Override // d4.p
        /* renamed from: a */
        public final Object invoke(j4.d<? super List<? extends T>> dVar, v3.d<? super s3.t> dVar2) {
            return ((a) create(dVar, dVar2)).invokeSuspend(s3.t.f7573a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v3.d<s3.t> create(Object obj, v3.d<?> dVar) {
            a aVar = new a(this.f7636k, this.f7637l, this.f7638m, this.f7639n, this.f7640o, dVar);
            aVar.f7635f = obj;
            return aVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0083  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00ac  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00b0  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00db A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00eb  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x0129  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x0133  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x0153  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00a5 -> B:29:0x00a8). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x011c -> B:58:0x011f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x014a -> B:71:0x014d). Please submit an issue!!! */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                Method dump skipped, instructions count: 364
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: t3.p0.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final void a(int i5, int i6) {
        String str;
        if (i5 > 0 && i6 > 0) {
            return;
        }
        if (i5 != i6) {
            str = "Both size " + i5 + " and step " + i6 + " must be greater than zero.";
        } else {
            str = "size " + i5 + " must be greater than zero.";
        }
        throw new IllegalArgumentException(str.toString());
    }

    public static final <T> Iterator<List<T>> b(Iterator<? extends T> it, int i5, int i6, boolean z4, boolean z5) {
        Iterator<List<T>> a5;
        e4.k.e(it, "iterator");
        if (it.hasNext()) {
            a5 = j4.f.a(new a(i5, i6, it, z5, z4, null));
            return a5;
        }
        return y.f7646a;
    }
}
