package f4;

import java.util.Random;
/* loaded from: classes.dex */
public abstract class a extends c {
    @Override // f4.c
    public int b() {
        return d().nextInt();
    }

    @Override // f4.c
    public int c(int i5) {
        return d().nextInt(i5);
    }

    public abstract Random d();
}
