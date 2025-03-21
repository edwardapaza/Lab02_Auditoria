package com.google.android.datatransport;
/* loaded from: classes.dex */
final class AutoValue_Event<T> extends Event<T> {
    private final Integer code;
    private final T payload;
    private final Priority priority;
    private final ProductData productData;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_Event(Integer code, T payload, Priority priority, ProductData productData) {
        this.code = code;
        if (payload == null) {
            throw new NullPointerException("Null payload");
        }
        this.payload = payload;
        if (priority == null) {
            throw new NullPointerException("Null priority");
        }
        this.priority = priority;
        this.productData = productData;
    }

    @Override // com.google.android.datatransport.Event
    public Integer getCode() {
        return this.code;
    }

    @Override // com.google.android.datatransport.Event
    public T getPayload() {
        return this.payload;
    }

    @Override // com.google.android.datatransport.Event
    public Priority getPriority() {
        return this.priority;
    }

    @Override // com.google.android.datatransport.Event
    public ProductData getProductData() {
        return this.productData;
    }

    public String toString() {
        return "Event{code=" + this.code + ", payload=" + this.payload + ", priority=" + this.priority + ", productData=" + this.productData + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof Event) {
            Event<?> that = (Event) o;
            Integer num = this.code;
            if (num != null ? num.equals(that.getCode()) : that.getCode() == null) {
                if (this.payload.equals(that.getPayload()) && this.priority.equals(that.getPriority())) {
                    ProductData productData = this.productData;
                    if (productData == null) {
                        if (that.getProductData() == null) {
                            return true;
                        }
                    } else if (productData.equals(that.getProductData())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int h$ = 1 * 1000003;
        Integer num = this.code;
        int h$2 = (((((h$ ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.payload.hashCode()) * 1000003) ^ this.priority.hashCode()) * 1000003;
        ProductData productData = this.productData;
        return h$2 ^ (productData != null ? productData.hashCode() : 0);
    }
}
