package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class AccountSummaryDefs {

    @Then("the system should display following account types")
    public void the_system_should_display_following_account_types(List<String> accountTypes) {
        List<String> actualAccountTypes = BrowserUtils.getElementsText(new AccountSummaryPage().accountTypes);
        System.out.println("actualAccountTypes = " + actualAccountTypes);
        Assert.assertEquals("Verify the account types", accountTypes,actualAccountTypes);
    }

    @Then("the system credit account table must have")
    public void the_system_credit_account_table_must_have(List<String> columnNames) {

        List<String> actualColumnList = BrowserUtils.getElementsText(new AccountSummaryPage().creditAccountsColumns);
        Assert.assertEquals("Verify the column names", columnNames,actualColumnList);

    }



}
