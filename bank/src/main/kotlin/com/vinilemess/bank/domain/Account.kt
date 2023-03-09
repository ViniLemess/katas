package com.vinilemess.bank.domain

import java.math.BigDecimal
import java.time.LocalDate

class Account(private val printer: StatementPrinter, private val transactions: ArrayList<Transaction>) {

    fun deposit(amount: BigDecimal) {
        val deposit = Transaction(LocalDate.now(), amount)
        transactions.add(deposit)
    }

    fun withdrawal(amount: BigDecimal) {
        val withdraw = Transaction(LocalDate.now(), amount.negate())
        transactions.add(withdraw)
    }

    fun printStatement() {
        printer.printStatement(transactions)
    }
}