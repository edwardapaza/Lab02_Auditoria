package q4;

import com.google.android.gms.common.api.a;
import java.util.ArrayList;
import m4.j0;
import m4.k0;
import m4.l0;
import m4.n0;
import o4.r;
import s3.t;
import t3.x;
/* loaded from: classes.dex */
public abstract class d<T> implements i<T> {

    /* renamed from: a  reason: collision with root package name */
    public final v3.g f7087a;

    /* renamed from: b  reason: collision with root package name */
    public final int f7088b;

    /* renamed from: c  reason: collision with root package name */
    public final o4.a f7089c;

    /* JADX INFO: Access modifiers changed from: package-private */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collect$2", f = "ChannelFlow.kt", l = {123}, m = "invokeSuspend")
    /* loaded from: classes.dex */
    public static final class a extends kotlin.coroutines.jvm.internal.l implements d4.p<j0, v3.d<? super t>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f7090a;

        /* renamed from: b  reason: collision with root package name */
        private /* synthetic */ Object f7091b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ p4.d<T> f7092c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ d<T> f7093d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(p4.d<? super T> dVar, d<T> dVar2, v3.d<? super a> dVar3) {
            super(2, dVar3);
            this.f7092c = dVar;
            this.f7093d = dVar2;
        }

        @Override // d4.p
        /* renamed from: a */
        public final Object invoke(j0 j0Var, v3.d<? super t> dVar) {
            return ((a) create(j0Var, dVar)).invokeSuspend(t.f7573a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v3.d<t> create(Object obj, v3.d<?> dVar) {
            a aVar = new a(this.f7092c, this.f7093d, dVar);
            aVar.f7091b = obj;
            return aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object c5;
            c5 = w3.d.c();
            int i5 = this.f7090a;
            if (i5 == 0) {
                s3.n.b(obj);
                p4.d<T> dVar = this.f7092c;
                o4.t<T> i6 = this.f7093d.i((j0) this.f7091b);
                this.f7090a = 1;
                if (p4.e.b(dVar, i6, this) == c5) {
                    return c5;
                }
            } else if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                s3.n.b(obj);
            }
            return t.f7573a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collectToFun$1", f = "ChannelFlow.kt", l = {60}, m = "invokeSuspend")
    /* loaded from: classes.dex */
    public static final class b extends kotlin.coroutines.jvm.internal.l implements d4.p<r<? super T>, v3.d<? super t>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f7094a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f7095b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ d<T> f7096c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(d<T> dVar, v3.d<? super b> dVar2) {
            super(2, dVar2);
            this.f7096c = dVar;
        }

        @Override // d4.p
        /* renamed from: a */
        public final Object invoke(r<? super T> rVar, v3.d<? super t> dVar) {
            return ((b) create(rVar, dVar)).invokeSuspend(t.f7573a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v3.d<t> create(Object obj, v3.d<?> dVar) {
            b bVar = new b(this.f7096c, dVar);
            bVar.f7095b = obj;
            return bVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object c5;
            c5 = w3.d.c();
            int i5 = this.f7094a;
            if (i5 == 0) {
                s3.n.b(obj);
                d<T> dVar = this.f7096c;
                this.f7094a = 1;
                if (dVar.e((r) this.f7095b, this) == c5) {
                    return c5;
                }
            } else if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                s3.n.b(obj);
            }
            return t.f7573a;
        }
    }

    public d(v3.g gVar, int i5, o4.a aVar) {
        this.f7087a = gVar;
        this.f7088b = i5;
        this.f7089c = aVar;
    }

    static /* synthetic */ <T> Object d(d<T> dVar, p4.d<? super T> dVar2, v3.d<? super t> dVar3) {
        Object c5;
        Object c6 = k0.c(new a(dVar2, dVar, null), dVar3);
        c5 = w3.d.c();
        return c6 == c5 ? c6 : t.f7573a;
    }

    @Override // q4.i
    public p4.c<T> a(v3.g gVar, int i5, o4.a aVar) {
        v3.g J = gVar.J(this.f7087a);
        if (aVar == o4.a.SUSPEND) {
            int i6 = this.f7088b;
            if (i6 != -3) {
                if (i5 != -3) {
                    if (i6 != -2) {
                        if (i5 != -2 && (i6 = i6 + i5) < 0) {
                            i5 = a.e.API_PRIORITY_OTHER;
                        }
                    }
                }
                i5 = i6;
            }
            aVar = this.f7089c;
        }
        return (e4.k.a(J, this.f7087a) && i5 == this.f7088b && aVar == this.f7089c) ? this : f(J, i5, aVar);
    }

    @Override // p4.c
    public Object b(p4.d<? super T> dVar, v3.d<? super t> dVar2) {
        return d(this, dVar, dVar2);
    }

    protected String c() {
        return null;
    }

    protected abstract Object e(r<? super T> rVar, v3.d<? super t> dVar);

    protected abstract d<T> f(v3.g gVar, int i5, o4.a aVar);

    public final d4.p<r<? super T>, v3.d<? super t>, Object> g() {
        return new b(this, null);
    }

    public final int h() {
        int i5 = this.f7088b;
        if (i5 == -3) {
            return -2;
        }
        return i5;
    }

    public o4.t<T> i(j0 j0Var) {
        return o4.p.c(j0Var, this.f7087a, h(), this.f7089c, l0.ATOMIC, null, g(), 16, null);
    }

    public String toString() {
        String w5;
        ArrayList arrayList = new ArrayList(4);
        String c5 = c();
        if (c5 != null) {
            arrayList.add(c5);
        }
        if (this.f7087a != v3.h.f8175a) {
            arrayList.add("context=" + this.f7087a);
        }
        if (this.f7088b != -3) {
            arrayList.add("capacity=" + this.f7088b);
        }
        if (this.f7089c != o4.a.SUSPEND) {
            arrayList.add("onBufferOverflow=" + this.f7089c);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(n0.a(this));
        sb.append('[');
        w5 = x.w(arrayList, ", ", null, null, 0, null, null, 62, null);
        sb.append(w5);
        sb.append(']');
        return sb.toString();
    }
}
