package cn.zhengjun.androidsourcedesignpatternsanalysis.chapter01;

import java.util.List;

/**
 * Author  : Zheng Jun
 * Email   : zhengjun1987@outlook.com
 * Date    : 2018/1/7
 * Summary : 在这里描述Class的主要功能
 */

public class Tenant {
    private float area;
    private float price;
    public static final float diffArea = 1.0f;
    public static final float diffPrice = 100.0f;

    public Tenant(float area, float price) {
        this.area = area;
        this.price = price;
    }

    public float getArea() {
        return area;
    }

    public float getPrice() {
        return price;
    }

    public void rentRoom(Agent agent) {
//        List<Room> roomList = agent.getRoomList();
//        for (Room room : roomList) {
//            if (isRoomSuitable(room)) {
//                System.out.println("租到房间了  room = " + room);
//            }
//        }
        Room room = agent.rent(this);
        if (room != null) {
            System.out.println("租到房间了  room = " + room);
        }
    }

    private boolean isRoomSuitable(Room room) {
        return Math.abs(room.getPrice() - getPrice()) <= diffPrice && Math.abs(room.getArea() - getArea()) <= diffArea;
    }
}
