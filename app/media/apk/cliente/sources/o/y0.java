package o;

import android.util.Log;
import java.io.Writer;
/* loaded from: classes.dex */
final class y0 extends Writer {

    /* renamed from: a  reason: collision with root package name */
    private final String f6731a;

    /* renamed from: b  reason: collision with root package name */
    private StringBuilder f6732b = new StringBuilder(128);

    /* JADX INFO: Access modifiers changed from: package-private */
    public y0(String str) {
        this.f6731a = str;
    }

    private void c() {
        if (this.f6732b.length() > 0) {
            Log.d(this.f6731a, this.f6732b.toString());
            StringBuilder sb = this.f6732b;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        c();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        c();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i5, int i6) {
        for (int i7 = 0; i7 < i6; i7++) {
            char c5 = cArr[i5 + i7];
            if (c5 == '\n') {
                c();
            } else {
                this.f6732b.append(c5);
            }
        }
    }
}
