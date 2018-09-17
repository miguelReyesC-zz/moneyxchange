package com.moneyxchange.server.api.cache;

import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.expiry.Duration;
import org.ehcache.expiry.Expirations;
import org.ehcache.jsr107.Eh107Configuration;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class CacheConfig {

    @Bean
    public JCacheManagerCustomizer cacheManagerCustomizer() {
        return cm -> {
            cm.createCache("exchangeRate", createCacheConfiguration(10, TimeUnit.MINUTES));
            cm.createCache("exchangeRates", createCacheConfiguration(10, TimeUnit.MINUTES));
        };
    }

    private javax.cache.configuration.Configuration<Object, Object> createCacheConfiguration(int time, TimeUnit units) {
        return Eh107Configuration
                .fromEhcacheCacheConfiguration(CacheConfigurationBuilder
                        .newCacheConfigurationBuilder(Object.class, Object.class, ResourcePoolsBuilder
                                .newResourcePoolsBuilder().heap(100))
                        .withExpiry(Expirations.timeToLiveExpiration(Duration.of(time, units)))
                        .build());
    }

}