package com.lohika.bookshelf.utils;

import com.lohika.bookshelf.constants.Browsers;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.safari.SafariDriver;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

import java.awt.Toolkit;
import org.openqa.selenium.WebDriver;

public class BrowserFactory {

    private static final String BROWSER_PROP_KEY = "browser";

    /**
     * creates the browser driver specified in the system property "browser"
     * if no property is set then a firefox browser driver is created.
     * The allow properties are firefox, safari and chrome
     * e.g to run with safari, pass in the option -Dbrowser=safari at runtime
     * @return WebDriver
     */
    public static WebDriver getBrowser() {
        Browsers browser;
        WebDriver driver;

        if(System.getProperty(BROWSER_PROP_KEY)==null){
            browser = Browsers.FIREFOX;
        }else{
            browser = Browsers.browserForName(System.getProperty(BROWSER_PROP_KEY));
        }
        switch(browser){
            case CHROME:
                driver = new ChromeDriver();
                break;
            case SAFARI:
                driver = new SafariDriver();
                break;
            case FIREFOX:
            default:
                driver = new FirefoxDriver();
                break;
        }
        addAllBrowserSetup(driver);
        return driver;
    }

    private static void addAllBrowserSetup(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().setPosition(new Point(0, 0));
        java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        org.openqa.selenium.Dimension dim = new org.openqa.selenium.Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());
        driver.manage().window().setSize(dim);
    }

}
