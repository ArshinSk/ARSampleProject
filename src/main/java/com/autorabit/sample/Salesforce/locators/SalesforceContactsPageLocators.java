package com.autorabit.sample.Salesforce.locators;

public interface SalesforceContactsPageLocators {

    String Button_NewContact_XPATH="//div[@title='New']";

    String Popup_NewContact_XPATH="//div[@class='isModal inlinePanel oneRecordActionWrapper']";
    String Dropdown_Salutation_XPATH="//button[@name='salutation']";
    String TextField_ContactFirstName_XPATH="//input[@name='firstName']";
    String TextField_ContactLastName_XPATH="//input[@name='lastName']";

    String Button_Save_XPATH="//button[@name='SaveEdit']";
    String Button_SaveANDNew_XPATH="//button[@name='SaveAndNew']";
    String Button_Cancel_XPATH="//button[@name='CancelEdit']";

    String LinkTab_Contacts_XPATH="//a[@title='Contacts' and @tabindex='0']";
    String ContactsTable_XPATH="//table[@role='grid']";
    String LinkInContactsTable_ContactNameLink_XPATH="//a[@data-refid='recordId']";
}
