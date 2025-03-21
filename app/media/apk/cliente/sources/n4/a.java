package n4;

import android.os.Looper;
import java.util.List;
import m4.f2;
import r4.v;
/* loaded from: classes.dex */
public final class a implements v {
    @Override // r4.v
    public String a() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }

    @Override // r4.v
    public f2 b(List<? extends v> list) {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            return new d(f.a(mainLooper, true), null, 2, null);
        }
        throw new IllegalStateException("The main looper is not available");
    }

    @Override // r4.v
    public int c() {
        return 1073741823;
    }
}
