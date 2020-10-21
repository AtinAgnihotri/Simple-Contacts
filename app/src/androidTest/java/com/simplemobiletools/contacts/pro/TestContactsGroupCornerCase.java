package com.simplemobiletools.contacts.pro;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.simplemobiletools.contacts.pro.testWorkflows.GroupsWorkflow;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class TestContactsGroupCornerCase extends BaseTestCase{
    @LargeTest
    @Test
    public void test_CornerCase_AddNewGroupWithoutName() {
        GroupsWorkflow.whenAddingNewGroupWithoutName();
        GroupsWorkflow.thenGroupsWarningToastShown();
    }
}
