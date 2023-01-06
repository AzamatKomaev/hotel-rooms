package com.azamat_komaev.hotel_rooms;

import java.util.Map;
import java.util.TreeMap;

public class Hotel {
    TreeMap<HotelRoomType, Room> rooms;

    public Hotel() {
        rooms = new TreeMap<>();

        rooms.put(HotelRoomType.LOW, new Room(HotelRoomType.LOW, 3));
        rooms.put(HotelRoomType.AVERAGE, new Room(HotelRoomType.AVERAGE, 4));
        rooms.put(HotelRoomType.HIGH, new Room(HotelRoomType.HIGH, 2));
    }

    private boolean shouldRoomBeUpgraded(Room room) {
        return room.getCount() == 0;
    }

    private Room upgradeRoomWhileNotBecomeValid(HotelRoomType roomType) {
        Room roomToUpgrade;

        do {
            try {
                Map.Entry<HotelRoomType, Room> entry = rooms.higherEntry(roomType);
                roomType = entry.getKey();
                roomToUpgrade = entry.getValue();
            } catch (NullPointerException e) {
                return null;
            }
        } while (roomToUpgrade.shouldBeUpgraded());
        return roomToUpgrade;
    }

    public void bookRoom(HotelRoomType roomType) {
        Room room = rooms.get(roomType);

        if (!shouldRoomBeUpgraded(room)) {
            room.book();
            System.out.println("The " + room.getType() + " room was booked successfully!");
            return;
        }

        System.out.println("The room you chose was not booked successfully. So, we will choose another room for you!");
        Room roomToUpgrade = upgradeRoomWhileNotBecomeValid(roomType);

        if (roomToUpgrade == null) {
            System.out.println("We are sorry, we can't give you any room in our hotel!");
            return;
        }

        roomToUpgrade.book();
        System.out.println("The " + roomToUpgrade.getType() + " room was booked successfully!");
    }
}
