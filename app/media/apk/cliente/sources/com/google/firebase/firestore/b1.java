package com.google.firebase.firestore;

import android.app.Activity;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class b1 {

    /* renamed from: a  reason: collision with root package name */
    private final p0 f1668a;

    /* renamed from: b  reason: collision with root package name */
    private final f0 f1669b;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f1670c;

    /* renamed from: d  reason: collision with root package name */
    private final Activity f1671d;

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private p0 f1672a = p0.EXCLUDE;

        /* renamed from: b  reason: collision with root package name */
        private f0 f1673b = f0.DEFAULT;

        /* renamed from: c  reason: collision with root package name */
        private Executor f1674c = z1.p.f8960a;

        /* renamed from: d  reason: collision with root package name */
        private Activity f1675d = null;

        public b1 e() {
            return new b1(this);
        }

        public b f(p0 p0Var) {
            z1.y.c(p0Var, "metadataChanges must not be null.");
            this.f1672a = p0Var;
            return this;
        }

        public b g(f0 f0Var) {
            z1.y.c(f0Var, "listen source must not be null.");
            this.f1673b = f0Var;
            return this;
        }
    }

    private b1(b bVar) {
        this.f1668a = bVar.f1672a;
        this.f1669b = bVar.f1673b;
        this.f1670c = bVar.f1674c;
        this.f1671d = bVar.f1675d;
    }

    public Activity a() {
        return this.f1671d;
    }

    public Executor b() {
        return this.f1670c;
    }

    public p0 c() {
        return this.f1668a;
    }

    public f0 d() {
        return this.f1669b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b1.class != obj.getClass()) {
            return false;
        }
        b1 b1Var = (b1) obj;
        return this.f1668a == b1Var.f1668a && this.f1669b == b1Var.f1669b && this.f1670c.equals(b1Var.f1670c) && this.f1671d.equals(b1Var.f1671d);
    }

    public int hashCode() {
        int hashCode = ((((this.f1668a.hashCode() * 31) + this.f1669b.hashCode()) * 31) + this.f1670c.hashCode()) * 31;
        Activity activity = this.f1671d;
        return hashCode + (activity != null ? activity.hashCode() : 0);
    }

    public String toString() {
        return "SnapshotListenOptions{metadataChanges=" + this.f1668a + ", source=" + this.f1669b + ", executor=" + this.f1670c + ", activity=" + this.f1671d + '}';
    }
}
