package com.google.android.gms.internal.p001firebaseauthapi;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaj  reason: invalid package */
/* loaded from: classes.dex */
final class zzaj {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i5, String str) {
        if (i5 >= 0) {
            return i5;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(Object obj, Object obj2) {
        if (obj == null) {
            String valueOf = String.valueOf(obj2);
            throw new NullPointerException("null key in entry: null=" + valueOf);
        } else if (obj2 != null) {
        } else {
            String valueOf2 = String.valueOf(obj);
            throw new NullPointerException("null value in entry: " + valueOf2 + "=null");
        }
    }
}
