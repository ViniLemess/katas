package com.vinilemess.bank.domain

class Transactions(private val transactions: ArrayList<Transaction>) {

    fun addTransaction(transaction: Transaction) {
        transactions.add(transaction)
    }

    fun getTransactions(): List<Transaction> {
        return transactions.toList();
    }
}