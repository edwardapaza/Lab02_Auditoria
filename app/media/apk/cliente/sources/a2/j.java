package a2;
/* loaded from: classes.dex */
public interface j {

    /* loaded from: classes.dex */
    public enum a {
        NONE(0),
        SDK(1),
        GLOBAL(2),
        COMBINED(3);
        

        /* renamed from: a  reason: collision with root package name */
        private final int f81a;

        a(int i5) {
            this.f81a = i5;
        }

        public int a() {
            return this.f81a;
        }
    }

    a b(String str);
}
