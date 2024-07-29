package com.ranamahadahmer.expensemaster.screens.main.data

import java.time.LocalDate

data class Transaction(val id: Int,
                       val title: String,
                       val amount: Double,
                       val date: LocalDate,
                       val category: String,
                       val type: String)

val listOfTransaction = listOf(
    Transaction(1, "Salary", 25000.0, LocalDate.now(), "Online", "Income"),
    Transaction(2, "Grocery", 3000.0, LocalDate.now(), "Cash", "Expense"),
    Transaction(3, "Bill", 5000.0, LocalDate.now(), "Online", "Expense"),
    Transaction(4, "Rent", 7000.0, LocalDate.now(), "Cash", "Expense"),
)
