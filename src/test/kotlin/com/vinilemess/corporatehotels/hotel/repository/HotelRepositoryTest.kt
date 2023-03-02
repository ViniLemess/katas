package com.vinilemess.corporatehotels.hotel.repository

import com.vinilemess.corporatehotels.exception.NotFoundException
import com.vinilemess.corporatehotels.hotel.model.Hotel
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.test.BeforeTest

class HotelRepositoryTest {

    private lateinit var hotelRepository: HotelRepository
    private val hotelId = 1L
    private val testHotel = Hotel(hotelId, "TestHotel");

    @BeforeTest
    fun setup() {
        hotelRepository = HotelRepository()
    }

    @Test
    fun `should insert new Hotel when hotelId does not exist`() {
        assertDoesNotThrow{
            hotelRepository.upsert(hotel = testHotel)
        }
    }

    @Test
    fun `should find hotel by id successfully`() {
        hotelRepository.upsert(hotel = testHotel)
        val hotelResult = hotelRepository.findHotelBy(hotelId)

        assertEquals(testHotel, hotelResult)
    }

    @Test
    fun `should throw not found exception when hotelId does not exist`() {
        val exception = org.junit.jupiter.api.assertThrows<NotFoundException> {
            hotelRepository.findHotelBy(hotelId)
        }
        kotlin.test.assertEquals("Hotel with id $hotelId not found", exception.message)
    }

    @Test
    fun verifyHotelExistence() {
        assertFalse(hotelRepository.verifyHotelExistence(hotelId))
        hotelRepository.upsert(hotel = testHotel)
        assertTrue(hotelRepository.verifyHotelExistence(hotelId))
    }
}