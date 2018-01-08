package cn.zhengjun.androidsourcedesignpatternsanalysis.chapter02;

/**
 * Author  : Zheng Jun
 * Email   : zhengjun1987@outlook.com
 * Date    : 2018/1/7
 * Summary : 在这里描述Class的主要功能
 */

public class Singleton {
    private Singleton() {
    }

    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static Singleton instance = new Singleton();
    }
}
