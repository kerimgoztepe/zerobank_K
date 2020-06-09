package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class AccountActivityPage extends BasePage {

    @FindBy (id = "aa_accountId")
    public WebElement accountDropdown;

    @FindBy (xpath = "//th")
    public List<WebElement> showTransactionsTableColumns;

    @FindBy (id = "filtered_transactions_for_account")
    public WebElement findTransactionsTable;

    @FindBy (id = "aa_fromDate")
    public WebElement fromDateBox;

    @FindBy (id = "aa_toDate")
    public WebElement toDateBox;

    @FindBy (tagName = "button")
    public WebElement searchBtn;

    @FindBy (id = "aa_description")
    public WebElement descriptionBox;

    @FindBy (id = "aa_type")
    public WebElement typeDropdown;



    public WebElement getSelectedOption(){

        return new Select(accountDropdown).getFirstSelectedOption();
    }


    public void sendDates(String fromDate, String toDate){

        BrowserUtils.waitForClickablility(fromDateBox,2);
        fromDateBox.sendKeys(Keys.CONTROL+"a"+Keys.DELETE);
        toDateBox.sendKeys(Keys.CONTROL+"a"+Keys.DELETE);
        fromDateBox.sendKeys(fromDate);
        toDateBox.sendKeys(toDate);
        searchBtn.click();
    }

    public List<String> getTableDates(){

        BrowserUtils.waitForVisibility(findTransactionsTable,5);
        List<WebElement> rows = Driver.get().findElements(By.xpath("//*[@id='filtered_transactions_for_account']//tbody/tr"));
        List<String> rowsText = BrowserUtils.getElementsText(rows);
        List<String> dates = new ArrayList<>();

        for (String row : rowsText) {
            dates.add(row.split(" ")[0]);
        }

        return dates;
    }

    public List<String> getTableDescriptions(){

        BrowserUtils.waitForVisibility(findTransactionsTable,5);
        List<WebElement> rows = Driver.get().findElements(By.xpath("//*[@id='filtered_transactions_for_account']//tbody/tr"));
        List<String> rowsText = BrowserUtils.getElementsText(rows);
        List<String> descriptions = new ArrayList<>();

        for (String row : rowsText) {
            descriptions.add(row.split(" ")[1]);
        }

        return descriptions;
    }

    public List<String> getTableDeposits(){

        BrowserUtils.waitForVisibility(findTransactionsTable,5);
        List<WebElement> rows = Driver.get().findElements(By.xpath("//*[@id='filtered_transactions_for_account']//tbody/tr"));
        List<String> rowsText = BrowserUtils.getElementsText(rows);
        List<String> deposits = new ArrayList<>();

        for (String row : rowsText) {
            deposits.add(row.split(" ")[2]);
        }

        return deposits;
    }

    public List<String> getTableWithdrawal(){

        BrowserUtils.waitForVisibility(findTransactionsTable,5);
        List<WebElement> rows = Driver.get().findElements(By.xpath("//*[@id='filtered_transactions_for_account']//tbody/tr"));
        List<String> rowsText = BrowserUtils.getElementsText(rows);
        List<String> withdrawal = new ArrayList<>();

        for (String row : rowsText) {
            withdrawal.add(row.split(" ")[3]);
        }

        return withdrawal;
    }














}
