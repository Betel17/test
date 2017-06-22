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
public class LaunchScreen {

    public LaunchScreen(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);


    }
    CommonUtil util = new CommonUtil();

    @AndroidFindBy(id = "id/addDocumentIcon")
    public WebElement btnAddDocument;

// Choose either photo gallery  or camera
    @AndroidFindBy(id = "id/camera")
    public WebElement btnCamera;


    @AndroidFindBy(id = "id/Photos")
    public WebElement btnPhoto;



    public boolean verifyAddDocumnetBtn(AppiumDriver driver) {
        return(util.verifyBtn(driver,btnAddDocument));

    }


    public boolean verifyCameraBtn(AppiumDriver driver) {
        return(util.verifyBtn(driver,btnCamera));

    }



    public boolean verifyPhotoBtn(AppiumDriver driver) {
        return(util.verifyBtn(driver,btnPhoto));

    }


    public void addDocument(AppiumDriver driver){

        util.clickbtn(driver,btnAddDocument);

    }

    public void chooseCamera(AppiumDriver driver){

        util.clickbtn(driver,btnCamera);

    }

    public void choosePhotos(AppiumDriver driver){

        util.clickbtn(driver,btnPhoto);

    }





}
