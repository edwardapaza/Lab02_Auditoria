package com.google.firebase.firestore;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class z extends f1.l {

    /* renamed from: a  reason: collision with root package name */
    private final a f1808a;

    /* loaded from: classes.dex */
    public enum a {
        OK(0),
        CANCELLED(1),
        UNKNOWN(2),
        INVALID_ARGUMENT(3),
        DEADLINE_EXCEEDED(4),
        NOT_FOUND(5),
        ALREADY_EXISTS(6),
        PERMISSION_DENIED(7),
        RESOURCE_EXHAUSTED(8),
        FAILED_PRECONDITION(9),
        ABORTED(10),
        OUT_OF_RANGE(11),
        UNIMPLEMENTED(12),
        INTERNAL(13),
        UNAVAILABLE(14),
        DATA_LOSS(15),
        UNAUTHENTICATED(16);
        

        /* renamed from: w  reason: collision with root package name */
        private static final SparseArray<a> f1826w = a();

        /* renamed from: a  reason: collision with root package name */
        private final int f1828a;

        a(int i5) {
            this.f1828a = i5;
        }

        private static SparseArray<a> a() {
            a[] values;
            SparseArray<a> sparseArray = new SparseArray<>();
            for (a aVar : values()) {
                a aVar2 = sparseArray.get(aVar.d());
                if (aVar2 != null) {
                    throw new IllegalStateException("Code value duplication between " + aVar2 + "&" + aVar.name());
                }
                sparseArray.put(aVar.d(), aVar);
            }
            return sparseArray;
        }

        public static a c(int i5) {
            return f1826w.get(i5, UNKNOWN);
        }

        public int d() {
            return this.f1828a;
        }
    }

    public z(String str, a aVar) {
        super(str);
        z1.y.c(str, "Provided message must not be null.");
        z1.b.d(aVar != a.OK, "A FirebaseFirestoreException should never be thrown for OK", new Object[0]);
        this.f1808a = (a) z1.y.c(aVar, "Provided code must not be null.");
    }

    public z(String str, a aVar, Throwable th) {
        super(str, th);
        z1.y.c(str, "Provided message must not be null.");
        z1.b.d(aVar != a.OK, "A FirebaseFirestoreException should never be thrown for OK", new Object[0]);
        this.f1808a = (a) z1.y.c(aVar, "Provided code must not be null.");
    }

    public a a() {
        return this.f1808a;
    }
}
