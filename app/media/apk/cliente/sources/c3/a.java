package c3;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import java.util.HashMap;
import java.util.Map;
import s2.a;
import t2.c;
import y2.n;
import z2.j;
import z2.l;
/* loaded from: classes.dex */
public class a implements s2.a, t2.a, l, n.b {

    /* renamed from: a  reason: collision with root package name */
    private final n f852a;

    /* renamed from: b  reason: collision with root package name */
    private final PackageManager f853b;

    /* renamed from: c  reason: collision with root package name */
    private c f854c;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, ResolveInfo> f855d;

    /* renamed from: e  reason: collision with root package name */
    private Map<Integer, j.d> f856e = new HashMap();

    public a(n nVar) {
        this.f852a = nVar;
        this.f853b = nVar.f8728b;
        nVar.b(this);
    }

    private void e() {
        this.f855d = new HashMap();
        int i5 = Build.VERSION.SDK_INT;
        if (i5 < 23) {
            return;
        }
        Intent type = new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        for (ResolveInfo resolveInfo : i5 >= 33 ? this.f853b.queryIntentActivities(type, PackageManager.ResolveInfoFlags.of(0L)) : this.f853b.queryIntentActivities(type, 0)) {
            String str = resolveInfo.activityInfo.name;
            resolveInfo.loadLabel(this.f853b).toString();
            this.f855d.put(str, resolveInfo);
        }
    }

    @Override // t2.a
    public void A() {
        this.f854c.b(this);
        this.f854c = null;
    }

    @Override // z2.l
    public boolean a(int i5, int i6, Intent intent) {
        if (this.f856e.containsKey(Integer.valueOf(i5))) {
            this.f856e.remove(Integer.valueOf(i5)).a(i6 == -1 ? intent.getStringExtra("android.intent.extra.PROCESS_TEXT") : null);
            return true;
        }
        return false;
    }

    @Override // s2.a
    public void b(a.b bVar) {
    }

    @Override // y2.n.b
    public Map<String, String> c() {
        if (this.f855d == null) {
            e();
        }
        HashMap hashMap = new HashMap();
        for (String str : this.f855d.keySet()) {
            hashMap.put(str, this.f855d.get(str).loadLabel(this.f853b).toString());
        }
        return hashMap;
    }

    @Override // y2.n.b
    public void d(String str, String str2, boolean z4, j.d dVar) {
        if (this.f854c == null) {
            dVar.b("error", "Plugin not bound to an Activity", null);
        } else if (Build.VERSION.SDK_INT < 23) {
            dVar.b("error", "Android version not supported", null);
        } else {
            Map<String, ResolveInfo> map = this.f855d;
            if (map == null) {
                dVar.b("error", "Can not process text actions before calling queryTextActions", null);
                return;
            }
            ResolveInfo resolveInfo = map.get(str);
            if (resolveInfo == null) {
                dVar.b("error", "Text processing activity not found", null);
                return;
            }
            Integer valueOf = Integer.valueOf(dVar.hashCode());
            this.f856e.put(valueOf, dVar);
            Intent intent = new Intent();
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent.setClassName(activityInfo.packageName, activityInfo.name);
            intent.setAction("android.intent.action.PROCESS_TEXT");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.PROCESS_TEXT", str2);
            intent.putExtra("android.intent.extra.PROCESS_TEXT_READONLY", z4);
            this.f854c.d().startActivityForResult(intent, valueOf.intValue());
        }
    }

    @Override // t2.a
    public void j() {
        this.f854c.b(this);
        this.f854c = null;
    }

    @Override // t2.a
    public void r(c cVar) {
        this.f854c = cVar;
        cVar.a(this);
    }

    @Override // s2.a
    public void t(a.b bVar) {
    }

    @Override // t2.a
    public void z(c cVar) {
        this.f854c = cVar;
        cVar.a(this);
    }
}
