package com.autorabit.sample.Salesforce.pages;

import com.autorabit.resuableUtilities.ActionEnginePageOperations;
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

public class Salesforce_OpportunitiesPage extends ActionEnginePageOperations {

    public void clickOn_New(){

        WebDriverWait wait = new WebDriverWait(DriverClass.getInstance().getDriver(), Duration.ofMinutes(1));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Salesforce_OpportunitiesPageLocators.Button_New_XPATH)));

        clickButton("XPATH", Salesforce_OpportunitiesPageLocators.Button_New_XPATH);
    }

    public void enterAmount(String amount){
        WebDriverWait wait = new WebDriverWait(DriverClass.getInstance().getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Salesforce_OpportunitiesPageLocators.TextField_Amount_XPATH)));
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
        clear("XPATH",Salesforce_OpportunitiesPageLocators.TextField_Amount_XPATH);
        typeText("XPATH",Salesforce_OpportunitiesPageLocators.TextField_Amount_XPATH,amount);
    }
    public void enterCloseDate(String closeDate){
        WebDriverWait wait = new WebDriverWait(DriverClass.getInstance().getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Salesforce_OpportunitiesPageLocators.TextField_CloseDate_XPATH)));

        clear("XPATH",Salesforce_OpportunitiesPageLocators.TextField_CloseDate_XPATH);
        typeText("XPATH",Salesforce_OpportunitiesPageLocators.TextField_CloseDate_XPATH,closeDate);
    }
    public void enterOpportunityName(String oppName){
        WebDriverWait wait = new WebDriverWait(DriverClass.getInstance().getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Salesforce_OpportunitiesPageLocators.TextField_OpportunityName_XPATH)));

        clear("XPATH",Salesforce_OpportunitiesPageLocators.TextField_OpportunityName_XPATH);
        typeText("XPATH",Salesforce_OpportunitiesPageLocators.TextField_OpportunityName_XPATH,oppName);
    }
    public void selectStage(){
        WebDriverWait wait = new WebDriverWait(DriverClass.getInstance().getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Salesforce_OpportunitiesPageLocators.Dropdown_Stage_XPATH)));

        WebElement dd_option = getWebElement("XPATH",Salesforce_OpportunitiesPageLocators.Dropdown_Stage_XPATH);
        JavascriptExecutor jse = (JavascriptExecutor)DriverClass.getInstance().getDriver();
        jse.executeScript("arguments[0].click()", dd_option);
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
        Actions action = new Actions(DriverClass.getInstance().getDriver());
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

    }
    public void enterDescription(String desc){
        WebDriverWait wait = new WebDriverWait(DriverClass.getInstance().getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Salesforce_OpportunitiesPageLocators.TextArea_Description_XPATH)));

        clear("XPATH",Salesforce_OpportunitiesPageLocators.TextArea_Description_XPATH);
        typeText("XPATH",Salesforce_OpportunitiesPageLocators.TextArea_Description_XPATH,desc);
    }
    public void clickOn_Save(){
        WebDriverWait wait = new WebDriverWait(DriverClass.getInstance().getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Salesforce_OpportunitiesPageLocators.Button_Save_XPATH)));

        clickButton("XPATH",Salesforce_OpportunitiesPageLocators.Button_Save_XPATH);
    }
    public void clickOn_SaveANDNew(){
        WebDriverWait wait = new WebDriverWait(DriverClass.getInstance().getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Salesforce_OpportunitiesPageLocators.Button_SaveANDNew_XPATH)));

        clickButton("XPATH",Salesforce_OpportunitiesPageLocators.Button_SaveANDNew_XPATH);
    }
    public void clickOn_Cancel(){
        WebDriverWait wait = new WebDriverWait(DriverClass.getInstance().getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Salesforce_OpportunitiesPageLocators.Button_Cancel_XPATH)));

        clickButton("XPATH",Salesforce_OpportunitiesPageLocators.Button_Cancel_XPATH);
    }
    public void provideNewOpportunityInformationToCreate(String amount,String closeDate,String opportunityName){
        WebDriverWait wait = new WebDriverWait(DriverClass.getInstance().getDriver(), Duration.ofMinutes(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Salesforce_OpportunitiesPageLocators.Popup_NewOpportunityPOPUP_XPATH)));

        WebElement Opportunity_Popup = getWebElement("XPATH",Salesforce_OpportunitiesPageLocators.Popup_NewOpportunityPOPUP_XPATH);
        if(Opportunity_Popup.isDisplayed()){
            enterAmount(amount);
            enterCloseDate(closeDate);
            enterOpportunityName(opportunityName);
            selectStage();
            clickOn_Save();
        }

    }
    public void clickOn_OpportunitiesTab(){
        WebDriverWait wait = new WebDriverWait(DriverClass.getInstance().getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Salesforce_OpportunitiesPageLocators.TabLink_Opportunity_XPATH)));

        //click("XPATH","//a[@title='Opportunities' and @tabindex='0']");
        WebElement OpportunityTab = getWebElement("XPATH",Salesforce_OpportunitiesPageLocators.TabLink_Opportunity_XPATH);
        JavascriptExecutor jse = (JavascriptExecutor)DriverClass.getInstance().getDriver();
        jse.executeScript("arguments[0].click()", OpportunityTab);
    }

    public boolean isOpportunityAvailable(String OpportunityName){
        boolean isAvailable = false;
        WebDriverWait wait = new WebDriverWait(DriverClass.getInstance().getDriver(), Duration.ofMinutes(1));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Salesforce_OpportunitiesPageLocators.OpportunityTable_XPATH)));

                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
        WebElement OpportunityTable = getWebElement("XPATH",Salesforce_OpportunitiesPageLocators.OpportunityTable_XPATH);

        List<WebElement> TableRows = OpportunityTable.findElements(By.tagName("tr"));

        for(int index=1; index<TableRows.size(); index++){
            System.out.println("################## Opportunity Name:"+TableRows.get(index).findElement(By.xpath(Salesforce_OpportunitiesPageLocators.LinkInOpportunityTable_OpportunityNameLink_XPATH)).getAttribute("title"));
            if(TableRows.get(index).findElement(By.xpath(Salesforce_OpportunitiesPageLocators.LinkInOpportunityTable_OpportunityNameLink_XPATH)).getAttribute("title").equalsIgnoreCase(OpportunityName)){
                    isAvailable = true;
                    break;
            }
        }
      return isAvailable;
    }
}
