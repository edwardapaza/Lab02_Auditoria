package io.flutter.plugin.editing;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    private CharSequence f3959a;

    /* renamed from: b  reason: collision with root package name */
    private CharSequence f3960b;

    /* renamed from: c  reason: collision with root package name */
    private int f3961c;

    /* renamed from: d  reason: collision with root package name */
    private int f3962d;

    /* renamed from: e  reason: collision with root package name */
    private int f3963e;

    /* renamed from: f  reason: collision with root package name */
    private int f3964f;

    /* renamed from: g  reason: collision with root package name */
    private int f3965g;

    /* renamed from: h  reason: collision with root package name */
    private int f3966h;

    public g(CharSequence charSequence, int i5, int i6, int i7, int i8) {
        this.f3963e = i5;
        this.f3964f = i6;
        this.f3965g = i7;
        this.f3966h = i8;
        a(charSequence, "", -1, -1);
    }

    public g(CharSequence charSequence, int i5, int i6, CharSequence charSequence2, int i7, int i8, int i9, int i10) {
        this.f3963e = i7;
        this.f3964f = i8;
        this.f3965g = i9;
        this.f3966h = i10;
        a(charSequence, charSequence2.toString(), i5, i6);
    }

    private void a(CharSequence charSequence, CharSequence charSequence2, int i5, int i6) {
        this.f3959a = charSequence;
        this.f3960b = charSequence2;
        this.f3961c = i5;
        this.f3962d = i6;
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("oldText", this.f3959a.toString());
            jSONObject.put("deltaText", this.f3960b.toString());
            jSONObject.put("deltaStart", this.f3961c);
            jSONObject.put("deltaEnd", this.f3962d);
            jSONObject.put("selectionBase", this.f3963e);
            jSONObject.put("selectionExtent", this.f3964f);
            jSONObject.put("composingBase", this.f3965g);
            jSONObject.put("composingExtent", this.f3966h);
        } catch (JSONException e5) {
            n2.b.b("TextEditingDelta", "unable to create JSONObject: " + e5);
        }
        return jSONObject;
    }
}
