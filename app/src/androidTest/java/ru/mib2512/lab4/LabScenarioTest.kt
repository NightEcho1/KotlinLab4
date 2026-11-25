package ru.mib2512.lab4
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.Matchers.not
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
@RunWith(AndroidJUnit4::class)
class LabScenarioTest {
    @Test fun extrasTravelBothWaysWithoutNewMainActivity() {
        ActivityScenario.launch(MainActivity::class.java).use { scenario ->
            onView(withId(R.id.plain_text1)).perform(replaceText("Привет"), closeSoftKeyboard())
            onView(withId(R.id.extra_text)).perform(replaceText("МИБ-2512"), closeSoftKeyboard())
            ReportCapture.save("01_input")
            onView(withId(R.id.btn_ch1)).perform(scrollTo(), click())
            onView(withId(R.id.text_from_main)).check(matches(withText("Привет")))
            onView(withId(R.id.extra_from_main)).check(matches(withText("МИБ-2512")))
            onView(withId(R.id.plain_text2)).perform(replaceText("Ответ"), closeSoftKeyboard())
            ReportCapture.save("02_second")
            onView(withId(R.id.btn_ch2)).perform(scrollTo(), click())
            onView(withId(R.id.text_from_act2)).check(matches(withText("Ответ")))
            scenario.recreate()
            onView(withId(R.id.text_from_act2)).check(matches(withText("Ответ")))
            onView(withId(R.id.plain_text1)).check(matches(withText("Привет")))
            ReportCapture.save("03_reply")
        }
    }
}
