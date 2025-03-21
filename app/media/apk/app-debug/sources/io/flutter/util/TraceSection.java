package io.flutter.util;

import androidx.tracing.Trace;
/* loaded from: classes.dex */
public final class TraceSection implements AutoCloseable {
    public static TraceSection scoped(String name) {
        return new TraceSection(name);
    }

    private TraceSection(String name) {
        begin(name);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        end();
    }

    private static String cropSectionName(String sectionName) {
        return sectionName.length() < 124 ? sectionName : sectionName.substring(0, 124) + "...";
    }

    public static void begin(String sectionName) {
        Trace.beginSection(cropSectionName(sectionName));
    }

    public static void end() throws RuntimeException {
        Trace.endSection();
    }

    public static void beginAsyncSection(String sectionName, int cookie) {
        Trace.beginAsyncSection(cropSectionName(sectionName), cookie);
    }

    public static void endAsyncSection(String sectionName, int cookie) {
        Trace.endAsyncSection(cropSectionName(sectionName), cookie);
    }
}
