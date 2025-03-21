package y1;

import java.util.HashMap;
import java.util.Map;
import s1.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class w0 {

    /* renamed from: a  reason: collision with root package name */
    private int f8533a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final Map<v1.l, m.a> f8534b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private boolean f8535c = true;

    /* renamed from: d  reason: collision with root package name */
    private com.google.protobuf.i f8536d = com.google.protobuf.i.f1961b;

    /* renamed from: e  reason: collision with root package name */
    private boolean f8537e = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f8538a;

        static {
            int[] iArr = new int[m.a.values().length];
            f8538a = iArr;
            try {
                iArr[m.a.ADDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8538a[m.a.MODIFIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8538a[m.a.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(v1.l lVar, m.a aVar) {
        this.f8535c = true;
        this.f8534b.put(lVar, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f8535c = false;
        this.f8534b.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        return this.f8535c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return this.f8537e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return this.f8533a != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        this.f8535c = true;
        this.f8537e = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        this.f8533a++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        this.f8533a--;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(v1.l lVar) {
        this.f8535c = true;
        this.f8534b.remove(lVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public v0 j() {
        m1.e<v1.l> e5 = v1.l.e();
        m1.e<v1.l> e6 = v1.l.e();
        m1.e<v1.l> e7 = v1.l.e();
        m1.e<v1.l> eVar = e5;
        m1.e<v1.l> eVar2 = e6;
        m1.e<v1.l> eVar3 = e7;
        for (Map.Entry<v1.l, m.a> entry : this.f8534b.entrySet()) {
            v1.l key = entry.getKey();
            m.a value = entry.getValue();
            int i5 = a.f8538a[value.ordinal()];
            if (i5 == 1) {
                eVar = eVar.i(key);
            } else if (i5 == 2) {
                eVar2 = eVar2.i(key);
            } else if (i5 != 3) {
                throw z1.b.a("Encountered invalid change type: %s", value);
            } else {
                eVar3 = eVar3.i(key);
            }
        }
        return new v0(this.f8536d, this.f8537e, eVar, eVar2, eVar3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(com.google.protobuf.i iVar) {
        if (iVar.isEmpty()) {
            return;
        }
        this.f8535c = true;
        this.f8536d = iVar;
    }
}
