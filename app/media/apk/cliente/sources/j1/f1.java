package j1;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import com.google.firebase.auth.FirebaseAuth;
/* loaded from: classes.dex */
public final class f1 implements com.google.firebase.auth.a1 {

    /* renamed from: a  reason: collision with root package name */
    private final String f5390a;

    /* renamed from: b  reason: collision with root package name */
    private final String f5391b;

    /* renamed from: c  reason: collision with root package name */
    private final int f5392c;

    /* renamed from: d  reason: collision with root package name */
    private final int f5393d;

    /* renamed from: e  reason: collision with root package name */
    private final long f5394e;

    /* renamed from: f  reason: collision with root package name */
    private String f5395f;

    /* renamed from: g  reason: collision with root package name */
    private FirebaseAuth f5396g;

    public f1(String str, String str2, int i5, int i6, long j5, String str3, FirebaseAuth firebaseAuth) {
        com.google.android.gms.common.internal.q.f(str3, "sessionInfo cannot be empty.");
        com.google.android.gms.common.internal.q.l(firebaseAuth, "firebaseAuth cannot be null.");
        this.f5390a = com.google.android.gms.common.internal.q.f(str, "sharedSecretKey cannot be empty. This is required to generate QR code URL.");
        this.f5391b = com.google.android.gms.common.internal.q.f(str2, "hashAlgorithm cannot be empty.");
        this.f5392c = i5;
        this.f5393d = i6;
        this.f5394e = j5;
        this.f5395f = str3;
        this.f5396g = firebaseAuth;
    }

    private final void j(String str) {
        this.f5396g.l().m().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)).addFlags(268435456));
    }

    @Override // com.google.firebase.auth.a1
    public final String a() {
        return this.f5391b;
    }

    @Override // com.google.firebase.auth.a1
    public final int b() {
        return this.f5392c;
    }

    @Override // com.google.firebase.auth.a1
    public final String c() {
        return this.f5395f;
    }

    @Override // com.google.firebase.auth.a1
    public final String d(String str, String str2) {
        com.google.android.gms.common.internal.q.f(str, "accountName cannot be empty.");
        com.google.android.gms.common.internal.q.f(str2, "issuer cannot be empty.");
        return String.format(null, "otpauth://totp/%s:%s?secret=%s&issuer=%s&algorithm=%s&digits=%d", str2, str, this.f5390a, str2, this.f5391b, Integer.valueOf(this.f5392c));
    }

    @Override // com.google.firebase.auth.a1
    public final String e() {
        return this.f5390a;
    }

    @Override // com.google.firebase.auth.a1
    public final String f() {
        return d(com.google.android.gms.common.internal.q.f(((com.google.firebase.auth.a0) com.google.android.gms.common.internal.q.l(this.f5396g.m(), "Current user cannot be null, since user is required to be logged in to enroll for TOTP MFA.")).n(), "Email cannot be empty, since verified email is required to use MFA."), this.f5396g.l().q());
    }

    @Override // com.google.firebase.auth.a1
    public final long g() {
        return this.f5394e;
    }

    @Override // com.google.firebase.auth.a1
    public final int h() {
        return this.f5393d;
    }

    @Override // com.google.firebase.auth.a1
    public final void i(String str) {
        com.google.android.gms.common.internal.q.f(str, "qrCodeUrl cannot be empty.");
        try {
            j(str);
        } catch (ActivityNotFoundException unused) {
            j("https://play.google.com/store/search?q=otpauth&c=apps");
        }
    }
}
