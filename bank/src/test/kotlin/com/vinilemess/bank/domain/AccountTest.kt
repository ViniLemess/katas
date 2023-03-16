package com.vinilemess.bank.domain

import io.mockk.*
import java.math.BigDecimal
import java.time.LocalDate
import kotlin.test.BeforeTest
import kotlin.test.Test

class AccountTest {

    private val testAmount = BigDecimal.valueOf(1000)
    private val printer: StatementPrinter = mockk()
    private val transactions: Transactions = mockk()

    private lateinit var account: Account

    @BeforeTest
    fun setup() {
        account = Account(printer, transactions)
    }

    @Test
    fun `should deposit 1000 and store the transaction successfully`() {
        val deposit = Transaction(LocalDate.now(), testAmount)
        justRun { transactions.addTransaction(deposit) }
        account.deposit(testAmount)

        verify { transactions.addTransaction(deposit) }
    }

    @Test
    fun `should withdrawal 1000 and store the transaction successfully`() {
        val withdrawal = Transaction(LocalDate.now(), testAmount.negate())
        justRun { transactions.addTransaction(withdrawal) }
        account.withdrawal(testAmount)

        verify { transactions.addTransaction(withdrawal) }
    }

    @Test
    fun `should print statement successfully`() {
        every { transactions.getTransactions() } returns listOf()
        justRun { printer.printStatement(transactions.getTransactions()) }

        account.printStatement()

        verify { printer.printStatement(transactions.getTransactions()) }
        verify { transactions.getTransactions() }
    }
}