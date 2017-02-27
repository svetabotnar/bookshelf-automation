package com.lohika.bookshelf.pages;

import com.lohika.bookshelf.utils.BrowserDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.InputEvent;

/**
 * Created by sbotnar on 2/16/17.
 */
public class BasePage {

    private String url;

    public BasePage(String url) {
        this.url = url;
    }

    public WebDriver getDriver() {
        return BrowserDriver.getCurrentDriver();
    }

    public String getUrl() {
        return url;
    }

    public void clickOutsideElement(By locator) {
        try {
            WebElement element = getDriver().findElement(locator);
//            JavascriptExecutor js=(JavascriptExecutor)getDriver();
////            js.executeScript("window.scrollTo("+(10)+", " +(100) + ").click();");
//            js.executeScript("arguments[0].click();",element);
//            Actions builder = new Actions(getDriver());
//            builder.moveToElement
//                    clickMouse(element.getLocation().getX()-150, element.getLocation().getY());
            clickMouse(100,100);
        } catch (NoSuchElementException e) {
            System.out.println("Cannot find element to click outside");
        } catch (AWTException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public static void clickMouse(int x, int y) throws AWTException, InterruptedException {
        Robot bot = new Robot();
        bot.mouseMove(x, y);
        bot.mousePress(InputEvent.BUTTON1_MASK);
        Thread.sleep(2000);
        bot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

}
