package androidx.core.app;

import android.os.Bundle;
import androidx.core.app.q;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n0 {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f268a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static final Object f269b = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bundle a(q.a aVar) {
        Bundle bundle = new Bundle();
        IconCompat d5 = aVar.d();
        bundle.putInt("icon", d5 != null ? d5.j() : 0);
        bundle.putCharSequence("title", aVar.h());
        bundle.putParcelable("actionIntent", aVar.a());
        Bundle bundle2 = aVar.c() != null ? new Bundle(aVar.c()) : new Bundle();
        bundle2.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        bundle.putBundle("extras", bundle2);
        bundle.putParcelableArray("remoteInputs", c(aVar.e()));
        bundle.putBoolean("showsUserInterface", aVar.g());
        bundle.putInt("semanticAction", aVar.f());
        return bundle;
    }

    private static Bundle b(v0 v0Var) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", v0Var.i());
        bundle.putCharSequence("label", v0Var.h());
        bundle.putCharSequenceArray("choices", v0Var.e());
        bundle.putBoolean("allowFreeFormInput", v0Var.c());
        bundle.putBundle("extras", v0Var.g());
        Set<String> d5 = v0Var.d();
        if (d5 != null && !d5.isEmpty()) {
            ArrayList<String> arrayList = new ArrayList<>(d5.size());
            for (String str : d5) {
                arrayList.add(str);
            }
            bundle.putStringArrayList("allowedDataTypes", arrayList);
        }
        return bundle;
    }

    private static Bundle[] c(v0[] v0VarArr) {
        if (v0VarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[v0VarArr.length];
        for (int i5 = 0; i5 < v0VarArr.length; i5++) {
            bundleArr[i5] = b(v0VarArr[i5]);
        }
        return bundleArr;
    }
}
