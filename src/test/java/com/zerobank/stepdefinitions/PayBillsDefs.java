package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Alert;

import java.util.List;
import java.util.Map;

public class PayBillsDefs {

    @When("the user fills the necessary places and clicks pay")
    public void the_user_fills_the_necessary_places_and_clicks_pay() {
        PayBillsPage payBillsPage = new PayBillsPage();

        payBillsPage.getSelectObject(payBillsPage.payeeDropdown).selectByIndex(2);
        payBillsPage.getSelectObject(payBillsPage.accountDropdown).selectByVisibleText("Loan");
        payBillsPage.ammountInputBox.sendKeys("1000");
        payBillsPage.descriptionInputBox.sendKeys("Car payment");
        payBillsPage.dateInputBox.sendKeys("2020-09-10");
        //payBillsPage.selectDate("10" ,"July","2020");
        payBillsPage.payBtn.click();
    }

    @Then("the system should display {string}")
    public void the_system_should_display(String expectedMessage) {

        String actualMessage = new PayBillsPage().alertContent.getText();
        Assert.assertEquals("Verify the alert message", expectedMessage,actualMessage);

    }

    @When("the user leaves empty the amount box")
    public void the_user_leaves_empty_the_amount_box() {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.dateInputBox.sendKeys("2020-09-10");
        payBillsPage.payBtn.click();
    }

    @When("the user leaves empty the date box")
    public void the_user_leaves_empty_the_date_box() {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.ammountInputBox.sendKeys("2020");
        payBillsPage.payBtn.click();
    }

    @Then("the system should display message {string}")
    public void the_system_should_display_message(String expectedMessage) {

        String actualMessage = Driver.get().switchTo().activeElement().getAttribute("validationMessage");
        Assert.assertEquals("Verify the message",expectedMessage,actualMessage);
    }

    @When("the user enters alphabetical characters to amountbox")
    public void the_user_enters_alphabetical_characters_to_amountbox() {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.ammountInputBox.sendKeys("Somewords");
        payBillsPage.dateInputBox.sendKeys("2020-09-10");
        payBillsPage.payBtn.click();
    }

    @When("the user enters special characters to amountbox")
    public void the_user_enters_special_characters_to_amountbox() {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.ammountInputBox.sendKeys("##$$%%!!?¡");
        payBillsPage.dateInputBox.sendKeys("2020-09-10");
        payBillsPage.payBtn.click();
    }

    @When("the user enters alphabetical characters to date box")
    public void the_user_enters_alphabetical_characters_to_date_box() {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.ammountInputBox.sendKeys("20500");
        payBillsPage.dateInputBox.sendKeys("somewords");
        payBillsPage.payBtn.click();
    }




    // lo que hicimos con Semih
    /*@When("the user enters the amount box following values")
    public void the_user_enters_the_amount_box_following_values(DataTable dataTable) {
        List<Map<String, String>> maps = dataTable.asMaps(String.class, String.class);
        PayBillsPage payBillsPage = new PayBillsPage();
        for (int i=0; i<maps.size();i++){
            String amountValue = maps.get(i).get("amount");
            payBillsPage.ammountInputBox.sendKeys(amountValue);
            String dateValue = maps.get(i).get("date");
            payBillsPage.dateInputBox.sendKeys(dateValue);
            payBillsPage.payBtn.click();
            String actualMessage = Driver.get().switchTo().activeElement().getAttribute("validationMessage");
           // Assert.assertEquals("Verify the message","Please fill out this field.",actualMessage);

            payBillsPage.navigateToTab("Pays Bills");
            BrowserUtils.waitFor(2);

        }
    }

     */

}
