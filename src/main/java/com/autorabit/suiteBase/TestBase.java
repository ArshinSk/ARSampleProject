package com.autorabit.suiteBase;

import com.autorabit.resuableUtilities.PropertyReader;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestBase {
    BrowserClass browClass = new BrowserClass();

    @BeforeMethod
    public void launchApplication() throws Exception {
        String browserName = PropertyReader.getPropertyValue("browser");
        String appUrl = PropertyReader.getPropertyValue("url");

        DriverClass.getInstance().setDriver(browClass.createBrowserInstance(browserName,false));
        WebDriver driver = DriverClass.getInstance().getDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
        driver.get(appUrl);

    }

    @AfterMethod
    public void afterMethod(){
        DriverClass.getInstance().closeBrowser();
    }


}
