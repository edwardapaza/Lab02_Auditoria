package i3;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes.dex */
public interface l extends n, u {

    /* loaded from: classes.dex */
    public static final class a implements l {
        @Override // i3.n, i3.u
        public String a() {
            return "gzip";
        }

        @Override // i3.u
        public InputStream b(InputStream inputStream) {
            return new GZIPInputStream(inputStream);
        }

        @Override // i3.n
        public OutputStream c(OutputStream outputStream) {
            return new GZIPOutputStream(outputStream);
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final l f3486a = new b();

        private b() {
        }

        @Override // i3.n, i3.u
        public String a() {
            return "identity";
        }

        @Override // i3.u
        public InputStream b(InputStream inputStream) {
            return inputStream;
        }

        @Override // i3.n
        public OutputStream c(OutputStream outputStream) {
            return outputStream;
        }
    }
}
