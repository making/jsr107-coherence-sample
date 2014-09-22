package jsr107;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.spi.CachingProvider;

public class Sample {

    public static void configureCache() {
        CachingProvider cachingProvider = Caching.getCachingProvider();
        CacheManager cacheManager = cachingProvider.getCacheManager();
        MutableConfiguration<String, Integer> config =
                new MutableConfiguration<>();
        config.setTypes(String.class, Integer.class);
        cacheManager.createCache("helloCache", config);
    }

    public static void main(String[] args) {
        configureCache();

        CachingProvider cachingProvider = Caching.getCachingProvider();
        CacheManager cacheManager = cachingProvider.getCacheManager();
        Cache<String, Integer> cache = cacheManager.getCache("helloCache", String.class, Integer.class);

        cache.put("hoge", 100);
        System.out.println(cache.get("hoge"));

        cacheManager.close();
    }
}
