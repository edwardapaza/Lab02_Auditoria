package com.google.firebase.firestore;

import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public abstract class r {

    /* renamed from: a  reason: collision with root package name */
    private static final c f1762a = new c();

    /* renamed from: b  reason: collision with root package name */
    private static final e f1763b = new e();

    /* loaded from: classes.dex */
    static class a extends r {

        /* renamed from: c  reason: collision with root package name */
        private final List<Object> f1764c;

        a(List<Object> list) {
            this.f1764c = list;
        }

        @Override // com.google.firebase.firestore.r
        String d() {
            return "FieldValue.arrayRemove";
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public List<Object> h() {
            return this.f1764c;
        }
    }

    /* loaded from: classes.dex */
    static class b extends r {

        /* renamed from: c  reason: collision with root package name */
        private final List<Object> f1765c;

        b(List<Object> list) {
            this.f1765c = list;
        }

        @Override // com.google.firebase.firestore.r
        String d() {
            return "FieldValue.arrayUnion";
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public List<Object> h() {
            return this.f1765c;
        }
    }

    /* loaded from: classes.dex */
    static class c extends r {
        c() {
        }

        @Override // com.google.firebase.firestore.r
        String d() {
            return "FieldValue.delete";
        }
    }

    /* loaded from: classes.dex */
    static class d extends r {

        /* renamed from: c  reason: collision with root package name */
        private final Number f1766c;

        d(Number number) {
            this.f1766c = number;
        }

        @Override // com.google.firebase.firestore.r
        String d() {
            return "FieldValue.increment";
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Number h() {
            return this.f1766c;
        }
    }

    /* loaded from: classes.dex */
    static class e extends r {
        e() {
        }

        @Override // com.google.firebase.firestore.r
        String d() {
            return "FieldValue.serverTimestamp";
        }
    }

    r() {
    }

    public static r a(Object... objArr) {
        return new a(Arrays.asList(objArr));
    }

    public static r b(Object... objArr) {
        return new b(Arrays.asList(objArr));
    }

    public static r c() {
        return f1762a;
    }

    public static r e(double d5) {
        return new d(Double.valueOf(d5));
    }

    public static r f(long j5) {
        return new d(Long.valueOf(j5));
    }

    public static r g() {
        return f1763b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract String d();
}
