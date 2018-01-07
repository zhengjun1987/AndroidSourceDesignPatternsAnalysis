package cn.zhengjun.androidsourcedesignpatternsanalysis.chapter01;

import java.util.ArrayList;
import java.util.List;

import static cn.zhengjun.androidsourcedesignpatternsanalysis.chapter01.Tenant.diffArea;
import static cn.zhengjun.androidsourcedesignpatternsanalysis.chapter01.Tenant.diffPrice;

/**
 * Author  : Zheng Jun
 * Email   : zhengjun1987@outlook.com
 * Date    : 2018/1/7
 * Summary : 在这里描述Class的主要功能
 */

public class Agent {
    private List<Room> roomList = new ArrayList<>();

    public Agent() {
        for (int i = 0; i < 5; i++) {
            roomList.add(new Room(14+i,(14+i)*150));
        }
    }

//    public List<Room> getRoomList() {
//        return roomList;
//    }

    Room rent(Tenant tenant){
        for (Room room : roomList) {
            if (isRoomSuitable(room,tenant)) {
                return room;
            }
        }
        return null;
    }

    private boolean isRoomSuitable(Room room,Tenant tenant) {
        return Math.abs(room.getPrice() - tenant.getPrice()) <= diffPrice && Math.abs(room.getArea() - tenant.getArea()) <= diffArea;
    }
}
