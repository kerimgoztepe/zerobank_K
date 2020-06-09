package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountActivityDefs {

    @When("the user clicks {string} tab")
    public void the_user_clicks_tab(String tabName) {
       new AccountActivityPage().navigateToTab(tabName);
    }

    @Then("the account dropdown default option should be {string}")
    public void the_account_dropdown_default_option_should_be(String defaultOption) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        Select select = accountActivityPage.getSelectObject(accountActivityPage.accountDropdown);

        String selectedOption = select.getFirstSelectedOption().getText();
        Assert.assertEquals("Verify the default option", defaultOption,selectedOption);

    }

    @Then("the account dropdown should have")
    public void the_account_dropdown_should_have(List<String> dropdownOptions) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        Select select = accountActivityPage.getSelectObject(accountActivityPage.accountDropdown);

        List<String> actualOptions = BrowserUtils.getElementsText(select.getOptions());

        Assert.assertEquals("Verify the options" , dropdownOptions,actualOptions);
    }

    @Then("the transaction table column names should be")
    public void the_transaction_table_column_names_should_be(List<String> expectedColumnNames) {
        List<String> actualColumnNames = BrowserUtils.getElementsText(new AccountActivityPage().showTransactionsTableColumns);
        Assert.assertEquals("Verify the column names", expectedColumnNames,actualColumnNames);
    }

    @Given("the user accesses the {string} sub tab")
    public void the_user_accesses_the_sub_tab(String subTabName) {
        new AccountActivityPage().navigateToSubTab(subTabName);
    }

    @When("the user enters date range from {string} to {string} and clicks search")
    public void the_user_enters_date_range_from_to_and_clicks_search(String fromDate, String toDate) {

        new AccountActivityPage().sendDates(fromDate,toDate);
    }

    @Then("the results should be displayed between {string} to {string}")
    public void the_results_should_be_displayed_between_to(String fromDate, String toDate) {

        List<String> actualDates = new AccountActivityPage().getTableDates();

        for (String actualDate : actualDates) {
            Integer actualYear = Integer.valueOf(actualDate.substring(0, 4));
            Integer expectedFromYear = Integer.valueOf(fromDate.substring(0, 4));
            Integer expectedToYear = Integer.valueOf(toDate.substring(0, 4));
            Assert.assertTrue("Verify the year", actualYear>=expectedFromYear &&actualYear<=expectedToYear);

            Integer actualMonth = Integer.valueOf(actualDate.substring(5, 7));
            Integer expectedFromMonth = Integer.valueOf(fromDate.substring(5, 7));
            Integer expectedToMonth = Integer.valueOf(toDate.substring(5, 7));
            Assert.assertTrue("Verify the month", actualMonth>=expectedFromMonth &&actualMonth<=expectedToMonth);

            Integer actualDay = Integer.valueOf(actualDate.substring(8));
            Integer expectedFromDay = Integer.valueOf(fromDate.substring(8));
            Integer expectedToDay = Integer.valueOf(toDate.substring(8));
            Assert.assertTrue("Verify the day", actualDay>=expectedFromDay &&actualDay<=expectedToDay);

        }

    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {

        List<String> actualDates = new AccountActivityPage().getTableDates();
        List<Integer> dates = new ArrayList<>();
        for (String actualDate : actualDates) {
            dates.add(Integer.valueOf(actualDate.replace("-","")));
        }

        for (int i = 0; i < dates.size()-1; i++) {
             Assert.assertTrue("Verify the most recent is at top",dates.get(i)>dates.get(i+1));
        }
    }

    @Then("the results should not contain the date {string}")
    public void the_results_should_not_contain_the_date(String date) {

        List<String> actualDates = new AccountActivityPage().getTableDates();

        Assert.assertTrue("Verify that date is not in the list ", !actualDates.contains(date));

    }

    @When("the user enters description {string} and clicks search")
    public void the_user_enters_description_and_clicks_search(String descriptionText) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        BrowserUtils.waitForClickablility(accountActivityPage.descriptionBox,2);
        accountActivityPage.descriptionBox.sendKeys(Keys.CONTROL+"a"+Keys.DELETE);
        accountActivityPage.descriptionBox.sendKeys(descriptionText);
        accountActivityPage.searchBtn.click();

    }

    @Then("the results should contain {string}")
    public void the_results_should_contain(String descriptionText) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        List<String> tableDescriptions = accountActivityPage.getTableDescriptions();
        for (String tableDescription : tableDescriptions) {
            Assert.assertTrue("Verify the description text", tableDescription.contains(descriptionText));
        }
    }

    @Then("the results should not contain {string}")
    public void the_results_should_not_contain(String descriptionText) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        List<String> tableDescriptions = accountActivityPage.getTableDescriptions();
        for (String tableDescription : tableDescriptions) {
            Assert.assertTrue("Verify the description text", !tableDescription.contains(descriptionText));
        }
    }

    @When("the user clicks search")
    public void the_user_clicks_search() {
        BrowserUtils.waitForClickablility(new AccountActivityPage().searchBtn,3);
        new AccountActivityPage().searchBtn.click();
        BrowserUtils.waitFor(3);
    }

    @Then("the results should contain a result under Deposit")
    public void the_results_should_contain_a_result_under_Deposit() {
        List<String> tableDeposits = new AccountActivityPage().getTableDeposits();
        Assert.assertTrue("Verify that there is deposit data", tableDeposits.size()!=0);
    }

    @Then("the results should contain a result under Withdrawal")
    public void the_results_should_contain_a_result_under_Withdrawal() {
        List<String> tableWithdrawal = new AccountActivityPage().getTableWithdrawal();
        Assert.assertTrue("Verify that there is deposit data", tableWithdrawal.size()!=0);
    }

    @When("the user selects type {string}")
    public void the_user_selects_type(String typeOption) {
        Select select = new Select(new AccountActivityPage().typeDropdown);
        select.selectByVisibleText(typeOption);
    }









}
