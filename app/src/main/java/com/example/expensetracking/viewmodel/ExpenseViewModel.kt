package com.example.expensetracking.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.expensetracking.database.ExpenseDatabase
import com.example.expensetracking.database.ExpenseDao
import com.example.expensetracking.model.Expense

class ExpenseViewModel(application: Application) : AndroidViewModel(application) {
    private val expenseDao: ExpenseDao
    val allExpenses: LiveData<List<Expense>>

    init {
        val database = ExpenseDatabase.getDatabase(application)
        expenseDao = database.expenseDao()
        allExpenses = expenseDao.getAllExpenses()
    }

    fun addExpense(expense: Expense) {
        viewModelScope.launch {
            expenseDao.insertExpense(expense)
        }
    }

    fun deleteExpense(expense: Expense) {
        viewModelScope.launch {
            expenseDao.deleteExpense(expense)
        }
    }
}