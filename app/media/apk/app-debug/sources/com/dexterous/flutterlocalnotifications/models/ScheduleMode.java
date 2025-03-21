package com.dexterous.flutterlocalnotifications.models;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
/* loaded from: classes2.dex */
public enum ScheduleMode {
    alarmClock,
    exact,
    exactAllowWhileIdle,
    inexact,
    inexactAllowWhileIdle;

    public boolean useAllowWhileIdle() {
        return this == exactAllowWhileIdle || this == inexactAllowWhileIdle;
    }

    public boolean useExactAlarm() {
        return this == exact || this == exactAllowWhileIdle;
    }

    public boolean useAlarmClock() {
        return this == alarmClock;
    }

    /* loaded from: classes2.dex */
    public static class Deserializer implements JsonDeserializer<ScheduleMode> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.JsonDeserializer
        public ScheduleMode deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            try {
                return ScheduleMode.valueOf(json.getAsString());
            } catch (Exception e) {
                return json.getAsBoolean() ? ScheduleMode.exactAllowWhileIdle : ScheduleMode.exact;
            }
        }
    }
}
