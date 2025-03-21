package j1;
/* loaded from: classes.dex */
public final class f extends com.google.firebase.auth.w {

    /* renamed from: a  reason: collision with root package name */
    private String f5384a;

    /* renamed from: b  reason: collision with root package name */
    private String f5385b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f5386c = false;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5387d = false;

    @Override // com.google.firebase.auth.w
    public final void a(boolean z4) {
        this.f5387d = z4;
    }

    @Override // com.google.firebase.auth.w
    public final void b(boolean z4) {
        this.f5386c = z4;
    }

    @Override // com.google.firebase.auth.w
    public final void c(String str, String str2) {
        this.f5384a = str;
        this.f5385b = str2;
    }

    public final String d() {
        return this.f5384a;
    }

    public final String e() {
        return this.f5385b;
    }

    public final boolean f() {
        return this.f5387d;
    }

    public final boolean g() {
        return (this.f5384a == null || this.f5385b == null) ? false : true;
    }

    public final boolean h() {
        return this.f5386c;
    }
}
