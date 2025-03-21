package com.google.android.gms.common.api.internal;

import android.os.Looper;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class j<L> {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f978a;

    /* renamed from: b  reason: collision with root package name */
    private volatile L f979b;

    /* renamed from: c  reason: collision with root package name */
    private volatile a<L> f980c;

    /* loaded from: classes.dex */
    public static final class a<L> {

        /* renamed from: a  reason: collision with root package name */
        private final L f981a;

        /* renamed from: b  reason: collision with root package name */
        private final String f982b;

        a(L l5, String str) {
            this.f981a = l5;
            this.f982b = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.f981a == aVar.f981a && this.f982b.equals(aVar.f982b);
            }
            return false;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f981a) * 31) + this.f982b.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Looper looper, L l5, String str) {
        this.f978a = new r0.a(looper);
        this.f979b = (L) com.google.android.gms.common.internal.q.l(l5, "Listener must not be null");
        this.f980c = new a<>(l5, com.google.android.gms.common.internal.q.e(str));
    }
}
