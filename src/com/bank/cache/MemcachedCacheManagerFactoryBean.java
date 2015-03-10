package com.bank.cache;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import com.alisoft.xplatform.asf.cache.ICacheManager;
import com.alisoft.xplatform.asf.cache.IMemcachedCache;
import com.alisoft.xplatform.asf.cache.memcached.CacheUtil;
import com.alisoft.xplatform.asf.cache.memcached.MemcachedCacheManager;



/**
* 管理Memcached 的CacheManager
*/
public class MemcachedCacheManagerFactoryBean implements FactoryBean, InitializingBean, DisposableBean {

    protected final Log logger = LogFactory.getLog(getClass());

    private ICacheManager<IMemcachedCache> cacheManager;

    public Object getObject() throws Exception {
        return cacheManager;
    }

    public Class getObjectType() {
        return this.cacheManager.getClass();
    }

    public boolean isSingleton() {
        return true;
    }

    public void afterPropertiesSet() throws Exception {
        logger.info("Initializing Memcached CacheManager");
        cacheManager = CacheUtil.getCacheManager(IMemcachedCache.class,
                MemcachedCacheManager.class.getName());
        cacheManager.start();
    }

    public void destroy() throws Exception {
        logger.info("Shutting down Memcached CacheManager");
        cacheManager.stop();
    }
}
