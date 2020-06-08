package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends HomePage{

    @FindBy (id = "user_login")
    public WebElement usernameInput;

    @FindBy (id ="user_password")
    public WebElement passwordInput;

    @FindBy (id ="user_remember_me")
    public WebElement rememberMe;

    @FindBy (name ="submit")
    public WebElement submitBtn;

    @FindBy (css = ".alert.alert-error")
    public WebElement errorMessage;

    public void login(){
        signinBtn.click();
        usernameInput.sendKeys(ConfigurationReader.get("username"));
        passwordInput.sendKeys(ConfigurationReader.get("password"));
        rememberMe.click();
        submitBtn.click();
    }

    public void loginInvalid(String username, String password){

        signinBtn.click();
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        rememberMe.click();
        submitBtn.click();
    }




}
