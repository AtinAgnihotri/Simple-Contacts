package com.simplemobiletools.contacts.pro;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestContactInsertion.class,
        TestContactFavorites.class,
        TestContactActions.class,
        TestContactGroups.class
})
public class E2ETestSuite {
}
