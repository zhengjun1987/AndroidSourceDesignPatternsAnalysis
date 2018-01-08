package cn.zhengjun.androidsourcedesignpatternsanalysis.chapter03;

/**
 * Author  : Zheng Jun
 * Email   : zhengjun1987@outlook.com
 * Date    : 2018/1/8
 * Summary : 在这里描述Class的主要功能
 */

public abstract class Computer {
    protected String board;
    protected String display;
    protected String os;

    protected Computer() {
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public void setOs(String os) {
        this.os = os;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "board='" + board + '\'' +
                ", display='" + display + '\'' +
                ", os='" + os + '\'' +
                '}';
    }

    abstract static class Builder {
        abstract Builder buildBoard(String board);
        abstract Builder buildDisplay(String display);
        abstract Builder buildOS(String os);
        abstract Computer build();
    }
}
