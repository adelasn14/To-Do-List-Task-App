package com.dicoding.todoapp.ui.list

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.dicoding.todoapp.R
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

//TODO 16 : Write UI test to validate when user tap Add Task (+), the AddTaskActivity displayed - FINISHED
@RunWith(AndroidJUnit4ClassRunner::class)
class TaskActivityTest {
    @Before
    fun setup(){
        ActivityScenario.launch(TaskActivity::class.java)
    }

    @Test
    fun onTestAddingTask() {
            onView(withId(R.id.rv_task)).check(matches(isDisplayed()))
            onView(withId(R.id.fab)).perform(click())
            onView(withId(R.id.add_ed_description)).check(matches(isDisplayed()))
            onView(withId(R.id.add_ed_title)).check(matches(isDisplayed()))
            onView(withId(R.id.add_tv_due_date)).check(matches(isDisplayed()))
    }
}