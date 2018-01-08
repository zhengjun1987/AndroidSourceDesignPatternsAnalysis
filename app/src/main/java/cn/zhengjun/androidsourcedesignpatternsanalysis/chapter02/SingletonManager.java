package cn.zhengjun.androidsourcedesignpatternsanalysis.chapter02;

import java.util.HashMap;
import java.util.Map;

/**
 * Author  : Zheng Jun
 * Email   : zhengjun1987@outlook.com
 * Date    : 2018/1/7
 * Summary : 在这里描述Class的主要功能
 */

public class SingletonManager {
    private static Map<String,Object> objectMap = new HashMap<>();

    private SingletonManager() {
    }

    public static void registerService(String key,Object instance) {
        if (!objectMap.containsKey(key)) {
            objectMap.put(key,instance);
        }
    }

    public static Object getService(String key){
        return objectMap.get(key);
    }
}
