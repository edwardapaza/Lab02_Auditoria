package m4;

import java.util.concurrent.CancellationException;
/* loaded from: classes.dex */
public final class v2 extends CancellationException {

    /* renamed from: a  reason: collision with root package name */
    public final transient u1 f6286a;

    public v2(String str) {
        this(str, null);
    }

    public v2(String str, u1 u1Var) {
        super(str);
        this.f6286a = u1Var;
    }
}
