package androidx.core.app;

import android.content.res.Configuration;
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f270a;

    /* renamed from: b  reason: collision with root package name */
    private Configuration f271b;

    public o(boolean z4) {
        this.f270a = z4;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public o(boolean z4, Configuration configuration) {
        this(z4);
        e4.k.e(configuration, "newConfig");
        this.f271b = configuration;
    }

    public final boolean a() {
        return this.f270a;
    }
}
