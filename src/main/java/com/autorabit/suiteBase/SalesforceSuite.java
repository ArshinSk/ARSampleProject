package com.autorabit.suiteBase;

import com.autorabit.resuableUtilities.PropertyReader;
import com.autorabit.sample.Salesforce.pages.SalesforceLoginPage;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Dimension;

public class SalesforceSuite extends TestData{

    BrowserClass browClass = new BrowserClass();
    String Suite_TestData=System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"TestData"+File.separator;
    public static String RunNumber; // Can be added to the TestData to make independent for each RUN
    public static boolean Browser_in_HeadlessMode=false;
    public static String browserName;

    public SalesforceSuite(){
        PropertyReader.configurePropertyFile(Suite_TestData+"Salesforce_Project.properties");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("------------------------------ Class Execution Started --------------------------");

        browserName = PropertyReader.getPropertyValue("browser");
        String app_Url= "https://"+PropertyReader.getPropertyValue("url");
        RunNumber = PropertyReader.getPropertyValue("RunNumber");
        Browser_in_HeadlessMode = Boolean.parseBoolean(PropertyReader.getPropertyValue("RunBrowserInHeadlessMode"));
        DriverClass.getInstance().setDriver(browClass.createBrowserInstance(browserName,Browser_in_HeadlessMode));
        WebDriver driver = DriverClass.getInstance().getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        driver.get(app_Url);
        System.out.println("Starting browser '"+browserName+"' and Loading Salesforce Application in the browser.....");
        System.out.println("Opening Instance URL is:"+app_Url);
        logInToApplication();
    }


    @AfterClass
    public void afterClass(){
        DriverClass.getInstance().closeBrowser();
    }

    public void logInToApplication(){
        com.autorabit.sample.Salesforce.pages.SalesforceLoginPage login = new SalesforceLoginPage();
        login.enterUsername(PropertyReader.getPropertyValue("username"));
        login.enterPassword(PropertyReader.getPropertyValue("password"));
        login.clickLogin();
    }
}
