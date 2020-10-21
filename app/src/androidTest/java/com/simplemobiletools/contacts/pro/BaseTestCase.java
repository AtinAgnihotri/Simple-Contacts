package com.simplemobiletools.contacts.pro;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;
import androidx.test.rule.GrantPermissionRule;
import androidx.test.uiautomator.UiDevice;

import com.schibsted.spain.barista.rule.BaristaRule;
import com.schibsted.spain.barista.rule.cleardata.ClearDatabaseRule;
import com.schibsted.spain.barista.rule.cleardata.ClearFilesRule;
import com.schibsted.spain.barista.rule.cleardata.ClearPreferencesRule;
import com.simplemobiletools.contacts.pro.activities.MainActivity;
import com.simplemobiletools.contacts.pro.activities.SplashActivity;
import com.simplemobiletools.contacts.pro.uiUtils.GlobalUtils;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class BaseTestCase {

    protected UiDevice mUiDevice;

    // Grant Permissions to the Instrumentation Instance of App
    @Rule
    public GrantPermissionRule mGrantPermissions = GrantPermissionRule.grant(
            "android.permission.READ_CONTACTS",
            "android.permission.GET_ACCOUNTS",
            "android.permission.WRITE_CONTACTS"
    );

//    @Rule
//    public ActivityScenarioRule<SplashActivity> splashActivityActivityScenarioRule = new ActivityScenarioRule<>(SplashActivity.class);
//    public ActivityTestRule<SplashActivity> splashActivityActivityTestRule = new ActivityTestRule<>(SplashActivity.class);
//    public ActivityScenario<SplashActivity> mActivityScenario;

//    @Rule
//    public ClearPreferencesRule clearPreferencesRule = new ClearPreferencesRule();

//    @Rule
//    public ClearDatabaseRule clearDatabaseRule = new ClearDatabaseRule();

//    @Rule
//    public ClearFilesRule clearFilesRule = new ClearFilesRule();

    @Rule
    public BaristaRule<MainActivity> mainActivityBaristaRule = BaristaRule.create(MainActivity.class);


    // Open the Launcher Activity of the App
    @Before
    public void setUp() throws InterruptedException {
        launchApplication();
    }


    protected void launchApplication() throws InterruptedException {
        // Init UiDevice
        mUiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        mainActivityBaristaRule.launchActivity();
//        mUiDevice.pressHome();

//        mActivityScenario = splashActivityActivityScenarioRule.getScenario();

    }

    @After
    public void tearDown() {

//        mActivityScenario.close();
    }


}
