package com.google.android.datatransport.cct.internal;
/* loaded from: classes.dex */
final class AutoValue_LogResponse extends LogResponse {
    private final long nextRequestWaitMillis;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_LogResponse(long nextRequestWaitMillis) {
        this.nextRequestWaitMillis = nextRequestWaitMillis;
    }

    @Override // com.google.android.datatransport.cct.internal.LogResponse
    public long getNextRequestWaitMillis() {
        return this.nextRequestWaitMillis;
    }

    public String toString() {
        return "LogResponse{nextRequestWaitMillis=" + this.nextRequestWaitMillis + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof LogResponse) {
            LogResponse that = (LogResponse) o;
            return this.nextRequestWaitMillis == that.getNextRequestWaitMillis();
        }
        return false;
    }

    public int hashCode() {
        int h$ = 1 * 1000003;
        long j = this.nextRequestWaitMillis;
        return h$ ^ ((int) (j ^ (j >>> 32)));
    }
}
