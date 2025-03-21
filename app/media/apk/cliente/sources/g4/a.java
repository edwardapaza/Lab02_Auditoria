package g4;

import e4.k;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
/* loaded from: classes.dex */
public final class a extends f4.a {
    @Override // f4.a
    public Random d() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        k.d(current, "current()");
        return current;
    }
}
