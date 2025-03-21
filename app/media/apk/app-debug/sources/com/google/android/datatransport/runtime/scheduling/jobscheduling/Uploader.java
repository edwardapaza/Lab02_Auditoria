package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import javax.inject.Inject;
/* loaded from: classes.dex */
public class Uploader {
    private static final String CLIENT_HEALTH_METRICS_LOG_SOURCE = "GDT_CLIENT_METRICS";
    private static final String LOG_TAG = "Uploader";
    private final BackendRegistry backendRegistry;
    private final ClientHealthMetricsStore clientHealthMetricsStore;
    private final Clock clock;
    private final Context context;
    private final EventStore eventStore;
    private final Executor executor;
    private final SynchronizationGuard guard;
    private final Clock uptimeClock;
    private final WorkScheduler workScheduler;

    @Inject
    public Uploader(Context context, BackendRegistry backendRegistry, EventStore eventStore, WorkScheduler workScheduler, Executor executor, SynchronizationGuard guard, Clock clock, Clock uptimeClock, ClientHealthMetricsStore clientHealthMetricsStore) {
        this.context = context;
        this.backendRegistry = backendRegistry;
        this.eventStore = eventStore;
        this.workScheduler = workScheduler;
        this.executor = executor;
        this.guard = guard;
        this.clock = clock;
        this.uptimeClock = uptimeClock;
        this.clientHealthMetricsStore = clientHealthMetricsStore;
    }

    boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.context.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void upload(final TransportContext transportContext, final int attemptNumber, final Runnable callback) {
        this.executor.execute(new Runnable() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                Uploader.this.m68x80c37673(transportContext, attemptNumber, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$upload$1$com-google-android-datatransport-runtime-scheduling-jobscheduling-Uploader  reason: not valid java name */
    public /* synthetic */ void m68x80c37673(final TransportContext transportContext, final int attemptNumber, Runnable callback) {
        try {
            try {
                SynchronizationGuard synchronizationGuard = this.guard;
                final EventStore eventStore = this.eventStore;
                Objects.requireNonNull(eventStore);
                synchronizationGuard.runCriticalSection(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader$$ExternalSyntheticLambda3
                    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                    public final Object execute() {
                        return Integer.valueOf(EventStore.this.cleanUp());
                    }
                });
                if (!isNetworkAvailable()) {
                    this.guard.runCriticalSection(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader$$ExternalSyntheticLambda4
                        @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                        public final Object execute() {
                            return Uploader.this.m67x3eac4914(transportContext, attemptNumber);
                        }
                    });
                } else {
                    logAndUpdateState(transportContext, attemptNumber);
                }
            } catch (SynchronizationException e) {
                this.workScheduler.schedule(transportContext, attemptNumber + 1);
            }
        } finally {
            callback.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$upload$0$com-google-android-datatransport-runtime-scheduling-jobscheduling-Uploader  reason: not valid java name */
    public /* synthetic */ Object m67x3eac4914(TransportContext transportContext, int attemptNumber) {
        this.workScheduler.schedule(transportContext, attemptNumber + 1);
        return null;
    }

    public BackendResponse logAndUpdateState(final TransportContext transportContext, int attemptNumber) {
        BackendResponse response;
        TransportBackend backend = this.backendRegistry.get(transportContext.getBackendName());
        BackendResponse response2 = BackendResponse.ok(0L);
        long maxNextRequestWaitMillis = 0;
        while (((Boolean) this.guard.runCriticalSection(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader$$ExternalSyntheticLambda5
            @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
            public final Object execute() {
                return Uploader.this.m60x65f78bd8(transportContext);
            }
        })).booleanValue()) {
            final Iterable<PersistedEvent> persistedEvents = (Iterable) this.guard.runCriticalSection(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader$$ExternalSyntheticLambda6
                @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                public final Object execute() {
                    return Uploader.this.m61xa80eb937(transportContext);
                }
            });
            if (!persistedEvents.iterator().hasNext()) {
                return response2;
            }
            if (backend == null) {
                Logging.d(LOG_TAG, "Unknown backend for %s, deleting event batch for it...", transportContext);
                response = BackendResponse.fatalError();
            } else {
                List<EventInternal> eventInternals = new ArrayList<>();
                for (PersistedEvent persistedEvent : persistedEvents) {
                    eventInternals.add(persistedEvent.getEvent());
                }
                if (transportContext.shouldUploadClientHealthMetrics()) {
                    eventInternals.add(createMetricsEvent(backend));
                }
                response = backend.send(BackendRequest.builder().setEvents(eventInternals).setExtras(transportContext.getExtras()).build());
            }
            if (response.getStatus() != BackendResponse.Status.TRANSIENT_ERROR) {
                this.guard.runCriticalSection(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader$$ExternalSyntheticLambda8
                    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                    public final Object execute() {
                        return Uploader.this.m63x2c3d13f5(persistedEvents);
                    }
                });
                if (response.getStatus() == BackendResponse.Status.OK) {
                    long maxNextRequestWaitMillis2 = Math.max(maxNextRequestWaitMillis, response.getNextRequestWaitMillis());
                    if (transportContext.shouldUploadClientHealthMetrics()) {
                        this.guard.runCriticalSection(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader$$ExternalSyntheticLambda9
                            @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                            public final Object execute() {
                                return Uploader.this.m64x6e544154();
                            }
                        });
                    }
                    maxNextRequestWaitMillis = maxNextRequestWaitMillis2;
                } else if (response.getStatus() == BackendResponse.Status.INVALID_PAYLOAD) {
                    final Map<String, Integer> countMap = new HashMap<>();
                    for (PersistedEvent persistedEvent2 : persistedEvents) {
                        String logSource = persistedEvent2.getEvent().getTransportName();
                        if (!countMap.containsKey(logSource)) {
                            countMap.put(logSource, 1);
                        } else {
                            countMap.put(logSource, Integer.valueOf(countMap.get(logSource).intValue() + 1));
                        }
                    }
                    this.guard.runCriticalSection(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader$$ExternalSyntheticLambda10
                        @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                        public final Object execute() {
                            return Uploader.this.m65xb06b6eb3(countMap);
                        }
                    });
                }
                response2 = response;
            } else {
                final long finalMaxNextRequestWaitMillis1 = maxNextRequestWaitMillis;
                this.guard.runCriticalSection(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader$$ExternalSyntheticLambda7
                    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                    public final Object execute() {
                        return Uploader.this.m62xea25e696(persistedEvents, transportContext, finalMaxNextRequestWaitMillis1);
                    }
                });
                this.workScheduler.schedule(transportContext, attemptNumber + 1, true);
                return response;
            }
        }
        final long finalMaxNextRequestWaitMillis = maxNextRequestWaitMillis;
        this.guard.runCriticalSection(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader$$ExternalSyntheticLambda1
            @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
            public final Object execute() {
                return Uploader.this.m66xf2829c12(transportContext, finalMaxNextRequestWaitMillis);
            }
        });
        return response2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$logAndUpdateState$2$com-google-android-datatransport-runtime-scheduling-jobscheduling-Uploader  reason: not valid java name */
    public /* synthetic */ Boolean m60x65f78bd8(TransportContext transportContext) {
        return Boolean.valueOf(this.eventStore.hasPendingEventsFor(transportContext));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$logAndUpdateState$3$com-google-android-datatransport-runtime-scheduling-jobscheduling-Uploader  reason: not valid java name */
    public /* synthetic */ Iterable m61xa80eb937(TransportContext transportContext) {
        return this.eventStore.loadBatch(transportContext);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$logAndUpdateState$4$com-google-android-datatransport-runtime-scheduling-jobscheduling-Uploader  reason: not valid java name */
    public /* synthetic */ Object m62xea25e696(Iterable persistedEvents, TransportContext transportContext, long finalMaxNextRequestWaitMillis1) {
        this.eventStore.recordFailure(persistedEvents);
        this.eventStore.recordNextCallTime(transportContext, this.clock.getTime() + finalMaxNextRequestWaitMillis1);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$logAndUpdateState$5$com-google-android-datatransport-runtime-scheduling-jobscheduling-Uploader  reason: not valid java name */
    public /* synthetic */ Object m63x2c3d13f5(Iterable persistedEvents) {
        this.eventStore.recordSuccess(persistedEvents);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$logAndUpdateState$6$com-google-android-datatransport-runtime-scheduling-jobscheduling-Uploader  reason: not valid java name */
    public /* synthetic */ Object m64x6e544154() {
        this.clientHealthMetricsStore.resetClientMetrics();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$logAndUpdateState$7$com-google-android-datatransport-runtime-scheduling-jobscheduling-Uploader  reason: not valid java name */
    public /* synthetic */ Object m65xb06b6eb3(Map countMap) {
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            this.clientHealthMetricsStore.recordLogEventDropped(entry.getValue().intValue(), LogEventDropped.Reason.INVALID_PAYLOD, entry.getKey());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$logAndUpdateState$8$com-google-android-datatransport-runtime-scheduling-jobscheduling-Uploader  reason: not valid java name */
    public /* synthetic */ Object m66xf2829c12(TransportContext transportContext, long finalMaxNextRequestWaitMillis) {
        this.eventStore.recordNextCallTime(transportContext, this.clock.getTime() + finalMaxNextRequestWaitMillis);
        return null;
    }

    public EventInternal createMetricsEvent(TransportBackend backend) {
        SynchronizationGuard synchronizationGuard = this.guard;
        final ClientHealthMetricsStore clientHealthMetricsStore = this.clientHealthMetricsStore;
        Objects.requireNonNull(clientHealthMetricsStore);
        ClientMetrics clientMetrics = (ClientMetrics) synchronizationGuard.runCriticalSection(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader$$ExternalSyntheticLambda0
            @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
            public final Object execute() {
                return ClientHealthMetricsStore.this.loadClientMetrics();
            }
        });
        return backend.decorate(EventInternal.builder().setEventMillis(this.clock.getTime()).setUptimeMillis(this.uptimeClock.getTime()).setTransportName(CLIENT_HEALTH_METRICS_LOG_SOURCE).setEncodedPayload(new EncodedPayload(Encoding.of("proto"), clientMetrics.toByteArray())).build());
    }
}
