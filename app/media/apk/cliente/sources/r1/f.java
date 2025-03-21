package r1;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.json.JSONObject;
import z1.w;
/* loaded from: classes.dex */
public class f {

    /* renamed from: g  reason: collision with root package name */
    private static final Charset f7142g = Charset.forName("UTF-8");

    /* renamed from: a  reason: collision with root package name */
    private final g f7143a;

    /* renamed from: b  reason: collision with root package name */
    private final InputStream f7144b;

    /* renamed from: c  reason: collision with root package name */
    private final InputStreamReader f7145c;

    /* renamed from: d  reason: collision with root package name */
    e f7146d;

    /* renamed from: e  reason: collision with root package name */
    private ByteBuffer f7147e;

    /* renamed from: f  reason: collision with root package name */
    long f7148f;

    public f(g gVar, InputStream inputStream) {
        this.f7143a = gVar;
        this.f7144b = inputStream;
        this.f7145c = new InputStreamReader(inputStream);
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        this.f7147e = allocate;
        allocate.flip();
    }

    private IllegalArgumentException a(String str) {
        b();
        throw new IllegalArgumentException("Invalid bundle: " + str);
    }

    private c c(String str) {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("metadata")) {
            e b5 = this.f7143a.b(jSONObject.getJSONObject("metadata"));
            w.a("BundleElement", "BundleMetadata element loaded", new Object[0]);
            return b5;
        } else if (jSONObject.has("namedQuery")) {
            j q5 = this.f7143a.q(jSONObject.getJSONObject("namedQuery"));
            w.a("BundleElement", "Query loaded: " + q5.b(), new Object[0]);
            return q5;
        } else if (jSONObject.has("documentMetadata")) {
            h c5 = this.f7143a.c(jSONObject.getJSONObject("documentMetadata"));
            w.a("BundleElement", "Document metadata loaded: " + c5.b(), new Object[0]);
            return c5;
        } else if (!jSONObject.has("document")) {
            throw a("Cannot decode unknown Bundle element: " + str);
        } else {
            b f5 = this.f7143a.f(jSONObject.getJSONObject("document"));
            w.a("BundleElement", "Document loaded: " + f5.b(), new Object[0]);
            return f5;
        }
    }

    private int g() {
        this.f7147e.mark();
        int i5 = 0;
        while (true) {
            try {
                if (i5 >= this.f7147e.remaining()) {
                    i5 = -1;
                    break;
                } else if (this.f7147e.get() == 123) {
                    break;
                } else {
                    i5++;
                }
            } finally {
                this.f7147e.reset();
            }
        }
        return i5;
    }

    private boolean h() {
        this.f7147e.compact();
        int read = this.f7144b.read(this.f7147e.array(), this.f7147e.arrayOffset() + this.f7147e.position(), this.f7147e.remaining());
        boolean z4 = read > 0;
        if (z4) {
            ByteBuffer byteBuffer = this.f7147e;
            byteBuffer.position(byteBuffer.position() + read);
        }
        this.f7147e.flip();
        return z4;
    }

    private String i(int i5) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (i5 > 0) {
            if (this.f7147e.remaining() == 0 && !h()) {
                throw a("Reached the end of bundle when more data was expected.");
            }
            int min = Math.min(i5, this.f7147e.remaining());
            byteArrayOutputStream.write(this.f7147e.array(), this.f7147e.arrayOffset() + this.f7147e.position(), min);
            ByteBuffer byteBuffer = this.f7147e;
            byteBuffer.position(byteBuffer.position() + min);
            i5 -= min;
        }
        return byteArrayOutputStream.toString(f7142g.name());
    }

    private String j() {
        int g5;
        do {
            g5 = g();
            if (g5 != -1) {
                break;
            }
        } while (h());
        if (this.f7147e.remaining() == 0) {
            return null;
        }
        if (g5 != -1) {
            byte[] bArr = new byte[g5];
            this.f7147e.get(bArr);
            return f7142g.decode(ByteBuffer.wrap(bArr)).toString();
        }
        throw a("Reached the end of bundle when a length string is expected.");
    }

    private c k() {
        int parseInt;
        String j5 = j();
        if (j5 == null) {
            return null;
        }
        String i5 = i(Integer.parseInt(j5));
        this.f7148f += j5.getBytes(f7142g).length + parseInt;
        return c(i5);
    }

    public void b() {
        this.f7144b.close();
    }

    public e d() {
        e eVar = this.f7146d;
        if (eVar != null) {
            return eVar;
        }
        c k5 = k();
        if (k5 instanceof e) {
            e eVar2 = (e) k5;
            this.f7146d = eVar2;
            this.f7148f = 0L;
            return eVar2;
        }
        throw a("Expected first element in bundle to be a metadata object");
    }

    public long e() {
        return this.f7148f;
    }

    public c f() {
        d();
        return k();
    }
}
