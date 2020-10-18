package com.simplemobiletools.contacts.pro.uiUtils;

import com.simplemobiletools.contacts.pro.R;

import org.hamcrest.CustomMatcher;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.hasChildCount;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static org.hamcrest.CoreMatchers.allOf;

public class TabSwitchingUtils {

    public static void switchToContactsTab(){
        GlobalUtils.clickItem(
                CustomMatchersUtils.nthChildOf(
                        allOf(
                                withParent(withId(R.id.main_tabs_holder)),
                                hasChildCount(3)
                        ),
                        0
                )
        );
    }

    public static void switchToFavoritesTab(){
        GlobalUtils.clickItem(
                CustomMatchersUtils.nthChildOf(
                        allOf(
                                withParent(withId(R.id.main_tabs_holder)),
                                hasChildCount(3)
                        ),
                        1
                )
        );
    }

    public static void switchToGroupsTab(){
        GlobalUtils.clickItem(
                CustomMatchersUtils.nthChildOf(
                        allOf(
                                withParent(withId(R.id.main_tabs_holder)),
                                hasChildCount(3)
                        ),
                        2
                )
        );
    }
}
