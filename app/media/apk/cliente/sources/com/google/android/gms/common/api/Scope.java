package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.q;
/* loaded from: classes.dex */
public final class Scope extends m0.a implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new n();

    /* renamed from: a  reason: collision with root package name */
    final int f873a;

    /* renamed from: b  reason: collision with root package name */
    private final String f874b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Scope(int i5, String str) {
        q.f(str, "scopeUri must not be null or empty");
        this.f873a = i5;
        this.f874b = str;
    }

    public Scope(String str) {
        this(1, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Scope) {
            return this.f874b.equals(((Scope) obj).f874b);
        }
        return false;
    }

    public int hashCode() {
        return this.f874b.hashCode();
    }

    public String t() {
        return this.f874b;
    }

    public String toString() {
        return this.f874b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        int i6 = this.f873a;
        int a5 = m0.c.a(parcel);
        m0.c.g(parcel, 1, i6);
        m0.c.l(parcel, 2, t(), false);
        m0.c.b(parcel, a5);
    }
}
