package com.dexterous.flutterlocalnotifications.models;

import android.graphics.Color;
import com.google.firebase.messaging.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class NotificationAction implements Serializable {
    private static final String ALLOW_GENERATED_REPLIES = "allowGeneratedReplies";
    private static final String CANCEL_NOTIFICATION = "cancelNotification";
    private static final String CONTEXTUAL = "contextual";
    private static final String ICON = "icon";
    private static final String ICON_SOURCE = "iconBitmapSource";
    private static final String ID = "id";
    private static final String INPUTS = "inputs";
    private static final String SHOWS_USER_INTERFACE = "showsUserInterface";
    private static final String TITLE = "title";
    private static final String TITLE_COLOR_ALPHA = "titleColorAlpha";
    private static final String TITLE_COLOR_BLUE = "titleColorBlue";
    private static final String TITLE_COLOR_GREEN = "titleColorGreen";
    private static final String TITLE_COLOR_RED = "titleColorRed";
    public final List<NotificationActionInput> actionInputs;
    public final Boolean allowGeneratedReplies;
    public final Boolean cancelNotification;
    public final Boolean contextual;
    public final String icon;
    public final IconSource iconSource;
    public final String id;
    public final Boolean showsUserInterface;
    public final String title;
    public final Integer titleColor;

    /* loaded from: classes2.dex */
    public static class NotificationActionInput implements Serializable {
        public final Boolean allowFreeFormInput;
        public final List<String> allowedMimeTypes;
        public final List<String> choices;
        public final String label;

        public NotificationActionInput(List<String> choices, Boolean allowFreeFormInput, String label, List<String> allowedMimeTypes) {
            this.choices = choices;
            this.allowFreeFormInput = allowFreeFormInput;
            this.label = label;
            this.allowedMimeTypes = allowedMimeTypes;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            NotificationActionInput that = (NotificationActionInput) o;
            List<String> list = this.choices;
            if (list == null ? that.choices != null : !list.equals(that.choices)) {
                return false;
            }
            Boolean bool = this.allowFreeFormInput;
            if (bool == null ? that.allowFreeFormInput != null : !bool.equals(that.allowFreeFormInput)) {
                return false;
            }
            String str = this.label;
            if (str == null ? that.label != null : !str.equals(that.label)) {
                return false;
            }
            List<String> list2 = this.allowedMimeTypes;
            if (list2 != null) {
                return list2.equals(that.allowedMimeTypes);
            }
            return that.allowedMimeTypes == null;
        }

        public int hashCode() {
            List<String> list = this.choices;
            int result = list != null ? list.hashCode() : 0;
            int i = result * 31;
            Boolean bool = this.allowFreeFormInput;
            int result2 = i + (bool != null ? bool.hashCode() : 0);
            int result3 = result2 * 31;
            String str = this.label;
            int result4 = (result3 + (str != null ? str.hashCode() : 0)) * 31;
            List<String> list2 = this.allowedMimeTypes;
            return result4 + (list2 != null ? list2.hashCode() : 0);
        }
    }

    public NotificationAction(Map<String, Object> arguments) {
        List<Map<String, Object>> inputs;
        NotificationAction notificationAction = this;
        notificationAction.actionInputs = new ArrayList();
        notificationAction.id = (String) arguments.get(ID);
        notificationAction.cancelNotification = (Boolean) arguments.get(CANCEL_NOTIFICATION);
        notificationAction.title = (String) arguments.get(TITLE);
        Integer a = (Integer) arguments.get(TITLE_COLOR_ALPHA);
        Integer r = (Integer) arguments.get(TITLE_COLOR_RED);
        Integer g = (Integer) arguments.get(TITLE_COLOR_GREEN);
        Integer b = (Integer) arguments.get(TITLE_COLOR_BLUE);
        if (a != null && r != null && g != null && b != null) {
            notificationAction.titleColor = Integer.valueOf(Color.argb(a.intValue(), r.intValue(), g.intValue(), b.intValue()));
        } else {
            notificationAction.titleColor = null;
        }
        notificationAction.icon = (String) arguments.get(ICON);
        notificationAction.contextual = (Boolean) arguments.get(CONTEXTUAL);
        notificationAction.showsUserInterface = (Boolean) arguments.get(SHOWS_USER_INTERFACE);
        notificationAction.allowGeneratedReplies = (Boolean) arguments.get(ALLOW_GENERATED_REPLIES);
        Integer iconSourceIndex = (Integer) arguments.get(ICON_SOURCE);
        if (iconSourceIndex != null) {
            notificationAction.iconSource = IconSource.values()[iconSourceIndex.intValue()];
        } else {
            notificationAction.iconSource = null;
        }
        if (arguments.get(INPUTS) != null && (inputs = (List) arguments.get(INPUTS)) != null) {
            for (Map<String, Object> input : inputs) {
                notificationAction.actionInputs.add(new NotificationActionInput(castList(String.class, (Collection) input.get("choices")), (Boolean) input.get("allowFreeFormInput"), (String) input.get(Constants.ScionAnalytics.PARAM_LABEL), castList(String.class, (Collection) input.get("allowedMimeTypes"))));
                notificationAction = this;
            }
        }
    }

    public static <T> List<T> castList(Class<? extends T> clazz, Collection<?> rawCollection) {
        if (rawCollection == null) {
            return Collections.emptyList();
        }
        List<T> result = new ArrayList<>(rawCollection.size());
        for (Object o : rawCollection) {
            try {
                result.add(clazz.cast(o));
            } catch (ClassCastException e) {
            }
        }
        return result;
    }
}
