package o;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s0 {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<s> f6655a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, r0> f6656b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<String, Bundle> f6657c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private o0 f6658d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(o0 o0Var) {
        this.f6658d = o0Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle B(String str, Bundle bundle) {
        return bundle != null ? this.f6657c.put(str, bundle) : this.f6657c.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(s sVar) {
        if (this.f6655a.contains(sVar)) {
            throw new IllegalStateException("Fragment already added: " + sVar);
        }
        synchronized (this.f6655a) {
            this.f6655a.add(sVar);
        }
        sVar.f6615p = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f6656b.values().removeAll(Collections.singleton(null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(String str) {
        return this.f6656b.get(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(int i5) {
        for (r0 r0Var : this.f6656b.values()) {
            if (r0Var != null) {
                r0Var.s(i5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "    ";
        if (!this.f6656b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (r0 r0Var : this.f6656b.values()) {
                printWriter.print(str);
                if (r0Var != null) {
                    s k5 = r0Var.k();
                    printWriter.println(k5);
                    k5.i(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size = this.f6655a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i5 = 0; i5 < size; i5++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i5);
                printWriter.print(": ");
                printWriter.println(this.f6655a.get(i5).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s f(String str) {
        r0 r0Var = this.f6656b.get(str);
        if (r0Var != null) {
            return r0Var.k();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s g(int i5) {
        for (int size = this.f6655a.size() - 1; size >= 0; size--) {
            s sVar = this.f6655a.get(size);
            if (sVar != null && sVar.C == i5) {
                return sVar;
            }
        }
        for (r0 r0Var : this.f6656b.values()) {
            if (r0Var != null) {
                s k5 = r0Var.k();
                if (k5.C == i5) {
                    return k5;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s h(String str) {
        if (str != null) {
            for (int size = this.f6655a.size() - 1; size >= 0; size--) {
                s sVar = this.f6655a.get(size);
                if (sVar != null && str.equals(sVar.E)) {
                    return sVar;
                }
            }
        }
        if (str != null) {
            for (r0 r0Var : this.f6656b.values()) {
                if (r0Var != null) {
                    s k5 = r0Var.k();
                    if (str.equals(k5.E)) {
                        return k5;
                    }
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s i(String str) {
        s m5;
        for (r0 r0Var : this.f6656b.values()) {
            if (r0Var != null && (m5 = r0Var.k().m(str)) != null) {
                return m5;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j(s sVar) {
        View view;
        View view2;
        ViewGroup viewGroup = sVar.M;
        if (viewGroup == null) {
            return -1;
        }
        int indexOf = this.f6655a.indexOf(sVar);
        for (int i5 = indexOf - 1; i5 >= 0; i5--) {
            s sVar2 = this.f6655a.get(i5);
            if (sVar2.M == viewGroup && (view2 = sVar2.N) != null) {
                return viewGroup.indexOfChild(view2) + 1;
            }
        }
        while (true) {
            indexOf++;
            if (indexOf >= this.f6655a.size()) {
                return -1;
            }
            s sVar3 = this.f6655a.get(indexOf);
            if (sVar3.M == viewGroup && (view = sVar3.N) != null) {
                return viewGroup.indexOfChild(view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<r0> k() {
        ArrayList arrayList = new ArrayList();
        for (r0 r0Var : this.f6656b.values()) {
            if (r0Var != null) {
                arrayList.add(r0Var);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<s> l() {
        ArrayList arrayList = new ArrayList();
        Iterator<r0> it = this.f6656b.values().iterator();
        while (it.hasNext()) {
            r0 next = it.next();
            arrayList.add(next != null ? next.k() : null);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HashMap<String, Bundle> m() {
        return this.f6657c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r0 n(String str) {
        return this.f6656b.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<s> o() {
        ArrayList arrayList;
        if (this.f6655a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f6655a) {
            arrayList = new ArrayList(this.f6655a);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o0 p() {
        return this.f6658d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle q(String str) {
        return this.f6657c.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(r0 r0Var) {
        s k5 = r0Var.k();
        if (c(k5.f6607f)) {
            return;
        }
        this.f6656b.put(k5.f6607f, r0Var);
        if (k5.I) {
            if (k5.H) {
                this.f6658d.d(k5);
            } else {
                this.f6658d.n(k5);
            }
            k5.I = false;
        }
        if (l0.I0(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + k5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(r0 r0Var) {
        s k5 = r0Var.k();
        if (k5.H) {
            this.f6658d.n(k5);
        }
        if (this.f6656b.get(k5.f6607f) == r0Var && this.f6656b.put(k5.f6607f, null) != null && l0.I0(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + k5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t() {
        Iterator<s> it = this.f6655a.iterator();
        while (it.hasNext()) {
            r0 r0Var = this.f6656b.get(it.next().f6607f);
            if (r0Var != null) {
                r0Var.m();
            }
        }
        for (r0 r0Var2 : this.f6656b.values()) {
            if (r0Var2 != null) {
                r0Var2.m();
                s k5 = r0Var2.k();
                if (k5.f6616q && !k5.b0()) {
                    if (k5.f6618s && !this.f6657c.containsKey(k5.f6607f)) {
                        B(k5.f6607f, r0Var2.q());
                    }
                    s(r0Var2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(s sVar) {
        synchronized (this.f6655a) {
            this.f6655a.remove(sVar);
        }
        sVar.f6615p = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v() {
        this.f6656b.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(List<String> list) {
        this.f6655a.clear();
        if (list != null) {
            for (String str : list) {
                s f5 = f(str);
                if (f5 == null) {
                    throw new IllegalStateException("No instantiated fragment for (" + str + ")");
                }
                if (l0.I0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + f5);
                }
                a(f5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(HashMap<String, Bundle> hashMap) {
        this.f6657c.clear();
        this.f6657c.putAll(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<String> y() {
        ArrayList<String> arrayList = new ArrayList<>(this.f6656b.size());
        for (r0 r0Var : this.f6656b.values()) {
            if (r0Var != null) {
                s k5 = r0Var.k();
                B(k5.f6607f, r0Var.q());
                arrayList.add(k5.f6607f);
                if (l0.I0(2)) {
                    Log.v("FragmentManager", "Saved state of " + k5 + ": " + k5.f6599b);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<String> z() {
        synchronized (this.f6655a) {
            if (this.f6655a.isEmpty()) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>(this.f6655a.size());
            Iterator<s> it = this.f6655a.iterator();
            while (it.hasNext()) {
                s next = it.next();
                arrayList.add(next.f6607f);
                if (l0.I0(2)) {
                    Log.v("FragmentManager", "saveAllState: adding fragment (" + next.f6607f + "): " + next);
                }
            }
            return arrayList;
        }
    }
}
