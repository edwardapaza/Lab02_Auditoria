package l0;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.base.zaq;
/* loaded from: classes.dex */
final class p extends zaq {

    /* renamed from: a  reason: collision with root package name */
    private final Context f5898a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ f f5899b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(f fVar, Context context) {
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
        this.f5899b = fVar;
        this.f5898a = context.getApplicationContext();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i5 = message.what;
        if (i5 != 1) {
            StringBuilder sb = new StringBuilder(50);
            sb.append("Don't know how to handle this message: ");
            sb.append(i5);
            Log.w("GoogleApiAvailability", sb.toString());
            return;
        }
        int f5 = this.f5899b.f(this.f5898a);
        if (this.f5899b.i(f5)) {
            this.f5899b.o(this.f5898a, f5);
        }
    }
}
