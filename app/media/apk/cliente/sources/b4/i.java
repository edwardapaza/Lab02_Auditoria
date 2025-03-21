package b4;

import e4.k;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
/* loaded from: classes.dex */
public final class i {
    public static final long a(Reader reader, Writer writer, int i5) {
        k.e(reader, "<this>");
        k.e(writer, "out");
        char[] cArr = new char[i5];
        int read = reader.read(cArr);
        long j5 = 0;
        while (read >= 0) {
            writer.write(cArr, 0, read);
            j5 += read;
            read = reader.read(cArr);
        }
        return j5;
    }

    public static /* synthetic */ long b(Reader reader, Writer writer, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i5 = 8192;
        }
        return a(reader, writer, i5);
    }

    public static final String c(Reader reader) {
        k.e(reader, "<this>");
        StringWriter stringWriter = new StringWriter();
        b(reader, stringWriter, 0, 2, null);
        String stringWriter2 = stringWriter.toString();
        k.d(stringWriter2, "buffer.toString()");
        return stringWriter2;
    }
}
