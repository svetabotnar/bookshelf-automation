package com.lohika.bookshelf.pages;

import com.lohika.bookshelf.constants.Status;
import com.lohika.bookshelf.utils.BrowserDriver;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


/**
 * Created by sbotnar on 2/16/17.
 */
public class LoginPage extends BasePage {
    private static final Logger LOGGER = Logger.getLogger(LoginPage.class.getName());

    private static final String URL = "http://localhost:8080";
//    private static final String URL = "http://bookshelf.lohika.com";
    private static final String MAIN_PAGE_PATH = "app/books";
    private By usernameLocator = By.cssSelector("#username");
    private By passwordLocator = By.cssSelector("#password");
    private By submitButtonLocator = By.xpath("//button[@type='submit']");
    private By logoutButtonLocator = By.cssSelector("div[class='signout']");
    private By errorContainerLocator = By.cssSelector("div[class='login-error']");


    public LoginPage() {
        super(URL);
    }

    public void open() {
        getDriver().navigate().to(getUrl());
    }

    public void login(String username, String password) {
        getDriver().findElement(usernameLocator).sendKeys(username);
        getDriver().findElement(passwordLocator).sendKeys(password);
        getDriver().findElement(submitButtonLocator).isEnabled();
        getDriver().findElement(submitButtonLocator).click();
    }

    public boolean isMainPageDisplayed() {
        return getDriver().getCurrentUrl().contains(MAIN_PAGE_PATH);
    }

    public void logout() throws Throwable {
        if (!getDriver().getCurrentUrl().contains("login")) {
            getDriver().findElement(logoutButtonLocator).click();
            getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }

    public boolean loggedInWithStatus(Status status) {
        if (isMainPageDisplayed()) {
            return status == Status.SUCCESSFUL;
        } else if (BrowserDriver.isElementPresent(errorContainerLocator)) {
            return status == Status.UNSUCCESSFUL;
        }
        return status == Status.UNSUCCESSFUL;
    }

}
