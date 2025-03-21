package x3;

import e4.k;
import e4.l;
/* loaded from: classes.dex */
public final class b {

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX WARN: Incorrect field signature: [TE; */
    /* loaded from: classes.dex */
    static final class a<E> extends l implements d4.a<E[]> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Enum[] f8348a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Incorrect types in method signature: ([TE;)V */
        a(Enum[] enumArr) {
            super(0);
            this.f8348a = enumArr;
        }

        /* JADX WARN: Incorrect return type in method signature: ()[TE; */
        @Override // d4.a
        /* renamed from: a */
        public final Enum[] b() {
            return this.f8348a;
        }
    }

    public static final <E extends Enum<E>> x3.a<E> a(E[] eArr) {
        k.e(eArr, "entries");
        c cVar = new c(new a(eArr));
        cVar.size();
        return cVar;
    }
}
