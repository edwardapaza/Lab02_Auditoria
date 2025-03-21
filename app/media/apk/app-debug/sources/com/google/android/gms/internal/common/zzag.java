package com.google.android.gms.internal.common;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;
import org.jspecify.nullness.NullMarked;
/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
@NullMarked
/* loaded from: classes.dex */
public abstract class zzag extends zzac implements List, RandomAccess {
    private static final zzak zza = new zzae(zzai.zza, 0);

    static zzag zzi(Object[] objArr, int i) {
        return i == 0 ? zzai.zza : new zzai(objArr, i);
    }

    public static zzag zzj(Iterable iterable) {
        if (iterable != null) {
            if (iterable instanceof Collection) {
                return zzk((Collection) iterable);
            }
            Iterator it = iterable.iterator();
            if (!it.hasNext()) {
                return zzai.zza;
            }
            Object next = it.next();
            if (!it.hasNext()) {
                return zzm(next);
            }
            zzad zzadVar = new zzad(4);
            zzadVar.zzb(next);
            zzadVar.zzc(it);
            zzadVar.zzc = true;
            return zzi(zzadVar.zza, zzadVar.zzb);
        }
        throw null;
    }

    public static zzag zzk(Collection collection) {
        if (!(collection instanceof zzac)) {
            Object[] array = collection.toArray();
            int length = array.length;
            zzah.zza(array, length);
            return zzi(array, length);
        }
        zzag zzd = ((zzac) collection).zzd();
        if (zzd.zzf()) {
            Object[] array2 = zzd.toArray();
            return zzi(array2, array2.length);
        }
        return zzd;
    }

    public static zzag zzl() {
        return zzai.zza;
    }

    public static zzag zzm(Object obj) {
        Object[] objArr = {obj};
        zzah.zza(objArr, 1);
        return zzi(objArr, 1);
    }

    public static zzag zzn(Object obj, Object obj2) {
        Object[] objArr = {obj, obj2};
        zzah.zza(objArr, 2);
        return zzi(objArr, 2);
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(@CheckForNull Object obj) {
        return indexOf(obj) >= 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0042  */
    @Override // java.util.Collection, java.util.List
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(@javax.annotation.CheckForNull java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            r1 = 0
            if (r7 != r6) goto L5
            goto L62
        L5:
            boolean r2 = r7 instanceof java.util.List
            if (r2 != 0) goto Lb
            r0 = 0
            goto L62
        Lb:
            java.util.List r7 = (java.util.List) r7
            int r2 = r6.size()
            int r3 = r7.size()
            if (r2 == r3) goto L19
            r0 = 0
            goto L62
        L19:
            boolean r3 = r7 instanceof java.util.RandomAccess
            if (r3 == 0) goto L34
            r3 = 0
        L1e:
            if (r3 >= r2) goto L33
            java.lang.Object r4 = r6.get(r3)
            java.lang.Object r5 = r7.get(r3)
            boolean r4 = com.google.android.gms.internal.common.zzr.zza(r4, r5)
            if (r4 != 0) goto L30
            r0 = 0
            goto L62
        L30:
            int r3 = r3 + 1
            goto L1e
        L33:
            goto L62
        L34:
            java.util.Iterator r2 = r6.iterator()
            java.util.Iterator r7 = r7.iterator()
        L3c:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L5a
            boolean r3 = r7.hasNext()
            if (r3 != 0) goto L4a
            r0 = 0
            goto L62
        L4a:
            java.lang.Object r3 = r2.next()
            java.lang.Object r4 = r7.next()
            boolean r3 = com.google.android.gms.internal.common.zzr.zza(r3, r4)
            if (r3 != 0) goto L3c
            r0 = 0
            goto L62
        L5a:
            boolean r7 = r7.hasNext()
            if (r7 != 0) goto L61
            goto L62
        L61:
            r0 = 0
        L62:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.common.zzag.equals(java.lang.Object):boolean");
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    @Override // java.util.List
    public final int indexOf(@CheckForNull Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (obj.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.common.zzac, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final int lastIndexOf(@CheckForNull Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    @Deprecated
    public final Object remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final Object set(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.common.zzac
    int zza(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i2] = get(i2);
        }
        return size;
    }

    @Override // com.google.android.gms.internal.common.zzac
    @Deprecated
    public final zzag zzd() {
        return this;
    }

    @Override // com.google.android.gms.internal.common.zzac
    public final zzaj zze() {
        return listIterator(0);
    }

    @Override // java.util.List
    /* renamed from: zzh */
    public zzag subList(int i, int i2) {
        zzs.zzc(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        if (i3 != 0) {
            return new zzaf(this, i, i3);
        }
        return zzai.zza;
    }

    @Override // java.util.List
    /* renamed from: zzo */
    public final zzak listIterator(int i) {
        zzs.zzb(i, size(), "index");
        return isEmpty() ? zza : new zzae(this, i);
    }
}
