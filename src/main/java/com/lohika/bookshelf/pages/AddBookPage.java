package com.lohika.bookshelf.pages;


import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

/**
 * Created by sbotnar on 2/17/17.
 */
public class AddBookPage extends BasePage {


    private static final String URL = "http://localhost:8080";
    private static final String ADD_BOOK_PAGE_MAIN_PATH = "/app/books/add";
    private By addBookContentLocator = By.cssSelector("div[class='book-content']");
    private By isbnInputLocator = By.cssSelector("input[name='isbn']");
    private By titleInputLocator = By.cssSelector("input[name='title']");
    private By searchIsbnButtonLocator = By.cssSelector("span[class='search-isbn-button']");
    private By addButtonLocator = By.xpath("//button[@type='submit']");
    private By messageLocator = By.cssSelector("div[class='message']");
    private By closeButtonLocator = By.cssSelector("div[class='dialog_content '] button");
    private By authorsLabelLocator = By.cssSelector("label[for='authors']");
    private By pagesInputLocator = By.cssSelector("label[for='pages']");
    private By categoriesLabelLocator = By.cssSelector("label[for='categories']");
    private By publisherLabelLocator = By.cssSelector("input[placeholder='publisher']");
    private By dropDownItemLocator = By.cssSelector("li[class='rc-select-dropdown-menu-item']");




    public AddBookPage() {
        super(URL + ADD_BOOK_PAGE_MAIN_PATH);
    }

    public void open() {
        getDriver().navigate().to(getUrl());
    }


    public boolean isAddBookFormPageDisplayed() {
        return getDriver().getCurrentUrl().contains(ADD_BOOK_PAGE_MAIN_PATH);
    }

    public void searchBook(String isbn_number) {
        getDriver().findElement(isbnInputLocator).click();
        getDriver().findElement(isbnInputLocator).sendKeys(isbn_number);
        getDriver().findElement(searchIsbnButtonLocator).click();
    }

    public void clickBookContentButton() {
        getDriver().findElement(addBookContentLocator).click();
    }

    public boolean addBookButtonIsInState(String state) {
        if (state.equals("disabled")) {
            return getDriver().findElement(addButtonLocator).getAttribute("disabled") != null;
        } else {
            return getDriver().findElement(addButtonLocator).getAttribute("disabled") == null;
        }
    }

    public void clickAddBookButton() {
        getDriver().findElement(addButtonLocator).click();

    }

    public boolean bookAddedMessageIsDisplayedWithText(String messageText) {
        return getDriver().findElement(messageLocator).getText().equals(messageText);
    }

    public void closeMessageWindow() {
        getDriver().findElement(closeButtonLocator).click();
    }

    public void enterTitle(String title) {
        getDriver().findElement(titleInputLocator).click();
        getDriver().findElement(titleInputLocator).sendKeys(title);
    }


    public void enterNumberOfPages(String number) {
        getDriver().findElement(pagesInputLocator).click();
        getDriver().findElement(pagesInputLocator).sendKeys(number);
    }

    public void enterCategories(String categoryName) {
        WebElement categoriesLabel = getDriver().findElement(categoriesLabelLocator);
        WebElement categoryInput = categoriesLabel.findElement(By.xpath("./..")).findElement(By.tagName("input"));
        categoryInput.click();
        List<WebElement> nameCategories = getDriver().findElements(dropDownItemLocator);
        for (WebElement el : nameCategories) {
            if (categoryName.equalsIgnoreCase(el.getAttribute("title"))) {
                el.click();
                getDriver().findElement(publisherLabelLocator).click();
                categoryInput.click();
                categoryInput.sendKeys(Keys.TAB);
                clickOutsideElement(dropDownItemLocator);
                return;
            }
        }


    }

    public void selectAuthors(String autorName){
        WebElement authorsLabel = getDriver().findElement(authorsLabelLocator);
        WebElement authorInput = authorsLabel.findElement(By.xpath("./..")).findElement(By.tagName("input"));
        authorInput.click();
        List<WebElement> nameAuthors = getDriver().findElements(dropDownItemLocator);
        for (WebElement el : nameAuthors) {
            if (autorName.equalsIgnoreCase(el.getAttribute("title"))) {
                el.click();
                getDriver().findElement(publisherLabelLocator).click();
                authorInput.click();
                authorInput.sendKeys(Keys.TAB);
                clickOutsideElement(dropDownItemLocator);
                return;
            }
        }

    }
//    WebElement wannabeSelect = sDriver.findElement(By.id("foo"));
//    Select foo = new Select(wannabeSelect);
//// Denotes option value - technical name
//    select.selectByValue(fieldValue);
//// Denotes option text that is actually visible to be selected
//    select.selectByVisibleText(fieldValue);

}




