package cn.zhengjun.androidsourcedesignpatternsanalysis.chapter03;

/**
 * Author  : Zheng Jun
 * Email   : zhengjun1987@outlook.com
 * Date    : 2018/1/8
 * Summary : 在这里描述Class的主要功能
 */

public class Constructor {
    public static void main(String[] args) {
        Computer.Builder builder  = new MacBook.MacbookBuilder();
        Computer computer = builder.buildBoard("Intel 主板").buildDisplay("Retina显示器").buildOS("").build();
        System.out.println("computer = " + computer);
    }
}
//computer = Computer{board='Intel 主板', display='Retina显示器', os='MacOS X 10.10'}
//
//Process finished with exit code 0
