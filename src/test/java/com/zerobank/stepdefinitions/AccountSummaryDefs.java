package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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


/*
    @Then("the system should display following account types {string}")
    public void the_system_should_display_following_account_types(String accountType, DataTable dataTable) {
        List<Map<String, String>> maps = dataTable.asMaps(String.class, String.class);

        Set<String> expectedSet = maps.get(0).keySet();
        List<String>  expectedList = new ArrayList<>();
        for (String s : expectedSet) {
            expectedList.add(s);
        }


        //2nd step
        List<String> actualAccountTypes = BrowserUtils.getElementsText(new AccountSummaryPage().accountTypes);
        Assert.assertEquals(expectedList,actualAccountTypes);

        //3rd step

        List<String> expectedColumnNames = new ArrayList<>();
        for (int i = 0; i < maps.size(); i++) {

            expectedColumnNames.add(maps.get(i).get("Credit Accounts"));
        }

        List<String> actualColumnNames = new AccountSummaryPage().getColumnNames(accountType);

        Assert.assertEquals(expectedColumnNames,actualColumnNames);
    }

 */





}
