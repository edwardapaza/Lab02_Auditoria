package r1;

import v1.w;
/* loaded from: classes.dex */
public class e implements c {

    /* renamed from: a  reason: collision with root package name */
    private final String f7137a;

    /* renamed from: b  reason: collision with root package name */
    private final int f7138b;

    /* renamed from: c  reason: collision with root package name */
    private final w f7139c;

    /* renamed from: d  reason: collision with root package name */
    private final int f7140d;

    /* renamed from: e  reason: collision with root package name */
    private final long f7141e;

    public e(String str, int i5, w wVar, int i6, long j5) {
        this.f7137a = str;
        this.f7138b = i5;
        this.f7139c = wVar;
        this.f7140d = i6;
        this.f7141e = j5;
    }

    public String a() {
        return this.f7137a;
    }

    public w b() {
        return this.f7139c;
    }

    public int c() {
        return this.f7138b;
    }

    public long d() {
        return this.f7141e;
    }

    public int e() {
        return this.f7140d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f7138b == eVar.f7138b && this.f7140d == eVar.f7140d && this.f7141e == eVar.f7141e && this.f7137a.equals(eVar.f7137a)) {
            return this.f7139c.equals(eVar.f7139c);
        }
        return false;
    }

    public int hashCode() {
        long j5 = this.f7141e;
        return (((((((this.f7137a.hashCode() * 31) + this.f7138b) * 31) + this.f7140d) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31) + this.f7139c.hashCode();
    }
}
