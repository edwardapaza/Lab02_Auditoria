package com.google.firebase.encoders.proto;

import com.google.firebase.encoders.proto.Protobuf;
import java.lang.annotation.Annotation;
/* loaded from: classes.dex */
public final class AtProtobuf {
    private Protobuf.IntEncoding intEncoding = Protobuf.IntEncoding.DEFAULT;
    private int tag;

    public AtProtobuf tag(int tag) {
        this.tag = tag;
        return this;
    }

    public AtProtobuf intEncoding(Protobuf.IntEncoding intEncoding) {
        this.intEncoding = intEncoding;
        return this;
    }

    public static AtProtobuf builder() {
        return new AtProtobuf();
    }

    public Protobuf build() {
        return new ProtobufImpl(this.tag, this.intEncoding);
    }

    /* loaded from: classes.dex */
    private static final class ProtobufImpl implements Protobuf {
        private final Protobuf.IntEncoding intEncoding;
        private final int tag;

        ProtobufImpl(int tag, Protobuf.IntEncoding intEncoding) {
            this.tag = tag;
            this.intEncoding = intEncoding;
        }

        @Override // java.lang.annotation.Annotation
        public Class<? extends Annotation> annotationType() {
            return Protobuf.class;
        }

        @Override // com.google.firebase.encoders.proto.Protobuf
        public int tag() {
            return this.tag;
        }

        @Override // com.google.firebase.encoders.proto.Protobuf
        public Protobuf.IntEncoding intEncoding() {
            return this.intEncoding;
        }

        @Override // java.lang.annotation.Annotation
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Protobuf) {
                Protobuf that = (Protobuf) other;
                return this.tag == that.tag() && this.intEncoding.equals(that.intEncoding());
            }
            return false;
        }

        @Override // java.lang.annotation.Annotation
        public int hashCode() {
            return (this.tag ^ 14552422) + (this.intEncoding.hashCode() ^ 2041407134);
        }

        @Override // java.lang.annotation.Annotation
        public String toString() {
            StringBuilder sb = new StringBuilder("@com.google.firebase.encoders.proto.Protobuf");
            sb.append('(');
            sb.append("tag=").append(this.tag);
            sb.append("intEncoding=").append(this.intEncoding);
            sb.append(')');
            return sb.toString();
        }
    }
}
