package q1;
/* loaded from: classes.dex */
public final class j {

    /* renamed from: b  reason: collision with root package name */
    public static final j f6951b = new j(null);

    /* renamed from: a  reason: collision with root package name */
    private final String f6952a;

    public j(String str) {
        this.f6952a = str;
    }

    public String a() {
        return this.f6952a;
    }

    public boolean b() {
        return this.f6952a != null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j.class != obj.getClass()) {
            return false;
        }
        String str = this.f6952a;
        String str2 = ((j) obj).f6952a;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        String str = this.f6952a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "User(uid:" + this.f6952a + ")";
    }
}
