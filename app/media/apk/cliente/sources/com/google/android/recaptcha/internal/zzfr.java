package com.google.android.recaptcha.internal;

import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
final class zzfr extends zzfm {
    final /* synthetic */ Iterable zza;
    final /* synthetic */ int zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfr(Iterable iterable, int i5) {
        this.zza = iterable;
        this.zzb = i5;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        Iterable iterable = this.zza;
        if (iterable instanceof List) {
            List list = (List) iterable;
            return list.subList(Math.min(list.size(), this.zzb), list.size()).iterator();
        }
        int i5 = this.zzb;
        Iterator it = iterable.iterator();
        it.getClass();
        zzff.zzb(i5 >= 0, "numberToAdvance must be nonnegative");
        for (int i6 = 0; i6 < i5 && it.hasNext(); i6++) {
            it.next();
        }
        return new zzfq(this, it);
    }
}
