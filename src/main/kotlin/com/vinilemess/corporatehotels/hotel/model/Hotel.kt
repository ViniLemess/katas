package com.vinilemess.corporatehotels.hotel.model

class Hotel(val id: Long, val name: String) {

    private val rooms: MutableList<HotelRoom> = ArrayList()
    fun addRoom(roomNumber: Long, roomType: RoomType) {
        rooms.add(HotelRoom(roomNumber, roomType))
    }

    fun getRooms(): List<HotelRoom> {
        return rooms.toList()
    }
}
