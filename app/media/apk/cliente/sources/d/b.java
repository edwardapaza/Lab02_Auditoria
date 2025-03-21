package d;

import android.content.Context;
import android.content.Intent;
import d.a;
import e4.g;
import e4.k;
import h4.l;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import s3.p;
import t3.g0;
import t3.h0;
import t3.x;
/* loaded from: classes.dex */
public final class b extends d.a<String[], Map<String, Boolean>> {

    /* renamed from: a  reason: collision with root package name */
    public static final a f2247a = new a(null);

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final Intent a(String[] strArr) {
            k.e(strArr, "input");
            Intent putExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr);
            k.d(putExtra, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
            return putExtra;
        }
    }

    @Override // d.a
    /* renamed from: d */
    public Intent a(Context context, String[] strArr) {
        k.e(context, "context");
        k.e(strArr, "input");
        return f2247a.a(strArr);
    }

    @Override // d.a
    /* renamed from: e */
    public a.C0046a<Map<String, Boolean>> b(Context context, String[] strArr) {
        int a5;
        int a6;
        Map d5;
        k.e(context, "context");
        k.e(strArr, "input");
        boolean z4 = true;
        if (strArr.length == 0) {
            d5 = h0.d();
            return new a.C0046a<>(d5);
        }
        int length = strArr.length;
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                break;
            }
            if (!(androidx.core.content.a.checkSelfPermission(context, strArr[i5]) == 0)) {
                z4 = false;
                break;
            }
            i5++;
        }
        if (z4) {
            a5 = g0.a(strArr.length);
            a6 = l.a(a5, 16);
            LinkedHashMap linkedHashMap = new LinkedHashMap(a6);
            for (String str : strArr) {
                s3.l a7 = p.a(str, Boolean.TRUE);
                linkedHashMap.put(a7.c(), a7.d());
            }
            return new a.C0046a<>(linkedHashMap);
        }
        return null;
    }

    @Override // d.a
    /* renamed from: f */
    public Map<String, Boolean> c(int i5, Intent intent) {
        Map<String, Boolean> d5;
        List i6;
        List N;
        Map<String, Boolean> j5;
        Map<String, Boolean> d6;
        Map<String, Boolean> d7;
        if (i5 != -1) {
            d7 = h0.d();
            return d7;
        } else if (intent == null) {
            d6 = h0.d();
            return d6;
        } else {
            String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
            if (intArrayExtra == null || stringArrayExtra == null) {
                d5 = h0.d();
                return d5;
            }
            ArrayList arrayList = new ArrayList(intArrayExtra.length);
            for (int i7 : intArrayExtra) {
                arrayList.add(Boolean.valueOf(i7 == 0));
            }
            i6 = t3.k.i(stringArrayExtra);
            N = x.N(i6, arrayList);
            j5 = h0.j(N);
            return j5;
        }
    }
}
