package com.autorabit.suiteBase;

import com.autorabit.resuableUtilities.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import java.io.File;

public class BrowserClass {

    public WebDriver createBrowserInstance(String browser,boolean headlessMode){
        WebDriver driver = null;
            if(browser.equalsIgnoreCase("Chrome")){

                //WebDriverManager.chromedriver().setup();
                /*String driverPath = System.getProperty("user.dir") + File.separator + "browserDriver" + File.separator
						+ "chromedriver";*/
				//System.out.println("####################### Driver Path:"+driverPath);		
				//File driverFile = new File(driverPath);
				//driverFile.setExecutable(true);
                //System.setProperty("webdriver.chrome.driver", driverPath);
                
                    ChromeOptions chOptions = new ChromeOptions();
                    //chOptions.addArguments("--incognito");
                    chOptions.addArguments("--window-size=1920,1080");
                    //chOptions.addArguments("--whitelisted-ips");
                    //chOptions.addArguments("--no-sandbox");
                if(headlessMode)
                        chOptions.addArguments("--headless");
                //driver = new ChromeDriver(chOptions);
                //driver = new ChromeDriver();
                //driver = new ChromeDriver(chOptions);
        WebDriverManager.chromedriver().setup();
        //ChromeOptions chopts = new ChromeOptions().setHeadless(true);
        driver = new ChromeDriver(chOptions);

            }else if(browser.equalsIgnoreCase("Firefox")){

                WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions ffOptions = new FirefoxOptions();
                    ffOptions.addArguments("-private");
                    ffOptions.addArguments("--window-size=1920,1080");
                if(headlessMode)
                        ffOptions.addArguments("-headless");
                driver = new FirefoxDriver(ffOptions);

            }else if(browser.equalsIgnoreCase("IE")){

                WebDriverManager.iedriver().setup();
                    InternetExplorerOptions ieOptions = new InternetExplorerOptions();
                    ieOptions.addCommandSwitches("-private");
                    ieOptions.addCommandSwitches("--window-size=1920,1080");
                driver = new InternetExplorerDriver(ieOptions);

            }else if(browser.equalsIgnoreCase("Edge")){

                WebDriverManager.edgedriver().setup();
                    EdgeOptions eOptions = new EdgeOptions();
                    eOptions.addArguments("-private");
                    eOptions.addArguments("--window-size=1920,1080");
                driver= new EdgeDriver(eOptions);

            }
    return driver;
    }
}
