package cn.zhengjun.androidsourcedesignpatternsanalysis.chapter02;

/**
 * Author  : Zheng Jun
 * Email   : zhengjun1987@outlook.com
 * Date    : 2018/1/7
 * Summary : 在这里描述Class的主要功能
 */

public enum SingletonEnum {
    INSTANCE("akslkhd") {
        @Override
        public void method1() {
            super.method1();
        }

        @Override
        public void method2() {
            System.out.println("SingletonEnum.INSTANCE.method2");
        }
    }, COPY("COPY") {
        @Override
        public void method1() {
            super.method1();
        }

        @Override
        public void method2() {
            super.method2();
        }
    };//默认枚举的创建是线程安全的，在任何情况下都只有一个实例

    public void method1() {
        System.out.println("SingletonEnum.method1");
    }

    public void method2() {
        System.out.println("SingletonEnum.method2");
    }

    String name;

    SingletonEnum(String name) {
        this.name = name;
    }
}
