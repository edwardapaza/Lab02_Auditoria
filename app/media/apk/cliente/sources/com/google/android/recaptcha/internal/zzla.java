package com.google.android.recaptcha.internal;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
final class zzla implements Iterator {
    final /* synthetic */ zzle zza;
    private int zzb = -1;
    private boolean zzc;
    private Iterator zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzla(zzle zzleVar, zzkz zzkzVar) {
        this.zza = zzleVar;
    }

    private final Iterator zza() {
        Map map;
        if (this.zzd == null) {
            map = this.zza.zzc;
            this.zzd = map.entrySet().iterator();
        }
        return this.zzd;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        Map map;
        int i5 = this.zzb + 1;
        list = this.zza.zzb;
        if (i5 >= list.size()) {
            map = this.zza.zzc;
            return !map.isEmpty() && zza().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        List list;
        Object next;
        List list2;
        this.zzc = true;
        int i5 = this.zzb + 1;
        this.zzb = i5;
        list = this.zza.zzb;
        if (i5 < list.size()) {
            list2 = this.zza.zzb;
            next = list2.get(this.zzb);
        } else {
            next = zza().next();
        }
        return (Map.Entry) next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        List list;
        if (!this.zzc) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzc = false;
        this.zza.zzn();
        int i5 = this.zzb;
        list = this.zza.zzb;
        if (i5 >= list.size()) {
            zza().remove();
            return;
        }
        zzle zzleVar = this.zza;
        int i6 = this.zzb;
        this.zzb = i6 - 1;
        zzleVar.zzl(i6);
    }
}
