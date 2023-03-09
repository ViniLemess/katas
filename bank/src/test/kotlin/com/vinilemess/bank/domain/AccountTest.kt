package com.vinilemess.bank.domain

import io.mockk.justRun
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import java.math.BigDecimal
import java.time.LocalDate
import kotlin.test.BeforeTest
import kotlin.test.Test

class AccountTest {

    private val testAmount = BigDecimal.valueOf(1000)
    private val printer: StatementPrinter = mockk()
    private val transactions: ArrayList<Transaction> = spyk()

    private lateinit var account: Account

    @BeforeTest
    fun setup() {
        account = Account(printer, transactions)
    }

    @Test
    fun `should deposit 1000 and store the transaction successfully`() {
        val deposit = Transaction(LocalDate.now(), testAmount)
        account.deposit(testAmount)

        verify { transactions.add(deposit) }
    }

    @Test
    fun `should withdrawal 1000 and store the transaction successfully`() {
        val deposit = Transaction(LocalDate.now(), testAmount.negate())
        account.withdrawal(testAmount)

        verify { transactions.add(deposit) }
    }

    @Test
    fun `should print statement successfully`() {
        justRun { printer.printStatement(transactions) }

        account.printStatement()

        verify { printer.printStatement(transactions) }
    }
}