package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class q0 {

    /* loaded from: classes.dex */
    public static class a extends m0.a {
        public static final Parcelable.Creator<a> CREATOR = new e2();

        public static a t() {
            return new a();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            m0.c.b(parcel, m0.c.a(parcel));
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b {
        private static final o0.a zza = new o0.a("PhoneAuthProvider", new String[0]);

        public void onCodeAutoRetrievalTimeOut(String str) {
            zza.e("Sms auto retrieval timed-out.", new Object[0]);
        }

        public void onCodeSent(String str, a aVar) {
        }

        public abstract void onVerificationCompleted(o0 o0Var);

        public abstract void onVerificationFailed(f1.l lVar);
    }

    public static o0 a(String str, String str2) {
        return o0.x(str, str2);
    }

    public static void b(p0 p0Var) {
        com.google.android.gms.common.internal.q.k(p0Var);
        FirebaseAuth.j0(p0Var);
    }
}
