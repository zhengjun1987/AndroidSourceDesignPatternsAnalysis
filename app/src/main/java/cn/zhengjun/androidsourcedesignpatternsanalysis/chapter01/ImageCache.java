package cn.zhengjun.androidsourcedesignpatternsanalysis.chapter01;

import android.graphics.Bitmap;

/**
 * Author  : Zheng Jun
 * Email   : zhengjun1987@outlook.com
 * Date    : 2018/1/7
 * Summary : 在这里描述Class的主要功能
 */

interface ImageCache {
    Bitmap get(String key);

    Bitmap put(String key, Bitmap value);
}
