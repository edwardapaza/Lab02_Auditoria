package com.google.android.gms.common.internal;

import android.util.Log;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class w0 {

    /* renamed from: a  reason: collision with root package name */
    private Object f1208a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f1209b = false;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ c f1210c;

    public w0(c cVar, Object obj) {
        this.f1210c = cVar;
        this.f1208a = obj;
    }

    protected abstract void a(Object obj);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void b();

    public final void c() {
        Object obj;
        synchronized (this) {
            obj = this.f1208a;
            if (this.f1209b) {
                String obj2 = toString();
                Log.w("GmsClient", "Callback proxy " + obj2 + " being reused. This is not safe.");
            }
        }
        if (obj != null) {
            try {
                a(obj);
            } catch (RuntimeException e5) {
                throw e5;
            }
        }
        synchronized (this) {
            this.f1209b = true;
        }
        e();
    }

    public final void d() {
        synchronized (this) {
            this.f1208a = null;
        }
    }

    public final void e() {
        ArrayList arrayList;
        ArrayList arrayList2;
        d();
        arrayList = this.f1210c.zzt;
        synchronized (arrayList) {
            arrayList2 = this.f1210c.zzt;
            arrayList2.remove(this);
        }
    }
}
