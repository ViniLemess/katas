package com.vinilemess.bank

import com.vinilemess.bank.domain.Account
import com.vinilemess.bank.domain.Printer
import com.vinilemess.bank.domain.StatementPrinter
import java.math.BigDecimal

fun main() {
    val account = Account(StatementPrinter(Printer()), ArrayList())

    account.deposit(BigDecimal.valueOf(1000.00))
    account.withdrawal(BigDecimal.valueOf(500.55))
    account.deposit(BigDecimal.valueOf(500.557899111))

    account.printStatement()
}