package io.flutter.plugin.editing;

import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import java.util.ArrayList;
import java.util.Iterator;
import y2.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends SpannableStringBuilder {

    /* renamed from: a  reason: collision with root package name */
    private int f3941a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f3942b = 0;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<b> f3943c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<b> f3944d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<g> f3945e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private String f3946f;

    /* renamed from: k  reason: collision with root package name */
    private String f3947k;

    /* renamed from: l  reason: collision with root package name */
    private int f3948l;

    /* renamed from: m  reason: collision with root package name */
    private int f3949m;

    /* renamed from: n  reason: collision with root package name */
    private int f3950n;

    /* renamed from: o  reason: collision with root package name */
    private int f3951o;

    /* renamed from: p  reason: collision with root package name */
    private BaseInputConnection f3952p;

    /* loaded from: classes.dex */
    class a extends BaseInputConnection {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Editable f3953a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(View view, boolean z4, Editable editable) {
            super(view, z4);
            this.f3953a = editable;
        }

        @Override // android.view.inputmethod.BaseInputConnection
        public Editable getEditable() {
            return this.f3953a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface b {
        void a(boolean z4, boolean z5, boolean z6);
    }

    public e(s.e eVar, View view) {
        this.f3952p = new a(view, true, this);
        if (eVar != null) {
            n(eVar);
        }
    }

    private void j(b bVar, boolean z4, boolean z5, boolean z6) {
        this.f3942b++;
        bVar.a(z4, z5, z6);
        this.f3942b--;
    }

    private void k(boolean z4, boolean z5, boolean z6) {
        if (z4 || z5 || z6) {
            Iterator<b> it = this.f3943c.iterator();
            while (it.hasNext()) {
                j(it.next(), z4, z5, z6);
            }
        }
    }

    public void a(b bVar) {
        ArrayList<b> arrayList;
        if (this.f3942b > 0) {
            n2.b.b("ListenableEditingState", "adding a listener " + bVar.toString() + " in a listener callback");
        }
        if (this.f3941a > 0) {
            n2.b.g("ListenableEditingState", "a listener was added to EditingState while a batch edit was in progress");
            arrayList = this.f3944d;
        } else {
            arrayList = this.f3943c;
        }
        arrayList.add(bVar);
    }

    public void b() {
        this.f3941a++;
        if (this.f3942b > 0) {
            n2.b.b("ListenableEditingState", "editing state should not be changed in a listener callback");
        }
        if (this.f3941a != 1 || this.f3943c.isEmpty()) {
            return;
        }
        this.f3947k = toString();
        this.f3948l = i();
        this.f3949m = h();
        this.f3950n = g();
        this.f3951o = f();
    }

    public void c() {
        this.f3945e.clear();
    }

    public void d() {
        int i5 = this.f3941a;
        if (i5 == 0) {
            n2.b.b("ListenableEditingState", "endBatchEdit called without a matching beginBatchEdit");
            return;
        }
        if (i5 == 1) {
            Iterator<b> it = this.f3944d.iterator();
            while (it.hasNext()) {
                j(it.next(), true, true, true);
            }
            if (!this.f3943c.isEmpty()) {
                n2.b.f("ListenableEditingState", "didFinishBatchEdit with " + String.valueOf(this.f3943c.size()) + " listener(s)");
                boolean z4 = false;
                k(!toString().equals(this.f3947k), (this.f3948l == i() && this.f3949m == h()) ? false : true, (this.f3950n == g() && this.f3951o == f()) ? true : true);
            }
        }
        this.f3943c.addAll(this.f3944d);
        this.f3944d.clear();
        this.f3941a--;
    }

    public ArrayList<g> e() {
        ArrayList<g> arrayList = new ArrayList<>(this.f3945e);
        this.f3945e.clear();
        return arrayList;
    }

    public final int f() {
        return BaseInputConnection.getComposingSpanEnd(this);
    }

    public final int g() {
        return BaseInputConnection.getComposingSpanStart(this);
    }

    public final int h() {
        return Selection.getSelectionEnd(this);
    }

    public final int i() {
        return Selection.getSelectionStart(this);
    }

    public void l(b bVar) {
        if (this.f3942b > 0) {
            n2.b.b("ListenableEditingState", "removing a listener " + bVar.toString() + " in a listener callback");
        }
        this.f3943c.remove(bVar);
        if (this.f3941a > 0) {
            this.f3944d.remove(bVar);
        }
    }

    public void m(int i5, int i6) {
        if (i5 < 0 || i5 >= i6) {
            BaseInputConnection.removeComposingSpans(this);
        } else {
            this.f3952p.setComposingRegion(i5, i6);
        }
    }

    public void n(s.e eVar) {
        b();
        replace(0, length(), (CharSequence) eVar.f8793a);
        if (eVar.c()) {
            Selection.setSelection(this, eVar.f8794b, eVar.f8795c);
        } else {
            Selection.removeSelection(this);
        }
        m(eVar.f8796d, eVar.f8797e);
        c();
        d();
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder replace(int i5, int i6, CharSequence charSequence, int i7, int i8) {
        boolean z4;
        boolean z5;
        if (this.f3942b > 0) {
            n2.b.b("ListenableEditingState", "editing state should not be changed in a listener callback");
        }
        String eVar = toString();
        int i9 = i6 - i5;
        boolean z6 = i9 != i8 - i7;
        for (int i10 = 0; i10 < i9 && !z6; i10++) {
            z6 |= charAt(i5 + i10) != charSequence.charAt(i7 + i10);
        }
        if (z6) {
            this.f3946f = null;
        }
        int i11 = i();
        int h5 = h();
        int g5 = g();
        int f5 = f();
        SpannableStringBuilder replace = super.replace(i5, i6, charSequence, i7, i8);
        boolean z7 = z6;
        this.f3945e.add(new g(eVar, i5, i6, charSequence, i(), h(), g(), f()));
        if (this.f3941a > 0) {
            return replace;
        }
        boolean z8 = (i() == i11 && h() == h5) ? false : true;
        if (g() == g5 && f() == f5) {
            z4 = z7;
            z5 = false;
        } else {
            z4 = z7;
            z5 = true;
        }
        k(z4, z8, z5);
        return replace;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void setSpan(Object obj, int i5, int i6, int i7) {
        super.setSpan(obj, i5, i6, i7);
        this.f3945e.add(new g(toString(), i(), h(), g(), f()));
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public String toString() {
        String str = this.f3946f;
        if (str != null) {
            return str;
        }
        String spannableStringBuilder = super.toString();
        this.f3946f = spannableStringBuilder;
        return spannableStringBuilder;
    }
}
