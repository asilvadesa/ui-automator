package br.com.asilvadesa.ui_automator;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
public class RequirementsTest extends BaseTest{

    private static final String BASIC_PACKAGE = "com.android.settings";

    @Test
    public void dataRoamingDisable() throws UiObjectNotFoundException {
        openApplicationWithPackage(BASIC_PACKAGE);
        selectObjectWithText("Conexões");
        selectObjectWithText("Redes móveis");
        UiObject object = selectObjectGreatGrandsonWithResourceId("com.samsung.android.app.telephonyui:id/recycler_view", 0, 1, 0);
        Assert.assertEquals(false, object.isChecked());
    }

}
