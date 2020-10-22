package com.simplemobiletools.contacts.pro;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.simplemobiletools.contacts.pro.testWorkflows.AddContactWorkflow;
import com.simplemobiletools.contacts.pro.testWorkflows.GroupsWorkflow;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

//@LargeTest
@RunWith(AndroidJUnit4.class)
public class TestContactGroups extends BaseTestCase{

    @Ignore
    @LargeTest
    @Test
    public void test_E2E_ContactGroupingInContactsList() {
        AddContactWorkflow.givenMultipleTestContactAddedOnContactsList(5, false);
        GroupsWorkflow.whenFirstTwoContactsAreSelectedAndGrouped();
        GroupsWorkflow.thenTestGroupHasFirstTwoContacts(mUiDevice);
    }



}
