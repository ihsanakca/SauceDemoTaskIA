package com.krafttech.utilities;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {
    private Driver() {
    }
    //InheritableThreadLocal  --> this is like a container, bag, pool. This is a java class
    //in this pool we can have separate objects for each thread
    //for each thread, in InheritableThreadLocal we can have separate object for that thread
    //driver class will provide separate webdriver object per thread
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();
    public static WebDriver get() {
        //if this thread doesn't have driver - create it and add to pool
        if (driverPool.get() == null) {
            //if we pass the driver from terminal then use that one
            //if we do not pass the driver from terminal then use the one properties file
            String browser = System.getProperty("browser") != null ? System.getProperty("browser") : ConfigurationReader.get("browser");
            switch (browser) {
                case "chrome":
                    driverPool.set(new ChromeDriver());
                    break;
                case "chrome-headless":
                    driverPool.set(new ChromeDriver(new ChromeOptions().addArguments("--headless")));
                    break;
                case "firefox":
                    driverPool.set(new FirefoxDriver());
                    break;
                case "firefox-headless":
                    driverPool.set(new FirefoxDriver(new FirefoxOptions().addArguments("--headless")));
                    break;
                case "edge":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS doesn't support Edge");
                    driverPool.set(new EdgeDriver());
                    break;
                case "safari":
                    if (!System.getProperty("os.name").toLowerCase().contains("mac"))
                        throw new WebDriverException("Your OS doesn't support Safari");
                    driverPool.set(new SafariDriver());
                    break;

                case "remote_chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.setCapability("platform",Platform.ANY);

                    try{
                        driverPool.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),chromeOptions));
                        //driverPool.set(new RemoteWebDriver(new URL("http://35.173.191.230:4444/wd/hub"),chromeOptions));
                    }catch (MalformedURLException e){
                        e.printStackTrace();
                    }

                    break;
                case "remote_firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.setCapability("platform", Platform.ANY);

                    try{
                        driverPool.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),firefoxOptions));
                        //driverPool.set(new RemoteWebDriver(new URL("http://35.173.191.230:4444/wd/hub"),firefoxOptions));
                    }catch (MalformedURLException e){
                        e.printStackTrace();
                    }
                    break;
            }
        }
        return driverPool.get();
    }
    public static void closeDriver() {
        driverPool.get().quit();
        driverPool.remove();
    }
}