package com.bank.cache;

import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;

import com.alisoft.xplatform.asf.cache.ICache;
import com.alisoft.xplatform.asf.cache.ICacheManager;
import com.alisoft.xplatform.asf.cache.impl.DefaultCacheImpl;

public class LocalCacheManager implements ICacheManager {

	private ConcurrentHashMap<String,ICache<?,?>> cachepool;
	
	public LocalCacheManager() {
		cachepool = new ConcurrentHashMap<String, ICache<?,?>>();
	}
	public void clusterCopy(String fromCache, String cluster) {
		
	}

	public ICache<?,?> getCache(String name) {
		ICache<?,?> cache = cachepool.get(name);
		if (cache == null) {
			cache = new DefaultCacheImpl();
		}
		return cache;
	}

	public void reload(String configFile) {
		
	}

	public void setConfigFile(String configFile) {
		
	}

	public void setResponseStatInterval(int seconds) {
		
	}

	public void start() {
		
	}

	public void stop() {
		if (cachepool != null && cachepool.size() > 0)
		{
			Enumeration<String> keys = cachepool.keys();
			
			while(keys.hasMoreElements())
			{
				String cacheName = keys.nextElement();
				
				ICache cache = cachepool.get(cacheName);
				cache.clear();
			}
			
			cachepool.clear();
		}
	}

}
