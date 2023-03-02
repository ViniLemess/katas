package com.vinilemess.corporatehotels.service

import com.vinilemess.corporatehotels.exception.ExistentHotelException
import com.vinilemess.corporatehotels.exception.NotFoundException
import com.vinilemess.corporatehotels.hotel.model.Hotel
import com.vinilemess.corporatehotels.hotel.model.RoomType
import com.vinilemess.corporatehotels.hotel.repository.HotelRepository
import com.vinilemess.corporatehotels.hotel.service.HotelService
import io.mockk.*
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals

class HotelServiceTest {

    private val hotelId = 1L

    private val hotelRepository: HotelRepository = mockk()

    private val hotelService: HotelService = HotelService(hotelRepository)

    @Test
    fun `should create hotel successfully`() {
        every { hotelRepository.verifyHotelExistence(hotelId) } returns false
        justRun { hotelRepository.upsert(any()) }
        hotelService.createHotel(hotelId, "Black Pearl")

        verify { hotelRepository.verifyHotelExistence(hotelId) }
        verify { hotelRepository.upsert(any()) }
    }

    @Test
    fun `should return exception when creating existing hotel`() {
        every { hotelRepository.verifyHotelExistence(hotelId) } returns true

        val exception = assertThrows<ExistentHotelException> {
            hotelService.createHotel(hotelId, "Black Pearl")
        }

        verify { hotelRepository.verifyHotelExistence(hotelId) }
        assertEquals("Hotel with id $hotelId already exists", exception.message)
    }

    @Test
    fun `test findHotelById with valid hotelId`() {
        val expectedHotel = Hotel(hotelId,"Test Hotel")
        every { hotelRepository.findHotelBy(hotelId) } returns expectedHotel

        val actualHotel = hotelService.findHotelById(hotelId)

        verify { hotelRepository.findHotelBy(hotelId) }
        assertEquals(expectedHotel, actualHotel)
    }

    @Test
    fun `test findHotelById with invalid hotelId`() {
        every { hotelRepository.findHotelBy(hotelId) } throws NotFoundException("Hotel with id $hotelId not found")

        val exception = assertThrows<NotFoundException> {
            hotelService.findHotelById(hotelId)
        }

        verify { hotelRepository.findHotelBy(hotelId) }
        assertEquals("Hotel with id $hotelId not found", exception.message)
    }

    @Test
    fun `test setRoom with existing hotel`() {
        val roomNumber = 101L
        val roomType = RoomType.SINGLE
        val hotel: Hotel = Hotel(hotelId,"Test Hotel")

        justRun { hotelRepository.upsert(any()) }
        every { hotelRepository.findHotelBy(hotelId) } returns hotel

        hotelService.setRoom(hotelId, roomNumber, roomType)

        verify { hotelRepository.upsert(any()) }
        verify { hotelRepository.findHotelBy(hotelId) }
    }

    @Test
    fun `test setRoom with non-existing hotel`() {
        val roomNumber = 101L
        val roomType = RoomType.SINGLE
        every { hotelRepository.findHotelBy(hotelId) } throws NotFoundException("Hotel with id $hotelId not found")

        val exception = assertThrows<NotFoundException> {
            hotelService.setRoom(hotelId, roomNumber, roomType)
        }

        verify { hotelRepository.findHotelBy(hotelId) }
        assertEquals("Hotel with id $hotelId not found", exception.message)
    }
}