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

/**
 * Author  : Zheng Jun
 * Email   : zhengjun1987@outlook.com
 * Date    : 2018/1/7
 * Summary : 在这里描述Class的主要功能
 */

public class ImageLoader implements ImageCache {
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
}
