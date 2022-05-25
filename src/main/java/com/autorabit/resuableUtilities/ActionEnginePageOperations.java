package com.autorabit.resuableUtilities;

import com.autorabit.suiteBase.DriverClass;
import com.autorabit.suiteBase.ExtentReportClass;
import com.autorabit.suiteBase.LoggerClass;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class ActionEnginePageOperations {
	com.aventstack.extentreports.ExtentTest test;
	public ActionEnginePageOperations()
	{}
	public ActionEnginePageOperations(com.aventstack.extentreports.ExtentTest test) {
		// Constructor of GenericKeywords, called when object of this class is created
		this.test = test;
	}

    public WebElement getWebElement(String findBy,String element){
        if ("ID".equals(findBy.toUpperCase())) {
            return DriverClass.getInstance().getDriver().findElement(By.id(element));
        } else if ("NAME".equals(findBy.toUpperCase())) {
            return DriverClass.getInstance().getDriver().findElement(By.name(element));
        } else if ("XPATH".equals(findBy.toUpperCase())) {
            return DriverClass.getInstance().getDriver().findElement(By.xpath(element));
        } else if ("CSSSELECTOR".equals(findBy.toUpperCase())) {
            return DriverClass.getInstance().getDriver().findElement(By.cssSelector(element));
        } else if ("CLASSNAME".equals(findBy.toUpperCase())) {
            return DriverClass.getInstance().getDriver().findElement(By.className(element));
        } else if ("TAG".equals(findBy.toUpperCase())) {
            return DriverClass.getInstance().getDriver().findElement(By.tagName(element));
        } else if ("LINKTEXT".equals(findBy.toUpperCase())) {
            return DriverClass.getInstance().getDriver().findElement(By.linkText(element));
        } else if ("PARTIALLINK".equals(findBy.toUpperCase())) {
            return DriverClass.getInstance().getDriver().findElement(By.partialLinkText(element));
        }
        System.out.println("Provided Element: " + findBy + "is not available with: " + element);
        return null;
    }

    public List<WebElement> getWebElements(String findBy, String element){
        if ("ID".equals(findBy.toUpperCase())) {
            return DriverClass.getInstance().getDriver().findElements(By.id(element));
        } else if ("NAME".equals(findBy.toUpperCase())) {
            return DriverClass.getInstance().getDriver().findElements(By.name(element));
        } else if ("XPATH".equals(findBy.toUpperCase())) {
            return DriverClass.getInstance().getDriver().findElements(By.xpath(element));
        } else if ("CSSSELECTOR".equals(findBy.toUpperCase())) {
            return DriverClass.getInstance().getDriver().findElements(By.cssSelector(element));
        } else if ("CLASSNAME".equals(findBy.toUpperCase())) {
            return DriverClass.getInstance().getDriver().findElements(By.className(element));
        } else if ("TAG".equals(findBy.toUpperCase())) {
            return DriverClass.getInstance().getDriver().findElements(By.tagName(element));
        } else if ("LINKTEXT".equals(findBy.toUpperCase())) {
            return DriverClass.getInstance().getDriver().findElements(By.linkText(element));
        } else if ("PARTIALLINK".equals(findBy.toUpperCase())) {
            return DriverClass.getInstance().getDriver().findElements(By.partialLinkText(element));
        }
        System.out.println("Provided Element: " + findBy + "is not available with: " + element);
        return null;
    }

    public void typeText(String findBy,String element,String valueToType){
            try {
                getWebElement(findBy, element).sendKeys(valueToType);
                ExtentReportClass.getInstance().getExtent().log(Status.PASS,element+"==> entered value as: "+valueToType);
            }catch (Exception e) {
            }
        }

    public void clickButton(String findBy,String element){
        try {
            getWebElement(findBy, element).click();
            ExtentReportClass.getInstance().getExtent().log(Status.PASS, "Clicked on Button with field name: " + element);
        }catch (Exception e){}
    }

    public void click(String findBy,String element){
        try{
            getWebElement(findBy,element).click();
            ExtentReportClass.getInstance().getExtent().log(Status.PASS,"Clicked on Option with field name :"+element);
        }catch (Exception e){

        }
    }

    public void clear(String findBy,String element) {
        try {
           getWebElement(findBy,element).clear();
            Thread.sleep(250);
            ExtentReportClass.getInstance().getExtent().log(Status.PASS, element+"==> Data Cleared Successfully! ");
        } catch (Exception e) {
        }
    }
    public boolean isElementPresent(String findBy,String element){
        boolean flag = false;
        try {
            flag = getWebElement(findBy,element).isDisplayed();
            ExtentReportClass.getInstance().getExtent().log(Status.PASS, element+"==> Presence of field is: "+ flag);
            return flag;
        } catch (Exception e) {
            return flag;
        }
    }
}
