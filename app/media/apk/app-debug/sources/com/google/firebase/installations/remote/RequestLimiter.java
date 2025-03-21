package com.google.firebase.installations.remote;

import com.google.firebase.installations.Utils;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
class RequestLimiter {
    private static final long MAXIMUM_BACKOFF_DURATION_FOR_CONFIGURATION_ERRORS = TimeUnit.HOURS.toMillis(24);
    private static final long MAXIMUM_BACKOFF_DURATION_FOR_SERVER_ERRORS = TimeUnit.MINUTES.toMillis(30);
    private int attemptCount;
    private long nextRequestTime;
    private final Utils utils;

    RequestLimiter(Utils utils) {
        this.utils = utils;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RequestLimiter() {
        this.utils = Utils.getInstance();
    }

    public synchronized void setNextRequestTime(int responseCode) {
        if (isSuccessfulOrRequiresNewFidCreation(responseCode)) {
            resetBackoffStrategy();
            return;
        }
        this.attemptCount++;
        long backOffTime = getBackoffDuration(responseCode);
        this.nextRequestTime = this.utils.currentTimeInMillis() + backOffTime;
    }

    private synchronized void resetBackoffStrategy() {
        this.attemptCount = 0;
    }

    private synchronized long getBackoffDuration(int responseCode) {
        if (!isRetryableError(responseCode)) {
            return MAXIMUM_BACKOFF_DURATION_FOR_CONFIGURATION_ERRORS;
        }
        return (long) Math.min(Math.pow(2.0d, this.attemptCount) + this.utils.getRandomDelayForSyncPrevention(), MAXIMUM_BACKOFF_DURATION_FOR_SERVER_ERRORS);
    }

    private static boolean isRetryableError(int responseCode) {
        return responseCode == 429 || (responseCode >= 500 && responseCode < 600);
    }

    private static boolean isSuccessfulOrRequiresNewFidCreation(int responseCode) {
        return (responseCode >= 200 && responseCode < 300) || responseCode == 401 || responseCode == 404;
    }

    public synchronized boolean isRequestAllowed() {
        boolean z;
        if (this.attemptCount != 0) {
            z = this.utils.currentTimeInMillis() > this.nextRequestTime;
        }
        return z;
    }
}
