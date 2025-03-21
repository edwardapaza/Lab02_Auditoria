package androidx.core.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.View$OnUnhandledKeyEventListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.c0;
import androidx.core.view.l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f496a = {i.d.accessibility_custom_action_0, i.d.accessibility_custom_action_1, i.d.accessibility_custom_action_2, i.d.accessibility_custom_action_3, i.d.accessibility_custom_action_4, i.d.accessibility_custom_action_5, i.d.accessibility_custom_action_6, i.d.accessibility_custom_action_7, i.d.accessibility_custom_action_8, i.d.accessibility_custom_action_9, i.d.accessibility_custom_action_10, i.d.accessibility_custom_action_11, i.d.accessibility_custom_action_12, i.d.accessibility_custom_action_13, i.d.accessibility_custom_action_14, i.d.accessibility_custom_action_15, i.d.accessibility_custom_action_16, i.d.accessibility_custom_action_17, i.d.accessibility_custom_action_18, i.d.accessibility_custom_action_19, i.d.accessibility_custom_action_20, i.d.accessibility_custom_action_21, i.d.accessibility_custom_action_22, i.d.accessibility_custom_action_23, i.d.accessibility_custom_action_24, i.d.accessibility_custom_action_25, i.d.accessibility_custom_action_26, i.d.accessibility_custom_action_27, i.d.accessibility_custom_action_28, i.d.accessibility_custom_action_29, i.d.accessibility_custom_action_30, i.d.accessibility_custom_action_31};

    /* renamed from: b  reason: collision with root package name */
    private static final androidx.core.view.h f497b = new androidx.core.view.h() { // from class: androidx.core.view.k
    };

    /* renamed from: c  reason: collision with root package name */
    private static final b f498c = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends c<CharSequence> {
        a(int i5, Class cls, int i6, int i7) {
            super(i5, cls, i6, i7);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.l.c
        /* renamed from: d */
        public CharSequence b(View view) {
            return g.b(view);
        }
    }

    /* loaded from: classes.dex */
    static class b implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        private final WeakHashMap<View, Boolean> f499a = new WeakHashMap<>();

        b() {
        }

        private void a(Map.Entry<View, Boolean> entry) {
            View key = entry.getKey();
            boolean booleanValue = entry.getValue().booleanValue();
            boolean z4 = key.isShown() && key.getWindowVisibility() == 0;
            if (booleanValue != z4) {
                l.g(key, z4 ? 16 : 32);
                entry.setValue(Boolean.valueOf(z4));
            }
        }

        private void b(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                for (Map.Entry<View, Boolean> entry : this.f499a.entrySet()) {
                    a(entry);
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            b(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class c<T> {

        /* renamed from: a  reason: collision with root package name */
        private final int f500a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<T> f501b;

        /* renamed from: c  reason: collision with root package name */
        private final int f502c;

        /* renamed from: d  reason: collision with root package name */
        private final int f503d;

        c(int i5, Class<T> cls, int i6, int i7) {
            this.f500a = i5;
            this.f501b = cls;
            this.f503d = i6;
            this.f502c = i7;
        }

        private boolean a() {
            return Build.VERSION.SDK_INT >= this.f502c;
        }

        abstract T b(View view);

        T c(View view) {
            if (a()) {
                return b(view);
            }
            T t5 = (T) view.getTag(this.f500a);
            if (this.f501b.isInstance(t5)) {
                return t5;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class d {
        static WindowInsets a(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        static WindowInsets b(View view, WindowInsets windowInsets) {
            return view.onApplyWindowInsets(windowInsets);
        }

        static void c(View view) {
            view.requestApplyInsets();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class e {

        /* loaded from: classes.dex */
        class a implements View.OnApplyWindowInsetsListener {

            /* renamed from: a  reason: collision with root package name */
            c0 f504a = null;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ View f505b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ androidx.core.view.g f506c;

            a(View view, androidx.core.view.g gVar) {
                this.f505b = view;
                this.f506c = gVar;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                c0 o5 = c0.o(windowInsets, view);
                int i5 = Build.VERSION.SDK_INT;
                if (i5 < 30) {
                    e.a(windowInsets, this.f505b);
                    if (o5.equals(this.f504a)) {
                        return this.f506c.a(view, o5).m();
                    }
                }
                this.f504a = o5;
                c0 a5 = this.f506c.a(view, o5);
                if (i5 >= 30) {
                    return a5.m();
                }
                l.j(view);
                return a5.m();
            }
        }

        static void a(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(i.d.tag_window_insets_animation_callback);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        static c0 b(View view, c0 c0Var, Rect rect) {
            WindowInsets m5 = c0Var.m();
            if (m5 != null) {
                return c0.o(view.computeSystemWindowInsets(m5, rect), view);
            }
            rect.setEmpty();
            return c0Var;
        }

        static boolean c(View view, float f5, float f6, boolean z4) {
            return view.dispatchNestedFling(f5, f6, z4);
        }

        static boolean d(View view, float f5, float f6) {
            return view.dispatchNestedPreFling(f5, f6);
        }

        static boolean e(View view, int i5, int i6, int[] iArr, int[] iArr2) {
            return view.dispatchNestedPreScroll(i5, i6, iArr, iArr2);
        }

        static boolean f(View view, int i5, int i6, int i7, int i8, int[] iArr) {
            return view.dispatchNestedScroll(i5, i6, i7, i8, iArr);
        }

        static ColorStateList g(View view) {
            return view.getBackgroundTintList();
        }

        static PorterDuff.Mode h(View view) {
            return view.getBackgroundTintMode();
        }

        static float i(View view) {
            return view.getElevation();
        }

        public static c0 j(View view) {
            return c0.a.a(view);
        }

        static String k(View view) {
            return view.getTransitionName();
        }

        static float l(View view) {
            return view.getTranslationZ();
        }

        static float m(View view) {
            return view.getZ();
        }

        static boolean n(View view) {
            return view.hasNestedScrollingParent();
        }

        static boolean o(View view) {
            return view.isImportantForAccessibility();
        }

        static boolean p(View view) {
            return view.isNestedScrollingEnabled();
        }

        static void q(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
        }

        static void r(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
        }

        static void s(View view, float f5) {
            view.setElevation(f5);
        }

        static void t(View view, boolean z4) {
            view.setNestedScrollingEnabled(z4);
        }

        static void u(View view, androidx.core.view.g gVar) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(i.d.tag_on_apply_window_listener, gVar);
            }
            if (gVar == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(i.d.tag_window_insets_animation_callback));
            } else {
                view.setOnApplyWindowInsetsListener(new a(view, gVar));
            }
        }

        static void v(View view, String str) {
            view.setTransitionName(str);
        }

        static void w(View view, float f5) {
            view.setTranslationZ(f5);
        }

        static void x(View view, float f5) {
            view.setZ(f5);
        }

        static boolean y(View view, int i5) {
            return view.startNestedScroll(i5);
        }

        static void z(View view) {
            view.stopNestedScroll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class f {
        public static c0 a(View view) {
            WindowInsets rootWindowInsets;
            rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            c0 n5 = c0.n(rootWindowInsets);
            n5.k(n5);
            n5.d(view.getRootView());
            return n5;
        }

        static int b(View view) {
            int scrollIndicators;
            scrollIndicators = view.getScrollIndicators();
            return scrollIndicators;
        }

        static void c(View view, int i5) {
            view.setScrollIndicators(i5);
        }

        static void d(View view, int i5, int i6) {
            view.setScrollIndicators(i5, i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class g {
        static void a(View view, final h hVar) {
            int i5 = i.d.tag_unhandled_key_listeners;
            androidx.collection.f fVar = (androidx.collection.f) view.getTag(i5);
            if (fVar == null) {
                fVar = new androidx.collection.f();
                view.setTag(i5, fVar);
            }
            Objects.requireNonNull(hVar);
            View$OnUnhandledKeyEventListener view$OnUnhandledKeyEventListener = new View$OnUnhandledKeyEventListener() { // from class: androidx.core.view.a0
                public final boolean onUnhandledKeyEvent(View view2, KeyEvent keyEvent) {
                    return l.h.this.onUnhandledKeyEvent(view2, keyEvent);
                }
            };
            fVar.put(hVar, view$OnUnhandledKeyEventListener);
            view.addOnUnhandledKeyEventListener(view$OnUnhandledKeyEventListener);
        }

        static CharSequence b(View view) {
            CharSequence accessibilityPaneTitle;
            accessibilityPaneTitle = view.getAccessibilityPaneTitle();
            return accessibilityPaneTitle;
        }

        static boolean c(View view) {
            boolean isAccessibilityHeading;
            isAccessibilityHeading = view.isAccessibilityHeading();
            return isAccessibilityHeading;
        }

        static boolean d(View view) {
            boolean isScreenReaderFocusable;
            isScreenReaderFocusable = view.isScreenReaderFocusable();
            return isScreenReaderFocusable;
        }

        static void e(View view, h hVar) {
            View$OnUnhandledKeyEventListener view$OnUnhandledKeyEventListener;
            androidx.collection.f fVar = (androidx.collection.f) view.getTag(i.d.tag_unhandled_key_listeners);
            if (fVar == null || (view$OnUnhandledKeyEventListener = (View$OnUnhandledKeyEventListener) fVar.get(hVar)) == null) {
                return;
            }
            view.removeOnUnhandledKeyEventListener(view$OnUnhandledKeyEventListener);
        }

        static <T> T f(View view, int i5) {
            View requireViewById;
            requireViewById = view.requireViewById(i5);
            return (T) requireViewById;
        }

        static void g(View view, boolean z4) {
            view.setAccessibilityHeading(z4);
        }

        static void h(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        public static void i(View view, l.a aVar) {
            view.setAutofillId(null);
        }

        static void j(View view, boolean z4) {
            view.setScreenReaderFocusable(z4);
        }
    }

    /* loaded from: classes.dex */
    public interface h {
        boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent);
    }

    /* loaded from: classes.dex */
    static class i {

        /* renamed from: d  reason: collision with root package name */
        private static final ArrayList<WeakReference<View>> f507d = new ArrayList<>();

        /* renamed from: a  reason: collision with root package name */
        private WeakHashMap<View, Boolean> f508a = null;

        /* renamed from: b  reason: collision with root package name */
        private SparseArray<WeakReference<View>> f509b = null;

        /* renamed from: c  reason: collision with root package name */
        private WeakReference<KeyEvent> f510c = null;

        i() {
        }

        static i a(View view) {
            int i5 = i.d.tag_unhandled_key_event_manager;
            i iVar = (i) view.getTag(i5);
            if (iVar == null) {
                i iVar2 = new i();
                view.setTag(i5, iVar2);
                return iVar2;
            }
            return iVar;
        }

        private View c(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.f508a;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View c5 = c(viewGroup.getChildAt(childCount), keyEvent);
                        if (c5 != null) {
                            return c5;
                        }
                    }
                }
                if (e(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        private SparseArray<WeakReference<View>> d() {
            if (this.f509b == null) {
                this.f509b = new SparseArray<>();
            }
            return this.f509b;
        }

        private boolean e(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(i.d.tag_unhandled_key_listeners);
            if (arrayList != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (((h) arrayList.get(size)).onUnhandledKeyEvent(view, keyEvent)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }

        private void g() {
            WeakHashMap<View, Boolean> weakHashMap = this.f508a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList<WeakReference<View>> arrayList = f507d;
            if (arrayList.isEmpty()) {
                return;
            }
            synchronized (arrayList) {
                if (this.f508a == null) {
                    this.f508a = new WeakHashMap<>();
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ArrayList<WeakReference<View>> arrayList2 = f507d;
                    View view = arrayList2.get(size).get();
                    if (view == null) {
                        arrayList2.remove(size);
                    } else {
                        this.f508a.put(view, Boolean.TRUE);
                        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                            this.f508a.put((View) parent, Boolean.TRUE);
                        }
                    }
                }
            }
        }

        boolean b(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                g();
            }
            View c5 = c(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (c5 != null && !KeyEvent.isModifierKey(keyCode)) {
                    d().put(keyCode, new WeakReference<>(c5));
                }
            }
            return c5 != null;
        }

        boolean f(KeyEvent keyEvent) {
            int indexOfKey;
            WeakReference<KeyEvent> weakReference = this.f510c;
            if (weakReference == null || weakReference.get() != keyEvent) {
                this.f510c = new WeakReference<>(keyEvent);
                WeakReference<View> weakReference2 = null;
                SparseArray<WeakReference<View>> d5 = d();
                if (keyEvent.getAction() == 1 && (indexOfKey = d5.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                    weakReference2 = d5.valueAt(indexOfKey);
                    d5.removeAt(indexOfKey);
                }
                if (weakReference2 == null) {
                    weakReference2 = d5.get(keyEvent.getKeyCode());
                }
                if (weakReference2 != null) {
                    View view = weakReference2.get();
                    if (view != null && view.isAttachedToWindow()) {
                        e(view, keyEvent);
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
    }

    public static c0 a(View view, c0 c0Var) {
        WindowInsets m5 = c0Var.m();
        if (m5 != null) {
            WindowInsets a5 = d.a(view, m5);
            if (!a5.equals(m5)) {
                return c0.o(a5, view);
            }
        }
        return c0Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return i.a(view).b(view, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return i.a(view).f(keyEvent);
    }

    public static CharSequence d(View view) {
        return i().c(view);
    }

    public static c0 e(View view) {
        return Build.VERSION.SDK_INT >= 23 ? f.a(view) : e.j(view);
    }

    public static String f(View view) {
        return e.k(view);
    }

    static void g(View view, int i5) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z4 = d(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (view.getAccessibilityLiveRegion() != 0 || z4) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                obtain.setEventType(z4 ? 32 : 2048);
                obtain.setContentChangeTypes(i5);
                if (z4) {
                    obtain.getText().add(d(view));
                    k(view);
                }
                view.sendAccessibilityEventUnchecked(obtain);
            } else if (i5 == 32) {
                AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(obtain2);
                obtain2.setEventType(32);
                obtain2.setContentChangeTypes(i5);
                obtain2.setSource(view);
                view.onPopulateAccessibilityEvent(obtain2);
                obtain2.getText().add(d(view));
                accessibilityManager.sendAccessibilityEvent(obtain2);
            } else if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i5);
                } catch (AbstractMethodError e5) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e5);
                }
            }
        }
    }

    public static c0 h(View view, c0 c0Var) {
        WindowInsets m5 = c0Var.m();
        if (m5 != null) {
            WindowInsets b5 = d.b(view, m5);
            if (!b5.equals(m5)) {
                return c0.o(b5, view);
            }
        }
        return c0Var;
    }

    private static c<CharSequence> i() {
        return new a(i.d.tag_accessibility_pane_title, CharSequence.class, 8, 28);
    }

    public static void j(View view) {
        d.c(view);
    }

    private static void k(View view) {
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
    }

    public static void l(View view, String str) {
        e.v(view, str);
    }
}
