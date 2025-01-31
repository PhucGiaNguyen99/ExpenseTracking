package com.example.expensetracking

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.expensetracking.model.Expense
import com.example.expensetracking.viewmodel.ExpenseViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: ExpenseViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etTitle = findViewById<EditText>(R.id.etTitle)
        val etAmount = findViewById<EditText>(R.id.etAmount)
        val etCategory = findViewById<EditText>(R.id.etCategory)
        val btnAdd = findViewById<Button>(R.id.btnAddExpense)

        btnAdd.setOnClickListener {
            val title = etTitle.text.toString()
            val amount = etAmount.text.toString().toDoubleOrNull()
            val category = etCategory.text.toString()

            if (title.isNotEmpty() && amount != null && category.isNotEmpty()) {
                val expense = Expense(title = title, amount = amount, category = category, date = System.currentTimeMillis())
                viewModel.addExpense(expense)

                etTitle.text.clear()
                etAmount.text.clear()
                etCategory.text.clear()
            }
        }
    }
}