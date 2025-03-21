package com.google.protobuf;

import java.io.IOException;
/* loaded from: classes.dex */
public class e0 extends IOException {

    /* renamed from: a  reason: collision with root package name */
    private w0 f1922a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f1923b;

    /* loaded from: classes.dex */
    public static class a extends e0 {
        public a(String str) {
            super(str);
        }
    }

    public e0(IOException iOException) {
        super(iOException.getMessage(), iOException);
        this.f1922a = null;
    }

    public e0(String str) {
        super(str);
        this.f1922a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e0 b() {
        return new e0("Protocol message end-group tag did not match expected tag.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e0 c() {
        return new e0("Protocol message contained an invalid tag (zero).");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e0 d() {
        return new e0("Protocol message had invalid UTF-8.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a e() {
        return new a("Protocol message tag had invalid wire type.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e0 f() {
        return new e0("CodedInputStream encountered a malformed varint.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e0 g() {
        return new e0("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e0 h() {
        return new e0("Failed to parse the message.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e0 i() {
        return new e0("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e0 l() {
        return new e0("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e0 m() {
        return new e0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return this.f1923b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        this.f1923b = true;
    }

    public e0 k(w0 w0Var) {
        this.f1922a = w0Var;
        return this;
    }
}
