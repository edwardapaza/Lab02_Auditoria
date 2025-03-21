package com.google.maps.android.collections;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.maps.android.collections.MapObjectManager;
/* loaded from: classes.dex */
public class GroundOverlayManager extends MapObjectManager<GroundOverlay, Collection> implements GoogleMap.OnGroundOverlayClickListener {
    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.maps.android.collections.GroundOverlayManager$Collection, com.google.maps.android.collections.MapObjectManager$Collection] */
    @Override // com.google.maps.android.collections.MapObjectManager
    public /* bridge */ /* synthetic */ Collection getCollection(String str) {
        return super.getCollection(str);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.maps.android.collections.GroundOverlayManager$Collection, com.google.maps.android.collections.MapObjectManager$Collection] */
    @Override // com.google.maps.android.collections.MapObjectManager
    public /* bridge */ /* synthetic */ Collection newCollection(String str) {
        return super.newCollection(str);
    }

    @Override // com.google.maps.android.collections.MapObjectManager
    public /* bridge */ /* synthetic */ boolean remove(GroundOverlay groundOverlay) {
        return super.remove(groundOverlay);
    }

    public GroundOverlayManager(GoogleMap map) {
        super(map);
    }

    @Override // com.google.maps.android.collections.MapObjectManager
    void setListenersOnUiThread() {
        if (this.mMap != null) {
            this.mMap.setOnGroundOverlayClickListener(this);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.maps.android.collections.MapObjectManager
    public Collection newCollection() {
        return new Collection();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.maps.android.collections.MapObjectManager
    public void removeObjectFromMap(GroundOverlay object) {
        object.remove();
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnGroundOverlayClickListener
    public void onGroundOverlayClick(GroundOverlay groundOverlay) {
        Collection collection = (Collection) this.mAllObjects.get(groundOverlay);
        if (collection == null || collection.mGroundOverlayClickListener == null) {
            return;
        }
        collection.mGroundOverlayClickListener.onGroundOverlayClick(groundOverlay);
    }

    /* loaded from: classes.dex */
    public class Collection extends MapObjectManager.Collection {
        private GoogleMap.OnGroundOverlayClickListener mGroundOverlayClickListener;

        public Collection() {
            super();
        }

        public GroundOverlay addGroundOverlay(GroundOverlayOptions opts) {
            GroundOverlay groundOverlay = GroundOverlayManager.this.mMap.addGroundOverlay(opts);
            super.add(groundOverlay);
            return groundOverlay;
        }

        public void addAll(java.util.Collection<GroundOverlayOptions> opts) {
            for (GroundOverlayOptions opt : opts) {
                addGroundOverlay(opt);
            }
        }

        public void addAll(java.util.Collection<GroundOverlayOptions> opts, boolean defaultVisible) {
            for (GroundOverlayOptions opt : opts) {
                addGroundOverlay(opt).setVisible(defaultVisible);
            }
        }

        public void showAll() {
            for (GroundOverlay groundOverlay : getGroundOverlays()) {
                groundOverlay.setVisible(true);
            }
        }

        public void hideAll() {
            for (GroundOverlay groundOverlay : getGroundOverlays()) {
                groundOverlay.setVisible(false);
            }
        }

        public boolean remove(GroundOverlay groundOverlay) {
            return super.remove((Collection) groundOverlay);
        }

        public java.util.Collection<GroundOverlay> getGroundOverlays() {
            return getObjects();
        }

        public void setOnGroundOverlayClickListener(GoogleMap.OnGroundOverlayClickListener groundOverlayClickListener) {
            this.mGroundOverlayClickListener = groundOverlayClickListener;
        }
    }
}
