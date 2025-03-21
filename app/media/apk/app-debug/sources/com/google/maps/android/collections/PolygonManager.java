package com.google.maps.android.collections;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.maps.android.collections.MapObjectManager;
/* loaded from: classes.dex */
public class PolygonManager extends MapObjectManager<Polygon, Collection> implements GoogleMap.OnPolygonClickListener {
    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.maps.android.collections.MapObjectManager$Collection, com.google.maps.android.collections.PolygonManager$Collection] */
    @Override // com.google.maps.android.collections.MapObjectManager
    public /* bridge */ /* synthetic */ Collection getCollection(String str) {
        return super.getCollection(str);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.maps.android.collections.MapObjectManager$Collection, com.google.maps.android.collections.PolygonManager$Collection] */
    @Override // com.google.maps.android.collections.MapObjectManager
    public /* bridge */ /* synthetic */ Collection newCollection(String str) {
        return super.newCollection(str);
    }

    @Override // com.google.maps.android.collections.MapObjectManager
    public /* bridge */ /* synthetic */ boolean remove(Polygon polygon) {
        return super.remove(polygon);
    }

    public PolygonManager(GoogleMap map) {
        super(map);
    }

    @Override // com.google.maps.android.collections.MapObjectManager
    void setListenersOnUiThread() {
        if (this.mMap != null) {
            this.mMap.setOnPolygonClickListener(this);
        }
    }

    @Override // com.google.maps.android.collections.MapObjectManager
    public Collection newCollection() {
        return new Collection();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.maps.android.collections.MapObjectManager
    public void removeObjectFromMap(Polygon object) {
        object.remove();
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnPolygonClickListener
    public void onPolygonClick(Polygon polygon) {
        Collection collection = (Collection) this.mAllObjects.get(polygon);
        if (collection == null || collection.mPolygonClickListener == null) {
            return;
        }
        collection.mPolygonClickListener.onPolygonClick(polygon);
    }

    /* loaded from: classes.dex */
    public class Collection extends MapObjectManager.Collection {
        private GoogleMap.OnPolygonClickListener mPolygonClickListener;

        public Collection() {
            super();
        }

        public Polygon addPolygon(PolygonOptions opts) {
            Polygon polygon = PolygonManager.this.mMap.addPolygon(opts);
            super.add(polygon);
            return polygon;
        }

        public void addAll(java.util.Collection<PolygonOptions> opts) {
            for (PolygonOptions opt : opts) {
                addPolygon(opt);
            }
        }

        public void addAll(java.util.Collection<PolygonOptions> opts, boolean defaultVisible) {
            for (PolygonOptions opt : opts) {
                addPolygon(opt).setVisible(defaultVisible);
            }
        }

        public void showAll() {
            for (Polygon polygon : getPolygons()) {
                polygon.setVisible(true);
            }
        }

        public void hideAll() {
            for (Polygon polygon : getPolygons()) {
                polygon.setVisible(false);
            }
        }

        public boolean remove(Polygon polygon) {
            return super.remove((Collection) polygon);
        }

        public java.util.Collection<Polygon> getPolygons() {
            return getObjects();
        }

        public void setOnPolygonClickListener(GoogleMap.OnPolygonClickListener polygonClickListener) {
            this.mPolygonClickListener = polygonClickListener;
        }
    }
}
