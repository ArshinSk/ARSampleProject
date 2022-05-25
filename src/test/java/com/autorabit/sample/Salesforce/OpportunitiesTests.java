package com.autorabit.sample.Salesforce;

import com.autorabit.sample.Salesforce.pages.SalesforceHomePage;
import com.autorabit.sample.Salesforce.pages.Salesforce_OpportunitiesPage;
import com.autorabit.suiteBase.SalesforceSuite;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.HashMap;

@Listeners(com.autorabit.resuableUtilities.ListenersImplementation.class)
public class OpportunitiesTests extends SalesforceSuite {

    public OpportunitiesTests(){
        testDataFile="OpportunitiesTests.json";
    }

    @Test(dataProvider = "readDataFromJson")
    public void createOpportunities(Object dataObj){
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@ Create Opportunities @@@@@@@@@@@@@@@@@@@@@@@");
        HashMap<String,String> testData = (HashMap<String, String>) dataObj;

        SalesforceHomePage homePage = new SalesforceHomePage();
        homePage.clickOn_Apps();
        homePage.searchApps_and_Items(testData.get("Search_Keyword"));
        homePage.clickOn_Item(testData.get("Item"));

        Salesforce_OpportunitiesPage opportunitiesPage = new Salesforce_OpportunitiesPage();
        opportunitiesPage.clickOn_New();
        opportunitiesPage.provideNewOpportunityInformationToCreate(testData.get("Amount"),testData.get("CloseDate"),testData.get("OpportunityName"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        opportunitiesPage.clickOn_OpportunitiesTab();
        Assert.assertTrue(opportunitiesPage.isOpportunityAvailable(testData.get("OpportunityName")),"OpportunityName is not available");
    }
}
