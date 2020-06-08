package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class AccountActivityNavigationDefs {

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        Driver.get().get(ConfigurationReader.get("url"));
        new LoginPage().login();
    }

    @When("the	user clicks	on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String columnName) {
        new AccountSummaryPage().clickAccountLink(columnName);
    }

    @Then("the	{string} page should be displayed")
    public void the_page_should_be_displayed(String expectedPageTitle) {
        String actualPageTitle = new AccountSummaryPage().getPageTitle();
        Assert.assertTrue("Verify the title "+actualPageTitle, actualPageTitle.contains(expectedPageTitle));
    }

    @Then("Account	drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String expectedSelectedOption) {
        String actualSelectedOption = new AccountActivityPage().getSelectedOption().getText();
        Assert.assertEquals("Verify the selected option",expectedSelectedOption,actualSelectedOption);
    }

}
