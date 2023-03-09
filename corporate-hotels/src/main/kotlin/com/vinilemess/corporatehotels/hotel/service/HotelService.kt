package com.vinilemess.corporatehotels.hotel.service

import com.vinilemess.corporatehotels.exception.ExistentHotelException
import com.vinilemess.corporatehotels.hotel.model.Hotel
import com.vinilemess.corporatehotels.hotel.model.RoomType
import com.vinilemess.corporatehotels.hotel.repository.HotelRepository

class HotelService(private val hotelRepository: HotelRepository) {

    fun createHotel(hotelId: Long, hotelName: String) {
        validateDoubleRegistry(hotelId)
        hotelRepository.upsert(Hotel(hotelId, hotelName))
    }

    fun setRoom(hotelId: Long, roomNumber: Long, roomType: RoomType) {
        val hotel = findHotelById(hotelId)
        hotel.addRoom(roomNumber, roomType)
        hotelRepository.upsert(hotel)
    }

    fun findHotelById(hotelId: Long): Hotel {
        return hotelRepository.findHotelBy(hotelId)
    }

    private fun validateDoubleRegistry(hotelId: Long) {
        if (hotelRepository.verifyHotelExistence(hotelId)) throw ExistentHotelException("Hotel with id $hotelId already exists")
    }
}