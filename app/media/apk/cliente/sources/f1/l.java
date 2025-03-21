package f1;
/* loaded from: classes.dex */
public class l extends Exception {
    @Deprecated
    protected l() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(String str) {
        super(str);
        com.google.android.gms.common.internal.q.f(str, "Detail message must not be empty");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(String str, Throwable th) {
        super(str, th);
        com.google.android.gms.common.internal.q.f(str, "Detail message must not be empty");
    }
}
