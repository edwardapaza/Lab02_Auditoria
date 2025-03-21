package io.flutter.view;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.accessibility.AccessibilityRecord;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class AccessibilityViewEmbedder {
    private static final String TAG = "AccessibilityBridge";
    private int nextFlutterId;
    private final View rootAccessibilityView;
    private final b reflectionAccessors = new b();
    private final SparseArray<c> flutterIdToOrigin = new SparseArray<>();
    private final Map<c, Integer> originToFlutterId = new HashMap();
    private final Map<View, Rect> embeddedViewToDisplayBounds = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Method f4186a;

        /* renamed from: b  reason: collision with root package name */
        private final Method f4187b;

        /* renamed from: c  reason: collision with root package name */
        private final Method f4188c;

        /* renamed from: d  reason: collision with root package name */
        private final Method f4189d;

        /* renamed from: e  reason: collision with root package name */
        private final Field f4190e;

        /* renamed from: f  reason: collision with root package name */
        private final Method f4191f;

        /* JADX WARN: Multi-variable type inference failed */
        private b() {
            Method method;
            Method method2;
            Method method3;
            Field field;
            Field declaredField;
            Method method4;
            Method method5;
            Field field2;
            Method method6 = null;
            try {
                method = AccessibilityNodeInfo.class.getMethod("getSourceNodeId", new Class[0]);
            } catch (NoSuchMethodException unused) {
                n2.b.g(AccessibilityViewEmbedder.TAG, "can't invoke AccessibilityNodeInfo#getSourceNodeId with reflection");
                method = null;
            }
            try {
                method2 = AccessibilityRecord.class.getMethod("getSourceNodeId", new Class[0]);
            } catch (NoSuchMethodException unused2) {
                n2.b.g(AccessibilityViewEmbedder.TAG, "can't invoke AccessibiiltyRecord#getSourceNodeId with reflection");
                method2 = null;
            }
            if (Build.VERSION.SDK_INT > 26) {
                try {
                    declaredField = AccessibilityNodeInfo.class.getDeclaredField("mChildNodeIds");
                    declaredField.setAccessible(true);
                    method4 = Class.forName("android.util.LongArray").getMethod("get", Integer.TYPE);
                    method3 = null;
                } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException | NullPointerException unused3) {
                    n2.b.g(AccessibilityViewEmbedder.TAG, "can't access childNodeIdsField with reflection");
                    method3 = null;
                    field = null;
                }
                this.f4186a = method;
                this.f4187b = method6;
                this.f4188c = method2;
                this.f4189d = method3;
                this.f4190e = declaredField;
                this.f4191f = method4;
            }
            try {
                method5 = AccessibilityNodeInfo.class.getMethod("getParentNodeId", new Class[0]);
            } catch (NoSuchMethodException unused4) {
                n2.b.g(AccessibilityViewEmbedder.TAG, "can't invoke getParentNodeId with reflection");
                method5 = null;
            }
            try {
                method3 = AccessibilityNodeInfo.class.getMethod("getChildId", Integer.TYPE);
                field2 = null;
            } catch (NoSuchMethodException unused5) {
                n2.b.g(AccessibilityViewEmbedder.TAG, "can't invoke getChildId with reflection");
                method3 = null;
                field2 = null;
            }
            method6 = method5;
            field = field2;
            declaredField = field;
            method4 = field;
            this.f4186a = method;
            this.f4187b = method6;
            this.f4188c = method2;
            this.f4189d = method3;
            this.f4190e = declaredField;
            this.f4191f = method4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Long f(AccessibilityNodeInfo accessibilityNodeInfo, int i5) {
            String str;
            Method method = this.f4189d;
            if (method == null && (this.f4190e == null || this.f4191f == null)) {
                return null;
            }
            if (method != null) {
                try {
                    return (Long) method.invoke(accessibilityNodeInfo, Integer.valueOf(i5));
                } catch (IllegalAccessException e5) {
                    e = e5;
                    str = "Failed to access getChildId method.";
                } catch (InvocationTargetException e6) {
                    e = e6;
                    str = "The getChildId method threw an exception when invoked.";
                }
            } else {
                try {
                    return Long.valueOf(((Long) this.f4191f.invoke(this.f4190e.get(accessibilityNodeInfo), Integer.valueOf(i5))).longValue());
                } catch (ArrayIndexOutOfBoundsException e7) {
                    e = e7;
                    str = "The longArrayGetIndex method threw an exception when invoked.";
                    n2.b.h(AccessibilityViewEmbedder.TAG, str, e);
                    return null;
                } catch (IllegalAccessException e8) {
                    e = e8;
                    str = "Failed to access longArrayGetIndex method or the childNodeId field.";
                } catch (InvocationTargetException e9) {
                    e = e9;
                    str = "The longArrayGetIndex method threw an exception when invoked.";
                    n2.b.h(AccessibilityViewEmbedder.TAG, str, e);
                    return null;
                }
            }
            n2.b.h(AccessibilityViewEmbedder.TAG, str, e);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Long g(AccessibilityNodeInfo accessibilityNodeInfo) {
            String str;
            Method method = this.f4187b;
            if (method != null) {
                try {
                    return Long.valueOf(((Long) method.invoke(accessibilityNodeInfo, new Object[0])).longValue());
                } catch (IllegalAccessException e5) {
                    e = e5;
                    str = "Failed to access getParentNodeId method.";
                    n2.b.h(AccessibilityViewEmbedder.TAG, str, e);
                    return l(accessibilityNodeInfo);
                } catch (InvocationTargetException e6) {
                    e = e6;
                    str = "The getParentNodeId method threw an exception when invoked.";
                    n2.b.h(AccessibilityViewEmbedder.TAG, str, e);
                    return l(accessibilityNodeInfo);
                }
            }
            return l(accessibilityNodeInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Long h(AccessibilityRecord accessibilityRecord) {
            String str;
            Method method = this.f4188c;
            if (method == null) {
                return null;
            }
            try {
                return (Long) method.invoke(accessibilityRecord, new Object[0]);
            } catch (IllegalAccessException e5) {
                e = e5;
                str = "Failed to access the getRecordSourceNodeId method.";
                n2.b.h(AccessibilityViewEmbedder.TAG, str, e);
                return null;
            } catch (InvocationTargetException e6) {
                e = e6;
                str = "The getRecordSourceNodeId method threw an exception when invoked.";
                n2.b.h(AccessibilityViewEmbedder.TAG, str, e);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Long i(AccessibilityNodeInfo accessibilityNodeInfo) {
            String str;
            Method method = this.f4186a;
            if (method == null) {
                return null;
            }
            try {
                return (Long) method.invoke(accessibilityNodeInfo, new Object[0]);
            } catch (IllegalAccessException e5) {
                e = e5;
                str = "Failed to access getSourceNodeId method.";
                n2.b.h(AccessibilityViewEmbedder.TAG, str, e);
                return null;
            } catch (InvocationTargetException e6) {
                e = e6;
                str = "The getSourceNodeId method threw an exception when invoked.";
                n2.b.h(AccessibilityViewEmbedder.TAG, str, e);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int j(long j5) {
            return (int) (j5 >> 32);
        }

        private static boolean k(long j5, int i5) {
            return (j5 & (1 << i5)) != 0;
        }

        private static Long l(AccessibilityNodeInfo accessibilityNodeInfo) {
            if (Build.VERSION.SDK_INT < 26) {
                n2.b.g(AccessibilityViewEmbedder.TAG, "Unexpected Android version. Unable to find the parent ID.");
                return null;
            }
            AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(accessibilityNodeInfo);
            Parcel obtain2 = Parcel.obtain();
            obtain2.setDataPosition(0);
            obtain.writeToParcel(obtain2, 0);
            obtain2.setDataPosition(0);
            long readLong = obtain2.readLong();
            if (k(readLong, 0)) {
                obtain2.readInt();
            }
            if (k(readLong, 1)) {
                obtain2.readLong();
            }
            if (k(readLong, 2)) {
                obtain2.readInt();
            }
            Long valueOf = k(readLong, 3) ? Long.valueOf(obtain2.readLong()) : null;
            obtain2.recycle();
            return valueOf;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        final View f4192a;

        /* renamed from: b  reason: collision with root package name */
        final int f4193b;

        private c(View view, int i5) {
            this.f4192a = view;
            this.f4193b = i5;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof c) {
                c cVar = (c) obj;
                return this.f4193b == cVar.f4193b && this.f4192a.equals(cVar.f4192a);
            }
            return false;
        }

        public int hashCode() {
            return ((this.f4192a.hashCode() + 31) * 31) + this.f4193b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AccessibilityViewEmbedder(View view, int i5) {
        this.rootAccessibilityView = view;
        this.nextFlutterId = i5;
    }

    private void addChildrenToFlutterNode(AccessibilityNodeInfo accessibilityNodeInfo, View view, AccessibilityNodeInfo accessibilityNodeInfo2) {
        int i5;
        for (int i6 = 0; i6 < accessibilityNodeInfo.getChildCount(); i6++) {
            Long f5 = this.reflectionAccessors.f(accessibilityNodeInfo, i6);
            if (f5 != null) {
                int j5 = b.j(f5.longValue());
                c cVar = new c(view, j5);
                if (this.originToFlutterId.containsKey(cVar)) {
                    i5 = this.originToFlutterId.get(cVar).intValue();
                } else {
                    int i7 = this.nextFlutterId;
                    this.nextFlutterId = i7 + 1;
                    cacheVirtualIdMappings(view, j5, i7);
                    i5 = i7;
                }
                accessibilityNodeInfo2.addChild(this.rootAccessibilityView, i5);
            }
        }
    }

    private void cacheVirtualIdMappings(View view, int i5, int i6) {
        c cVar = new c(view, i5);
        this.originToFlutterId.put(cVar, Integer.valueOf(i6));
        this.flutterIdToOrigin.put(i6, cVar);
    }

    private AccessibilityNodeInfo convertToFlutterNode(AccessibilityNodeInfo accessibilityNodeInfo, int i5, View view) {
        AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(this.rootAccessibilityView, i5);
        obtain.setPackageName(this.rootAccessibilityView.getContext().getPackageName());
        obtain.setSource(this.rootAccessibilityView, i5);
        obtain.setClassName(accessibilityNodeInfo.getClassName());
        copyAccessibilityFields(accessibilityNodeInfo, obtain);
        setFlutterNodesTranslateBounds(accessibilityNodeInfo, this.embeddedViewToDisplayBounds.get(view), obtain);
        addChildrenToFlutterNode(accessibilityNodeInfo, view, obtain);
        setFlutterNodeParent(accessibilityNodeInfo, view, obtain);
        return obtain;
    }

    private void copyAccessibilityFields(AccessibilityNodeInfo accessibilityNodeInfo, AccessibilityNodeInfo accessibilityNodeInfo2) {
        List availableExtraData;
        CharSequence hintText;
        boolean isShowingHintText;
        int drawingOrder;
        boolean isImportantForAccessibility;
        boolean isContextClickable;
        accessibilityNodeInfo2.setAccessibilityFocused(accessibilityNodeInfo.isAccessibilityFocused());
        accessibilityNodeInfo2.setCheckable(accessibilityNodeInfo.isCheckable());
        accessibilityNodeInfo2.setChecked(accessibilityNodeInfo.isChecked());
        accessibilityNodeInfo2.setContentDescription(accessibilityNodeInfo.getContentDescription());
        accessibilityNodeInfo2.setEnabled(accessibilityNodeInfo.isEnabled());
        accessibilityNodeInfo2.setClickable(accessibilityNodeInfo.isClickable());
        accessibilityNodeInfo2.setFocusable(accessibilityNodeInfo.isFocusable());
        accessibilityNodeInfo2.setFocused(accessibilityNodeInfo.isFocused());
        accessibilityNodeInfo2.setLongClickable(accessibilityNodeInfo.isLongClickable());
        accessibilityNodeInfo2.setMovementGranularities(accessibilityNodeInfo.getMovementGranularities());
        accessibilityNodeInfo2.setPassword(accessibilityNodeInfo.isPassword());
        accessibilityNodeInfo2.setScrollable(accessibilityNodeInfo.isScrollable());
        accessibilityNodeInfo2.setSelected(accessibilityNodeInfo.isSelected());
        accessibilityNodeInfo2.setText(accessibilityNodeInfo.getText());
        accessibilityNodeInfo2.setVisibleToUser(accessibilityNodeInfo.isVisibleToUser());
        accessibilityNodeInfo2.setEditable(accessibilityNodeInfo.isEditable());
        accessibilityNodeInfo2.setCanOpenPopup(accessibilityNodeInfo.canOpenPopup());
        accessibilityNodeInfo2.setCollectionInfo(accessibilityNodeInfo.getCollectionInfo());
        accessibilityNodeInfo2.setCollectionItemInfo(accessibilityNodeInfo.getCollectionItemInfo());
        accessibilityNodeInfo2.setContentInvalid(accessibilityNodeInfo.isContentInvalid());
        accessibilityNodeInfo2.setDismissable(accessibilityNodeInfo.isDismissable());
        accessibilityNodeInfo2.setInputType(accessibilityNodeInfo.getInputType());
        accessibilityNodeInfo2.setLiveRegion(accessibilityNodeInfo.getLiveRegion());
        accessibilityNodeInfo2.setMultiLine(accessibilityNodeInfo.isMultiLine());
        accessibilityNodeInfo2.setRangeInfo(accessibilityNodeInfo.getRangeInfo());
        accessibilityNodeInfo2.setError(accessibilityNodeInfo.getError());
        accessibilityNodeInfo2.setMaxTextLength(accessibilityNodeInfo.getMaxTextLength());
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 23) {
            isContextClickable = accessibilityNodeInfo.isContextClickable();
            accessibilityNodeInfo2.setContextClickable(isContextClickable);
        }
        if (i5 >= 24) {
            drawingOrder = accessibilityNodeInfo.getDrawingOrder();
            accessibilityNodeInfo2.setDrawingOrder(drawingOrder);
            isImportantForAccessibility = accessibilityNodeInfo.isImportantForAccessibility();
            accessibilityNodeInfo2.setImportantForAccessibility(isImportantForAccessibility);
        }
        if (i5 >= 26) {
            availableExtraData = accessibilityNodeInfo.getAvailableExtraData();
            accessibilityNodeInfo2.setAvailableExtraData(availableExtraData);
            hintText = accessibilityNodeInfo.getHintText();
            accessibilityNodeInfo2.setHintText(hintText);
            isShowingHintText = accessibilityNodeInfo.isShowingHintText();
            accessibilityNodeInfo2.setShowingHintText(isShowingHintText);
        }
    }

    private void setFlutterNodeParent(AccessibilityNodeInfo accessibilityNodeInfo, View view, AccessibilityNodeInfo accessibilityNodeInfo2) {
        Long g5 = this.reflectionAccessors.g(accessibilityNodeInfo);
        if (g5 == null) {
            return;
        }
        Integer num = this.originToFlutterId.get(new c(view, b.j(g5.longValue())));
        if (num != null) {
            accessibilityNodeInfo2.setParent(this.rootAccessibilityView, num.intValue());
        }
    }

    private void setFlutterNodesTranslateBounds(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect, AccessibilityNodeInfo accessibilityNodeInfo2) {
        Rect rect2 = new Rect();
        accessibilityNodeInfo.getBoundsInParent(rect2);
        accessibilityNodeInfo2.setBoundsInParent(rect2);
        Rect rect3 = new Rect();
        accessibilityNodeInfo.getBoundsInScreen(rect3);
        rect3.offset(rect.left, rect.top);
        accessibilityNodeInfo2.setBoundsInScreen(rect3);
    }

    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i5) {
        AccessibilityNodeInfo createAccessibilityNodeInfo;
        c cVar = this.flutterIdToOrigin.get(i5);
        if (cVar == null || !this.embeddedViewToDisplayBounds.containsKey(cVar.f4192a) || cVar.f4192a.getAccessibilityNodeProvider() == null || (createAccessibilityNodeInfo = cVar.f4192a.getAccessibilityNodeProvider().createAccessibilityNodeInfo(cVar.f4193b)) == null) {
            return null;
        }
        return convertToFlutterNode(createAccessibilityNodeInfo, i5, cVar.f4192a);
    }

    public Integer getRecordFlutterId(View view, AccessibilityRecord accessibilityRecord) {
        Long h5 = this.reflectionAccessors.h(accessibilityRecord);
        if (h5 == null) {
            return null;
        }
        return this.originToFlutterId.get(new c(view, b.j(h5.longValue())));
    }

    public AccessibilityNodeInfo getRootNode(View view, int i5, Rect rect) {
        AccessibilityNodeInfo createAccessibilityNodeInfo = view.createAccessibilityNodeInfo();
        Long i6 = this.reflectionAccessors.i(createAccessibilityNodeInfo);
        if (i6 == null) {
            return null;
        }
        this.embeddedViewToDisplayBounds.put(view, rect);
        cacheVirtualIdMappings(view, b.j(i6.longValue()), i5);
        return convertToFlutterNode(createAccessibilityNodeInfo, i5, view);
    }

    public boolean onAccessibilityHoverEvent(int i5, MotionEvent motionEvent) {
        c cVar = this.flutterIdToOrigin.get(i5);
        if (cVar == null) {
            return false;
        }
        Rect rect = this.embeddedViewToDisplayBounds.get(cVar.f4192a);
        int pointerCount = motionEvent.getPointerCount();
        MotionEvent.PointerProperties[] pointerPropertiesArr = new MotionEvent.PointerProperties[pointerCount];
        MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[pointerCount];
        for (int i6 = 0; i6 < motionEvent.getPointerCount(); i6++) {
            MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
            pointerPropertiesArr[i6] = pointerProperties;
            motionEvent.getPointerProperties(i6, pointerProperties);
            MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
            motionEvent.getPointerCoords(i6, pointerCoords);
            MotionEvent.PointerCoords pointerCoords2 = new MotionEvent.PointerCoords(pointerCoords);
            pointerCoordsArr[i6] = pointerCoords2;
            pointerCoords2.x -= rect.left;
            pointerCoords2.y -= rect.top;
        }
        return cVar.f4192a.dispatchGenericMotionEvent(MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), motionEvent.getAction(), motionEvent.getPointerCount(), pointerPropertiesArr, pointerCoordsArr, motionEvent.getMetaState(), motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags()));
    }

    public boolean performAction(int i5, int i6, Bundle bundle) {
        AccessibilityNodeProvider accessibilityNodeProvider;
        c cVar = this.flutterIdToOrigin.get(i5);
        if (cVar == null || (accessibilityNodeProvider = cVar.f4192a.getAccessibilityNodeProvider()) == null) {
            return false;
        }
        return accessibilityNodeProvider.performAction(cVar.f4193b, i6, bundle);
    }

    public View platformViewOfNode(int i5) {
        c cVar = this.flutterIdToOrigin.get(i5);
        if (cVar == null) {
            return null;
        }
        return cVar.f4192a;
    }

    public boolean requestSendAccessibilityEvent(View view, View view2, AccessibilityEvent accessibilityEvent) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(accessibilityEvent);
        Long h5 = this.reflectionAccessors.h(accessibilityEvent);
        if (h5 == null) {
            return false;
        }
        int j5 = b.j(h5.longValue());
        Integer num = this.originToFlutterId.get(new c(view, j5));
        if (num == null) {
            int i5 = this.nextFlutterId;
            this.nextFlutterId = i5 + 1;
            num = Integer.valueOf(i5);
            cacheVirtualIdMappings(view, j5, num.intValue());
        }
        obtain.setSource(this.rootAccessibilityView, num.intValue());
        obtain.setClassName(accessibilityEvent.getClassName());
        obtain.setPackageName(accessibilityEvent.getPackageName());
        for (int i6 = 0; i6 < obtain.getRecordCount(); i6++) {
            AccessibilityRecord record = obtain.getRecord(i6);
            Long h6 = this.reflectionAccessors.h(record);
            if (h6 == null) {
                return false;
            }
            c cVar = new c(view, b.j(h6.longValue()));
            if (!this.originToFlutterId.containsKey(cVar)) {
                return false;
            }
            record.setSource(this.rootAccessibilityView, this.originToFlutterId.get(cVar).intValue());
        }
        return this.rootAccessibilityView.getParent().requestSendAccessibilityEvent(view2, obtain);
    }
}
