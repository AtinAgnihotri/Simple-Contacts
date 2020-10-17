package com.simplemobiletools.contacts.pro.testWorkflows;

import com.simplemobiletools.contacts.pro.uiUtils.AddContactsUtils;

public class AddContactWorkflow {

    public static void givenTestContactAddedOnContactsList() {
        AddContactsUtils.insertATestContact();
    }

    public static void givenMultipleTestContactAddedOnContactsList(boolean addNonNumberedContact) {
        AddContactsUtils.insertMultipleTestContacts(15);

        // Add First Test Contact if addNonNumberedContact is true
        if (addNonNumberedContact)
            AddContactsUtils.insertATestContact();
    }

    public static void whenTestContactAddedOnContactsList() {
        AddContactsUtils.insertATestContact();
    }

    public static void whenSavingEmptyContact() {
        AddContactsUtils.insertEmptyContact();
    }

}
