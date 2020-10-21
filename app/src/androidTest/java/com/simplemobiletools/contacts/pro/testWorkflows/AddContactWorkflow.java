package com.simplemobiletools.contacts.pro.testWorkflows;

import com.simplemobiletools.contacts.pro.R;
import com.simplemobiletools.contacts.pro.uiUtils.AddContactsUtils;

import static com.schibsted.spain.barista.interaction.BaristaClickInteractions.clickOn;

public class AddContactWorkflow {

    public static void givenTestContactAddedOnContactsList() {
        AddContactsUtils.insertATestContact();
    }

    public static void givenMultipleTestContactAddedOnContactsList(int numberOfContacts, boolean addNonNumberedContact) {
        AddContactsUtils.insertMultipleTestContacts(numberOfContacts);

        // Add First Test Contact if addNonNumberedContact is true
        if (addNonNumberedContact)
            AddContactsUtils.insertATestContact();
    }

    public static void whenTestContactAddedOnContactsList() {
        AddContactsUtils.insertATestContact();
//        clickOn(R.id.fragment_fab);
    }

    public static void whenSavingEmptyContact() {
        AddContactsUtils.insertEmptyContact();
    }

}
