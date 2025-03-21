package c2;

import com.google.android.gms.common.internal.p;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private String f851a;

    public b(String str) {
        this.f851a = str;
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            return p.a(this.f851a, ((b) obj).f851a);
        }
        return false;
    }

    public int hashCode() {
        return p.b(this.f851a);
    }

    public String toString() {
        return p.c(this).a("token", this.f851a).toString();
    }
}
