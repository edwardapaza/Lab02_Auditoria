package androidx.core.app;

import android.annotation.NonNull;
import android.annotation.Nullable;
import android.app.Person;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import java.util.Objects;
/* loaded from: classes.dex */
public class t0 {

    /* renamed from: a  reason: collision with root package name */
    CharSequence f340a;

    /* renamed from: b  reason: collision with root package name */
    IconCompat f341b;

    /* renamed from: c  reason: collision with root package name */
    String f342c;

    /* renamed from: d  reason: collision with root package name */
    String f343d;

    /* renamed from: e  reason: collision with root package name */
    boolean f344e;

    /* renamed from: f  reason: collision with root package name */
    boolean f345f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        static t0 a(Person person) {
            return new b().f(person.getName()).c(person.getIcon() != null ? IconCompat.a(person.getIcon()) : null).g(person.getUri()).e(person.getKey()).b(person.isBot()).d(person.isImportant()).a();
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [android.app.Person$Builder] */
        static Person b(t0 t0Var) {
            return new Object() { // from class: android.app.Person.Builder
                static {
                    throw new NoClassDefFoundError();
                }

                @NonNull
                public native /* synthetic */ Person build();

                @NonNull
                public native /* synthetic */ Builder setBot(boolean z4);

                @NonNull
                public native /* synthetic */ Builder setIcon(@Nullable Icon icon);

                @NonNull
                public native /* synthetic */ Builder setImportant(boolean z4);

                @NonNull
                public native /* synthetic */ Builder setKey(@Nullable String str);

                @NonNull
                public native /* synthetic */ Builder setName(@Nullable CharSequence charSequence);

                @NonNull
                public native /* synthetic */ Builder setUri(@Nullable String str);
            }.setName(t0Var.c()).setIcon(t0Var.a() != null ? t0Var.a().r() : null).setUri(t0Var.d()).setKey(t0Var.b()).setBot(t0Var.e()).setImportant(t0Var.f()).build();
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        CharSequence f346a;

        /* renamed from: b  reason: collision with root package name */
        IconCompat f347b;

        /* renamed from: c  reason: collision with root package name */
        String f348c;

        /* renamed from: d  reason: collision with root package name */
        String f349d;

        /* renamed from: e  reason: collision with root package name */
        boolean f350e;

        /* renamed from: f  reason: collision with root package name */
        boolean f351f;

        public t0 a() {
            return new t0(this);
        }

        public b b(boolean z4) {
            this.f350e = z4;
            return this;
        }

        public b c(IconCompat iconCompat) {
            this.f347b = iconCompat;
            return this;
        }

        public b d(boolean z4) {
            this.f351f = z4;
            return this;
        }

        public b e(String str) {
            this.f349d = str;
            return this;
        }

        public b f(CharSequence charSequence) {
            this.f346a = charSequence;
            return this;
        }

        public b g(String str) {
            this.f348c = str;
            return this;
        }
    }

    t0(b bVar) {
        this.f340a = bVar.f346a;
        this.f341b = bVar.f347b;
        this.f342c = bVar.f348c;
        this.f343d = bVar.f349d;
        this.f344e = bVar.f350e;
        this.f345f = bVar.f351f;
    }

    public IconCompat a() {
        return this.f341b;
    }

    public String b() {
        return this.f343d;
    }

    public CharSequence c() {
        return this.f340a;
    }

    public String d() {
        return this.f342c;
    }

    public boolean e() {
        return this.f344e;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof t0)) {
            t0 t0Var = (t0) obj;
            String b5 = b();
            String b6 = t0Var.b();
            return (b5 == null && b6 == null) ? Objects.equals(Objects.toString(c()), Objects.toString(t0Var.c())) && Objects.equals(d(), t0Var.d()) && Objects.equals(Boolean.valueOf(e()), Boolean.valueOf(t0Var.e())) && Objects.equals(Boolean.valueOf(f()), Boolean.valueOf(t0Var.f())) : Objects.equals(b5, b6);
        }
        return false;
    }

    public boolean f() {
        return this.f345f;
    }

    public String g() {
        String str = this.f342c;
        if (str != null) {
            return str;
        }
        if (this.f340a != null) {
            return "name:" + ((Object) this.f340a);
        }
        return "";
    }

    public Person h() {
        return a.b(this);
    }

    public int hashCode() {
        String b5 = b();
        return b5 != null ? b5.hashCode() : Objects.hash(c(), d(), Boolean.valueOf(e()), Boolean.valueOf(f()));
    }

    public Bundle i() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence("name", this.f340a);
        IconCompat iconCompat = this.f341b;
        bundle.putBundle("icon", iconCompat != null ? iconCompat.q() : null);
        bundle.putString("uri", this.f342c);
        bundle.putString("key", this.f343d);
        bundle.putBoolean("isBot", this.f344e);
        bundle.putBoolean("isImportant", this.f345f);
        return bundle;
    }
}
