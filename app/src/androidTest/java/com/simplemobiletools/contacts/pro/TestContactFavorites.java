package com.simplemobiletools.contacts.pro;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.simplemobiletools.contacts.pro.testWorkflows.FavoritesWorkflow;

import org.junit.Test;
import org.junit.runner.RunWith;

//@RunWith(AndroidJUnit4.class)
public class TestContactFavorites extends BaseTestCase {
    @Test
    public void test_CornerCase_AddFavoriteWhenNoContactsSaved() {
        FavoritesWorkflow.whenAddingFavoriteWithoutAnyContacts();
        FavoritesWorkflow.thenFavoritesWarningToastShown();
    }
}
