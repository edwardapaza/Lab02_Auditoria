package com.dexterous.flutterlocalnotifications;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import androidx.core.app.AlarmManagerCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.Person;
import androidx.core.app.RemoteInput;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.media.app.NotificationCompat;
import com.dexterous.flutterlocalnotifications.isolate.IsolatePreferences;
import com.dexterous.flutterlocalnotifications.models.BitmapSource;
import com.dexterous.flutterlocalnotifications.models.DateTimeComponents;
import com.dexterous.flutterlocalnotifications.models.IconSource;
import com.dexterous.flutterlocalnotifications.models.MessageDetails;
import com.dexterous.flutterlocalnotifications.models.NotificationAction;
import com.dexterous.flutterlocalnotifications.models.NotificationChannelAction;
import com.dexterous.flutterlocalnotifications.models.NotificationChannelDetails;
import com.dexterous.flutterlocalnotifications.models.NotificationChannelGroupDetails;
import com.dexterous.flutterlocalnotifications.models.NotificationDetails;
import com.dexterous.flutterlocalnotifications.models.NotificationStyle;
import com.dexterous.flutterlocalnotifications.models.PersonDetails;
import com.dexterous.flutterlocalnotifications.models.RepeatInterval;
import com.dexterous.flutterlocalnotifications.models.ScheduleMode;
import com.dexterous.flutterlocalnotifications.models.ScheduledNotificationRepeatFrequency;
import com.dexterous.flutterlocalnotifications.models.SoundSource;
import com.dexterous.flutterlocalnotifications.models.styles.BigPictureStyleInformation;
import com.dexterous.flutterlocalnotifications.models.styles.BigTextStyleInformation;
import com.dexterous.flutterlocalnotifications.models.styles.DefaultStyleInformation;
import com.dexterous.flutterlocalnotifications.models.styles.InboxStyleInformation;
import com.dexterous.flutterlocalnotifications.models.styles.MessagingStyleInformation;
import com.dexterous.flutterlocalnotifications.models.styles.StyleInformation;
import com.dexterous.flutterlocalnotifications.utils.BooleanUtils;
import com.dexterous.flutterlocalnotifications.utils.LongUtils;
import com.dexterous.flutterlocalnotifications.utils.StringUtils;
import com.google.firebase.messaging.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import io.flutter.FlutterInjector;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class FlutterLocalNotificationsPlugin implements MethodChannel.MethodCallHandler, PluginRegistry.NewIntentListener, PluginRegistry.RequestPermissionsResultListener, PluginRegistry.ActivityResultListener, FlutterPlugin, ActivityAware {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String ACTION_ID = "actionId";
    private static final String ARE_NOTIFICATIONS_ENABLED_METHOD = "areNotificationsEnabled";
    private static final String CALLBACK_HANDLE = "callback_handle";
    private static final String CANCEL_ALL_METHOD = "cancelAll";
    private static final String CANCEL_ID = "id";
    private static final String CANCEL_METHOD = "cancel";
    static final String CANCEL_NOTIFICATION = "cancelNotification";
    private static final String CANCEL_TAG = "tag";
    private static final String CAN_SCHEDULE_EXACT_NOTIFICATIONS_METHOD = "canScheduleExactNotifications";
    private static final String CREATE_NOTIFICATION_CHANNEL_GROUP_METHOD = "createNotificationChannelGroup";
    private static final String CREATE_NOTIFICATION_CHANNEL_METHOD = "createNotificationChannel";
    private static final String DEFAULT_ICON = "defaultIcon";
    private static final String DELETE_NOTIFICATION_CHANNEL_GROUP_METHOD = "deleteNotificationChannelGroup";
    private static final String DELETE_NOTIFICATION_CHANNEL_METHOD = "deleteNotificationChannel";
    private static final String DISPATCHER_HANDLE = "dispatcher_handle";
    private static final String DRAWABLE = "drawable";
    private static final String EXACT_ALARMS_PERMISSION_ERROR_CODE = "exact_alarms_not_permitted";
    static final int EXACT_ALARM_PERMISSION_REQUEST_CODE = 2;
    private static final String GET_ACTIVE_NOTIFICATIONS_ERROR_MESSAGE = "Android version must be 6.0 or newer to use getActiveNotifications";
    private static final String GET_ACTIVE_NOTIFICATIONS_METHOD = "getActiveNotifications";
    private static final String GET_ACTIVE_NOTIFICATION_MESSAGING_STYLE_ERROR_CODE = "getActiveNotificationMessagingStyleError";
    private static final String GET_ACTIVE_NOTIFICATION_MESSAGING_STYLE_METHOD = "getActiveNotificationMessagingStyle";
    private static final String GET_CALLBACK_HANDLE_METHOD = "getCallbackHandle";
    private static final String GET_NOTIFICATION_APP_LAUNCH_DETAILS_METHOD = "getNotificationAppLaunchDetails";
    private static final String GET_NOTIFICATION_CHANNELS_ERROR_CODE = "getNotificationChannelsError";
    private static final String GET_NOTIFICATION_CHANNELS_METHOD = "getNotificationChannels";
    private static final String INITIALIZE_METHOD = "initialize";
    private static final String INPUT = "input";
    private static final String INPUT_RESULT = "FlutterLocalNotificationsPluginInputResult";
    private static final String INVALID_BIG_PICTURE_ERROR_CODE = "invalid_big_picture";
    private static final String INVALID_DRAWABLE_RESOURCE_ERROR_MESSAGE = "The resource %s could not be found. Please make sure it has been added as a drawable resource to your Android head project.";
    private static final String INVALID_ICON_ERROR_CODE = "invalid_icon";
    private static final String INVALID_LARGE_ICON_ERROR_CODE = "invalid_large_icon";
    private static final String INVALID_LED_DETAILS_ERROR_CODE = "invalid_led_details";
    private static final String INVALID_LED_DETAILS_ERROR_MESSAGE = "Must specify both ledOnMs and ledOffMs to configure the blink cycle on older versions of Android before Oreo";
    private static final String INVALID_RAW_RESOURCE_ERROR_MESSAGE = "The resource %s could not be found. Please make sure it has been added as a raw resource to your Android head project.";
    private static final String INVALID_SOUND_ERROR_CODE = "invalid_sound";
    private static final String METHOD_CHANNEL = "dexterous.com/flutter/local_notifications";
    static String NOTIFICATION_DETAILS = "notificationDetails";
    static final String NOTIFICATION_ID = "notificationId";
    private static final String NOTIFICATION_LAUNCHED_APP = "notificationLaunchedApp";
    static final int NOTIFICATION_PERMISSION_REQUEST_CODE = 1;
    private static final String NOTIFICATION_RESPONSE_TYPE = "notificationResponseType";
    static final String PAYLOAD = "payload";
    private static final String PENDING_NOTIFICATION_REQUESTS_METHOD = "pendingNotificationRequests";
    private static final String PERIODICALLY_SHOW_METHOD = "periodicallyShow";
    private static final String PERMISSION_REQUEST_IN_PROGRESS_ERROR_CODE = "permissionRequestInProgress";
    private static final String PERMISSION_REQUEST_IN_PROGRESS_ERROR_MESSAGE = "Another permission request is already in progress";
    private static final String REQUEST_EXACT_ALARMS_PERMISSION_METHOD = "requestExactAlarmsPermission";
    private static final String REQUEST_NOTIFICATIONS_PERMISSION_METHOD = "requestNotificationsPermission";
    private static final String SCHEDULED_NOTIFICATIONS = "scheduled_notifications";
    private static final String SELECT_FOREGROUND_NOTIFICATION_ACTION = "SELECT_FOREGROUND_NOTIFICATION";
    private static final String SELECT_NOTIFICATION = "SELECT_NOTIFICATION";
    private static final String SHARED_PREFERENCES_KEY = "notification_plugin_cache";
    private static final String SHOW_METHOD = "show";
    private static final String START_FOREGROUND_SERVICE = "startForegroundService";
    private static final String STOP_FOREGROUND_SERVICE = "stopForegroundService";
    private static final String TAG = "FLTLocalNotifPlugin";
    private static final String UNSUPPORTED_OS_VERSION_ERROR_CODE = "unsupported_os_version";
    private static final String ZONED_SCHEDULE_METHOD = "zonedSchedule";
    static Gson gson;
    private Context applicationContext;
    private PermissionRequestListener callback;
    private MethodChannel channel;
    private Activity mainActivity;
    private PermissionRequestProgress permissionRequestProgress = PermissionRequestProgress.None;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public enum PermissionRequestProgress {
        None,
        RequestingNotificationPermission,
        RequestingExactAlarmsPermission
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void rescheduleNotifications(Context context) {
        ArrayList<NotificationDetails> scheduledNotifications = loadScheduledNotifications(context);
        Iterator<NotificationDetails> it = scheduledNotifications.iterator();
        while (it.hasNext()) {
            NotificationDetails notificationDetails = it.next();
            try {
                if (notificationDetails.repeatInterval != null) {
                    repeatNotification(context, notificationDetails, false);
                } else if (notificationDetails.timeZoneName != null) {
                    zonedScheduleNotification(context, notificationDetails, false);
                } else {
                    scheduleNotification(context, notificationDetails, false);
                }
            } catch (ExactAlarmPermissionException e) {
                Log.e(TAG, e.getMessage());
                removeNotificationFromCache(context, notificationDetails.id);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void scheduleNextNotification(Context context, NotificationDetails notificationDetails) {
        try {
            if (notificationDetails.scheduledNotificationRepeatFrequency != null) {
                zonedScheduleNextNotification(context, notificationDetails);
            } else if (notificationDetails.matchDateTimeComponents != null) {
                zonedScheduleNextNotificationMatchingDateComponents(context, notificationDetails);
            } else if (notificationDetails.repeatInterval != null) {
                scheduleNextRepeatingNotification(context, notificationDetails);
            } else {
                removeNotificationFromCache(context, notificationDetails.id);
            }
        } catch (ExactAlarmPermissionException e) {
            Log.e(TAG, e.getMessage());
            removeNotificationFromCache(context, notificationDetails.id);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Notification createNotification(Context context, NotificationDetails notificationDetails) {
        CharSequence charSequence;
        CharSequence charSequence2;
        int[] iArr;
        IconCompat icon;
        Intent actionIntent;
        int requestCode;
        PendingIntent actionPendingIntent;
        int requestCode2;
        int flags;
        String str;
        String str2;
        NotificationChannelDetails notificationChannelDetails = NotificationChannelDetails.fromNotificationDetails(notificationDetails);
        if (canCreateNotificationChannel(context, notificationChannelDetails).booleanValue()) {
            setupNotificationChannel(context, notificationChannelDetails);
        }
        Intent intent = getLaunchIntent(context);
        intent.setAction(SELECT_NOTIFICATION);
        Integer num = notificationDetails.id;
        String str3 = NOTIFICATION_ID;
        intent.putExtra(NOTIFICATION_ID, num);
        String str4 = notificationDetails.payload;
        String str5 = PAYLOAD;
        intent.putExtra(PAYLOAD, str4);
        int flags2 = 134217728;
        if (Build.VERSION.SDK_INT >= 23) {
            flags2 = 134217728 | AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
        }
        PendingIntent pendingIntent = PendingIntent.getActivity(context, notificationDetails.id.intValue(), intent, flags2);
        DefaultStyleInformation defaultStyleInformation = (DefaultStyleInformation) notificationDetails.styleInformation;
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, notificationDetails.channelId);
        if (defaultStyleInformation.htmlFormatTitle.booleanValue()) {
            charSequence = fromHtml(notificationDetails.title);
        } else {
            charSequence = notificationDetails.title;
        }
        NotificationCompat.Builder contentTitle = builder.setContentTitle(charSequence);
        if (defaultStyleInformation.htmlFormatBody.booleanValue()) {
            charSequence2 = fromHtml(notificationDetails.body);
        } else {
            charSequence2 = notificationDetails.body;
        }
        NotificationCompat.Builder builder2 = contentTitle.setContentText(charSequence2).setTicker(notificationDetails.ticker).setAutoCancel(BooleanUtils.getValue(notificationDetails.autoCancel)).setContentIntent(pendingIntent).setPriority(notificationDetails.priority.intValue()).setOngoing(BooleanUtils.getValue(notificationDetails.ongoing)).setSilent(BooleanUtils.getValue(notificationDetails.silent)).setOnlyAlertOnce(BooleanUtils.getValue(notificationDetails.onlyAlertOnce));
        if (notificationDetails.actions != null) {
            int requestCode3 = notificationDetails.id.intValue() * 16;
            for (NotificationAction action : notificationDetails.actions) {
                if (!TextUtils.isEmpty(action.icon) && action.iconSource != null) {
                    IconCompat icon2 = getIconFromSource(context, action.icon, action.iconSource);
                    icon = icon2;
                } else {
                    icon = null;
                }
                if (action.showsUserInterface == null || !action.showsUserInterface.booleanValue()) {
                    actionIntent = new Intent(context, ActionBroadcastReceiver.class);
                    actionIntent.setAction(ActionBroadcastReceiver.ACTION_TAPPED);
                } else {
                    actionIntent = getLaunchIntent(context);
                    actionIntent.setAction(SELECT_FOREGROUND_NOTIFICATION_ACTION);
                }
                NotificationChannelDetails notificationChannelDetails2 = notificationChannelDetails;
                Intent intent2 = intent;
                actionIntent.putExtra(str3, notificationDetails.id).putExtra(ACTION_ID, action.id).putExtra(CANCEL_NOTIFICATION, action.cancelNotification).putExtra(str5, notificationDetails.payload);
                int actionFlags = 134217728;
                if (action.actionInputs == null || action.actionInputs.isEmpty()) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        actionFlags = 134217728 | AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                    }
                } else if (Build.VERSION.SDK_INT >= 31) {
                    actionFlags = 134217728 | 33554432;
                }
                if (action.showsUserInterface != null && action.showsUserInterface.booleanValue()) {
                    requestCode = requestCode3 + 1;
                    actionPendingIntent = PendingIntent.getActivity(context, requestCode3, actionIntent, actionFlags);
                } else {
                    requestCode = requestCode3 + 1;
                    actionPendingIntent = PendingIntent.getBroadcast(context, requestCode3, actionIntent, actionFlags);
                }
                Spannable actionTitleSpannable = new SpannableString(action.title);
                if (action.titleColor == null) {
                    requestCode2 = requestCode;
                    flags = flags2;
                } else {
                    requestCode2 = requestCode;
                    flags = flags2;
                    actionTitleSpannable.setSpan(new ForegroundColorSpan(action.titleColor.intValue()), 0, actionTitleSpannable.length(), 0);
                }
                NotificationCompat.Action.Builder actionBuilder = new NotificationCompat.Action.Builder(icon, actionTitleSpannable, actionPendingIntent);
                if (action.contextual != null) {
                    actionBuilder.setContextual(action.contextual.booleanValue());
                }
                if (action.showsUserInterface != null) {
                    actionBuilder.setShowsUserInterface(action.showsUserInterface.booleanValue());
                }
                if (action.allowGeneratedReplies != null) {
                    actionBuilder.setAllowGeneratedReplies(action.allowGeneratedReplies.booleanValue());
                }
                if (action.actionInputs != null) {
                    Iterator<NotificationAction.NotificationActionInput> it = action.actionInputs.iterator();
                    while (it.hasNext()) {
                        NotificationAction.NotificationActionInput input = it.next();
                        Spannable actionTitleSpannable2 = actionTitleSpannable;
                        Iterator<NotificationAction.NotificationActionInput> it2 = it;
                        RemoteInput.Builder remoteInput = new RemoteInput.Builder(INPUT_RESULT).setLabel(input.label);
                        if (input.allowFreeFormInput != null) {
                            remoteInput.setAllowFreeFormInput(input.allowFreeFormInput.booleanValue());
                        }
                        if (input.allowedMimeTypes == null) {
                            str = str3;
                        } else {
                            Iterator<String> it3 = input.allowedMimeTypes.iterator();
                            while (it3.hasNext()) {
                                Iterator<String> it4 = it3;
                                String mimeType = it3.next();
                                remoteInput.setAllowDataType(mimeType, true);
                                str3 = str3;
                                it3 = it4;
                            }
                            str = str3;
                        }
                        if (input.choices == null) {
                            str2 = str5;
                        } else {
                            str2 = str5;
                            remoteInput.setChoices((CharSequence[]) input.choices.toArray(new CharSequence[0]));
                        }
                        actionBuilder.addRemoteInput(remoteInput.build());
                        str5 = str2;
                        actionTitleSpannable = actionTitleSpannable2;
                        it = it2;
                        str3 = str;
                    }
                }
                builder2.addAction(actionBuilder.build());
                str5 = str5;
                notificationChannelDetails = notificationChannelDetails2;
                intent = intent2;
                requestCode3 = requestCode2;
                flags2 = flags;
                str3 = str3;
            }
        }
        setSmallIcon(context, notificationDetails, builder2);
        builder2.setLargeIcon(getBitmapFromSource(context, notificationDetails.largeIcon, notificationDetails.largeIconBitmapSource));
        if (notificationDetails.color != null) {
            builder2.setColor(notificationDetails.color.intValue());
        }
        if (notificationDetails.colorized != null) {
            builder2.setColorized(notificationDetails.colorized.booleanValue());
        }
        if (notificationDetails.showWhen != null) {
            builder2.setShowWhen(BooleanUtils.getValue(notificationDetails.showWhen));
        }
        if (notificationDetails.when != null) {
            builder2.setWhen(notificationDetails.when.longValue());
        }
        if (notificationDetails.usesChronometer != null) {
            builder2.setUsesChronometer(notificationDetails.usesChronometer.booleanValue());
        }
        if (notificationDetails.chronometerCountDown != null && Build.VERSION.SDK_INT >= 24) {
            builder2.setChronometerCountDown(notificationDetails.chronometerCountDown.booleanValue());
        }
        if (BooleanUtils.getValue(notificationDetails.fullScreenIntent)) {
            builder2.setFullScreenIntent(pendingIntent, true);
        }
        if (!StringUtils.isNullOrEmpty(notificationDetails.shortcutId).booleanValue()) {
            builder2.setShortcutId(notificationDetails.shortcutId);
        }
        if (!StringUtils.isNullOrEmpty(notificationDetails.subText).booleanValue()) {
            builder2.setSubText(notificationDetails.subText);
        }
        if (notificationDetails.number != null) {
            builder2.setNumber(notificationDetails.number.intValue());
        }
        setVisibility(notificationDetails, builder2);
        applyGrouping(notificationDetails, builder2);
        setSound(context, notificationDetails, builder2);
        setVibrationPattern(notificationDetails, builder2);
        setLights(notificationDetails, builder2);
        setStyle(context, notificationDetails, builder2);
        setProgress(notificationDetails, builder2);
        setCategory(notificationDetails, builder2);
        setTimeoutAfter(notificationDetails, builder2);
        Notification notification = builder2.build();
        if (notificationDetails.additionalFlags != null && notificationDetails.additionalFlags.length > 0) {
            for (int additionalFlag : notificationDetails.additionalFlags) {
                notification.flags |= additionalFlag;
            }
        }
        return notification;
    }

    private static Boolean canCreateNotificationChannel(Context context, NotificationChannelDetails notificationChannelDetails) {
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel(notificationChannelDetails.id);
            if ((notificationChannel == null && (notificationChannelDetails.channelAction == null || notificationChannelDetails.channelAction == NotificationChannelAction.CreateIfNotExists)) || (notificationChannel != null && notificationChannelDetails.channelAction == NotificationChannelAction.Update)) {
                z = true;
            }
            return Boolean.valueOf(z);
        }
        return false;
    }

    private static void setSmallIcon(Context context, NotificationDetails notificationDetails, NotificationCompat.Builder builder) {
        if (!StringUtils.isNullOrEmpty(notificationDetails.icon).booleanValue()) {
            builder.setSmallIcon(getDrawableResourceId(context, notificationDetails.icon));
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_KEY, 0);
        String defaultIcon = sharedPreferences.getString(DEFAULT_ICON, null);
        if (StringUtils.isNullOrEmpty(defaultIcon).booleanValue()) {
            builder.setSmallIcon(notificationDetails.iconResourceId.intValue());
        } else {
            builder.setSmallIcon(getDrawableResourceId(context, defaultIcon));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Gson buildGson() {
        if (gson == null) {
            RuntimeTypeAdapterFactory<StyleInformation> styleInformationAdapter = RuntimeTypeAdapterFactory.of(StyleInformation.class).registerSubtype(DefaultStyleInformation.class).registerSubtype(BigTextStyleInformation.class).registerSubtype(BigPictureStyleInformation.class).registerSubtype(InboxStyleInformation.class).registerSubtype(MessagingStyleInformation.class);
            GsonBuilder builder = new GsonBuilder().registerTypeAdapter(ScheduleMode.class, new ScheduleMode.Deserializer()).registerTypeAdapterFactory(styleInformationAdapter);
            gson = builder.create();
        }
        return gson;
    }

    private static ArrayList<NotificationDetails> loadScheduledNotifications(Context context) {
        ArrayList<NotificationDetails> scheduledNotifications = new ArrayList<>();
        SharedPreferences sharedPreferences = context.getSharedPreferences(SCHEDULED_NOTIFICATIONS, 0);
        String json = sharedPreferences.getString(SCHEDULED_NOTIFICATIONS, null);
        if (json != null) {
            Gson gson2 = buildGson();
            Type type = new TypeToken<ArrayList<NotificationDetails>>() { // from class: com.dexterous.flutterlocalnotifications.FlutterLocalNotificationsPlugin.1
            }.getType();
            ArrayList<NotificationDetails> scheduledNotifications2 = (ArrayList) gson2.fromJson(json, type);
            return scheduledNotifications2;
        }
        return scheduledNotifications;
    }

    private static void saveScheduledNotifications(Context context, ArrayList<NotificationDetails> scheduledNotifications) {
        Gson gson2 = buildGson();
        String json = gson2.toJson(scheduledNotifications);
        SharedPreferences sharedPreferences = context.getSharedPreferences(SCHEDULED_NOTIFICATIONS, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SCHEDULED_NOTIFICATIONS, json).apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void removeNotificationFromCache(Context context, Integer notificationId) {
        ArrayList<NotificationDetails> scheduledNotifications = loadScheduledNotifications(context);
        Iterator<NotificationDetails> it = scheduledNotifications.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            NotificationDetails notificationDetails = it.next();
            if (notificationDetails.id.equals(notificationId)) {
                it.remove();
                break;
            }
        }
        saveScheduledNotifications(context, scheduledNotifications);
    }

    private static Spanned fromHtml(String html) {
        if (html == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            return Html.fromHtml(html, 0);
        }
        return Html.fromHtml(html);
    }

    private static void scheduleNotification(Context context, NotificationDetails notificationDetails, Boolean updateScheduledNotificationsCache) {
        Gson gson2 = buildGson();
        String notificationDetailsJson = gson2.toJson(notificationDetails);
        Intent notificationIntent = new Intent(context, ScheduledNotificationReceiver.class);
        notificationIntent.putExtra(NOTIFICATION_DETAILS, notificationDetailsJson);
        PendingIntent pendingIntent = getBroadcastPendingIntent(context, notificationDetails.id.intValue(), notificationIntent);
        AlarmManager alarmManager = getAlarmManager(context);
        setupAlarm(notificationDetails, alarmManager, notificationDetails.millisecondsSinceEpoch.longValue(), pendingIntent);
        if (updateScheduledNotificationsCache.booleanValue()) {
            saveScheduledNotification(context, notificationDetails);
        }
    }

    private static void zonedScheduleNotification(Context context, NotificationDetails notificationDetails, Boolean updateScheduledNotificationsCache) {
        Gson gson2 = buildGson();
        String notificationDetailsJson = gson2.toJson(notificationDetails);
        Intent notificationIntent = new Intent(context, ScheduledNotificationReceiver.class);
        notificationIntent.putExtra(NOTIFICATION_DETAILS, notificationDetailsJson);
        PendingIntent pendingIntent = getBroadcastPendingIntent(context, notificationDetails.id.intValue(), notificationIntent);
        AlarmManager alarmManager = getAlarmManager(context);
        long epochMilli = ZonedDateTime.of(LocalDateTime.parse(notificationDetails.scheduledDateTime), ZoneId.of(notificationDetails.timeZoneName)).toInstant().toEpochMilli();
        setupAlarm(notificationDetails, alarmManager, epochMilli, pendingIntent);
        if (updateScheduledNotificationsCache.booleanValue()) {
            saveScheduledNotification(context, notificationDetails);
        }
    }

    private static void scheduleNextRepeatingNotification(Context context, NotificationDetails notificationDetails) {
        long repeatInterval = calculateRepeatIntervalMilliseconds(notificationDetails);
        long notificationTriggerTime = calculateNextNotificationTrigger(notificationDetails.calledAt.longValue(), repeatInterval);
        Gson gson2 = buildGson();
        String notificationDetailsJson = gson2.toJson(notificationDetails);
        Intent notificationIntent = new Intent(context, ScheduledNotificationReceiver.class);
        notificationIntent.putExtra(NOTIFICATION_DETAILS, notificationDetailsJson);
        PendingIntent pendingIntent = getBroadcastPendingIntent(context, notificationDetails.id.intValue(), notificationIntent);
        AlarmManager alarmManager = getAlarmManager(context);
        if (notificationDetails.scheduleMode == null) {
            notificationDetails.scheduleMode = ScheduleMode.exactAllowWhileIdle;
        }
        setupAllowWhileIdleAlarm(notificationDetails, alarmManager, notificationTriggerTime, pendingIntent);
        saveScheduledNotification(context, notificationDetails);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, Object> extractNotificationResponseMap(Intent intent) {
        int notificationId = intent.getIntExtra(NOTIFICATION_ID, 0);
        Map<String, Object> notificationResponseMap = new HashMap<>();
        notificationResponseMap.put(NOTIFICATION_ID, Integer.valueOf(notificationId));
        notificationResponseMap.put(ACTION_ID, intent.getStringExtra(ACTION_ID));
        notificationResponseMap.put(PAYLOAD, intent.getStringExtra(PAYLOAD));
        Bundle remoteInput = RemoteInput.getResultsFromIntent(intent);
        if (remoteInput != null) {
            notificationResponseMap.put(INPUT, remoteInput.getString(INPUT_RESULT));
        }
        if (SELECT_NOTIFICATION.equals(intent.getAction())) {
            notificationResponseMap.put(NOTIFICATION_RESPONSE_TYPE, 0);
        }
        if (SELECT_FOREGROUND_NOTIFICATION_ACTION.equals(intent.getAction())) {
            notificationResponseMap.put(NOTIFICATION_RESPONSE_TYPE, 1);
        }
        return notificationResponseMap;
    }

    private static PendingIntent getBroadcastPendingIntent(Context context, int id, Intent intent) {
        int flags = Build.VERSION.SDK_INT >= 23 ? 134217728 | AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 134217728;
        return PendingIntent.getBroadcast(context, id, intent, flags);
    }

    private static void repeatNotification(Context context, NotificationDetails notificationDetails, Boolean updateScheduledNotificationsCache) {
        long repeatInterval = calculateRepeatIntervalMilliseconds(notificationDetails);
        long notificationTriggerTime = notificationDetails.calledAt.longValue();
        if (notificationDetails.repeatTime != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            calendar.set(11, notificationDetails.repeatTime.hour.intValue());
            calendar.set(12, notificationDetails.repeatTime.minute.intValue());
            calendar.set(13, notificationDetails.repeatTime.second.intValue());
            if (notificationDetails.day != null) {
                calendar.set(7, notificationDetails.day.intValue());
            }
            notificationTriggerTime = calendar.getTimeInMillis();
        }
        long notificationTriggerTime2 = calculateNextNotificationTrigger(notificationTriggerTime, repeatInterval);
        Gson gson2 = buildGson();
        String notificationDetailsJson = gson2.toJson(notificationDetails);
        Intent notificationIntent = new Intent(context, ScheduledNotificationReceiver.class);
        notificationIntent.putExtra(NOTIFICATION_DETAILS, notificationDetailsJson);
        PendingIntent pendingIntent = getBroadcastPendingIntent(context, notificationDetails.id.intValue(), notificationIntent);
        AlarmManager alarmManager = getAlarmManager(context);
        if (notificationDetails.scheduleMode == null) {
            notificationDetails.scheduleMode = ScheduleMode.inexact;
        }
        if (notificationDetails.scheduleMode.useAllowWhileIdle()) {
            setupAllowWhileIdleAlarm(notificationDetails, alarmManager, notificationTriggerTime2, pendingIntent);
        } else {
            alarmManager.setInexactRepeating(0, notificationTriggerTime2, repeatInterval, pendingIntent);
        }
        if (updateScheduledNotificationsCache.booleanValue()) {
            saveScheduledNotification(context, notificationDetails);
        }
    }

    private static void setupAlarm(NotificationDetails notificationDetails, AlarmManager alarmManager, long epochMilli, PendingIntent pendingIntent) {
        if (notificationDetails.scheduleMode == null) {
            notificationDetails.scheduleMode = ScheduleMode.exact;
        }
        if (notificationDetails.scheduleMode.useAllowWhileIdle()) {
            setupAllowWhileIdleAlarm(notificationDetails, alarmManager, epochMilli, pendingIntent);
        } else if (notificationDetails.scheduleMode.useExactAlarm()) {
            checkCanScheduleExactAlarms(alarmManager);
            AlarmManagerCompat.setExact(alarmManager, 0, epochMilli, pendingIntent);
        } else if (notificationDetails.scheduleMode.useAlarmClock()) {
            checkCanScheduleExactAlarms(alarmManager);
            AlarmManagerCompat.setAlarmClock(alarmManager, epochMilli, pendingIntent, pendingIntent);
        } else {
            alarmManager.set(0, epochMilli, pendingIntent);
        }
    }

    private static void setupAllowWhileIdleAlarm(NotificationDetails notificationDetails, AlarmManager alarmManager, long epochMilli, PendingIntent pendingIntent) {
        if (notificationDetails.scheduleMode.useExactAlarm()) {
            checkCanScheduleExactAlarms(alarmManager);
            AlarmManagerCompat.setExactAndAllowWhileIdle(alarmManager, 0, epochMilli, pendingIntent);
        } else if (notificationDetails.scheduleMode.useAlarmClock()) {
            checkCanScheduleExactAlarms(alarmManager);
            AlarmManagerCompat.setAlarmClock(alarmManager, epochMilli, pendingIntent, pendingIntent);
        } else {
            AlarmManagerCompat.setAndAllowWhileIdle(alarmManager, 0, epochMilli, pendingIntent);
        }
    }

    private static void checkCanScheduleExactAlarms(AlarmManager alarmManager) {
        if (Build.VERSION.SDK_INT >= 31 && !alarmManager.canScheduleExactAlarms()) {
            throw new ExactAlarmPermissionException();
        }
    }

    private static long calculateNextNotificationTrigger(long notificationTriggerTime, long repeatInterval) {
        long currentTime = System.currentTimeMillis();
        while (notificationTriggerTime < currentTime) {
            notificationTriggerTime += repeatInterval;
        }
        return notificationTriggerTime;
    }

    private static long calculateRepeatIntervalMilliseconds(NotificationDetails notificationDetails) {
        switch (AnonymousClass4.$SwitchMap$com$dexterous$flutterlocalnotifications$models$RepeatInterval[notificationDetails.repeatInterval.ordinal()]) {
            case 1:
                return 60000L;
            case 2:
                return 3600000L;
            case 3:
                return 86400000L;
            case 4:
                return 604800000L;
            default:
                return 0L;
        }
    }

    private static void saveScheduledNotification(Context context, NotificationDetails notificationDetails) {
        ArrayList<NotificationDetails> scheduledNotifications = loadScheduledNotifications(context);
        ArrayList<NotificationDetails> scheduledNotificationsToSave = new ArrayList<>();
        Iterator<NotificationDetails> it = scheduledNotifications.iterator();
        while (it.hasNext()) {
            NotificationDetails scheduledNotification = it.next();
            if (!scheduledNotification.id.equals(notificationDetails.id)) {
                scheduledNotificationsToSave.add(scheduledNotification);
            }
        }
        scheduledNotificationsToSave.add(notificationDetails);
        saveScheduledNotifications(context, scheduledNotificationsToSave);
    }

    private static int getDrawableResourceId(Context context, String name) {
        return context.getResources().getIdentifier(name, DRAWABLE, context.getPackageName());
    }

    private static byte[] castObjectToByteArray(Object data) {
        if (data instanceof ArrayList) {
            List<Double> l = (ArrayList) data;
            byte[] byteArray = new byte[l.size()];
            for (int i = 0; i < l.size(); i++) {
                byteArray[i] = (byte) l.get(i).intValue();
            }
            return byteArray;
        }
        return (byte[]) data;
    }

    private static Bitmap getBitmapFromSource(Context context, Object data, BitmapSource bitmapSource) {
        if (bitmapSource == BitmapSource.DrawableResource) {
            Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), getDrawableResourceId(context, (String) data));
            return bitmap;
        } else if (bitmapSource == BitmapSource.FilePath) {
            Bitmap bitmap2 = BitmapFactory.decodeFile((String) data);
            return bitmap2;
        } else if (bitmapSource != BitmapSource.ByteArray) {
            return null;
        } else {
            byte[] byteArray = castObjectToByteArray(data);
            Bitmap bitmap3 = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            return bitmap3;
        }
    }

    private static IconCompat getIconFromSource(Context context, Object data, IconSource iconSource) {
        switch (AnonymousClass4.$SwitchMap$com$dexterous$flutterlocalnotifications$models$IconSource[iconSource.ordinal()]) {
            case 1:
                IconCompat icon = IconCompat.createWithResource(context, getDrawableResourceId(context, (String) data));
                return icon;
            case 2:
                IconCompat icon2 = IconCompat.createWithBitmap(BitmapFactory.decodeFile((String) data));
                return icon2;
            case 3:
                IconCompat icon3 = IconCompat.createWithContentUri((String) data);
                return icon3;
            case 4:
                try {
                    FlutterLoader flutterLoader = FlutterInjector.instance().flutterLoader();
                    AssetFileDescriptor assetFileDescriptor = context.getAssets().openFd(flutterLoader.getLookupKeyForAsset((String) data));
                    FileInputStream fileInputStream = assetFileDescriptor.createInputStream();
                    IconCompat icon4 = IconCompat.createWithBitmap(BitmapFactory.decodeStream(fileInputStream));
                    fileInputStream.close();
                    assetFileDescriptor.close();
                    return icon4;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            case 5:
                byte[] byteArray = castObjectToByteArray(data);
                IconCompat icon5 = IconCompat.createWithData(byteArray, 0, byteArray.length);
                return icon5;
            default:
                return null;
        }
    }

    private static void setVisibility(NotificationDetails notificationDetails, NotificationCompat.Builder builder) {
        int visibility;
        if (notificationDetails.visibility == null) {
            return;
        }
        switch (notificationDetails.visibility.intValue()) {
            case 0:
                visibility = 0;
                break;
            case 1:
                visibility = 1;
                break;
            case 2:
                visibility = -1;
                break;
            default:
                throw new IllegalArgumentException("Unknown index: " + notificationDetails.visibility);
        }
        builder.setVisibility(visibility);
    }

    private static void applyGrouping(NotificationDetails notificationDetails, NotificationCompat.Builder builder) {
        boolean isGrouped = false;
        if (!StringUtils.isNullOrEmpty(notificationDetails.groupKey).booleanValue()) {
            builder.setGroup(notificationDetails.groupKey);
            isGrouped = true;
        }
        if (isGrouped) {
            if (BooleanUtils.getValue(notificationDetails.setAsGroupSummary)) {
                builder.setGroupSummary(true);
            }
            builder.setGroupAlertBehavior(notificationDetails.groupAlertBehavior.intValue());
        }
    }

    private static void setVibrationPattern(NotificationDetails notificationDetails, NotificationCompat.Builder builder) {
        if (BooleanUtils.getValue(notificationDetails.enableVibration)) {
            if (notificationDetails.vibrationPattern != null && notificationDetails.vibrationPattern.length > 0) {
                builder.setVibrate(notificationDetails.vibrationPattern);
                return;
            }
            return;
        }
        builder.setVibrate(new long[]{0});
    }

    private static void setLights(NotificationDetails notificationDetails, NotificationCompat.Builder builder) {
        if (BooleanUtils.getValue(notificationDetails.enableLights) && notificationDetails.ledOnMs != null && notificationDetails.ledOffMs != null) {
            builder.setLights(notificationDetails.ledColor.intValue(), notificationDetails.ledOnMs.intValue(), notificationDetails.ledOffMs.intValue());
        }
    }

    private static void setSound(Context context, NotificationDetails notificationDetails, NotificationCompat.Builder builder) {
        if (BooleanUtils.getValue(notificationDetails.playSound)) {
            Uri uri = retrieveSoundResourceUri(context, notificationDetails.sound, notificationDetails.soundSource);
            builder.setSound(uri);
            return;
        }
        builder.setSound(null);
    }

    private static void setCategory(NotificationDetails notificationDetails, NotificationCompat.Builder builder) {
        if (notificationDetails.category == null) {
            return;
        }
        builder.setCategory(notificationDetails.category);
    }

    private static void setTimeoutAfter(NotificationDetails notificationDetails, NotificationCompat.Builder builder) {
        if (notificationDetails.timeoutAfter == null) {
            return;
        }
        builder.setTimeoutAfter(notificationDetails.timeoutAfter.longValue());
    }

    private static Intent getLaunchIntent(Context context) {
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getPackageManager();
        return packageManager.getLaunchIntentForPackage(packageName);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.dexterous.flutterlocalnotifications.FlutterLocalNotificationsPlugin$4  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$dexterous$flutterlocalnotifications$models$IconSource;
        static final /* synthetic */ int[] $SwitchMap$com$dexterous$flutterlocalnotifications$models$NotificationStyle;
        static final /* synthetic */ int[] $SwitchMap$com$dexterous$flutterlocalnotifications$models$RepeatInterval;

        static {
            int[] iArr = new int[NotificationStyle.values().length];
            $SwitchMap$com$dexterous$flutterlocalnotifications$models$NotificationStyle = iArr;
            try {
                iArr[NotificationStyle.BigPicture.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$dexterous$flutterlocalnotifications$models$NotificationStyle[NotificationStyle.BigText.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$dexterous$flutterlocalnotifications$models$NotificationStyle[NotificationStyle.Inbox.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$dexterous$flutterlocalnotifications$models$NotificationStyle[NotificationStyle.Messaging.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$dexterous$flutterlocalnotifications$models$NotificationStyle[NotificationStyle.Media.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            int[] iArr2 = new int[IconSource.values().length];
            $SwitchMap$com$dexterous$flutterlocalnotifications$models$IconSource = iArr2;
            try {
                iArr2[IconSource.DrawableResource.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$dexterous$flutterlocalnotifications$models$IconSource[IconSource.BitmapFilePath.ordinal()] = 2;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$dexterous$flutterlocalnotifications$models$IconSource[IconSource.ContentUri.ordinal()] = 3;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$dexterous$flutterlocalnotifications$models$IconSource[IconSource.FlutterBitmapAsset.ordinal()] = 4;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$dexterous$flutterlocalnotifications$models$IconSource[IconSource.ByteArray.ordinal()] = 5;
            } catch (NoSuchFieldError e10) {
            }
            int[] iArr3 = new int[RepeatInterval.values().length];
            $SwitchMap$com$dexterous$flutterlocalnotifications$models$RepeatInterval = iArr3;
            try {
                iArr3[RepeatInterval.EveryMinute.ordinal()] = 1;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$com$dexterous$flutterlocalnotifications$models$RepeatInterval[RepeatInterval.Hourly.ordinal()] = 2;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$com$dexterous$flutterlocalnotifications$models$RepeatInterval[RepeatInterval.Daily.ordinal()] = 3;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$com$dexterous$flutterlocalnotifications$models$RepeatInterval[RepeatInterval.Weekly.ordinal()] = 4;
            } catch (NoSuchFieldError e14) {
            }
        }
    }

    private static void setStyle(Context context, NotificationDetails notificationDetails, NotificationCompat.Builder builder) {
        switch (AnonymousClass4.$SwitchMap$com$dexterous$flutterlocalnotifications$models$NotificationStyle[notificationDetails.style.ordinal()]) {
            case 1:
                setBigPictureStyle(context, notificationDetails, builder);
                return;
            case 2:
                setBigTextStyle(notificationDetails, builder);
                return;
            case 3:
                setInboxStyle(notificationDetails, builder);
                return;
            case 4:
                setMessagingStyle(context, notificationDetails, builder);
                return;
            case 5:
                setMediaStyle(builder);
                return;
            default:
                return;
        }
    }

    private static void setProgress(NotificationDetails notificationDetails, NotificationCompat.Builder builder) {
        if (BooleanUtils.getValue(notificationDetails.showProgress)) {
            builder.setProgress(notificationDetails.maxProgress.intValue(), notificationDetails.progress.intValue(), notificationDetails.indeterminate.booleanValue());
        }
    }

    private static void setBigPictureStyle(Context context, NotificationDetails notificationDetails, NotificationCompat.Builder builder) {
        CharSequence summaryText;
        CharSequence contentTitle;
        BigPictureStyleInformation bigPictureStyleInformation = (BigPictureStyleInformation) notificationDetails.styleInformation;
        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
        if (bigPictureStyleInformation.contentTitle != null) {
            if (bigPictureStyleInformation.htmlFormatContentTitle.booleanValue()) {
                contentTitle = fromHtml(bigPictureStyleInformation.contentTitle);
            } else {
                contentTitle = bigPictureStyleInformation.contentTitle;
            }
            bigPictureStyle.setBigContentTitle(contentTitle);
        }
        CharSequence contentTitle2 = bigPictureStyleInformation.summaryText;
        if (contentTitle2 != null) {
            if (bigPictureStyleInformation.htmlFormatSummaryText.booleanValue()) {
                summaryText = fromHtml(bigPictureStyleInformation.summaryText);
            } else {
                summaryText = bigPictureStyleInformation.summaryText;
            }
            bigPictureStyle.setSummaryText(summaryText);
        }
        if (bigPictureStyleInformation.hideExpandedLargeIcon.booleanValue()) {
            bigPictureStyle.bigLargeIcon((Bitmap) null);
        } else if (bigPictureStyleInformation.largeIcon != null) {
            bigPictureStyle.bigLargeIcon(getBitmapFromSource(context, bigPictureStyleInformation.largeIcon, bigPictureStyleInformation.largeIconBitmapSource));
        }
        bigPictureStyle.bigPicture(getBitmapFromSource(context, bigPictureStyleInformation.bigPicture, bigPictureStyleInformation.bigPictureBitmapSource));
        builder.setStyle(bigPictureStyle);
    }

    private static void setInboxStyle(NotificationDetails notificationDetails, NotificationCompat.Builder builder) {
        CharSequence summaryText;
        CharSequence contentTitle;
        InboxStyleInformation inboxStyleInformation = (InboxStyleInformation) notificationDetails.styleInformation;
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        if (inboxStyleInformation.contentTitle != null) {
            if (inboxStyleInformation.htmlFormatContentTitle.booleanValue()) {
                contentTitle = fromHtml(inboxStyleInformation.contentTitle);
            } else {
                contentTitle = inboxStyleInformation.contentTitle;
            }
            inboxStyle.setBigContentTitle(contentTitle);
        }
        CharSequence contentTitle2 = inboxStyleInformation.summaryText;
        if (contentTitle2 != null) {
            if (inboxStyleInformation.htmlFormatSummaryText.booleanValue()) {
                summaryText = fromHtml(inboxStyleInformation.summaryText);
            } else {
                summaryText = inboxStyleInformation.summaryText;
            }
            inboxStyle.setSummaryText(summaryText);
        }
        if (inboxStyleInformation.lines != null) {
            Iterator<String> it = inboxStyleInformation.lines.iterator();
            while (it.hasNext()) {
                String line = it.next();
                inboxStyle.addLine(inboxStyleInformation.htmlFormatLines.booleanValue() ? fromHtml(line) : line);
            }
        }
        builder.setStyle(inboxStyle);
    }

    private static void setMediaStyle(NotificationCompat.Builder builder) {
        NotificationCompat.MediaStyle mediaStyle = new NotificationCompat.MediaStyle();
        builder.setStyle(mediaStyle);
    }

    private static void setMessagingStyle(Context context, NotificationDetails notificationDetails, NotificationCompat.Builder builder) {
        MessagingStyleInformation messagingStyleInformation = (MessagingStyleInformation) notificationDetails.styleInformation;
        Person person = buildPerson(context, messagingStyleInformation.person);
        NotificationCompat.MessagingStyle messagingStyle = new NotificationCompat.MessagingStyle(person);
        messagingStyle.setGroupConversation(BooleanUtils.getValue(messagingStyleInformation.groupConversation));
        if (messagingStyleInformation.conversationTitle != null) {
            messagingStyle.setConversationTitle(messagingStyleInformation.conversationTitle);
        }
        if (messagingStyleInformation.messages != null && !messagingStyleInformation.messages.isEmpty()) {
            Iterator<MessageDetails> it = messagingStyleInformation.messages.iterator();
            while (it.hasNext()) {
                MessageDetails messageDetails = it.next();
                NotificationCompat.MessagingStyle.Message message = createMessage(context, messageDetails);
                messagingStyle.addMessage(message);
            }
        }
        builder.setStyle(messagingStyle);
    }

    private static NotificationCompat.MessagingStyle.Message createMessage(Context context, MessageDetails messageDetails) {
        NotificationCompat.MessagingStyle.Message message = new NotificationCompat.MessagingStyle.Message(messageDetails.text, messageDetails.timestamp.longValue(), buildPerson(context, messageDetails.person));
        if (messageDetails.dataUri != null && messageDetails.dataMimeType != null) {
            message.setData(messageDetails.dataMimeType, Uri.parse(messageDetails.dataUri));
        }
        return message;
    }

    private static Person buildPerson(Context context, PersonDetails personDetails) {
        if (personDetails == null) {
            return null;
        }
        Person.Builder personBuilder = new Person.Builder();
        personBuilder.setBot(BooleanUtils.getValue(personDetails.bot));
        if (personDetails.icon != null && personDetails.iconBitmapSource != null) {
            personBuilder.setIcon(getIconFromSource(context, personDetails.icon, personDetails.iconBitmapSource));
        }
        personBuilder.setImportant(BooleanUtils.getValue(personDetails.important));
        if (personDetails.key != null) {
            personBuilder.setKey(personDetails.key);
        }
        if (personDetails.name != null) {
            personBuilder.setName(personDetails.name);
        }
        if (personDetails.uri != null) {
            personBuilder.setUri(personDetails.uri);
        }
        return personBuilder.build();
    }

    private static void setBigTextStyle(NotificationDetails notificationDetails, NotificationCompat.Builder builder) {
        CharSequence summaryText;
        CharSequence contentTitle;
        CharSequence bigText;
        BigTextStyleInformation bigTextStyleInformation = (BigTextStyleInformation) notificationDetails.styleInformation;
        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
        if (bigTextStyleInformation.bigText != null) {
            if (bigTextStyleInformation.htmlFormatBigText.booleanValue()) {
                bigText = fromHtml(bigTextStyleInformation.bigText);
            } else {
                bigText = bigTextStyleInformation.bigText;
            }
            bigTextStyle.bigText(bigText);
        }
        CharSequence bigText2 = bigTextStyleInformation.contentTitle;
        if (bigText2 != null) {
            if (bigTextStyleInformation.htmlFormatContentTitle.booleanValue()) {
                contentTitle = fromHtml(bigTextStyleInformation.contentTitle);
            } else {
                contentTitle = bigTextStyleInformation.contentTitle;
            }
            bigTextStyle.setBigContentTitle(contentTitle);
        }
        CharSequence contentTitle2 = bigTextStyleInformation.summaryText;
        if (contentTitle2 != null) {
            if (bigTextStyleInformation.htmlFormatSummaryText.booleanValue()) {
                summaryText = fromHtml(bigTextStyleInformation.summaryText);
            } else {
                summaryText = bigTextStyleInformation.summaryText;
            }
            bigTextStyle.setSummaryText(summaryText);
        }
        builder.setStyle(bigTextStyle);
    }

    private static void setupNotificationChannel(Context context, NotificationChannelDetails notificationChannelDetails) {
        int i;
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            NotificationChannel notificationChannel = new NotificationChannel(notificationChannelDetails.id, notificationChannelDetails.name, notificationChannelDetails.importance.intValue());
            notificationChannel.setDescription(notificationChannelDetails.description);
            notificationChannel.setGroup(notificationChannelDetails.groupId);
            if (notificationChannelDetails.playSound.booleanValue()) {
                if (notificationChannelDetails.audioAttributesUsage != null) {
                    i = notificationChannelDetails.audioAttributesUsage.intValue();
                } else {
                    i = 5;
                }
                Integer audioAttributesUsage = Integer.valueOf(i);
                AudioAttributes audioAttributes = new AudioAttributes.Builder().setUsage(audioAttributesUsage.intValue()).build();
                Uri uri = retrieveSoundResourceUri(context, notificationChannelDetails.sound, notificationChannelDetails.soundSource);
                notificationChannel.setSound(uri, audioAttributes);
            } else {
                notificationChannel.setSound(null, null);
            }
            notificationChannel.enableVibration(BooleanUtils.getValue(notificationChannelDetails.enableVibration));
            if (notificationChannelDetails.vibrationPattern != null && notificationChannelDetails.vibrationPattern.length > 0) {
                notificationChannel.setVibrationPattern(notificationChannelDetails.vibrationPattern);
            }
            boolean enableLights = BooleanUtils.getValue(notificationChannelDetails.enableLights);
            notificationChannel.enableLights(enableLights);
            if (enableLights && notificationChannelDetails.ledColor != null) {
                notificationChannel.setLightColor(notificationChannelDetails.ledColor.intValue());
            }
            notificationChannel.setShowBadge(BooleanUtils.getValue(notificationChannelDetails.showBadge));
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    private static Uri retrieveSoundResourceUri(Context context, String sound, SoundSource soundSource) {
        if (StringUtils.isNullOrEmpty(sound).booleanValue()) {
            Uri uri = RingtoneManager.getDefaultUri(2);
            return uri;
        } else if (soundSource == null || soundSource == SoundSource.RawResource) {
            Uri uri2 = Uri.parse("android.resource://" + context.getPackageName() + "/raw/" + sound);
            return uri2;
        } else if (soundSource != SoundSource.Uri) {
            return null;
        } else {
            Uri uri3 = Uri.parse(sound);
            return uri3;
        }
    }

    private static AlarmManager getAlarmManager(Context context) {
        return (AlarmManager) context.getSystemService(androidx.core.app.NotificationCompat.CATEGORY_ALARM);
    }

    private static boolean isValidDrawableResource(Context context, String name, MethodChannel.Result result, String errorCode) {
        int resourceId = context.getResources().getIdentifier(name, DRAWABLE, context.getPackageName());
        if (resourceId == 0) {
            result.error(errorCode, String.format(INVALID_DRAWABLE_RESOURCE_ERROR_MESSAGE, name), null);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void showNotification(Context context, NotificationDetails notificationDetails) {
        Notification notification = createNotification(context, notificationDetails);
        NotificationManagerCompat notificationManagerCompat = getNotificationManager(context);
        if (notificationDetails.tag != null) {
            notificationManagerCompat.notify(notificationDetails.tag, notificationDetails.id.intValue(), notification);
        } else {
            notificationManagerCompat.notify(notificationDetails.id.intValue(), notification);
        }
    }

    private static void zonedScheduleNextNotification(Context context, NotificationDetails notificationDetails) {
        String nextFireDate = getNextFireDate(notificationDetails);
        if (nextFireDate == null) {
            return;
        }
        notificationDetails.scheduledDateTime = nextFireDate;
        zonedScheduleNotification(context, notificationDetails, true);
    }

    private static void zonedScheduleNextNotificationMatchingDateComponents(Context context, NotificationDetails notificationDetails) {
        String nextFireDate = getNextFireDateMatchingDateTimeComponents(notificationDetails);
        if (nextFireDate == null) {
            return;
        }
        notificationDetails.scheduledDateTime = nextFireDate;
        zonedScheduleNotification(context, notificationDetails, true);
    }

    private static String getNextFireDate(NotificationDetails notificationDetails) {
        if (notificationDetails.scheduledNotificationRepeatFrequency == ScheduledNotificationRepeatFrequency.Daily) {
            LocalDateTime localDateTime = LocalDateTime.parse(notificationDetails.scheduledDateTime).plusDays(1L);
            return DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(localDateTime);
        } else if (notificationDetails.scheduledNotificationRepeatFrequency == ScheduledNotificationRepeatFrequency.Weekly) {
            LocalDateTime localDateTime2 = LocalDateTime.parse(notificationDetails.scheduledDateTime).plusWeeks(1L);
            return DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(localDateTime2);
        } else {
            return null;
        }
    }

    private static String getNextFireDateMatchingDateTimeComponents(NotificationDetails notificationDetails) {
        ZoneId zoneId = ZoneId.of(notificationDetails.timeZoneName);
        ZonedDateTime scheduledDateTime = ZonedDateTime.of(LocalDateTime.parse(notificationDetails.scheduledDateTime), zoneId);
        ZonedDateTime now = ZonedDateTime.now(zoneId);
        ZonedDateTime nextFireDate = ZonedDateTime.of(now.getYear(), now.getMonthValue(), now.getDayOfMonth(), scheduledDateTime.getHour(), scheduledDateTime.getMinute(), scheduledDateTime.getSecond(), scheduledDateTime.getNano(), zoneId);
        while (nextFireDate.isBefore(now)) {
            nextFireDate = nextFireDate.plusDays(1L);
        }
        if (notificationDetails.matchDateTimeComponents == DateTimeComponents.Time) {
            return DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(nextFireDate);
        }
        if (notificationDetails.matchDateTimeComponents == DateTimeComponents.DayOfWeekAndTime) {
            while (nextFireDate.getDayOfWeek() != scheduledDateTime.getDayOfWeek()) {
                nextFireDate = nextFireDate.plusDays(1L);
            }
            return DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(nextFireDate);
        } else if (notificationDetails.matchDateTimeComponents == DateTimeComponents.DayOfMonthAndTime) {
            while (nextFireDate.getDayOfMonth() != scheduledDateTime.getDayOfMonth()) {
                nextFireDate = nextFireDate.plusDays(1L);
            }
            return DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(nextFireDate);
        } else if (notificationDetails.matchDateTimeComponents != DateTimeComponents.DateAndTime) {
            return null;
        } else {
            while (true) {
                if (nextFireDate.getMonthValue() != scheduledDateTime.getMonthValue() || nextFireDate.getDayOfMonth() != scheduledDateTime.getDayOfMonth()) {
                    nextFireDate = nextFireDate.plusDays(1L);
                } else {
                    return DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(nextFireDate);
                }
            }
        }
    }

    private static NotificationManagerCompat getNotificationManager(Context context) {
        return NotificationManagerCompat.from(context);
    }

    private static boolean launchedActivityFromHistory(Intent intent) {
        return intent != null && (intent.getFlags() & 1048576) == 1048576;
    }

    private void setActivity(Activity flutterActivity) {
        this.mainActivity = flutterActivity;
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding binding) {
        this.applicationContext = binding.getApplicationContext();
        MethodChannel methodChannel = new MethodChannel(binding.getBinaryMessenger(), METHOD_CHANNEL);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
        this.channel.setMethodCallHandler(null);
        this.channel = null;
        this.applicationContext = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(ActivityPluginBinding binding) {
        binding.addOnNewIntentListener(this);
        binding.addRequestPermissionsResultListener(this);
        binding.addActivityResultListener(this);
        Activity activity = binding.getActivity();
        this.mainActivity = activity;
        Intent mainActivityIntent = activity.getIntent();
        if (!launchedActivityFromHistory(mainActivityIntent) && SELECT_FOREGROUND_NOTIFICATION_ACTION.equals(mainActivityIntent.getAction())) {
            Map<String, Object> notificationResponse = extractNotificationResponseMap(mainActivityIntent);
            processForegroundNotificationAction(mainActivityIntent, notificationResponse);
        }
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivityForConfigChanges() {
        this.mainActivity = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding binding) {
        binding.addOnNewIntentListener(this);
        binding.addRequestPermissionsResultListener(this);
        binding.addActivityResultListener(this);
        this.mainActivity = binding.getActivity();
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
        this.mainActivity = null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall call, final MethodChannel.Result result) {
        char c;
        String str = call.method;
        switch (str.hashCode()) {
            case -2096263152:
                if (str.equals(STOP_FOREGROUND_SERVICE)) {
                    c = 21;
                    break;
                }
                c = 65535;
                break;
            case -2041662895:
                if (str.equals(GET_NOTIFICATION_CHANNELS_METHOD)) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            case -1873731438:
                if (str.equals(DELETE_NOTIFICATION_CHANNEL_GROUP_METHOD)) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case -1785484984:
                if (str.equals(REQUEST_NOTIFICATIONS_PERMISSION_METHOD)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -1367724422:
                if (str.equals(CANCEL_METHOD)) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -1108601471:
                if (str.equals(REQUEST_EXACT_ALARMS_PERMISSION_METHOD)) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -799130106:
                if (str.equals(PENDING_NOTIFICATION_REQUESTS_METHOD)) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case -208611345:
                if (str.equals(GET_NOTIFICATION_APP_LAUNCH_DETAILS_METHOD)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 3529469:
                if (str.equals(SHOW_METHOD)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 6625712:
                if (str.equals(PERIODICALLY_SHOW_METHOD)) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 116003316:
                if (str.equals(GET_ACTIVE_NOTIFICATION_MESSAGING_STYLE_METHOD)) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case 476547271:
                if (str.equals(CANCEL_ALL_METHOD)) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 548573423:
                if (str.equals(ZONED_SCHEDULE_METHOD)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 767006947:
                if (str.equals(CREATE_NOTIFICATION_CHANNEL_GROUP_METHOD)) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case 825311171:
                if (str.equals(GET_CALLBACK_HANDLE_METHOD)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 871091088:
                if (str.equals(INITIALIZE_METHOD)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 891942317:
                if (str.equals(ARE_NOTIFICATIONS_ENABLED_METHOD)) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 972029712:
                if (str.equals(CAN_SCHEDULE_EXACT_NOTIFICATIONS_METHOD)) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 1008472557:
                if (str.equals(DELETE_NOTIFICATION_CHANNEL_METHOD)) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case 1207771056:
                if (str.equals(START_FOREGROUND_SERVICE)) {
                    c = 20;
                    break;
                }
                c = 65535;
                break;
            case 1594833996:
                if (str.equals(GET_ACTIVE_NOTIFICATIONS_METHOD)) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case 1653467900:
                if (str.equals(CREATE_NOTIFICATION_CHANNEL_METHOD)) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                initialize(call, result);
                return;
            case 1:
                getCallbackHandle(result);
                return;
            case 2:
                getNotificationAppLaunchDetails(result);
                return;
            case 3:
                show(call, result);
                return;
            case 4:
                zonedSchedule(call, result);
                return;
            case 5:
                requestNotificationsPermission(new PermissionRequestListener() { // from class: com.dexterous.flutterlocalnotifications.FlutterLocalNotificationsPlugin.2
                    @Override // com.dexterous.flutterlocalnotifications.PermissionRequestListener
                    public void complete(boolean granted) {
                        result.success(Boolean.valueOf(granted));
                    }

                    @Override // com.dexterous.flutterlocalnotifications.PermissionRequestListener
                    public void fail(String message) {
                        result.error(FlutterLocalNotificationsPlugin.PERMISSION_REQUEST_IN_PROGRESS_ERROR_CODE, message, null);
                    }
                });
                return;
            case 6:
                requestExactAlarmsPermission(new PermissionRequestListener() { // from class: com.dexterous.flutterlocalnotifications.FlutterLocalNotificationsPlugin.3
                    @Override // com.dexterous.flutterlocalnotifications.PermissionRequestListener
                    public void complete(boolean granted) {
                        result.success(Boolean.valueOf(granted));
                    }

                    @Override // com.dexterous.flutterlocalnotifications.PermissionRequestListener
                    public void fail(String message) {
                        result.error(FlutterLocalNotificationsPlugin.PERMISSION_REQUEST_IN_PROGRESS_ERROR_CODE, message, null);
                    }
                });
                return;
            case 7:
                repeat(call, result);
                return;
            case '\b':
                cancel(call, result);
                return;
            case '\t':
                cancelAllNotifications(result);
                return;
            case '\n':
                pendingNotificationRequests(result);
                return;
            case 11:
                areNotificationsEnabled(result);
                return;
            case '\f':
                setCanScheduleExactNotifications(result);
                return;
            case '\r':
                createNotificationChannelGroup(call, result);
                return;
            case 14:
                deleteNotificationChannelGroup(call, result);
                return;
            case 15:
                createNotificationChannel(call, result);
                return;
            case 16:
                deleteNotificationChannel(call, result);
                return;
            case 17:
                getActiveNotifications(result);
                return;
            case 18:
                getActiveNotificationMessagingStyle(call, result);
                return;
            case 19:
                getNotificationChannels(result);
                return;
            case 20:
                startForegroundService(call, result);
                return;
            case 21:
                stopForegroundService(result);
                return;
            default:
                result.notImplemented();
                return;
        }
    }

    private void pendingNotificationRequests(MethodChannel.Result result) {
        ArrayList<NotificationDetails> scheduledNotifications = loadScheduledNotifications(this.applicationContext);
        List<Map<String, Object>> pendingNotifications = new ArrayList<>();
        Iterator<NotificationDetails> it = scheduledNotifications.iterator();
        while (it.hasNext()) {
            NotificationDetails scheduledNotification = it.next();
            HashMap<String, Object> pendingNotification = new HashMap<>();
            pendingNotification.put(CANCEL_ID, scheduledNotification.id);
            pendingNotification.put("title", scheduledNotification.title);
            pendingNotification.put("body", scheduledNotification.body);
            pendingNotification.put(PAYLOAD, scheduledNotification.payload);
            pendingNotifications.add(pendingNotification);
        }
        result.success(pendingNotifications);
    }

    private void getActiveNotifications(MethodChannel.Result result) {
        if (Build.VERSION.SDK_INT < 23) {
            result.error(UNSUPPORTED_OS_VERSION_ERROR_CODE, GET_ACTIVE_NOTIFICATIONS_ERROR_MESSAGE, null);
            return;
        }
        NotificationManager notificationManager = (NotificationManager) this.applicationContext.getSystemService("notification");
        try {
            StatusBarNotification[] activeNotifications = notificationManager.getActiveNotifications();
            List<Map<String, Object>> activeNotificationsPayload = new ArrayList<>();
            for (StatusBarNotification activeNotification : activeNotifications) {
                HashMap<String, Object> activeNotificationPayload = new HashMap<>();
                activeNotificationPayload.put(CANCEL_ID, Integer.valueOf(activeNotification.getId()));
                Notification notification = activeNotification.getNotification();
                if (Build.VERSION.SDK_INT >= 26) {
                    activeNotificationPayload.put("channelId", notification.getChannelId());
                }
                activeNotificationPayload.put(CANCEL_TAG, activeNotification.getTag());
                activeNotificationPayload.put("groupKey", notification.getGroup());
                activeNotificationPayload.put("title", notification.extras.getCharSequence(androidx.core.app.NotificationCompat.EXTRA_TITLE));
                activeNotificationPayload.put("body", notification.extras.getCharSequence(androidx.core.app.NotificationCompat.EXTRA_TEXT));
                activeNotificationPayload.put("bigText", notification.extras.getCharSequence(androidx.core.app.NotificationCompat.EXTRA_BIG_TEXT));
                activeNotificationsPayload.add(activeNotificationPayload);
            }
            result.success(activeNotificationsPayload);
        } catch (Throwable e) {
            result.error(UNSUPPORTED_OS_VERSION_ERROR_CODE, e.getMessage(), Log.getStackTraceString(e));
        }
    }

    private void cancel(MethodCall call, MethodChannel.Result result) {
        Map<String, Object> arguments = (Map) call.arguments();
        Integer id = (Integer) arguments.get(CANCEL_ID);
        String tag = (String) arguments.get(CANCEL_TAG);
        cancelNotification(id, tag);
        result.success(null);
    }

    private void repeat(MethodCall call, MethodChannel.Result result) {
        NotificationDetails notificationDetails = extractNotificationDetails(result, (Map) call.arguments());
        if (notificationDetails != null) {
            try {
                repeatNotification(this.applicationContext, notificationDetails, true);
                result.success(null);
            } catch (PluginException e) {
                result.error(e.code, e.getMessage(), null);
            }
        }
    }

    private void zonedSchedule(MethodCall call, MethodChannel.Result result) {
        NotificationDetails notificationDetails = extractNotificationDetails(result, (Map) call.arguments());
        if (notificationDetails != null) {
            if (notificationDetails.matchDateTimeComponents != null) {
                notificationDetails.scheduledDateTime = getNextFireDateMatchingDateTimeComponents(notificationDetails);
            }
            try {
                zonedScheduleNotification(this.applicationContext, notificationDetails, true);
                result.success(null);
            } catch (PluginException e) {
                result.error(e.code, e.getMessage(), null);
            }
        }
    }

    private void show(MethodCall call, MethodChannel.Result result) {
        Map<String, Object> arguments = (Map) call.arguments();
        NotificationDetails notificationDetails = extractNotificationDetails(result, arguments);
        if (notificationDetails != null) {
            showNotification(this.applicationContext, notificationDetails);
            result.success(null);
        }
    }

    private void getNotificationAppLaunchDetails(MethodChannel.Result result) {
        Map<String, Object> notificationAppLaunchDetails = new HashMap<>();
        boolean z = false;
        Boolean notificationLaunchedApp = false;
        Activity activity = this.mainActivity;
        if (activity != null) {
            Intent launchIntent = activity.getIntent();
            if (launchIntent != null && ((SELECT_NOTIFICATION.equals(launchIntent.getAction()) || SELECT_FOREGROUND_NOTIFICATION_ACTION.equals(launchIntent.getAction())) && !launchedActivityFromHistory(launchIntent))) {
                z = true;
            }
            notificationLaunchedApp = Boolean.valueOf(z);
            if (notificationLaunchedApp.booleanValue()) {
                notificationAppLaunchDetails.put("notificationResponse", extractNotificationResponseMap(launchIntent));
            }
        }
        notificationAppLaunchDetails.put(NOTIFICATION_LAUNCHED_APP, notificationLaunchedApp);
        result.success(notificationAppLaunchDetails);
    }

    private void initialize(MethodCall call, MethodChannel.Result result) {
        Map<String, Object> arguments = (Map) call.arguments();
        String defaultIcon = (String) arguments.get(DEFAULT_ICON);
        if (!isValidDrawableResource(this.applicationContext, defaultIcon, result, INVALID_ICON_ERROR_CODE)) {
            return;
        }
        Long dispatcherHandle = LongUtils.parseLong(call.argument(DISPATCHER_HANDLE));
        Long callbackHandle = LongUtils.parseLong(call.argument(CALLBACK_HANDLE));
        if (dispatcherHandle != null && callbackHandle != null) {
            new IsolatePreferences(this.applicationContext).saveCallbackKeys(dispatcherHandle, callbackHandle);
        }
        SharedPreferences sharedPreferences = this.applicationContext.getSharedPreferences(SHARED_PREFERENCES_KEY, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(DEFAULT_ICON, defaultIcon).apply();
        result.success(true);
    }

    private void getCallbackHandle(MethodChannel.Result result) {
        Long handle = new IsolatePreferences(this.applicationContext).getCallbackHandle();
        result.success(handle);
    }

    private NotificationDetails extractNotificationDetails(MethodChannel.Result result, Map<String, Object> arguments) {
        NotificationDetails notificationDetails = NotificationDetails.from(arguments);
        if (hasInvalidIcon(result, notificationDetails.icon) || hasInvalidLargeIcon(result, notificationDetails.largeIcon, notificationDetails.largeIconBitmapSource) || hasInvalidBigPictureResources(result, notificationDetails) || hasInvalidRawSoundResource(result, notificationDetails) || hasInvalidLedDetails(result, notificationDetails)) {
            return null;
        }
        return notificationDetails;
    }

    private boolean hasInvalidLedDetails(MethodChannel.Result result, NotificationDetails notificationDetails) {
        if (notificationDetails.ledColor != null) {
            if (notificationDetails.ledOnMs == null || notificationDetails.ledOffMs == null) {
                result.error(INVALID_LED_DETAILS_ERROR_CODE, INVALID_LED_DETAILS_ERROR_MESSAGE, null);
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean hasInvalidRawSoundResource(MethodChannel.Result result, NotificationDetails notificationDetails) {
        if (!StringUtils.isNullOrEmpty(notificationDetails.sound).booleanValue() && (notificationDetails.soundSource == null || notificationDetails.soundSource == SoundSource.RawResource)) {
            int soundResourceId = this.applicationContext.getResources().getIdentifier(notificationDetails.sound, "raw", this.applicationContext.getPackageName());
            if (soundResourceId == 0) {
                result.error(INVALID_SOUND_ERROR_CODE, String.format(INVALID_RAW_RESOURCE_ERROR_MESSAGE, notificationDetails.sound), null);
                return true;
            }
        }
        return false;
    }

    private boolean hasInvalidBigPictureResources(MethodChannel.Result result, NotificationDetails notificationDetails) {
        if (notificationDetails.style == NotificationStyle.BigPicture) {
            BigPictureStyleInformation bigPictureStyleInformation = (BigPictureStyleInformation) notificationDetails.styleInformation;
            if (hasInvalidLargeIcon(result, bigPictureStyleInformation.largeIcon, bigPictureStyleInformation.largeIconBitmapSource)) {
                return true;
            }
            if (bigPictureStyleInformation.bigPictureBitmapSource == BitmapSource.DrawableResource) {
                String bigPictureResourceName = (String) bigPictureStyleInformation.bigPicture;
                return StringUtils.isNullOrEmpty(bigPictureResourceName).booleanValue() && !isValidDrawableResource(this.applicationContext, bigPictureResourceName, result, INVALID_BIG_PICTURE_ERROR_CODE);
            } else if (bigPictureStyleInformation.bigPictureBitmapSource == BitmapSource.FilePath) {
                String largeIconPath = (String) bigPictureStyleInformation.bigPicture;
                return StringUtils.isNullOrEmpty(largeIconPath).booleanValue();
            } else if (bigPictureStyleInformation.bigPictureBitmapSource == BitmapSource.ByteArray) {
                byte[] byteArray = (byte[]) bigPictureStyleInformation.bigPicture;
                return byteArray == null || byteArray.length == 0;
            }
        }
        return false;
    }

    private boolean hasInvalidLargeIcon(MethodChannel.Result result, Object largeIcon, BitmapSource largeIconBitmapSource) {
        if (largeIconBitmapSource == BitmapSource.DrawableResource || largeIconBitmapSource == BitmapSource.FilePath) {
            String largeIconPath = (String) largeIcon;
            return (StringUtils.isNullOrEmpty(largeIconPath).booleanValue() || largeIconBitmapSource != BitmapSource.DrawableResource || isValidDrawableResource(this.applicationContext, largeIconPath, result, INVALID_LARGE_ICON_ERROR_CODE)) ? false : true;
        } else if (largeIconBitmapSource == BitmapSource.ByteArray) {
            byte[] byteArray = (byte[]) largeIcon;
            return byteArray.length == 0;
        } else {
            return false;
        }
    }

    private boolean hasInvalidIcon(MethodChannel.Result result, String icon) {
        return (StringUtils.isNullOrEmpty(icon).booleanValue() || isValidDrawableResource(this.applicationContext, icon, result, INVALID_ICON_ERROR_CODE)) ? false : true;
    }

    private void cancelNotification(Integer id, String tag) {
        Intent intent = new Intent(this.applicationContext, ScheduledNotificationReceiver.class);
        PendingIntent pendingIntent = getBroadcastPendingIntent(this.applicationContext, id.intValue(), intent);
        AlarmManager alarmManager = getAlarmManager(this.applicationContext);
        alarmManager.cancel(pendingIntent);
        NotificationManagerCompat notificationManager = getNotificationManager(this.applicationContext);
        if (tag == null) {
            notificationManager.cancel(id.intValue());
        } else {
            notificationManager.cancel(tag, id.intValue());
        }
        removeNotificationFromCache(this.applicationContext, id);
    }

    private void cancelAllNotifications(MethodChannel.Result result) {
        NotificationManagerCompat notificationManager = getNotificationManager(this.applicationContext);
        notificationManager.cancelAll();
        ArrayList<NotificationDetails> scheduledNotifications = loadScheduledNotifications(this.applicationContext);
        if (scheduledNotifications == null || scheduledNotifications.isEmpty()) {
            result.success(null);
            return;
        }
        Intent intent = new Intent(this.applicationContext, ScheduledNotificationReceiver.class);
        Iterator<NotificationDetails> it = scheduledNotifications.iterator();
        while (it.hasNext()) {
            NotificationDetails scheduledNotification = it.next();
            PendingIntent pendingIntent = getBroadcastPendingIntent(this.applicationContext, scheduledNotification.id.intValue(), intent);
            AlarmManager alarmManager = getAlarmManager(this.applicationContext);
            alarmManager.cancel(pendingIntent);
        }
        saveScheduledNotifications(this.applicationContext, new ArrayList());
        result.success(null);
    }

    public void requestNotificationsPermission(PermissionRequestListener callback) {
        if (this.permissionRequestProgress != PermissionRequestProgress.None) {
            callback.fail(PERMISSION_REQUEST_IN_PROGRESS_ERROR_MESSAGE);
            return;
        }
        this.callback = callback;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean permissionGranted = ContextCompat.checkSelfPermission(this.mainActivity, "android.permission.POST_NOTIFICATIONS") == 0;
            if (!permissionGranted) {
                this.permissionRequestProgress = PermissionRequestProgress.RequestingNotificationPermission;
                ActivityCompat.requestPermissions(this.mainActivity, new String[]{"android.permission.POST_NOTIFICATIONS"}, 1);
                return;
            }
            this.callback.complete(true);
            this.permissionRequestProgress = PermissionRequestProgress.None;
            return;
        }
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this.mainActivity);
        this.callback.complete(notificationManager.areNotificationsEnabled());
    }

    public void requestExactAlarmsPermission(PermissionRequestListener callback) {
        if (this.permissionRequestProgress != PermissionRequestProgress.None) {
            callback.fail(PERMISSION_REQUEST_IN_PROGRESS_ERROR_MESSAGE);
            return;
        }
        this.callback = callback;
        if (Build.VERSION.SDK_INT >= 31) {
            AlarmManager alarmManager = getAlarmManager(this.applicationContext);
            boolean permissionGranted = alarmManager.canScheduleExactAlarms();
            if (!permissionGranted) {
                this.permissionRequestProgress = PermissionRequestProgress.RequestingExactAlarmsPermission;
                this.mainActivity.startActivityForResult(new Intent("android.settings.REQUEST_SCHEDULE_EXACT_ALARM", Uri.parse("package:" + this.applicationContext.getPackageName())), 2);
                return;
            }
            this.callback.complete(true);
            this.permissionRequestProgress = PermissionRequestProgress.None;
            return;
        }
        this.callback.complete(true);
    }

    @Override // io.flutter.plugin.common.PluginRegistry.RequestPermissionsResultListener
    public boolean onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        boolean z = false;
        if (this.permissionRequestProgress == PermissionRequestProgress.RequestingNotificationPermission && requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == 0) {
                z = true;
            }
            boolean granted = z;
            this.callback.complete(granted);
            this.permissionRequestProgress = PermissionRequestProgress.None;
            return granted;
        }
        return false;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.NewIntentListener
    public boolean onNewIntent(Intent intent) {
        Activity activity;
        boolean res = sendNotificationPayloadMessage(intent).booleanValue();
        if (res && (activity = this.mainActivity) != null) {
            activity.setIntent(intent);
        }
        return res;
    }

    private Boolean sendNotificationPayloadMessage(Intent intent) {
        if (SELECT_NOTIFICATION.equals(intent.getAction()) || SELECT_FOREGROUND_NOTIFICATION_ACTION.equals(intent.getAction())) {
            Map<String, Object> notificationResponse = extractNotificationResponseMap(intent);
            if (SELECT_FOREGROUND_NOTIFICATION_ACTION.equals(intent.getAction())) {
                processForegroundNotificationAction(intent, notificationResponse);
            }
            this.channel.invokeMethod("didReceiveNotificationResponse", notificationResponse);
            return true;
        }
        return false;
    }

    private void processForegroundNotificationAction(Intent intent, Map<String, Object> notificationResponse) {
        if (intent.getBooleanExtra(CANCEL_NOTIFICATION, false)) {
            NotificationManagerCompat.from(this.applicationContext).cancel(((Integer) notificationResponse.get(NOTIFICATION_ID)).intValue());
        }
    }

    private void createNotificationChannelGroup(MethodCall call, MethodChannel.Result result) {
        if (Build.VERSION.SDK_INT >= 26) {
            Map<String, Object> arguments = (Map) call.arguments();
            NotificationChannelGroupDetails notificationChannelGroupDetails = NotificationChannelGroupDetails.from(arguments);
            NotificationManager notificationManager = (NotificationManager) this.applicationContext.getSystemService("notification");
            NotificationChannelGroup notificationChannelGroup = new NotificationChannelGroup(notificationChannelGroupDetails.id, notificationChannelGroupDetails.name);
            if (Build.VERSION.SDK_INT >= 28) {
                notificationChannelGroup.setDescription(notificationChannelGroupDetails.description);
            }
            notificationManager.createNotificationChannelGroup(notificationChannelGroup);
        }
        result.success(null);
    }

    private void deleteNotificationChannelGroup(MethodCall call, MethodChannel.Result result) {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationManager notificationManager = (NotificationManager) this.applicationContext.getSystemService("notification");
            String groupId = (String) call.arguments();
            notificationManager.deleteNotificationChannelGroup(groupId);
        }
        result.success(null);
    }

    private void createNotificationChannel(MethodCall call, MethodChannel.Result result) {
        Map<String, Object> arguments = (Map) call.arguments();
        NotificationChannelDetails notificationChannelDetails = NotificationChannelDetails.from(arguments);
        setupNotificationChannel(this.applicationContext, notificationChannelDetails);
        result.success(null);
    }

    private void deleteNotificationChannel(MethodCall call, MethodChannel.Result result) {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationManager notificationManager = (NotificationManager) this.applicationContext.getSystemService("notification");
            String channelId = (String) call.arguments();
            notificationManager.deleteNotificationChannel(channelId);
        }
        result.success(null);
    }

    private void getActiveNotificationMessagingStyle(MethodCall call, MethodChannel.Result result) {
        if (Build.VERSION.SDK_INT < 23) {
            result.error(UNSUPPORTED_OS_VERSION_ERROR_CODE, "Android version must be 6.0 or newer to use getActiveNotificationMessagingStyle", null);
            return;
        }
        NotificationManager notificationManager = (NotificationManager) this.applicationContext.getSystemService("notification");
        try {
            Map<String, Object> arguments = (Map) call.arguments();
            int id = ((Integer) arguments.get(CANCEL_ID)).intValue();
            String tag = (String) arguments.get(CANCEL_TAG);
            StatusBarNotification[] activeNotifications = notificationManager.getActiveNotifications();
            Notification notification = null;
            for (StatusBarNotification activeNotification : activeNotifications) {
                try {
                    if (activeNotification.getId() == id && (tag == null || tag.equals(activeNotification.getTag()))) {
                        notification = activeNotification.getNotification();
                        break;
                    }
                } catch (Throwable th) {
                    e = th;
                    result.error(GET_ACTIVE_NOTIFICATION_MESSAGING_STYLE_ERROR_CODE, e.getMessage(), Log.getStackTraceString(e));
                    return;
                }
            }
            if (notification == null) {
                result.success(null);
                return;
            }
            NotificationCompat.MessagingStyle messagingStyle = NotificationCompat.MessagingStyle.extractMessagingStyleFromNotification(notification);
            if (messagingStyle == null) {
                result.success(null);
                return;
            }
            HashMap<String, Object> stylePayload = new HashMap<>();
            stylePayload.put("groupConversation", Boolean.valueOf(messagingStyle.isGroupConversation()));
            stylePayload.put("person", describePerson(messagingStyle.getUser()));
            stylePayload.put("conversationTitle", messagingStyle.getConversationTitle());
            List<Map<String, Object>> messagesPayload = new ArrayList<>();
            for (NotificationCompat.MessagingStyle.Message msg : messagingStyle.getMessages()) {
                Map<String, Object> msgPayload = new HashMap<>();
                NotificationManager notificationManager2 = notificationManager;
                try {
                    msgPayload.put("text", msg.getText());
                    msgPayload.put("timestamp", Long.valueOf(msg.getTimestamp()));
                    msgPayload.put("person", describePerson(msg.getPerson()));
                    messagesPayload.add(msgPayload);
                    notificationManager = notificationManager2;
                } catch (Throwable th2) {
                    e = th2;
                    result.error(GET_ACTIVE_NOTIFICATION_MESSAGING_STYLE_ERROR_CODE, e.getMessage(), Log.getStackTraceString(e));
                    return;
                }
            }
            stylePayload.put("messages", messagesPayload);
            result.success(stylePayload);
        } catch (Throwable th3) {
            e = th3;
        }
    }

    private Map<String, Object> describePerson(Person person) {
        if (person == null) {
            return null;
        }
        Map<String, Object> payload = new HashMap<>();
        payload.put("key", person.getKey());
        payload.put("name", person.getName());
        payload.put("uri", person.getUri());
        payload.put("bot", Boolean.valueOf(person.isBot()));
        payload.put("important", Boolean.valueOf(person.isImportant()));
        payload.put("icon", describeIcon(person.getIcon()));
        return payload;
    }

    private Map<String, Object> describeIcon(IconCompat icon) {
        IconSource source;
        Object resourceEntryName;
        if (icon == null) {
            return null;
        }
        switch (icon.getType()) {
            case 2:
                source = IconSource.DrawableResource;
                int resId = icon.getResId();
                Context context = this.applicationContext;
                if (!context.getResources().getResourceTypeName(resId).equals(DRAWABLE)) {
                    throw new AssertionError();
                }
                if (!context.getResources().getResourcePackageName(resId).equals(context.getPackageName())) {
                    throw new AssertionError();
                }
                resourceEntryName = context.getResources().getResourceEntryName(resId);
                break;
            case 3:
            default:
                return null;
            case 4:
                source = IconSource.ContentUri;
                resourceEntryName = icon.getUri().toString();
                break;
        }
        Map<String, Object> payload = new HashMap<>();
        payload.put(Constants.ScionAnalytics.PARAM_SOURCE, Integer.valueOf(source.ordinal()));
        payload.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, resourceEntryName);
        return payload;
    }

    private void getNotificationChannels(MethodChannel.Result result) {
        try {
            NotificationManagerCompat notificationManagerCompat = getNotificationManager(this.applicationContext);
            List<NotificationChannel> channels = notificationManagerCompat.getNotificationChannels();
            List<Map<String, Object>> channelsPayload = new ArrayList<>();
            for (NotificationChannel channel : channels) {
                HashMap<String, Object> channelPayload = getMappedNotificationChannel(channel);
                channelsPayload.add(channelPayload);
            }
            result.success(channelsPayload);
        } catch (Throwable e) {
            result.error(GET_NOTIFICATION_CHANNELS_ERROR_CODE, e.getMessage(), Log.getStackTraceString(e));
        }
    }

    private HashMap<String, Object> getMappedNotificationChannel(NotificationChannel channel) {
        int usage;
        HashMap<String, Object> channelPayload = new HashMap<>();
        if (Build.VERSION.SDK_INT >= 26) {
            channelPayload.put(CANCEL_ID, channel.getId());
            channelPayload.put("name", channel.getName());
            channelPayload.put("description", channel.getDescription());
            channelPayload.put("groupId", channel.getGroup());
            channelPayload.put("showBadge", Boolean.valueOf(channel.canShowBadge()));
            channelPayload.put("importance", Integer.valueOf(channel.getImportance()));
            Uri soundUri = channel.getSound();
            if (soundUri != null) {
                channelPayload.put("playSound", true);
                List<SoundSource> soundSources = Arrays.asList(SoundSource.values());
                if (soundUri.getScheme().equals("android.resource")) {
                    String[] splitUri = soundUri.toString().split("/");
                    String resource = splitUri[splitUri.length - 1];
                    Integer resourceId = tryParseInt(resource);
                    if (resourceId == null) {
                        channelPayload.put("soundSource", Integer.valueOf(soundSources.indexOf(SoundSource.RawResource)));
                        channelPayload.put("sound", resource);
                    } else {
                        String resourceName = this.applicationContext.getResources().getResourceEntryName(resourceId.intValue());
                        if (resourceName != null) {
                            channelPayload.put("soundSource", Integer.valueOf(soundSources.indexOf(SoundSource.RawResource)));
                            channelPayload.put("sound", resourceName);
                        }
                    }
                } else {
                    channelPayload.put("soundSource", Integer.valueOf(soundSources.indexOf(SoundSource.Uri)));
                    channelPayload.put("sound", soundUri.toString());
                }
            } else {
                channelPayload.put("sound", null);
                channelPayload.put("playSound", false);
            }
            channelPayload.put("enableVibration", Boolean.valueOf(channel.shouldVibrate()));
            channelPayload.put("vibrationPattern", channel.getVibrationPattern());
            channelPayload.put("enableLights", Boolean.valueOf(channel.shouldShowLights()));
            channelPayload.put("ledColor", Integer.valueOf(channel.getLightColor()));
            AudioAttributes audioAttributes = channel.getAudioAttributes();
            if (audioAttributes == null) {
                usage = 5;
            } else {
                usage = audioAttributes.getUsage();
            }
            channelPayload.put("audioAttributesUsage", Integer.valueOf(usage));
        }
        return channelPayload;
    }

    private Integer tryParseInt(String value) {
        try {
            return Integer.valueOf(Integer.parseInt(value));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private void startForegroundService(MethodCall call, MethodChannel.Result result) {
        Map<String, Object> notificationData = (Map) call.argument("notificationData");
        Integer startType = (Integer) call.argument("startType");
        ArrayList<Integer> foregroundServiceTypes = (ArrayList) call.argument("foregroundServiceTypes");
        if (foregroundServiceTypes != null && foregroundServiceTypes.size() == 0) {
            result.error("ARGUMENT_ERROR", "If foregroundServiceTypes is non-null it must not be empty!", null);
        } else if (notificationData == null || startType == null) {
            result.error("ARGUMENT_ERROR", "An argument passed to startForegroundService was null!", null);
        } else {
            NotificationDetails notificationDetails = extractNotificationDetails(result, notificationData);
            if (notificationDetails != null) {
                if (notificationDetails.id.intValue() == 0) {
                    result.error("ARGUMENT_ERROR", "The id of the notification for a foreground service must not be 0!", null);
                    return;
                }
                ForegroundServiceStartParameter parameter = new ForegroundServiceStartParameter(notificationDetails, startType.intValue(), foregroundServiceTypes);
                Intent intent = new Intent(this.applicationContext, ForegroundService.class);
                intent.putExtra(ForegroundServiceStartParameter.EXTRA, parameter);
                ContextCompat.startForegroundService(this.applicationContext, intent);
                result.success(null);
            }
        }
    }

    private void stopForegroundService(MethodChannel.Result result) {
        this.applicationContext.stopService(new Intent(this.applicationContext, ForegroundService.class));
        result.success(null);
    }

    private void areNotificationsEnabled(MethodChannel.Result result) {
        NotificationManagerCompat notificationManager = getNotificationManager(this.applicationContext);
        result.success(Boolean.valueOf(notificationManager.areNotificationsEnabled()));
    }

    private void setCanScheduleExactNotifications(MethodChannel.Result result) {
        if (Build.VERSION.SDK_INT < 31) {
            result.success(true);
            return;
        }
        AlarmManager alarmManager = getAlarmManager(this.applicationContext);
        result.success(Boolean.valueOf(alarmManager.canScheduleExactAlarms()));
    }

    @Override // io.flutter.plugin.common.PluginRegistry.ActivityResultListener
    public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode != 1 && requestCode != 2) {
            return false;
        }
        if (this.permissionRequestProgress == PermissionRequestProgress.RequestingExactAlarmsPermission && requestCode == 2 && Build.VERSION.SDK_INT >= 31) {
            AlarmManager alarmManager = getAlarmManager(this.applicationContext);
            this.callback.complete(alarmManager.canScheduleExactAlarms());
            this.permissionRequestProgress = PermissionRequestProgress.None;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class PluginException extends RuntimeException {
        public final String code;

        PluginException(String code, String message) {
            super(message);
            this.code = code;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class ExactAlarmPermissionException extends PluginException {
        public ExactAlarmPermissionException() {
            super(FlutterLocalNotificationsPlugin.EXACT_ALARMS_PERMISSION_ERROR_CODE, "Exact alarms are not permitted");
        }
    }
}
