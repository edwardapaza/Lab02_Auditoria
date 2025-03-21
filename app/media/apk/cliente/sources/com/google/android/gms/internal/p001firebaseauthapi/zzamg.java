package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
@Deprecated
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzamg  reason: invalid package */
/* loaded from: classes.dex */
public final class zzamg extends AbstractList<String> implements zzajq, RandomAccess {
    private final zzajq zza;

    public zzamg(zzajq zzajqVar) {
        this.zza = zzajqVar;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzajq
    public final zzajq a_() {
        return this;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i5) {
        return (String) this.zza.get(i5);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<String> iterator() {
        return new zzami(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<String> listIterator(int i5) {
        return new zzamf(this, i5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzajq
    public final void zza(zzahm zzahmVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzajq
    public final Object zzb(int i5) {
        return this.zza.zzb(i5);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzajq
    public final List<?> zzb() {
        return this.zza.zzb();
    }
}
