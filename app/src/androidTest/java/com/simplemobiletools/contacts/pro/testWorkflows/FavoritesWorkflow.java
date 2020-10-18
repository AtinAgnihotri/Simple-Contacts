package com.simplemobiletools.contacts.pro.testWorkflows;

import com.simplemobiletools.contacts.pro.R;
import com.simplemobiletools.contacts.pro.uiUtils.GlobalUtils;
import com.simplemobiletools.contacts.pro.uiUtils.TabSwitchingUtils;

import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static org.hamcrest.Matchers.allOf;

import static org.junit.Assert.assertTrue;

public class FavoritesWorkflow {

    public static void whenAddingFavoriteWithoutAnyContacts() {
        TabSwitchingUtils.switchToFavoritesTab();

        // Click On Add New Favorite
        GlobalUtils.clickItem(allOf(
                withId(R.id.fragment_fab), withParent(withId(R.id.favorites_fragment))
        ));
    }

    public static void thenFavoritesWarningToastShown(){
        // Pause to wait for Toast before instrumentation closes
        GlobalUtils.pauseTestFor(GlobalUtils.PAUSE_STANDARD_200);

        assertTrue(GlobalUtils.checkIfToastShown(GlobalUtils.TOAST_CONTACTS_EMPTY_WARNING));
    }
}
