package com.google.android.gms.internal.common;

import java.io.IOException;
import java.util.Iterator;
/* loaded from: classes.dex */
final class zzv implements Iterable {
    final /* synthetic */ CharSequence zza;
    final /* synthetic */ zzx zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzv(zzx zzxVar, CharSequence charSequence) {
        this.zzb = zzxVar;
        this.zza = charSequence;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        Iterator zzh;
        zzh = this.zzb.zzh(this.zza);
        return zzh;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Iterator it = iterator();
        try {
            if (it.hasNext()) {
                CharSequence zza = zzq.zza(it.next(), ", ");
                while (true) {
                    sb.append(zza);
                    if (!it.hasNext()) {
                        break;
                    }
                    sb.append((CharSequence) ", ");
                    zza = zzq.zza(it.next(), ", ");
                }
            }
            sb.append(']');
            return sb.toString();
        } catch (IOException e5) {
            throw new AssertionError(e5);
        }
    }
}
