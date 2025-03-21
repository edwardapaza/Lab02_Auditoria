package com.google.android.recaptcha.internal;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
/* loaded from: classes.dex */
public final class zzfl extends zzfp implements Serializable {
    final int zza;
    private final Queue zzb;

    private zzfl(int i5) {
        if (i5 < 0) {
            throw new IllegalArgumentException(zzfi.zza("maxSize (%s) must >= 0", Integer.valueOf(i5)));
        }
        this.zzb = new ArrayDeque(i5);
        this.zza = i5;
    }

    public static zzfl zza(int i5) {
        return new zzfl(i5);
    }

    @Override // com.google.android.recaptcha.internal.zzfn, java.util.Collection, java.util.Queue
    public final boolean add(Object obj) {
        obj.getClass();
        if (this.zza == 0) {
            return true;
        }
        if (size() == this.zza) {
            this.zzb.remove();
        }
        this.zzb.add(obj);
        return true;
    }

    @Override // com.google.android.recaptcha.internal.zzfn, java.util.Collection
    public final boolean addAll(Collection collection) {
        Iterator it;
        int size = collection.size();
        if (size >= this.zza) {
            clear();
            int i5 = size - this.zza;
            zzff.zzb(i5 >= 0, "number to skip cannot be negative");
            it = new zzfr(collection, i5).iterator();
        } else {
            it = collection.iterator();
        }
        return zzfs.zza(this, it);
    }

    @Override // com.google.android.recaptcha.internal.zzfp, java.util.Queue
    public final boolean offer(Object obj) {
        add(obj);
        return true;
    }

    @Override // com.google.android.recaptcha.internal.zzfn, com.google.android.recaptcha.internal.zzfo
    protected final /* synthetic */ Object zzb() {
        return this.zzb;
    }

    @Override // com.google.android.recaptcha.internal.zzfp, com.google.android.recaptcha.internal.zzfn
    protected final /* synthetic */ Collection zzc() {
        return this.zzb;
    }

    @Override // com.google.android.recaptcha.internal.zzfp
    protected final Queue zzd() {
        return this.zzb;
    }
}
