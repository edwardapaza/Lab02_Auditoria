package io.flutter.embedding.android;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes.dex */
public class w {

    /* renamed from: a  reason: collision with root package name */
    long f3757a;

    /* renamed from: b  reason: collision with root package name */
    b f3758b;

    /* renamed from: c  reason: collision with root package name */
    long f3759c;

    /* renamed from: d  reason: collision with root package name */
    long f3760d;

    /* renamed from: e  reason: collision with root package name */
    boolean f3761e;

    /* renamed from: f  reason: collision with root package name */
    a f3762f;

    /* renamed from: g  reason: collision with root package name */
    String f3763g;

    /* loaded from: classes.dex */
    public enum a {
        kKeyboard(0),
        kDirectionalPad(1),
        kGamepad(2),
        kJoystick(3),
        kHdmi(4);
        

        /* renamed from: a  reason: collision with root package name */
        private final long f3770a;

        a(long j5) {
            this.f3770a = j5;
        }

        public long c() {
            return this.f3770a;
        }
    }

    /* loaded from: classes.dex */
    public enum b {
        kDown(0),
        kUp(1),
        kRepeat(2);
        

        /* renamed from: a  reason: collision with root package name */
        private long f3775a;

        b(long j5) {
            this.f3775a = j5;
        }

        public long c() {
            return this.f3775a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteBuffer a() {
        try {
            String str = this.f3763g;
            byte[] bytes = str == null ? null : str.getBytes("UTF-8");
            int length = bytes == null ? 0 : bytes.length;
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(length + 56);
            allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            allocateDirect.putLong(length);
            allocateDirect.putLong(this.f3757a);
            allocateDirect.putLong(this.f3758b.c());
            allocateDirect.putLong(this.f3759c);
            allocateDirect.putLong(this.f3760d);
            allocateDirect.putLong(this.f3761e ? 1L : 0L);
            allocateDirect.putLong(this.f3762f.c());
            if (bytes != null) {
                allocateDirect.put(bytes);
            }
            return allocateDirect;
        } catch (UnsupportedEncodingException unused) {
            throw new AssertionError("UTF-8 not supported");
        }
    }
}
