package j1;

import android.text.TextUtils;
import com.google.android.gms.internal.p001firebaseauthapi.zzafq;
import com.google.android.gms.internal.p001firebaseauthapi.zzagq;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class n0 {
    public static com.google.firebase.auth.j0 a(zzafq zzafqVar) {
        if (zzafqVar == null) {
            return null;
        }
        if (TextUtils.isEmpty(zzafqVar.zze())) {
            if (zzafqVar.zzb() != null) {
                return new com.google.firebase.auth.z0(zzafqVar.zzd(), zzafqVar.zzc(), zzafqVar.zza(), (zzagq) com.google.android.gms.common.internal.q.l(zzafqVar.zzb(), "totpInfo cannot be null."));
            }
            return null;
        }
        return new com.google.firebase.auth.t0(zzafqVar.zzd(), zzafqVar.zzc(), zzafqVar.zza(), com.google.android.gms.common.internal.q.e(zzafqVar.zze()));
    }

    public static List<com.google.firebase.auth.j0> b(List<zzafq> list) {
        if (list == null || list.isEmpty()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (zzafq zzafqVar : list) {
            com.google.firebase.auth.j0 a5 = a(zzafqVar);
            if (a5 != null) {
                arrayList.add(a5);
            }
        }
        return arrayList;
    }
}
