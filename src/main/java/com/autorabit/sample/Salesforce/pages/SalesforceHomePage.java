package com.autorabit.sample.Salesforce.pages;

import com.autorabit.resuableUtilities.ActionEnginePageOperations;
import com.autorabit.sample.Salesforce.locators.SalesforceHomePageLocators;
import com.autorabit.suiteBase.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SalesforceHomePage extends ActionEnginePageOperations {

    public void clickOn_Apps(){
        WebDriverWait wait =new WebDriverWait(DriverClass.getInstance().getDriver(), Duration.ofMinutes(1));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SalesforceHomePageLocators.IconApps_Apps_XPATH)));
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
        click("XPATH", SalesforceHomePageLocators.IconApps_Apps_XPATH);
    }

    public void searchApps_and_Items(String keyword){
        WebDriverWait wait = new WebDriverWait(DriverClass.getInstance().getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SalesforceHomePageLocators.TextField_SearchAppsandItems_XPATH)));
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
        clear("XPATH", SalesforceHomePageLocators.TextField_SearchAppsandItems_XPATH);
        typeText("XPATH", SalesforceHomePageLocators.TextField_SearchAppsandItems_XPATH,keyword);
    }

    public void clickOn_Item(String Item){
        WebDriverWait wait = new WebDriverWait(DriverClass.getInstance().getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SalesforceHomePageLocators.Dropdown_AppsANDItems_XPATH)));

        WebElement Dropdown_Items = getWebElement("XPATH", SalesforceHomePageLocators.Dropdown_AppsANDItems_XPATH).findElement(By.xpath("//div[@aria-label='Items']"));
        List<WebElement> Options = Dropdown_Items.findElements(By.xpath("//a[@role='option' and @data-label='"+Item+"']"));

        for(WebElement opt:Options){
            if(opt.getAttribute("data-label").equalsIgnoreCase(Item)){
                JavascriptExecutor jse = (JavascriptExecutor)DriverClass.getInstance().getDriver();
                jse.executeScript("arguments[0].click()", opt);
                break;
            }
        }
    }
}
