package com.vinilemess.bank.domain

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*
import java.util.concurrent.atomic.AtomicReference

private const val HEADER = "Date || Amount || Balance"

class StatementPrinter(private val printer: Printer) {

    fun printStatement(transactions: List<Transaction>) {
        printHeader()
        getStatementLines(transactions).reversed().forEach {
            printer.printLine(it)
        }
    }

    private fun printHeader() {
        printer.printLine(HEADER)
    }

    private fun getStatementLines(transactions: List<Transaction>): List<String> {
        val runningBalance: AtomicReference<BigDecimal> = AtomicReference(BigDecimal.ZERO)
        return transactions.map { transaction -> buildStatementLine(runningBalance, transaction) }
    }

    private fun buildStatementLine(runningBalance: AtomicReference<BigDecimal>, transaction: Transaction): String {
        addToBalanceSum(runningBalance, transaction.amount)
        return "${transaction.getFormattedDate()} || ${toCurrencyFormat(transaction.amount)} || ${toCurrencyFormat(runningBalance.get())}"
    }

    private fun addToBalanceSum(newSum: AtomicReference<BigDecimal>, amount: BigDecimal) {
        while (true) {
            val oldVal = newSum.get()
            if (newSum.compareAndSet(oldVal, oldVal.add(amount))) return
        }
    }

    private fun toCurrencyFormat(amount: BigDecimal): String {
        val currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US)
        return currencyFormatter.format(amount.toDouble())
    }
}