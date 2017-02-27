package com.lohika.bookshelf.steps;

import com.lohika.bookshelf.pages.AddBookPage;
import com.lohika.bookshelf.pages.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

/**
 * Created by sbotnar on 2/17/17.
 */
public class AddBookSteps {
    private AddBookPage page = new AddBookPage();
    private LoginPage loginPage = new LoginPage();

    @Given("^I navigate to main page$")
    public void iNavigateToMainPage() throws Throwable {
        page.open();
    }

    @When("^I click on BookContent button$")
    public void iClickOnBookContentButton() throws Throwable {
        page.clickBookContentButton();
    }


    @Then("Add Book form page is displayed$")
    public void isDisplayed() throws Throwable {
        page.isAddBookFormPageDisplayed();
    }


    @When("^I search book with \"([^\"]*)\" number$")
    public void iSearchBookWithNumber(String isbn_number) throws Throwable {
       page.searchBook(isbn_number);
    }

    @And("^Add Book button is \"([^\"]*)\"$")
    public void addBookButtonIs(String state) throws Throwable {
        Assert.assertTrue(page.addBookButtonIsInState(state));
    }

    @When("^I click on Add Book button$")
    public void iClickOnAddBookButton() throws Throwable {
        page.clickAddBookButton();
    }

    @Then("^Message \"([^\"]*)\" is displayed$")
    public void messageIsDisplayed(String messageText) throws Throwable {
        page.bookAddedMessageIsDisplayedWithText(messageText);
    }

    @Before
    public void testStart() throws Throwable {
        loginPage.open();
        loginPage.login("sbotnar@lohika.com", "place your password here");
    }

    @After
    public void testEnd() throws Throwable {
        loginPage.logout();
    }

    @And("^I close message window$")
    public void iCloseMessageWindow() throws Throwable {
       page.closeMessageWindow();
    }

    @When("^I enter Title \"([^\"]*)\"$")
    public void iEnterTitle(String title) throws Throwable {
        page.enterTitle(title);
    }

    @When("^I enter \"([^\"]*)\" number of pages$")
    public void iEnterNumberOfPages(String number) throws Throwable {
      page.enterNumberOfPages(number);
    }

    @When("^I select \"([^\"]*)\" Category$")
    public void iSelectCategory(String categoryName) throws Throwable {
        page.enterCategories(categoryName);
    }

    @When("^I select \"([^\"]*)\" Authors$")
    public void iSelectAuthors(String authorName) throws Throwable {
        page.selectAuthors(authorName);
    }
}
