package com.simplemobiletools.contacts.pro.uiUtils;

import com.simplemobiletools.contacts.pro.R;

import org.hamcrest.Matcher;

import static androidx.test.espresso.matcher.ViewMatchers.withChild;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

public class ContactInfoUtils {
    public static Matcher getContactItem(String contactName){
        return allOf(
                withId(R.id.item_contact_frame),
                withChild(
                        allOf(
                                withId(R.id.item_contact_holder),
                                withChild(
                                        allOf(
                                                withId(R.id.item_contact_name),
                                                withText(contactName)
                                        )
                                )
                        )
                )
        );
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


//    public static void goToContactInfoFromContactList(int contactIndex) {
//        // Click the contact item with the new name
//        GlobalUtils.clickItem(
//                allOf(
//                        withId(R.id.item_contact_frame),
//                        withChild(
//                                allOf(
//                                        withId(R.id.item_contact_holder),
//                                        withChild(
//                                                allOf(
//                                                        withId(R.id.item_contact_name),
//                                                        withInde
//                                                )
//                                        )
//                                )
//                        )
//                )
//        );
//    }
}
