package com.dicoding.todoapp.ui.detail

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.dicoding.todoapp.databinding.ActivityTaskDetailBinding
import com.dicoding.todoapp.ui.ViewModelFactory
import com.dicoding.todoapp.utils.DateConverter
import com.dicoding.todoapp.utils.TASK_ID

class DetailTaskActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTaskDetailBinding
    private lateinit var detailTaskViewModel: DetailTaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaskDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //TODO 11 : Show detail task and implement delete action - FINISHED

        setupActions()
        setupViewModel()
    }

    private fun setupViewModel() {
        detailTaskViewModel = ViewModelProvider(
            this,
            ViewModelFactory.getInstance(this)
        )[DetailTaskViewModel::class.java]

        val detail = intent.getIntExtra((TASK_ID), 0)
        detailTaskViewModel.setTaskId(detail)
        detailTaskViewModel.task.observe(this) {
            if (it != null) {
                binding.apply {
                    detailEdTitle.setText(it.title)
                    detailEdDescription.setText(it.description)
                    detailEdDueDate.setText(it.let { DateConverter.convertMillisToString(it.dueDateMillis) })
                }
                Log.d("DetailActivity", "Detail : $it")
            }
        }
    }

    private fun setupActions() {
        binding.btnDeleteTask.setOnClickListener {
            detailTaskViewModel.deleteTask()
            finish()
            Toast.makeText(applicationContext, "Task successfully deleted", Toast.LENGTH_SHORT).show()
        }
    }
}