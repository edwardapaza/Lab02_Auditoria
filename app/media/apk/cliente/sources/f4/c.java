package f4;

import e4.g;
import java.io.Serializable;
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public static final a f3050a = new a(null);

    /* renamed from: b  reason: collision with root package name */
    private static final c f3051b = y3.b.f8814a.b();

    /* loaded from: classes.dex */
    public static final class a extends c implements Serializable {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        @Override // f4.c
        public int b() {
            return c.f3051b.b();
        }

        @Override // f4.c
        public int c(int i5) {
            return c.f3051b.c(i5);
        }
    }

    public abstract int b();

    public abstract int c(int i5);
}
