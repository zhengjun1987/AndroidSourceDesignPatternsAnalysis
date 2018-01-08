package cn.zhengjun.androidsourcedesignpatternsanalysis.chapter01;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import cn.zhengjun.androidsourcedesignpatternsanalysis.R;

/**
 * Author  : Zheng Jun
 * Email   : zhengjun1987@outlook.com
 * Date    : 2018/1/7
 * Summary : 在这里描述Class的主要功能
 */

public class ImageLoader implements ImageCache {
    public static class Configuration {
        public static final int CACHE_POLICY_ONLY_MEMORY = 0;
        public static final int CACHE_POLICY_ONLY_DISK = 1;
        public static final int CACHE_POLICY_BOTH = 2;

        int cachePolicy;
        int threadCount;
        int loadingRes;
        int failedRes;

        public int getCachePolicy() {
            return cachePolicy;
        }

        public int getThreadCount() {
            return threadCount;
        }

        public int getLoadingRes() {
            return loadingRes;
        }

        public int getFailedRes() {
            return failedRes;
        }

        private Configuration(Builder builder) {
            cachePolicy = builder.cachePolicy;
            threadCount = builder.threadCount;
            loadingRes = builder.loadingRes;
            failedRes = builder.failedRes;
        }

        public static final class Builder {
            private int cachePolicy;
            private int threadCount;
            private int loadingRes;
            private int failedRes;

            public Builder() {
            }

            public Builder cachePolicy(int val) {
                cachePolicy = val;
                return this;
            }

            public Builder threadCount(int val) {
                threadCount = val;
                return this;
            }

            public Builder loadingRes(int val) {
                loadingRes = val;
                return this;
            }

            public Builder failedRes(int val) {
                failedRes = val;
                return this;
            }

            public Configuration build() {
                return new Configuration(this);
            }
        }
    }

    private Configuration configuration;

    public ImageLoader(Configuration configuration) {
        this.configuration = configuration;
    }

    private MemoryCache memoryCache = new MemoryCache();
    private DiskCache diskCache = new DiskCache();
    //    LruCache<String,Bitmap> mImageCache;
    private ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

//    public ImageLoader() {
//        initImageCache();
//    }

//    private void initImageCache() {
//        int cacheSize = (int) (Runtime.getRuntime().maxMemory() / 1024 / 4);
//        mImageCache = new LruCache<String, Bitmap>(cacheSize){
//            @Override
//            protected int sizeOf(String key, Bitmap value) {
//                return value.getRowBytes()*value.getHeight()/1024;
//            }
//        };
//    }

    public void displayImage(final String url, final ImageView imageView) {
        imageView.setTag(url);

        //先看缓存中是否含有该图片
        Bitmap bitmap = get(url);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
            return;
        }

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = downloadImage(url);
                if (bitmap == null) {
                    return;
                }
                if (url.equals(imageView.getTag())) {
                    imageView.setImageBitmap(bitmap);
                }
                put(url, bitmap);
            }
        });
    }

    private Bitmap downloadImage(String url) {
        Bitmap bitmap = null;
        try {
            URL url1 = new URL(url);
            HttpURLConnection httpsURLConnection = (HttpURLConnection) url1.openConnection();
            bitmap = BitmapFactory.decodeStream(httpsURLConnection.getInputStream());
            httpsURLConnection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bitmap;
    }

    @Override
    public Bitmap get(String key) {
        Bitmap bitmap = memoryCache.get(key);
        if (bitmap != null) {
            return bitmap;
        }
        bitmap = diskCache.get(key);
        return bitmap;
    }

    @Override
    public Bitmap put(String key, Bitmap value) {
        memoryCache.put(key, value);
        return diskCache.put(key, value);
    }

    public static void main(String[] args) {
        Configuration.Builder builder = new Configuration.Builder();
        builder.cachePolicy(Configuration.CACHE_POLICY_BOTH)
                .loadingRes(R.drawable.ic_launcher_background)
                .threadCount(3);
        ImageLoader imageLoader = new ImageLoader(builder.build());
    }
}
