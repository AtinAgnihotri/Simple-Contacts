package com.simplemobiletools.contacts.pro;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.simplemobiletools.contacts.pro.testWorkflows.FavoritesWorkflow;

import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class TestContactFavorites extends BaseTestCase {
    @Test
    public void test_CornerCase_AddFavoriteWhenNoContactsSaved() {
        FavoritesWorkflow.whenAddingFavoriteWithoutAnyContacts();
        FavoritesWorkflow.thenFavoritesWarningToastShown();
    }
}
