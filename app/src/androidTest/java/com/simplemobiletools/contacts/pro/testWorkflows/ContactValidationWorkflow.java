package com.simplemobiletools.contacts.pro.testWorkflows;

import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;

import com.simplemobiletools.contacts.pro.R;
import com.simplemobiletools.contacts.pro.uiUtils.GlobalUtils;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasChildCount;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.junit.Assert.assertTrue;

public class ContactValidationWorkflow {

    public static void thenTestContactExistsInContactList() {
        // Check that the number has been added
        String stringToCheck = new StringBuilder(GlobalUtils.TEST_FIRST_NAME)
                .append(" ")
                .append(GlobalUtils.TEST_SURNAME)
                .toString();
        assertTrue(GlobalUtils.checkIfViewExists(allOf(withText(stringToCheck), withId(R.id.item_contact_name))));
    }

    public static void thenContactsWarningToastShown() {
        assertTrue(GlobalUtils.checkIfToastShown(GlobalUtils.TOAST_CONTACTS_INFO_EMPTY_WARNING));
    }

    public static void thenTestContactHasNewNumber(UiDevice mUiDevice) {
        // Confirm we are back on Contacts Info page
        assertTrue(GlobalUtils.checkIfViewDisplayed("Details"));

        // Confirm that we have the new number
//        assertTrue(GlobalUtils.checkIfViewHasMatchingText(R.id.contact_number, GlobalUtils.TEST_NUMBER_ALT));
        assertTrue(GlobalUtils.isElementAvailable(mUiDevice, By.text(GlobalUtils.TEST_NUMBER_ALT)));
    }

    public static void thenTestContactDoesntExists(UiDevice mUiDevice) {
        // Pause Added as Contact list takes time after deleting contact to redraw
        GlobalUtils.pauseTestFor(GlobalUtils.PAUSE_STANDARD_500);

//        assertTrue(GlobalUtils.checkIfViewExists("No contacts found"));
        assertTrue(GlobalUtils.isElementAvailable(mUiDevice, By.text("No contacts found")));
    }

    public static void thenOnlyTestContactExistsInContactList(UiDevice mUiDevice) {
        // Check that the number has been added
        String stringToCheck = new StringBuilder(GlobalUtils.TEST_FIRST_NAME)
                .append(" ")
                .append(GlobalUtils.TEST_SURNAME)
                .toString();

        boolean contactExists = GlobalUtils.checkIfViewDisplayed(allOf(withText(stringToCheck), withId(R.id.item_contact_name)));
        boolean listHas1Contact = GlobalUtils.checkIfViewHasNChildren(
                allOf(
                        allOf(
                            withId(R.id.fragment_list),
                            withParent(allOf(withId(R.id.fragment_wrapper), withParent(withId(R.id.contacts_fragment))))
                        )
                    ),
                1
        );

        assertTrue(contactExists && listHas1Contact);
//        onView(allOf(
//                withId(R.id.fragment_list),
//                withParent(allOf(withId(R.id.fragment_wrapper), withParent(withId(R.id.contacts_fragment))))
//        )).check(matches(hasChildCount(1)));

    }

}
