package m3;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: d  reason: collision with root package name */
    public static final w4.f f6107d = w4.f.e(":status");

    /* renamed from: e  reason: collision with root package name */
    public static final w4.f f6108e = w4.f.e(":method");

    /* renamed from: f  reason: collision with root package name */
    public static final w4.f f6109f = w4.f.e(":path");

    /* renamed from: g  reason: collision with root package name */
    public static final w4.f f6110g = w4.f.e(":scheme");

    /* renamed from: h  reason: collision with root package name */
    public static final w4.f f6111h = w4.f.e(":authority");

    /* renamed from: i  reason: collision with root package name */
    public static final w4.f f6112i = w4.f.e(":host");

    /* renamed from: j  reason: collision with root package name */
    public static final w4.f f6113j = w4.f.e(":version");

    /* renamed from: a  reason: collision with root package name */
    public final w4.f f6114a;

    /* renamed from: b  reason: collision with root package name */
    public final w4.f f6115b;

    /* renamed from: c  reason: collision with root package name */
    final int f6116c;

    public d(String str, String str2) {
        this(w4.f.e(str), w4.f.e(str2));
    }

    public d(w4.f fVar, String str) {
        this(fVar, w4.f.e(str));
    }

    public d(w4.f fVar, w4.f fVar2) {
        this.f6114a = fVar;
        this.f6115b = fVar2;
        this.f6116c = fVar.p() + 32 + fVar2.p();
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            return this.f6114a.equals(dVar.f6114a) && this.f6115b.equals(dVar.f6115b);
        }
        return false;
    }

    public int hashCode() {
        return ((527 + this.f6114a.hashCode()) * 31) + this.f6115b.hashCode();
    }

    public String toString() {
        return String.format("%s: %s", this.f6114a.u(), this.f6115b.u());
    }
}
