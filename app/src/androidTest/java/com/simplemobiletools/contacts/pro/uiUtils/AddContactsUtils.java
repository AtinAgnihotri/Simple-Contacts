package com.simplemobiletools.contacts.pro.uiUtils;

import com.simplemobiletools.contacts.pro.R;

import org.jetbrains.annotations.NotNull;

import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static com.schibsted.spain.barista.interaction.BaristaClickInteractions.clickOn;
import static org.hamcrest.Matchers.allOf;

public class AddContactsUtils {

    public static void addBasicContactWorkflow(String firstName, String lastName, String number) {
        // Add First Name, Surname and Phone Number
        GlobalUtils.enterTextIntoView(R.id.contact_first_name, firstName);
        GlobalUtils.enterTextIntoView(R.id.contact_surname, lastName);
        GlobalUtils.enterTextIntoView(R.id.contact_number, number);

        // Save contact
        GlobalUtils.clickItem(R.id.save);
    }

    public static void insertATestContact() {
        // Go to add contact activity
//        GlobalUtils.clickItem(allOf(
//                withId(R.id.fragment_fab), withParent(withId(R.id.contacts_fragment))
//        ));
        clickOn(R.id.fragment_fab);

        // Add
        // Add a basic Contact
        AddContactsUtils.addBasicContactWorkflow(
                GlobalUtils.TEST_FIRST_NAME, GlobalUtils.TEST_SURNAME, GlobalUtils.TEST_NUMBER
        );
    }

    public static void insertEmptyContact() {
        // Go to add contact activity
        GlobalUtils.clickItem(allOf(
                withId(R.id.fragment_fab), withParent(withId(R.id.contacts_fragment))
        ));

        // Click Save contact button
        GlobalUtils.clickItem(R.id.save);
    }

    public static void insertMultipleTestContacts(int number) {
        // Add number Contacts to fill Contact List
        for (int i = 0; i < number; i++) {
            // Go to add contact activity
            GlobalUtils.clickItem(allOf(
                    withId(R.id.fragment_fab), withParent(withId(R.id.contacts_fragment))
            ));

            // Add a basic Contact
            AddContactsUtils.addBasicContactWorkflow(
                    GlobalUtils.TEST_FIRST_NAME + i,
                    GlobalUtils.TEST_SURNAME + i,
                    GlobalUtils.TEST_NUMBER
            );
        }
    }

    @NotNull
    public static String [] getFirstNContactNames(int n) {
        String [] names = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = new StringBuilder(GlobalUtils.TEST_FIRST_NAME)
                    .append(i)
                    .append(" ")
                    .append(GlobalUtils.TEST_SURNAME)
                    .append(i)
                    .toString();
        }
        return names;
    }

    @NotNull
    public static String [] getMtoNContactNames(int m, int n) {
        String [] names = new String[n-m];
        for (int i = 0; i < n - m; i++) {
            names[i] = new StringBuilder(GlobalUtils.TEST_FIRST_NAME)
                    .append(i)
                    .append(" ")
                    .append(GlobalUtils.TEST_SURNAME)
                    .append(i)
                    .toString();
        }
        return names;
    }
}
