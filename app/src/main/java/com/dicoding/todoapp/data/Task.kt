package com.dicoding.todoapp.data

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

//TODO 1 : Define a local database table using the schema in app/schema/tasks.json - FINISHED
@Parcelize
@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    val id: Int = 0,

    @NonNull
    val title: String,

    @NonNull
    val description: String,

    @NonNull
    @ColumnInfo(name = "dueDate")
    val dueDateMillis: Long,

    @NonNull
    @ColumnInfo(name = "completed")
    val isCompleted: Boolean = false
) : Parcelable