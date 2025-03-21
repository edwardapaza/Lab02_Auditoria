package androidx.core.app;

import android.content.res.Configuration;
/* loaded from: classes.dex */
public final class u0 {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f361a;

    /* renamed from: b  reason: collision with root package name */
    private Configuration f362b;

    public u0(boolean z4) {
        this.f361a = z4;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public u0(boolean z4, Configuration configuration) {
        this(z4);
        e4.k.e(configuration, "newConfig");
        this.f362b = configuration;
    }

    public final boolean a() {
        return this.f361a;
    }
}
