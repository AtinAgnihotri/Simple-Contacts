package com.simplemobiletools.contacts.pro.uiUtils;

import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.Until;

import com.simplemobiletools.contacts.pro.R;

import org.hamcrest.Matcher;

import static androidx.test.espresso.matcher.ViewMatchers.withChild;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

public class ContactInfoUtils {
    public static Matcher getContactItem(String contactName){
        return withText(contactName);
    }

    public static void goToContactInfoFromContactList(String contactName) {
        // Click the contact item with name contactName
        GlobalUtils.clickItem(
                getContactItem(contactName)
        );
    }

    public static void selectContactItemInContactList(String contactName) {
        // Click the contact item with name contactName
        GlobalUtils.longClickItem(
                getContactItem(contactName)
        );
    }

    public static void waitTillContactExists(UiDevice mUiDevice, String contactName) {
        GlobalUtils.waitTillObjectExists(mUiDevice, By.text(contactName));
    }


}
