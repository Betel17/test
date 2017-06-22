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
public class ScannerPreviewScreen {

    public ScannerPreviewScreen(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);


    }


    @AndroidFindBy(id = "com.iscanner.mobilelib.iscanner:id/previewDone_Button")
    public WebElement btnDone;

    @AndroidFindBy(id = "com.iscanner.mobilelib.iscanner:id/trash_Button")
    public WebElement btnTrash;

    @AndroidFindBy(id = "com.iscanner.mobilelib.iscanner:id/imagePreview")
    public WebElement image;

    @AndroidFindBy(id = "com.iscanner.mobilelib.iscanner:id/previewCrop_Button")
    public WebElement btnCrop;

    CommonUtil util = new CommonUtil();






    public boolean verifyCapturedImage(AppiumDriver driver) {

        return (util.verifyBtn(driver, image));

    }


    public boolean verifyCropBtn(AppiumDriver driver) {

        return (util.verifyBtn(driver, btnCrop));

    }

    public void clickDoneBtn(AppiumDriver driver) {

        util.clickbtn(driver, btnDone);
    }

    public void clickTrashBtn(AppiumDriver driver) {

        util.clickbtn(driver, btnTrash);
    }



}