package com.simplemobiletools.contacts.pro;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.simplemobiletools.contacts.pro.testWorkflows.AddContactWorkflow;
import com.simplemobiletools.contacts.pro.testWorkflows.GroupsWorkflow;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class TestContactGroups extends BaseTestCase{

    @Test
    public void test_E2E_ContactGroupingInContactsList() {
        AddContactWorkflow.givenMultipleTestContactAddedOnContactsList(10, false);
        GroupsWorkflow.whenFirstThreeContactsAreSelectedAndGrouped();
        GroupsWorkflow.thenTestGroupHasFirstThreeContacts();
    }

    @Test
    public void test_CornerCase_AddNewGroupWithoutName() {
        GroupsWorkflow.whenAddingNewGroupWithoutName();
        GroupsWorkflow.thenGroupsWarningToastShown();
    }

}
