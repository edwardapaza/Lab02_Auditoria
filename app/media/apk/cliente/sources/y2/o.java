package y2;

import java.util.HashMap;
import java.util.Map;
import z2.j;
/* loaded from: classes.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f8732a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f8733b;

    /* renamed from: c  reason: collision with root package name */
    private z2.j f8734c;

    /* renamed from: d  reason: collision with root package name */
    private j.d f8735d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f8736e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f8737f;

    /* renamed from: g  reason: collision with root package name */
    private final j.c f8738g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements j.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ byte[] f8739a;

        a(byte[] bArr) {
            this.f8739a = bArr;
        }

        @Override // z2.j.d
        public void a(Object obj) {
            o.this.f8733b = this.f8739a;
        }

        @Override // z2.j.d
        public void b(String str, String str2, Object obj) {
            n2.b.b("RestorationChannel", "Error " + str + " while sending restoration data to framework: " + str2);
        }

        @Override // z2.j.d
        public void c() {
        }
    }

    /* loaded from: classes.dex */
    class b implements j.c {
        b() {
        }

        @Override // z2.j.c
        public void a(z2.i iVar, j.d dVar) {
            Map i5;
            String str = iVar.f9003a;
            Object obj = iVar.f9004b;
            str.hashCode();
            if (str.equals("get")) {
                o.this.f8737f = true;
                if (!o.this.f8736e) {
                    o oVar = o.this;
                    if (oVar.f8732a) {
                        oVar.f8735d = dVar;
                        return;
                    }
                }
                o oVar2 = o.this;
                i5 = oVar2.i(oVar2.f8733b);
            } else if (!str.equals("put")) {
                dVar.c();
                return;
            } else {
                o.this.f8733b = (byte[]) obj;
                i5 = null;
            }
            dVar.a(i5);
        }
    }

    public o(o2.a aVar, boolean z4) {
        this(new z2.j(aVar, "flutter/restoration", z2.q.f9018b), z4);
    }

    o(z2.j jVar, boolean z4) {
        this.f8736e = false;
        this.f8737f = false;
        b bVar = new b();
        this.f8738g = bVar;
        this.f8734c = jVar;
        this.f8732a = z4;
        jVar.e(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> i(byte[] bArr) {
        HashMap hashMap = new HashMap();
        hashMap.put("enabled", Boolean.TRUE);
        hashMap.put("data", bArr);
        return hashMap;
    }

    public void g() {
        this.f8733b = null;
    }

    public byte[] h() {
        return this.f8733b;
    }

    public void j(byte[] bArr) {
        this.f8736e = true;
        j.d dVar = this.f8735d;
        if (dVar != null) {
            dVar.a(i(bArr));
            this.f8735d = null;
        } else if (this.f8737f) {
            this.f8734c.d("push", i(bArr), new a(bArr));
            return;
        }
        this.f8733b = bArr;
    }
}
