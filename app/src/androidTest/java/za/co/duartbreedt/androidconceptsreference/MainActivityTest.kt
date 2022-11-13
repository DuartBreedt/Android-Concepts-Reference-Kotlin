package za.co.duartbreedt.androidconceptsreference

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    var activityScenarioRule = ActivityScenarioRule(
        MainActivity::class.java
    )

    @Test
    fun inputNameAndNavigate() {

        // MainActivity.java views
        Espresso.onView(withId(R.id.editText_username))
            .perform(ViewActions.typeText("Steve"), ViewActions.closeSoftKeyboard())
        Espresso.onView(withId(R.id.button_navigate)).perform(ViewActions.click())

        // NextActivity.java views
        Espresso.onView(withId(R.id.text_greeting))
            .check(ViewAssertions.matches(ViewMatchers.withText("Welcome!")))
    }
}