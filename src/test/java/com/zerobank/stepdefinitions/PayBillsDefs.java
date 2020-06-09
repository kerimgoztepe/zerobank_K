package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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

    @When("the user enters {string} and {string}")
    public void the_user_enters_and(String amount, String date) {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.ammountInputBox.sendKeys(amount);
        payBillsPage.dateInputBox.sendKeys(date);
        payBillsPage.payBtn.click();
    }

    @Then("the system should display message {string}")
    public void the_system_should_display_message(String expectedMessage) {

        String actualMessage = Driver.get().switchTo().activeElement().getAttribute("validationMessage");
        Assert.assertEquals("Verify the message",expectedMessage,actualMessage);
    }

    @When("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String> values) {

        PayBillsPage payBillsPage = new PayBillsPage();
        BrowserUtils.waitForClickablility(payBillsPage.payeeName,3);

        payBillsPage.payeeName.sendKeys(values.get("Payee Name"));
        payBillsPage.payeeAddress.sendKeys(values.get("Payee Address"));
        payBillsPage.payeeAccount.sendKeys(values.get("Account"));
        payBillsPage.payeeDetails.sendKeys(values.get("Payee details"));
        payBillsPage.addBtn.click();
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> expectedCurrencyList) {

        Select select = new Select(new PayBillsPage().currencyDropdown);
        List<WebElement> selectOptions = select.getOptions();
        List<String> actualCurrencyList = BrowserUtils.getElementsText(selectOptions);

        Assert.assertTrue("Verify the dropdown options"+actualCurrencyList,actualCurrencyList.containsAll(expectedCurrencyList));

    }

    @When("the user tries to calculate cost without selecting a currency")
    public void the_user_tries_to_calculate_cost_without_selecting_a_currency() {
        new PayBillsPage().purchaseBtn.click();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Alert alert = Driver.get().switchTo().alert();
        String text = alert.getText();
        Assert.assertTrue("Verify that there is a alert message"+text,text.length()>0);
    }

    @When("the user tries to calculate cost without entering value")
    public void the_user_tries_to_calculate_cost_without_entering_value() {
        PayBillsPage payBillsPage= new PayBillsPage();
        Select select = new Select(new PayBillsPage().currencyDropdown);
        select.selectByIndex(2);
        payBillsPage.purchaseBtn.click();
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
