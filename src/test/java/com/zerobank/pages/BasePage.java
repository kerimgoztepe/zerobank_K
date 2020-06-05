package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class  BasePage {

    public BasePage (){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy (linkText = "Zero Bank")
    public WebElement homeBtn;

    @FindBy (id = "searchTerm")
    public WebElement searchInputBox;

    @FindBy (xpath = "(//*[@class='dropdown-toggle'])[1]")
    public WebElement settingsBtn;

    @FindBy (xpath = "(//*[@class='dropdown-toggle'])[2]")
    public WebElement usernameBtn;

    @FindBy (css = ".nav-tabs>li")
    public List<WebElement> navigationTabs;


    public String getUsername (){
        return  usernameBtn.getText();
    }

    public void navigateToTab(String tabName){
        for (WebElement tab : navigationTabs) {
            if(tab.getText().equals(tabName)){
                tab.click();
                break;
            }
        }
    }



}