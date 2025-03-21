package io.flutter.embedding.engine.mutatorsstack;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FlutterMutatorsStack {
    private List<a> mutators = new ArrayList();
    private Matrix finalMatrix = new Matrix();
    private List<Path> finalClippingPaths = new ArrayList();

    /* loaded from: classes.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        private Matrix f3845a;

        /* renamed from: b  reason: collision with root package name */
        private Rect f3846b;

        /* renamed from: c  reason: collision with root package name */
        private float[] f3847c;

        /* renamed from: d  reason: collision with root package name */
        private b f3848d;

        public a(Matrix matrix) {
            this.f3848d = b.TRANSFORM;
            this.f3845a = matrix;
        }

        public a(Rect rect) {
            this.f3848d = b.CLIP_RECT;
            this.f3846b = rect;
        }

        public a(Rect rect, float[] fArr) {
            this.f3848d = b.CLIP_RRECT;
            this.f3846b = rect;
            this.f3847c = fArr;
        }

        public Matrix a() {
            return this.f3845a;
        }
    }

    /* loaded from: classes.dex */
    public enum b {
        CLIP_RECT,
        CLIP_RRECT,
        CLIP_PATH,
        TRANSFORM,
        OPACITY
    }

    public List<Path> getFinalClippingPaths() {
        return this.finalClippingPaths;
    }

    public Matrix getFinalMatrix() {
        return this.finalMatrix;
    }

    public List<a> getMutators() {
        return this.mutators;
    }

    public void pushClipRRect(int i5, int i6, int i7, int i8, float[] fArr) {
        Rect rect = new Rect(i5, i6, i7, i8);
        this.mutators.add(new a(rect, fArr));
        Path path = new Path();
        path.addRoundRect(new RectF(rect), fArr, Path.Direction.CCW);
        path.transform(this.finalMatrix);
        this.finalClippingPaths.add(path);
    }

    public void pushClipRect(int i5, int i6, int i7, int i8) {
        Rect rect = new Rect(i5, i6, i7, i8);
        this.mutators.add(new a(rect));
        Path path = new Path();
        path.addRect(new RectF(rect), Path.Direction.CCW);
        path.transform(this.finalMatrix);
        this.finalClippingPaths.add(path);
    }

    public void pushTransform(float[] fArr) {
        Matrix matrix = new Matrix();
        matrix.setValues(fArr);
        a aVar = new a(matrix);
        this.mutators.add(aVar);
        this.finalMatrix.preConcat(aVar.a());
    }
}
