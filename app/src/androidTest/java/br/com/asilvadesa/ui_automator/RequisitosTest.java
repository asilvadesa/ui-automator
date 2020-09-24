package br.com.asilvadesa.ui_automator;

import android.content.Context;
import android.content.Intent;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;

@RunWith(AndroidJUnit4.class)
public class RequisitosTest {

    private static final String BASIC_SAMPLE_PACKAGE = "com.android.settings";
    private UiDevice mDevice;


    @Test
    public void dadosEmRoamingDesativado() throws UiObjectNotFoundException {

        // Initialize UiDevice instance
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        // Start from the home screen
        mDevice.pressHome();

        Context context = getApplicationContext();
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(BASIC_SAMPLE_PACKAGE);
        context.startActivity(intent);

        mDevice.findObject(new UiSelector().text("Conexões")).clickAndWaitForNewWindow();
        mDevice.findObject(new UiSelector().text("Redes móveis")).clickAndWaitForNewWindow();

        UiObject object = mDevice.findObject(new UiSelector().resourceId("com.samsung.android.app.telephonyui:id/recycler_view"));
        int childCount = object.getChildCount();

        UiObject child = object.getChild(new UiSelector().index(0))
                .getChild(new UiSelector().index(1)).getChild(new UiSelector().index(0));

        Assert.assertEquals(false, child.isChecked());
    }
}
