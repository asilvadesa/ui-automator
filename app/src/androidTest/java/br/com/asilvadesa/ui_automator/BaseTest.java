package br.com.asilvadesa.ui_automator;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;

import org.junit.Before;
import org.junit.runner.RunWith;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;

@RunWith(AndroidJUnit4.class)
public class BaseTest {

    private UiDevice mDevice;

    @Before
    public void initialize(){
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        mDevice.pressHome();


    }

    protected void setCommandAdbShell(String command){
        InstrumentationRegistry.getInstrumentation().getUiAutomation().executeShellCommand(command);
    }


    protected UiObject selectObjectGreatGrandsonWithResourceId(String res, int child, int grandChild, int greatGrandson) throws UiObjectNotFoundException {

        UiObject object = mDevice.findObject(new UiSelector().resourceId(res));
        return object.getChild(new UiSelector().index(child))
                .getChild(new UiSelector().index(grandChild)).getChild(new UiSelector().index(greatGrandson));
    }

    protected void selectObjectWithText(String textName) throws UiObjectNotFoundException {
        mDevice.findObject(new UiSelector().text(textName)).clickAndWaitForNewWindow();
    }

    protected void openApplicationWithPackage(String packageName) {
        Context context = getApplicationContext();
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(packageName);
        String aPackage = intent.getPackage();
        Log.i("NOME ", aPackage);
        context.startActivity(intent);
    }
}
