package y2;

import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.h;
import java.util.HashMap;
import z2.a;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final z2.a<Object> f8594a;

    /* renamed from: b  reason: collision with root package name */
    public final FlutterJNI f8595b;

    /* renamed from: c  reason: collision with root package name */
    private b f8596c;

    /* renamed from: d  reason: collision with root package name */
    public final a.d<Object> f8597d;

    /* renamed from: y2.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0131a implements a.d<Object> {
        C0131a() {
        }

        @Override // z2.a.d
        public void a(Object obj, a.e<Object> eVar) {
            if (a.this.f8596c == null) {
                eVar.a(null);
                return;
            }
            HashMap hashMap = (HashMap) obj;
            String str = (String) hashMap.get("type");
            HashMap hashMap2 = (HashMap) hashMap.get("data");
            n2.b.f("AccessibilityChannel", "Received " + str + " message.");
            str.hashCode();
            char c5 = 65535;
            switch (str.hashCode()) {
                case -1140076541:
                    if (str.equals("tooltip")) {
                        c5 = 0;
                        break;
                    }
                    break;
                case -649620375:
                    if (str.equals("announce")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case 114595:
                    if (str.equals("tap")) {
                        c5 = 2;
                        break;
                    }
                    break;
                case 97604824:
                    if (str.equals("focus")) {
                        c5 = 3;
                        break;
                    }
                    break;
                case 114203431:
                    if (str.equals("longPress")) {
                        c5 = 4;
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    String str2 = (String) hashMap2.get("message");
                    if (str2 != null) {
                        a.this.f8596c.d(str2);
                        break;
                    }
                    break;
                case 1:
                    String str3 = (String) hashMap2.get("message");
                    if (str3 != null) {
                        a.this.f8596c.a(str3);
                        break;
                    }
                    break;
                case 2:
                    Integer num = (Integer) hashMap.get("nodeId");
                    if (num != null) {
                        a.this.f8596c.g(num.intValue());
                        break;
                    }
                    break;
                case 3:
                    Integer num2 = (Integer) hashMap.get("nodeId");
                    if (num2 != null) {
                        a.this.f8596c.e(num2.intValue());
                        break;
                    }
                    break;
                case 4:
                    Integer num3 = (Integer) hashMap.get("nodeId");
                    if (num3 != null) {
                        a.this.f8596c.f(num3.intValue());
                        break;
                    }
                    break;
            }
            eVar.a(null);
        }
    }

    /* loaded from: classes.dex */
    public interface b extends FlutterJNI.a {
        void a(String str);

        void d(String str);

        void e(int i5);

        void f(int i5);

        void g(int i5);
    }

    public a(o2.a aVar, FlutterJNI flutterJNI) {
        C0131a c0131a = new C0131a();
        this.f8597d = c0131a;
        z2.a<Object> aVar2 = new z2.a<>(aVar, "flutter/accessibility", z2.p.f9015a);
        this.f8594a = aVar2;
        aVar2.e(c0131a);
        this.f8595b = flutterJNI;
    }

    public void b(int i5, h.g gVar) {
        this.f8595b.dispatchSemanticsAction(i5, gVar);
    }

    public void c(int i5, h.g gVar, Object obj) {
        this.f8595b.dispatchSemanticsAction(i5, gVar, obj);
    }

    public void d() {
        this.f8595b.setSemanticsEnabled(false);
    }

    public void e() {
        this.f8595b.setSemanticsEnabled(true);
    }

    public void f(int i5) {
        this.f8595b.setAccessibilityFeatures(i5);
    }

    public void g(b bVar) {
        this.f8596c = bVar;
        this.f8595b.setAccessibilityDelegate(bVar);
    }
}
