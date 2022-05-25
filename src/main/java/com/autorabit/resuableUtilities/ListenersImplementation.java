package com.autorabit.resuableUtilities;

import com.autorabit.suiteBase.DriverClass;
import com.autorabit.suiteBase.ExtentReportClass;
import com.autorabit.suiteBase.GenerateExtentReport;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ListenersImplementation implements ITestListener {
    static ExtentReports report=GenerateExtentReport.setupExtentReport();
    static ExtentTest extTest;
    public void onTestStart(org.testng.ITestResult result) {
        extTest=report.createTest(result.getMethod().getMethodName());
        ExtentReportClass.getInstance().setExtent(extTest);
    }

    public void onTestSuccess(org.testng.ITestResult result) {
        ExtentReportClass.getInstance().getExtent().log(Status.PASS,"Test Case : "+result.getMethod().getMethodName()+" is PASSED");
        File src = ((TakesScreenshot) DriverClass.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
        Date date = new Date();
        String presentDate = dateFormat.format(date);

        String methodName = result.getMethod().getMethodName();
        String screenShotFilePath = System.getProperty("user.dir")+File.separator+"target"+File.separator+"reports"+File.separator+"ScreenShots"+File.separator+methodName+"_"+presentDate+".png";
        String screenShotFilePath1 = "ScreenShots"+File.separator+methodName+"_"+presentDate+".png";
        System.out.println("************************ Screenshot Path:"+screenShotFilePath);
        File dest = new File(screenShotFilePath);
        try {
            FileUtils.copyFile(src,dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //ExtentReportClass.getInstance().getExtent().addScreenCaptureFromPath(screenShotFilePath,"TestCase Passed Screenshot");
        ExtentReportClass.getInstance().getExtent().log(Status.INFO, "Click Here for screenshot",MediaEntityBuilder.createScreenCaptureFromPath( screenShotFilePath1).build());  
        ExtentReportClass.getInstance().flushReports();
    }

    public void onTestFailure(org.testng.ITestResult result) {
        ExtentReportClass.getInstance().getExtent().log(Status.FAIL,"Test Case: "+result.getMethod().getMethodName()+" is FAILED");
        ExtentReportClass.getInstance().getExtent().log(Status.FAIL,result.getThrowable());

        //Add Screen shot for the failed Tests
        File src = ((TakesScreenshot) DriverClass.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
        Date date = new Date();
        String presentDate = dateFormat.format(date);

        String methodName = result.getMethod().getMethodName();
        String screenShotFilePath = System.getProperty("user.dir")+File.separator+"target"+File.separator+"reports"+File.separator+"ScreenShots"+File.separator+methodName+"_"+presentDate+".png";
        String screenShotFilePath1 ="ScreenShots"+File.separator+methodName+"_"+presentDate+".png";
        System.out.println("************************ Screenshot Path:"+screenShotFilePath);
       
        File dest = new File(screenShotFilePath);
        try {
            FileUtils.copyFile(src,dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

      ExtentReportClass.getInstance().getExtent().log(Status.INFO, "Click Here for screenshot",MediaEntityBuilder.createScreenCaptureFromPath( screenShotFilePath1).build());
      ExtentReportClass.getInstance().flushReports();
    }

    public void onTestSkipped(org.testng.ITestResult result) {
        ExtentReportClass.getInstance().getExtent().log(Status.SKIP,"Test Case : "+result.getMethod().getMethodName()+" is SKIPPED");
        ExtentReportClass.getInstance().flushReports();
    }

    public void onTestFailedButWithinSuccessPercentage(org.testng.ITestResult result) { /* compiled code */ }

    public void onTestFailedWithTimeout(org.testng.ITestResult result) { /* compiled code */ }

    public void onStart(org.testng.ITestContext context) {
    }

    public void onFinish(org.testng.ITestContext context) {
            report.flush();
            String fileName = GenerateExtentReport.CopyfileName();
            copyFileFromReports(fileName);
    }
    public static void copyFileFromReports(String fileName)
    {	
    	FileInputStream instream = null;
    	FileOutputStream outstream = null;
 
    	try{
    	    File infile =new File(fileName);
    	    File outfile =new File(System.getProperty("user.dir")+ File.separator+"target"+ File.separator+"reports"+File.separator+"TestReport.html");
 
    	    instream = new FileInputStream(infile);
    	    outstream = new FileOutputStream(outfile);
 
    	    long fileSize = new File(fileName).length();
    	    System.out.println("File size is :"+fileSize);
    	    byte[] buffer = new byte[(int)fileSize];
 
    	    int length;
    	    while ((length = instream.read(buffer)) > 0){
    	    	outstream.write(buffer, 0, length);
    	    }

    	    instream.close();
    	    outstream.close();

    	}catch(IOException ioe){
    		ioe.printStackTrace();
    	 }
    }
}
