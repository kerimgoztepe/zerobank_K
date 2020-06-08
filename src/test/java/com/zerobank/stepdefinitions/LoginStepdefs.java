package com.zerobank.stepdefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class LoginStepdefs {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("the user logs in with valid credentials")
    public void the_user_logs_in_with_valid_credentials() {
        new LoginPage().login();
    }

    @Then("The page title should be {string}")
    public void The_page_title_should_be(String expectedTitle) {
        String actualTitle = Driver.get().getTitle();
        System.out.println("actualTitle = " + actualTitle);
        Assert.assertEquals("Verify the title", actualTitle, expectedTitle);
    }

    /*@When("the user logs in with blank username or password")
    public void the_user_logs_in_with_blank_username_or_password() {
        new LoginPage().loginInvalid(" ", " ");
    }

    @When("the user logs in with {string} {string}")
    public void the_user_logs_in_with(String username, String password) {
        new LoginPage().loginInvalid(username,password);
    }

     */

    @When("the user logs in with invalid {string} or {string}")
    public void the_user_logs_in_with_invalid_or(String username, String password) {
        new LoginPage().loginInvalid(username,password);
    }


    @Then("the system should display error message {string}")
    public void the_system_should_display_error_message(String expectedMessage) {
        String actualMessage = new LoginPage().errorMessage.getText();
        System.out.println("actualMessage = " + actualMessage);
        Assert.assertEquals(expectedMessage, actualMessage);

    }






}
