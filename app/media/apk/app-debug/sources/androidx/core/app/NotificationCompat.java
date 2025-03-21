package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.content.LocusId;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.core.R;
import androidx.core.app.Person;
import androidx.core.content.ContextCompat;
import androidx.core.content.LocusIdCompat;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
/* loaded from: classes.dex */
public class NotificationCompat {
    public static final int BADGE_ICON_LARGE = 2;
    public static final int BADGE_ICON_NONE = 0;
    public static final int BADGE_ICON_SMALL = 1;
    public static final String CATEGORY_ALARM = "alarm";
    public static final String CATEGORY_CALL = "call";
    public static final String CATEGORY_EMAIL = "email";
    public static final String CATEGORY_ERROR = "err";
    public static final String CATEGORY_EVENT = "event";
    public static final String CATEGORY_LOCATION_SHARING = "location_sharing";
    public static final String CATEGORY_MESSAGE = "msg";
    public static final String CATEGORY_MISSED_CALL = "missed_call";
    public static final String CATEGORY_NAVIGATION = "navigation";
    public static final String CATEGORY_PROGRESS = "progress";
    public static final String CATEGORY_PROMO = "promo";
    public static final String CATEGORY_RECOMMENDATION = "recommendation";
    public static final String CATEGORY_REMINDER = "reminder";
    public static final String CATEGORY_SERVICE = "service";
    public static final String CATEGORY_SOCIAL = "social";
    public static final String CATEGORY_STATUS = "status";
    public static final String CATEGORY_STOPWATCH = "stopwatch";
    public static final String CATEGORY_SYSTEM = "sys";
    public static final String CATEGORY_TRANSPORT = "transport";
    public static final String CATEGORY_WORKOUT = "workout";
    public static final int COLOR_DEFAULT = 0;
    public static final int DEFAULT_ALL = -1;
    public static final int DEFAULT_LIGHTS = 4;
    public static final int DEFAULT_SOUND = 1;
    public static final int DEFAULT_VIBRATE = 2;
    public static final String EXTRA_ANSWER_COLOR = "android.answerColor";
    public static final String EXTRA_ANSWER_INTENT = "android.answerIntent";
    public static final String EXTRA_AUDIO_CONTENTS_URI = "android.audioContents";
    public static final String EXTRA_BACKGROUND_IMAGE_URI = "android.backgroundImageUri";
    public static final String EXTRA_BIG_TEXT = "android.bigText";
    public static final String EXTRA_CALL_IS_VIDEO = "android.callIsVideo";
    public static final String EXTRA_CALL_PERSON = "android.callPerson";
    public static final String EXTRA_CALL_PERSON_COMPAT = "android.callPersonCompat";
    public static final String EXTRA_CALL_TYPE = "android.callType";
    public static final String EXTRA_CHANNEL_GROUP_ID = "android.intent.extra.CHANNEL_GROUP_ID";
    public static final String EXTRA_CHANNEL_ID = "android.intent.extra.CHANNEL_ID";
    public static final String EXTRA_CHRONOMETER_COUNT_DOWN = "android.chronometerCountDown";
    public static final String EXTRA_COLORIZED = "android.colorized";
    public static final String EXTRA_COMPACT_ACTIONS = "android.compactActions";
    public static final String EXTRA_COMPAT_TEMPLATE = "androidx.core.app.extra.COMPAT_TEMPLATE";
    public static final String EXTRA_CONVERSATION_TITLE = "android.conversationTitle";
    public static final String EXTRA_DECLINE_COLOR = "android.declineColor";
    public static final String EXTRA_DECLINE_INTENT = "android.declineIntent";
    public static final String EXTRA_HANG_UP_INTENT = "android.hangUpIntent";
    public static final String EXTRA_HIDDEN_CONVERSATION_TITLE = "android.hiddenConversationTitle";
    public static final String EXTRA_HISTORIC_MESSAGES = "android.messages.historic";
    public static final String EXTRA_INFO_TEXT = "android.infoText";
    public static final String EXTRA_IS_GROUP_CONVERSATION = "android.isGroupConversation";
    public static final String EXTRA_LARGE_ICON = "android.largeIcon";
    public static final String EXTRA_LARGE_ICON_BIG = "android.largeIcon.big";
    public static final String EXTRA_MEDIA_SESSION = "android.mediaSession";
    public static final String EXTRA_MESSAGES = "android.messages";
    public static final String EXTRA_MESSAGING_STYLE_USER = "android.messagingStyleUser";
    public static final String EXTRA_NOTIFICATION_ID = "android.intent.extra.NOTIFICATION_ID";
    public static final String EXTRA_NOTIFICATION_TAG = "android.intent.extra.NOTIFICATION_TAG";
    @Deprecated
    public static final String EXTRA_PEOPLE = "android.people";
    public static final String EXTRA_PEOPLE_LIST = "android.people.list";
    public static final String EXTRA_PICTURE = "android.picture";
    public static final String EXTRA_PICTURE_CONTENT_DESCRIPTION = "android.pictureContentDescription";
    public static final String EXTRA_PICTURE_ICON = "android.pictureIcon";
    public static final String EXTRA_PROGRESS = "android.progress";
    public static final String EXTRA_PROGRESS_INDETERMINATE = "android.progressIndeterminate";
    public static final String EXTRA_PROGRESS_MAX = "android.progressMax";
    public static final String EXTRA_REMOTE_INPUT_HISTORY = "android.remoteInputHistory";
    public static final String EXTRA_SELF_DISPLAY_NAME = "android.selfDisplayName";
    public static final String EXTRA_SHOW_BIG_PICTURE_WHEN_COLLAPSED = "android.showBigPictureWhenCollapsed";
    public static final String EXTRA_SHOW_CHRONOMETER = "android.showChronometer";
    public static final String EXTRA_SHOW_WHEN = "android.showWhen";
    public static final String EXTRA_SMALL_ICON = "android.icon";
    public static final String EXTRA_SUB_TEXT = "android.subText";
    public static final String EXTRA_SUMMARY_TEXT = "android.summaryText";
    public static final String EXTRA_TEMPLATE = "android.template";
    public static final String EXTRA_TEXT = "android.text";
    public static final String EXTRA_TEXT_LINES = "android.textLines";
    public static final String EXTRA_TITLE = "android.title";
    public static final String EXTRA_TITLE_BIG = "android.title.big";
    public static final String EXTRA_VERIFICATION_ICON = "android.verificationIcon";
    public static final String EXTRA_VERIFICATION_ICON_COMPAT = "android.verificationIconCompat";
    public static final String EXTRA_VERIFICATION_TEXT = "android.verificationText";
    public static final int FLAG_AUTO_CANCEL = 16;
    public static final int FLAG_BUBBLE = 4096;
    public static final int FLAG_FOREGROUND_SERVICE = 64;
    public static final int FLAG_GROUP_SUMMARY = 512;
    @Deprecated
    public static final int FLAG_HIGH_PRIORITY = 128;
    public static final int FLAG_INSISTENT = 4;
    public static final int FLAG_LOCAL_ONLY = 256;
    public static final int FLAG_NO_CLEAR = 32;
    public static final int FLAG_ONGOING_EVENT = 2;
    public static final int FLAG_ONLY_ALERT_ONCE = 8;
    public static final int FLAG_SHOW_LIGHTS = 1;
    public static final int FOREGROUND_SERVICE_DEFAULT = 0;
    public static final int FOREGROUND_SERVICE_DEFERRED = 2;
    public static final int FOREGROUND_SERVICE_IMMEDIATE = 1;
    public static final int GROUP_ALERT_ALL = 0;
    public static final int GROUP_ALERT_CHILDREN = 2;
    public static final int GROUP_ALERT_SUMMARY = 1;
    public static final String GROUP_KEY_SILENT = "silent";
    public static final String INTENT_CATEGORY_NOTIFICATION_PREFERENCES = "android.intent.category.NOTIFICATION_PREFERENCES";
    public static final int MAX_ACTION_BUTTONS = 3;
    public static final int PRIORITY_DEFAULT = 0;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_LOW = -1;
    public static final int PRIORITY_MAX = 2;
    public static final int PRIORITY_MIN = -2;
    public static final int STREAM_DEFAULT = -1;
    private static final String TAG = "NotifCompat";
    public static final int VISIBILITY_PRIVATE = 0;
    public static final int VISIBILITY_PUBLIC = 1;
    public static final int VISIBILITY_SECRET = -1;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface BadgeIconType {
    }

    /* loaded from: classes.dex */
    public interface Extender {
        Builder extend(Builder builder);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface GroupAlertBehavior {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface NotificationVisibility {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface ServiceNotificationBehavior {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface StreamType {
    }

    /* loaded from: classes.dex */
    public static class Builder {
        private static final int MAX_CHARSEQUENCE_LENGTH = 5120;
        public ArrayList<Action> mActions;
        boolean mAllowSystemGeneratedContextualActions;
        int mBadgeIcon;
        RemoteViews mBigContentView;
        BubbleMetadata mBubbleMetadata;
        String mCategory;
        String mChannelId;
        boolean mChronometerCountDown;
        int mColor;
        boolean mColorized;
        boolean mColorizedSet;
        CharSequence mContentInfo;
        PendingIntent mContentIntent;
        CharSequence mContentText;
        CharSequence mContentTitle;
        RemoteViews mContentView;
        public Context mContext;
        Bundle mExtras;
        int mFgsDeferBehavior;
        PendingIntent mFullScreenIntent;
        int mGroupAlertBehavior;
        String mGroupKey;
        boolean mGroupSummary;
        RemoteViews mHeadsUpContentView;
        ArrayList<Action> mInvisibleActions;
        IconCompat mLargeIcon;
        boolean mLocalOnly;
        LocusIdCompat mLocusId;
        Notification mNotification;
        int mNumber;
        @Deprecated
        public ArrayList<String> mPeople;
        public ArrayList<Person> mPersonList;
        int mPriority;
        int mProgress;
        boolean mProgressIndeterminate;
        int mProgressMax;
        Notification mPublicVersion;
        CharSequence[] mRemoteInputHistory;
        CharSequence mSettingsText;
        String mShortcutId;
        boolean mShowWhen;
        boolean mSilent;
        Object mSmallIcon;
        String mSortKey;
        Style mStyle;
        CharSequence mSubText;
        RemoteViews mTickerView;
        long mTimeout;
        boolean mUseChronometer;
        int mVisibility;

        public Builder(Context context, Notification notification) {
            this(context, NotificationCompat.getChannelId(notification));
            ArrayList<android.app.Person> peopleList;
            Notification.Action[] actionArr;
            Bundle extras = notification.extras;
            Style style = Style.extractStyleFromNotification(notification);
            setContentTitle(NotificationCompat.getContentTitle(notification)).setContentText(NotificationCompat.getContentText(notification)).setContentInfo(NotificationCompat.getContentInfo(notification)).setSubText(NotificationCompat.getSubText(notification)).setSettingsText(NotificationCompat.getSettingsText(notification)).setStyle(style).setGroup(NotificationCompat.getGroup(notification)).setGroupSummary(NotificationCompat.isGroupSummary(notification)).setLocusId(NotificationCompat.getLocusId(notification)).setWhen(notification.when).setShowWhen(NotificationCompat.getShowWhen(notification)).setUsesChronometer(NotificationCompat.getUsesChronometer(notification)).setAutoCancel(NotificationCompat.getAutoCancel(notification)).setOnlyAlertOnce(NotificationCompat.getOnlyAlertOnce(notification)).setOngoing(NotificationCompat.getOngoing(notification)).setLocalOnly(NotificationCompat.getLocalOnly(notification)).setLargeIcon(notification.largeIcon).setBadgeIconType(NotificationCompat.getBadgeIconType(notification)).setCategory(NotificationCompat.getCategory(notification)).setBubbleMetadata(NotificationCompat.getBubbleMetadata(notification)).setNumber(notification.number).setTicker(notification.tickerText).setContentIntent(notification.contentIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(notification.fullScreenIntent, NotificationCompat.getHighPriority(notification)).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setDefaults(notification.defaults).setPriority(notification.priority).setColor(NotificationCompat.getColor(notification)).setVisibility(NotificationCompat.getVisibility(notification)).setPublicVersion(NotificationCompat.getPublicVersion(notification)).setSortKey(NotificationCompat.getSortKey(notification)).setTimeoutAfter(NotificationCompat.getTimeoutAfter(notification)).setShortcutId(NotificationCompat.getShortcutId(notification)).setProgress(extras.getInt(NotificationCompat.EXTRA_PROGRESS_MAX), extras.getInt(NotificationCompat.EXTRA_PROGRESS), extras.getBoolean(NotificationCompat.EXTRA_PROGRESS_INDETERMINATE)).setAllowSystemGeneratedContextualActions(NotificationCompat.getAllowSystemGeneratedContextualActions(notification)).setSmallIcon(notification.icon, notification.iconLevel).addExtras(getExtrasWithoutDuplicateData(notification, style));
            if (Build.VERSION.SDK_INT >= 23) {
                this.mSmallIcon = Api23Impl.getSmallIcon(notification);
                Icon largeIcon = Api23Impl.getLargeIcon(notification);
                if (largeIcon != null) {
                    this.mLargeIcon = IconCompat.createFromIcon(largeIcon);
                }
            }
            if (notification.actions != null && notification.actions.length != 0) {
                for (Notification.Action action : notification.actions) {
                    addAction(Action.Builder.fromAndroidAction(action).build());
                }
            }
            if (Build.VERSION.SDK_INT >= 21) {
                List<Action> invisibleActions = NotificationCompat.getInvisibleActions(notification);
                if (!invisibleActions.isEmpty()) {
                    for (Action invisibleAction : invisibleActions) {
                        addInvisibleAction(invisibleAction);
                    }
                }
            }
            String[] people = notification.extras.getStringArray(NotificationCompat.EXTRA_PEOPLE);
            if (people != null && people.length != 0) {
                for (String person : people) {
                    addPerson(person);
                }
            }
            if (Build.VERSION.SDK_INT >= 28 && (peopleList = notification.extras.getParcelableArrayList(NotificationCompat.EXTRA_PEOPLE_LIST)) != null && !peopleList.isEmpty()) {
                Iterator<android.app.Person> it = peopleList.iterator();
                while (it.hasNext()) {
                    android.app.Person person2 = it.next();
                    addPerson(Person.fromAndroidPerson(person2));
                }
            }
            if (Build.VERSION.SDK_INT >= 24 && extras.containsKey(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN)) {
                setChronometerCountDown(extras.getBoolean(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN));
            }
            if (Build.VERSION.SDK_INT >= 26 && extras.containsKey(NotificationCompat.EXTRA_COLORIZED)) {
                setColorized(extras.getBoolean(NotificationCompat.EXTRA_COLORIZED));
            }
        }

        private static Bundle getExtrasWithoutDuplicateData(Notification notification, Style style) {
            if (notification.extras == null) {
                return null;
            }
            Bundle newExtras = new Bundle(notification.extras);
            newExtras.remove(NotificationCompat.EXTRA_TITLE);
            newExtras.remove(NotificationCompat.EXTRA_TEXT);
            newExtras.remove(NotificationCompat.EXTRA_INFO_TEXT);
            newExtras.remove(NotificationCompat.EXTRA_SUB_TEXT);
            newExtras.remove(NotificationCompat.EXTRA_CHANNEL_ID);
            newExtras.remove(NotificationCompat.EXTRA_CHANNEL_GROUP_ID);
            newExtras.remove(NotificationCompat.EXTRA_SHOW_WHEN);
            newExtras.remove(NotificationCompat.EXTRA_PROGRESS);
            newExtras.remove(NotificationCompat.EXTRA_PROGRESS_MAX);
            newExtras.remove(NotificationCompat.EXTRA_PROGRESS_INDETERMINATE);
            newExtras.remove(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN);
            newExtras.remove(NotificationCompat.EXTRA_COLORIZED);
            newExtras.remove(NotificationCompat.EXTRA_PEOPLE_LIST);
            newExtras.remove(NotificationCompat.EXTRA_PEOPLE);
            newExtras.remove(NotificationCompatExtras.EXTRA_SORT_KEY);
            newExtras.remove(NotificationCompatExtras.EXTRA_GROUP_KEY);
            newExtras.remove(NotificationCompatExtras.EXTRA_GROUP_SUMMARY);
            newExtras.remove(NotificationCompatExtras.EXTRA_LOCAL_ONLY);
            newExtras.remove(NotificationCompatExtras.EXTRA_ACTION_EXTRAS);
            Bundle carExtenderExtras = newExtras.getBundle("android.car.EXTENSIONS");
            if (carExtenderExtras != null) {
                Bundle carExtenderExtras2 = new Bundle(carExtenderExtras);
                carExtenderExtras2.remove("invisible_actions");
                newExtras.putBundle("android.car.EXTENSIONS", carExtenderExtras2);
            }
            if (style != null) {
                style.clearCompatExtraKeys(newExtras);
            }
            return newExtras;
        }

        public Builder(Context context, String channelId) {
            this.mActions = new ArrayList<>();
            this.mPersonList = new ArrayList<>();
            this.mInvisibleActions = new ArrayList<>();
            this.mShowWhen = true;
            this.mLocalOnly = false;
            this.mColor = 0;
            this.mVisibility = 0;
            this.mBadgeIcon = 0;
            this.mGroupAlertBehavior = 0;
            this.mFgsDeferBehavior = 0;
            Notification notification = new Notification();
            this.mNotification = notification;
            this.mContext = context;
            this.mChannelId = channelId;
            notification.when = System.currentTimeMillis();
            this.mNotification.audioStreamType = -1;
            this.mPriority = 0;
            this.mPeople = new ArrayList<>();
            this.mAllowSystemGeneratedContextualActions = true;
        }

        @Deprecated
        public Builder(Context context) {
            this(context, (String) null);
        }

        public Builder setWhen(long when) {
            this.mNotification.when = when;
            return this;
        }

        public Builder setShowWhen(boolean show) {
            this.mShowWhen = show;
            return this;
        }

        public Builder setSmallIcon(IconCompat icon) {
            this.mSmallIcon = icon.toIcon(this.mContext);
            return this;
        }

        public Builder setUsesChronometer(boolean b) {
            this.mUseChronometer = b;
            return this;
        }

        public Builder setChronometerCountDown(boolean countsDown) {
            this.mChronometerCountDown = countsDown;
            getExtras().putBoolean(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN, countsDown);
            return this;
        }

        public Builder setSmallIcon(int icon) {
            this.mNotification.icon = icon;
            return this;
        }

        public Builder setSmallIcon(int icon, int level) {
            this.mNotification.icon = icon;
            this.mNotification.iconLevel = level;
            return this;
        }

        @Deprecated
        public Builder setNotificationSilent() {
            this.mSilent = true;
            return this;
        }

        public Builder setSilent(boolean silent) {
            this.mSilent = silent;
            return this;
        }

        public Builder setContentTitle(CharSequence title) {
            this.mContentTitle = limitCharSequenceLength(title);
            return this;
        }

        public Builder setContentText(CharSequence text) {
            this.mContentText = limitCharSequenceLength(text);
            return this;
        }

        public Builder setSubText(CharSequence text) {
            this.mSubText = limitCharSequenceLength(text);
            return this;
        }

        public Builder setSettingsText(CharSequence text) {
            this.mSettingsText = limitCharSequenceLength(text);
            return this;
        }

        public Builder setRemoteInputHistory(CharSequence[] text) {
            this.mRemoteInputHistory = text;
            return this;
        }

        public Builder setNumber(int number) {
            this.mNumber = number;
            return this;
        }

        public Builder setContentInfo(CharSequence info) {
            this.mContentInfo = limitCharSequenceLength(info);
            return this;
        }

        public Builder setProgress(int max, int progress, boolean indeterminate) {
            this.mProgressMax = max;
            this.mProgress = progress;
            this.mProgressIndeterminate = indeterminate;
            return this;
        }

        public Builder setContent(RemoteViews views) {
            this.mNotification.contentView = views;
            return this;
        }

        public Builder setContentIntent(PendingIntent intent) {
            this.mContentIntent = intent;
            return this;
        }

        public Builder setDeleteIntent(PendingIntent intent) {
            this.mNotification.deleteIntent = intent;
            return this;
        }

        public Builder setFullScreenIntent(PendingIntent intent, boolean highPriority) {
            this.mFullScreenIntent = intent;
            setFlag(128, highPriority);
            return this;
        }

        public Builder setTicker(CharSequence tickerText) {
            this.mNotification.tickerText = limitCharSequenceLength(tickerText);
            return this;
        }

        @Deprecated
        public Builder setTicker(CharSequence tickerText, RemoteViews views) {
            this.mNotification.tickerText = limitCharSequenceLength(tickerText);
            this.mTickerView = views;
            return this;
        }

        public Builder setLargeIcon(Bitmap icon) {
            this.mLargeIcon = icon == null ? null : IconCompat.createWithBitmap(NotificationCompat.reduceLargeIconSize(this.mContext, icon));
            return this;
        }

        public Builder setLargeIcon(Icon icon) {
            this.mLargeIcon = icon == null ? null : IconCompat.createFromIcon(icon);
            return this;
        }

        public Builder setSound(Uri sound) {
            this.mNotification.sound = sound;
            this.mNotification.audioStreamType = -1;
            if (Build.VERSION.SDK_INT >= 21) {
                AudioAttributes.Builder builder = Api21Impl.createBuilder();
                AudioAttributes.Builder builder2 = Api21Impl.setUsage(Api21Impl.setContentType(builder, 4), 5);
                this.mNotification.audioAttributes = Api21Impl.build(builder2);
            }
            return this;
        }

        public Builder setSound(Uri sound, int streamType) {
            this.mNotification.sound = sound;
            this.mNotification.audioStreamType = streamType;
            if (Build.VERSION.SDK_INT >= 21) {
                AudioAttributes.Builder builder = Api21Impl.createBuilder();
                AudioAttributes.Builder builder2 = Api21Impl.setLegacyStreamType(Api21Impl.setContentType(builder, 4), streamType);
                this.mNotification.audioAttributes = Api21Impl.build(builder2);
            }
            return this;
        }

        public Builder setVibrate(long[] pattern) {
            this.mNotification.vibrate = pattern;
            return this;
        }

        public Builder setLights(int argb, int onMs, int offMs) {
            this.mNotification.ledARGB = argb;
            this.mNotification.ledOnMS = onMs;
            this.mNotification.ledOffMS = offMs;
            boolean showLights = (this.mNotification.ledOnMS == 0 || this.mNotification.ledOffMS == 0) ? false : true;
            Notification notification = this.mNotification;
            notification.flags = (showLights ? 1 : 0) | (notification.flags & (-2));
            return this;
        }

        public Builder setOngoing(boolean ongoing) {
            setFlag(2, ongoing);
            return this;
        }

        public Builder setColorized(boolean colorize) {
            this.mColorized = colorize;
            this.mColorizedSet = true;
            return this;
        }

        public Builder setOnlyAlertOnce(boolean onlyAlertOnce) {
            setFlag(8, onlyAlertOnce);
            return this;
        }

        public Builder setAutoCancel(boolean autoCancel) {
            setFlag(16, autoCancel);
            return this;
        }

        public Builder setLocalOnly(boolean b) {
            this.mLocalOnly = b;
            return this;
        }

        public Builder setCategory(String category) {
            this.mCategory = category;
            return this;
        }

        public Builder setDefaults(int defaults) {
            this.mNotification.defaults = defaults;
            if ((defaults & 4) != 0) {
                this.mNotification.flags |= 1;
            }
            return this;
        }

        private void setFlag(int mask, boolean value) {
            if (value) {
                this.mNotification.flags |= mask;
                return;
            }
            this.mNotification.flags &= ~mask;
        }

        public Builder setPriority(int pri) {
            this.mPriority = pri;
            return this;
        }

        @Deprecated
        public Builder addPerson(String uri) {
            if (uri != null && !uri.isEmpty()) {
                this.mPeople.add(uri);
            }
            return this;
        }

        public Builder addPerson(Person person) {
            if (person != null) {
                this.mPersonList.add(person);
            }
            return this;
        }

        public Builder clearPeople() {
            this.mPersonList.clear();
            this.mPeople.clear();
            return this;
        }

        public Builder setGroup(String groupKey) {
            this.mGroupKey = groupKey;
            return this;
        }

        public Builder setGroupSummary(boolean isGroupSummary) {
            this.mGroupSummary = isGroupSummary;
            return this;
        }

        public Builder setSortKey(String sortKey) {
            this.mSortKey = sortKey;
            return this;
        }

        public Builder addExtras(Bundle extras) {
            if (extras != null) {
                Bundle bundle = this.mExtras;
                if (bundle == null) {
                    this.mExtras = new Bundle(extras);
                } else {
                    bundle.putAll(extras);
                }
            }
            return this;
        }

        public Builder setExtras(Bundle extras) {
            this.mExtras = extras;
            return this;
        }

        public Bundle getExtras() {
            if (this.mExtras == null) {
                this.mExtras = new Bundle();
            }
            return this.mExtras;
        }

        public Builder addAction(int icon, CharSequence title, PendingIntent intent) {
            this.mActions.add(new Action(icon, title, intent));
            return this;
        }

        public Builder addAction(Action action) {
            if (action != null) {
                this.mActions.add(action);
            }
            return this;
        }

        public Builder clearActions() {
            this.mActions.clear();
            return this;
        }

        public Builder addInvisibleAction(int icon, CharSequence title, PendingIntent intent) {
            this.mInvisibleActions.add(new Action(icon, title, intent));
            return this;
        }

        public Builder addInvisibleAction(Action action) {
            if (action != null) {
                this.mInvisibleActions.add(action);
            }
            return this;
        }

        public Builder clearInvisibleActions() {
            this.mInvisibleActions.clear();
            Bundle carExtenderBundle = this.mExtras.getBundle("android.car.EXTENSIONS");
            if (carExtenderBundle != null) {
                Bundle carExtenderBundle2 = new Bundle(carExtenderBundle);
                carExtenderBundle2.remove("invisible_actions");
                this.mExtras.putBundle("android.car.EXTENSIONS", carExtenderBundle2);
            }
            return this;
        }

        public Builder setStyle(Style style) {
            if (this.mStyle != style) {
                this.mStyle = style;
                if (style != null) {
                    style.setBuilder(this);
                }
            }
            return this;
        }

        public Builder setColor(int argb) {
            this.mColor = argb;
            return this;
        }

        public Builder setVisibility(int visibility) {
            this.mVisibility = visibility;
            return this;
        }

        public Builder setPublicVersion(Notification n) {
            this.mPublicVersion = n;
            return this;
        }

        private boolean useExistingRemoteView() {
            Style style = this.mStyle;
            return style == null || !style.displayCustomViewInline();
        }

        public RemoteViews createContentView() {
            RemoteViews styleView;
            if (this.mContentView != null && useExistingRemoteView()) {
                return this.mContentView;
            }
            NotificationCompatBuilder compatBuilder = new NotificationCompatBuilder(this);
            Style style = this.mStyle;
            if (style != null && (styleView = style.makeContentView(compatBuilder)) != null) {
                return styleView;
            }
            Notification notification = compatBuilder.build();
            if (Build.VERSION.SDK_INT >= 24) {
                return Api24Impl.createContentView(Api24Impl.recoverBuilder(this.mContext, notification));
            }
            return notification.contentView;
        }

        public RemoteViews createBigContentView() {
            RemoteViews styleView;
            if (this.mBigContentView != null && useExistingRemoteView()) {
                return this.mBigContentView;
            }
            NotificationCompatBuilder compatBuilder = new NotificationCompatBuilder(this);
            Style style = this.mStyle;
            if (style != null && (styleView = style.makeBigContentView(compatBuilder)) != null) {
                return styleView;
            }
            Notification notification = compatBuilder.build();
            if (Build.VERSION.SDK_INT >= 24) {
                return Api24Impl.createBigContentView(Api24Impl.recoverBuilder(this.mContext, notification));
            }
            return notification.bigContentView;
        }

        public RemoteViews createHeadsUpContentView() {
            RemoteViews styleView;
            if (Build.VERSION.SDK_INT < 21) {
                return null;
            }
            if (this.mHeadsUpContentView != null && useExistingRemoteView()) {
                return this.mHeadsUpContentView;
            }
            NotificationCompatBuilder compatBuilder = new NotificationCompatBuilder(this);
            Style style = this.mStyle;
            if (style != null && (styleView = style.makeHeadsUpContentView(compatBuilder)) != null) {
                return styleView;
            }
            Notification notification = compatBuilder.build();
            if (Build.VERSION.SDK_INT >= 24) {
                return Api24Impl.createHeadsUpContentView(Api24Impl.recoverBuilder(this.mContext, notification));
            }
            return notification.headsUpContentView;
        }

        public Builder setCustomContentView(RemoteViews contentView) {
            this.mContentView = contentView;
            return this;
        }

        public Builder setCustomBigContentView(RemoteViews contentView) {
            this.mBigContentView = contentView;
            return this;
        }

        public Builder setCustomHeadsUpContentView(RemoteViews contentView) {
            this.mHeadsUpContentView = contentView;
            return this;
        }

        public Builder setChannelId(String channelId) {
            this.mChannelId = channelId;
            return this;
        }

        public Builder setTimeoutAfter(long durationMs) {
            this.mTimeout = durationMs;
            return this;
        }

        public Builder setShortcutId(String shortcutId) {
            this.mShortcutId = shortcutId;
            return this;
        }

        public Builder setShortcutInfo(ShortcutInfoCompat shortcutInfo) {
            if (shortcutInfo == null) {
                return this;
            }
            this.mShortcutId = shortcutInfo.getId();
            if (this.mLocusId == null) {
                if (shortcutInfo.getLocusId() != null) {
                    this.mLocusId = shortcutInfo.getLocusId();
                } else if (shortcutInfo.getId() != null) {
                    this.mLocusId = new LocusIdCompat(shortcutInfo.getId());
                }
            }
            if (this.mContentTitle == null) {
                setContentTitle(shortcutInfo.getShortLabel());
            }
            return this;
        }

        public Builder setLocusId(LocusIdCompat locusId) {
            this.mLocusId = locusId;
            return this;
        }

        public Builder setBadgeIconType(int icon) {
            this.mBadgeIcon = icon;
            return this;
        }

        public Builder setGroupAlertBehavior(int groupAlertBehavior) {
            this.mGroupAlertBehavior = groupAlertBehavior;
            return this;
        }

        public Builder setForegroundServiceBehavior(int behavior) {
            this.mFgsDeferBehavior = behavior;
            return this;
        }

        public Builder setBubbleMetadata(BubbleMetadata data) {
            this.mBubbleMetadata = data;
            return this;
        }

        public Builder extend(Extender extender) {
            extender.extend(this);
            return this;
        }

        public Builder setAllowSystemGeneratedContextualActions(boolean allowed) {
            this.mAllowSystemGeneratedContextualActions = allowed;
            return this;
        }

        @Deprecated
        public Notification getNotification() {
            return build();
        }

        public Notification build() {
            return new NotificationCompatBuilder(this).build();
        }

        protected static CharSequence limitCharSequenceLength(CharSequence cs) {
            if (cs == null) {
                return cs;
            }
            if (cs.length() > MAX_CHARSEQUENCE_LENGTH) {
                return cs.subSequence(0, MAX_CHARSEQUENCE_LENGTH);
            }
            return cs;
        }

        public RemoteViews getContentView() {
            return this.mContentView;
        }

        public RemoteViews getBigContentView() {
            return this.mBigContentView;
        }

        public RemoteViews getHeadsUpContentView() {
            return this.mHeadsUpContentView;
        }

        public long getWhenIfShowing() {
            if (this.mShowWhen) {
                return this.mNotification.when;
            }
            return 0L;
        }

        public int getPriority() {
            return this.mPriority;
        }

        public int getForegroundServiceBehavior() {
            return this.mFgsDeferBehavior;
        }

        public int getColor() {
            return this.mColor;
        }

        public BubbleMetadata getBubbleMetadata() {
            return this.mBubbleMetadata;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static class Api21Impl {
            private Api21Impl() {
            }

            static AudioAttributes.Builder createBuilder() {
                return new AudioAttributes.Builder();
            }

            static AudioAttributes.Builder setContentType(AudioAttributes.Builder builder, int contentType) {
                return builder.setContentType(contentType);
            }

            static AudioAttributes.Builder setUsage(AudioAttributes.Builder builder, int usage) {
                return builder.setUsage(usage);
            }

            static AudioAttributes.Builder setLegacyStreamType(AudioAttributes.Builder builder, int streamType) {
                return builder.setLegacyStreamType(streamType);
            }

            static AudioAttributes build(AudioAttributes.Builder builder) {
                return builder.build();
            }
        }

        /* loaded from: classes.dex */
        static class Api23Impl {
            private Api23Impl() {
            }

            static Icon getSmallIcon(Notification notification) {
                return notification.getSmallIcon();
            }

            static Icon getLargeIcon(Notification notification) {
                return notification.getLargeIcon();
            }
        }

        /* loaded from: classes.dex */
        static class Api24Impl {
            private Api24Impl() {
            }

            static Notification.Builder recoverBuilder(Context context, Notification n) {
                return Notification.Builder.recoverBuilder(context, n);
            }

            static RemoteViews createContentView(Notification.Builder builder) {
                return builder.createContentView();
            }

            static RemoteViews createHeadsUpContentView(Notification.Builder builder) {
                return builder.createHeadsUpContentView();
            }

            static RemoteViews createBigContentView(Notification.Builder builder) {
                return builder.createHeadsUpContentView();
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Style {
        CharSequence mBigContentTitle;
        protected Builder mBuilder;
        CharSequence mSummaryText;
        boolean mSummaryTextSet = false;

        public void setBuilder(Builder builder) {
            if (this.mBuilder != builder) {
                this.mBuilder = builder;
                if (builder != null) {
                    builder.setStyle(this);
                }
            }
        }

        public Notification build() {
            Builder builder = this.mBuilder;
            if (builder == null) {
                return null;
            }
            Notification notification = builder.build();
            return notification;
        }

        protected String getClassName() {
            return null;
        }

        public void apply(NotificationBuilderWithBuilderAccessor builder) {
        }

        public boolean displayCustomViewInline() {
            return false;
        }

        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor builder) {
            return null;
        }

        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor builder) {
            return null;
        }

        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor builder) {
            return null;
        }

        public void addCompatExtras(Bundle extras) {
            if (this.mSummaryTextSet) {
                extras.putCharSequence(NotificationCompat.EXTRA_SUMMARY_TEXT, this.mSummaryText);
            }
            CharSequence charSequence = this.mBigContentTitle;
            if (charSequence != null) {
                extras.putCharSequence(NotificationCompat.EXTRA_TITLE_BIG, charSequence);
            }
            String className = getClassName();
            if (className != null) {
                extras.putString(NotificationCompat.EXTRA_COMPAT_TEMPLATE, className);
            }
        }

        protected void restoreFromCompatExtras(Bundle extras) {
            if (extras.containsKey(NotificationCompat.EXTRA_SUMMARY_TEXT)) {
                this.mSummaryText = extras.getCharSequence(NotificationCompat.EXTRA_SUMMARY_TEXT);
                this.mSummaryTextSet = true;
            }
            this.mBigContentTitle = extras.getCharSequence(NotificationCompat.EXTRA_TITLE_BIG);
        }

        protected void clearCompatExtraKeys(Bundle extras) {
            extras.remove(NotificationCompat.EXTRA_SUMMARY_TEXT);
            extras.remove(NotificationCompat.EXTRA_TITLE_BIG);
            extras.remove(NotificationCompat.EXTRA_COMPAT_TEMPLATE);
        }

        public static Style extractStyleFromNotification(Notification notification) {
            Bundle extras = NotificationCompat.getExtras(notification);
            if (extras == null) {
                return null;
            }
            return constructStyleForExtras(extras);
        }

        private static Style constructCompatStyleByPlatformName(String platformTemplateClass) {
            if (platformTemplateClass == null) {
                return null;
            }
            if (platformTemplateClass.equals(Notification.BigPictureStyle.class.getName())) {
                return new BigPictureStyle();
            }
            if (platformTemplateClass.equals(Notification.BigTextStyle.class.getName())) {
                return new BigTextStyle();
            }
            if (platformTemplateClass.equals(Notification.InboxStyle.class.getName())) {
                return new InboxStyle();
            }
            if (Build.VERSION.SDK_INT >= 24) {
                if (platformTemplateClass.equals(Notification.MessagingStyle.class.getName())) {
                    return new MessagingStyle();
                }
                if (platformTemplateClass.equals(Notification.DecoratedCustomViewStyle.class.getName())) {
                    return new DecoratedCustomViewStyle();
                }
            }
            return null;
        }

        static Style constructCompatStyleByName(String templateClass) {
            if (templateClass != null) {
                char c = 65535;
                switch (templateClass.hashCode()) {
                    case -716705180:
                        if (templateClass.equals("androidx.core.app.NotificationCompat$DecoratedCustomViewStyle")) {
                            c = 3;
                            break;
                        }
                        break;
                    case -171946061:
                        if (templateClass.equals("androidx.core.app.NotificationCompat$BigPictureStyle")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 714386739:
                        if (templateClass.equals("androidx.core.app.NotificationCompat$CallStyle")) {
                            c = 5;
                            break;
                        }
                        break;
                    case 912942987:
                        if (templateClass.equals("androidx.core.app.NotificationCompat$InboxStyle")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 919595044:
                        if (templateClass.equals("androidx.core.app.NotificationCompat$BigTextStyle")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 2090799565:
                        if (templateClass.equals("androidx.core.app.NotificationCompat$MessagingStyle")) {
                            c = 4;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        return new BigTextStyle();
                    case 1:
                        return new BigPictureStyle();
                    case 2:
                        return new InboxStyle();
                    case 3:
                        return new DecoratedCustomViewStyle();
                    case 4:
                        return new MessagingStyle();
                    case 5:
                        return new CallStyle();
                    default:
                        return null;
                }
            }
            return null;
        }

        static Style constructCompatStyleForBundle(Bundle extras) {
            Style style = constructCompatStyleByName(extras.getString(NotificationCompat.EXTRA_COMPAT_TEMPLATE));
            if (style != null) {
                return style;
            }
            if (extras.containsKey(NotificationCompat.EXTRA_SELF_DISPLAY_NAME) || extras.containsKey(NotificationCompat.EXTRA_MESSAGING_STYLE_USER)) {
                return new MessagingStyle();
            }
            if (extras.containsKey(NotificationCompat.EXTRA_PICTURE) || extras.containsKey(NotificationCompat.EXTRA_PICTURE_ICON)) {
                return new BigPictureStyle();
            }
            if (extras.containsKey(NotificationCompat.EXTRA_BIG_TEXT)) {
                return new BigTextStyle();
            }
            if (extras.containsKey(NotificationCompat.EXTRA_TEXT_LINES)) {
                return new InboxStyle();
            }
            if (extras.containsKey(NotificationCompat.EXTRA_CALL_TYPE)) {
                return new CallStyle();
            }
            return constructCompatStyleByPlatformName(extras.getString(NotificationCompat.EXTRA_TEMPLATE));
        }

        static Style constructStyleForExtras(Bundle extras) {
            Style style = constructCompatStyleForBundle(extras);
            if (style == null) {
                return null;
            }
            try {
                style.restoreFromCompatExtras(extras);
                return style;
            } catch (ClassCastException e) {
                return null;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:62:0x01b9  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x01dd  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x0234  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x0236  */
        /* JADX WARN: Removed duplicated region for block: B:83:0x0240  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public android.widget.RemoteViews applyStandardTemplate(boolean r20, int r21, boolean r22) {
            /*
                Method dump skipped, instructions count: 582
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.NotificationCompat.Style.applyStandardTemplate(boolean, int, boolean):android.widget.RemoteViews");
        }

        public Bitmap createColoredBitmap(int iconId, int color) {
            return createColoredBitmap(iconId, color, 0);
        }

        Bitmap createColoredBitmap(IconCompat icon, int color) {
            return createColoredBitmap(icon, color, 0);
        }

        private Bitmap createColoredBitmap(int iconId, int color, int size) {
            return createColoredBitmap(IconCompat.createWithResource(this.mBuilder.mContext, iconId), color, size);
        }

        private Bitmap createColoredBitmap(IconCompat icon, int color, int size) {
            Drawable drawable = icon.loadDrawable(this.mBuilder.mContext);
            int width = size == 0 ? drawable.getIntrinsicWidth() : size;
            int height = size == 0 ? drawable.getIntrinsicHeight() : size;
            Bitmap resultBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            drawable.setBounds(0, 0, width, height);
            if (color != 0) {
                drawable.mutate().setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN));
            }
            Canvas canvas = new Canvas(resultBitmap);
            drawable.draw(canvas);
            return resultBitmap;
        }

        private Bitmap createIconWithBackground(int iconId, int size, int iconSize, int color) {
            Bitmap coloredBitmap = createColoredBitmap(R.drawable.notification_icon_background, color == 0 ? 0 : color, size);
            Canvas canvas = new Canvas(coloredBitmap);
            Drawable icon = this.mBuilder.mContext.getResources().getDrawable(iconId).mutate();
            icon.setFilterBitmap(true);
            int inset = (size - iconSize) / 2;
            icon.setBounds(inset, inset, iconSize + inset, iconSize + inset);
            icon.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
            icon.draw(canvas);
            return coloredBitmap;
        }

        public void buildIntoRemoteViews(RemoteViews outerView, RemoteViews innerView) {
            hideNormalContent(outerView);
            outerView.removeAllViews(R.id.notification_main_column);
            outerView.addView(R.id.notification_main_column, innerView.clone());
            outerView.setViewVisibility(R.id.notification_main_column, 0);
            if (Build.VERSION.SDK_INT >= 21) {
                int top = calculateTopPadding();
                outerView.setViewPadding(R.id.notification_main_column_container, 0, top, 0, 0);
            }
        }

        private void hideNormalContent(RemoteViews outerView) {
            outerView.setViewVisibility(R.id.title, 8);
            outerView.setViewVisibility(R.id.text2, 8);
            outerView.setViewVisibility(R.id.text, 8);
        }

        private int calculateTopPadding() {
            Resources resources = this.mBuilder.mContext.getResources();
            int padding = resources.getDimensionPixelSize(R.dimen.notification_top_pad);
            int largePadding = resources.getDimensionPixelSize(R.dimen.notification_top_pad_large_text);
            float fontScale = resources.getConfiguration().fontScale;
            float largeFactor = (constrain(fontScale, 1.0f, 1.3f) - 1.0f) / 0.29999995f;
            return Math.round(((1.0f - largeFactor) * padding) + (largePadding * largeFactor));
        }

        private static float constrain(float amount, float low, float high) {
            return amount < low ? low : amount > high ? high : amount;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static class Api24Impl {
            private Api24Impl() {
            }

            static void setChronometerCountDown(RemoteViews remoteViews, int viewId, boolean isCountDown) {
                remoteViews.setChronometerCountDown(viewId, isCountDown);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class BigPictureStyle extends Style {
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$BigPictureStyle";
        private IconCompat mBigLargeIcon;
        private boolean mBigLargeIconSet;
        private CharSequence mPictureContentDescription;
        private IconCompat mPictureIcon;
        private boolean mShowBigPictureWhenCollapsed;

        public BigPictureStyle() {
        }

        public BigPictureStyle(Builder builder) {
            setBuilder(builder);
        }

        public BigPictureStyle setBigContentTitle(CharSequence title) {
            this.mBigContentTitle = Builder.limitCharSequenceLength(title);
            return this;
        }

        public BigPictureStyle setSummaryText(CharSequence cs) {
            this.mSummaryText = Builder.limitCharSequenceLength(cs);
            this.mSummaryTextSet = true;
            return this;
        }

        public BigPictureStyle setContentDescription(CharSequence contentDescription) {
            this.mPictureContentDescription = contentDescription;
            return this;
        }

        public BigPictureStyle bigPicture(Bitmap b) {
            this.mPictureIcon = b == null ? null : IconCompat.createWithBitmap(b);
            return this;
        }

        public BigPictureStyle bigPicture(Icon i) {
            this.mPictureIcon = IconCompat.createFromIcon(i);
            return this;
        }

        public BigPictureStyle showBigPictureWhenCollapsed(boolean show) {
            this.mShowBigPictureWhenCollapsed = show;
            return this;
        }

        public BigPictureStyle bigLargeIcon(Bitmap b) {
            this.mBigLargeIcon = b == null ? null : IconCompat.createWithBitmap(b);
            this.mBigLargeIconSet = true;
            return this;
        }

        public BigPictureStyle bigLargeIcon(Icon i) {
            this.mBigLargeIcon = i == null ? null : IconCompat.createFromIcon(i);
            this.mBigLargeIconSet = true;
            return this;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        protected String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void apply(NotificationBuilderWithBuilderAccessor builder) {
            Notification.Builder builder1 = builder.getBuilder();
            Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle(builder1);
            Notification.BigPictureStyle style = bigPictureStyle.setBigContentTitle(this.mBigContentTitle);
            if (this.mPictureIcon != null) {
                if (Build.VERSION.SDK_INT >= 31) {
                    Context context = null;
                    if (builder instanceof NotificationCompatBuilder) {
                        context = ((NotificationCompatBuilder) builder).getContext();
                    }
                    Api31Impl.setBigPicture(style, this.mPictureIcon.toIcon(context));
                } else if (this.mPictureIcon.getType() == 1) {
                    Bitmap b = this.mPictureIcon.getBitmap();
                    style = style.bigPicture(b);
                }
            }
            if (this.mBigLargeIconSet) {
                if (this.mBigLargeIcon == null) {
                    style.bigLargeIcon((Bitmap) null);
                } else if (Build.VERSION.SDK_INT >= 23) {
                    Context context2 = null;
                    if (builder instanceof NotificationCompatBuilder) {
                        context2 = ((NotificationCompatBuilder) builder).getContext();
                    }
                    Api23Impl.setBigLargeIcon(style, this.mBigLargeIcon.toIcon(context2));
                } else if (this.mBigLargeIcon.getType() == 1) {
                    style.bigLargeIcon(this.mBigLargeIcon.getBitmap());
                } else {
                    style.bigLargeIcon((Bitmap) null);
                }
            }
            if (this.mSummaryTextSet) {
                style.setSummaryText(this.mSummaryText);
            }
            if (Build.VERSION.SDK_INT >= 31) {
                Api31Impl.showBigPictureWhenCollapsed(style, this.mShowBigPictureWhenCollapsed);
                Api31Impl.setContentDescription(style, this.mPictureContentDescription);
            }
        }

        @Override // androidx.core.app.NotificationCompat.Style
        protected void restoreFromCompatExtras(Bundle extras) {
            super.restoreFromCompatExtras(extras);
            if (extras.containsKey(NotificationCompat.EXTRA_LARGE_ICON_BIG)) {
                this.mBigLargeIcon = asIconCompat(extras.getParcelable(NotificationCompat.EXTRA_LARGE_ICON_BIG));
                this.mBigLargeIconSet = true;
            }
            this.mPictureIcon = getPictureIcon(extras);
            this.mShowBigPictureWhenCollapsed = extras.getBoolean(NotificationCompat.EXTRA_SHOW_BIG_PICTURE_WHEN_COLLAPSED);
        }

        public static IconCompat getPictureIcon(Bundle extras) {
            if (extras == null) {
                return null;
            }
            Parcelable bitmapPicture = extras.getParcelable(NotificationCompat.EXTRA_PICTURE);
            if (bitmapPicture != null) {
                return asIconCompat(bitmapPicture);
            }
            return asIconCompat(extras.getParcelable(NotificationCompat.EXTRA_PICTURE_ICON));
        }

        private static IconCompat asIconCompat(Parcelable bitmapOrIcon) {
            if (bitmapOrIcon != null) {
                if (Build.VERSION.SDK_INT >= 23 && (bitmapOrIcon instanceof Icon)) {
                    return IconCompat.createFromIcon((Icon) bitmapOrIcon);
                }
                if (bitmapOrIcon instanceof Bitmap) {
                    return IconCompat.createWithBitmap((Bitmap) bitmapOrIcon);
                }
                return null;
            }
            return null;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        protected void clearCompatExtraKeys(Bundle extras) {
            super.clearCompatExtraKeys(extras);
            extras.remove(NotificationCompat.EXTRA_LARGE_ICON_BIG);
            extras.remove(NotificationCompat.EXTRA_PICTURE);
            extras.remove(NotificationCompat.EXTRA_PICTURE_ICON);
            extras.remove(NotificationCompat.EXTRA_SHOW_BIG_PICTURE_WHEN_COLLAPSED);
        }

        /* loaded from: classes.dex */
        private static class Api23Impl {
            private Api23Impl() {
            }

            static void setBigLargeIcon(Notification.BigPictureStyle style, Icon icon) {
                style.bigLargeIcon(icon);
            }
        }

        /* loaded from: classes.dex */
        private static class Api31Impl {
            private Api31Impl() {
            }

            static void showBigPictureWhenCollapsed(Notification.BigPictureStyle style, boolean show) {
                style.showBigPictureWhenCollapsed(show);
            }

            static void setContentDescription(Notification.BigPictureStyle style, CharSequence contentDescription) {
                style.setContentDescription(contentDescription);
            }

            static void setBigPicture(Notification.BigPictureStyle style, Icon icon) {
                style.bigPicture(icon);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class BigTextStyle extends Style {
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$BigTextStyle";
        private CharSequence mBigText;

        public BigTextStyle() {
        }

        public BigTextStyle(Builder builder) {
            setBuilder(builder);
        }

        public BigTextStyle setBigContentTitle(CharSequence title) {
            this.mBigContentTitle = Builder.limitCharSequenceLength(title);
            return this;
        }

        public BigTextStyle setSummaryText(CharSequence cs) {
            this.mSummaryText = Builder.limitCharSequenceLength(cs);
            this.mSummaryTextSet = true;
            return this;
        }

        public BigTextStyle bigText(CharSequence cs) {
            this.mBigText = Builder.limitCharSequenceLength(cs);
            return this;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        protected String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void apply(NotificationBuilderWithBuilderAccessor builder) {
            Notification.Builder builder1 = builder.getBuilder();
            Notification.BigTextStyle style = new Notification.BigTextStyle(builder1);
            Notification.BigTextStyle style2 = style.setBigContentTitle(this.mBigContentTitle).bigText(this.mBigText);
            if (this.mSummaryTextSet) {
                style2.setSummaryText(this.mSummaryText);
            }
        }

        @Override // androidx.core.app.NotificationCompat.Style
        protected void restoreFromCompatExtras(Bundle extras) {
            super.restoreFromCompatExtras(extras);
            this.mBigText = extras.getCharSequence(NotificationCompat.EXTRA_BIG_TEXT);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void addCompatExtras(Bundle extras) {
            super.addCompatExtras(extras);
            if (Build.VERSION.SDK_INT < 21) {
                extras.putCharSequence(NotificationCompat.EXTRA_BIG_TEXT, this.mBigText);
            }
        }

        @Override // androidx.core.app.NotificationCompat.Style
        protected void clearCompatExtraKeys(Bundle extras) {
            super.clearCompatExtraKeys(extras);
            extras.remove(NotificationCompat.EXTRA_BIG_TEXT);
        }
    }

    /* loaded from: classes.dex */
    public static class MessagingStyle extends Style {
        public static final int MAXIMUM_RETAINED_MESSAGES = 25;
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$MessagingStyle";
        private CharSequence mConversationTitle;
        private Boolean mIsGroupConversation;
        private Person mUser;
        private final List<Message> mMessages = new ArrayList();
        private final List<Message> mHistoricMessages = new ArrayList();

        MessagingStyle() {
        }

        @Deprecated
        public MessagingStyle(CharSequence userDisplayName) {
            this.mUser = new Person.Builder().setName(userDisplayName).build();
        }

        public MessagingStyle(Person user) {
            if (TextUtils.isEmpty(user.getName())) {
                throw new IllegalArgumentException("User's name must not be empty.");
            }
            this.mUser = user;
        }

        @Deprecated
        public CharSequence getUserDisplayName() {
            return this.mUser.getName();
        }

        public Person getUser() {
            return this.mUser;
        }

        public MessagingStyle setConversationTitle(CharSequence conversationTitle) {
            this.mConversationTitle = conversationTitle;
            return this;
        }

        public CharSequence getConversationTitle() {
            return this.mConversationTitle;
        }

        @Deprecated
        public MessagingStyle addMessage(CharSequence text, long timestamp, CharSequence sender) {
            this.mMessages.add(new Message(text, timestamp, new Person.Builder().setName(sender).build()));
            if (this.mMessages.size() > 25) {
                this.mMessages.remove(0);
            }
            return this;
        }

        public MessagingStyle addMessage(CharSequence text, long timestamp, Person person) {
            addMessage(new Message(text, timestamp, person));
            return this;
        }

        public MessagingStyle addMessage(Message message) {
            if (message != null) {
                this.mMessages.add(message);
                if (this.mMessages.size() > 25) {
                    this.mMessages.remove(0);
                }
            }
            return this;
        }

        public MessagingStyle addHistoricMessage(Message message) {
            if (message != null) {
                this.mHistoricMessages.add(message);
                if (this.mHistoricMessages.size() > 25) {
                    this.mHistoricMessages.remove(0);
                }
            }
            return this;
        }

        public List<Message> getMessages() {
            return this.mMessages;
        }

        public List<Message> getHistoricMessages() {
            return this.mHistoricMessages;
        }

        public MessagingStyle setGroupConversation(boolean isGroupConversation) {
            this.mIsGroupConversation = Boolean.valueOf(isGroupConversation);
            return this;
        }

        public boolean isGroupConversation() {
            if (this.mBuilder != null && this.mBuilder.mContext.getApplicationInfo().targetSdkVersion < 28 && this.mIsGroupConversation == null) {
                return this.mConversationTitle != null;
            }
            Boolean bool = this.mIsGroupConversation;
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        }

        public static MessagingStyle extractMessagingStyleFromNotification(Notification notification) {
            Style style = Style.extractStyleFromNotification(notification);
            if (style instanceof MessagingStyle) {
                return (MessagingStyle) style;
            }
            return null;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        protected String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void apply(NotificationBuilderWithBuilderAccessor builder) {
            CharSequence text;
            Notification.MessagingStyle createMessagingStyle;
            setGroupConversation(isGroupConversation());
            if (Build.VERSION.SDK_INT >= 24) {
                if (Build.VERSION.SDK_INT >= 28) {
                    createMessagingStyle = Api28Impl.createMessagingStyle(this.mUser.toAndroidPerson());
                } else {
                    createMessagingStyle = Api24Impl.createMessagingStyle(this.mUser.getName());
                }
                for (Message message : this.mMessages) {
                    Api24Impl.addMessage(createMessagingStyle, message.toAndroidMessage());
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    for (Message historicMessage : this.mHistoricMessages) {
                        Api26Impl.addHistoricMessage(createMessagingStyle, historicMessage.toAndroidMessage());
                    }
                }
                if (this.mIsGroupConversation.booleanValue() || Build.VERSION.SDK_INT >= 28) {
                    Api24Impl.setConversationTitle(createMessagingStyle, this.mConversationTitle);
                }
                if (Build.VERSION.SDK_INT >= 28) {
                    Api28Impl.setGroupConversation(createMessagingStyle, this.mIsGroupConversation.booleanValue());
                }
                Notification.Builder builder1 = builder.getBuilder();
                createMessagingStyle.setBuilder(builder1);
                return;
            }
            Message latestIncomingMessage = findLatestIncomingMessage();
            if (this.mConversationTitle != null && this.mIsGroupConversation.booleanValue()) {
                builder.getBuilder().setContentTitle(this.mConversationTitle);
            } else if (latestIncomingMessage != null) {
                builder.getBuilder().setContentTitle("");
                if (latestIncomingMessage.getPerson() != null) {
                    builder.getBuilder().setContentTitle(latestIncomingMessage.getPerson().getName());
                }
            }
            if (latestIncomingMessage != null) {
                Notification.Builder builder2 = builder.getBuilder();
                if (this.mConversationTitle != null) {
                    text = makeMessageLine(latestIncomingMessage);
                } else {
                    text = latestIncomingMessage.getText();
                }
                builder2.setContentText(text);
            }
            SpannableStringBuilder completeMessage = new SpannableStringBuilder();
            boolean showNames = this.mConversationTitle != null || hasMessagesWithoutSender();
            for (int i = this.mMessages.size() - 1; i >= 0; i--) {
                Message message2 = this.mMessages.get(i);
                CharSequence line = showNames ? makeMessageLine(message2) : message2.getText();
                if (i != this.mMessages.size() - 1) {
                    completeMessage.insert(0, (CharSequence) "\n");
                }
                completeMessage.insert(0, line);
            }
            Notification.Builder builder12 = builder.getBuilder();
            Notification.BigTextStyle style = new Notification.BigTextStyle(builder12);
            style.setBigContentTitle(null).bigText(completeMessage);
        }

        private Message findLatestIncomingMessage() {
            List<Message> list;
            for (int i = this.mMessages.size() - 1; i >= 0; i--) {
                Message message = this.mMessages.get(i);
                if (message.getPerson() != null && !TextUtils.isEmpty(message.getPerson().getName())) {
                    return message;
                }
            }
            if (!this.mMessages.isEmpty()) {
                return this.mMessages.get(list.size() - 1);
            }
            return null;
        }

        private boolean hasMessagesWithoutSender() {
            for (int i = this.mMessages.size() - 1; i >= 0; i--) {
                Message message = this.mMessages.get(i);
                if (message.getPerson() != null && message.getPerson().getName() == null) {
                    return true;
                }
            }
            return false;
        }

        private CharSequence makeMessageLine(Message message) {
            int i;
            BidiFormatter bidi = BidiFormatter.getInstance();
            SpannableStringBuilder sb = new SpannableStringBuilder();
            boolean afterLollipop = Build.VERSION.SDK_INT >= 21;
            int color = afterLollipop ? ViewCompat.MEASURED_STATE_MASK : -1;
            String replyName = message.getPerson() == null ? "" : message.getPerson().getName();
            if (TextUtils.isEmpty(replyName)) {
                replyName = this.mUser.getName();
                if (afterLollipop && this.mBuilder.getColor() != 0) {
                    i = this.mBuilder.getColor();
                } else {
                    i = color;
                }
                color = i;
            }
            CharSequence senderText = bidi.unicodeWrap(replyName);
            sb.append(senderText);
            sb.setSpan(makeFontColorSpan(color), sb.length() - senderText.length(), sb.length(), 33);
            String text = message.getText() != null ? message.getText() : "";
            sb.append((CharSequence) "  ").append(bidi.unicodeWrap(text));
            return sb;
        }

        private TextAppearanceSpan makeFontColorSpan(int color) {
            return new TextAppearanceSpan(null, 0, 0, ColorStateList.valueOf(color), null);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void addCompatExtras(Bundle extras) {
            super.addCompatExtras(extras);
            extras.putCharSequence(NotificationCompat.EXTRA_SELF_DISPLAY_NAME, this.mUser.getName());
            extras.putBundle(NotificationCompat.EXTRA_MESSAGING_STYLE_USER, this.mUser.toBundle());
            extras.putCharSequence(NotificationCompat.EXTRA_HIDDEN_CONVERSATION_TITLE, this.mConversationTitle);
            if (this.mConversationTitle != null && this.mIsGroupConversation.booleanValue()) {
                extras.putCharSequence(NotificationCompat.EXTRA_CONVERSATION_TITLE, this.mConversationTitle);
            }
            if (!this.mMessages.isEmpty()) {
                extras.putParcelableArray(NotificationCompat.EXTRA_MESSAGES, Message.getBundleArrayForMessages(this.mMessages));
            }
            if (!this.mHistoricMessages.isEmpty()) {
                extras.putParcelableArray(NotificationCompat.EXTRA_HISTORIC_MESSAGES, Message.getBundleArrayForMessages(this.mHistoricMessages));
            }
            Boolean bool = this.mIsGroupConversation;
            if (bool != null) {
                extras.putBoolean(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION, bool.booleanValue());
            }
        }

        @Override // androidx.core.app.NotificationCompat.Style
        protected void restoreFromCompatExtras(Bundle extras) {
            super.restoreFromCompatExtras(extras);
            this.mMessages.clear();
            if (extras.containsKey(NotificationCompat.EXTRA_MESSAGING_STYLE_USER)) {
                this.mUser = Person.fromBundle(extras.getBundle(NotificationCompat.EXTRA_MESSAGING_STYLE_USER));
            } else {
                this.mUser = new Person.Builder().setName(extras.getString(NotificationCompat.EXTRA_SELF_DISPLAY_NAME)).build();
            }
            CharSequence charSequence = extras.getCharSequence(NotificationCompat.EXTRA_CONVERSATION_TITLE);
            this.mConversationTitle = charSequence;
            if (charSequence == null) {
                this.mConversationTitle = extras.getCharSequence(NotificationCompat.EXTRA_HIDDEN_CONVERSATION_TITLE);
            }
            Parcelable[] messages = extras.getParcelableArray(NotificationCompat.EXTRA_MESSAGES);
            if (messages != null) {
                this.mMessages.addAll(Message.getMessagesFromBundleArray(messages));
            }
            Parcelable[] historicMessages = extras.getParcelableArray(NotificationCompat.EXTRA_HISTORIC_MESSAGES);
            if (historicMessages != null) {
                this.mHistoricMessages.addAll(Message.getMessagesFromBundleArray(historicMessages));
            }
            if (extras.containsKey(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION)) {
                this.mIsGroupConversation = Boolean.valueOf(extras.getBoolean(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION));
            }
        }

        @Override // androidx.core.app.NotificationCompat.Style
        protected void clearCompatExtraKeys(Bundle extras) {
            super.clearCompatExtraKeys(extras);
            extras.remove(NotificationCompat.EXTRA_MESSAGING_STYLE_USER);
            extras.remove(NotificationCompat.EXTRA_SELF_DISPLAY_NAME);
            extras.remove(NotificationCompat.EXTRA_CONVERSATION_TITLE);
            extras.remove(NotificationCompat.EXTRA_HIDDEN_CONVERSATION_TITLE);
            extras.remove(NotificationCompat.EXTRA_MESSAGES);
            extras.remove(NotificationCompat.EXTRA_HISTORIC_MESSAGES);
            extras.remove(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION);
        }

        /* loaded from: classes.dex */
        public static final class Message {
            static final String KEY_DATA_MIME_TYPE = "type";
            static final String KEY_DATA_URI = "uri";
            static final String KEY_EXTRAS_BUNDLE = "extras";
            static final String KEY_NOTIFICATION_PERSON = "sender_person";
            static final String KEY_PERSON = "person";
            static final String KEY_SENDER = "sender";
            static final String KEY_TEXT = "text";
            static final String KEY_TIMESTAMP = "time";
            private String mDataMimeType;
            private Uri mDataUri;
            private Bundle mExtras;
            private final Person mPerson;
            private final CharSequence mText;
            private final long mTimestamp;

            public Message(CharSequence text, long timestamp, Person person) {
                this.mExtras = new Bundle();
                this.mText = text;
                this.mTimestamp = timestamp;
                this.mPerson = person;
            }

            @Deprecated
            public Message(CharSequence text, long timestamp, CharSequence sender) {
                this(text, timestamp, new Person.Builder().setName(sender).build());
            }

            public Message setData(String dataMimeType, Uri dataUri) {
                this.mDataMimeType = dataMimeType;
                this.mDataUri = dataUri;
                return this;
            }

            public CharSequence getText() {
                return this.mText;
            }

            public long getTimestamp() {
                return this.mTimestamp;
            }

            public Bundle getExtras() {
                return this.mExtras;
            }

            @Deprecated
            public CharSequence getSender() {
                Person person = this.mPerson;
                if (person == null) {
                    return null;
                }
                return person.getName();
            }

            public Person getPerson() {
                return this.mPerson;
            }

            public String getDataMimeType() {
                return this.mDataMimeType;
            }

            public Uri getDataUri() {
                return this.mDataUri;
            }

            private Bundle toBundle() {
                Bundle bundle = new Bundle();
                CharSequence charSequence = this.mText;
                if (charSequence != null) {
                    bundle.putCharSequence(KEY_TEXT, charSequence);
                }
                bundle.putLong(KEY_TIMESTAMP, this.mTimestamp);
                Person person = this.mPerson;
                if (person != null) {
                    bundle.putCharSequence(KEY_SENDER, person.getName());
                    if (Build.VERSION.SDK_INT >= 28) {
                        bundle.putParcelable(KEY_NOTIFICATION_PERSON, Api28Impl.castToParcelable(this.mPerson.toAndroidPerson()));
                    } else {
                        bundle.putBundle(KEY_PERSON, this.mPerson.toBundle());
                    }
                }
                String str = this.mDataMimeType;
                if (str != null) {
                    bundle.putString(KEY_DATA_MIME_TYPE, str);
                }
                Uri uri = this.mDataUri;
                if (uri != null) {
                    bundle.putParcelable(KEY_DATA_URI, uri);
                }
                Bundle bundle2 = this.mExtras;
                if (bundle2 != null) {
                    bundle.putBundle(KEY_EXTRAS_BUNDLE, bundle2);
                }
                return bundle;
            }

            static Bundle[] getBundleArrayForMessages(List<Message> messages) {
                Bundle[] bundles = new Bundle[messages.size()];
                int N = messages.size();
                for (int i = 0; i < N; i++) {
                    bundles[i] = messages.get(i).toBundle();
                }
                return bundles;
            }

            static List<Message> getMessagesFromBundleArray(Parcelable[] bundles) {
                Message message;
                List<Message> messages = new ArrayList<>(bundles.length);
                for (int i = 0; i < bundles.length; i++) {
                    if ((bundles[i] instanceof Bundle) && (message = getMessageFromBundle((Bundle) bundles[i])) != null) {
                        messages.add(message);
                    }
                }
                return messages;
            }

            static Message getMessageFromBundle(Bundle bundle) {
                try {
                    if (bundle.containsKey(KEY_TEXT) && bundle.containsKey(KEY_TIMESTAMP)) {
                        Person person = null;
                        if (bundle.containsKey(KEY_PERSON)) {
                            person = Person.fromBundle(bundle.getBundle(KEY_PERSON));
                        } else if (bundle.containsKey(KEY_NOTIFICATION_PERSON) && Build.VERSION.SDK_INT >= 28) {
                            person = Person.fromAndroidPerson((android.app.Person) bundle.getParcelable(KEY_NOTIFICATION_PERSON));
                        } else if (bundle.containsKey(KEY_SENDER)) {
                            person = new Person.Builder().setName(bundle.getCharSequence(KEY_SENDER)).build();
                        }
                        Message message = new Message(bundle.getCharSequence(KEY_TEXT), bundle.getLong(KEY_TIMESTAMP), person);
                        if (bundle.containsKey(KEY_DATA_MIME_TYPE) && bundle.containsKey(KEY_DATA_URI)) {
                            message.setData(bundle.getString(KEY_DATA_MIME_TYPE), (Uri) bundle.getParcelable(KEY_DATA_URI));
                        }
                        if (bundle.containsKey(KEY_EXTRAS_BUNDLE)) {
                            message.getExtras().putAll(bundle.getBundle(KEY_EXTRAS_BUNDLE));
                        }
                        return message;
                    }
                    return null;
                } catch (ClassCastException e) {
                    return null;
                }
            }

            Notification.MessagingStyle.Message toAndroidMessage() {
                Notification.MessagingStyle.Message frameworkMessage;
                Person person = getPerson();
                if (Build.VERSION.SDK_INT >= 28) {
                    frameworkMessage = Api28Impl.createMessage(getText(), getTimestamp(), person != null ? person.toAndroidPerson() : null);
                } else {
                    frameworkMessage = Api24Impl.createMessage(getText(), getTimestamp(), person != null ? person.getName() : null);
                }
                if (getDataMimeType() != null) {
                    Api24Impl.setData(frameworkMessage, getDataMimeType(), getDataUri());
                }
                return frameworkMessage;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* loaded from: classes.dex */
            public static class Api24Impl {
                private Api24Impl() {
                }

                static Notification.MessagingStyle.Message createMessage(CharSequence text, long timestamp, CharSequence sender) {
                    return new Notification.MessagingStyle.Message(text, timestamp, sender);
                }

                static Notification.MessagingStyle.Message setData(Notification.MessagingStyle.Message message, String dataMimeType, Uri dataUri) {
                    return message.setData(dataMimeType, dataUri);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* loaded from: classes.dex */
            public static class Api28Impl {
                private Api28Impl() {
                }

                static Notification.MessagingStyle.Message createMessage(CharSequence text, long timestamp, android.app.Person sender) {
                    return new Notification.MessagingStyle.Message(text, timestamp, sender);
                }

                static Parcelable castToParcelable(android.app.Person person) {
                    return person;
                }
            }
        }

        /* loaded from: classes.dex */
        static class Api24Impl {
            private Api24Impl() {
            }

            static Notification.MessagingStyle createMessagingStyle(CharSequence userDisplayName) {
                return new Notification.MessagingStyle(userDisplayName);
            }

            static Notification.MessagingStyle addMessage(Notification.MessagingStyle messagingStyle, Notification.MessagingStyle.Message message) {
                return messagingStyle.addMessage(message);
            }

            static Notification.MessagingStyle setConversationTitle(Notification.MessagingStyle messagingStyle, CharSequence conversationTitle) {
                return messagingStyle.setConversationTitle(conversationTitle);
            }
        }

        /* loaded from: classes.dex */
        static class Api26Impl {
            private Api26Impl() {
            }

            static Notification.MessagingStyle addHistoricMessage(Notification.MessagingStyle messagingStyle, Notification.MessagingStyle.Message message) {
                return messagingStyle.addHistoricMessage(message);
            }
        }

        /* loaded from: classes.dex */
        static class Api28Impl {
            private Api28Impl() {
            }

            static Notification.MessagingStyle createMessagingStyle(android.app.Person user) {
                return new Notification.MessagingStyle(user);
            }

            static Notification.MessagingStyle setGroupConversation(Notification.MessagingStyle messagingStyle, boolean isGroupConversation) {
                return messagingStyle.setGroupConversation(isGroupConversation);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CallStyle extends Style {
        public static final int CALL_TYPE_INCOMING = 1;
        public static final int CALL_TYPE_ONGOING = 2;
        public static final int CALL_TYPE_SCREENING = 3;
        public static final int CALL_TYPE_UNKNOWN = 0;
        private static final String KEY_ACTION_PRIORITY = "key_action_priority";
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$CallStyle";
        private Integer mAnswerButtonColor;
        private PendingIntent mAnswerIntent;
        private int mCallType;
        private Integer mDeclineButtonColor;
        private PendingIntent mDeclineIntent;
        private PendingIntent mHangUpIntent;
        private boolean mIsVideo;
        private Person mPerson;
        private IconCompat mVerificationIcon;
        private CharSequence mVerificationText;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes.dex */
        public @interface CallType {
        }

        public CallStyle() {
        }

        public CallStyle(Builder builder) {
            setBuilder(builder);
        }

        public static CallStyle forIncomingCall(Person person, PendingIntent declineIntent, PendingIntent answerIntent) {
            return new CallStyle(1, person, null, (PendingIntent) Objects.requireNonNull(declineIntent, "declineIntent is required"), (PendingIntent) Objects.requireNonNull(answerIntent, "answerIntent is required"));
        }

        public static CallStyle forOngoingCall(Person person, PendingIntent hangUpIntent) {
            return new CallStyle(2, person, (PendingIntent) Objects.requireNonNull(hangUpIntent, "hangUpIntent is required"), null, null);
        }

        public static CallStyle forScreeningCall(Person person, PendingIntent hangUpIntent, PendingIntent answerIntent) {
            return new CallStyle(3, person, (PendingIntent) Objects.requireNonNull(hangUpIntent, "hangUpIntent is required"), null, (PendingIntent) Objects.requireNonNull(answerIntent, "answerIntent is required"));
        }

        private CallStyle(int callType, Person person, PendingIntent hangUpIntent, PendingIntent declineIntent, PendingIntent answerIntent) {
            if (person == null || TextUtils.isEmpty(person.getName())) {
                throw new IllegalArgumentException("person must have a non-empty a name");
            }
            this.mCallType = callType;
            this.mPerson = person;
            this.mAnswerIntent = answerIntent;
            this.mDeclineIntent = declineIntent;
            this.mHangUpIntent = hangUpIntent;
        }

        public CallStyle setIsVideo(boolean isVideo) {
            this.mIsVideo = isVideo;
            return this;
        }

        public CallStyle setVerificationIcon(Icon verificationIcon) {
            this.mVerificationIcon = verificationIcon == null ? null : IconCompat.createFromIcon(verificationIcon);
            return this;
        }

        public CallStyle setVerificationIcon(Bitmap verificationIcon) {
            this.mVerificationIcon = IconCompat.createWithBitmap(verificationIcon);
            return this;
        }

        public CallStyle setVerificationText(CharSequence verificationText) {
            this.mVerificationText = verificationText;
            return this;
        }

        public CallStyle setAnswerButtonColorHint(int color) {
            this.mAnswerButtonColor = Integer.valueOf(color);
            return this;
        }

        public CallStyle setDeclineButtonColorHint(int color) {
            this.mDeclineButtonColor = Integer.valueOf(color);
            return this;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public boolean displayCustomViewInline() {
            return true;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        protected void restoreFromCompatExtras(Bundle extras) {
            super.restoreFromCompatExtras(extras);
            this.mCallType = extras.getInt(NotificationCompat.EXTRA_CALL_TYPE);
            this.mIsVideo = extras.getBoolean(NotificationCompat.EXTRA_CALL_IS_VIDEO);
            if (Build.VERSION.SDK_INT >= 28 && extras.containsKey(NotificationCompat.EXTRA_CALL_PERSON)) {
                this.mPerson = Person.fromAndroidPerson((android.app.Person) extras.getParcelable(NotificationCompat.EXTRA_CALL_PERSON));
            } else if (extras.containsKey(NotificationCompat.EXTRA_CALL_PERSON_COMPAT)) {
                this.mPerson = Person.fromBundle(extras.getBundle(NotificationCompat.EXTRA_CALL_PERSON_COMPAT));
            }
            if (Build.VERSION.SDK_INT >= 23 && extras.containsKey(NotificationCompat.EXTRA_VERIFICATION_ICON)) {
                this.mVerificationIcon = IconCompat.createFromIcon((Icon) extras.getParcelable(NotificationCompat.EXTRA_VERIFICATION_ICON));
            } else if (extras.containsKey(NotificationCompat.EXTRA_VERIFICATION_ICON_COMPAT)) {
                this.mVerificationIcon = IconCompat.createFromBundle(extras.getBundle(NotificationCompat.EXTRA_VERIFICATION_ICON_COMPAT));
            }
            this.mVerificationText = extras.getCharSequence(NotificationCompat.EXTRA_VERIFICATION_TEXT);
            this.mAnswerIntent = (PendingIntent) extras.getParcelable(NotificationCompat.EXTRA_ANSWER_INTENT);
            this.mDeclineIntent = (PendingIntent) extras.getParcelable(NotificationCompat.EXTRA_DECLINE_INTENT);
            this.mHangUpIntent = (PendingIntent) extras.getParcelable(NotificationCompat.EXTRA_HANG_UP_INTENT);
            this.mAnswerButtonColor = extras.containsKey(NotificationCompat.EXTRA_ANSWER_COLOR) ? Integer.valueOf(extras.getInt(NotificationCompat.EXTRA_ANSWER_COLOR)) : null;
            this.mDeclineButtonColor = extras.containsKey(NotificationCompat.EXTRA_DECLINE_COLOR) ? Integer.valueOf(extras.getInt(NotificationCompat.EXTRA_DECLINE_COLOR)) : null;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void addCompatExtras(Bundle extras) {
            super.addCompatExtras(extras);
            extras.putInt(NotificationCompat.EXTRA_CALL_TYPE, this.mCallType);
            extras.putBoolean(NotificationCompat.EXTRA_CALL_IS_VIDEO, this.mIsVideo);
            if (this.mPerson != null) {
                if (Build.VERSION.SDK_INT >= 28) {
                    extras.putParcelable(NotificationCompat.EXTRA_CALL_PERSON, Api28Impl.castToParcelable(this.mPerson.toAndroidPerson()));
                } else {
                    extras.putParcelable(NotificationCompat.EXTRA_CALL_PERSON_COMPAT, this.mPerson.toBundle());
                }
            }
            if (this.mVerificationIcon != null) {
                if (Build.VERSION.SDK_INT >= 23) {
                    extras.putParcelable(NotificationCompat.EXTRA_VERIFICATION_ICON, Api23Impl.castToParcelable(this.mVerificationIcon.toIcon(this.mBuilder.mContext)));
                } else {
                    extras.putParcelable(NotificationCompat.EXTRA_VERIFICATION_ICON_COMPAT, this.mVerificationIcon.toBundle());
                }
            }
            extras.putCharSequence(NotificationCompat.EXTRA_VERIFICATION_TEXT, this.mVerificationText);
            extras.putParcelable(NotificationCompat.EXTRA_ANSWER_INTENT, this.mAnswerIntent);
            extras.putParcelable(NotificationCompat.EXTRA_DECLINE_INTENT, this.mDeclineIntent);
            extras.putParcelable(NotificationCompat.EXTRA_HANG_UP_INTENT, this.mHangUpIntent);
            Integer num = this.mAnswerButtonColor;
            if (num != null) {
                extras.putInt(NotificationCompat.EXTRA_ANSWER_COLOR, num.intValue());
            }
            Integer num2 = this.mDeclineButtonColor;
            if (num2 != null) {
                extras.putInt(NotificationCompat.EXTRA_DECLINE_COLOR, num2.intValue());
            }
        }

        @Override // androidx.core.app.NotificationCompat.Style
        protected String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void apply(NotificationBuilderWithBuilderAccessor builderAccessor) {
            if (Build.VERSION.SDK_INT >= 31) {
                Notification.CallStyle style = null;
                switch (this.mCallType) {
                    case 1:
                        style = Api31Impl.forIncomingCall(this.mPerson.toAndroidPerson(), this.mDeclineIntent, this.mAnswerIntent);
                        break;
                    case 2:
                        style = Api31Impl.forOngoingCall(this.mPerson.toAndroidPerson(), this.mHangUpIntent);
                        break;
                    case 3:
                        style = Api31Impl.forScreeningCall(this.mPerson.toAndroidPerson(), this.mHangUpIntent, this.mAnswerIntent);
                        break;
                    default:
                        if (Log.isLoggable(NotificationCompat.TAG, 3)) {
                            Log.d(NotificationCompat.TAG, "Unrecognized call type in CallStyle: " + String.valueOf(this.mCallType));
                            break;
                        }
                        break;
                }
                if (style != null) {
                    style.setBuilder(builderAccessor.getBuilder());
                    Integer num = this.mAnswerButtonColor;
                    if (num != null) {
                        Api31Impl.setAnswerButtonColorHint(style, num.intValue());
                    }
                    Integer num2 = this.mDeclineButtonColor;
                    if (num2 != null) {
                        Api31Impl.setDeclineButtonColorHint(style, num2.intValue());
                    }
                    Api31Impl.setVerificationText(style, this.mVerificationText);
                    IconCompat iconCompat = this.mVerificationIcon;
                    if (iconCompat != null) {
                        Api31Impl.setVerificationIcon(style, iconCompat.toIcon(this.mBuilder.mContext));
                    }
                    Api31Impl.setIsVideo(style, this.mIsVideo);
                    return;
                }
                return;
            }
            Notification.Builder builder = builderAccessor.getBuilder();
            Person person = this.mPerson;
            CharSequence text = null;
            CharSequence title = person != null ? person.getName() : null;
            builder.setContentTitle(title);
            if (this.mBuilder.mExtras != null && this.mBuilder.mExtras.containsKey(NotificationCompat.EXTRA_TEXT)) {
                text = this.mBuilder.mExtras.getCharSequence(NotificationCompat.EXTRA_TEXT);
            }
            if (text == null) {
                text = getDefaultText();
            }
            builder.setContentText(text);
            if (this.mPerson != null) {
                if (Build.VERSION.SDK_INT >= 23 && this.mPerson.getIcon() != null) {
                    Api23Impl.setLargeIcon(builder, this.mPerson.getIcon().toIcon(this.mBuilder.mContext));
                }
                if (Build.VERSION.SDK_INT >= 28) {
                    Api28Impl.addPerson(builder, this.mPerson.toAndroidPerson());
                } else if (Build.VERSION.SDK_INT >= 21) {
                    Api21Impl.addPerson(builder, this.mPerson.getUri());
                }
            }
            if (Build.VERSION.SDK_INT >= 21) {
                Api21Impl.setCategory(builder, NotificationCompat.CATEGORY_CALL);
            }
        }

        private String getDefaultText() {
            switch (this.mCallType) {
                case 1:
                    return this.mBuilder.mContext.getResources().getString(R.string.call_notification_incoming_text);
                case 2:
                    return this.mBuilder.mContext.getResources().getString(R.string.call_notification_ongoing_text);
                case 3:
                    return this.mBuilder.mContext.getResources().getString(R.string.call_notification_screening_text);
                default:
                    return null;
            }
        }

        private Action makeNegativeAction() {
            int icon = R.drawable.ic_call_decline_low;
            if (Build.VERSION.SDK_INT >= 21) {
                icon = R.drawable.ic_call_decline;
            }
            if (this.mDeclineIntent == null) {
                return makeAction(icon, R.string.call_notification_hang_up_action, this.mDeclineButtonColor, R.color.call_notification_decline_color, this.mHangUpIntent);
            }
            return makeAction(icon, R.string.call_notification_decline_action, this.mDeclineButtonColor, R.color.call_notification_decline_color, this.mDeclineIntent);
        }

        private Action makeAnswerAction() {
            int videoIcon = R.drawable.ic_call_answer_video_low;
            int icon = R.drawable.ic_call_answer_low;
            if (Build.VERSION.SDK_INT >= 21) {
                videoIcon = R.drawable.ic_call_answer_video;
                icon = R.drawable.ic_call_answer;
            }
            if (this.mAnswerIntent == null) {
                return null;
            }
            boolean z = this.mIsVideo;
            return makeAction(z ? videoIcon : icon, z ? R.string.call_notification_answer_video_action : R.string.call_notification_answer_action, this.mAnswerButtonColor, R.color.call_notification_answer_color, this.mAnswerIntent);
        }

        private Action makeAction(int icon, int title, Integer colorInt, int defaultColorRes, PendingIntent intent) {
            if (colorInt == null) {
                colorInt = Integer.valueOf(ContextCompat.getColor(this.mBuilder.mContext, defaultColorRes));
            }
            SpannableStringBuilder stringBuilder = new SpannableStringBuilder();
            stringBuilder.append((CharSequence) this.mBuilder.mContext.getResources().getString(title));
            stringBuilder.setSpan(new ForegroundColorSpan(colorInt.intValue()), 0, stringBuilder.length(), 18);
            Action action = new Action.Builder(IconCompat.createWithResource(this.mBuilder.mContext, icon), stringBuilder, intent).build();
            action.getExtras().putBoolean(KEY_ACTION_PRIORITY, true);
            return action;
        }

        private boolean isActionAddedByCallStyle(Action action) {
            return action != null && action.getExtras().getBoolean(KEY_ACTION_PRIORITY);
        }

        public ArrayList<Action> getActionsListWithSystemActions() {
            Action firstAction = makeNegativeAction();
            Action lastAction = makeAnswerAction();
            int nonContextualActionSlotsRemaining = 3;
            ArrayList<Action> resultActions = new ArrayList<>(3);
            if (3 > 0) {
                resultActions.add(firstAction);
                nonContextualActionSlotsRemaining = 3 - 1;
            }
            List<Action> existingActions = this.mBuilder.mActions;
            if (existingActions != null) {
                for (Action action : existingActions) {
                    if (action.isContextual()) {
                        resultActions.add(action);
                    } else if (!isActionAddedByCallStyle(action) && nonContextualActionSlotsRemaining > 1) {
                        resultActions.add(action);
                        nonContextualActionSlotsRemaining--;
                    }
                    if (lastAction != null && nonContextualActionSlotsRemaining == 1) {
                        resultActions.add(lastAction);
                        nonContextualActionSlotsRemaining--;
                    }
                }
            }
            if (lastAction != null && nonContextualActionSlotsRemaining >= 1) {
                resultActions.add(lastAction);
            }
            return resultActions;
        }

        /* loaded from: classes.dex */
        static class Api20Impl {
            private Api20Impl() {
            }

            static Notification.Action build(Notification.Action.Builder builder) {
                return builder.build();
            }

            static Notification.Action.Builder createActionBuilder(int icon, CharSequence title, PendingIntent intent) {
                return new Notification.Action.Builder(icon, title, intent);
            }

            static Notification.Action.Builder addExtras(Notification.Action.Builder builder, Bundle extras) {
                return builder.addExtras(extras);
            }

            static Notification.Action.Builder addRemoteInput(Notification.Action.Builder builder, android.app.RemoteInput remoteInput) {
                return builder.addRemoteInput(remoteInput);
            }
        }

        /* loaded from: classes.dex */
        static class Api21Impl {
            private Api21Impl() {
            }

            static Notification.Builder addPerson(Notification.Builder builder, String uri) {
                return builder.addPerson(uri);
            }

            static Notification.Builder setCategory(Notification.Builder builder, String category) {
                return builder.setCategory(category);
            }
        }

        /* loaded from: classes.dex */
        static class Api23Impl {
            private Api23Impl() {
            }

            static void setLargeIcon(Notification.Builder builder, Icon icon) {
                builder.setLargeIcon(icon);
            }

            static Notification.Action.Builder createActionBuilder(Icon icon, CharSequence title, PendingIntent intent) {
                return new Notification.Action.Builder(icon, title, intent);
            }

            static Parcelable castToParcelable(Icon icon) {
                return icon;
            }
        }

        /* loaded from: classes.dex */
        static class Api24Impl {
            private Api24Impl() {
            }

            static Notification.Action.Builder setAllowGeneratedReplies(Notification.Action.Builder builder, boolean allowGeneratedReplies) {
                return builder.setAllowGeneratedReplies(allowGeneratedReplies);
            }
        }

        /* loaded from: classes.dex */
        static class Api28Impl {
            private Api28Impl() {
            }

            static Notification.Builder addPerson(Notification.Builder builder, android.app.Person person) {
                return builder.addPerson(person);
            }

            static Parcelable castToParcelable(android.app.Person person) {
                return person;
            }
        }

        /* loaded from: classes.dex */
        static class Api31Impl {
            private Api31Impl() {
            }

            static Notification.CallStyle forIncomingCall(android.app.Person person, PendingIntent declineIntent, PendingIntent answerIntent) {
                return Notification.CallStyle.forIncomingCall(person, declineIntent, answerIntent);
            }

            static Notification.CallStyle forOngoingCall(android.app.Person person, PendingIntent hangUpIntent) {
                return Notification.CallStyle.forOngoingCall(person, hangUpIntent);
            }

            static Notification.CallStyle forScreeningCall(android.app.Person person, PendingIntent hangUpIntent, PendingIntent answerIntent) {
                return Notification.CallStyle.forScreeningCall(person, hangUpIntent, answerIntent);
            }

            static Notification.CallStyle setIsVideo(Notification.CallStyle callStyle, boolean isVideo) {
                return callStyle.setIsVideo(isVideo);
            }

            static Notification.CallStyle setVerificationIcon(Notification.CallStyle callStyle, Icon verificationIcon) {
                return callStyle.setVerificationIcon(verificationIcon);
            }

            static Notification.CallStyle setVerificationText(Notification.CallStyle callStyle, CharSequence verificationText) {
                return callStyle.setVerificationText(verificationText);
            }

            static Notification.CallStyle setAnswerButtonColorHint(Notification.CallStyle callStyle, int color) {
                return callStyle.setAnswerButtonColorHint(color);
            }

            static Notification.CallStyle setDeclineButtonColorHint(Notification.CallStyle callStyle, int color) {
                return callStyle.setDeclineButtonColorHint(color);
            }

            static Notification.Action.Builder setAuthenticationRequired(Notification.Action.Builder actionBuilder, boolean authenticationRequired) {
                return actionBuilder.setAuthenticationRequired(authenticationRequired);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class InboxStyle extends Style {
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$InboxStyle";
        private ArrayList<CharSequence> mTexts = new ArrayList<>();

        public InboxStyle() {
        }

        public InboxStyle(Builder builder) {
            setBuilder(builder);
        }

        public InboxStyle setBigContentTitle(CharSequence title) {
            this.mBigContentTitle = Builder.limitCharSequenceLength(title);
            return this;
        }

        public InboxStyle setSummaryText(CharSequence cs) {
            this.mSummaryText = Builder.limitCharSequenceLength(cs);
            this.mSummaryTextSet = true;
            return this;
        }

        public InboxStyle addLine(CharSequence cs) {
            if (cs != null) {
                this.mTexts.add(Builder.limitCharSequenceLength(cs));
            }
            return this;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        protected String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void apply(NotificationBuilderWithBuilderAccessor builder) {
            Notification.Builder builder1 = builder.getBuilder();
            Notification.InboxStyle style = new Notification.InboxStyle(builder1).setBigContentTitle(this.mBigContentTitle);
            if (this.mSummaryTextSet) {
                style.setSummaryText(this.mSummaryText);
            }
            Iterator<CharSequence> it = this.mTexts.iterator();
            while (it.hasNext()) {
                CharSequence text = it.next();
                style.addLine(text);
            }
        }

        @Override // androidx.core.app.NotificationCompat.Style
        protected void restoreFromCompatExtras(Bundle extras) {
            super.restoreFromCompatExtras(extras);
            this.mTexts.clear();
            if (extras.containsKey(NotificationCompat.EXTRA_TEXT_LINES)) {
                Collections.addAll(this.mTexts, extras.getCharSequenceArray(NotificationCompat.EXTRA_TEXT_LINES));
            }
        }

        @Override // androidx.core.app.NotificationCompat.Style
        protected void clearCompatExtraKeys(Bundle extras) {
            super.clearCompatExtraKeys(extras);
            extras.remove(NotificationCompat.EXTRA_TEXT_LINES);
        }
    }

    /* loaded from: classes.dex */
    public static class DecoratedCustomViewStyle extends Style {
        private static final int MAX_ACTION_BUTTONS = 3;
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle";

        @Override // androidx.core.app.NotificationCompat.Style
        protected String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public boolean displayCustomViewInline() {
            return true;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void apply(NotificationBuilderWithBuilderAccessor builder) {
            if (Build.VERSION.SDK_INT >= 24) {
                Notification.Builder builder1 = builder.getBuilder();
                builder1.setStyle(Api24Impl.createDecoratedCustomViewStyle());
            }
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor builder) {
            if (Build.VERSION.SDK_INT < 24 && this.mBuilder.getContentView() != null) {
                return createRemoteViews(this.mBuilder.getContentView(), false);
            }
            return null;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor builder) {
            RemoteViews innerView;
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews bigContentView = this.mBuilder.getBigContentView();
            if (bigContentView != null) {
                innerView = bigContentView;
            } else {
                innerView = this.mBuilder.getContentView();
            }
            if (innerView == null) {
                return null;
            }
            return createRemoteViews(innerView, true);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor builder) {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews headsUp = this.mBuilder.getHeadsUpContentView();
            RemoteViews innerView = headsUp != null ? headsUp : this.mBuilder.getContentView();
            if (headsUp == null) {
                return null;
            }
            return createRemoteViews(innerView, true);
        }

        private RemoteViews createRemoteViews(RemoteViews innerView, boolean showActions) {
            int numActions;
            RemoteViews remoteViews = applyStandardTemplate(true, R.layout.notification_template_custom_big, false);
            remoteViews.removeAllViews(R.id.actions);
            boolean actionsVisible = false;
            List<Action> nonContextualActions = getNonContextualActions(this.mBuilder.mActions);
            if (showActions && nonContextualActions != null && (numActions = Math.min(nonContextualActions.size(), 3)) > 0) {
                actionsVisible = true;
                for (int i = 0; i < numActions; i++) {
                    RemoteViews button = generateActionButton(nonContextualActions.get(i));
                    remoteViews.addView(R.id.actions, button);
                }
            }
            int actionVisibility = actionsVisible ? 0 : 8;
            remoteViews.setViewVisibility(R.id.actions, actionVisibility);
            remoteViews.setViewVisibility(R.id.action_divider, actionVisibility);
            buildIntoRemoteViews(remoteViews, innerView);
            return remoteViews;
        }

        private static List<Action> getNonContextualActions(List<Action> actions) {
            if (actions == null) {
                return null;
            }
            List<Action> nonContextualActions = new ArrayList<>();
            for (Action action : actions) {
                if (!action.isContextual()) {
                    nonContextualActions.add(action);
                }
            }
            return nonContextualActions;
        }

        private RemoteViews generateActionButton(Action action) {
            boolean tombstone = action.actionIntent == null;
            RemoteViews button = new RemoteViews(this.mBuilder.mContext.getPackageName(), tombstone ? R.layout.notification_action_tombstone : R.layout.notification_action);
            IconCompat icon = action.getIconCompat();
            if (icon != null) {
                button.setImageViewBitmap(R.id.action_image, createColoredBitmap(icon, R.color.notification_action_color_filter));
            }
            button.setTextViewText(R.id.action_text, action.title);
            if (!tombstone) {
                button.setOnClickPendingIntent(R.id.action_container, action.actionIntent);
            }
            button.setContentDescription(R.id.action_container, action.title);
            return button;
        }

        /* loaded from: classes.dex */
        static class Api24Impl {
            private Api24Impl() {
            }

            static Notification.Style createDecoratedCustomViewStyle() {
                return new Notification.DecoratedCustomViewStyle();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class Action {
        static final String EXTRA_SEMANTIC_ACTION = "android.support.action.semanticAction";
        static final String EXTRA_SHOWS_USER_INTERFACE = "android.support.action.showsUserInterface";
        public static final int SEMANTIC_ACTION_ARCHIVE = 5;
        public static final int SEMANTIC_ACTION_CALL = 10;
        public static final int SEMANTIC_ACTION_DELETE = 4;
        public static final int SEMANTIC_ACTION_MARK_AS_READ = 2;
        public static final int SEMANTIC_ACTION_MARK_AS_UNREAD = 3;
        public static final int SEMANTIC_ACTION_MUTE = 6;
        public static final int SEMANTIC_ACTION_NONE = 0;
        public static final int SEMANTIC_ACTION_REPLY = 1;
        public static final int SEMANTIC_ACTION_THUMBS_DOWN = 9;
        public static final int SEMANTIC_ACTION_THUMBS_UP = 8;
        public static final int SEMANTIC_ACTION_UNMUTE = 7;
        public PendingIntent actionIntent;
        @Deprecated
        public int icon;
        private boolean mAllowGeneratedReplies;
        private boolean mAuthenticationRequired;
        private final RemoteInput[] mDataOnlyRemoteInputs;
        final Bundle mExtras;
        private IconCompat mIcon;
        private final boolean mIsContextual;
        private final RemoteInput[] mRemoteInputs;
        private final int mSemanticAction;
        boolean mShowsUserInterface;
        public CharSequence title;

        /* loaded from: classes.dex */
        public interface Extender {
            Builder extend(Builder builder);
        }

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes.dex */
        public @interface SemanticAction {
        }

        public Action(int icon, CharSequence title, PendingIntent intent) {
            this(icon != 0 ? IconCompat.createWithResource(null, "", icon) : null, title, intent);
        }

        public Action(IconCompat icon, CharSequence title, PendingIntent intent) {
            this(icon, title, intent, new Bundle(), (RemoteInput[]) null, (RemoteInput[]) null, true, 0, true, false, false);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Action(int icon, CharSequence title, PendingIntent intent, Bundle extras, RemoteInput[] remoteInputs, RemoteInput[] dataOnlyRemoteInputs, boolean allowGeneratedReplies, int semanticAction, boolean showsUserInterface, boolean isContextual, boolean requireAuth) {
            this(icon != 0 ? IconCompat.createWithResource(null, "", icon) : null, title, intent, extras, remoteInputs, dataOnlyRemoteInputs, allowGeneratedReplies, semanticAction, showsUserInterface, isContextual, requireAuth);
        }

        Action(IconCompat icon, CharSequence title, PendingIntent intent, Bundle extras, RemoteInput[] remoteInputs, RemoteInput[] dataOnlyRemoteInputs, boolean allowGeneratedReplies, int semanticAction, boolean showsUserInterface, boolean isContextual, boolean requireAuth) {
            this.mShowsUserInterface = true;
            this.mIcon = icon;
            if (icon != null && icon.getType() == 2) {
                this.icon = icon.getResId();
            }
            this.title = Builder.limitCharSequenceLength(title);
            this.actionIntent = intent;
            this.mExtras = extras != null ? extras : new Bundle();
            this.mRemoteInputs = remoteInputs;
            this.mDataOnlyRemoteInputs = dataOnlyRemoteInputs;
            this.mAllowGeneratedReplies = allowGeneratedReplies;
            this.mSemanticAction = semanticAction;
            this.mShowsUserInterface = showsUserInterface;
            this.mIsContextual = isContextual;
            this.mAuthenticationRequired = requireAuth;
        }

        @Deprecated
        public int getIcon() {
            return this.icon;
        }

        public IconCompat getIconCompat() {
            int i;
            if (this.mIcon == null && (i = this.icon) != 0) {
                this.mIcon = IconCompat.createWithResource(null, "", i);
            }
            return this.mIcon;
        }

        public CharSequence getTitle() {
            return this.title;
        }

        public PendingIntent getActionIntent() {
            return this.actionIntent;
        }

        public Bundle getExtras() {
            return this.mExtras;
        }

        public boolean getAllowGeneratedReplies() {
            return this.mAllowGeneratedReplies;
        }

        public boolean isAuthenticationRequired() {
            return this.mAuthenticationRequired;
        }

        public RemoteInput[] getRemoteInputs() {
            return this.mRemoteInputs;
        }

        public int getSemanticAction() {
            return this.mSemanticAction;
        }

        public boolean isContextual() {
            return this.mIsContextual;
        }

        public RemoteInput[] getDataOnlyRemoteInputs() {
            return this.mDataOnlyRemoteInputs;
        }

        public boolean getShowsUserInterface() {
            return this.mShowsUserInterface;
        }

        /* loaded from: classes.dex */
        public static final class Builder {
            private boolean mAllowGeneratedReplies;
            private boolean mAuthenticationRequired;
            private final Bundle mExtras;
            private final IconCompat mIcon;
            private final PendingIntent mIntent;
            private boolean mIsContextual;
            private ArrayList<RemoteInput> mRemoteInputs;
            private int mSemanticAction;
            private boolean mShowsUserInterface;
            private final CharSequence mTitle;

            public static Builder fromAndroidAction(Notification.Action action) {
                Builder builder;
                android.app.RemoteInput[] remoteInputs;
                if (Build.VERSION.SDK_INT >= 23 && Api23Impl.getIcon(action) != null) {
                    IconCompat iconCompat = IconCompat.createFromIconOrNullIfZeroResId(Api23Impl.getIcon(action));
                    builder = new Builder(iconCompat, action.title, action.actionIntent);
                } else {
                    builder = new Builder(action.icon, action.title, action.actionIntent);
                }
                if (Build.VERSION.SDK_INT >= 20 && (remoteInputs = Api20Impl.getRemoteInputs(action)) != null && remoteInputs.length != 0) {
                    for (android.app.RemoteInput remoteInput : remoteInputs) {
                        builder.addRemoteInput(RemoteInput.fromPlatform(remoteInput));
                    }
                }
                if (Build.VERSION.SDK_INT >= 24) {
                    builder.mAllowGeneratedReplies = Api24Impl.getAllowGeneratedReplies(action);
                }
                if (Build.VERSION.SDK_INT >= 28) {
                    builder.setSemanticAction(Api28Impl.getSemanticAction(action));
                }
                if (Build.VERSION.SDK_INT >= 29) {
                    builder.setContextual(Api29Impl.isContextual(action));
                }
                if (Build.VERSION.SDK_INT >= 31) {
                    builder.setAuthenticationRequired(Api31Impl.isAuthenticationRequired(action));
                }
                if (Build.VERSION.SDK_INT >= 20) {
                    builder.addExtras(Api20Impl.getExtras(action));
                }
                return builder;
            }

            public Builder(IconCompat icon, CharSequence title, PendingIntent intent) {
                this(icon, title, intent, new Bundle(), null, true, 0, true, false, false);
            }

            public Builder(int icon, CharSequence title, PendingIntent intent) {
                this(icon != 0 ? IconCompat.createWithResource(null, "", icon) : null, title, intent, new Bundle(), null, true, 0, true, false, false);
            }

            public Builder(Action action) {
                this(action.getIconCompat(), action.title, action.actionIntent, new Bundle(action.mExtras), action.getRemoteInputs(), action.getAllowGeneratedReplies(), action.getSemanticAction(), action.mShowsUserInterface, action.isContextual(), action.isAuthenticationRequired());
            }

            private Builder(IconCompat icon, CharSequence title, PendingIntent intent, Bundle extras, RemoteInput[] remoteInputs, boolean allowGeneratedReplies, int semanticAction, boolean showsUserInterface, boolean isContextual, boolean authRequired) {
                this.mAllowGeneratedReplies = true;
                this.mShowsUserInterface = true;
                this.mIcon = icon;
                this.mTitle = Builder.limitCharSequenceLength(title);
                this.mIntent = intent;
                this.mExtras = extras;
                this.mRemoteInputs = remoteInputs == null ? null : new ArrayList<>(Arrays.asList(remoteInputs));
                this.mAllowGeneratedReplies = allowGeneratedReplies;
                this.mSemanticAction = semanticAction;
                this.mShowsUserInterface = showsUserInterface;
                this.mIsContextual = isContextual;
                this.mAuthenticationRequired = authRequired;
            }

            public Builder addExtras(Bundle extras) {
                if (extras != null) {
                    this.mExtras.putAll(extras);
                }
                return this;
            }

            public Bundle getExtras() {
                return this.mExtras;
            }

            public Builder addRemoteInput(RemoteInput remoteInput) {
                if (this.mRemoteInputs == null) {
                    this.mRemoteInputs = new ArrayList<>();
                }
                if (remoteInput != null) {
                    this.mRemoteInputs.add(remoteInput);
                }
                return this;
            }

            public Builder setAllowGeneratedReplies(boolean allowGeneratedReplies) {
                this.mAllowGeneratedReplies = allowGeneratedReplies;
                return this;
            }

            public Builder setSemanticAction(int semanticAction) {
                this.mSemanticAction = semanticAction;
                return this;
            }

            public Builder setContextual(boolean isContextual) {
                this.mIsContextual = isContextual;
                return this;
            }

            public Builder setAuthenticationRequired(boolean authenticationRequired) {
                this.mAuthenticationRequired = authenticationRequired;
                return this;
            }

            public Builder setShowsUserInterface(boolean showsUserInterface) {
                this.mShowsUserInterface = showsUserInterface;
                return this;
            }

            public Builder extend(Extender extender) {
                extender.extend(this);
                return this;
            }

            private void checkContextualActionNullFields() {
                if (this.mIsContextual && this.mIntent == null) {
                    throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
                }
            }

            public Action build() {
                checkContextualActionNullFields();
                List<RemoteInput> dataOnlyInputs = new ArrayList<>();
                List<RemoteInput> textInputs = new ArrayList<>();
                ArrayList<RemoteInput> arrayList = this.mRemoteInputs;
                if (arrayList != null) {
                    Iterator<RemoteInput> it = arrayList.iterator();
                    while (it.hasNext()) {
                        RemoteInput input = it.next();
                        if (input.isDataOnly()) {
                            dataOnlyInputs.add(input);
                        } else {
                            textInputs.add(input);
                        }
                    }
                }
                RemoteInput[] dataOnlyInputsArr = dataOnlyInputs.isEmpty() ? null : (RemoteInput[]) dataOnlyInputs.toArray(new RemoteInput[dataOnlyInputs.size()]);
                RemoteInput[] textInputsArr = textInputs.isEmpty() ? null : (RemoteInput[]) textInputs.toArray(new RemoteInput[textInputs.size()]);
                return new Action(this.mIcon, this.mTitle, this.mIntent, this.mExtras, textInputsArr, dataOnlyInputsArr, this.mAllowGeneratedReplies, this.mSemanticAction, this.mShowsUserInterface, this.mIsContextual, this.mAuthenticationRequired);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* loaded from: classes.dex */
            public static class Api20Impl {
                private Api20Impl() {
                }

                static android.app.RemoteInput[] getRemoteInputs(Notification.Action action) {
                    return action.getRemoteInputs();
                }

                static Bundle getExtras(Notification.Action action) {
                    return action.getExtras();
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* loaded from: classes.dex */
            public static class Api23Impl {
                private Api23Impl() {
                }

                static Icon getIcon(Notification.Action action) {
                    return action.getIcon();
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* loaded from: classes.dex */
            public static class Api24Impl {
                private Api24Impl() {
                }

                static boolean getAllowGeneratedReplies(Notification.Action action) {
                    return action.getAllowGeneratedReplies();
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* loaded from: classes.dex */
            public static class Api28Impl {
                private Api28Impl() {
                }

                static int getSemanticAction(Notification.Action action) {
                    return action.getSemanticAction();
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* loaded from: classes.dex */
            public static class Api29Impl {
                private Api29Impl() {
                }

                static boolean isContextual(Notification.Action action) {
                    return action.isContextual();
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* loaded from: classes.dex */
            public static class Api31Impl {
                private Api31Impl() {
                }

                static boolean isAuthenticationRequired(Notification.Action action) {
                    return action.isAuthenticationRequired();
                }
            }
        }

        /* loaded from: classes.dex */
        public static final class WearableExtender implements Extender {
            private static final int DEFAULT_FLAGS = 1;
            private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
            private static final int FLAG_AVAILABLE_OFFLINE = 1;
            private static final int FLAG_HINT_DISPLAY_INLINE = 4;
            private static final int FLAG_HINT_LAUNCHES_ACTIVITY = 2;
            private static final String KEY_CANCEL_LABEL = "cancelLabel";
            private static final String KEY_CONFIRM_LABEL = "confirmLabel";
            private static final String KEY_FLAGS = "flags";
            private static final String KEY_IN_PROGRESS_LABEL = "inProgressLabel";
            private CharSequence mCancelLabel;
            private CharSequence mConfirmLabel;
            private int mFlags;
            private CharSequence mInProgressLabel;

            public WearableExtender() {
                this.mFlags = 1;
            }

            public WearableExtender(Action action) {
                this.mFlags = 1;
                Bundle wearableBundle = action.getExtras().getBundle(EXTRA_WEARABLE_EXTENSIONS);
                if (wearableBundle != null) {
                    this.mFlags = wearableBundle.getInt(KEY_FLAGS, 1);
                    this.mInProgressLabel = wearableBundle.getCharSequence(KEY_IN_PROGRESS_LABEL);
                    this.mConfirmLabel = wearableBundle.getCharSequence(KEY_CONFIRM_LABEL);
                    this.mCancelLabel = wearableBundle.getCharSequence(KEY_CANCEL_LABEL);
                }
            }

            @Override // androidx.core.app.NotificationCompat.Action.Extender
            public Builder extend(Builder builder) {
                Bundle wearableBundle = new Bundle();
                int i = this.mFlags;
                if (i != 1) {
                    wearableBundle.putInt(KEY_FLAGS, i);
                }
                CharSequence charSequence = this.mInProgressLabel;
                if (charSequence != null) {
                    wearableBundle.putCharSequence(KEY_IN_PROGRESS_LABEL, charSequence);
                }
                CharSequence charSequence2 = this.mConfirmLabel;
                if (charSequence2 != null) {
                    wearableBundle.putCharSequence(KEY_CONFIRM_LABEL, charSequence2);
                }
                CharSequence charSequence3 = this.mCancelLabel;
                if (charSequence3 != null) {
                    wearableBundle.putCharSequence(KEY_CANCEL_LABEL, charSequence3);
                }
                builder.getExtras().putBundle(EXTRA_WEARABLE_EXTENSIONS, wearableBundle);
                return builder;
            }

            /* renamed from: clone */
            public WearableExtender m8clone() {
                WearableExtender that = new WearableExtender();
                that.mFlags = this.mFlags;
                that.mInProgressLabel = this.mInProgressLabel;
                that.mConfirmLabel = this.mConfirmLabel;
                that.mCancelLabel = this.mCancelLabel;
                return that;
            }

            public WearableExtender setAvailableOffline(boolean availableOffline) {
                setFlag(1, availableOffline);
                return this;
            }

            public boolean isAvailableOffline() {
                return (this.mFlags & 1) != 0;
            }

            private void setFlag(int mask, boolean value) {
                if (value) {
                    this.mFlags |= mask;
                } else {
                    this.mFlags &= ~mask;
                }
            }

            @Deprecated
            public WearableExtender setInProgressLabel(CharSequence label) {
                this.mInProgressLabel = label;
                return this;
            }

            @Deprecated
            public CharSequence getInProgressLabel() {
                return this.mInProgressLabel;
            }

            @Deprecated
            public WearableExtender setConfirmLabel(CharSequence label) {
                this.mConfirmLabel = label;
                return this;
            }

            @Deprecated
            public CharSequence getConfirmLabel() {
                return this.mConfirmLabel;
            }

            @Deprecated
            public WearableExtender setCancelLabel(CharSequence label) {
                this.mCancelLabel = label;
                return this;
            }

            @Deprecated
            public CharSequence getCancelLabel() {
                return this.mCancelLabel;
            }

            public WearableExtender setHintLaunchesActivity(boolean hintLaunchesActivity) {
                setFlag(2, hintLaunchesActivity);
                return this;
            }

            public boolean getHintLaunchesActivity() {
                return (this.mFlags & 2) != 0;
            }

            public WearableExtender setHintDisplayActionInline(boolean hintDisplayInline) {
                setFlag(4, hintDisplayInline);
                return this;
            }

            public boolean getHintDisplayActionInline() {
                return (this.mFlags & 4) != 0;
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class WearableExtender implements Extender {
        private static final int DEFAULT_CONTENT_ICON_GRAVITY = 8388613;
        private static final int DEFAULT_FLAGS = 1;
        private static final int DEFAULT_GRAVITY = 80;
        private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
        private static final int FLAG_BIG_PICTURE_AMBIENT = 32;
        private static final int FLAG_CONTENT_INTENT_AVAILABLE_OFFLINE = 1;
        private static final int FLAG_HINT_AVOID_BACKGROUND_CLIPPING = 16;
        private static final int FLAG_HINT_CONTENT_INTENT_LAUNCHES_ACTIVITY = 64;
        private static final int FLAG_HINT_HIDE_ICON = 2;
        private static final int FLAG_HINT_SHOW_BACKGROUND_ONLY = 4;
        private static final int FLAG_START_SCROLL_BOTTOM = 8;
        private static final String KEY_ACTIONS = "actions";
        private static final String KEY_BACKGROUND = "background";
        private static final String KEY_BRIDGE_TAG = "bridgeTag";
        private static final String KEY_CONTENT_ACTION_INDEX = "contentActionIndex";
        private static final String KEY_CONTENT_ICON = "contentIcon";
        private static final String KEY_CONTENT_ICON_GRAVITY = "contentIconGravity";
        private static final String KEY_CUSTOM_CONTENT_HEIGHT = "customContentHeight";
        private static final String KEY_CUSTOM_SIZE_PRESET = "customSizePreset";
        private static final String KEY_DISMISSAL_ID = "dismissalId";
        private static final String KEY_DISPLAY_INTENT = "displayIntent";
        private static final String KEY_FLAGS = "flags";
        private static final String KEY_GRAVITY = "gravity";
        private static final String KEY_HINT_SCREEN_TIMEOUT = "hintScreenTimeout";
        private static final String KEY_PAGES = "pages";
        @Deprecated
        public static final int SCREEN_TIMEOUT_LONG = -1;
        @Deprecated
        public static final int SCREEN_TIMEOUT_SHORT = 0;
        @Deprecated
        public static final int SIZE_DEFAULT = 0;
        @Deprecated
        public static final int SIZE_FULL_SCREEN = 5;
        @Deprecated
        public static final int SIZE_LARGE = 4;
        @Deprecated
        public static final int SIZE_MEDIUM = 3;
        @Deprecated
        public static final int SIZE_SMALL = 2;
        @Deprecated
        public static final int SIZE_XSMALL = 1;
        public static final int UNSET_ACTION_INDEX = -1;
        private ArrayList<Action> mActions;
        private Bitmap mBackground;
        private String mBridgeTag;
        private int mContentActionIndex;
        private int mContentIcon;
        private int mContentIconGravity;
        private int mCustomContentHeight;
        private int mCustomSizePreset;
        private String mDismissalId;
        private PendingIntent mDisplayIntent;
        private int mFlags;
        private int mGravity;
        private int mHintScreenTimeout;
        private ArrayList<Notification> mPages;

        public WearableExtender() {
            this.mActions = new ArrayList<>();
            this.mFlags = 1;
            this.mPages = new ArrayList<>();
            this.mContentIconGravity = 8388613;
            this.mContentActionIndex = -1;
            this.mCustomSizePreset = 0;
            this.mGravity = DEFAULT_GRAVITY;
        }

        public WearableExtender(Notification notification) {
            this.mActions = new ArrayList<>();
            this.mFlags = 1;
            this.mPages = new ArrayList<>();
            this.mContentIconGravity = 8388613;
            this.mContentActionIndex = -1;
            this.mCustomSizePreset = 0;
            this.mGravity = DEFAULT_GRAVITY;
            Bundle extras = NotificationCompat.getExtras(notification);
            Bundle wearableBundle = extras != null ? extras.getBundle(EXTRA_WEARABLE_EXTENSIONS) : null;
            if (wearableBundle != null) {
                ArrayList<Parcelable> parcelables = wearableBundle.getParcelableArrayList(KEY_ACTIONS);
                if (parcelables != null) {
                    Action[] actions = new Action[parcelables.size()];
                    for (int i = 0; i < actions.length; i++) {
                        if (Build.VERSION.SDK_INT >= 20) {
                            actions[i] = Api20Impl.getActionCompatFromAction(parcelables, i);
                        } else {
                            actions[i] = NotificationCompatJellybean.getActionFromBundle((Bundle) parcelables.get(i));
                        }
                    }
                    Collections.addAll(this.mActions, actions);
                }
                this.mFlags = wearableBundle.getInt(KEY_FLAGS, 1);
                this.mDisplayIntent = (PendingIntent) wearableBundle.getParcelable(KEY_DISPLAY_INTENT);
                Notification[] pages = NotificationCompat.getNotificationArrayFromBundle(wearableBundle, KEY_PAGES);
                if (pages != null) {
                    Collections.addAll(this.mPages, pages);
                }
                this.mBackground = (Bitmap) wearableBundle.getParcelable(KEY_BACKGROUND);
                this.mContentIcon = wearableBundle.getInt(KEY_CONTENT_ICON);
                this.mContentIconGravity = wearableBundle.getInt(KEY_CONTENT_ICON_GRAVITY, 8388613);
                this.mContentActionIndex = wearableBundle.getInt(KEY_CONTENT_ACTION_INDEX, -1);
                this.mCustomSizePreset = wearableBundle.getInt(KEY_CUSTOM_SIZE_PRESET, 0);
                this.mCustomContentHeight = wearableBundle.getInt(KEY_CUSTOM_CONTENT_HEIGHT);
                this.mGravity = wearableBundle.getInt(KEY_GRAVITY, DEFAULT_GRAVITY);
                this.mHintScreenTimeout = wearableBundle.getInt(KEY_HINT_SCREEN_TIMEOUT);
                this.mDismissalId = wearableBundle.getString(KEY_DISMISSAL_ID);
                this.mBridgeTag = wearableBundle.getString(KEY_BRIDGE_TAG);
            }
        }

        @Override // androidx.core.app.NotificationCompat.Extender
        public Builder extend(Builder builder) {
            Bundle wearableBundle = new Bundle();
            if (!this.mActions.isEmpty()) {
                ArrayList<Parcelable> parcelables = new ArrayList<>(this.mActions.size());
                Iterator<Action> it = this.mActions.iterator();
                while (it.hasNext()) {
                    Action action = it.next();
                    if (Build.VERSION.SDK_INT >= 20) {
                        parcelables.add(getActionFromActionCompat(action));
                    } else {
                        parcelables.add(NotificationCompatJellybean.getBundleForAction(action));
                    }
                }
                wearableBundle.putParcelableArrayList(KEY_ACTIONS, parcelables);
            }
            int i = this.mFlags;
            if (i != 1) {
                wearableBundle.putInt(KEY_FLAGS, i);
            }
            PendingIntent pendingIntent = this.mDisplayIntent;
            if (pendingIntent != null) {
                wearableBundle.putParcelable(KEY_DISPLAY_INTENT, pendingIntent);
            }
            if (!this.mPages.isEmpty()) {
                ArrayList<Notification> arrayList = this.mPages;
                wearableBundle.putParcelableArray(KEY_PAGES, (Parcelable[]) arrayList.toArray(new Notification[arrayList.size()]));
            }
            Bitmap bitmap = this.mBackground;
            if (bitmap != null) {
                wearableBundle.putParcelable(KEY_BACKGROUND, bitmap);
            }
            int i2 = this.mContentIcon;
            if (i2 != 0) {
                wearableBundle.putInt(KEY_CONTENT_ICON, i2);
            }
            int i3 = this.mContentIconGravity;
            if (i3 != 8388613) {
                wearableBundle.putInt(KEY_CONTENT_ICON_GRAVITY, i3);
            }
            int i4 = this.mContentActionIndex;
            if (i4 != -1) {
                wearableBundle.putInt(KEY_CONTENT_ACTION_INDEX, i4);
            }
            int i5 = this.mCustomSizePreset;
            if (i5 != 0) {
                wearableBundle.putInt(KEY_CUSTOM_SIZE_PRESET, i5);
            }
            int i6 = this.mCustomContentHeight;
            if (i6 != 0) {
                wearableBundle.putInt(KEY_CUSTOM_CONTENT_HEIGHT, i6);
            }
            int i7 = this.mGravity;
            if (i7 != DEFAULT_GRAVITY) {
                wearableBundle.putInt(KEY_GRAVITY, i7);
            }
            int i8 = this.mHintScreenTimeout;
            if (i8 != 0) {
                wearableBundle.putInt(KEY_HINT_SCREEN_TIMEOUT, i8);
            }
            String str = this.mDismissalId;
            if (str != null) {
                wearableBundle.putString(KEY_DISMISSAL_ID, str);
            }
            String str2 = this.mBridgeTag;
            if (str2 != null) {
                wearableBundle.putString(KEY_BRIDGE_TAG, str2);
            }
            builder.getExtras().putBundle(EXTRA_WEARABLE_EXTENSIONS, wearableBundle);
            return builder;
        }

        private static Notification.Action getActionFromActionCompat(Action actionCompat) {
            Notification.Action.Builder actionBuilder;
            Bundle actionExtras;
            if (Build.VERSION.SDK_INT >= 23) {
                IconCompat iconCompat = actionCompat.getIconCompat();
                actionBuilder = Api23Impl.createBuilder(iconCompat == null ? null : iconCompat.toIcon(), actionCompat.getTitle(), actionCompat.getActionIntent());
            } else {
                IconCompat icon = actionCompat.getIconCompat();
                int iconResId = 0;
                if (icon != null && icon.getType() == 2) {
                    iconResId = icon.getResId();
                }
                actionBuilder = Api20Impl.createBuilder(iconResId, actionCompat.getTitle(), actionCompat.getActionIntent());
            }
            if (actionCompat.getExtras() != null) {
                actionExtras = new Bundle(actionCompat.getExtras());
            } else {
                actionExtras = new Bundle();
            }
            actionExtras.putBoolean("android.support.allowGeneratedReplies", actionCompat.getAllowGeneratedReplies());
            if (Build.VERSION.SDK_INT >= 24) {
                Api24Impl.setAllowGeneratedReplies(actionBuilder, actionCompat.getAllowGeneratedReplies());
            }
            if (Build.VERSION.SDK_INT >= 31) {
                Api31Impl.setAuthenticationRequired(actionBuilder, actionCompat.isAuthenticationRequired());
            }
            Api20Impl.addExtras(actionBuilder, actionExtras);
            RemoteInput[] remoteInputCompats = actionCompat.getRemoteInputs();
            if (remoteInputCompats != null) {
                android.app.RemoteInput[] remoteInputs = RemoteInput.fromCompat(remoteInputCompats);
                for (android.app.RemoteInput remoteInput : remoteInputs) {
                    Api20Impl.addRemoteInput(actionBuilder, remoteInput);
                }
            }
            return Api20Impl.build(actionBuilder);
        }

        /* renamed from: clone */
        public WearableExtender m9clone() {
            WearableExtender that = new WearableExtender();
            that.mActions = new ArrayList<>(this.mActions);
            that.mFlags = this.mFlags;
            that.mDisplayIntent = this.mDisplayIntent;
            that.mPages = new ArrayList<>(this.mPages);
            that.mBackground = this.mBackground;
            that.mContentIcon = this.mContentIcon;
            that.mContentIconGravity = this.mContentIconGravity;
            that.mContentActionIndex = this.mContentActionIndex;
            that.mCustomSizePreset = this.mCustomSizePreset;
            that.mCustomContentHeight = this.mCustomContentHeight;
            that.mGravity = this.mGravity;
            that.mHintScreenTimeout = this.mHintScreenTimeout;
            that.mDismissalId = this.mDismissalId;
            that.mBridgeTag = this.mBridgeTag;
            return that;
        }

        public WearableExtender addAction(Action action) {
            this.mActions.add(action);
            return this;
        }

        public WearableExtender addActions(List<Action> actions) {
            this.mActions.addAll(actions);
            return this;
        }

        public WearableExtender clearActions() {
            this.mActions.clear();
            return this;
        }

        public List<Action> getActions() {
            return this.mActions;
        }

        @Deprecated
        public WearableExtender setDisplayIntent(PendingIntent intent) {
            this.mDisplayIntent = intent;
            return this;
        }

        @Deprecated
        public PendingIntent getDisplayIntent() {
            return this.mDisplayIntent;
        }

        @Deprecated
        public WearableExtender addPage(Notification page) {
            this.mPages.add(page);
            return this;
        }

        @Deprecated
        public WearableExtender addPages(List<Notification> pages) {
            this.mPages.addAll(pages);
            return this;
        }

        @Deprecated
        public WearableExtender clearPages() {
            this.mPages.clear();
            return this;
        }

        @Deprecated
        public List<Notification> getPages() {
            return this.mPages;
        }

        @Deprecated
        public WearableExtender setBackground(Bitmap background) {
            this.mBackground = background;
            return this;
        }

        @Deprecated
        public Bitmap getBackground() {
            return this.mBackground;
        }

        @Deprecated
        public WearableExtender setContentIcon(int icon) {
            this.mContentIcon = icon;
            return this;
        }

        @Deprecated
        public int getContentIcon() {
            return this.mContentIcon;
        }

        @Deprecated
        public WearableExtender setContentIconGravity(int contentIconGravity) {
            this.mContentIconGravity = contentIconGravity;
            return this;
        }

        @Deprecated
        public int getContentIconGravity() {
            return this.mContentIconGravity;
        }

        public WearableExtender setContentAction(int actionIndex) {
            this.mContentActionIndex = actionIndex;
            return this;
        }

        public int getContentAction() {
            return this.mContentActionIndex;
        }

        @Deprecated
        public WearableExtender setGravity(int gravity) {
            this.mGravity = gravity;
            return this;
        }

        @Deprecated
        public int getGravity() {
            return this.mGravity;
        }

        @Deprecated
        public WearableExtender setCustomSizePreset(int sizePreset) {
            this.mCustomSizePreset = sizePreset;
            return this;
        }

        @Deprecated
        public int getCustomSizePreset() {
            return this.mCustomSizePreset;
        }

        @Deprecated
        public WearableExtender setCustomContentHeight(int height) {
            this.mCustomContentHeight = height;
            return this;
        }

        @Deprecated
        public int getCustomContentHeight() {
            return this.mCustomContentHeight;
        }

        public WearableExtender setStartScrollBottom(boolean startScrollBottom) {
            setFlag(8, startScrollBottom);
            return this;
        }

        public boolean getStartScrollBottom() {
            return (this.mFlags & 8) != 0;
        }

        public WearableExtender setContentIntentAvailableOffline(boolean contentIntentAvailableOffline) {
            setFlag(1, contentIntentAvailableOffline);
            return this;
        }

        public boolean getContentIntentAvailableOffline() {
            return (this.mFlags & 1) != 0;
        }

        @Deprecated
        public WearableExtender setHintHideIcon(boolean hintHideIcon) {
            setFlag(2, hintHideIcon);
            return this;
        }

        @Deprecated
        public boolean getHintHideIcon() {
            return (this.mFlags & 2) != 0;
        }

        @Deprecated
        public WearableExtender setHintShowBackgroundOnly(boolean hintShowBackgroundOnly) {
            setFlag(4, hintShowBackgroundOnly);
            return this;
        }

        @Deprecated
        public boolean getHintShowBackgroundOnly() {
            return (this.mFlags & 4) != 0;
        }

        @Deprecated
        public WearableExtender setHintAvoidBackgroundClipping(boolean hintAvoidBackgroundClipping) {
            setFlag(16, hintAvoidBackgroundClipping);
            return this;
        }

        @Deprecated
        public boolean getHintAvoidBackgroundClipping() {
            return (this.mFlags & 16) != 0;
        }

        @Deprecated
        public WearableExtender setHintScreenTimeout(int timeout) {
            this.mHintScreenTimeout = timeout;
            return this;
        }

        @Deprecated
        public int getHintScreenTimeout() {
            return this.mHintScreenTimeout;
        }

        @Deprecated
        public WearableExtender setHintAmbientBigPicture(boolean hintAmbientBigPicture) {
            setFlag(32, hintAmbientBigPicture);
            return this;
        }

        @Deprecated
        public boolean getHintAmbientBigPicture() {
            return (this.mFlags & 32) != 0;
        }

        public WearableExtender setHintContentIntentLaunchesActivity(boolean hintContentIntentLaunchesActivity) {
            setFlag(64, hintContentIntentLaunchesActivity);
            return this;
        }

        public boolean getHintContentIntentLaunchesActivity() {
            return (this.mFlags & 64) != 0;
        }

        public WearableExtender setDismissalId(String dismissalId) {
            this.mDismissalId = dismissalId;
            return this;
        }

        public String getDismissalId() {
            return this.mDismissalId;
        }

        public WearableExtender setBridgeTag(String bridgeTag) {
            this.mBridgeTag = bridgeTag;
            return this;
        }

        public String getBridgeTag() {
            return this.mBridgeTag;
        }

        private void setFlag(int mask, boolean value) {
            if (value) {
                this.mFlags |= mask;
            } else {
                this.mFlags &= ~mask;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static class Api20Impl {
            private Api20Impl() {
            }

            static Notification.Action.Builder createBuilder(int icon, CharSequence title, PendingIntent intent) {
                return new Notification.Action.Builder(icon, title, intent);
            }

            static Notification.Action.Builder addExtras(Notification.Action.Builder builder, Bundle extras) {
                return builder.addExtras(extras);
            }

            static Notification.Action.Builder addRemoteInput(Notification.Action.Builder builder, android.app.RemoteInput remoteInput) {
                return builder.addRemoteInput(remoteInput);
            }

            static Notification.Action build(Notification.Action.Builder builder) {
                return builder.build();
            }

            public static Action getActionCompatFromAction(ArrayList<Parcelable> parcelables, int i) {
                return NotificationCompat.getActionCompatFromAction((Notification.Action) parcelables.get(i));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static class Api23Impl {
            private Api23Impl() {
            }

            static Notification.Action.Builder createBuilder(Icon icon, CharSequence title, PendingIntent intent) {
                return new Notification.Action.Builder(icon, title, intent);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static class Api24Impl {
            private Api24Impl() {
            }

            static Notification.Action.Builder setAllowGeneratedReplies(Notification.Action.Builder builder, boolean allowGeneratedReplies) {
                return builder.setAllowGeneratedReplies(allowGeneratedReplies);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static class Api31Impl {
            private Api31Impl() {
            }

            static Notification.Action.Builder setAuthenticationRequired(Notification.Action.Builder builder, boolean authenticationRequired) {
                return builder.setAuthenticationRequired(authenticationRequired);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class CarExtender implements Extender {
        static final String EXTRA_CAR_EXTENDER = "android.car.EXTENSIONS";
        private static final String EXTRA_COLOR = "app_color";
        private static final String EXTRA_CONVERSATION = "car_conversation";
        static final String EXTRA_INVISIBLE_ACTIONS = "invisible_actions";
        private static final String EXTRA_LARGE_ICON = "large_icon";
        private static final String KEY_AUTHOR = "author";
        private static final String KEY_MESSAGES = "messages";
        private static final String KEY_ON_READ = "on_read";
        private static final String KEY_ON_REPLY = "on_reply";
        private static final String KEY_PARTICIPANTS = "participants";
        private static final String KEY_REMOTE_INPUT = "remote_input";
        private static final String KEY_TEXT = "text";
        private static final String KEY_TIMESTAMP = "timestamp";
        private int mColor;
        private Bitmap mLargeIcon;
        private UnreadConversation mUnreadConversation;

        public CarExtender() {
            this.mColor = 0;
        }

        public CarExtender(Notification notification) {
            this.mColor = 0;
            if (Build.VERSION.SDK_INT < 21) {
                return;
            }
            Bundle carBundle = NotificationCompat.getExtras(notification) == null ? null : NotificationCompat.getExtras(notification).getBundle(EXTRA_CAR_EXTENDER);
            if (carBundle != null) {
                this.mLargeIcon = (Bitmap) carBundle.getParcelable(EXTRA_LARGE_ICON);
                this.mColor = carBundle.getInt(EXTRA_COLOR, 0);
                Bundle b = carBundle.getBundle(EXTRA_CONVERSATION);
                this.mUnreadConversation = getUnreadConversationFromBundle(b);
            }
        }

        private static UnreadConversation getUnreadConversationFromBundle(Bundle b) {
            RemoteInput remoteInputCompat;
            if (b == null) {
                return null;
            }
            Parcelable[] parcelableMessages = b.getParcelableArray(KEY_MESSAGES);
            String[] messages = null;
            if (parcelableMessages != null) {
                String[] tmp = new String[parcelableMessages.length];
                boolean success = true;
                int i = 0;
                while (true) {
                    if (i >= tmp.length) {
                        break;
                    } else if (!(parcelableMessages[i] instanceof Bundle)) {
                        success = false;
                        break;
                    } else {
                        tmp[i] = ((Bundle) parcelableMessages[i]).getString(KEY_TEXT);
                        if (tmp[i] != null) {
                            i++;
                        } else {
                            success = false;
                            break;
                        }
                    }
                }
                if (!success) {
                    return null;
                }
                messages = tmp;
            }
            PendingIntent onRead = (PendingIntent) b.getParcelable(KEY_ON_READ);
            PendingIntent onReply = (PendingIntent) b.getParcelable(KEY_ON_REPLY);
            android.app.RemoteInput remoteInput = (android.app.RemoteInput) b.getParcelable(KEY_REMOTE_INPUT);
            String[] participants = b.getStringArray(KEY_PARTICIPANTS);
            if (participants == null || participants.length != 1) {
                return null;
            }
            if (remoteInput != null) {
                remoteInputCompat = new RemoteInput(Api20Impl.getResultKey(remoteInput), Api20Impl.getLabel(remoteInput), Api20Impl.getChoices(remoteInput), Api20Impl.getAllowFreeFormInput(remoteInput), Build.VERSION.SDK_INT >= 29 ? Api29Impl.getEditChoicesBeforeSending(remoteInput) : 0, Api20Impl.getExtras(remoteInput), null);
            } else {
                remoteInputCompat = null;
            }
            return new UnreadConversation(messages, remoteInputCompat, onReply, onRead, participants, b.getLong(KEY_TIMESTAMP));
        }

        private static Bundle getBundleForUnreadConversation(UnreadConversation uc) {
            Bundle b = new Bundle();
            String author = null;
            if (uc.getParticipants() != null && uc.getParticipants().length > 1) {
                author = uc.getParticipants()[0];
            }
            Parcelable[] messages = new Parcelable[uc.getMessages().length];
            for (int i = 0; i < messages.length; i++) {
                Bundle m = new Bundle();
                m.putString(KEY_TEXT, uc.getMessages()[i]);
                m.putString(KEY_AUTHOR, author);
                messages[i] = m;
            }
            b.putParcelableArray(KEY_MESSAGES, messages);
            RemoteInput remoteInputCompat = uc.getRemoteInput();
            if (remoteInputCompat != null) {
                RemoteInput.Builder builder = Api20Impl.createBuilder(remoteInputCompat.getResultKey());
                Api20Impl.setLabel(builder, remoteInputCompat.getLabel());
                Api20Impl.setChoices(builder, remoteInputCompat.getChoices());
                Api20Impl.setAllowFreeFormInput(builder, remoteInputCompat.getAllowFreeFormInput());
                Api20Impl.addExtras(builder, remoteInputCompat.getExtras());
                android.app.RemoteInput remoteInput = Api20Impl.build(builder);
                b.putParcelable(KEY_REMOTE_INPUT, Api20Impl.castToParcelable(remoteInput));
            }
            b.putParcelable(KEY_ON_REPLY, uc.getReplyPendingIntent());
            b.putParcelable(KEY_ON_READ, uc.getReadPendingIntent());
            b.putStringArray(KEY_PARTICIPANTS, uc.getParticipants());
            b.putLong(KEY_TIMESTAMP, uc.getLatestTimestamp());
            return b;
        }

        @Override // androidx.core.app.NotificationCompat.Extender
        public Builder extend(Builder builder) {
            if (Build.VERSION.SDK_INT < 21) {
                return builder;
            }
            Bundle carExtensions = new Bundle();
            Bitmap bitmap = this.mLargeIcon;
            if (bitmap != null) {
                carExtensions.putParcelable(EXTRA_LARGE_ICON, bitmap);
            }
            int i = this.mColor;
            if (i != 0) {
                carExtensions.putInt(EXTRA_COLOR, i);
            }
            UnreadConversation unreadConversation = this.mUnreadConversation;
            if (unreadConversation != null) {
                Bundle b = getBundleForUnreadConversation(unreadConversation);
                carExtensions.putBundle(EXTRA_CONVERSATION, b);
            }
            Bundle b2 = builder.getExtras();
            b2.putBundle(EXTRA_CAR_EXTENDER, carExtensions);
            return builder;
        }

        public CarExtender setColor(int color) {
            this.mColor = color;
            return this;
        }

        public int getColor() {
            return this.mColor;
        }

        public CarExtender setLargeIcon(Bitmap largeIcon) {
            this.mLargeIcon = largeIcon;
            return this;
        }

        public Bitmap getLargeIcon() {
            return this.mLargeIcon;
        }

        @Deprecated
        public CarExtender setUnreadConversation(UnreadConversation unreadConversation) {
            this.mUnreadConversation = unreadConversation;
            return this;
        }

        @Deprecated
        public UnreadConversation getUnreadConversation() {
            return this.mUnreadConversation;
        }

        @Deprecated
        /* loaded from: classes.dex */
        public static class UnreadConversation {
            private final long mLatestTimestamp;
            private final String[] mMessages;
            private final String[] mParticipants;
            private final PendingIntent mReadPendingIntent;
            private final RemoteInput mRemoteInput;
            private final PendingIntent mReplyPendingIntent;

            UnreadConversation(String[] messages, RemoteInput remoteInput, PendingIntent replyPendingIntent, PendingIntent readPendingIntent, String[] participants, long latestTimestamp) {
                this.mMessages = messages;
                this.mRemoteInput = remoteInput;
                this.mReadPendingIntent = readPendingIntent;
                this.mReplyPendingIntent = replyPendingIntent;
                this.mParticipants = participants;
                this.mLatestTimestamp = latestTimestamp;
            }

            public String[] getMessages() {
                return this.mMessages;
            }

            public RemoteInput getRemoteInput() {
                return this.mRemoteInput;
            }

            public PendingIntent getReplyPendingIntent() {
                return this.mReplyPendingIntent;
            }

            public PendingIntent getReadPendingIntent() {
                return this.mReadPendingIntent;
            }

            public String[] getParticipants() {
                return this.mParticipants;
            }

            public String getParticipant() {
                String[] strArr = this.mParticipants;
                if (strArr.length > 0) {
                    return strArr[0];
                }
                return null;
            }

            public long getLatestTimestamp() {
                return this.mLatestTimestamp;
            }

            /* loaded from: classes.dex */
            public static class Builder {
                private long mLatestTimestamp;
                private final List<String> mMessages = new ArrayList();
                private final String mParticipant;
                private PendingIntent mReadPendingIntent;
                private RemoteInput mRemoteInput;
                private PendingIntent mReplyPendingIntent;

                public Builder(String name) {
                    this.mParticipant = name;
                }

                public Builder addMessage(String message) {
                    if (message != null) {
                        this.mMessages.add(message);
                    }
                    return this;
                }

                public Builder setReplyAction(PendingIntent pendingIntent, RemoteInput remoteInput) {
                    this.mRemoteInput = remoteInput;
                    this.mReplyPendingIntent = pendingIntent;
                    return this;
                }

                public Builder setReadPendingIntent(PendingIntent pendingIntent) {
                    this.mReadPendingIntent = pendingIntent;
                    return this;
                }

                public Builder setLatestTimestamp(long timestamp) {
                    this.mLatestTimestamp = timestamp;
                    return this;
                }

                public UnreadConversation build() {
                    List<String> list = this.mMessages;
                    String[] messages = (String[]) list.toArray(new String[list.size()]);
                    String[] participants = {this.mParticipant};
                    return new UnreadConversation(messages, this.mRemoteInput, this.mReplyPendingIntent, this.mReadPendingIntent, participants, this.mLatestTimestamp);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static class Api20Impl {
            private Api20Impl() {
            }

            static RemoteInput.Builder createBuilder(String resultKey) {
                return new RemoteInput.Builder(resultKey);
            }

            static android.app.RemoteInput build(RemoteInput.Builder builder) {
                return builder.build();
            }

            static String getResultKey(android.app.RemoteInput remoteInput) {
                return remoteInput.getResultKey();
            }

            static CharSequence[] getChoices(android.app.RemoteInput remoteInput) {
                return remoteInput.getChoices();
            }

            static RemoteInput.Builder setChoices(RemoteInput.Builder builder, CharSequence[] choices) {
                return builder.setChoices(choices);
            }

            static CharSequence getLabel(android.app.RemoteInput remoteInput) {
                return remoteInput.getLabel();
            }

            static RemoteInput.Builder setLabel(RemoteInput.Builder builder, CharSequence label) {
                return builder.setLabel(label);
            }

            static boolean getAllowFreeFormInput(android.app.RemoteInput remoteInput) {
                return remoteInput.getAllowFreeFormInput();
            }

            static RemoteInput.Builder setAllowFreeFormInput(RemoteInput.Builder builder, boolean allowFreeFormInput) {
                return builder.setAllowFreeFormInput(allowFreeFormInput);
            }

            static Bundle getExtras(android.app.RemoteInput remoteInput) {
                return remoteInput.getExtras();
            }

            static RemoteInput.Builder addExtras(RemoteInput.Builder builder, Bundle extras) {
                return builder.addExtras(extras);
            }

            static Parcelable castToParcelable(android.app.RemoteInput remoteInput) {
                return remoteInput;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static class Api29Impl {
            private Api29Impl() {
            }

            static int getEditChoicesBeforeSending(android.app.RemoteInput remoteInput) {
                return remoteInput.getEditChoicesBeforeSending();
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class TvExtender implements Extender {
        static final String EXTRA_CHANNEL_ID = "channel_id";
        static final String EXTRA_CONTENT_INTENT = "content_intent";
        static final String EXTRA_DELETE_INTENT = "delete_intent";
        private static final String EXTRA_FLAGS = "flags";
        static final String EXTRA_SUPPRESS_SHOW_OVER_APPS = "suppressShowOverApps";
        static final String EXTRA_TV_EXTENDER = "android.tv.EXTENSIONS";
        private static final int FLAG_AVAILABLE_ON_TV = 1;
        private static final String TAG = "TvExtender";
        private String mChannelId;
        private PendingIntent mContentIntent;
        private PendingIntent mDeleteIntent;
        private int mFlags;
        private boolean mSuppressShowOverApps;

        public TvExtender() {
            this.mFlags = 1;
        }

        public TvExtender(Notification notif) {
            if (Build.VERSION.SDK_INT < 26) {
                return;
            }
            Bundle tvBundle = notif.extras == null ? null : notif.extras.getBundle(EXTRA_TV_EXTENDER);
            if (tvBundle != null) {
                this.mFlags = tvBundle.getInt(EXTRA_FLAGS);
                this.mChannelId = tvBundle.getString(EXTRA_CHANNEL_ID);
                this.mSuppressShowOverApps = tvBundle.getBoolean(EXTRA_SUPPRESS_SHOW_OVER_APPS);
                this.mContentIntent = (PendingIntent) tvBundle.getParcelable(EXTRA_CONTENT_INTENT);
                this.mDeleteIntent = (PendingIntent) tvBundle.getParcelable(EXTRA_DELETE_INTENT);
            }
        }

        @Override // androidx.core.app.NotificationCompat.Extender
        public Builder extend(Builder builder) {
            if (Build.VERSION.SDK_INT < 26) {
                return builder;
            }
            Bundle tvExtensions = new Bundle();
            tvExtensions.putInt(EXTRA_FLAGS, this.mFlags);
            tvExtensions.putString(EXTRA_CHANNEL_ID, this.mChannelId);
            tvExtensions.putBoolean(EXTRA_SUPPRESS_SHOW_OVER_APPS, this.mSuppressShowOverApps);
            PendingIntent pendingIntent = this.mContentIntent;
            if (pendingIntent != null) {
                tvExtensions.putParcelable(EXTRA_CONTENT_INTENT, pendingIntent);
            }
            PendingIntent pendingIntent2 = this.mDeleteIntent;
            if (pendingIntent2 != null) {
                tvExtensions.putParcelable(EXTRA_DELETE_INTENT, pendingIntent2);
            }
            builder.getExtras().putBundle(EXTRA_TV_EXTENDER, tvExtensions);
            return builder;
        }

        public boolean isAvailableOnTv() {
            return (this.mFlags & 1) != 0;
        }

        public TvExtender setChannelId(String channelId) {
            this.mChannelId = channelId;
            return this;
        }

        public String getChannelId() {
            return this.mChannelId;
        }

        public TvExtender setContentIntent(PendingIntent intent) {
            this.mContentIntent = intent;
            return this;
        }

        public PendingIntent getContentIntent() {
            return this.mContentIntent;
        }

        public TvExtender setDeleteIntent(PendingIntent intent) {
            this.mDeleteIntent = intent;
            return this;
        }

        public PendingIntent getDeleteIntent() {
            return this.mDeleteIntent;
        }

        public TvExtender setSuppressShowOverApps(boolean suppress) {
            this.mSuppressShowOverApps = suppress;
            return this;
        }

        public boolean isSuppressShowOverApps() {
            return this.mSuppressShowOverApps;
        }
    }

    /* loaded from: classes.dex */
    public static final class BubbleMetadata {
        private static final int FLAG_AUTO_EXPAND_BUBBLE = 1;
        private static final int FLAG_SUPPRESS_NOTIFICATION = 2;
        private PendingIntent mDeleteIntent;
        private int mDesiredHeight;
        private int mDesiredHeightResId;
        private int mFlags;
        private IconCompat mIcon;
        private PendingIntent mPendingIntent;
        private String mShortcutId;

        private BubbleMetadata(PendingIntent expandIntent, PendingIntent deleteIntent, IconCompat icon, int height, int heightResId, int flags, String shortcutId) {
            this.mPendingIntent = expandIntent;
            this.mIcon = icon;
            this.mDesiredHeight = height;
            this.mDesiredHeightResId = heightResId;
            this.mDeleteIntent = deleteIntent;
            this.mFlags = flags;
            this.mShortcutId = shortcutId;
        }

        public PendingIntent getIntent() {
            return this.mPendingIntent;
        }

        public String getShortcutId() {
            return this.mShortcutId;
        }

        public PendingIntent getDeleteIntent() {
            return this.mDeleteIntent;
        }

        public IconCompat getIcon() {
            return this.mIcon;
        }

        public int getDesiredHeight() {
            return this.mDesiredHeight;
        }

        public int getDesiredHeightResId() {
            return this.mDesiredHeightResId;
        }

        public boolean getAutoExpandBubble() {
            return (this.mFlags & 1) != 0;
        }

        public boolean isNotificationSuppressed() {
            return (this.mFlags & 2) != 0;
        }

        public void setFlags(int flags) {
            this.mFlags = flags;
        }

        public static Notification.BubbleMetadata toPlatform(BubbleMetadata compatMetadata) {
            if (compatMetadata == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 30) {
                return Api30Impl.toPlatform(compatMetadata);
            }
            if (Build.VERSION.SDK_INT != 29) {
                return null;
            }
            return Api29Impl.toPlatform(compatMetadata);
        }

        public static BubbleMetadata fromPlatform(Notification.BubbleMetadata platformMetadata) {
            if (platformMetadata == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 30) {
                return Api30Impl.fromPlatform(platformMetadata);
            }
            if (Build.VERSION.SDK_INT != 29) {
                return null;
            }
            return Api29Impl.fromPlatform(platformMetadata);
        }

        /* loaded from: classes.dex */
        public static final class Builder {
            private PendingIntent mDeleteIntent;
            private int mDesiredHeight;
            private int mDesiredHeightResId;
            private int mFlags;
            private IconCompat mIcon;
            private PendingIntent mPendingIntent;
            private String mShortcutId;

            @Deprecated
            public Builder() {
            }

            public Builder(String shortcutId) {
                if (TextUtils.isEmpty(shortcutId)) {
                    throw new NullPointerException("Bubble requires a non-null shortcut id");
                }
                this.mShortcutId = shortcutId;
            }

            public Builder(PendingIntent intent, IconCompat icon) {
                if (intent == null) {
                    throw new NullPointerException("Bubble requires non-null pending intent");
                }
                if (icon == null) {
                    throw new NullPointerException("Bubbles require non-null icon");
                }
                this.mPendingIntent = intent;
                this.mIcon = icon;
            }

            public Builder setIntent(PendingIntent intent) {
                if (this.mShortcutId != null) {
                    throw new IllegalStateException("Created as a shortcut bubble, cannot set a PendingIntent. Consider using BubbleMetadata.Builder(PendingIntent,Icon) instead.");
                }
                if (intent == null) {
                    throw new NullPointerException("Bubble requires non-null pending intent");
                }
                this.mPendingIntent = intent;
                return this;
            }

            public Builder setIcon(IconCompat icon) {
                if (this.mShortcutId != null) {
                    throw new IllegalStateException("Created as a shortcut bubble, cannot set an Icon. Consider using BubbleMetadata.Builder(PendingIntent,Icon) instead.");
                }
                if (icon == null) {
                    throw new NullPointerException("Bubbles require non-null icon");
                }
                this.mIcon = icon;
                return this;
            }

            public Builder setDesiredHeight(int height) {
                this.mDesiredHeight = Math.max(height, 0);
                this.mDesiredHeightResId = 0;
                return this;
            }

            public Builder setDesiredHeightResId(int heightResId) {
                this.mDesiredHeightResId = heightResId;
                this.mDesiredHeight = 0;
                return this;
            }

            public Builder setAutoExpandBubble(boolean shouldExpand) {
                setFlag(1, shouldExpand);
                return this;
            }

            public Builder setSuppressNotification(boolean shouldSuppressNotif) {
                setFlag(2, shouldSuppressNotif);
                return this;
            }

            public Builder setDeleteIntent(PendingIntent deleteIntent) {
                this.mDeleteIntent = deleteIntent;
                return this;
            }

            public BubbleMetadata build() {
                String str = this.mShortcutId;
                if (str == null && this.mPendingIntent == null) {
                    throw new NullPointerException("Must supply pending intent or shortcut to bubble");
                }
                if (str == null && this.mIcon == null) {
                    throw new NullPointerException("Must supply an icon or shortcut for the bubble");
                }
                BubbleMetadata data = new BubbleMetadata(this.mPendingIntent, this.mDeleteIntent, this.mIcon, this.mDesiredHeight, this.mDesiredHeightResId, this.mFlags, str);
                data.setFlags(this.mFlags);
                return data;
            }

            private Builder setFlag(int mask, boolean value) {
                if (value) {
                    this.mFlags |= mask;
                } else {
                    this.mFlags &= ~mask;
                }
                return this;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class Api29Impl {
            private Api29Impl() {
            }

            static Notification.BubbleMetadata toPlatform(BubbleMetadata compatMetadata) {
                if (compatMetadata == null || compatMetadata.getIntent() == null) {
                    return null;
                }
                Notification.BubbleMetadata.Builder platformMetadataBuilder = new Notification.BubbleMetadata.Builder().setIcon(compatMetadata.getIcon().toIcon()).setIntent(compatMetadata.getIntent()).setDeleteIntent(compatMetadata.getDeleteIntent()).setAutoExpandBubble(compatMetadata.getAutoExpandBubble()).setSuppressNotification(compatMetadata.isNotificationSuppressed());
                if (compatMetadata.getDesiredHeight() != 0) {
                    platformMetadataBuilder.setDesiredHeight(compatMetadata.getDesiredHeight());
                }
                if (compatMetadata.getDesiredHeightResId() != 0) {
                    platformMetadataBuilder.setDesiredHeightResId(compatMetadata.getDesiredHeightResId());
                }
                return platformMetadataBuilder.build();
            }

            static BubbleMetadata fromPlatform(Notification.BubbleMetadata platformMetadata) {
                if (platformMetadata == null || platformMetadata.getIntent() == null) {
                    return null;
                }
                Builder compatBuilder = new Builder(platformMetadata.getIntent(), IconCompat.createFromIcon(platformMetadata.getIcon())).setAutoExpandBubble(platformMetadata.getAutoExpandBubble()).setDeleteIntent(platformMetadata.getDeleteIntent()).setSuppressNotification(platformMetadata.isNotificationSuppressed());
                if (platformMetadata.getDesiredHeight() != 0) {
                    compatBuilder.setDesiredHeight(platformMetadata.getDesiredHeight());
                }
                if (platformMetadata.getDesiredHeightResId() != 0) {
                    compatBuilder.setDesiredHeightResId(platformMetadata.getDesiredHeightResId());
                }
                return compatBuilder.build();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class Api30Impl {
            private Api30Impl() {
            }

            static Notification.BubbleMetadata toPlatform(BubbleMetadata compatMetadata) {
                Notification.BubbleMetadata.Builder platformMetadataBuilder;
                if (compatMetadata == null) {
                    return null;
                }
                if (compatMetadata.getShortcutId() != null) {
                    platformMetadataBuilder = new Notification.BubbleMetadata.Builder(compatMetadata.getShortcutId());
                } else {
                    platformMetadataBuilder = new Notification.BubbleMetadata.Builder(compatMetadata.getIntent(), compatMetadata.getIcon().toIcon());
                }
                platformMetadataBuilder.setDeleteIntent(compatMetadata.getDeleteIntent()).setAutoExpandBubble(compatMetadata.getAutoExpandBubble()).setSuppressNotification(compatMetadata.isNotificationSuppressed());
                if (compatMetadata.getDesiredHeight() != 0) {
                    platformMetadataBuilder.setDesiredHeight(compatMetadata.getDesiredHeight());
                }
                if (compatMetadata.getDesiredHeightResId() != 0) {
                    platformMetadataBuilder.setDesiredHeightResId(compatMetadata.getDesiredHeightResId());
                }
                return platformMetadataBuilder.build();
            }

            static BubbleMetadata fromPlatform(Notification.BubbleMetadata platformMetadata) {
                Builder compatBuilder;
                if (platformMetadata == null) {
                    return null;
                }
                if (platformMetadata.getShortcutId() != null) {
                    compatBuilder = new Builder(platformMetadata.getShortcutId());
                } else {
                    compatBuilder = new Builder(platformMetadata.getIntent(), IconCompat.createFromIcon(platformMetadata.getIcon()));
                }
                compatBuilder.setAutoExpandBubble(platformMetadata.getAutoExpandBubble()).setDeleteIntent(platformMetadata.getDeleteIntent()).setSuppressNotification(platformMetadata.isNotificationSuppressed());
                if (platformMetadata.getDesiredHeight() != 0) {
                    compatBuilder.setDesiredHeight(platformMetadata.getDesiredHeight());
                }
                if (platformMetadata.getDesiredHeightResId() != 0) {
                    compatBuilder.setDesiredHeightResId(platformMetadata.getDesiredHeightResId());
                }
                return compatBuilder.build();
            }
        }
    }

    static Notification[] getNotificationArrayFromBundle(Bundle bundle, String key) {
        Parcelable[] array = bundle.getParcelableArray(key);
        if ((array instanceof Notification[]) || array == null) {
            return (Notification[]) array;
        }
        Notification[] typedArray = new Notification[array.length];
        for (int i = 0; i < array.length; i++) {
            typedArray[i] = (Notification) array[i];
        }
        bundle.putParcelableArray(key, typedArray);
        return typedArray;
    }

    public static Bundle getExtras(Notification notification) {
        return notification.extras;
    }

    public static int getActionCount(Notification notification) {
        if (notification.actions != null) {
            return notification.actions.length;
        }
        return 0;
    }

    public static Action getAction(Notification notification, int actionIndex) {
        if (Build.VERSION.SDK_INT >= 20) {
            return getActionCompatFromAction(notification.actions[actionIndex]);
        }
        Notification.Action action = notification.actions[actionIndex];
        Bundle actionExtras = null;
        SparseArray<Bundle> actionExtrasMap = notification.extras.getSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS);
        if (actionExtrasMap != null) {
            Bundle actionExtras2 = actionExtrasMap.get(actionIndex);
            actionExtras = actionExtras2;
        }
        return NotificationCompatJellybean.readAction(action.icon, action.title, action.actionIntent, actionExtras);
    }

    public static BubbleMetadata getBubbleMetadata(Notification notification) {
        if (Build.VERSION.SDK_INT >= 29) {
            return BubbleMetadata.fromPlatform(Api29Impl.getBubbleMetadata(notification));
        }
        return null;
    }

    static Action getActionCompatFromAction(Notification.Action action) {
        RemoteInput[] remoteInputs;
        int i;
        boolean allowGeneratedReplies;
        int semanticAction;
        android.app.RemoteInput[] srcArray = Api20Impl.getRemoteInputs(action);
        if (srcArray == null) {
            remoteInputs = null;
        } else {
            remoteInputs = new RemoteInput[srcArray.length];
            for (int i2 = 0; i2 < srcArray.length; i2++) {
                android.app.RemoteInput src = srcArray[i2];
                String resultKey = Api20Impl.getResultKey(src);
                CharSequence label = Api20Impl.getLabel(src);
                CharSequence[] choices = Api20Impl.getChoices(src);
                boolean allowFreeFormInput = Api20Impl.getAllowFreeFormInput(src);
                if (Build.VERSION.SDK_INT >= 29) {
                    i = Api29Impl.getEditChoicesBeforeSending(src);
                } else {
                    i = 0;
                }
                remoteInputs[i2] = new RemoteInput(resultKey, label, choices, allowFreeFormInput, i, Api20Impl.getExtras(src), null);
            }
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 24) {
            allowGeneratedReplies = Api20Impl.getExtras(action).getBoolean("android.support.allowGeneratedReplies") || Api24Impl.getAllowGeneratedReplies(action);
        } else {
            allowGeneratedReplies = Api20Impl.getExtras(action).getBoolean("android.support.allowGeneratedReplies");
        }
        boolean showsUserInterface = Api20Impl.getExtras(action).getBoolean("android.support.action.showsUserInterface", true);
        if (Build.VERSION.SDK_INT >= 28) {
            semanticAction = Api28Impl.getSemanticAction(action);
        } else {
            semanticAction = Api20Impl.getExtras(action).getInt("android.support.action.semanticAction", 0);
        }
        boolean isContextual = Build.VERSION.SDK_INT >= 29 ? Api29Impl.isContextual(action) : false;
        boolean authRequired = Build.VERSION.SDK_INT >= 31 ? Api31Impl.isAuthenticationRequired(action) : false;
        if (Build.VERSION.SDK_INT >= 23) {
            if (Api23Impl.getIcon(action) == null && action.icon != 0) {
                return new Action(action.icon, action.title, action.actionIntent, Api20Impl.getExtras(action), remoteInputs, (RemoteInput[]) null, allowGeneratedReplies, semanticAction, showsUserInterface, isContextual, authRequired);
            }
            IconCompat icon = Api23Impl.getIcon(action) == null ? null : IconCompat.createFromIconOrNullIfZeroResId(Api23Impl.getIcon(action));
            return new Action(icon, action.title, action.actionIntent, Api20Impl.getExtras(action), remoteInputs, (RemoteInput[]) null, allowGeneratedReplies, semanticAction, showsUserInterface, isContextual, authRequired);
        }
        return new Action(action.icon, action.title, action.actionIntent, Api20Impl.getExtras(action), remoteInputs, (RemoteInput[]) null, allowGeneratedReplies, semanticAction, showsUserInterface, isContextual, authRequired);
    }

    public static List<Action> getInvisibleActions(Notification notification) {
        ArrayList<Action> result = new ArrayList<>();
        Bundle carExtenderBundle = notification.extras.getBundle("android.car.EXTENSIONS");
        if (carExtenderBundle == null) {
            return result;
        }
        Bundle listBundle = carExtenderBundle.getBundle("invisible_actions");
        if (listBundle != null) {
            for (int i = 0; i < listBundle.size(); i++) {
                result.add(NotificationCompatJellybean.getActionFromBundle(listBundle.getBundle(Integer.toString(i))));
            }
        }
        return result;
    }

    public static List<Person> getPeople(Notification notification) {
        ArrayList<Person> result = new ArrayList<>();
        if (Build.VERSION.SDK_INT >= 28) {
            ArrayList<android.app.Person> peopleList = notification.extras.getParcelableArrayList(EXTRA_PEOPLE_LIST);
            if (peopleList != null && !peopleList.isEmpty()) {
                Iterator<android.app.Person> it = peopleList.iterator();
                while (it.hasNext()) {
                    android.app.Person person = it.next();
                    result.add(Person.fromAndroidPerson(person));
                }
            }
        } else {
            String[] peopleArray = notification.extras.getStringArray(EXTRA_PEOPLE);
            if (peopleArray != null && peopleArray.length != 0) {
                for (String personUri : peopleArray) {
                    result.add(new Person.Builder().setUri(personUri).build());
                }
            }
        }
        return result;
    }

    public static CharSequence getContentTitle(Notification notification) {
        return notification.extras.getCharSequence(EXTRA_TITLE);
    }

    public static CharSequence getContentText(Notification notification) {
        return notification.extras.getCharSequence(EXTRA_TEXT);
    }

    public static CharSequence getContentInfo(Notification notification) {
        return notification.extras.getCharSequence(EXTRA_INFO_TEXT);
    }

    public static CharSequence getSubText(Notification notification) {
        return notification.extras.getCharSequence(EXTRA_SUB_TEXT);
    }

    public static String getCategory(Notification notification) {
        if (Build.VERSION.SDK_INT >= 21) {
            return notification.category;
        }
        return null;
    }

    public static boolean getLocalOnly(Notification notification) {
        if (Build.VERSION.SDK_INT >= 20) {
            return (notification.flags & 256) != 0;
        }
        return notification.extras.getBoolean(NotificationCompatExtras.EXTRA_LOCAL_ONLY);
    }

    public static String getGroup(Notification notification) {
        if (Build.VERSION.SDK_INT >= 20) {
            return Api20Impl.getGroup(notification);
        }
        return notification.extras.getString(NotificationCompatExtras.EXTRA_GROUP_KEY);
    }

    public static boolean getShowWhen(Notification notification) {
        return notification.extras.getBoolean(EXTRA_SHOW_WHEN);
    }

    public static boolean getUsesChronometer(Notification notification) {
        return notification.extras.getBoolean(EXTRA_SHOW_CHRONOMETER);
    }

    public static boolean getOnlyAlertOnce(Notification notification) {
        return (notification.flags & 8) != 0;
    }

    public static boolean getAutoCancel(Notification notification) {
        return (notification.flags & 16) != 0;
    }

    public static boolean getOngoing(Notification notification) {
        return (notification.flags & 2) != 0;
    }

    public static int getColor(Notification notification) {
        if (Build.VERSION.SDK_INT >= 21) {
            return notification.color;
        }
        return 0;
    }

    public static int getVisibility(Notification notification) {
        if (Build.VERSION.SDK_INT >= 21) {
            return notification.visibility;
        }
        return 0;
    }

    public static Notification getPublicVersion(Notification notification) {
        if (Build.VERSION.SDK_INT >= 21) {
            return notification.publicVersion;
        }
        return null;
    }

    static boolean getHighPriority(Notification notification) {
        return (notification.flags & 128) != 0;
    }

    public static boolean isGroupSummary(Notification notification) {
        if (Build.VERSION.SDK_INT >= 20) {
            return (notification.flags & 512) != 0;
        }
        return notification.extras.getBoolean(NotificationCompatExtras.EXTRA_GROUP_SUMMARY);
    }

    public static String getSortKey(Notification notification) {
        if (Build.VERSION.SDK_INT >= 20) {
            return Api20Impl.getSortKey(notification);
        }
        return notification.extras.getString(NotificationCompatExtras.EXTRA_SORT_KEY);
    }

    public static String getChannelId(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getChannelId(notification);
        }
        return null;
    }

    public static long getTimeoutAfter(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getTimeoutAfter(notification);
        }
        return 0L;
    }

    public static int getBadgeIconType(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getBadgeIconType(notification);
        }
        return 0;
    }

    public static String getShortcutId(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getShortcutId(notification);
        }
        return null;
    }

    public static CharSequence getSettingsText(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getSettingsText(notification);
        }
        return null;
    }

    public static LocusIdCompat getLocusId(Notification notification) {
        LocusId locusId;
        if (Build.VERSION.SDK_INT < 29 || (locusId = Api29Impl.getLocusId(notification)) == null) {
            return null;
        }
        return LocusIdCompat.toLocusIdCompat(locusId);
    }

    public static int getGroupAlertBehavior(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getGroupAlertBehavior(notification);
        }
        return 0;
    }

    public static boolean getAllowSystemGeneratedContextualActions(Notification notification) {
        if (Build.VERSION.SDK_INT >= 29) {
            return Api29Impl.getAllowSystemGeneratedContextualActions(notification);
        }
        return false;
    }

    public static Bitmap reduceLargeIconSize(Context context, Bitmap icon) {
        if (icon == null || Build.VERSION.SDK_INT >= 27) {
            return icon;
        }
        Resources res = context.getResources();
        int maxWidth = res.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_width);
        int maxHeight = res.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_height);
        if (icon.getWidth() <= maxWidth && icon.getHeight() <= maxHeight) {
            return icon;
        }
        double scale = Math.min(maxWidth / Math.max(1, icon.getWidth()), maxHeight / Math.max(1, icon.getHeight()));
        return Bitmap.createScaledBitmap(icon, (int) Math.ceil(icon.getWidth() * scale), (int) Math.ceil(icon.getHeight() * scale), true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api20Impl {
        private Api20Impl() {
        }

        static boolean getAllowFreeFormInput(android.app.RemoteInput remoteInput) {
            return remoteInput.getAllowFreeFormInput();
        }

        static CharSequence[] getChoices(android.app.RemoteInput remoteInput) {
            return remoteInput.getChoices();
        }

        static CharSequence getLabel(android.app.RemoteInput remoteInput) {
            return remoteInput.getLabel();
        }

        static String getResultKey(android.app.RemoteInput remoteInput) {
            return remoteInput.getResultKey();
        }

        static android.app.RemoteInput[] getRemoteInputs(Notification.Action action) {
            return action.getRemoteInputs();
        }

        static String getSortKey(Notification notification) {
            return notification.getSortKey();
        }

        static String getGroup(Notification notification) {
            return notification.getGroup();
        }

        static Bundle getExtras(Notification.Action action) {
            return action.getExtras();
        }

        static Bundle getExtras(android.app.RemoteInput remoteInput) {
            return remoteInput.getExtras();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api23Impl {
        private Api23Impl() {
        }

        static Icon getIcon(Notification.Action action) {
            return action.getIcon();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api24Impl {
        private Api24Impl() {
        }

        static boolean getAllowGeneratedReplies(Notification.Action action) {
            return action.getAllowGeneratedReplies();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api26Impl {
        private Api26Impl() {
        }

        static int getGroupAlertBehavior(Notification notification) {
            return notification.getGroupAlertBehavior();
        }

        static CharSequence getSettingsText(Notification notification) {
            return notification.getSettingsText();
        }

        static String getShortcutId(Notification notification) {
            return notification.getShortcutId();
        }

        static int getBadgeIconType(Notification notification) {
            return notification.getBadgeIconType();
        }

        static long getTimeoutAfter(Notification notification) {
            return notification.getTimeoutAfter();
        }

        static String getChannelId(Notification notification) {
            return notification.getChannelId();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api28Impl {
        private Api28Impl() {
        }

        static int getSemanticAction(Notification.Action action) {
            return action.getSemanticAction();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api29Impl {
        private Api29Impl() {
        }

        static boolean getAllowSystemGeneratedContextualActions(Notification notification) {
            return notification.getAllowSystemGeneratedContextualActions();
        }

        static LocusId getLocusId(Notification notification) {
            return notification.getLocusId();
        }

        static boolean isContextual(Notification.Action action) {
            return action.isContextual();
        }

        static int getEditChoicesBeforeSending(android.app.RemoteInput remoteInput) {
            return remoteInput.getEditChoicesBeforeSending();
        }

        static Notification.BubbleMetadata getBubbleMetadata(Notification notification) {
            return notification.getBubbleMetadata();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api31Impl {
        private Api31Impl() {
        }

        static boolean isAuthenticationRequired(Notification.Action action) {
            return action.isAuthenticationRequired();
        }
    }
}
