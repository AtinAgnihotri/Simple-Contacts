package com.simplemobiletools.contacts.pro.testWorkflows;

import android.provider.Settings;

import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.Until;

import com.simplemobiletools.contacts.pro.R;
import com.simplemobiletools.contacts.pro.uiUtils.ContactInfoUtils;
import com.simplemobiletools.contacts.pro.uiUtils.GlobalUtils;

public class ContactActionsWorkflow {

    public static void whenTestContactNumberEdited() {
        // Pause as UI takes time to redraw after Updating Number
        GlobalUtils.pauseTestFor(GlobalUtils.PAUSE_STANDARD_500);

        // Name of the New Contact
        String stringToCheck = new StringBuilder(GlobalUtils.TEST_FIRST_NAME)
                .append(" ")
                .append(GlobalUtils.TEST_SURNAME)
                .toString();

        // Go to Contact Info page
        ContactInfoUtils.goToContactInfoFromContactList(stringToCheck);


        // Click the edit button on Contact Info page
        GlobalUtils.clickItem(R.id.edit);

        // Edit the Phone Number
        GlobalUtils.replaceViewText(R.id.contact_number, GlobalUtils.TEST_NUMBER_ALT);

        // Save the contact
        GlobalUtils.clickItem(R.id.save);

    }

    public static void whenTestContactNumberDeleted(UiDevice mUiDevice) {
        // Name of the New Contact
        String stringToCheck = new StringBuilder(GlobalUtils.TEST_FIRST_NAME)
                .append(" ")
                .append(GlobalUtils.TEST_SURNAME)
                .toString();

        // Wait Till Number Comes
        mUiDevice.wait(Until.hasObject(By.text(stringToCheck)), GlobalUtils.WAIT_STANDARD_5000);

        // Go to Contact Info page
        ContactInfoUtils.goToContactInfoFromContactList(stringToCheck);


        // Delete Contact
        GlobalUtils.clickItem(R.id.delete);
        GlobalUtils.clickItem("Yes");

    }

    public static void whenFirstTestContactIsSearched() {
        // Click the search button
        GlobalUtils.clickItem(R.id.search);

        // Enter the name of the first contact
        String stringToEnter = new StringBuilder(GlobalUtils.TEST_FIRST_NAME)
                .append(" ")
                .append(GlobalUtils.TEST_SURNAME)
                .toString();
        GlobalUtils.enterTextIntoView(R.id.search_src_text, stringToEnter);

    }

}
