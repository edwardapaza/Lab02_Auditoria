package androidx.core.os;

import android.os.LocaleList;
import java.util.Locale;
/* loaded from: classes.dex */
final class k implements j {

    /* renamed from: a  reason: collision with root package name */
    private final LocaleList f436a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Object obj) {
        this.f436a = (LocaleList) obj;
    }

    @Override // androidx.core.os.j
    public Object a() {
        return this.f436a;
    }

    public boolean equals(Object obj) {
        return this.f436a.equals(((j) obj).a());
    }

    @Override // androidx.core.os.j
    public Locale get(int i5) {
        return this.f436a.get(i5);
    }

    public int hashCode() {
        return this.f436a.hashCode();
    }

    @Override // androidx.core.os.j
    public boolean isEmpty() {
        return this.f436a.isEmpty();
    }

    public String toString() {
        return this.f436a.toString();
    }
}
