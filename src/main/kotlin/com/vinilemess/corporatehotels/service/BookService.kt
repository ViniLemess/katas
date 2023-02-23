package com.vinilemess.corporatehotels.service

import com.vinilemess.corporatehotels.model.Reservation
import com.vinilemess.corporatehotels.model.RoomType
import java.time.LocalDate

class BookService {

    fun book(employeeId: Long, hotelId: Long, roomType: RoomType, checkIn: LocalDate, checkOut: LocalDate): Reservation {
        return Reservation();
    }
}