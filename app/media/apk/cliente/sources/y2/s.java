package y2;

import android.os.Bundle;
import i2.d0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import z2.j;
/* loaded from: classes.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    public final z2.j f8764a;

    /* renamed from: b  reason: collision with root package name */
    private f f8765b;

    /* renamed from: c  reason: collision with root package name */
    final j.c f8766c;

    /* loaded from: classes.dex */
    class a implements j.c {
        a() {
        }

        @Override // z2.j.c
        public void a(z2.i iVar, j.d dVar) {
            Bundle bundle;
            if (s.this.f8765b == null) {
                return;
            }
            String str = iVar.f9003a;
            Object obj = iVar.f9004b;
            n2.b.f("TextInputChannel", "Received '" + str + "' message.");
            str.hashCode();
            char c5 = 65535;
            switch (str.hashCode()) {
                case -1779068172:
                    if (str.equals("TextInput.setPlatformViewClient")) {
                        c5 = 0;
                        break;
                    }
                    break;
                case -1015421462:
                    if (str.equals("TextInput.setEditingState")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case -37561188:
                    if (str.equals("TextInput.setClient")) {
                        c5 = 2;
                        break;
                    }
                    break;
                case 270476819:
                    if (str.equals("TextInput.hide")) {
                        c5 = 3;
                        break;
                    }
                    break;
                case 270803918:
                    if (str.equals("TextInput.show")) {
                        c5 = 4;
                        break;
                    }
                    break;
                case 649192816:
                    if (str.equals("TextInput.sendAppPrivateCommand")) {
                        c5 = 5;
                        break;
                    }
                    break;
                case 1204752139:
                    if (str.equals("TextInput.setEditableSizeAndTransform")) {
                        c5 = 6;
                        break;
                    }
                    break;
                case 1727570905:
                    if (str.equals("TextInput.finishAutofillContext")) {
                        c5 = 7;
                        break;
                    }
                    break;
                case 1904427655:
                    if (str.equals("TextInput.clearClient")) {
                        c5 = '\b';
                        break;
                    }
                    break;
                case 2113369584:
                    if (str.equals("TextInput.requestAutofill")) {
                        c5 = '\t';
                        break;
                    }
                    break;
            }
            try {
                switch (c5) {
                    case 0:
                        JSONObject jSONObject = (JSONObject) obj;
                        s.this.f8765b.f(jSONObject.getInt("platformViewId"), jSONObject.optBoolean("usesVirtualDisplay", false));
                        dVar.a(null);
                        return;
                    case 1:
                        s.this.f8765b.c(e.a((JSONObject) obj));
                        dVar.a(null);
                        return;
                    case 2:
                        try {
                            JSONArray jSONArray = (JSONArray) obj;
                            s.this.f8765b.d(jSONArray.getInt(0), b.a(jSONArray.getJSONObject(1)));
                            dVar.a(null);
                            return;
                        } catch (NoSuchFieldException e5) {
                            e = e5;
                            dVar.b("error", e.getMessage(), null);
                            return;
                        }
                    case 3:
                        s.this.f8765b.j();
                        break;
                    case 4:
                        s.this.f8765b.b();
                        break;
                    case 5:
                        JSONObject jSONObject2 = (JSONObject) obj;
                        String string = jSONObject2.getString("action");
                        String string2 = jSONObject2.getString("data");
                        if (string2 == null || string2.isEmpty()) {
                            bundle = null;
                        } else {
                            bundle = new Bundle();
                            bundle.putString("data", string2);
                        }
                        s.this.f8765b.e(string, bundle);
                        dVar.a(null);
                        return;
                    case 6:
                        JSONObject jSONObject3 = (JSONObject) obj;
                        double d5 = jSONObject3.getDouble("width");
                        double d6 = jSONObject3.getDouble("height");
                        JSONArray jSONArray2 = jSONObject3.getJSONArray("transform");
                        double[] dArr = new double[16];
                        for (int i5 = 0; i5 < 16; i5++) {
                            dArr[i5] = jSONArray2.getDouble(i5);
                        }
                        s.this.f8765b.g(d5, d6, dArr);
                        dVar.a(null);
                        return;
                    case 7:
                        s.this.f8765b.i(((Boolean) obj).booleanValue());
                        break;
                    case '\b':
                        s.this.f8765b.a();
                        break;
                    case d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                        s.this.f8765b.h();
                        break;
                    default:
                        dVar.c();
                        return;
                }
                dVar.a(null);
            } catch (JSONException e6) {
                e = e6;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f8768a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f8769b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f8770c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f8771d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f8772e;

        /* renamed from: f  reason: collision with root package name */
        public final d f8773f;

        /* renamed from: g  reason: collision with root package name */
        public final c f8774g;

        /* renamed from: h  reason: collision with root package name */
        public final Integer f8775h;

        /* renamed from: i  reason: collision with root package name */
        public final String f8776i;

        /* renamed from: j  reason: collision with root package name */
        public final a f8777j;

        /* renamed from: k  reason: collision with root package name */
        public final String[] f8778k;

        /* renamed from: l  reason: collision with root package name */
        public final b[] f8779l;

        /* loaded from: classes.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public final String f8780a;

            /* renamed from: b  reason: collision with root package name */
            public final String[] f8781b;

            /* renamed from: c  reason: collision with root package name */
            public final e f8782c;

            /* renamed from: d  reason: collision with root package name */
            public final String f8783d;

            public a(String str, String[] strArr, String str2, e eVar) {
                this.f8780a = str;
                this.f8781b = strArr;
                this.f8783d = str2;
                this.f8782c = eVar;
            }

            public static a a(JSONObject jSONObject) {
                String string = jSONObject.getString("uniqueIdentifier");
                JSONArray jSONArray = jSONObject.getJSONArray("hints");
                String string2 = jSONObject.isNull("hintText") ? null : jSONObject.getString("hintText");
                JSONObject jSONObject2 = jSONObject.getJSONObject("editingValue");
                String[] strArr = new String[jSONArray.length()];
                for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                    strArr[i5] = b(jSONArray.getString(i5));
                }
                return new a(string, strArr, string2, e.a(jSONObject2));
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Code restructure failed: missing block: B:45:0x00a3, code lost:
                if (r16.equals("familyName") == false) goto L7;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            private static java.lang.String b(java.lang.String r16) {
                /*
                    Method dump skipped, instructions count: 802
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: y2.s.b.a.b(java.lang.String):java.lang.String");
            }
        }

        public b(boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, d dVar, c cVar, Integer num, String str, a aVar, String[] strArr, b[] bVarArr) {
            this.f8768a = z4;
            this.f8769b = z5;
            this.f8770c = z6;
            this.f8771d = z7;
            this.f8772e = z8;
            this.f8773f = dVar;
            this.f8774g = cVar;
            this.f8775h = num;
            this.f8776i = str;
            this.f8777j = aVar;
            this.f8778k = strArr;
            this.f8779l = bVarArr;
        }

        public static b a(JSONObject jSONObject) {
            b[] bVarArr;
            String string = jSONObject.getString("inputAction");
            if (string != null) {
                if (jSONObject.isNull("fields")) {
                    bVarArr = null;
                } else {
                    JSONArray jSONArray = jSONObject.getJSONArray("fields");
                    int length = jSONArray.length();
                    b[] bVarArr2 = new b[length];
                    for (int i5 = 0; i5 < length; i5++) {
                        bVarArr2[i5] = a(jSONArray.getJSONObject(i5));
                    }
                    bVarArr = bVarArr2;
                }
                Integer b5 = b(string);
                ArrayList arrayList = new ArrayList();
                JSONArray jSONArray2 = jSONObject.isNull("contentCommitMimeTypes") ? null : jSONObject.getJSONArray("contentCommitMimeTypes");
                if (jSONArray2 != null) {
                    for (int i6 = 0; i6 < jSONArray2.length(); i6++) {
                        arrayList.add(jSONArray2.optString(i6));
                    }
                }
                return new b(jSONObject.optBoolean("obscureText"), jSONObject.optBoolean("autocorrect", true), jSONObject.optBoolean("enableSuggestions"), jSONObject.optBoolean("enableIMEPersonalizedLearning"), jSONObject.optBoolean("enableDeltaModel"), d.c(jSONObject.getString("textCapitalization")), c.a(jSONObject.getJSONObject("inputType")), b5, jSONObject.isNull("actionLabel") ? null : jSONObject.getString("actionLabel"), jSONObject.isNull("autofill") ? null : a.a(jSONObject.getJSONObject("autofill")), (String[]) arrayList.toArray(new String[arrayList.size()]), bVarArr);
            }
            throw new JSONException("Configuration JSON missing 'inputAction' property.");
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0072, code lost:
            if (r12.equals("TextInputAction.done") == false) goto L3;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static java.lang.Integer b(java.lang.String r12) {
            /*
                r12.hashCode()
                int r0 = r12.hashCode()
                r1 = 7
                r2 = 6
                r3 = 5
                r4 = 4
                r5 = 3
                r6 = 2
                r7 = 1
                java.lang.Integer r8 = java.lang.Integer.valueOf(r7)
                r9 = 0
                java.lang.Integer r10 = java.lang.Integer.valueOf(r9)
                r11 = -1
                switch(r0) {
                    case -810971940: goto L75;
                    case -737377923: goto L6c;
                    case -737089298: goto L61;
                    case -737080013: goto L56;
                    case -736940669: goto L4b;
                    case 469250275: goto L40;
                    case 1241689507: goto L35;
                    case 1539450297: goto L2a;
                    case 2110497650: goto L1e;
                    default: goto L1b;
                }
            L1b:
                r7 = -1
                goto L7f
            L1e:
                java.lang.String r0 = "TextInputAction.previous"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L27
                goto L1b
            L27:
                r7 = 8
                goto L7f
            L2a:
                java.lang.String r0 = "TextInputAction.newline"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L33
                goto L1b
            L33:
                r7 = 7
                goto L7f
            L35:
                java.lang.String r0 = "TextInputAction.go"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L3e
                goto L1b
            L3e:
                r7 = 6
                goto L7f
            L40:
                java.lang.String r0 = "TextInputAction.search"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L49
                goto L1b
            L49:
                r7 = 5
                goto L7f
            L4b:
                java.lang.String r0 = "TextInputAction.send"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L54
                goto L1b
            L54:
                r7 = 4
                goto L7f
            L56:
                java.lang.String r0 = "TextInputAction.none"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L5f
                goto L1b
            L5f:
                r7 = 3
                goto L7f
            L61:
                java.lang.String r0 = "TextInputAction.next"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L6a
                goto L1b
            L6a:
                r7 = 2
                goto L7f
            L6c:
                java.lang.String r0 = "TextInputAction.done"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L7f
                goto L1b
            L75:
                java.lang.String r0 = "TextInputAction.unspecified"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L7e
                goto L1b
            L7e:
                r7 = 0
            L7f:
                switch(r7) {
                    case 0: goto La3;
                    case 1: goto L9e;
                    case 2: goto L99;
                    case 3: goto L98;
                    case 4: goto L93;
                    case 5: goto L8e;
                    case 6: goto L89;
                    case 7: goto L88;
                    case 8: goto L83;
                    default: goto L82;
                }
            L82:
                return r10
            L83:
                java.lang.Integer r12 = java.lang.Integer.valueOf(r1)
                return r12
            L88:
                return r8
            L89:
                java.lang.Integer r12 = java.lang.Integer.valueOf(r6)
                return r12
            L8e:
                java.lang.Integer r12 = java.lang.Integer.valueOf(r5)
                return r12
            L93:
                java.lang.Integer r12 = java.lang.Integer.valueOf(r4)
                return r12
            L98:
                return r8
            L99:
                java.lang.Integer r12 = java.lang.Integer.valueOf(r3)
                return r12
            L9e:
                java.lang.Integer r12 = java.lang.Integer.valueOf(r2)
                return r12
            La3:
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: y2.s.b.b(java.lang.String):java.lang.Integer");
        }
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final g f8784a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f8785b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f8786c;

        public c(g gVar, boolean z4, boolean z5) {
            this.f8784a = gVar;
            this.f8785b = z4;
            this.f8786c = z5;
        }

        public static c a(JSONObject jSONObject) {
            return new c(g.c(jSONObject.getString("name")), jSONObject.optBoolean("signed", false), jSONObject.optBoolean("decimal", false));
        }
    }

    /* loaded from: classes.dex */
    public enum d {
        CHARACTERS("TextCapitalization.characters"),
        WORDS("TextCapitalization.words"),
        SENTENCES("TextCapitalization.sentences"),
        NONE("TextCapitalization.none");
        

        /* renamed from: a  reason: collision with root package name */
        private final String f8792a;

        d(String str) {
            this.f8792a = str;
        }

        static d c(String str) {
            d[] values;
            for (d dVar : values()) {
                if (dVar.f8792a.equals(str)) {
                    return dVar;
                }
            }
            throw new NoSuchFieldException("No such TextCapitalization: " + str);
        }
    }

    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public final String f8793a;

        /* renamed from: b  reason: collision with root package name */
        public final int f8794b;

        /* renamed from: c  reason: collision with root package name */
        public final int f8795c;

        /* renamed from: d  reason: collision with root package name */
        public final int f8796d;

        /* renamed from: e  reason: collision with root package name */
        public final int f8797e;

        public e(String str, int i5, int i6, int i7, int i8) {
            if (!(i5 == -1 && i6 == -1) && (i5 < 0 || i6 < 0)) {
                throw new IndexOutOfBoundsException("invalid selection: (" + String.valueOf(i5) + ", " + String.valueOf(i6) + ")");
            } else if (!(i7 == -1 && i8 == -1) && (i7 < 0 || i7 > i8)) {
                throw new IndexOutOfBoundsException("invalid composing range: (" + String.valueOf(i7) + ", " + String.valueOf(i8) + ")");
            } else if (i8 > str.length()) {
                throw new IndexOutOfBoundsException("invalid composing start: " + String.valueOf(i7));
            } else if (i5 > str.length()) {
                throw new IndexOutOfBoundsException("invalid selection start: " + String.valueOf(i5));
            } else if (i6 > str.length()) {
                throw new IndexOutOfBoundsException("invalid selection end: " + String.valueOf(i6));
            } else {
                this.f8793a = str;
                this.f8794b = i5;
                this.f8795c = i6;
                this.f8796d = i7;
                this.f8797e = i8;
            }
        }

        public static e a(JSONObject jSONObject) {
            return new e(jSONObject.getString("text"), jSONObject.getInt("selectionBase"), jSONObject.getInt("selectionExtent"), jSONObject.getInt("composingBase"), jSONObject.getInt("composingExtent"));
        }

        public boolean b() {
            int i5 = this.f8796d;
            return i5 >= 0 && this.f8797e > i5;
        }

        public boolean c() {
            return this.f8794b >= 0;
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        void a();

        void b();

        void c(e eVar);

        void d(int i5, b bVar);

        void e(String str, Bundle bundle);

        void f(int i5, boolean z4);

        void g(double d5, double d6, double[] dArr);

        void h();

        void i(boolean z4);

        void j();
    }

    /* loaded from: classes.dex */
    public enum g {
        TEXT("TextInputType.text"),
        DATETIME("TextInputType.datetime"),
        NAME("TextInputType.name"),
        POSTAL_ADDRESS("TextInputType.address"),
        NUMBER("TextInputType.number"),
        PHONE("TextInputType.phone"),
        MULTILINE("TextInputType.multiline"),
        EMAIL_ADDRESS("TextInputType.emailAddress"),
        URL("TextInputType.url"),
        VISIBLE_PASSWORD("TextInputType.visiblePassword"),
        NONE("TextInputType.none");
        

        /* renamed from: a  reason: collision with root package name */
        private final String f8810a;

        g(String str) {
            this.f8810a = str;
        }

        static g c(String str) {
            g[] values;
            for (g gVar : values()) {
                if (gVar.f8810a.equals(str)) {
                    return gVar;
                }
            }
            throw new NoSuchFieldException("No such TextInputType: " + str);
        }
    }

    public s(o2.a aVar) {
        a aVar2 = new a();
        this.f8766c = aVar2;
        z2.j jVar = new z2.j(aVar, "flutter/textinput", z2.f.f9002a);
        this.f8764a = jVar;
        jVar.e(aVar2);
    }

    private static HashMap<Object, Object> c(ArrayList<io.flutter.plugin.editing.g> arrayList) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        JSONArray jSONArray = new JSONArray();
        Iterator<io.flutter.plugin.editing.g> it = arrayList.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().b());
        }
        hashMap.put("deltas", jSONArray);
        return hashMap;
    }

    private static HashMap<Object, Object> d(String str, int i5, int i6, int i7, int i8) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("text", str);
        hashMap.put("selectionBase", Integer.valueOf(i5));
        hashMap.put("selectionExtent", Integer.valueOf(i6));
        hashMap.put("composingBase", Integer.valueOf(i7));
        hashMap.put("composingExtent", Integer.valueOf(i8));
        return hashMap;
    }

    public void b(int i5, Map<String, Object> map) {
        n2.b.f("TextInputChannel", "Sending 'commitContent' message.");
        this.f8764a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i5), "TextInputAction.commitContent", map));
    }

    public void e(int i5) {
        n2.b.f("TextInputChannel", "Sending 'done' message.");
        this.f8764a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i5), "TextInputAction.done"));
    }

    public void f(int i5) {
        n2.b.f("TextInputChannel", "Sending 'go' message.");
        this.f8764a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i5), "TextInputAction.go"));
    }

    public void g(int i5) {
        n2.b.f("TextInputChannel", "Sending 'newline' message.");
        this.f8764a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i5), "TextInputAction.newline"));
    }

    public void h(int i5) {
        n2.b.f("TextInputChannel", "Sending 'next' message.");
        this.f8764a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i5), "TextInputAction.next"));
    }

    public void i(int i5, String str, Bundle bundle) {
        HashMap hashMap = new HashMap();
        hashMap.put("action", str);
        if (bundle != null) {
            HashMap hashMap2 = new HashMap();
            for (String str2 : bundle.keySet()) {
                Object obj = bundle.get(str2);
                if (obj instanceof byte[]) {
                    hashMap2.put(str2, bundle.getByteArray(str2));
                } else if (obj instanceof Byte) {
                    hashMap2.put(str2, Byte.valueOf(bundle.getByte(str2)));
                } else if (obj instanceof char[]) {
                    hashMap2.put(str2, bundle.getCharArray(str2));
                } else if (obj instanceof Character) {
                    hashMap2.put(str2, Character.valueOf(bundle.getChar(str2)));
                } else if (obj instanceof CharSequence[]) {
                    hashMap2.put(str2, bundle.getCharSequenceArray(str2));
                } else if (obj instanceof CharSequence) {
                    hashMap2.put(str2, bundle.getCharSequence(str2));
                } else if (obj instanceof float[]) {
                    hashMap2.put(str2, bundle.getFloatArray(str2));
                } else if (obj instanceof Float) {
                    hashMap2.put(str2, Float.valueOf(bundle.getFloat(str2)));
                }
            }
            hashMap.put("data", hashMap2);
        }
        this.f8764a.c("TextInputClient.performPrivateCommand", Arrays.asList(Integer.valueOf(i5), hashMap));
    }

    public void j(int i5) {
        n2.b.f("TextInputChannel", "Sending 'previous' message.");
        this.f8764a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i5), "TextInputAction.previous"));
    }

    public void k() {
        this.f8764a.c("TextInputClient.requestExistingInputState", null);
    }

    public void l(int i5) {
        n2.b.f("TextInputChannel", "Sending 'search' message.");
        this.f8764a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i5), "TextInputAction.search"));
    }

    public void m(int i5) {
        n2.b.f("TextInputChannel", "Sending 'send' message.");
        this.f8764a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i5), "TextInputAction.send"));
    }

    public void n(f fVar) {
        this.f8765b = fVar;
    }

    public void o(int i5) {
        n2.b.f("TextInputChannel", "Sending 'unspecified' message.");
        this.f8764a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i5), "TextInputAction.unspecified"));
    }

    public void p(int i5, String str, int i6, int i7, int i8, int i9) {
        n2.b.f("TextInputChannel", "Sending message to update editing state: \nText: " + str + "\nSelection start: " + i6 + "\nSelection end: " + i7 + "\nComposing start: " + i8 + "\nComposing end: " + i9);
        this.f8764a.c("TextInputClient.updateEditingState", Arrays.asList(Integer.valueOf(i5), d(str, i6, i7, i8, i9)));
    }

    public void q(int i5, ArrayList<io.flutter.plugin.editing.g> arrayList) {
        n2.b.f("TextInputChannel", "Sending message to update editing state with deltas: \nNumber of deltas: " + arrayList.size());
        this.f8764a.c("TextInputClient.updateEditingStateWithDeltas", Arrays.asList(Integer.valueOf(i5), c(arrayList)));
    }

    public void r(int i5, HashMap<String, e> hashMap) {
        n2.b.f("TextInputChannel", "Sending message to update editing state for " + String.valueOf(hashMap.size()) + " field(s).");
        HashMap hashMap2 = new HashMap();
        for (Map.Entry<String, e> entry : hashMap.entrySet()) {
            e value = entry.getValue();
            hashMap2.put(entry.getKey(), d(value.f8793a, value.f8794b, value.f8795c, -1, -1));
        }
        this.f8764a.c("TextInputClient.updateEditingStateWithTag", Arrays.asList(Integer.valueOf(i5), hashMap2));
    }
}
