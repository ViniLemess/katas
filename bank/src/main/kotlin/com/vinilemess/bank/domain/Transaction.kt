package com.vinilemess.bank.domain

import java.math.BigDecimal
import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class Transaction(val date: LocalDate, val amount: BigDecimal) {

    fun getFormattedDate(): String {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy").format(date)
    }
}