package com.udacity.gradle.builditbigger;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import static android.support.test.espresso.Espresso.onView;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;



@RunWith(AndroidJUnit4.class)
public class JokeTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void NonEmptyStringTest(){
        onView(withId(R.id.tell_joke_button)).perform(click());

        onView(withId(R.id.tv_joke)).check(matches(not(withText(""))));

    }

}
