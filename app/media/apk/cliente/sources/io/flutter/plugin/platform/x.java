package io.flutter.plugin.platform;

import android.content.Context;
import android.graphics.Rect;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    private final Rect f4101a;

    /* renamed from: b  reason: collision with root package name */
    private final Rect f4102b;

    public x(Context context) {
        super(context);
        this.f4101a = new Rect();
        this.f4102b = new Rect();
    }

    private static int a(int i5) {
        return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i5), Integer.MIN_VALUE);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        for (int i9 = 0; i9 < getChildCount(); i9++) {
            View childAt = getChildAt(i9);
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) childAt.getLayoutParams();
            this.f4101a.set(i5, i6, i7, i8);
            Gravity.apply(layoutParams.gravity, childAt.getMeasuredWidth(), childAt.getMeasuredHeight(), this.f4101a, layoutParams.x, layoutParams.y, this.f4102b);
            Rect rect = this.f4102b;
            childAt.layout(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i5, int i6) {
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            getChildAt(i7).measure(a(i5), a(i6));
        }
        super.onMeasure(i5, i6);
    }
}
