package io.flutter.plugins.firebase.messaging;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.util.Log;
import com.google.firebase.messaging.RemoteMessage;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class FlutterFirebaseMessagingReceiver extends BroadcastReceiver {
    private static final String TAG = "FLTFireMsgReceiver";
    static HashMap<String, RemoteMessage> notifications = new HashMap<>();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "broadcast received for message");
        if (ContextHolder.getApplicationContext() == null) {
            ContextHolder.setApplicationContext(context.getApplicationContext());
        }
        if (intent.getExtras() == null) {
            Log.d(TAG, "broadcast received but intent contained no extras to process RemoteMessage. Operation cancelled.");
            return;
        }
        RemoteMessage remoteMessage = new RemoteMessage(intent.getExtras());
        if (remoteMessage.getNotification() != null) {
            notifications.put(remoteMessage.getMessageId(), remoteMessage);
            FlutterFirebaseMessagingStore.getInstance().storeFirebaseMessage(remoteMessage);
        }
        if (FlutterFirebaseMessagingUtils.isApplicationForeground(context)) {
            FlutterFirebaseRemoteMessageLiveData.getInstance().postRemoteMessage(remoteMessage);
            return;
        }
        Intent onBackgroundMessageIntent = new Intent(context, FlutterFirebaseMessagingBackgroundService.class);
        Parcel parcel = Parcel.obtain();
        remoteMessage.writeToParcel(parcel, 0);
        onBackgroundMessageIntent.putExtra("notification", parcel.marshall());
        FlutterFirebaseMessagingBackgroundService.enqueueMessageProcessing(context, onBackgroundMessageIntent, remoteMessage.getOriginalPriority() == 1);
    }
}
