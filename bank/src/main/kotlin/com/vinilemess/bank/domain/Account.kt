package com.vinilemess.bank.domain

import java.math.BigDecimal
import java.time.LocalDate

//TODO transformar transactions em um objeto encapsulado

class Account(private val printer: StatementPrinter,  private val transactions: Transactions) {

    fun deposit(amount: BigDecimal) {
        val deposit = Transaction(LocalDate.now(), amount)
        transactions.addTransaction(deposit)
    }

    fun withdrawal(amount: BigDecimal) {
        val withdraw = Transaction(LocalDate.now(), amount.negate())
        transactions.addTransaction(withdraw)
    }

    fun printStatement() {
        printer.printStatement(transactions.getTransactions())
    }
}