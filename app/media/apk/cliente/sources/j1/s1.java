package j1;
/* loaded from: classes.dex */
final class s1 extends o1 {

    /* renamed from: a  reason: collision with root package name */
    private final String f5471a;

    /* renamed from: b  reason: collision with root package name */
    private final String f5472b;

    /* renamed from: c  reason: collision with root package name */
    private final String f5473c;

    private s1(String str, String str2, String str3) {
        this.f5471a = str;
        this.f5472b = str2;
        this.f5473c = str3;
    }

    @Override // j1.o1
    public final String a() {
        return this.f5472b;
    }

    @Override // j1.o1
    public final String b() {
        return this.f5473c;
    }

    @Override // j1.o1
    public final String c() {
        return this.f5471a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof o1) {
            o1 o1Var = (o1) obj;
            String str = this.f5471a;
            if (str != null ? str.equals(o1Var.c()) : o1Var.c() == null) {
                String str2 = this.f5472b;
                if (str2 != null ? str2.equals(o1Var.a()) : o1Var.a() == null) {
                    String str3 = this.f5473c;
                    String b5 = o1Var.b();
                    if (str3 != null ? str3.equals(b5) : b5 == null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f5471a;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.f5472b;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f5473c;
        return hashCode2 ^ (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        String str = this.f5471a;
        String str2 = this.f5472b;
        String str3 = this.f5473c;
        return "AttestationResult{recaptchaV2Token=" + str + ", playIntegrityToken=" + str2 + ", recaptchaEnterpriseToken=" + str3 + "}";
    }
}
