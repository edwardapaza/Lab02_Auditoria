package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.ListIterator;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzamf  reason: invalid package */
/* loaded from: classes.dex */
final class zzamf implements ListIterator<String> {
    private ListIterator<String> zza;
    private final /* synthetic */ int zzb;
    private final /* synthetic */ zzamg zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzamf(zzamg zzamgVar, int i5) {
        zzajq zzajqVar;
        this.zzb = i5;
        this.zzc = zzamgVar;
        zzajqVar = zzamgVar.zza;
        this.zza = zzajqVar.listIterator(i5);
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void add(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.zza.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* synthetic */ Object next() {
        return this.zza.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.zza.nextIndex();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ String previous() {
        return this.zza.previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.zza.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void set(String str) {
        throw new UnsupportedOperationException();
    }
}
