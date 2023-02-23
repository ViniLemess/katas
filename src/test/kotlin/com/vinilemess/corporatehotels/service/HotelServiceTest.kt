package com.vinilemess.corporatehotels.service

import com.vinilemess.corporatehotels.exception.ExistentHotelException
import com.vinilemess.corporatehotels.exception.NotFoundException
import com.vinilemess.corporatehotels.model.Hotel
import com.vinilemess.corporatehotels.model.RoomType
import org.junit.jupiter.api.assertThrows
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito.verify
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import kotlin.test.Test
import kotlin.test.assertEquals

class HotelServiceTest {

    private val hotelId = 1L

    private val hotelRepository: HashMap<Long, Hotel> = mock()

    private val hotelService: HotelService = HotelService(hotelRepository)

    @Test
    fun `should create hotel successfully`() {
        hotelService.createHotel(hotelId, "Black Pearl")

        verify(hotelRepository).put(any(), any())
    }

    @Test
    fun `should validate creation of existing hotel`() {
        doReturn(true).`when`(hotelRepository).contains(hotelId)

        val exception = assertThrows<ExistentHotelException> {
            hotelService.createHotel(hotelId, "Black Pearl")
        }

        verify(hotelRepository).contains(hotelId)
        assertEquals("Hotel with id $hotelId already exists", exception.message)
    }

    @Test
    fun `test findHotelById with valid hotelId`() {
        val expectedHotel = Hotel("Test Hotel", HashMap())
        doReturn(expectedHotel).`when`(hotelRepository)[hotelId]

        val actualHotel = hotelService.findHotelById(hotelId)

        verify(hotelRepository).getOrElse(hotelId) {}

        assertEquals(expectedHotel, actualHotel)
    }

    @Test
    fun `test findHotelById with invalid hotelId`() {
        doReturn(null).`when`(hotelRepository)[hotelId]

        val exception = assertThrows<NotFoundException> {
            hotelService.findHotelById(hotelId)
        }

        assertEquals("Hotel with id $hotelId not found", exception.message)
    }

    @Test
    fun `test setRoom with existing hotel`() {
        val roomNumber = 101L
        val roomType = RoomType.SINGLE
        val hotel: Hotel = Hotel("Test Hotel", HashMap())

        doReturn(true).`when`(hotelRepository).containsKey(hotelId)
        doReturn(hotel).`when`(hotelRepository)[hotelId]

        hotelService.setRoom(hotelId, roomNumber, roomType)

        verify(hotelRepository).containsKey(hotelId)
        verify(hotelRepository)[hotelId]
    }

    @Test
    fun `test setRoom with non-existing hotel`() {
        val roomNumber = 101L
        val roomType = RoomType.SINGLE
        doReturn(false).`when`(hotelRepository).containsKey(hotelId)

        val exception = assertThrows<NotFoundException> {
            hotelService.setRoom(hotelId, roomNumber, roomType)
        }

        verify(hotelRepository).containsKey(hotelId)
        assertEquals("Hotel with id $hotelId not found", exception.message)
    }
}