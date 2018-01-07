package cn.zhengjun.androidsourcedesignpatternsanalysis.chapter01;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import static cn.zhengjun.androidsourcedesignpatternsanalysis.MyUtils.closeClosable;

/**
 * Author  : Zheng Jun
 * Email   : zhengjun1987@outlook.com
 * Date    : 2018/1/7
 * Summary : 在这里描述Class的主要功能
 */

public class DiskCache implements ImageCache {
    private static String cacheDir = "sdcard/cache/";

    @Override
    public Bitmap get(String key) {
        return BitmapFactory.decodeFile(cacheDir+key);
    }

    @Override
    public Bitmap put(String key, Bitmap value) {
        Bitmap bitmap = get(key);
        FileOutputStream stream = null;
        try {
            stream = new FileOutputStream(cacheDir + key);
            value.compress(Bitmap.CompressFormat.JPEG,100,stream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeClosable(stream);
        }
        return bitmap;
    }
}
