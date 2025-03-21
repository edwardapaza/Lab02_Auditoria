package o;

import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class w0 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f6710a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f6711b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f6712c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ArrayList f6713d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ArrayList f6714e;

        a(int i5, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
            this.f6710a = i5;
            this.f6711b = arrayList;
            this.f6712c = arrayList2;
            this.f6713d = arrayList3;
            this.f6714e = arrayList4;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i5 = 0; i5 < this.f6710a; i5++) {
                androidx.core.view.l.l((View) this.f6711b.get(i5), (String) this.f6712c.get(i5));
                androidx.core.view.l.l((View) this.f6713d.get(i5), (String) this.f6714e.get(i5));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void f(List<View> list, View view) {
        int size = list.size();
        if (i(list, view, size)) {
            return;
        }
        if (androidx.core.view.l.f(view) != null) {
            list.add(view);
        }
        for (int i5 = size; i5 < list.size(); i5++) {
            View view2 = list.get(i5);
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i6 = 0; i6 < childCount; i6++) {
                    View childAt = viewGroup.getChildAt(i6);
                    if (!i(list, childAt, size) && androidx.core.view.l.f(childAt) != null) {
                        list.add(childAt);
                    }
                }
            }
        }
    }

    private static boolean i(List<View> list, View view, int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            if (list.get(i6) == view) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean l(List list) {
        return list == null || list.isEmpty();
    }

    public abstract void A(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract Object B(Object obj);

    public abstract void a(Object obj, View view);

    public abstract void b(Object obj, ArrayList<View> arrayList);

    public void c(Object obj) {
    }

    public void d(Object obj, Runnable runnable) {
    }

    public abstract void e(ViewGroup viewGroup, Object obj);

    public abstract boolean g(Object obj);

    public abstract Object h(Object obj);

    public Object j(ViewGroup viewGroup, Object obj) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(View view, Rect rect) {
        if (view.isAttachedToWindow()) {
            RectF rectF = new RectF();
            rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
            view.getMatrix().mapRect(rectF);
            rectF.offset(view.getLeft(), view.getTop());
            ViewParent parent = view.getParent();
            while (parent instanceof View) {
                View view2 = (View) parent;
                rectF.offset(-view2.getScrollX(), -view2.getScrollY());
                view2.getMatrix().mapRect(rectF);
                rectF.offset(view2.getLeft(), view2.getTop());
                parent = view2.getParent();
            }
            int[] iArr = new int[2];
            view.getRootView().getLocationOnScreen(iArr);
            rectF.offset(iArr[0], iArr[1]);
            rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
        }
    }

    public boolean m() {
        if (l0.I0(4)) {
            Log.i("FragmentManager", "Older versions of AndroidX Transition do not support seeking. Add dependency on AndroidX Transition 1.5.0 or higher to enable seeking.");
            return false;
        }
        return false;
    }

    public boolean n(Object obj) {
        return false;
    }

    public abstract Object o(Object obj, Object obj2, Object obj3);

    public abstract Object p(Object obj, Object obj2, Object obj3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<String> q(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = arrayList.get(i5);
            arrayList2.add(androidx.core.view.l.f(view));
            androidx.core.view.l.l(view, null);
        }
        return arrayList2;
    }

    public abstract void r(Object obj, View view, ArrayList<View> arrayList);

    public abstract void s(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    public void t(Object obj, float f5) {
    }

    public abstract void u(Object obj, Rect rect);

    public abstract void v(Object obj, View view);

    public void w(s sVar, Object obj, androidx.core.os.c cVar, Runnable runnable) {
        x(sVar, obj, cVar, null, runnable);
    }

    public void x(s sVar, Object obj, androidx.core.os.c cVar, Runnable runnable, Runnable runnable2) {
        runnable2.run();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(View view, ArrayList<View> arrayList, ArrayList<View> arrayList2, ArrayList<String> arrayList3, Map<String, String> map) {
        int size = arrayList2.size();
        ArrayList arrayList4 = new ArrayList();
        for (int i5 = 0; i5 < size; i5++) {
            View view2 = arrayList.get(i5);
            String f5 = androidx.core.view.l.f(view2);
            arrayList4.add(f5);
            if (f5 != null) {
                androidx.core.view.l.l(view2, null);
                String str = map.get(f5);
                int i6 = 0;
                while (true) {
                    if (i6 >= size) {
                        break;
                    } else if (str.equals(arrayList3.get(i6))) {
                        androidx.core.view.l.l(arrayList2.get(i6), f5);
                        break;
                    } else {
                        i6++;
                    }
                }
            }
        }
        androidx.core.view.i.a(view, new a(size, arrayList2, arrayList3, arrayList, arrayList4));
    }

    public abstract void z(Object obj, View view, ArrayList<View> arrayList);
}
