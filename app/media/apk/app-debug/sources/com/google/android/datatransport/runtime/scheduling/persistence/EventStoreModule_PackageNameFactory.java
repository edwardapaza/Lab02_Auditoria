package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import javax.inject.Provider;
/* loaded from: classes.dex */
public final class EventStoreModule_PackageNameFactory implements Factory<String> {
    private final Provider<Context> contextProvider;

    public EventStoreModule_PackageNameFactory(Provider<Context> contextProvider) {
        this.contextProvider = contextProvider;
    }

    @Override // javax.inject.Provider
    public String get() {
        return packageName(this.contextProvider.get());
    }

    public static EventStoreModule_PackageNameFactory create(Provider<Context> contextProvider) {
        return new EventStoreModule_PackageNameFactory(contextProvider);
    }

    public static String packageName(Context context) {
        return (String) Preconditions.checkNotNull(EventStoreModule.packageName(context), "Cannot return null from a non-@Nullable @Provides method");
    }
}
