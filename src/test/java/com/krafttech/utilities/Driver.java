package com.krafttech.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    private Driver() {
    }

    private static WebDriver driver;

    public static WebDriver get() {
        if (driver == null) {
            String browser = ConfigurationReader.get("browser");

            switch (browser.toLowerCase()) {
                case "chrome":
                   // System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
