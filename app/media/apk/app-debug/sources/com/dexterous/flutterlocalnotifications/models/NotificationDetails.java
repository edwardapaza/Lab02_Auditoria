package com.dexterous.flutterlocalnotifications.models;

import android.graphics.Color;
import android.os.Build;
import com.dexterous.flutterlocalnotifications.models.styles.BigPictureStyleInformation;
import com.dexterous.flutterlocalnotifications.models.styles.BigTextStyleInformation;
import com.dexterous.flutterlocalnotifications.models.styles.DefaultStyleInformation;
import com.dexterous.flutterlocalnotifications.models.styles.InboxStyleInformation;
import com.dexterous.flutterlocalnotifications.models.styles.MessagingStyleInformation;
import com.dexterous.flutterlocalnotifications.models.styles.StyleInformation;
import com.dexterous.flutterlocalnotifications.utils.LongUtils;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class NotificationDetails implements Serializable {
    private static final String ACTIONS = "actions";
    private static final String ADDITIONAL_FLAGS = "additionalFlags";
    private static final String AUDIO_ATTRIBUTES_USAGE = "audioAttributesUsage";
    private static final String AUTO_CANCEL = "autoCancel";
    private static final String BIG_PICTURE = "bigPicture";
    private static final String BIG_PICTURE_BITMAP_SOURCE = "bigPictureBitmapSource";
    private static final String BIG_TEXT = "bigText";
    private static final String BODY = "body";
    private static final String BOT = "bot";
    private static final String CALLED_AT = "calledAt";
    private static final String CATEGORY = "category";
    private static final String CHANNEL_ACTION = "channelAction";
    private static final String CHANNEL_DESCRIPTION = "channelDescription";
    private static final String CHANNEL_ID = "channelId";
    private static final String CHANNEL_NAME = "channelName";
    private static final String CHANNEL_SHOW_BADGE = "channelShowBadge";
    private static final String CHRONOMETER_COUNT_DOWN = "chronometerCountDown";
    private static final String COLORIZED = "colorized";
    private static final String COLOR_ALPHA = "colorAlpha";
    private static final String COLOR_BLUE = "colorBlue";
    private static final String COLOR_GREEN = "colorGreen";
    private static final String COLOR_RED = "colorRed";
    private static final String CONTENT_TITLE = "contentTitle";
    private static final String CONVERSATION_TITLE = "conversationTitle";
    private static final String DATA_MIME_TYPE = "dataMimeType";
    private static final String DATA_URI = "dataUri";
    private static final String DAY = "day";
    private static final String ENABLE_LIGHTS = "enableLights";
    private static final String ENABLE_VIBRATION = "enableVibration";
    private static final String FULL_SCREEN_INTENT = "fullScreenIntent";
    private static final String GROUP_ALERT_BEHAVIOR = "groupAlertBehavior";
    private static final String GROUP_CONVERSATION = "groupConversation";
    private static final String GROUP_KEY = "groupKey";
    private static final String HIDE_EXPANDED_LARGE_ICON = "hideExpandedLargeIcon";
    private static final String HTML_FORMAT_BIG_TEXT = "htmlFormatBigText";
    private static final String HTML_FORMAT_CONTENT = "htmlFormatContent";
    private static final String HTML_FORMAT_CONTENT_TITLE = "htmlFormatContentTitle";
    private static final String HTML_FORMAT_LINES = "htmlFormatLines";
    private static final String HTML_FORMAT_SUMMARY_TEXT = "htmlFormatSummaryText";
    private static final String HTML_FORMAT_TITLE = "htmlFormatTitle";
    private static final String ICON = "icon";
    private static final String ICON_SOURCE = "iconSource";
    private static final String ID = "id";
    private static final String IMPORTANCE = "importance";
    private static final String IMPORTANT = "important";
    private static final String INDETERMINATE = "indeterminate";
    private static final String KEY = "key";
    private static final String LARGE_ICON = "largeIcon";
    private static final String LARGE_ICON_BITMAP_SOURCE = "largeIconBitmapSource";
    private static final String LED_COLOR_ALPHA = "ledColorAlpha";
    private static final String LED_COLOR_BLUE = "ledColorBlue";
    private static final String LED_COLOR_GREEN = "ledColorGreen";
    private static final String LED_COLOR_RED = "ledColorRed";
    private static final String LED_OFF_MS = "ledOffMs";
    private static final String LED_ON_MS = "ledOnMs";
    private static final String LINES = "lines";
    private static final String MATCH_DATE_TIME_COMPONENTS = "matchDateTimeComponents";
    private static final String MAX_PROGRESS = "maxProgress";
    private static final String MESSAGES = "messages";
    private static final String MILLISECONDS_SINCE_EPOCH = "millisecondsSinceEpoch";
    private static final String NAME = "name";
    private static final String NUMBER = "number";
    private static final String ONGOING = "ongoing";
    private static final String ONLY_ALERT_ONCE = "onlyAlertOnce";
    private static final String PAYLOAD = "payload";
    private static final String PERSON = "person";
    private static final String PLATFORM_SPECIFICS = "platformSpecifics";
    private static final String PLAY_SOUND = "playSound";
    private static final String PRIORITY = "priority";
    private static final String PROGRESS = "progress";
    private static final String REPEAT_INTERVAL = "repeatInterval";
    private static final String REPEAT_TIME = "repeatTime";
    private static final String SCHEDULED_DATE_TIME = "scheduledDateTime";
    private static final String SCHEDULED_NOTIFICATION_REPEAT_FREQUENCY = "scheduledNotificationRepeatFrequency";
    private static final String SCHEDULE_MODE = "scheduleMode";
    private static final String SET_AS_GROUP_SUMMARY = "setAsGroupSummary";
    private static final String SHORTCUT_ID = "shortcutId";
    private static final String SHOW_PROGRESS = "showProgress";
    private static final String SHOW_WHEN = "showWhen";
    private static final String SILENT = "silent";
    private static final String SOUND = "sound";
    private static final String SOUND_SOURCE = "soundSource";
    private static final String STYLE = "style";
    private static final String STYLE_INFORMATION = "styleInformation";
    private static final String SUB_TEXT = "subText";
    private static final String SUMMARY_TEXT = "summaryText";
    private static final String TAG = "tag";
    private static final String TEXT = "text";
    private static final String TICKER = "ticker";
    private static final String TIMEOUT_AFTER = "timeoutAfter";
    private static final String TIMESTAMP = "timestamp";
    private static final String TIME_ZONE_NAME = "timeZoneName";
    private static final String TITLE = "title";
    private static final String URI = "uri";
    private static final String USES_CHRONOMETER = "usesChronometer";
    private static final String VIBRATION_PATTERN = "vibrationPattern";
    private static final String VISIBILITY = "visibility";
    private static final String WHEN = "when";
    public List<NotificationAction> actions;
    public int[] additionalFlags;
    public Integer audioAttributesUsage;
    public Boolean autoCancel;
    public String body;
    public Long calledAt;
    public String category;
    public NotificationChannelAction channelAction;
    public String channelDescription;
    public String channelId = "Default_Channel_Id";
    public String channelName;
    public Boolean channelShowBadge;
    public Boolean chronometerCountDown;
    public Integer color;
    public Boolean colorized;
    public Integer day;
    public Boolean enableLights;
    public Boolean enableVibration;
    public Boolean fullScreenIntent;
    public Integer groupAlertBehavior;
    public String groupKey;
    public String icon;
    public Integer iconResourceId;
    public Integer id;
    public Integer importance;
    public Boolean indeterminate;
    public Object largeIcon;
    public BitmapSource largeIconBitmapSource;
    public Integer ledColor;
    public Integer ledOffMs;
    public Integer ledOnMs;
    public DateTimeComponents matchDateTimeComponents;
    public Integer maxProgress;
    public Long millisecondsSinceEpoch;
    public Integer number;
    public Boolean ongoing;
    public Boolean onlyAlertOnce;
    public String payload;
    public Boolean playSound;
    public Integer priority;
    public Integer progress;
    public RepeatInterval repeatInterval;
    public Time repeatTime;
    @SerializedName(alternate = {"allowWhileIdle"}, value = SCHEDULE_MODE)
    public ScheduleMode scheduleMode;
    public String scheduledDateTime;
    public ScheduledNotificationRepeatFrequency scheduledNotificationRepeatFrequency;
    public Boolean setAsGroupSummary;
    public String shortcutId;
    public Boolean showProgress;
    public Boolean showWhen;
    public Boolean silent;
    public String sound;
    public SoundSource soundSource;
    public NotificationStyle style;
    public StyleInformation styleInformation;
    public String subText;
    public String tag;
    public String ticker;
    public String timeZoneName;
    public Long timeoutAfter;
    public String title;
    public Boolean usesChronometer;
    public long[] vibrationPattern;
    public Integer visibility;
    public Long when;

    public static NotificationDetails from(Map<String, Object> arguments) {
        NotificationDetails notificationDetails = new NotificationDetails();
        notificationDetails.payload = (String) arguments.get(PAYLOAD);
        notificationDetails.id = (Integer) arguments.get(ID);
        notificationDetails.title = (String) arguments.get(TITLE);
        notificationDetails.body = (String) arguments.get(BODY);
        notificationDetails.scheduledDateTime = (String) arguments.get(SCHEDULED_DATE_TIME);
        notificationDetails.timeZoneName = (String) arguments.get(TIME_ZONE_NAME);
        if (arguments.containsKey(SCHEDULED_NOTIFICATION_REPEAT_FREQUENCY)) {
            notificationDetails.scheduledNotificationRepeatFrequency = ScheduledNotificationRepeatFrequency.values()[((Integer) arguments.get(SCHEDULED_NOTIFICATION_REPEAT_FREQUENCY)).intValue()];
        }
        if (arguments.containsKey(MATCH_DATE_TIME_COMPONENTS)) {
            notificationDetails.matchDateTimeComponents = DateTimeComponents.values()[((Integer) arguments.get(MATCH_DATE_TIME_COMPONENTS)).intValue()];
        }
        if (arguments.containsKey(MILLISECONDS_SINCE_EPOCH)) {
            notificationDetails.millisecondsSinceEpoch = (Long) arguments.get(MILLISECONDS_SINCE_EPOCH);
        }
        if (arguments.containsKey(CALLED_AT)) {
            notificationDetails.calledAt = (Long) arguments.get(CALLED_AT);
        }
        if (arguments.containsKey(REPEAT_INTERVAL)) {
            notificationDetails.repeatInterval = RepeatInterval.values()[((Integer) arguments.get(REPEAT_INTERVAL)).intValue()];
        }
        if (arguments.containsKey(REPEAT_TIME)) {
            Map<String, Object> repeatTimeParams = (Map) arguments.get(REPEAT_TIME);
            notificationDetails.repeatTime = Time.from(repeatTimeParams);
        }
        if (arguments.containsKey(DAY)) {
            notificationDetails.day = (Integer) arguments.get(DAY);
        }
        readPlatformSpecifics(arguments, notificationDetails);
        return notificationDetails;
    }

    private static void readPlatformSpecifics(Map<String, Object> arguments, NotificationDetails notificationDetails) {
        List<Map<String, Object>> inputActions;
        Map<String, Object> platformChannelSpecifics = (Map) arguments.get(PLATFORM_SPECIFICS);
        if (platformChannelSpecifics != null) {
            notificationDetails.autoCancel = (Boolean) platformChannelSpecifics.get(AUTO_CANCEL);
            notificationDetails.ongoing = (Boolean) platformChannelSpecifics.get(ONGOING);
            notificationDetails.silent = (Boolean) platformChannelSpecifics.get("silent");
            notificationDetails.style = NotificationStyle.values()[((Integer) platformChannelSpecifics.get(STYLE)).intValue()];
            readStyleInformation(notificationDetails, platformChannelSpecifics);
            notificationDetails.icon = (String) platformChannelSpecifics.get(ICON);
            notificationDetails.priority = (Integer) platformChannelSpecifics.get(PRIORITY);
            readSoundInformation(notificationDetails, platformChannelSpecifics);
            notificationDetails.enableVibration = (Boolean) platformChannelSpecifics.get(ENABLE_VIBRATION);
            notificationDetails.vibrationPattern = (long[]) platformChannelSpecifics.get(VIBRATION_PATTERN);
            readGroupingInformation(notificationDetails, platformChannelSpecifics);
            notificationDetails.onlyAlertOnce = (Boolean) platformChannelSpecifics.get(ONLY_ALERT_ONCE);
            notificationDetails.showWhen = (Boolean) platformChannelSpecifics.get(SHOW_WHEN);
            notificationDetails.when = LongUtils.parseLong(platformChannelSpecifics.get(WHEN));
            notificationDetails.usesChronometer = (Boolean) platformChannelSpecifics.get(USES_CHRONOMETER);
            notificationDetails.chronometerCountDown = (Boolean) platformChannelSpecifics.get(CHRONOMETER_COUNT_DOWN);
            readProgressInformation(notificationDetails, platformChannelSpecifics);
            readColor(notificationDetails, platformChannelSpecifics);
            readChannelInformation(notificationDetails, platformChannelSpecifics);
            readLedInformation(notificationDetails, platformChannelSpecifics);
            readLargeIconInformation(notificationDetails, platformChannelSpecifics);
            notificationDetails.ticker = (String) platformChannelSpecifics.get(TICKER);
            notificationDetails.visibility = (Integer) platformChannelSpecifics.get(VISIBILITY);
            if (platformChannelSpecifics.containsKey(SCHEDULE_MODE)) {
                notificationDetails.scheduleMode = ScheduleMode.valueOf((String) platformChannelSpecifics.get(SCHEDULE_MODE));
            }
            notificationDetails.timeoutAfter = LongUtils.parseLong(platformChannelSpecifics.get(TIMEOUT_AFTER));
            notificationDetails.category = (String) platformChannelSpecifics.get(CATEGORY);
            notificationDetails.fullScreenIntent = (Boolean) platformChannelSpecifics.get(FULL_SCREEN_INTENT);
            notificationDetails.shortcutId = (String) platformChannelSpecifics.get(SHORTCUT_ID);
            notificationDetails.additionalFlags = (int[]) platformChannelSpecifics.get(ADDITIONAL_FLAGS);
            notificationDetails.subText = (String) platformChannelSpecifics.get(SUB_TEXT);
            notificationDetails.tag = (String) platformChannelSpecifics.get(TAG);
            notificationDetails.colorized = (Boolean) platformChannelSpecifics.get(COLORIZED);
            notificationDetails.number = (Integer) platformChannelSpecifics.get(NUMBER);
            notificationDetails.audioAttributesUsage = (Integer) platformChannelSpecifics.get(AUDIO_ATTRIBUTES_USAGE);
            if (platformChannelSpecifics.containsKey(ACTIONS) && (inputActions = (List) platformChannelSpecifics.get(ACTIONS)) != null && !inputActions.isEmpty()) {
                notificationDetails.actions = new ArrayList();
                for (Map<String, Object> input : inputActions) {
                    NotificationAction action = new NotificationAction(input);
                    notificationDetails.actions.add(action);
                }
            }
        }
    }

    private static void readProgressInformation(NotificationDetails notificationDetails, Map<String, Object> platformChannelSpecifics) {
        notificationDetails.showProgress = (Boolean) platformChannelSpecifics.get(SHOW_PROGRESS);
        if (platformChannelSpecifics.containsKey(MAX_PROGRESS)) {
            notificationDetails.maxProgress = (Integer) platformChannelSpecifics.get(MAX_PROGRESS);
        }
        if (platformChannelSpecifics.containsKey("progress")) {
            notificationDetails.progress = (Integer) platformChannelSpecifics.get("progress");
        }
        if (platformChannelSpecifics.containsKey(INDETERMINATE)) {
            notificationDetails.indeterminate = (Boolean) platformChannelSpecifics.get(INDETERMINATE);
        }
    }

    private static void readLargeIconInformation(NotificationDetails notificationDetails, Map<String, Object> platformChannelSpecifics) {
        Integer argumentValue;
        notificationDetails.largeIcon = platformChannelSpecifics.get(LARGE_ICON);
        if (platformChannelSpecifics.containsKey(LARGE_ICON_BITMAP_SOURCE) && (argumentValue = (Integer) platformChannelSpecifics.get(LARGE_ICON_BITMAP_SOURCE)) != null) {
            notificationDetails.largeIconBitmapSource = BitmapSource.values()[argumentValue.intValue()];
        }
    }

    private static void readGroupingInformation(NotificationDetails notificationDetails, Map<String, Object> platformChannelSpecifics) {
        notificationDetails.groupKey = (String) platformChannelSpecifics.get(GROUP_KEY);
        notificationDetails.setAsGroupSummary = (Boolean) platformChannelSpecifics.get(SET_AS_GROUP_SUMMARY);
        notificationDetails.groupAlertBehavior = (Integer) platformChannelSpecifics.get(GROUP_ALERT_BEHAVIOR);
    }

    private static void readSoundInformation(NotificationDetails notificationDetails, Map<String, Object> platformChannelSpecifics) {
        notificationDetails.playSound = (Boolean) platformChannelSpecifics.get(PLAY_SOUND);
        notificationDetails.sound = (String) platformChannelSpecifics.get(SOUND);
        Integer soundSourceIndex = (Integer) platformChannelSpecifics.get(SOUND_SOURCE);
        if (soundSourceIndex != null) {
            notificationDetails.soundSource = SoundSource.values()[soundSourceIndex.intValue()];
        }
    }

    private static void readColor(NotificationDetails notificationDetails, Map<String, Object> platformChannelSpecifics) {
        Integer a = (Integer) platformChannelSpecifics.get(COLOR_ALPHA);
        Integer r = (Integer) platformChannelSpecifics.get(COLOR_RED);
        Integer g = (Integer) platformChannelSpecifics.get(COLOR_GREEN);
        Integer b = (Integer) platformChannelSpecifics.get(COLOR_BLUE);
        if (a != null && r != null && g != null && b != null) {
            notificationDetails.color = Integer.valueOf(Color.argb(a.intValue(), r.intValue(), g.intValue(), b.intValue()));
        }
    }

    private static void readLedInformation(NotificationDetails notificationDetails, Map<String, Object> platformChannelSpecifics) {
        Integer a = (Integer) platformChannelSpecifics.get(LED_COLOR_ALPHA);
        Integer r = (Integer) platformChannelSpecifics.get(LED_COLOR_RED);
        Integer g = (Integer) platformChannelSpecifics.get(LED_COLOR_GREEN);
        Integer b = (Integer) platformChannelSpecifics.get(LED_COLOR_BLUE);
        if (a != null && r != null && g != null && b != null) {
            notificationDetails.ledColor = Integer.valueOf(Color.argb(a.intValue(), r.intValue(), g.intValue(), b.intValue()));
        }
        notificationDetails.enableLights = (Boolean) platformChannelSpecifics.get(ENABLE_LIGHTS);
        notificationDetails.ledOnMs = (Integer) platformChannelSpecifics.get(LED_ON_MS);
        notificationDetails.ledOffMs = (Integer) platformChannelSpecifics.get(LED_OFF_MS);
    }

    private static void readChannelInformation(NotificationDetails notificationDetails, Map<String, Object> platformChannelSpecifics) {
        if (Build.VERSION.SDK_INT >= 26) {
            notificationDetails.channelId = (String) platformChannelSpecifics.get(CHANNEL_ID);
            notificationDetails.channelName = (String) platformChannelSpecifics.get(CHANNEL_NAME);
            notificationDetails.channelDescription = (String) platformChannelSpecifics.get(CHANNEL_DESCRIPTION);
            notificationDetails.importance = (Integer) platformChannelSpecifics.get(IMPORTANCE);
            notificationDetails.channelShowBadge = (Boolean) platformChannelSpecifics.get(CHANNEL_SHOW_BADGE);
            notificationDetails.channelAction = NotificationChannelAction.values()[((Integer) platformChannelSpecifics.get(CHANNEL_ACTION)).intValue()];
        }
    }

    private static void readStyleInformation(NotificationDetails notificationDetails, Map<String, Object> platformSpecifics) {
        Map<String, Object> styleInformation = (Map) platformSpecifics.get(STYLE_INFORMATION);
        DefaultStyleInformation defaultStyleInformation = getDefaultStyleInformation(styleInformation);
        if (notificationDetails.style == NotificationStyle.Default) {
            notificationDetails.styleInformation = defaultStyleInformation;
        } else if (notificationDetails.style == NotificationStyle.BigPicture) {
            readBigPictureStyleInformation(notificationDetails, styleInformation, defaultStyleInformation);
        } else if (notificationDetails.style == NotificationStyle.BigText) {
            readBigTextStyleInformation(notificationDetails, styleInformation, defaultStyleInformation);
        } else if (notificationDetails.style == NotificationStyle.Inbox) {
            readInboxStyleInformation(notificationDetails, styleInformation, defaultStyleInformation);
        } else if (notificationDetails.style == NotificationStyle.Messaging) {
            readMessagingStyleInformation(notificationDetails, styleInformation, defaultStyleInformation);
        } else if (notificationDetails.style == NotificationStyle.Media) {
            notificationDetails.styleInformation = defaultStyleInformation;
        }
    }

    private static void readMessagingStyleInformation(NotificationDetails notificationDetails, Map<String, Object> styleInformation, DefaultStyleInformation defaultStyleInformation) {
        String conversationTitle = (String) styleInformation.get(CONVERSATION_TITLE);
        Boolean groupConversation = (Boolean) styleInformation.get(GROUP_CONVERSATION);
        PersonDetails person = readPersonDetails((Map) styleInformation.get(PERSON));
        ArrayList<MessageDetails> messages = readMessages((ArrayList) styleInformation.get(MESSAGES));
        notificationDetails.styleInformation = new MessagingStyleInformation(person, conversationTitle, groupConversation, messages, defaultStyleInformation.htmlFormatTitle, defaultStyleInformation.htmlFormatBody);
    }

    private static PersonDetails readPersonDetails(Map<String, Object> person) {
        if (person == null) {
            return null;
        }
        Boolean bot = (Boolean) person.get(BOT);
        Object icon = person.get(ICON);
        Integer iconSourceIndex = (Integer) person.get(ICON_SOURCE);
        IconSource iconSource = iconSourceIndex != null ? IconSource.values()[iconSourceIndex.intValue()] : null;
        Boolean important = (Boolean) person.get(IMPORTANT);
        String key = (String) person.get(KEY);
        String name = (String) person.get(NAME);
        String uri = (String) person.get(URI);
        return new PersonDetails(bot, icon, iconSource, important, key, name, uri);
    }

    private static ArrayList<MessageDetails> readMessages(ArrayList<Map<String, Object>> messages) {
        ArrayList<MessageDetails> result = new ArrayList<>();
        if (messages != null) {
            Iterator<Map<String, Object>> it = messages.iterator();
            while (it.hasNext()) {
                Map<String, Object> messageData = it.next();
                result.add(new MessageDetails((String) messageData.get(TEXT), LongUtils.parseLong(messageData.get(TIMESTAMP)), readPersonDetails((Map) messageData.get(PERSON)), (String) messageData.get(DATA_MIME_TYPE), (String) messageData.get(DATA_URI)));
            }
        }
        return result;
    }

    private static void readInboxStyleInformation(NotificationDetails notificationDetails, Map<String, Object> styleInformation, DefaultStyleInformation defaultStyleInformation) {
        String contentTitle = (String) styleInformation.get(CONTENT_TITLE);
        Boolean htmlFormatContentTitle = (Boolean) styleInformation.get(HTML_FORMAT_CONTENT_TITLE);
        String summaryText = (String) styleInformation.get(SUMMARY_TEXT);
        Boolean htmlFormatSummaryText = (Boolean) styleInformation.get(HTML_FORMAT_SUMMARY_TEXT);
        ArrayList<String> lines = (ArrayList) styleInformation.get(LINES);
        Boolean htmlFormatLines = (Boolean) styleInformation.get(HTML_FORMAT_LINES);
        notificationDetails.styleInformation = new InboxStyleInformation(defaultStyleInformation.htmlFormatTitle, defaultStyleInformation.htmlFormatBody, contentTitle, htmlFormatContentTitle, summaryText, htmlFormatSummaryText, lines, htmlFormatLines);
    }

    private static void readBigTextStyleInformation(NotificationDetails notificationDetails, Map<String, Object> styleInformation, DefaultStyleInformation defaultStyleInformation) {
        String bigText = (String) styleInformation.get(BIG_TEXT);
        Boolean htmlFormatBigText = (Boolean) styleInformation.get(HTML_FORMAT_BIG_TEXT);
        String contentTitle = (String) styleInformation.get(CONTENT_TITLE);
        Boolean htmlFormatContentTitle = (Boolean) styleInformation.get(HTML_FORMAT_CONTENT_TITLE);
        String summaryText = (String) styleInformation.get(SUMMARY_TEXT);
        Boolean htmlFormatSummaryText = (Boolean) styleInformation.get(HTML_FORMAT_SUMMARY_TEXT);
        notificationDetails.styleInformation = new BigTextStyleInformation(defaultStyleInformation.htmlFormatTitle, defaultStyleInformation.htmlFormatBody, bigText, htmlFormatBigText, contentTitle, htmlFormatContentTitle, summaryText, htmlFormatSummaryText);
    }

    private static void readBigPictureStyleInformation(NotificationDetails notificationDetails, Map<String, Object> styleInformation, DefaultStyleInformation defaultStyleInformation) {
        BitmapSource largeIconBitmapSource;
        String contentTitle = (String) styleInformation.get(CONTENT_TITLE);
        Boolean htmlFormatContentTitle = (Boolean) styleInformation.get(HTML_FORMAT_CONTENT_TITLE);
        String summaryText = (String) styleInformation.get(SUMMARY_TEXT);
        Boolean htmlFormatSummaryText = (Boolean) styleInformation.get(HTML_FORMAT_SUMMARY_TEXT);
        Object largeIcon = styleInformation.get(LARGE_ICON);
        if (!styleInformation.containsKey(LARGE_ICON_BITMAP_SOURCE)) {
            largeIconBitmapSource = null;
        } else {
            Integer largeIconBitmapSourceArgument = (Integer) styleInformation.get(LARGE_ICON_BITMAP_SOURCE);
            BitmapSource largeIconBitmapSource2 = BitmapSource.values()[largeIconBitmapSourceArgument.intValue()];
            largeIconBitmapSource = largeIconBitmapSource2;
        }
        Object bigPicture = styleInformation.get(BIG_PICTURE);
        Integer bigPictureBitmapSourceArgument = (Integer) styleInformation.get(BIG_PICTURE_BITMAP_SOURCE);
        BitmapSource bigPictureBitmapSource = BitmapSource.values()[bigPictureBitmapSourceArgument.intValue()];
        Boolean showThumbnail = (Boolean) styleInformation.get(HIDE_EXPANDED_LARGE_ICON);
        notificationDetails.styleInformation = new BigPictureStyleInformation(defaultStyleInformation.htmlFormatTitle, defaultStyleInformation.htmlFormatBody, contentTitle, htmlFormatContentTitle, summaryText, htmlFormatSummaryText, largeIcon, largeIconBitmapSource, bigPicture, bigPictureBitmapSource, showThumbnail);
    }

    private static DefaultStyleInformation getDefaultStyleInformation(Map<String, Object> styleInformation) {
        Boolean htmlFormatTitle = (Boolean) styleInformation.get(HTML_FORMAT_TITLE);
        Boolean htmlFormatBody = (Boolean) styleInformation.get(HTML_FORMAT_CONTENT);
        return new DefaultStyleInformation(htmlFormatTitle, htmlFormatBody);
    }
}
