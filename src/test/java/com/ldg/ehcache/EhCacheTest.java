package com.ldg.ehcache;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.integrations.shiro.EhcacheShiroManager;
import org.junit.Test;

import java.net.URL;

/**
 * Created by LiuDongguang on 2017/7/24.
 */
public class EhCacheTest {
    @Test
    public void t1() throws Exception {
        CacheManager cacheManager
                = CacheManagerBuilder.newCacheManagerBuilder()
                .withCache("preConfigured",
                        CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, String.class, ResourcePoolsBuilder.heap(10)))
                .build();
        cacheManager.init();

        Cache<Long, String> preConfigured =
                cacheManager.getCache("preConfigured", Long.class, String.class);

        Cache<Integer, String> myCache = cacheManager.createCache("myCache",
                CacheConfigurationBuilder.newCacheConfigurationBuilder(Integer.class, String.class, ResourcePoolsBuilder.heap(10)).build());

        for (int i = 0; i <= 20; i++) {
            //写
            myCache.put(i, "@" + i);
            //读
            String value = myCache.get(i);
            System.out.println("get at " + i + ":" + value);
        }

        cacheManager.removeCache("preConfigured");
        cacheManager.close();

    }

    private static String stripPrefix(String resourcePath) {
        return resourcePath.substring(resourcePath.indexOf(":") + 1);
    }

    @Test
    public void t2() throws Exception {
        URL resource = EhcacheShiroManager.class.getClass().getResource(stripPrefix("classpath:/ehcache.xml"));
        System.out.println(resource);
    }

    @Test
    public void t3() throws Exception {
        EhcacheShiroManager e = new EhcacheShiroManager();
       // e.setCacheManagerConfigFile("classpath:/ehcache.xml");
        e.init();
    }

}
