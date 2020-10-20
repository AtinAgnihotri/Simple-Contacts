package com.simplemobiletools.contacts.pro;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.simplemobiletools.contacts.pro.testWorkflows.AddContactWorkflow;
import com.simplemobiletools.contacts.pro.testWorkflows.ContactValidationWorkflow;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 */

//@LargeTest
@RunWith(AndroidJUnit4.class)
public class TestContactInsertion extends BaseTestCase{

    @LargeTest
    @Test
    public void test_E2E_AddContactToContactsList() {
        AddContactWorkflow.whenTestContactAddedOnContactsList();
        ContactValidationWorkflow.thenTestContactExistsInContactList();
    }

    @LargeTest
    @Test
    public void test_CornerCase_SaveContactWithoutAnyInfo() {
        AddContactWorkflow.whenSavingEmptyContact();
        ContactValidationWorkflow.thenContactsWarningToastShown();
    }
}
