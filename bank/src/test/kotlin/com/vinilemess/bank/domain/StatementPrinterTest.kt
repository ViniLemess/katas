package com.vinilemess.bank.domain

import io.mockk.spyk
import io.mockk.verify
import java.math.BigDecimal
import java.time.LocalDate
import kotlin.test.BeforeTest
import kotlin.test.Test

class StatementPrinterTest {

    private val printer: Printer = spyk()

    private lateinit var statementPrinter: StatementPrinter
    private lateinit var transactions: List<Transaction>

    @BeforeTest
    fun setup() {
        statementPrinter = StatementPrinter(printer)
        transactions = listOf(
            Transaction(LocalDate.of(2019, 8, 19), BigDecimal.valueOf(2000.55)),
            Transaction(LocalDate.of(2020, 8, 19), BigDecimal.valueOf(-200.23)),
            Transaction(LocalDate.of(2021, 8, 19), BigDecimal.valueOf(331.00))
        )
    }

    @Test
    fun `should print statement for transactions successfully`() {
        statementPrinter.printStatement(transactions)

        verify { printer.printLine("Date || Amount || Balance") }
        verify { printer.printLine("19/08/2021 || \$331.00 || \$2,131.32") }
        verify { printer.printLine("19/08/2020 || -\$200.23 || \$1,800.32") }
        verify { printer.printLine("19/08/2019 || \$2,000.55 || \$2,000.55") }
    }
}