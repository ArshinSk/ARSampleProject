package com.autorabit.sample.Salesforce;

import com.autorabit.resuableUtilities.PropertyReader;
import com.autorabit.sample.Salesforce.pages.SalesforceHomePage;
import com.autorabit.sample.Salesforce.pages.SalesforceLoginPage;
import com.autorabit.sample.Salesforce.pages.Salesforce_OpportunitiesPage;
import com.autorabit.suiteBase.BrowserClass;
import com.autorabit.suiteBase.DriverClass;
import com.autorabit.suiteBase.SalesforceSuite;
import com.autorabit.suiteBase.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@Listeners(com.autorabit.resuableUtilities.ListenersImplementation.class)
public class LogInTests extends TestData {
    String Suite_TestData=System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"TestData"+File.separator;
    String browserName;
    String RunNumber;
    boolean Browser_in_HeadlessMode;
    BrowserClass browClass = new BrowserClass();

    public LogInTests(){
        testDataFile="ValidLogInTests.json";
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
        System.out.println("Starting browser '"+browserName+"' and Loading ARM Application in the browser.....");
        System.out.println("Opening Instance URL is:"+app_Url);
    }


    @AfterClass
    public void afterClass(){
        //LoggerClass.info("------------------------------ Class Execution Ended --------------------------");
        DriverClass.getInstance().closeBrowser();
    }


    @Test(dataProvider = "readDataFromJson")
    public void ValidLogInTests(Object dataObj){
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@ LogIn Tests @@@@@@@@@@@@@@@@@@@@@@@@@@");
        HashMap<String,String> testData = (HashMap<String, String>) dataObj;

        SalesforceLoginPage login = new SalesforceLoginPage();
        login.enterUsername(testData.get("Username"));
        login.enterPassword(testData.get("Password"));
        login.clickLogin();

       System.out.println("%%%%%%%%%%%%%%%%%% isDisplayed->"+ new SalesforceLoginPage().isLoggedIn());
    }


}
