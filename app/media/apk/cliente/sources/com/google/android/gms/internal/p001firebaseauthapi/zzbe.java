package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Iterator;
import java.util.Set;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbe  reason: invalid package */
/* loaded from: classes.dex */
public final class zzbe {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(Set<?> set) {
        Iterator<?> it = set.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i5 = ~(~(i5 + (next != null ? next.hashCode() : 0)));
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zza(Set<?> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }
}
