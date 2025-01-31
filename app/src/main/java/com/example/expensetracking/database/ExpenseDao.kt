package com.example.expensetracking.database
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.expensetracking.model.Expense

@Dao
interface ExpenseDao {
    @Insert
    suspend fun insertExpense(expense: Expense)

    @Delete
    suspend fun deleteExpense(expense: Expense)

    @Query("SELECT * FROM expenses ORDER BY date DESC")
    fun getAllExpenses(): LiveData<List<Expense>>
}