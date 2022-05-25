package com.autorabit.suiteBase;

import org.openqa.selenium.WebDriver;

public class DriverClass {

    /**
     * Singleton Design Pattern, which allows Objects creation only from one
     */
    private DriverClass(){

    }

    private static DriverClass instance = new DriverClass();

    public static DriverClass getInstance(){
        return instance;
    }

    /**
     *  Provides the Thread reference as long as Thread is alive
     */
    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public WebDriver getDriver(){
        return driver.get();
    }

    public void setDriver(WebDriver driverLocal){
        driver.set(driverLocal);
    }

    public void closeBrowser(){
        driver.get().quit();
        driver.remove();
    }
}
