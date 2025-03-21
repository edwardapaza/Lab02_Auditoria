package e2;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    private static volatile d f2669b;

    /* renamed from: a  reason: collision with root package name */
    private final Set<f> f2670a = new HashSet();

    d() {
    }

    public static d a() {
        d dVar = f2669b;
        if (dVar == null) {
            synchronized (d.class) {
                dVar = f2669b;
                if (dVar == null) {
                    dVar = new d();
                    f2669b = dVar;
                }
            }
        }
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set<f> b() {
        Set<f> unmodifiableSet;
        synchronized (this.f2670a) {
            unmodifiableSet = Collections.unmodifiableSet(this.f2670a);
        }
        return unmodifiableSet;
    }
}
