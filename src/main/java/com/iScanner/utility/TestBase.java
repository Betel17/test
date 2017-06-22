package com.iScanner.utility;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.net.URL;

/**
 * Created by pina on 22/06/17.
 */
public class TestBase {

    private AppiumDriver driver;

    @BeforeMethod
    public void setUp() throws Exception{



        File appDir= new File("/Users/blegesse/Desktop");
        File app= new File(appDir,"iScanner.apk");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("automationName","appium");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "6.01");
        cap.setCapability("deviceName","samsung galaxy");
        cap.setCapability("app",app.getAbsolutePath());
        cap.setCapability("newCommandTimeout","600");
        cap.setCapability("autoLaunch", "true");
        driver= new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);


    }

    @AfterMethod
    public void teardown() throws Exception{

        driver.quit();
    }
}
