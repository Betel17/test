package com.iScanner.test;

import com.iScanner.screens.LaunchScreen;
import com.iScanner.utility.CommonUtil;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by pina on 22/06/17.
 */
public class LaunchScreenTest {

    @Test
    public void lt001_verifyCameraBtn(AndroidDriver driver) {
        LaunchScreen launchScreen = new LaunchScreen(driver);
        launchScreen.addDocument(driver);

        Assert.assertTrue(launchScreen.verifyCameraBtn(driver), "validating camera btn on Launch screen");
    }

    @Test
    public void lt002_verifyPhotosBtn(AndroidDriver driver) {
        LaunchScreen launchScreen = new LaunchScreen(driver);
        launchScreen.addDocument(driver);

        Assert.assertTrue(launchScreen.verifyPhotoBtn(driver), "validating camera btn on Launch screen");
    }
}