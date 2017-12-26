package com.inmemorycache.storage;

import javax.annotation.Nonnull;

public interface InMemoryCache {

    @Nonnull
    String get(@Nonnull String key);

    @Nonnull
    String set(@Nonnull String key, @Nonnull String value);
}
