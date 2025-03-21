package com.google.firebase.messaging;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class TopicsSubscriber {
    static final String ERROR_INTERNAL_SERVER_ERROR = "INTERNAL_SERVER_ERROR";
    static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";
    private static final long MAX_DELAY_SEC = TimeUnit.HOURS.toSeconds(8);
    private static final long MIN_DELAY_SEC = 30;
    private static final long RPC_TIMEOUT_SEC = 30;
    private final Context context;
    private final FirebaseMessaging firebaseMessaging;
    private final Metadata metadata;
    private final GmsRpc rpc;
    private final TopicsStore store;
    private final ScheduledExecutorService syncExecutor;
    private final Map<String, ArrayDeque<TaskCompletionSource<Void>>> pendingOperations = new ArrayMap();
    private boolean syncScheduledOrRunning = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Task<TopicsSubscriber> createInstance(final FirebaseMessaging firebaseMessaging, final Metadata metadata, final GmsRpc rpc, final Context context, final ScheduledExecutorService syncExecutor) {
        return Tasks.call(syncExecutor, new Callable() { // from class: com.google.firebase.messaging.TopicsSubscriber$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return TopicsSubscriber.lambda$createInstance$0(context, syncExecutor, firebaseMessaging, metadata, rpc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TopicsSubscriber lambda$createInstance$0(Context context, ScheduledExecutorService syncExecutor, FirebaseMessaging firebaseMessaging, Metadata metadata, GmsRpc rpc) throws Exception {
        TopicsStore topicsStore = TopicsStore.getInstance(context, syncExecutor);
        TopicsSubscriber topicsSubscriber = new TopicsSubscriber(firebaseMessaging, metadata, topicsStore, rpc, context, syncExecutor);
        return topicsSubscriber;
    }

    private TopicsSubscriber(FirebaseMessaging firebaseMessaging, Metadata metadata, TopicsStore store, GmsRpc rpc, Context context, ScheduledExecutorService syncExecutor) {
        this.firebaseMessaging = firebaseMessaging;
        this.metadata = metadata;
        this.store = store;
        this.rpc = rpc;
        this.context = context;
        this.syncExecutor = syncExecutor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Task<Void> subscribeToTopic(String topic) {
        Task<Void> task = scheduleTopicOperation(TopicOperation.subscribe(topic));
        startTopicsSyncIfNecessary();
        return task;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Task<Void> unsubscribeFromTopic(String topic) {
        Task<Void> task = scheduleTopicOperation(TopicOperation.unsubscribe(topic));
        startTopicsSyncIfNecessary();
        return task;
    }

    Task<Void> scheduleTopicOperation(TopicOperation topicOperation) {
        this.store.addTopicOperation(topicOperation);
        TaskCompletionSource<Void> taskCompletionSource = new TaskCompletionSource<>();
        addToPendingOperations(topicOperation, taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    private void addToPendingOperations(TopicOperation topicOperation, TaskCompletionSource<Void> taskCompletionSource) {
        ArrayDeque<TaskCompletionSource<Void>> list;
        synchronized (this.pendingOperations) {
            String key = topicOperation.serialize();
            if (this.pendingOperations.containsKey(key)) {
                list = this.pendingOperations.get(key);
            } else {
                list = new ArrayDeque<>();
                this.pendingOperations.put(key, list);
            }
            list.add(taskCompletionSource);
        }
    }

    boolean hasPendingOperation() {
        return this.store.getNextTopicOperation() != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startTopicsSyncIfNecessary() {
        if (hasPendingOperation()) {
            startSync();
        }
    }

    private void startSync() {
        if (!isSyncScheduledOrRunning()) {
            syncWithDelaySecondsInternal(0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void syncWithDelaySecondsInternal(long delaySeconds) {
        long retryDelaySeconds = Math.min(Math.max(30L, 2 * delaySeconds), MAX_DELAY_SEC);
        TopicsSyncTask syncTask = new TopicsSyncTask(this, this.context, this.metadata, retryDelaySeconds);
        scheduleSyncTaskWithDelaySeconds(syncTask, delaySeconds);
        setSyncScheduledOrRunning(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void scheduleSyncTaskWithDelaySeconds(Runnable task, long delaySeconds) {
        this.syncExecutor.schedule(task, delaySeconds, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0018, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x000d, code lost:
        if (isDebugLogEnabled() == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
        android.util.Log.d(com.google.firebase.messaging.Constants.TAG, "topic sync succeeded");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean syncTopics() throws java.io.IOException {
        /*
            r3 = this;
        L0:
            monitor-enter(r3)
            com.google.firebase.messaging.TopicsStore r0 = r3.store     // Catch: java.lang.Throwable -> L2b
            com.google.firebase.messaging.TopicOperation r0 = r0.getNextTopicOperation()     // Catch: java.lang.Throwable -> L2b
            if (r0 != 0) goto L19
            boolean r1 = isDebugLogEnabled()     // Catch: java.lang.Throwable -> L2b
            if (r1 == 0) goto L16
            java.lang.String r1 = "FirebaseMessaging"
            java.lang.String r2 = "topic sync succeeded"
            android.util.Log.d(r1, r2)     // Catch: java.lang.Throwable -> L2b
        L16:
            r1 = 1
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L2b
            return r1
        L19:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L2b
            boolean r1 = r3.performTopicOperation(r0)
            if (r1 != 0) goto L22
            r1 = 0
            return r1
        L22:
            com.google.firebase.messaging.TopicsStore r1 = r3.store
            r1.removeTopicOperation(r0)
            r3.markCompletePendingOperation(r0)
            goto L0
        L2b:
            r0 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L2b
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.TopicsSubscriber.syncTopics():boolean");
    }

    private void markCompletePendingOperation(TopicOperation topicOperation) {
        synchronized (this.pendingOperations) {
            String key = topicOperation.serialize();
            if (this.pendingOperations.containsKey(key)) {
                ArrayDeque<TaskCompletionSource<Void>> list = this.pendingOperations.get(key);
                TaskCompletionSource<Void> taskCompletionSource = list.poll();
                if (taskCompletionSource != null) {
                    taskCompletionSource.setResult(null);
                }
                if (list.isEmpty()) {
                    this.pendingOperations.remove(key);
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    boolean performTopicOperation(TopicOperation topicOperation) throws IOException {
        try {
            String operation = topicOperation.getOperation();
            char c = 65535;
            switch (operation.hashCode()) {
                case 83:
                    if (operation.equals(ExifInterface.LATITUDE_SOUTH)) {
                        c = 0;
                        break;
                    }
                    break;
                case 85:
                    if (operation.equals("U")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    blockingSubscribeToTopic(topicOperation.getTopic());
                    if (isDebugLogEnabled()) {
                        Log.d(Constants.TAG, "Subscribe to topic: " + topicOperation.getTopic() + " succeeded.");
                        break;
                    }
                    break;
                case 1:
                    blockingUnsubscribeFromTopic(topicOperation.getTopic());
                    if (isDebugLogEnabled()) {
                        Log.d(Constants.TAG, "Unsubscribe from topic: " + topicOperation.getTopic() + " succeeded.");
                        break;
                    }
                    break;
                default:
                    if (isDebugLogEnabled()) {
                        Log.d(Constants.TAG, "Unknown topic operation" + topicOperation + ".");
                        break;
                    }
                    break;
            }
            return true;
        } catch (IOException e) {
            if (ERROR_SERVICE_NOT_AVAILABLE.equals(e.getMessage()) || ERROR_INTERNAL_SERVER_ERROR.equals(e.getMessage())) {
                Log.e(Constants.TAG, "Topic operation failed: " + e.getMessage() + ". Will retry Topic operation.");
                return false;
            } else if (e.getMessage() == null) {
                Log.e(Constants.TAG, "Topic operation failed without exception message. Will retry Topic operation.");
                return false;
            } else {
                throw e;
            }
        }
    }

    private void blockingSubscribeToTopic(String topic) throws IOException {
        awaitTask(this.rpc.subscribeToTopic(this.firebaseMessaging.blockingGetToken(), topic));
    }

    private void blockingUnsubscribeFromTopic(String topic) throws IOException {
        awaitTask(this.rpc.unsubscribeFromTopic(this.firebaseMessaging.blockingGetToken(), topic));
    }

    private static <T> void awaitTask(Task<T> task) throws IOException {
        try {
            Tasks.await(task, 30L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e = e;
            throw new IOException(ERROR_SERVICE_NOT_AVAILABLE, e);
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            }
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new IOException(e2);
        } catch (TimeoutException e3) {
            e = e3;
            throw new IOException(ERROR_SERVICE_NOT_AVAILABLE, e);
        }
    }

    synchronized boolean isSyncScheduledOrRunning() {
        return this.syncScheduledOrRunning;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void setSyncScheduledOrRunning(boolean value) {
        this.syncScheduledOrRunning = value;
    }

    static boolean isDebugLogEnabled() {
        return Log.isLoggable(Constants.TAG, 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable(Constants.TAG, 3));
    }

    TopicsStore getStore() {
        return this.store;
    }
}
