package androidx.core.app;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f265a = new Object();

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
        r1 = r3.getAttributeValue(null, "application_locales");
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0041, code lost:
        if (r2 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0043, code lost:
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0050, code lost:
        if (r2 == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0057, code lost:
        if (r1.isEmpty() == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005a, code lost:
        r8.deleteFile("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(android.content.Context r8) {
        /*
            java.lang.Object r0 = androidx.core.app.e.f265a
            monitor-enter(r0)
            java.lang.String r1 = ""
            java.lang.String r2 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            java.io.FileInputStream r2 = r8.openFileInput(r2)     // Catch: java.io.FileNotFoundException -> L67 java.lang.Throwable -> L69
            org.xmlpull.v1.XmlPullParser r3 = android.util.Xml.newPullParser()     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49
            java.lang.String r4 = "UTF-8"
            r3.setInput(r2, r4)     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49
            int r4 = r3.getDepth()     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49
        L18:
            int r5 = r3.next()     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49
            r6 = 1
            if (r5 == r6) goto L41
            r6 = 3
            if (r5 != r6) goto L28
            int r7 = r3.getDepth()     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49
            if (r7 <= r4) goto L41
        L28:
            if (r5 == r6) goto L18
            r6 = 4
            if (r5 != r6) goto L2e
            goto L18
        L2e:
            java.lang.String r5 = r3.getName()     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49
            java.lang.String r6 = "locales"
            boolean r5 = r5.equals(r6)     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49
            if (r5 == 0) goto L18
            r4 = 0
            java.lang.String r5 = "application_locales"
            java.lang.String r1 = r3.getAttributeValue(r4, r5)     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L49
        L41:
            if (r2 == 0) goto L53
        L43:
            r2.close()     // Catch: java.io.IOException -> L53 java.lang.Throwable -> L69
            goto L53
        L47:
            r8 = move-exception
            goto L61
        L49:
            java.lang.String r3 = "AppLocalesStorageHelper"
            java.lang.String r4 = "Reading app Locales : Unable to parse through file :androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            android.util.Log.w(r3, r4)     // Catch: java.lang.Throwable -> L47
            if (r2 == 0) goto L53
            goto L43
        L53:
            boolean r2 = r1.isEmpty()     // Catch: java.lang.Throwable -> L69
            if (r2 != 0) goto L5a
            goto L5f
        L5a:
            java.lang.String r2 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            r8.deleteFile(r2)     // Catch: java.lang.Throwable -> L69
        L5f:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L69
            return r1
        L61:
            if (r2 == 0) goto L66
            r2.close()     // Catch: java.io.IOException -> L66 java.lang.Throwable -> L69
        L66:
            throw r8     // Catch: java.lang.Throwable -> L69
        L67:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L69
            return r1
        L69:
            r8 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L69
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.e.a(android.content.Context):java.lang.String");
    }
}
