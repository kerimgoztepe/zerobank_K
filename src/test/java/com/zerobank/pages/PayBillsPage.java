package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PayBillsPage extends BasePage{

    @FindBy (id = "sp_payee")
    public WebElement payeeDropdown;
    @FindBy (id = "sp_account")
    public WebElement accountDropdown;
    @FindBy (id = "sp_amount")
    public WebElement ammountInputBox;
    @FindBy (id = "sp_date")
    public WebElement dateInputBox;
    @FindBy (id = "sp_description")
    public WebElement descriptionInputBox;
    @FindBy (id = "pay_saved_payees")
    public WebElement payBtn;
    @FindBy(id = "alert_content")
    public WebElement alertContent;
    @FindBy(id = "np_new_payee_name")
    public WebElement payeeName;
    @FindBy(id = "np_new_payee_address")
    public WebElement payeeAddress;
    @FindBy(id = "np_new_payee_account")
    public WebElement payeeAccount;
    @FindBy(id = "np_new_payee_details")
    public WebElement payeeDetails;
    @FindBy(id = "add_new_payee")
    public WebElement addBtn;
    @FindBy(id = "pc_currency")
    public WebElement currencyDropdown;
    @FindBy(id = "purchase_cash")
    public WebElement purchaseBtn;



    //this part is used inside selectDate method
    @FindBy (className = "ui-datepicker-title")
    public WebElement datePickerTitle;
    @FindBy(linkText = "Prev")
    public WebElement previousBtn;
    @FindBy(linkText = "Next")
    public WebElement nextBtn;
    @FindBy (xpath = "//table//td")
    public List<WebElement> days;




    public void selectDate(String day, String month, String year){

        dateInputBox.click();

        String desiredMonthAndYear = month+" "+year;
        String dateYearAndMonth = datePickerTitle.getText();
        int i = 0;
        int year2;

        while (!desiredMonthAndYear.equals(dateYearAndMonth)){
            if(Integer.valueOf(year)<2020){
                previousBtn.click();
                dateYearAndMonth = datePickerTitle.getText();
            }else if (Integer.valueOf(year)>2020){
                nextBtn.click();
                dateYearAndMonth = datePickerTitle.getText();
            }else{
                while(!dateYearAndMonth.contains(month) && i<11){
                    nextBtn.click();
                    dateYearAndMonth = datePickerTitle.getText();
                    year2=Integer.valueOf(datePickerTitle.getText().split(" ")[1]);
                    if(year2==2021) {
                        previousBtn.click();
                        dateYearAndMonth = datePickerTitle.getText();
                        i=0;
                        break;
                    }
                    i++;
                }
                while(!dateYearAndMonth.contains(month) && i<11){
                    previousBtn.click();
                    dateYearAndMonth = datePickerTitle.getText();
                    i++;
                }
            }
        }

        for (WebElement element : days) {
            if(element.getText().equals(day)){
                element.click();
                break;
            }
        }

        payBtn.click();
    }




}
