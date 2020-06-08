package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityPage extends  BasePage {

    @FindBy (id = "aa_accountId")
    public WebElement accountDropdown;

    @FindBy (xpath = "//th")
    public List<WebElement> transactionsTableColumns;



    public WebElement getSelectedOption(){
        return new Select(accountDropdown).getFirstSelectedOption();
    }








}
