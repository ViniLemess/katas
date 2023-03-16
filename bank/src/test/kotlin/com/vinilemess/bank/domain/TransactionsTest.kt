package com.vinilemess.bank.domain

import io.mockk.spyk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.time.LocalDate

class TransactionsTest {

    private val transactionsList: ArrayList<Transaction> = spyk()

    private val transactions = Transactions(transactionsList);

    @Test
    fun addTransaction() {
        val transaction = Transaction(LocalDate.of(2023, 9, 2), BigDecimal.valueOf(200))

        transactions.addTransaction(transaction)

        verify { transactionsList.add(transaction) }
    }

    @Test
    fun getTransactions() {
        assertEquals(0, transactions.getTransactions().size)

        verify { transactionsList.toList() }
    }
}