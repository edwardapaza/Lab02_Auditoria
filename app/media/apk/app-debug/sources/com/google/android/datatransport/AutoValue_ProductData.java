package com.google.android.datatransport;
/* loaded from: classes.dex */
final class AutoValue_ProductData extends ProductData {
    private final Integer productId;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ProductData(Integer productId) {
        this.productId = productId;
    }

    @Override // com.google.android.datatransport.ProductData
    public Integer getProductId() {
        return this.productId;
    }

    public String toString() {
        return "ProductData{productId=" + this.productId + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof ProductData) {
            ProductData that = (ProductData) o;
            Integer num = this.productId;
            return num == null ? that.getProductId() == null : num.equals(that.getProductId());
        }
        return false;
    }

    public int hashCode() {
        int h$ = 1 * 1000003;
        Integer num = this.productId;
        return h$ ^ (num == null ? 0 : num.hashCode());
    }
}
