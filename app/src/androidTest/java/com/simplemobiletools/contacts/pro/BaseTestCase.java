package com.simplemobiletools.contacts.pro;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.GrantPermissionRule;
import androidx.test.uiautomator.UiDevice;

import com.simplemobiletools.contacts.pro.activities.SplashActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class BaseTestCase {

    protected UiDevice mUiDevice;

    // Grant Permissions to the Instrumentation Instance of App
    @Rule
    public GrantPermissionRule mGrantPermissions = GrantPermissionRule.grant(
            "android.permission.READ_CONTACTS",
            "android.permission.GET_ACCOUNTS",
            "android.permission.WRITE_CONTACTS"
    );

    // Open the Launcher Activity of the App
    @Rule
    public ActivityScenarioRule<SplashActivity> splashActivityActivityScenarioRule = new ActivityScenarioRule<>(SplashActivity.class);


    @Before
    public void setUp() {
        launchApplication();
    }

    protected void launchApplication() {
        // Init UiDevice
        mUiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

    }

}
