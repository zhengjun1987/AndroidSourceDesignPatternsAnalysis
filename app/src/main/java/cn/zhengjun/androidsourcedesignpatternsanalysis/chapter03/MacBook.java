package cn.zhengjun.androidsourcedesignpatternsanalysis.chapter03;

/**
 * Author  : Zheng Jun
 * Email   : zhengjun1987@outlook.com
 * Date    : 2018/1/8
 * Summary : 在这里描述Class的主要功能
 */

public class MacBook extends Computer {
    protected MacBook() {
    }

    @Override
    public void setOs(String os) {
        this.os = "MacOS X 10.10";
    }

    static class MacbookBuilder extends Builder {

        private MacBook macBook = new MacBook();

        @Override
        Builder buildBoard(String board) {
            macBook.setBoard(board);
            return this;
        }

        @Override
        Builder buildDisplay(String display) {
            macBook.setDisplay(display);
            return this;
        }

        @Override
        Builder buildOS(String os) {
            macBook.setOs(os);
            return this;
        }

        @Override
        Computer build() {
            return macBook;
        }
    }
}
