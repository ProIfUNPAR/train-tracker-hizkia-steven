package com.example.hizkia.train_tracker_kv2;

import android.os.SystemClock;
import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

/**
 * Created by ASUS on 29/04/2018.
 */
public class AutomatedTest {

    @Rule
    public ActivityTestRule <MainActivity> mActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Before
    public void setUp() throws Exception {

    }

    /**
     * Test case for train "Bima | Malang - Gambir" from "Stasiun Sidoarjo" to "Stasiun Cirebon"
     */
    @Test
    public void testRun() throws Exception{
        // open application
        SystemClock.sleep(3000);

        // open train's spinner
        Espresso.onView(withId(R.id.spinnerTrains)).perform(click());
        SystemClock.sleep(1500);
        Espresso.onData(allOf(is(instanceOf(String.class)), is("Bima | Malang - Gambir"))).perform(click());
        SystemClock.sleep(1500);

        // close train's spinner
        //Espresso.pressBack();

        // click button next to trackActivity
        Espresso.onView(withId(R.id.btnNext)).perform(click());

        //on trackActivity choose start station and end station
        Espresso.onView(withId(R.id.spinnerCurrent)).perform(click());
        SystemClock.sleep(1000);
        Espresso.onData(allOf(is(instanceOf(String.class)), is("Stasiun Sidoarjo"))).perform(click());
        SystemClock.sleep(1000);


        Espresso.onView(withId(R.id.spinnerDestination)).perform(click());
        SystemClock.sleep(1000);
        Espresso.onData(allOf(is(instanceOf(String.class)), is("Stasiun Cirebon"))).perform(click());
        SystemClock.sleep(1000);

        // click button go to mapActivity
        Espresso.onView(withId(R.id.btnGoMap)).perform(click());
        SystemClock.sleep(3000);

        //exit app
        Espresso.pressBack();
        SystemClock.sleep(1000);
        Espresso.pressBack();
        SystemClock.sleep(1000);

    }

    @Test
    public void testRun2() throws Exception{
        //test case for train "Argo Jati | Cirebon - Gambir" from "Stasiun Gambir" station to "Stasiun Jatibarang" station
        // open application
        SystemClock.sleep(1500);

        // open train's spinner
        Espresso.onView(withId(R.id.spinnerTrains)).perform(click());
        SystemClock.sleep(1500);
        Espresso.onData(allOf(is(instanceOf(String.class)), is("Argo Jati | Cirebon - Gambir"))).perform(click());
        SystemClock.sleep(1500);

        // close train's spinner
        //Espresso.pressBack();

        Espresso.onView(withId(R.id.rbEnd)).perform(click());
        Espresso.onView(withId(R.id.rbEnd)).check(matches(isChecked()));
        Espresso.onView(withId(R.id.rbStart)).check(matches(not(isChecked())));


        // click button next to trackActivity
        Espresso.onView(withId(R.id.btnNext)).perform(click());

        //on trackActivity choose start station and end station
        Espresso.onView(withId(R.id.spinnerCurrent)).perform(click());
        SystemClock.sleep(1000);
        Espresso.onData(allOf(is(instanceOf(String.class)), is("Stasiun Bekasi"))).perform(click());
        SystemClock.sleep(1000);


        Espresso.onView(withId(R.id.spinnerDestination)).perform(click());
        SystemClock.sleep(1000);
        Espresso.onData(allOf(is(instanceOf(String.class)), is("Stasiun Jatibarang"))).perform(click());
        SystemClock.sleep(1000);

        // click button go to mapActivity
        Espresso.onView(withId(R.id.btnGoMap)).perform(click());
        SystemClock.sleep(3000);

        //exit app
        Espresso.pressBack();
        SystemClock.sleep(1000);
        Espresso.pressBack();
        SystemClock.sleep(1000);

    }

    @After
    public void tearDown() throws Exception {
    }

}