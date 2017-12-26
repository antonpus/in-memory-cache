package com.inmemorycache.storage.impl;

import com.inmemorycache.storage.InMemoryCache;

import javax.annotation.Nonnull;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Optional.of;
import static java.util.Optional.ofNullable;

public class HashMapCache implements InMemoryCache {

    private static final String NIL = "nil";
    private static final String TYPE_ERROR = "type_error";

    private Map<String, Object> cache = new ConcurrentHashMap<>();

    @Nonnull
    @Override
    public String get(@Nonnull String key) {

        return ofNullable(cache.get(key))
                .map(val -> valueOrTypeError(val, String.class))
                .map(String.class::cast)
                .orElse(NIL);
    }

    @Nonnull
    @Override
    public String set(@Nonnull String key, @Nonnull String value) {
        return (String) cache.put(key, value);
    }


    private Object valueOrTypeError(Object value, Class<?> type) {
        return type.isInstance(value) ? value : TYPE_ERROR;
    }
}
