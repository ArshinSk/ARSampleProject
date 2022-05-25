package com.autorabit.sample.Salesforce.pages;

import com.autorabit.resuableUtilities.ActionEnginePageOperations;
import com.autorabit.sample.Salesforce.locators.SalesforceLoginPageLocators;
import com.autorabit.suiteBase.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SalesforceLoginPage extends ActionEnginePageOperations {

    public void enterUsername(String username){
        clear("XPATH", SalesforceLoginPageLocators.TextField_UserName_XPATH);
        typeText("XPATH", SalesforceLoginPageLocators.TextField_UserName_XPATH,username);
        //LoggerClass.info("Provided Salesforce Username:"+username);
    }

    public void enterPassword(String password){
        clear("XPATH", SalesforceLoginPageLocators.TextField_Password_XPATH);
        typeText("XPATH", SalesforceLoginPageLocators.TextField_Password_XPATH,password);
        //LoggerClass.info("Provided Salesforce Password: xxxxxxx");
    }

    public void clickLogin(){
        clickButton("XPATH", SalesforceLoginPageLocators.Button_Login_XPATH);
        //LoggerClass.info("Clicked on 'Log-In' Button");
    }

    public boolean isLoggedIn(){
        WebDriverWait wait = new WebDriverWait(DriverClass.getInstance().getDriver(), Duration.ofMinutes(1));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SalesforceLoginPageLocators.TextField_Search_XPATH)));

        return isElementPresent("XPATH", SalesforceLoginPageLocators.TextField_Search_XPATH);
    }
}
