package com.iScanner.test;

import com.iScanner.screens.CaptureScreen;
import com.iScanner.screens.LaunchScreen;
import com.iScanner.screens.ScannerPreviewScreen;
import com.iScanner.utility.CommonUtil;
import com.iScanner.utility.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;

/**
 * Created by pina on 22/06/17.
 */
public class ScreenCaptureTest extends TestBase{



// validating image capture functionality of the iScanner app

    @Test(dataProvider = "from-json")
    public void ct001_verifyImageCaptureFunctionality(AndroidDriver driver) {

        CommonUtil util= new CommonUtil();
        LaunchScreen launchScreen= new LaunchScreen(driver);
        launchScreen.addDocument(driver);
        launchScreen.chooseCamera(driver);

        CaptureScreen captureScreen = new CaptureScreen(driver);
        captureScreen.takePicture(driver);

        ScannerPreviewScreen scannerPreviewScreen = new ScannerPreviewScreen(driver);

        Assert.assertTrue(scannerPreviewScreen.verifyCapturedImage(driver), "Validating image is captured ");

        util.saveScreenShotAsJpg("image1.jpg",driver );}

// validating cancel button functionality from capture screen before taking picture of the document
//  Expected out put is app returns to its initial    screen and there is no capture button
    @Test
    public void ct002_verifyCancelButtonFunctionalityFromCaptureStandBy(AndroidDriver driver) {

        LaunchScreen launchScreen= new LaunchScreen(driver);
        launchScreen.addDocument(driver);

        launchScreen.chooseCamera(driver);
        CaptureScreen captureScreen = new CaptureScreen(driver);

        captureScreen.clickCancelOnCameraView(driver);

        // the app exist from capture standby mode
        Assert.assertFalse(captureScreen.verifyCaptureBtn(driver), "No capture button after canceling out of capture screen ");

    }

// validating iScanner keeps its state after sending it to background and relaunching  it

        @Test
        public void ct003_verifyPreviewImageResumesAfterSendingAppToBackgroundAndRelauchingiScannerApp(AndroidDriver driver) {
            CommonUtil util = new CommonUtil();
            LaunchScreen launchScreen= new LaunchScreen(driver);
            launchScreen.addDocument(driver);
            launchScreen.chooseCamera(driver);

            CaptureScreen captureScreen = new CaptureScreen(driver);
            captureScreen.takePicture(driver);

            ScannerPreviewScreen scannerPreviewScreen = new ScannerPreviewScreen(driver);

            util.clickHardWareHomeBtn(driver);

            util.relaunchiScannerFromBackGround(driver);

            Assert.assertTrue(scannerPreviewScreen.verifyCapturedImage(driver), "validating preview  after putting app to background after capture");




        }






}
