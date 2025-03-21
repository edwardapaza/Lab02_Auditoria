package com.google.maps.android.collections;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.maps.android.collections.MapObjectManager;
/* loaded from: classes.dex */
public class CircleManager extends MapObjectManager<Circle, Collection> implements GoogleMap.OnCircleClickListener {
    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.maps.android.collections.CircleManager$Collection, com.google.maps.android.collections.MapObjectManager$Collection] */
    @Override // com.google.maps.android.collections.MapObjectManager
    public /* bridge */ /* synthetic */ Collection getCollection(String str) {
        return super.getCollection(str);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.maps.android.collections.CircleManager$Collection, com.google.maps.android.collections.MapObjectManager$Collection] */
    @Override // com.google.maps.android.collections.MapObjectManager
    public /* bridge */ /* synthetic */ Collection newCollection(String str) {
        return super.newCollection(str);
    }

    @Override // com.google.maps.android.collections.MapObjectManager
    public /* bridge */ /* synthetic */ boolean remove(Circle circle) {
        return super.remove(circle);
    }

    public CircleManager(GoogleMap map) {
        super(map);
    }

    @Override // com.google.maps.android.collections.MapObjectManager
    void setListenersOnUiThread() {
        if (this.mMap != null) {
            this.mMap.setOnCircleClickListener(this);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.maps.android.collections.MapObjectManager
    public Collection newCollection() {
        return new Collection();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.maps.android.collections.MapObjectManager
    public void removeObjectFromMap(Circle object) {
        object.remove();
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnCircleClickListener
    public void onCircleClick(Circle circle) {
        Collection collection = (Collection) this.mAllObjects.get(circle);
        if (collection == null || collection.mCircleClickListener == null) {
            return;
        }
        collection.mCircleClickListener.onCircleClick(circle);
    }

    /* loaded from: classes.dex */
    public class Collection extends MapObjectManager.Collection {
        private GoogleMap.OnCircleClickListener mCircleClickListener;

        public Collection() {
            super();
        }

        public Circle addCircle(CircleOptions opts) {
            Circle circle = CircleManager.this.mMap.addCircle(opts);
            super.add(circle);
            return circle;
        }

        public void addAll(java.util.Collection<CircleOptions> opts) {
            for (CircleOptions opt : opts) {
                addCircle(opt);
            }
        }

        public void addAll(java.util.Collection<CircleOptions> opts, boolean defaultVisible) {
            for (CircleOptions opt : opts) {
                addCircle(opt).setVisible(defaultVisible);
            }
        }

        public void showAll() {
            for (Circle circle : getCircles()) {
                circle.setVisible(true);
            }
        }

        public void hideAll() {
            for (Circle circle : getCircles()) {
                circle.setVisible(false);
            }
        }

        public boolean remove(Circle circle) {
            return super.remove((Collection) circle);
        }

        public java.util.Collection<Circle> getCircles() {
            return getObjects();
        }

        public void setOnCircleClickListener(GoogleMap.OnCircleClickListener circleClickListener) {
            this.mCircleClickListener = circleClickListener;
        }
    }
}
