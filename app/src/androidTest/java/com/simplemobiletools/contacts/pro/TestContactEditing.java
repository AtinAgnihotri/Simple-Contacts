package com.simplemobiletools.contacts.pro;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.simplemobiletools.contacts.pro.testWorkflows.AddContactWorkflow;
import com.simplemobiletools.contacts.pro.testWorkflows.ContactActionsWorkflow;
import com.simplemobiletools.contacts.pro.testWorkflows.ContactValidationWorkflow;

import org.jsoup.Connection;
import org.junit.Test;
import org.junit.runner.RunWith;

//@LargeTest
@RunWith(AndroidJUnit4.class)
public class TestContactEditing extends BaseTestCase {

    @LargeTest
    @Test
    public void test_E2E_EditContactInContactsList() {
        AddContactWorkflow.givenTestContactAddedOnContactsList();
        ContactActionsWorkflow.whenTestContactNumberEdited();
        ContactValidationWorkflow.thenTestContactHasNewNumber(mUiDevice);
    }





}
