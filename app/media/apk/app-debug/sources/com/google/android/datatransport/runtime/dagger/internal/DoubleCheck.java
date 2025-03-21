package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.Lazy;
import javax.inject.Provider;
/* loaded from: classes.dex */
public final class DoubleCheck<T> implements Provider<T>, Lazy<T> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Object UNINITIALIZED = new Object();
    private volatile Object instance = UNINITIALIZED;
    private volatile Provider<T> provider;

    private DoubleCheck(Provider<T> provider) {
        if (provider == null) {
            throw new AssertionError();
        }
        this.provider = provider;
    }

    @Override // javax.inject.Provider
    public T get() {
        Object result = (T) this.instance;
        Object obj = UNINITIALIZED;
        if (result == obj) {
            synchronized (this) {
                result = this.instance;
                if (result == obj) {
                    result = (T) this.provider.get();
                    this.instance = reentrantCheck(this.instance, result);
                    this.provider = null;
                }
            }
        }
        return (T) result;
    }

    public static Object reentrantCheck(Object currentInstance, Object newInstance) {
        boolean isReentrant = (currentInstance == UNINITIALIZED || (currentInstance instanceof MemoizedSentinel)) ? false : true;
        if (isReentrant && currentInstance != newInstance) {
            throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + currentInstance + " & " + newInstance + ". This is likely due to a circular dependency.");
        }
        return newInstance;
    }

    public static <P extends Provider<T>, T> Provider<T> provider(P delegate) {
        Preconditions.checkNotNull(delegate);
        if (delegate instanceof DoubleCheck) {
            return delegate;
        }
        return new DoubleCheck(delegate);
    }

    public static <P extends Provider<T>, T> Lazy<T> lazy(P provider) {
        if (provider instanceof Lazy) {
            Lazy<T> lazy = (Lazy) provider;
            return lazy;
        }
        return new DoubleCheck((Provider) Preconditions.checkNotNull(provider));
    }
}
