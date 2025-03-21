package com.google.android.recaptcha.internal;

import java.net.ConnectException;
import java.net.Socket;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class zzej implements zzen {
    private static final boolean zzb(int i5) {
        try {
            new Socket("localhost", i5).close();
            return true;
        } catch (ConnectException unused) {
            return false;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzen
    public final /* synthetic */ Object cs(Object[] objArr) {
        return zzel.zza(this, objArr);
    }

    @Override // com.google.android.recaptcha.internal.zzen
    public final Object zza(Object... objArr) {
        ArrayList<Number> arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            if (true != (obj instanceof Integer)) {
                obj = null;
            }
            Integer num = (Integer) obj;
            if (num == null) {
                throw new zzae(4, 5, null);
            }
            arrayList.add(Integer.valueOf(num.intValue()));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Number number : arrayList) {
            int intValue = number.intValue();
            if (zzb(intValue)) {
                arrayList2.add(Integer.valueOf(intValue));
            }
        }
        return arrayList2;
    }
}
