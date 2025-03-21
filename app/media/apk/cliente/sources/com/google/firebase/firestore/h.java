package com.google.firebase.firestore;

import java.util.ArrayList;
import java.util.List;
import s1.m;
import s1.x1;
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private final b f1697a;

    /* renamed from: b  reason: collision with root package name */
    private final x0 f1698b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1699c;

    /* renamed from: d  reason: collision with root package name */
    private final int f1700d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1701a;

        static {
            int[] iArr = new int[m.a.values().length];
            f1701a = iArr;
            try {
                iArr[m.a.ADDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1701a[m.a.METADATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1701a[m.a.MODIFIED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1701a[m.a.REMOVED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum b {
        ADDED,
        MODIFIED,
        REMOVED
    }

    h(x0 x0Var, b bVar, int i5, int i6) {
        this.f1697a = bVar;
        this.f1698b = x0Var;
        this.f1699c = i5;
        this.f1700d = i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<h> a(FirebaseFirestore firebaseFirestore, p0 p0Var, x1 x1Var) {
        int i5;
        int i6;
        ArrayList arrayList = new ArrayList();
        if (x1Var.g().isEmpty()) {
            v1.i iVar = null;
            int i7 = 0;
            for (s1.m mVar : x1Var.d()) {
                v1.i b5 = mVar.b();
                x0 h5 = x0.h(firebaseFirestore, b5, x1Var.k(), x1Var.f().contains(b5.getKey()));
                z1.b.d(mVar.c() == m.a.ADDED, "Invalid added event for first snapshot", new Object[0]);
                z1.b.d(iVar == null || x1Var.h().c().compare(iVar, b5) < 0, "Got added events in wrong order", new Object[0]);
                arrayList.add(new h(h5, b.ADDED, -1, i7));
                iVar = b5;
                i7++;
            }
        } else {
            v1.n g5 = x1Var.g();
            for (s1.m mVar2 : x1Var.d()) {
                if (p0Var != p0.EXCLUDE || mVar2.c() != m.a.METADATA) {
                    v1.i b6 = mVar2.b();
                    x0 h6 = x0.h(firebaseFirestore, b6, x1Var.k(), x1Var.f().contains(b6.getKey()));
                    b f5 = f(mVar2);
                    if (f5 != b.ADDED) {
                        i5 = g5.n(b6.getKey());
                        z1.b.d(i5 >= 0, "Index for document not found", new Object[0]);
                        g5 = g5.p(b6.getKey());
                    } else {
                        i5 = -1;
                    }
                    if (f5 != b.REMOVED) {
                        g5 = g5.h(b6);
                        i6 = g5.n(b6.getKey());
                        z1.b.d(i6 >= 0, "Index for document not found", new Object[0]);
                    } else {
                        i6 = -1;
                    }
                    arrayList.add(new h(h6, f5, i5, i6));
                }
            }
        }
        return arrayList;
    }

    private static b f(s1.m mVar) {
        int i5 = a.f1701a[mVar.c().ordinal()];
        if (i5 != 1) {
            if (i5 == 2 || i5 == 3) {
                return b.MODIFIED;
            }
            if (i5 == 4) {
                return b.REMOVED;
            }
            throw new IllegalArgumentException("Unknown view change type: " + mVar.c());
        }
        return b.ADDED;
    }

    public x0 b() {
        return this.f1698b;
    }

    public int c() {
        return this.f1700d;
    }

    public int d() {
        return this.f1699c;
    }

    public b e() {
        return this.f1697a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof h) {
            h hVar = (h) obj;
            return this.f1697a.equals(hVar.f1697a) && this.f1698b.equals(hVar.f1698b) && this.f1699c == hVar.f1699c && this.f1700d == hVar.f1700d;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f1697a.hashCode() * 31) + this.f1698b.hashCode()) * 31) + this.f1699c) * 31) + this.f1700d;
    }
}
