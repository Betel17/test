package com.iScanner.utility;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by pina on 22/06/17.
 */
public class CommonUtil {






    public  static void saveScreenShotAsJpg(String fileName , AppiumDriver driver) {
        String filepath="src/main/resources/outputImage/";
        String fullFileName=filepath+fileName;
        try {
            File screenShotJpg = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShotJpg, new File(fullFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public boolean verifyBtn(AppiumDriver driver, WebElement btn) {
        boolean isBtnPresent = false;
        int timeOutInSeconds = 5;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);

        try {
            if (wait.until(ExpectedConditions.elementToBeClickable(btn)) != null) {


                isBtnPresent = true;
            }

        } catch (TimeoutException e) {


        }
        return isBtnPresent;
    }


        public boolean verifytxt(AppiumDriver driver, WebElement btn, String Str) {
            boolean  istextPresent=false;
            int timeOutInSeconds = 5;
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);

            try{
                wait.until(ExpectedConditions.visibilityOf(btn));
                if (btn.getAttribute("text").equals(Str) || btn.getAttribute("content-desc").equalsIgnoreCase(Str)) {

                    istextPresent= true;}
            }catch(Exception e) {


            }
            return istextPresent;
        }


    public void clickbtn (AppiumDriver driver, WebElement btn){

        int timeOutInSeconds = 5;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);

        wait.until(ExpectedConditions.elementToBeClickable(btn)).click();

    }



    public void clickHardWareHomeBtn(AndroidDriver driver)  {

        driver.pressKeyCode(AndroidKeyCode.KEYCODE_HOME);

    }


    public void relaunchiScannerFromBackGround(AndroidDriver driver){


        try {
            Thread.sleep(1000);
            driver.pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);

            Thread.sleep(1000);

            driver.findElementByAccessibilityId("iScanner").click();

            Thread.sleep(1000);


        } catch (InterruptedException e){
            e.printStackTrace();

        }
    }

    }





