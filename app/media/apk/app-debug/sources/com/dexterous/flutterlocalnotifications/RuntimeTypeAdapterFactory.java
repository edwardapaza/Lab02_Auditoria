package com.dexterous.flutterlocalnotifications;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public final class RuntimeTypeAdapterFactory<T> implements TypeAdapterFactory {
    private final Class<?> baseType;
    private final Map<String, Class<?>> labelToSubtype = new LinkedHashMap();
    private final Map<Class<?>, String> subtypeToLabel = new LinkedHashMap();
    private final String typeFieldName;

    private RuntimeTypeAdapterFactory(Class<?> baseType, String typeFieldName) {
        if (typeFieldName == null || baseType == null) {
            throw new NullPointerException();
        }
        this.baseType = baseType;
        this.typeFieldName = typeFieldName;
    }

    public static <T> RuntimeTypeAdapterFactory<T> of(Class<T> baseType, String typeFieldName) {
        return new RuntimeTypeAdapterFactory<>(baseType, typeFieldName);
    }

    public static <T> RuntimeTypeAdapterFactory<T> of(Class<T> baseType) {
        return new RuntimeTypeAdapterFactory<>(baseType, "type");
    }

    public RuntimeTypeAdapterFactory<T> registerSubtype(Class<? extends T> type, String label) {
        if (type == null || label == null) {
            throw new NullPointerException();
        }
        if (this.subtypeToLabel.containsKey(type) || this.labelToSubtype.containsKey(label)) {
            throw new IllegalArgumentException("types and labels must be unique");
        }
        this.labelToSubtype.put(label, type);
        this.subtypeToLabel.put(type, label);
        return this;
    }

    public RuntimeTypeAdapterFactory<T> registerSubtype(Class<? extends T> type) {
        return registerSubtype(type, type.getSimpleName());
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <R> TypeAdapter<R> create(Gson gson, TypeToken<R> type) {
        if (type.getRawType() != this.baseType) {
            return null;
        }
        final Map<String, TypeAdapter<?>> labelToDelegate = new LinkedHashMap<>();
        final Map<Class<?>, TypeAdapter<?>> subtypeToDelegate = new LinkedHashMap<>();
        for (Map.Entry<String, Class<?>> entry : this.labelToSubtype.entrySet()) {
            TypeAdapter<?> delegate = gson.getDelegateAdapter(this, TypeToken.get((Class) entry.getValue()));
            labelToDelegate.put(entry.getKey(), delegate);
            subtypeToDelegate.put(entry.getValue(), delegate);
        }
        return new TypeAdapter<R>() { // from class: com.dexterous.flutterlocalnotifications.RuntimeTypeAdapterFactory.1
            @Override // com.google.gson.TypeAdapter
            public R read(JsonReader in) throws IOException {
                JsonElement jsonElement = Streams.parse(in);
                JsonElement labelJsonElement = jsonElement.getAsJsonObject().remove(RuntimeTypeAdapterFactory.this.typeFieldName);
                if (labelJsonElement == null) {
                    throw new JsonParseException("cannot deserialize " + RuntimeTypeAdapterFactory.this.baseType + " because it does not define a field named " + RuntimeTypeAdapterFactory.this.typeFieldName);
                }
                String label = labelJsonElement.getAsString();
                TypeAdapter<R> delegate2 = (TypeAdapter) labelToDelegate.get(label);
                if (delegate2 == null) {
                    throw new JsonParseException("cannot deserialize " + RuntimeTypeAdapterFactory.this.baseType + " subtype named " + label + "; did you forget to register a subtype?");
                }
                return delegate2.fromJsonTree(jsonElement);
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter out, R value) throws IOException {
                Class<?> srcType = value.getClass();
                String label = (String) RuntimeTypeAdapterFactory.this.subtypeToLabel.get(srcType);
                TypeAdapter<R> delegate2 = (TypeAdapter) subtypeToDelegate.get(srcType);
                if (delegate2 == null) {
                    throw new JsonParseException("cannot serialize " + srcType.getName() + "; did you forget to register a subtype?");
                }
                JsonObject jsonObject = delegate2.toJsonTree(value).getAsJsonObject();
                if (jsonObject.has(RuntimeTypeAdapterFactory.this.typeFieldName)) {
                    throw new JsonParseException("cannot serialize " + srcType.getName() + " because it already defines a field named " + RuntimeTypeAdapterFactory.this.typeFieldName);
                }
                JsonObject clone = new JsonObject();
                clone.add(RuntimeTypeAdapterFactory.this.typeFieldName, new JsonPrimitive(label));
                for (Map.Entry<String, JsonElement> e : jsonObject.entrySet()) {
                    clone.add(e.getKey(), e.getValue());
                }
                Streams.write(clone, out);
            }
        }.nullSafe();
    }
}
