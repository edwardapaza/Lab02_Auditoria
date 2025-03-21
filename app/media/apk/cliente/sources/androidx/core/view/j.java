package androidx.core.view;

import android.os.Build;
import android.view.View;
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    private final c f485a;

    /* loaded from: classes.dex */
    private static class a extends c {

        /* renamed from: a  reason: collision with root package name */
        private final View f486a;

        a(View view) {
            this.f486a = view;
        }
    }

    /* loaded from: classes.dex */
    private static class b extends a {

        /* renamed from: b  reason: collision with root package name */
        private View f487b;

        b(View view) {
            super(view);
            this.f487b = view;
        }
    }

    /* loaded from: classes.dex */
    private static class c {
        c() {
        }
    }

    public j(View view) {
        this.f485a = Build.VERSION.SDK_INT >= 30 ? new b(view) : new a(view);
    }
}
