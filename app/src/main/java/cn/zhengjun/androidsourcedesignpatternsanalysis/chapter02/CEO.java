package cn.zhengjun.androidsourcedesignpatternsanalysis.chapter02;

/**
 * Author  : Zheng Jun
 * Email   : zhengjun1987@outlook.com
 * Date    : 2018/1/7
 * Summary : 在这里描述Class的主要功能
 */

public class CEO extends Staff {
    private static CEO ceo = new CEO();

    public static CEO getInstance() {
        return ceo;
    }

    private CEO() {
    }

    @Override
    void work() {
        System.out.println("CEO.work");
    }
}
