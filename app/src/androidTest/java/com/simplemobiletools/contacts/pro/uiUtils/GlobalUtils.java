package com.simplemobiletools.contacts.pro.uiUtils;

import androidx.test.espresso.NoMatchingViewException;

import org.hamcrest.Matcher;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.longClick;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasChildCount;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class GlobalUtils {

    public static final String TEST_FIRST_NAME = "TestFirstName";
    public static final String TEST_SURNAME = "TestSurname";
    public static final String TEST_NUMBER = "1234567890";
    public static final String TEST_NUMBER_ALT = "0100100010";
    public static final String TEST_GRP = "TestGroup";
    public static final String TOAST_CONTACTS_INFO_EMPTY_WARNING = "Please add Either first name, surname or a phone number to proceed";
    public static final String TOAST_CONTACTS_EMPTY_WARNING = "No Contacts to favorite";
    public static final String TOAST_EMPTY_GRP_NAME_WARNING = "Please enter a name";
    public static final String SPLASH_ACTIVITY_PKG = "com.simplemobiletools.contacts.pro.activities.SplashActivity";
    public static final int LAUNCH_TIMEOUT = 5000;

    public static void clickItem (int resourceId) {
        onView(withId(resourceId)).perform(click());
    }

    public static void clickItem (String withGivenText) {
        onView(withText(withGivenText)).perform(click());
    }

    public static void clickItem (Matcher matcher) {
        onView(matcher).perform(click());
    }

    public static void longClickItem (int resourceId) {
        onView(withId(resourceId)).perform(longClick());
    }

    public static void longClickItem (String withGivenText) {
        onView(withText(withGivenText)).perform(longClick());
    }

    public static void longClickItem (Matcher matcher) {
        onView(matcher).perform(longClick());
    }

    public static void enterTextIntoView(int resourceId, String inputText){
        onView(withId(resourceId)).perform(typeText(inputText));
    }

    public static void enterTextIntoView(String withGivenText, String inputText){
        onView(withText(withGivenText)).perform(typeText(inputText));
    }

    public static void enterTextIntoView(Matcher matcher, String inputText){
        onView(matcher).perform(typeText(inputText));
    }

    public static void replaceViewText(int resourceId, String inputText){
        onView(withId(resourceId)).perform(replaceText(inputText));
    }

    public static void replaceViewText(String withGivenText, String inputText){
        onView(withText(withGivenText)).perform(replaceText(inputText));
    }

    public static void replaceViewText(Matcher matcher, String inputText){
        onView(matcher).perform(replaceText(inputText));
    }

    public static boolean checkIfViewExists(int resourceId) {
        boolean viewExists = true;
        try {
            onView(withId(resourceId));
        } catch (NoMatchingViewException e) {
            viewExists = false;
        }

        return viewExists;
    }

    public static boolean checkIfViewExists(String withGivenText) {
        boolean viewExists = true;
        try {
            onView(withText(withGivenText));
        } catch (NoMatchingViewException e) {
            viewExists = false;
        }

        return viewExists;
    }

    public static boolean checkIfViewExists(Matcher matcher) {
        boolean viewExists = true;
        try {
            onView(matcher);
        } catch (NoMatchingViewException e) {
            viewExists = false;
        }

        return viewExists;
    }

    public static boolean checkIfViewDisplayed(int resourceId) {
        boolean viewDisplayed = true;
        try {
            onView(withId(resourceId)).check(matches(isDisplayed()));
        } catch (NoMatchingViewException e) {
            viewDisplayed = false;
        }

        return viewDisplayed;
    }

    public static boolean checkIfViewDisplayed(String withGivenText) {
        boolean viewDisplayed = true;
        try {
            onView(withText(withGivenText)).check(matches(isDisplayed()));
        } catch (NoMatchingViewException e) {
            viewDisplayed = false;
        }

        return viewDisplayed;
    }

    public static boolean checkIfViewDisplayed(Matcher matcher) {
        boolean viewDisplayed = true;
        try {
            onView(matcher).check(matches(isDisplayed()));
        } catch (NoMatchingViewException e) {
            viewDisplayed = false;
        }

        return viewDisplayed;
    }

    public static boolean checkIfViewHasMatchingText(int resourceId, String matchingText) {
        boolean viewExists = true;
        try {
            onView(withId(resourceId)).check(matches(withText(matchingText)));
        } catch (NoMatchingViewException e) {
            viewExists = false;
        }

        return viewExists;
    }

    public static boolean checkIfViewHasMatchingText(String withGivenText, String matchingText) {
        boolean viewExists = true;
        try {
            onView(withText(withGivenText)).check(matches(withText(matchingText)));
        } catch (NoMatchingViewException e) {
            viewExists = false;
        }

        return viewExists;
    }

    public static boolean checkIfViewHasMatchingText(Matcher matcher, String matchingText) {
        boolean viewExists = true;
        try {
            onView(matcher).check(matches(withText(matchingText)));
        } catch (NoMatchingViewException e) {
            viewExists = false;
        }

        return viewExists;
    }

    public static boolean checkIfViewHasNChildren(int resourceId, int childrenCount) {
        boolean viewHasNChildren = true;
        try {
            onView(withId(resourceId)).check(matches(hasChildCount(childrenCount)));
        } catch (NoMatchingViewException e) {
            viewHasNChildren = false;
        }

        return viewHasNChildren;
    }

    public static boolean checkIfViewHasNChildren(String withGivenText, int childrenCount) {
        boolean viewHasNChildren = true;
        try {
            onView(withText(withGivenText)).check(matches(hasChildCount(childrenCount)));
        } catch (NoMatchingViewException e) {
            viewHasNChildren = false;
        }

        return viewHasNChildren;
    }

    public static boolean checkIfViewHasNChildren(Matcher matcher, int childrenCount) {
        boolean viewHasNChildren = true;
        try {
            onView(matcher).check(matches(hasChildCount(childrenCount)));
        } catch (NoMatchingViewException e) {
            viewHasNChildren = false;
        }

        return viewHasNChildren;
    }

    public static boolean checkIfToastShown(String toastMessage) {
        boolean toastShown = true;
        try {
            onView(withText(toastMessage)).inRoot(CustomMatchersUtils.isToast()).check(matches(isDisplayed()));
        } catch (NoMatchingViewException e) {
            toastShown = false;
        }

        return toastShown;
    }



    public static void pauseTestFor(int miliseconds) {
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
