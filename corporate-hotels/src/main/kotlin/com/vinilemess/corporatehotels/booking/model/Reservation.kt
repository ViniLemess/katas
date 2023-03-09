package com.vinilemess.corporatehotels.booking.model

import com.vinilemess.corporatehotels.hotel.model.RoomType
import java.time.LocalDate

data class Reservation(
    val hotelId: Long,
    val employeeId: Long,
    val roomType: RoomType,
    val checkIn: LocalDate,
    val checkOut: LocalDate
) {}