package io.flutter.plugin.platform;

import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private io.flutter.view.h f4003a;

    public boolean a(MotionEvent motionEvent, boolean z4) {
        io.flutter.view.h hVar = this.f4003a;
        if (hVar == null) {
            return false;
        }
        return hVar.M(motionEvent, z4);
    }

    public boolean b(View view, View view2, AccessibilityEvent accessibilityEvent) {
        io.flutter.view.h hVar = this.f4003a;
        if (hVar == null) {
            return false;
        }
        return hVar.w(view, view2, accessibilityEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(io.flutter.view.h hVar) {
        this.f4003a = hVar;
    }
}
