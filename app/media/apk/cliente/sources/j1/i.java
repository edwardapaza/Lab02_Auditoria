package j1;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p001firebaseauthapi.zzafm;
import com.google.android.gms.internal.p001firebaseauthapi.zzafp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class i extends com.google.firebase.auth.a0 {
    public static final Parcelable.Creator<i> CREATOR = new h();

    /* renamed from: a  reason: collision with root package name */
    private zzafm f5408a;

    /* renamed from: b  reason: collision with root package name */
    private e f5409b;

    /* renamed from: c  reason: collision with root package name */
    private String f5410c;

    /* renamed from: d  reason: collision with root package name */
    private String f5411d;

    /* renamed from: e  reason: collision with root package name */
    private List<e> f5412e;

    /* renamed from: f  reason: collision with root package name */
    private List<String> f5413f;

    /* renamed from: k  reason: collision with root package name */
    private String f5414k;

    /* renamed from: l  reason: collision with root package name */
    private Boolean f5415l;

    /* renamed from: m  reason: collision with root package name */
    private k f5416m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f5417n;

    /* renamed from: o  reason: collision with root package name */
    private com.google.firebase.auth.d2 f5418o;

    /* renamed from: p  reason: collision with root package name */
    private m0 f5419p;

    /* renamed from: q  reason: collision with root package name */
    private List<zzafp> f5420q;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(zzafm zzafmVar, e eVar, String str, String str2, List<e> list, List<String> list2, String str3, Boolean bool, k kVar, boolean z4, com.google.firebase.auth.d2 d2Var, m0 m0Var, List<zzafp> list3) {
        this.f5408a = zzafmVar;
        this.f5409b = eVar;
        this.f5410c = str;
        this.f5411d = str2;
        this.f5412e = list;
        this.f5413f = list2;
        this.f5414k = str3;
        this.f5415l = bool;
        this.f5416m = kVar;
        this.f5417n = z4;
        this.f5418o = d2Var;
        this.f5419p = m0Var;
        this.f5420q = list3;
    }

    public i(f1.f fVar, List<? extends com.google.firebase.auth.d1> list) {
        com.google.android.gms.common.internal.q.k(fVar);
        this.f5410c = fVar.q();
        this.f5411d = "com.google.firebase.auth.internal.DefaultFirebaseUser";
        this.f5414k = "2";
        O(list);
    }

    @Override // com.google.firebase.auth.a0
    public final synchronized com.google.firebase.auth.a0 O(List<? extends com.google.firebase.auth.d1> list) {
        com.google.android.gms.common.internal.q.k(list);
        this.f5412e = new ArrayList(list.size());
        this.f5413f = new ArrayList(list.size());
        for (int i5 = 0; i5 < list.size(); i5++) {
            com.google.firebase.auth.d1 d1Var = list.get(i5);
            if (d1Var.c().equals("firebase")) {
                this.f5409b = (e) d1Var;
            } else {
                this.f5413f.add(d1Var.c());
            }
            this.f5412e.add((e) d1Var);
        }
        if (this.f5409b == null) {
            this.f5409b = this.f5412e.get(0);
        }
        return this;
    }

    @Override // com.google.firebase.auth.a0
    public final f1.f P() {
        return f1.f.p(this.f5410c);
    }

    @Override // com.google.firebase.auth.a0
    public final void Q(zzafm zzafmVar) {
        this.f5408a = (zzafm) com.google.android.gms.common.internal.q.k(zzafmVar);
    }

    @Override // com.google.firebase.auth.a0
    public final /* synthetic */ com.google.firebase.auth.a0 R() {
        this.f5415l = Boolean.FALSE;
        return this;
    }

    @Override // com.google.firebase.auth.a0
    public final void S(List<com.google.firebase.auth.j0> list) {
        this.f5419p = m0.t(list);
    }

    @Override // com.google.firebase.auth.a0
    public final zzafm T() {
        return this.f5408a;
    }

    @Override // com.google.firebase.auth.a0
    public final List<String> U() {
        return this.f5413f;
    }

    public final i V(String str) {
        this.f5414k = str;
        return this;
    }

    public final void W(com.google.firebase.auth.d2 d2Var) {
        this.f5418o = d2Var;
    }

    public final void X(k kVar) {
        this.f5416m = kVar;
    }

    public final void Y(boolean z4) {
        this.f5417n = z4;
    }

    public final void Z(List<zzafp> list) {
        com.google.android.gms.common.internal.q.k(list);
        this.f5420q = list;
    }

    @Override // com.google.firebase.auth.a0, com.google.firebase.auth.d1
    public String a() {
        return this.f5409b.a();
    }

    public final com.google.firebase.auth.d2 a0() {
        return this.f5418o;
    }

    @Override // com.google.firebase.auth.a0, com.google.firebase.auth.d1
    public Uri b() {
        return this.f5409b.b();
    }

    public final List<com.google.firebase.auth.j0> b0() {
        m0 m0Var = this.f5419p;
        return m0Var != null ? m0Var.u() : new ArrayList();
    }

    @Override // com.google.firebase.auth.d1
    public String c() {
        return this.f5409b.c();
    }

    public final List<e> c0() {
        return this.f5412e;
    }

    public final boolean d0() {
        return this.f5417n;
    }

    @Override // com.google.firebase.auth.d1
    public boolean f() {
        return this.f5409b.f();
    }

    @Override // com.google.firebase.auth.a0, com.google.firebase.auth.d1
    public String j() {
        return this.f5409b.j();
    }

    @Override // com.google.firebase.auth.a0, com.google.firebase.auth.d1
    public String n() {
        return this.f5409b.n();
    }

    @Override // com.google.firebase.auth.a0, com.google.firebase.auth.d1
    public String q() {
        return this.f5409b.q();
    }

    @Override // com.google.firebase.auth.a0
    public com.google.firebase.auth.b0 v() {
        return this.f5416m;
    }

    @Override // com.google.firebase.auth.a0
    public /* synthetic */ com.google.firebase.auth.h0 w() {
        return new m(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        int a5 = m0.c.a(parcel);
        m0.c.k(parcel, 1, T(), i5, false);
        m0.c.k(parcel, 2, this.f5409b, i5, false);
        m0.c.l(parcel, 3, this.f5410c, false);
        m0.c.l(parcel, 4, this.f5411d, false);
        m0.c.o(parcel, 5, this.f5412e, false);
        m0.c.m(parcel, 6, U(), false);
        m0.c.l(parcel, 7, this.f5414k, false);
        m0.c.d(parcel, 8, Boolean.valueOf(z()), false);
        m0.c.k(parcel, 9, v(), i5, false);
        m0.c.c(parcel, 10, this.f5417n);
        m0.c.k(parcel, 11, this.f5418o, i5, false);
        m0.c.k(parcel, 12, this.f5419p, i5, false);
        m0.c.o(parcel, 13, this.f5420q, false);
        m0.c.b(parcel, a5);
    }

    @Override // com.google.firebase.auth.a0
    public List<? extends com.google.firebase.auth.d1> x() {
        return this.f5412e;
    }

    @Override // com.google.firebase.auth.a0
    public String y() {
        Map map;
        zzafm zzafmVar = this.f5408a;
        if (zzafmVar == null || zzafmVar.zzc() == null || (map = (Map) l0.a(this.f5408a.zzc()).b().get("firebase")) == null) {
            return null;
        }
        return (String) map.get("tenant");
    }

    @Override // com.google.firebase.auth.a0
    public boolean z() {
        com.google.firebase.auth.c0 a5;
        Boolean bool = this.f5415l;
        if (bool == null || bool.booleanValue()) {
            zzafm zzafmVar = this.f5408a;
            String str = "";
            if (zzafmVar != null && (a5 = l0.a(zzafmVar.zzc())) != null) {
                str = a5.e();
            }
            boolean z4 = true;
            if (x().size() > 1 || (str != null && str.equals("custom"))) {
                z4 = false;
            }
            this.f5415l = Boolean.valueOf(z4);
        }
        return this.f5415l.booleanValue();
    }

    @Override // com.google.firebase.auth.a0
    public final String zzd() {
        return T().zzc();
    }

    @Override // com.google.firebase.auth.a0
    public final String zze() {
        return this.f5408a.zzf();
    }
}
