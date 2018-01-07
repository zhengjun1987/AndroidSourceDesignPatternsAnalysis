package cn.zhengjun.androidsourcedesignpatternsanalysis.chapter01;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * Author  : Zheng Jun
 * Email   : zhengjun1987@outlook.com
 * Date    : 2018/1/7
 * Summary : 在这里描述Class的主要功能
 */

public class MemoryCache implements ImageCache {
    private LruCache<String,Bitmap> lruCache;

    MemoryCache() {
        initCache();
    }

    private void initCache() {
        int cacheSize = (int) (Runtime.getRuntime().maxMemory() / 4096);
        lruCache = new LruCache<String, Bitmap>(cacheSize){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes()*value.getHeight()/1024;
            }
        };
    }

    @Override
    public Bitmap get(String key) {
        return lruCache.get(key);
    }

    @Override
    public Bitmap put(String key, Bitmap value) {
        return lruCache.put(key, value);
    }
}
