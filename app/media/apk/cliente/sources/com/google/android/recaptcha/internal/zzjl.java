package com.google.android.recaptcha.internal;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
/* loaded from: classes.dex */
public final class zzjl extends zzgh implements RandomAccess, zzjm {
    @Deprecated
    public static final zzjm zza;
    private static final zzjl zzb;
    private final List zzc;

    static {
        zzjl zzjlVar = new zzjl(false);
        zzb = zzjlVar;
        zza = zzjlVar;
    }

    public zzjl() {
        this(10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzjl(int i5) {
        super(true);
        ArrayList arrayList = new ArrayList(i5);
        this.zzc = arrayList;
    }

    private zzjl(ArrayList arrayList) {
        super(true);
        this.zzc = arrayList;
    }

    private zzjl(boolean z4) {
        super(false);
        this.zzc = Collections.emptyList();
    }

    private static String zzj(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof zzgw ? ((zzgw) obj).zzn(zzjc.zzb) : zzjc.zzd((byte[]) obj);
    }

    @Override // com.google.android.recaptcha.internal.zzgh, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i5, Object obj) {
        zza();
        this.zzc.add(i5, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.recaptcha.internal.zzgh, java.util.AbstractList, java.util.List
    public final boolean addAll(int i5, Collection collection) {
        zza();
        if (collection instanceof zzjm) {
            collection = ((zzjm) collection).zzh();
        }
        boolean addAll = this.zzc.addAll(i5, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // com.google.android.recaptcha.internal.zzgh, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.android.recaptcha.internal.zzgh, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        zza();
        this.zzc.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.recaptcha.internal.zzgh, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i5) {
        zza();
        Object remove = this.zzc.remove(i5);
        ((AbstractList) this).modCount++;
        return zzj(remove);
    }

    @Override // com.google.android.recaptcha.internal.zzgh, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i5, Object obj) {
        zza();
        return zzj(this.zzc.set(i5, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc.size();
    }

    @Override // com.google.android.recaptcha.internal.zzjb
    public final /* bridge */ /* synthetic */ zzjb zzd(int i5) {
        if (i5 >= size()) {
            ArrayList arrayList = new ArrayList(i5);
            arrayList.addAll(this.zzc);
            return new zzjl(arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.recaptcha.internal.zzjm
    public final zzjm zze() {
        return zzc() ? new zzlq(this) : this;
    }

    @Override // com.google.android.recaptcha.internal.zzjm
    public final Object zzf(int i5) {
        return this.zzc.get(i5);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: zzg */
    public final String get(int i5) {
        Object obj = this.zzc.get(i5);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzgw) {
            zzgw zzgwVar = (zzgw) obj;
            String zzn = zzgwVar.zzn(zzjc.zzb);
            if (zzgwVar.zzj()) {
                this.zzc.set(i5, zzn);
            }
            return zzn;
        }
        byte[] bArr = (byte[]) obj;
        String zzd = zzjc.zzd(bArr);
        if (zzma.zze(bArr)) {
            this.zzc.set(i5, zzd);
        }
        return zzd;
    }

    @Override // com.google.android.recaptcha.internal.zzjm
    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    @Override // com.google.android.recaptcha.internal.zzjm
    public final void zzi(zzgw zzgwVar) {
        zza();
        this.zzc.add(zzgwVar);
        ((AbstractList) this).modCount++;
    }
}
