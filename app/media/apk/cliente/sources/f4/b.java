package f4;

import e4.k;
import java.util.Random;
/* loaded from: classes.dex */
public final class b extends f4.a {

    /* renamed from: c  reason: collision with root package name */
    private final a f3049c = new a();

    /* loaded from: classes.dex */
    public static final class a extends ThreadLocal<Random> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public Random initialValue() {
            return new Random();
        }
    }

    @Override // f4.a
    public Random d() {
        Random random = this.f3049c.get();
        k.d(random, "implStorage.get()");
        return random;
    }
}
