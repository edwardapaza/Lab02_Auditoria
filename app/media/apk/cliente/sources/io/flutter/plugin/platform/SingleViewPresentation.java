package io.flutter.plugin.platform;

import android.app.AlertDialog;
import android.app.Presentation;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.MutableContextWrapper;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class SingleViewPresentation extends Presentation {
    private static final String TAG = "PlatformViewsController";
    private final io.flutter.plugin.platform.a accessibilityEventsDelegate;
    private FrameLayout container;
    private final View.OnFocusChangeListener focusChangeListener;
    private final Context outerContext;
    private a rootView;
    private boolean startFocused;
    private final d state;
    private int viewId;

    /* loaded from: classes.dex */
    private static class a extends FrameLayout {

        /* renamed from: a  reason: collision with root package name */
        private final io.flutter.plugin.platform.a f3994a;

        /* renamed from: b  reason: collision with root package name */
        private final View f3995b;

        public a(Context context, io.flutter.plugin.platform.a aVar, View view) {
            super(context);
            this.f3994a = aVar;
            this.f3995b = view;
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public boolean requestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f3994a.b(this.f3995b, view, accessibilityEvent);
        }
    }

    /* loaded from: classes.dex */
    private static class b extends ContextWrapper {

        /* renamed from: a  reason: collision with root package name */
        private final InputMethodManager f3996a;

        b(Context context) {
            this(context, null);
        }

        private b(Context context, InputMethodManager inputMethodManager) {
            super(context);
            this.f3996a = inputMethodManager == null ? (InputMethodManager) context.getSystemService("input_method") : inputMethodManager;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Context createDisplayContext(Display display) {
            return new b(super.createDisplayContext(display), this.f3996a);
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Object getSystemService(String str) {
            return "input_method".equals(str) ? this.f3996a : super.getSystemService(str);
        }
    }

    /* loaded from: classes.dex */
    private static class c extends ContextWrapper {

        /* renamed from: a  reason: collision with root package name */
        private final h0 f3997a;

        /* renamed from: b  reason: collision with root package name */
        private WindowManager f3998b;

        /* renamed from: c  reason: collision with root package name */
        private final Context f3999c;

        c(Context context, h0 h0Var, Context context2) {
            super(context);
            this.f3997a = h0Var;
            this.f3999c = context2;
        }

        private WindowManager a() {
            if (this.f3998b == null) {
                this.f3998b = this.f3997a;
            }
            return this.f3998b;
        }

        private boolean b() {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            for (int i5 = 0; i5 < stackTrace.length && i5 < 11; i5++) {
                if (stackTrace[i5].getClassName().equals(AlertDialog.class.getCanonicalName()) && stackTrace[i5].getMethodName().equals("<init>")) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Object getSystemService(String str) {
            return "window".equals(str) ? b() ? this.f3999c.getSystemService(str) : a() : super.getSystemService(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        private i f4000a;

        /* renamed from: b  reason: collision with root package name */
        private h0 f4001b;

        /* renamed from: c  reason: collision with root package name */
        private x f4002c;

        d() {
        }
    }

    public SingleViewPresentation(Context context, Display display, io.flutter.plugin.platform.a aVar, d dVar, View.OnFocusChangeListener onFocusChangeListener, boolean z4) {
        super(new b(context), display);
        this.startFocused = false;
        this.accessibilityEventsDelegate = aVar;
        this.state = dVar;
        this.focusChangeListener = onFocusChangeListener;
        this.outerContext = context;
        getWindow().setFlags(8, 8);
        this.startFocused = z4;
    }

    public SingleViewPresentation(Context context, Display display, i iVar, io.flutter.plugin.platform.a aVar, int i5, View.OnFocusChangeListener onFocusChangeListener) {
        super(new b(context), display);
        this.startFocused = false;
        this.accessibilityEventsDelegate = aVar;
        this.viewId = i5;
        this.focusChangeListener = onFocusChangeListener;
        this.outerContext = context;
        d dVar = new d();
        this.state = dVar;
        dVar.f4000a = iVar;
        getWindow().setFlags(8, 8);
        getWindow().setType(2030);
    }

    public d detachState() {
        FrameLayout frameLayout = this.container;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        a aVar = this.rootView;
        if (aVar != null) {
            aVar.removeAllViews();
        }
        return this.state;
    }

    public i getView() {
        return this.state.f4000a;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        if (this.state.f4002c == null) {
            this.state.f4002c = new x(getContext());
        }
        if (this.state.f4001b == null) {
            d dVar = this.state;
            dVar.f4001b = new h0((WindowManager) getContext().getSystemService("window"), dVar.f4002c);
        }
        this.container = new FrameLayout(getContext());
        c cVar = new c(getContext(), this.state.f4001b, this.outerContext);
        View c5 = this.state.f4000a.c();
        if (c5.getContext() instanceof MutableContextWrapper) {
            ((MutableContextWrapper) c5.getContext()).setBaseContext(cVar);
        } else {
            n2.b.g(TAG, "Unexpected platform view context for view ID " + this.viewId + "; some functionality may not work correctly. When constructing a platform view in the factory, ensure that the view returned from PlatformViewFactory#create returns the provided context from getContext(). If you are unable to associate the view with that context, consider using Hybrid Composition instead.");
        }
        this.container.addView(c5);
        a aVar = new a(getContext(), this.accessibilityEventsDelegate, c5);
        this.rootView = aVar;
        aVar.addView(this.container);
        this.rootView.addView(this.state.f4002c);
        c5.setOnFocusChangeListener(this.focusChangeListener);
        this.rootView.setFocusableInTouchMode(true);
        if (this.startFocused) {
            c5.requestFocus();
        } else {
            this.rootView.requestFocus();
        }
        setContentView(this.rootView);
    }
}
