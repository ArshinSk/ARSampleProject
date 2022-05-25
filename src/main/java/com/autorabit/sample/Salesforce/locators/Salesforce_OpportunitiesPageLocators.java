package com.autorabit.sample.Salesforce.locators;

public interface Salesforce_OpportunitiesPageLocators {
    String Button_New_XPATH="//div[@title='New']";

    String TabLink_Opportunity_XPATH="//a[@title='Opportunities' and @tabindex='0']";
    String OpportunityTable_XPATH="//table[@role='grid']";
    String LinkInOpportunityTable_OpportunityNameLink_XPATH="//a[@data-refid='recordId']";

    String Popup_NewOpportunityPOPUP_XPATH="//div[@class='isModal inlinePanel oneRecordActionWrapper']";
    String TextField_Amount_XPATH="//input[@name='Amount']";
    String TextField_CloseDate_XPATH="//input[@name='CloseDate']";
    String TextField_OpportunityName_XPATH="//input[@name='Name']";
    String Dropdown_Stage_XPATH="//button[@type='button' and starts-with(@aria-label,'Stage,')]";
    String TextArea_Description_XPATH="//textarea[starts-with(@id,'input-')]";

    String Button_Save_XPATH="//button[@name='SaveEdit']";
    String Button_SaveANDNew_XPATH="//button[@name='SaveAndNew']";
    String Button_Cancel_XPATH="//button[@name='CancelEdit']";
}
