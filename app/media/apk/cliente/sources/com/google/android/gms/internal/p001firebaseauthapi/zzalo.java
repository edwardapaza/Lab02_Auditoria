package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzalo  reason: invalid package */
/* loaded from: classes.dex */
public final class zzalo implements Comparable, Map.Entry {
    private final Comparable zza;
    private Object zzb;
    private final /* synthetic */ zzalh zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzalo(zzalh zzalhVar, Comparable comparable, Object obj) {
        this.zzc = zzalhVar;
        this.zza = comparable;
        this.zzb = obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzalo(zzalh zzalhVar, Map.Entry entry) {
        this(zzalhVar, (Comparable) entry.getKey(), entry.getValue());
    }

    private static boolean zza(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        return ((Comparable) getKey()).compareTo((Comparable) ((zzalo) obj).getKey());
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            return zza(this.zza, entry.getKey()) && zza(this.zzb, entry.getValue());
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.zza;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.zzb;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.zza;
        int hashCode = comparable == null ? 0 : comparable.hashCode();
        Object obj = this.zzb;
        return hashCode ^ (obj != null ? obj.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        this.zzc.zzg();
        Object obj2 = this.zzb;
        this.zzb = obj;
        return obj2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        String valueOf2 = String.valueOf(this.zzb);
        return valueOf + "=" + valueOf2;
    }
}
