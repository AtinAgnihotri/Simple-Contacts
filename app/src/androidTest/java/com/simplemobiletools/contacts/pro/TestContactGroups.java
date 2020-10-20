package com.simplemobiletools.contacts.pro;

import android.widget.Toast;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.simplemobiletools.contacts.pro.testWorkflows.AddContactWorkflow;
import com.simplemobiletools.contacts.pro.testWorkflows.GroupsWorkflow;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class TestContactGroups extends BaseTestCase{

    @LargeTest
    public void test_E2E_ContactGroupingInContactsList() {
        AddContactWorkflow.givenMultipleTestContactAddedOnContactsList(10, false);
        GroupsWorkflow.whenFirstThreeContactsAreSelectedAndGrouped();
        GroupsWorkflow.thenTestGroupHasFirstThreeContacts(mUiDevice);
    }

    @Test
    public void test_CornerCase_AddNewGroupWithoutName() {
        GroupsWorkflow.whenAddingNewGroupWithoutName();
        GroupsWorkflow.thenGroupsWarningToastShown();
    }

}
