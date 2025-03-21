package com.google.android.recaptcha.internal;
/* loaded from: classes.dex */
public abstract class zzfm implements Iterable {
    private final zzfe zza = zzfe.zza();

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        boolean z4 = true;
        for (Object obj : this) {
            if (!z4) {
                sb.append(", ");
            }
            sb.append(obj);
            z4 = false;
        }
        sb.append(']');
        return sb.toString();
    }
}
