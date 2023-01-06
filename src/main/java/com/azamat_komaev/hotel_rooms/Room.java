package com.azamat_komaev.hotel_rooms;

import com.azamat_komaev.hotel_rooms.HotelRoomType;

class Room {
    private final HotelRoomType type;
    private int count;
    private int price;

    public Room(HotelRoomType type, int count, int price) {
        checkCountAndPrice(count, price);

        this.type = type;
        this.count = count;
        this.price = price;
    }

    private void checkCountAndPrice(int count, int price) {
        if (count <= 0 || price <= 0) {
            throw new IllegalArgumentException("Count and price cannot be less or equal to 0!");
        }
    }

    public boolean book() {
        if (count == 0) {
            return false;
        }

        count -= 1;
        return true;
    };
}
