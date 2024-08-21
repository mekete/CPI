package edu.uw.cpi.util;

import edu.uw.cpi.model.BlsResponse;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheHelper {

    private CacheManager cacheManager;
    private Cache<BlsResponse, BlsResponse> cache;

    public CacheHelper() {
        cacheManager = CacheManagerBuilder.newCacheManagerBuilder().build();
        cacheManager.init();

        cache = cacheManager
                .createCache("BlsResponse", CacheConfigurationBuilder
                        .newCacheConfigurationBuilder(
                                BlsResponse.class, BlsResponse.class,
                                ResourcePoolsBuilder.heap(10)));
    }

    public Cache<BlsResponse, BlsResponse> getSquareNumberCacheFromCacheManager() {
        return cacheManager.getCache("BlsResponse", BlsResponse.class, BlsResponse.class);
    }

}
