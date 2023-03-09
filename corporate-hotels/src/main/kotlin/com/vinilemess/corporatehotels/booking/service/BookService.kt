package com.vinilemess.corporatehotels.booking.service

import com.vinilemess.corporatehotels.booking.model.Reservation
import com.vinilemess.corporatehotels.exception.BookPermissionDeniedException
import com.vinilemess.corporatehotels.hotel.model.RoomType
import com.vinilemess.corporatehotels.hotel.repository.HotelRepository
import com.vinilemess.corporatehotels.hotel.service.HotelService
import java.time.LocalDate
import java.time.temporal.ChronoUnit

class BookService {

    private val hotelService = HotelService(HotelRepository())
    private val bookingPolicyService = BookingPolicyService()
    private val reservationHistory: MutableMap<Long, Reservation> = HashMap()

    fun book(employeeId: Long, hotelId: Long, roomType: RoomType, checkIn: LocalDate, checkOut: LocalDate): Reservation {
        val hotel = hotelService.findHotelById(hotelId)
        val isBookingAllowed = bookingPolicyService.isBookingAllowed(employeeId, roomType)

        if (isBookingAllowed && isCheckInOneDayAfterCheckOut(checkIn, checkOut)) {
            val reservation = Reservation(employeeId, hotelId, roomType, checkIn, checkOut)
            reservationHistory[hotelId] = reservation;
            return reservation
        }
        throw BookPermissionDeniedException("Booking not allowed")
    }

    fun isCheckInOneDayAfterCheckOut(checkIn: LocalDate, checkOut: LocalDate): Boolean {
        return ChronoUnit.DAYS.between(checkIn, checkOut) > 1
    }
}