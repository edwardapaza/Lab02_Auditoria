package y2;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import z2.j;
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public final z2.j f8627a;

    /* renamed from: b  reason: collision with root package name */
    private b f8628b;

    /* renamed from: c  reason: collision with root package name */
    public final j.c f8629c;

    /* loaded from: classes.dex */
    class a implements j.c {
        a() {
        }

        @Override // z2.j.c
        public void a(z2.i iVar, j.d dVar) {
            if (h.this.f8628b == null) {
                return;
            }
            String str = iVar.f9003a;
            str.hashCode();
            if (!str.equals("Localization.getStringResource")) {
                dVar.c();
                return;
            }
            JSONObject jSONObject = (JSONObject) iVar.a();
            try {
                dVar.a(h.this.f8628b.a(jSONObject.getString("key"), jSONObject.has("locale") ? jSONObject.getString("locale") : null));
            } catch (JSONException e5) {
                dVar.b("error", e5.getMessage(), null);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        String a(String str, String str2);
    }

    public h(o2.a aVar) {
        a aVar2 = new a();
        this.f8629c = aVar2;
        z2.j jVar = new z2.j(aVar, "flutter/localization", z2.f.f9002a);
        this.f8627a = jVar;
        jVar.e(aVar2);
    }

    public void b(List<Locale> list) {
        n2.b.f("LocalizationChannel", "Sending Locales to Flutter.");
        ArrayList arrayList = new ArrayList();
        for (Locale locale : list) {
            n2.b.f("LocalizationChannel", "Locale (Language: " + locale.getLanguage() + ", Country: " + locale.getCountry() + ", Variant: " + locale.getVariant() + ")");
            arrayList.add(locale.getLanguage());
            arrayList.add(locale.getCountry());
            arrayList.add(locale.getScript());
            arrayList.add(locale.getVariant());
        }
        this.f8627a.c("setLocale", arrayList);
    }

    public void c(b bVar) {
        this.f8628b = bVar;
    }
}
