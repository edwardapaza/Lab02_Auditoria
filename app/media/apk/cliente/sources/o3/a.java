package o3;

import com.google.protobuf.g1;
import com.google.protobuf.l;
import com.google.protobuf.w0;
import i3.q0;
import i3.w;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes.dex */
final class a extends InputStream implements w, q0 {

    /* renamed from: a  reason: collision with root package name */
    private w0 f6778a;

    /* renamed from: b  reason: collision with root package name */
    private final g1<?> f6779b;

    /* renamed from: c  reason: collision with root package name */
    private ByteArrayInputStream f6780c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(w0 w0Var, g1<?> g1Var) {
        this.f6778a = w0Var;
        this.f6779b = g1Var;
    }

    @Override // java.io.InputStream
    public int available() {
        w0 w0Var = this.f6778a;
        if (w0Var != null) {
            return w0Var.a();
        }
        ByteArrayInputStream byteArrayInputStream = this.f6780c;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.available();
        }
        return 0;
    }

    @Override // i3.w
    public int c(OutputStream outputStream) {
        w0 w0Var = this.f6778a;
        if (w0Var != null) {
            int a5 = w0Var.a();
            this.f6778a.d(outputStream);
            this.f6778a = null;
            return a5;
        }
        ByteArrayInputStream byteArrayInputStream = this.f6780c;
        if (byteArrayInputStream != null) {
            int a6 = (int) b.a(byteArrayInputStream, outputStream);
            this.f6780c = null;
            return a6;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w0 d() {
        w0 w0Var = this.f6778a;
        if (w0Var != null) {
            return w0Var;
        }
        throw new IllegalStateException("message not available");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g1<?> g() {
        return this.f6779b;
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.f6778a != null) {
            this.f6780c = new ByteArrayInputStream(this.f6778a.j());
            this.f6778a = null;
        }
        ByteArrayInputStream byteArrayInputStream = this.f6780c;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.read();
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i5, int i6) {
        w0 w0Var = this.f6778a;
        if (w0Var != null) {
            int a5 = w0Var.a();
            if (a5 == 0) {
                this.f6778a = null;
                this.f6780c = null;
                return -1;
            } else if (i6 >= a5) {
                l h02 = l.h0(bArr, i5, a5);
                this.f6778a.f(h02);
                h02.c0();
                h02.d();
                this.f6778a = null;
                this.f6780c = null;
                return a5;
            } else {
                this.f6780c = new ByteArrayInputStream(this.f6778a.j());
                this.f6778a = null;
            }
        }
        ByteArrayInputStream byteArrayInputStream = this.f6780c;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.read(bArr, i5, i6);
        }
        return -1;
    }
}
