package com.spring;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.spring.cache.HazelcastCacheManager;

@Configuration
@Profile("hazelcast-cache")
public class HazelcastCacheConfig {

	@Bean
	public Config hazelCastConfig() {
		Config config = new Config();
		config.setInstanceName("hazelcast-cache");
		MapConfig allUsersCache = new MapConfig();
		allUsersCache.setTimeToLiveSeconds(20);
		allUsersCache.setEvictionPolicy(EvictionPolicy.LFU);
		config.getMapConfigs().put("alluserscache", allUsersCache);
		MapConfig usercache = new MapConfig();
		usercache.setTimeToLiveSeconds(20);
		usercache.setEvictionPolicy(EvictionPolicy.LFU);
		config.getMapConfigs().put("usercache", usercache);
		return config;

	}

	@Bean
	public HazelcastInstance hazelcastInstance() {
		Config config = new Config();
		config.setProperty("hazelcast.jmx", "true");
		return Hazelcast.newHazelcastInstance(config);
	}

	@Bean
	public CacheManager cacheManager() {
		// The Stormpath SDK knows to use the Spring CacheManager automatically
		return new HazelcastCacheManager(hazelcastInstance());
	}

}
