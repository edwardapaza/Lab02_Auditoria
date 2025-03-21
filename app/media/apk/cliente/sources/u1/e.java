package u1;

import java.util.Comparator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e {

    /* renamed from: c  reason: collision with root package name */
    static final Comparator<e> f7776c = new Comparator() { // from class: u1.c
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int e5;
            e5 = e.e((e) obj, (e) obj2);
            return e5;
        }
    };

    /* renamed from: d  reason: collision with root package name */
    static final Comparator<e> f7777d = new Comparator() { // from class: u1.d
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int f5;
            f5 = e.f((e) obj, (e) obj2);
            return f5;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final v1.l f7778a;

    /* renamed from: b  reason: collision with root package name */
    private final int f7779b;

    public e(v1.l lVar, int i5) {
        this.f7778a = lVar;
        this.f7779b = i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int e(e eVar, e eVar2) {
        int compareTo = eVar.f7778a.compareTo(eVar2.f7778a);
        return compareTo != 0 ? compareTo : z1.h0.l(eVar.f7779b, eVar2.f7779b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int f(e eVar, e eVar2) {
        int l5 = z1.h0.l(eVar.f7779b, eVar2.f7779b);
        return l5 != 0 ? l5 : eVar.f7778a.compareTo(eVar2.f7778a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f7779b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public v1.l d() {
        return this.f7778a;
    }
}
