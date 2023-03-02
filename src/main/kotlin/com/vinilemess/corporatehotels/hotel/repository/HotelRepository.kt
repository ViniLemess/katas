package com.vinilemess.corporatehotels.hotel.repository

import com.vinilemess.corporatehotels.exception.NotFoundException
import com.vinilemess.corporatehotels.hotel.model.Hotel

class HotelRepository() {

    private val hotelMap: HashMap<Long, Hotel> = HashMap()

    fun upsert(hotel: Hotel) {
        hotelMap[hotel.id] = hotel
    }

    fun findHotelBy(id: Long): Hotel {
        return hotelMap.getOrElse(id) {
            throw NotFoundException("Hotel with id $id not found")
        }
    }

    fun verifyHotelExistence(hotelId: Long): Boolean{
        return hotelMap.containsKey(hotelId)
    }
}