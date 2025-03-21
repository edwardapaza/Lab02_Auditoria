package o;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes.dex */
public abstract class d0<H> extends z {

    /* renamed from: a  reason: collision with root package name */
    private final Activity f6413a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f6414b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f6415c;

    /* renamed from: d  reason: collision with root package name */
    private final int f6416d;

    /* renamed from: e  reason: collision with root package name */
    private final l0 f6417e;

    public d0(Activity activity, Context context, Handler handler, int i5) {
        e4.k.e(context, "context");
        e4.k.e(handler, "handler");
        this.f6413a = activity;
        this.f6414b = context;
        this.f6415c = handler;
        this.f6416d = i5;
        this.f6417e = new m0();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d0(x xVar) {
        this(xVar, xVar, new Handler(), 0);
        e4.k.e(xVar, "activity");
    }

    public void A(s sVar, Intent intent, int i5, Bundle bundle) {
        e4.k.e(sVar, "fragment");
        e4.k.e(intent, "intent");
        if (!(i5 == -1)) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host".toString());
        }
        androidx.core.content.a.startActivity(this.f6414b, intent, bundle);
    }

    public void B() {
    }

    @Override // o.z
    public View g(int i5) {
        return null;
    }

    @Override // o.z
    public boolean s() {
        return true;
    }

    public final Activity t() {
        return this.f6413a;
    }

    public final Context u() {
        return this.f6414b;
    }

    public final l0 v() {
        return this.f6417e;
    }

    public final Handler w() {
        return this.f6415c;
    }

    public void x(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        e4.k.e(str, "prefix");
        e4.k.e(printWriter, "writer");
    }

    public abstract H y();

    public LayoutInflater z() {
        LayoutInflater from = LayoutInflater.from(this.f6414b);
        e4.k.d(from, "from(context)");
        return from;
    }
}
