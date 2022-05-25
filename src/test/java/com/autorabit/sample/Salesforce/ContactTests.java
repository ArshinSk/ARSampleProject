package com.autorabit.sample.Salesforce;

import com.autorabit.sample.Salesforce.pages.SalesforceContactsPage;
import com.autorabit.sample.Salesforce.pages.SalesforceHomePage;
import com.autorabit.suiteBase.SalesforceSuite;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.HashMap;

@Listeners(com.autorabit.resuableUtilities.ListenersImplementation.class)
public class ContactTests extends SalesforceSuite {

    public ContactTests(){
        testDataFile="ContactTests.json";
    }

    @Test(dataProvider = "readDataFromJson")
    public void AddContact(Object dataObj){
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Add Contact @@@@@@@@@@@@@@@@@@@@@@@@@");
        HashMap<String,String> testData = (HashMap<String, String>) dataObj;

        SalesforceHomePage homePage = new SalesforceHomePage();
        homePage.clickOn_Apps();
        homePage.searchApps_and_Items(testData.get("Search_Keyword"));
        homePage.clickOn_Item(testData.get("Item"));

        SalesforceContactsPage contactsPage = new SalesforceContactsPage();
        contactsPage.clickOn_New_Contact();
        contactsPage.provideContactDetails(testData.get("FirstName"),testData.get("LastName"));

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        contactsPage.clickOn_ContactsTab();
        Assert.assertTrue(contactsPage.isContactAvailable(testData.get("FirstName")+" "+testData.get("LastName")),"ContactName is not available");
    }
}
