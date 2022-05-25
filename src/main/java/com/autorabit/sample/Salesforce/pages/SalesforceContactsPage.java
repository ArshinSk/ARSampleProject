package com.autorabit.sample.Salesforce.pages;

import com.autorabit.resuableUtilities.ActionEnginePageOperations;
import com.autorabit.sample.Salesforce.locators.SalesforceContactsPageLocators;
import com.autorabit.sample.Salesforce.locators.Salesforce_OpportunitiesPageLocators;
import com.autorabit.suiteBase.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SalesforceContactsPage extends ActionEnginePageOperations {

    public void clickOn_New_Contact(){
        WebDriverWait wait = new WebDriverWait(DriverClass.getInstance().getDriver(), Duration.ofMinutes(1));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SalesforceContactsPageLocators.Button_NewContact_XPATH)));

        WebElement NewContact = getWebElement("XPATH",SalesforceContactsPageLocators.Button_NewContact_XPATH);
        JavascriptExecutor jse = (JavascriptExecutor)DriverClass.getInstance().getDriver();
        jse.executeScript("arguments[0].click()", NewContact);
    }
    public void selectSalutation(){
        WebDriverWait wait = new WebDriverWait(DriverClass.getInstance().getDriver(), Duration.ofMinutes(1));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SalesforceContactsPageLocators.Dropdown_Salutation_XPATH)));

        WebElement dd_option = getWebElement("XPATH", SalesforceContactsPageLocators.Dropdown_Salutation_XPATH);
        JavascriptExecutor jse = (JavascriptExecutor)DriverClass.getInstance().getDriver();
        jse.executeScript("arguments[0].click()", dd_option);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        Actions action = new Actions(DriverClass.getInstance().getDriver());
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
    }
    public void enterFirstName(String fName){
        WebDriverWait wait = new WebDriverWait(DriverClass.getInstance().getDriver(), Duration.ofMinutes(1));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SalesforceContactsPageLocators.TextField_ContactFirstName_XPATH)));

        clear("XPATH",SalesforceContactsPageLocators.TextField_ContactFirstName_XPATH);
        typeText("XPATH",SalesforceContactsPageLocators.TextField_ContactFirstName_XPATH,fName);
    }
    public void enterLastName(String lName){
        WebDriverWait wait = new WebDriverWait(DriverClass.getInstance().getDriver(), Duration.ofMinutes(1));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SalesforceContactsPageLocators.TextField_ContactLastName_XPATH)));

        clear("XPATH",SalesforceContactsPageLocators.TextField_ContactLastName_XPATH);
        typeText("XPATH",SalesforceContactsPageLocators.TextField_ContactLastName_XPATH,lName);
    }
    public void clickOn_Save_Contact(){
        WebDriverWait wait = new WebDriverWait(DriverClass.getInstance().getDriver(), Duration.ofMinutes(1));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SalesforceContactsPageLocators.Button_Save_XPATH)));

        clickButton("XPATH",SalesforceContactsPageLocators.Button_Save_XPATH);
    }
    public void provideContactDetails(String fname,String lname){
        WebDriverWait wait = new WebDriverWait(DriverClass.getInstance().getDriver(), Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesforceContactsPageLocators.Popup_NewContact_XPATH)));
        WebElement NewContactPopup = getWebElement("XPATH",SalesforceContactsPageLocators.Popup_NewContact_XPATH);
        if(NewContactPopup.isDisplayed()) {
            selectSalutation();
            enterFirstName(fname);
            enterLastName(lname);
            clickOn_Save_Contact();
        }

    }
    public void clickOn_ContactsTab(){
        WebDriverWait wait = new WebDriverWait(DriverClass.getInstance().getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SalesforceContactsPageLocators.LinkTab_Contacts_XPATH)));

        //click("XPATH","//a[@title='Opportunities' and @tabindex='0']");
        WebElement OpportunityTab = getWebElement("XPATH",SalesforceContactsPageLocators.LinkTab_Contacts_XPATH);
        JavascriptExecutor jse = (JavascriptExecutor)DriverClass.getInstance().getDriver();
        jse.executeScript("arguments[0].click()", OpportunityTab);
    }

    public boolean isContactAvailable(String name){
        boolean isAvailable = false;
        WebDriverWait wait = new WebDriverWait(DriverClass.getInstance().getDriver(), Duration.ofMinutes(1));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SalesforceContactsPageLocators.ContactsTable_XPATH)));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement OpportunityTable = getWebElement("XPATH",SalesforceContactsPageLocators.ContactsTable_XPATH);

        List<WebElement> TableRows = OpportunityTable.findElements(By.tagName("tr"));

        for(int index=1; index<TableRows.size(); index++){
            System.out.println("################## Contact Name:"+TableRows.get(index).findElement(By.xpath(SalesforceContactsPageLocators.LinkInContactsTable_ContactNameLink_XPATH)).getAttribute("title"));
            if(TableRows.get(index).findElement(By.xpath(SalesforceContactsPageLocators.LinkInContactsTable_ContactNameLink_XPATH)).getAttribute("title").equalsIgnoreCase(name)){
                isAvailable = true;
                break;
            }
        }
        return isAvailable;
    }
}
