package androidx.lifecycle;

import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class l0 {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, h0> f564a = new LinkedHashMap();

    public final void a() {
        for (h0 h0Var : this.f564a.values()) {
            h0Var.a();
        }
        this.f564a.clear();
    }

    public final h0 b(String str) {
        e4.k.e(str, "key");
        return this.f564a.get(str);
    }

    public final void c(String str, h0 h0Var) {
        e4.k.e(str, "key");
        e4.k.e(h0Var, "viewModel");
        h0 put = this.f564a.put(str, h0Var);
        if (put != null) {
            put.c();
        }
    }
}
