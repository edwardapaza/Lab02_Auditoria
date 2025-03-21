package androidx.core.hardware.display;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;
import com.google.firebase.messaging.Constants;
/* loaded from: classes.dex */
public final class DisplayManagerCompat {
    public static final String DISPLAY_CATEGORY_PRESENTATION = "android.hardware.display.category.PRESENTATION";
    private final Context mContext;

    private DisplayManagerCompat(Context context) {
        this.mContext = context;
    }

    public static DisplayManagerCompat getInstance(Context context) {
        return new DisplayManagerCompat(context);
    }

    public Display getDisplay(int displayId) {
        DisplayManager displayManager = (DisplayManager) this.mContext.getSystemService(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION);
        return displayManager.getDisplay(displayId);
    }

    public Display[] getDisplays() {
        return ((DisplayManager) this.mContext.getSystemService(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION)).getDisplays();
    }

    public Display[] getDisplays(String category) {
        return ((DisplayManager) this.mContext.getSystemService(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION)).getDisplays();
    }
}
