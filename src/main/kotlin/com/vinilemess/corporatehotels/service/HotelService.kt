package com.vinilemess.corporatehotels.service

import com.vinilemess.corporatehotels.exception.ExistentHotelException
import com.vinilemess.corporatehotels.exception.NotFoundException
import com.vinilemess.corporatehotels.model.Hotel
import com.vinilemess.corporatehotels.model.RoomType

class HotelService(private val hotelRepository: HashMap<Long, Hotel>) {

    fun createHotel(hotelId: Long, hotelName: String) {
        if (verifyExistence(hotelId)) throw ExistentHotelException("Hotel with id $hotelId already exists")
        hotelRepository.put(hotelId, Hotel(hotelName, HashMap()))
    }

    fun setRoom(hotelId: Long, roomNumber: Long, roomType: RoomType) {
        if (!verifyExistence(hotelId)) throw NotFoundException("Hotel with id $hotelId not found")
        val hotel = findHotelById(hotelId)
        hotel.addRoom(roomNumber, roomType)
    }

    fun findHotelById(hotelId: Long): Hotel {
        return hotelRepository.getOrElse(hotelId) {
            throw NotFoundException("Hotel with id $hotelId not found")
        }
    }

    private fun verifyExistence(hotelId: Long): Boolean {
        return hotelRepository.containsKey(hotelId)
    }
}