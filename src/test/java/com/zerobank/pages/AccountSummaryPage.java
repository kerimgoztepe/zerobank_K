package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountSummaryPage extends BasePage{

    @FindBy(className = "board-header")
    public List<WebElement> accountTypes;

    @FindBy(xpath = "//h2[contains(text(),'Credit Accounts')]//following-sibling::div[1]//thead")
    public List<WebElement> creditAccountsColumns;



    public List<String> getColumnNames (String accountType){
        String xpath = "//h2[contains(text(),'" +accountType+ "')]//following-sibling::div[1]//th";
        return BrowserUtils.getElementsText(By.xpath(xpath));
    }

    public void clickAccountLink (String columnName){
        Driver.get().findElement(By.xpath("//a[text()='"+ columnName + "']")).click();
    }






}
