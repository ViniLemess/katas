package com.vinilemess.bank.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.time.LocalDate

class TransactionTest {

    @Test
    fun `should get formatted date successfully`() {
        val transaction = Transaction(LocalDate.of(2023, 3, 6), BigDecimal.valueOf(1000))

        assertEquals("06/03/2023", transaction.getFormattedDate())
    }
}