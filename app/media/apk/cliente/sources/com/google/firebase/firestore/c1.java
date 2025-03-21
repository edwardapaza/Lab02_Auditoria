package com.google.firebase.firestore;
/* loaded from: classes.dex */
public class c1 {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f1678a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f1679b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c1(boolean z4, boolean z5) {
        this.f1678a = z4;
        this.f1679b = z5;
    }

    public boolean a() {
        return this.f1678a;
    }

    public boolean b() {
        return this.f1679b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c1) {
            c1 c1Var = (c1) obj;
            return this.f1678a == c1Var.f1678a && this.f1679b == c1Var.f1679b;
        }
        return false;
    }

    public int hashCode() {
        return ((this.f1678a ? 1 : 0) * 31) + (this.f1679b ? 1 : 0);
    }

    public String toString() {
        return "SnapshotMetadata{hasPendingWrites=" + this.f1678a + ", isFromCache=" + this.f1679b + '}';
    }
}
