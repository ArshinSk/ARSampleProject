package com.autorabit.suiteBase;

import com.autorabit.resuableUtilities.PropertyReader;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GenerateExtentReport {
    static ExtentReports extent;
    public static String fName;
    public static ExtentReports setupExtentReport() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
        Date date =new Date();
        String presentDate = dateFormat.format(date);

        String reportPath = System.getProperty("user.dir")+ File.separator+"target"+File.separator+"reports"+File.separator+"Execution_"+presentDate+".html";
        fName=reportPath;
        ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(sparkReport);

        sparkReport.config().setDocumentTitle("Salesforce AutomationTests Results");
        sparkReport.config().setReportName("Salesforce Suite Results");
        sparkReport.config().setTheme(Theme.DARK);

        extent.setSystemInfo("Executed Environment:", PropertyReader.getPropertyValue("url"));
        extent.setSystemInfo("Executed Browser:",PropertyReader.getPropertyValue("browser"));
        extent.setSystemInfo("Executed OS:",System.getProperty("os.name"));
        extent.setSystemInfo("Executed By:",System.getProperty("user.name"));
        return extent;
    }
    
    public static String CopyfileName()
    {
    	return fName;
    }
   
}
