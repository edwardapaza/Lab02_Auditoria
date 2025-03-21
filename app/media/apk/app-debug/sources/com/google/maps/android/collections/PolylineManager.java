package com.google.maps.android.collections;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.collections.MapObjectManager;
/* loaded from: classes.dex */
public class PolylineManager extends MapObjectManager<Polyline, Collection> implements GoogleMap.OnPolylineClickListener {
    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.maps.android.collections.PolylineManager$Collection, com.google.maps.android.collections.MapObjectManager$Collection] */
    @Override // com.google.maps.android.collections.MapObjectManager
    public /* bridge */ /* synthetic */ Collection getCollection(String str) {
        return super.getCollection(str);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.maps.android.collections.PolylineManager$Collection, com.google.maps.android.collections.MapObjectManager$Collection] */
    @Override // com.google.maps.android.collections.MapObjectManager
    public /* bridge */ /* synthetic */ Collection newCollection(String str) {
        return super.newCollection(str);
    }

    @Override // com.google.maps.android.collections.MapObjectManager
    public /* bridge */ /* synthetic */ boolean remove(Polyline polyline) {
        return super.remove(polyline);
    }

    public PolylineManager(GoogleMap map) {
        super(map);
    }

    @Override // com.google.maps.android.collections.MapObjectManager
    void setListenersOnUiThread() {
        if (this.mMap != null) {
            this.mMap.setOnPolylineClickListener(this);
        }
    }

    @Override // com.google.maps.android.collections.MapObjectManager
    public Collection newCollection() {
        return new Collection();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.maps.android.collections.MapObjectManager
    public void removeObjectFromMap(Polyline object) {
        object.remove();
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnPolylineClickListener
    public void onPolylineClick(Polyline polyline) {
        Collection collection = (Collection) this.mAllObjects.get(polyline);
        if (collection == null || collection.mPolylineClickListener == null) {
            return;
        }
        collection.mPolylineClickListener.onPolylineClick(polyline);
    }

    /* loaded from: classes.dex */
    public class Collection extends MapObjectManager.Collection {
        private GoogleMap.OnPolylineClickListener mPolylineClickListener;

        public Collection() {
            super();
        }

        public Polyline addPolyline(PolylineOptions opts) {
            Polyline polyline = PolylineManager.this.mMap.addPolyline(opts);
            super.add(polyline);
            return polyline;
        }

        public void addAll(java.util.Collection<PolylineOptions> opts) {
            for (PolylineOptions opt : opts) {
                addPolyline(opt);
            }
        }

        public void addAll(java.util.Collection<PolylineOptions> opts, boolean defaultVisible) {
            for (PolylineOptions opt : opts) {
                addPolyline(opt).setVisible(defaultVisible);
            }
        }

        public void showAll() {
            for (Polyline polyline : getPolylines()) {
                polyline.setVisible(true);
            }
        }

        public void hideAll() {
            for (Polyline polyline : getPolylines()) {
                polyline.setVisible(false);
            }
        }

        public boolean remove(Polyline polyline) {
            return super.remove((Collection) polyline);
        }

        public java.util.Collection<Polyline> getPolylines() {
            return getObjects();
        }

        public void setOnPolylineClickListener(GoogleMap.OnPolylineClickListener polylineClickListener) {
            this.mPolylineClickListener = polylineClickListener;
        }
    }
}
