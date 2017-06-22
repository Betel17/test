package com.iScanner.screens;

import com.iScanner.utility.CommonUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by pina on 22/06/17.
 */
public class CaptureScreen {
    public CaptureScreen(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);


    }
    CommonUtil util = new CommonUtil();

    @AndroidFindBy(id = "id/cameraIcon")
    public WebElement btnShutter;

    @AndroidFindBy(id="com.iscanner.mobilelib.iscanner:id/sc_imagecapture_cancel_button")
    public WebElement btnCancel;

    @AndroidFindBy(id="com.iscanner.mobilelib.iscanner:id/sc_imagecapture_view")
    public WebElement cameraView;
    @AndroidFindBy(id= "com.iscanner.mobilelib.iscanner:id/sc_imagecapture_flash_button")
    public WebElement btnFlash;


    public boolean verifyCaptureBtn(AppiumDriver driver) {
        return(util.verifyBtn(driver,btnShutter));

    }
    public boolean verifyCancelBtn(AppiumDriver driver) {
        return(util.verifyBtn(driver,btnCancel));

    }
    public boolean verifyCameraView(AppiumDriver driver) {
        return(util.verifyBtn(driver,cameraView));

    }

    public void takePicture(AppiumDriver driver) {
        util.clickbtn(driver,btnShutter);
    }


    public void clickCancelOnCameraView(AppiumDriver driver) {
        util.clickbtn(driver,btnCancel);
    }

}
