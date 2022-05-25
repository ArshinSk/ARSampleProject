package com.autorabit.suiteBase;

import com.aventstack.extentreports.ExtentTest;

public class ExtentReportClass {

    /**
     * Singleton Design Pattern, which allows Objects creation only from one
     */
    private static ExtentReportClass instance = new ExtentReportClass();
    private ExtentReportClass(){  }

    public static ExtentReportClass getInstance(){
        return instance;
    }

    /**
     *  Provides the Thread reference as long as Thread is alive
     */
    ThreadLocal<ExtentTest> extentThread = new ThreadLocal<ExtentTest>();

    public ExtentTest getExtent(){
        return extentThread.get();
    }

    public void setExtent(ExtentTest extentTestLocal){
        extentThread.set(extentTestLocal);
    }

    public void flushReports(){
        extentThread.remove();
    }
}
