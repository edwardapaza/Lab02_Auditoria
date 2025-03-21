package com.dexterous.flutterlocalnotifications.models;

import java.io.Serializable;
import java.util.Map;
/* loaded from: classes2.dex */
public class Time implements Serializable {
    private static final String HOUR = "hour";
    private static final String MINUTE = "minute";
    private static final String SECOND = "second";
    public Integer hour = 0;
    public Integer minute = 0;
    public Integer second = 0;

    public static Time from(Map<String, Object> arguments) {
        Time time = new Time();
        time.hour = (Integer) arguments.get(HOUR);
        time.minute = (Integer) arguments.get(MINUTE);
        time.second = (Integer) arguments.get(SECOND);
        return time;
    }
}
