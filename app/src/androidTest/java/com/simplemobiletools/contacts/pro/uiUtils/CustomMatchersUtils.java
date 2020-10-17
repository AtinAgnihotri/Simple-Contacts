package com.simplemobiletools.contacts.pro.uiUtils;

import android.os.IBinder;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.test.espresso.Root;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class CustomMatchersUtils {

    public static Matcher<Root> isToast() {
        return new TypeSafeMatcher<Root>() {
            @Override
            protected boolean matchesSafely(Root root) {
                int type = root.getWindowLayoutParams().get().type;
                if ((type == WindowManager.LayoutParams.TYPE_TOAST)) {
                    IBinder windowToken = root.getDecorView().getWindowToken();
                    IBinder appToken = root.getDecorView().getApplicationWindowToken();
                    if (windowToken == appToken)
                        return true;
                }
                return false;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("Is a toast");
            }
        };
    }

    
}
