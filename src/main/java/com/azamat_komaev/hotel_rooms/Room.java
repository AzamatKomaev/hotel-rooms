package com.azamat_komaev.hotel_rooms;

import java.util.Objects;

class Room {
    private final HotelRoomType type;
    private int count;

    public Room(HotelRoomType type, int count) {
        checkCount(count);

        this.type = type;
        this.count = count;
    }

    private void checkCount(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("Count cannot be less or equal to 0!");
        }
    }

    public boolean shouldBeUpgraded() {
        return count <= 0;
    }

    public void book() {
        count -= 1;
    };

    public HotelRoomType getType() {
        return type;
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room room)) return false;
        return count == room.count && type == room.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, count);
    }
}
