package com.simplemobiletools.contacts.pro;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestContactDeletion.class,
        TestContactEditing.class,
        TestContactFavorites.class,
        TestContactGroups.class,
        TestContactInsertion.class,
        TestContactInsertionCornerCase.class,
        TestContactSearching.class,
        TestContactsGroupCornerCase.class
})
public class E2ETestSuite {
}
