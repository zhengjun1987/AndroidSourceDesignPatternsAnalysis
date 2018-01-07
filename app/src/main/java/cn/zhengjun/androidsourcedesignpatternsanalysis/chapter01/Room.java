package cn.zhengjun.androidsourcedesignpatternsanalysis.chapter01;

/**
 * Author  : Zheng Jun
 * Email   : zhengjun1987@outlook.com
 * Date    : 2018/1/7
 * Summary : 在这里描述Class的主要功能
 */

public class Room {
    private float area;
    private float price;

    public Room(float area, float price) {
        this.area = area;
        this.price = price;
    }

    public float getArea() {
        return area;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Room{" +
                "area=" + area +
                ", price=" + price +
                '}';
    }
}
