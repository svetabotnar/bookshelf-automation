package com.lohika.bookshelf.steps;

import com.lohika.bookshelf.constants.Status;
import com.lohika.bookshelf.pages.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.util.logging.Logger;

/**
 * Created by sbotnar on 2/16/17.
 */
public class LoginSteps {

    private LoginPage page = new LoginPage();

    @Given("^I navigate to login page$")
    public void iNavigateToLoginPage() throws Throwable {
        page.open();
    }

    @When("^I login with username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void iLoginWithUsernameAndPassword(String username, String password) throws Throwable {
        page.login(username, password);
    }

    @And("^I do logout$")
    public void iDoLogout() throws Throwable {
        page.logout();
    }

    @Then("^I should see that I logged in with status \"([^\"]*)\"$")
    public void iShouldSeeThatILoggedIn(String status) throws Throwable {
        Assert.assertTrue(page.loggedInWithStatus(Status.valueOf(status.toUpperCase())));
    }

}
