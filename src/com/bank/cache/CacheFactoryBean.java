package com.bank.cache;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;

import com.alisoft.xplatform.asf.cache.ICache;
import com.alisoft.xplatform.asf.cache.ICacheManager;
import com.alisoft.xplatform.asf.cache.IMemcachedCache;

/**
* 返回 MemcachedCache
*/
public class CacheFactoryBean implements FactoryBean, BeanNameAware, InitializingBean {

    protected final Log logger = LogFactory.getLog(getClass());

	private ICacheManager<ICache<?,?>> cacheManager;
    private String cacheName;
    private String beanName;
    private ICache cache;

	public void setCacheManager(ICacheManager<ICache<?,?>> cacheManager) {
        this.cacheManager = cacheManager;
    }

    public void setCacheName(String cacheName) {
        this.cacheName = cacheName;
    }

    public Object getObject() throws Exception {
        return cache;
    }

    public Class getObjectType() {
        return IMemcachedCache.class;
    }

    public boolean isSingleton() {
        return true; 
    }

    public void setBeanName(String name) {
        this.beanName=name;
    }

    public void afterPropertiesSet() throws Exception {
        // If no cache name given, use bean name as cache name.
       if (this.cacheName == null) {
		this.cacheName = this.beanName;
	}
        cache = cacheManager.getCache(cacheName);
    }
}
