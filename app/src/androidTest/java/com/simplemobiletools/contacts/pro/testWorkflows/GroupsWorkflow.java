package com.simplemobiletools.contacts.pro.testWorkflows;

import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;

import com.simplemobiletools.contacts.pro.R;
import com.simplemobiletools.contacts.pro.uiUtils.AddContactsUtils;
import com.simplemobiletools.contacts.pro.uiUtils.ContactInfoUtils;
import com.simplemobiletools.contacts.pro.uiUtils.CustomMatchersUtils;
import com.simplemobiletools.contacts.pro.uiUtils.GlobalUtils;
import com.simplemobiletools.contacts.pro.uiUtils.TabSwitchingUtils;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.junit.Assert.assertTrue;

public class GroupsWorkflow {

    public static void whenFirstThreeContactsAreSelectedAndGrouped() {
        // Get the names of first three contacts
        String [] firstThreeContacts = AddContactsUtils.getFirstNContactNames(3);

        // Long click first name to go into multi-selection mode
        GlobalUtils.longClickItem(ContactInfoUtils.getContactItem(firstThreeContacts[0]));

        // Click the other two normally to select them
        GlobalUtils.clickItem(ContactInfoUtils.getContactItem(firstThreeContacts[1]));
        GlobalUtils.clickItem(ContactInfoUtils.getContactItem(firstThreeContacts[2]));

        // Click Add to group button
        GlobalUtils.clickItem(R.id.cab_add_to_group);

        // Click the Create a new group radio button
        GlobalUtils.clickItem("Create a new group");

        // Enter the name of the group
        GlobalUtils.enterTextIntoView(R.id.group_name, GlobalUtils.TEST_GRP);

        // Press OK
        GlobalUtils.clickItem("OK");

        // Switch to Group Tab
        TabSwitchingUtils.switchToGroupsTab();

        // Click on Group Item
        GlobalUtils.clickItem(GlobalUtils.TEST_GRP + " (3)");

    }

    public static void whenAddingNewGroupWithoutName() {

        // Switch to Groups Tab
        TabSwitchingUtils.switchToGroupsTab();

        // Click on Add New Group Button
        GlobalUtils.clickItem(allOf(
                withId(R.id.fragment_fab), withParent(withId(R.id.groups_fragment))
        ));

        // Click OK Button
        GlobalUtils.clickItem("OK");

    }

    public static void thenTestGroupHasFirstThreeContacts(UiDevice mUiDevice) {
        boolean has3Contacts = GlobalUtils.checkIfViewHasNChildren(R.id.group_contacts_list, 3);
        boolean first3ContactsMatch = true;
        for (String contactName : AddContactsUtils.getFirstNContactNames(3)){
            first3ContactsMatch = first3ContactsMatch && GlobalUtils.isElementAvailable(mUiDevice, By.text(contactName));
        }
        assertTrue(has3Contacts && first3ContactsMatch);
    }

    public static void thenGroupsWarningToastShown() {
        // Pause to wait for Toast before instrumentation closes
        GlobalUtils.pauseTestFor(GlobalUtils.PAUSE_STANDARD_200);

//        assertTrue(GlobalUtils.checkIfToastShown(GlobalUtils.TOAST_EMPTY_GRP_NAME_WARNING));
        assertTrue(GlobalUtils.isElementAvailable(onView(withText(GlobalUtils.TOAST_EMPTY_GRP_NAME_WARNING)).inRoot(CustomMatchersUtils.isToast())));
    }
}
