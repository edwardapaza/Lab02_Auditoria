package io.flutter.plugins.googlemaps;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.maps.model.Tile;
import com.google.android.gms.maps.model.TileProvider;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.googlemaps.TileProviderController;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class TileProviderController implements TileProvider {
    private static final String TAG = "TileProviderController";
    protected final Handler handler = new Handler(Looper.getMainLooper());
    protected final MethodChannel methodChannel;
    protected final String tileOverlayId;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TileProviderController(MethodChannel methodChannel, String tileOverlayId) {
        this.tileOverlayId = tileOverlayId;
        this.methodChannel = methodChannel;
    }

    @Override // com.google.android.gms.maps.model.TileProvider
    public Tile getTile(int x, int y, int zoom) {
        Worker worker = new Worker(x, y, zoom);
        return worker.getTile();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class Worker implements MethodChannel.Result {
        private final CountDownLatch countDownLatch = new CountDownLatch(1);
        private Map<String, ?> result;
        private final int x;
        private final int y;
        private final int zoom;

        Worker(int x, int y, int zoom) {
            this.x = x;
            this.y = y;
            this.zoom = zoom;
        }

        Tile getTile() {
            TileProviderController.this.handler.post(new Runnable() { // from class: io.flutter.plugins.googlemaps.TileProviderController$Worker$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    TileProviderController.Worker.this.m156xd966c09e();
                }
            });
            try {
                this.countDownLatch.await();
                try {
                    return Convert.interpretTile(this.result);
                } catch (Exception e) {
                    Log.e(TileProviderController.TAG, "Can't parse tile data", e);
                    return TileProvider.NO_TILE;
                }
            } catch (InterruptedException e2) {
                Log.e(TileProviderController.TAG, String.format("countDownLatch: can't get tile: x = %d, y= %d, zoom = %d", Integer.valueOf(this.x), Integer.valueOf(this.y), Integer.valueOf(this.zoom)), e2);
                return TileProvider.NO_TILE;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$getTile$0$io-flutter-plugins-googlemaps-TileProviderController$Worker  reason: not valid java name */
        public /* synthetic */ void m156xd966c09e() {
            TileProviderController.this.methodChannel.invokeMethod("tileOverlay#getTile", Convert.tileOverlayArgumentsToJson(TileProviderController.this.tileOverlayId, this.x, this.y, this.zoom), this);
        }

        @Override // io.flutter.plugin.common.MethodChannel.Result
        public void success(Object data) {
            this.result = (Map) data;
            this.countDownLatch.countDown();
        }

        @Override // io.flutter.plugin.common.MethodChannel.Result
        public void error(String errorCode, String errorMessage, Object data) {
            Log.e(TileProviderController.TAG, "Can't get tile: errorCode = " + errorCode + ", errorMessage = " + errorCode + ", date = " + data);
            this.result = null;
            this.countDownLatch.countDown();
        }

        @Override // io.flutter.plugin.common.MethodChannel.Result
        public void notImplemented() {
            Log.e(TileProviderController.TAG, "Can't get tile: notImplemented");
            this.result = null;
            this.countDownLatch.countDown();
        }
    }
}
