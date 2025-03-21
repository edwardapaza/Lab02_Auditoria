package l4;

import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public enum e {
    NANOSECONDS(TimeUnit.NANOSECONDS),
    MICROSECONDS(TimeUnit.MICROSECONDS),
    MILLISECONDS(TimeUnit.MILLISECONDS),
    SECONDS(TimeUnit.SECONDS),
    MINUTES(TimeUnit.MINUTES),
    HOURS(TimeUnit.HOURS),
    DAYS(TimeUnit.DAYS);
    

    /* renamed from: a  reason: collision with root package name */
    private final TimeUnit f6048a;

    e(TimeUnit timeUnit) {
        this.f6048a = timeUnit;
    }

    public final TimeUnit c() {
        return this.f6048a;
    }
}
