package com.vinilemess.corporatehotels.model

class Hotel(private val name: String, private val rooms: HashMap<Long, HotelRoom>) {

    fun addRoom(roomNumber: Long, roomType: RoomType) {
        rooms[roomNumber] = HotelRoom(false, roomType)
    }
}
