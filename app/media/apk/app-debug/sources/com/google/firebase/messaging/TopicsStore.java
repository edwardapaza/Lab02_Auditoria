package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class TopicsStore {
    private static final String DIVIDER_QUEUE_OPERATIONS = ",";
    static final String KEY_TOPIC_OPERATIONS_QUEUE = "topic_operation_queue";
    static final String PREFERENCES = "com.google.android.gms.appid";
    private static WeakReference<TopicsStore> topicsStoreWeakReference;
    private final SharedPreferences sharedPreferences;
    private final Executor syncExecutor;
    private SharedPreferencesQueue topicOperationsQueue;

    private TopicsStore(SharedPreferences sharedPrefs, Executor executor) {
        this.syncExecutor = executor;
        this.sharedPreferences = sharedPrefs;
    }

    private synchronized void initStore() {
        this.topicOperationsQueue = SharedPreferencesQueue.createInstance(this.sharedPreferences, KEY_TOPIC_OPERATIONS_QUEUE, DIVIDER_QUEUE_OPERATIONS, this.syncExecutor);
    }

    public static synchronized TopicsStore getInstance(Context context, Executor executor) {
        TopicsStore store;
        synchronized (TopicsStore.class) {
            store = null;
            WeakReference<TopicsStore> weakReference = topicsStoreWeakReference;
            if (weakReference != null) {
                store = weakReference.get();
            }
            if (store == null) {
                SharedPreferences sharedPrefs = context.getSharedPreferences(PREFERENCES, 0);
                store = new TopicsStore(sharedPrefs, executor);
                store.initStore();
                topicsStoreWeakReference = new WeakReference<>(store);
            }
        }
        return store;
    }

    static synchronized void clearCaches() {
        synchronized (TopicsStore.class) {
            WeakReference<TopicsStore> weakReference = topicsStoreWeakReference;
            if (weakReference != null) {
                weakReference.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized TopicOperation getNextTopicOperation() {
        String entry;
        entry = this.topicOperationsQueue.peek();
        return TopicOperation.from(entry);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean addTopicOperation(TopicOperation topicOperation) {
        return this.topicOperationsQueue.add(topicOperation.serialize());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean removeTopicOperation(TopicOperation topicOperation) {
        return this.topicOperationsQueue.remove(topicOperation.serialize());
    }

    synchronized TopicOperation pollTopicOperation() {
        try {
        } catch (NoSuchElementException e) {
            Log.e(Constants.TAG, "Polling operation queue failed");
            return null;
        }
        return TopicOperation.from(this.topicOperationsQueue.remove());
    }

    synchronized List<TopicOperation> getOperations() {
        List<TopicOperation> operations;
        List<String> items = this.topicOperationsQueue.toList();
        operations = new ArrayList<>(items.size());
        for (String item : items) {
            operations.add(TopicOperation.from(item));
        }
        return operations;
    }

    synchronized void clearTopicOperations() {
        this.topicOperationsQueue.clear();
    }
}
