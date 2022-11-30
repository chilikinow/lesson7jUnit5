package com.qaguru.lesson5.pages;

import com.qaguru.lesson5.pages.components.Button;
import com.qaguru.lesson5.pages.components.MainHeading;
import com.qaguru.lesson5.pages.components.OptionSelector;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage{

    private String endPoint;

    private MainHeading mainHeading;
    private Button homeButton;
    private Button customerLoginButton;
    private Button bankManagerLoginButton;

    private OptionSelector optionSelector;
    private Button addCustomerButton;

    {
        mainHeading = new MainHeading($(".mainHeading"));
        homeButton = new Button($("[ng-click = 'home()']"));
        customerLoginButton = new Button($("[ng-click = 'customer()']"));
        bankManagerLoginButton = new Button($("[ng-click = 'manager()']"));

        addCustomerButton = new Button($("[ng-click = 'addCust()']"));
        optionSelector = new OptionSelector($("#userSelect"));
    }

    public HomePage(String endpoint){
        this.endPoint = endpoint;
    }

    public HomePage openPage(){
        open(this.endPoint);
        return this;
    }

    public HomePage checkMainHeadingHaveText(String text){
        this.mainHeading.shouldExist().shouldHaveText(text);
        return this;
    }

    public HomePage checkCustomerLoginButton(String text){
        this.customerLoginButton.shouldExist().shouldHaveText(text).click();
        optionSelector.shouldExist();
        return this;
    }

    public HomePage checkBankManagerLoginButton(String text){
        this.bankManagerLoginButton.shouldExist().shouldHaveText(text).click();
        addCustomerButton.shouldExist();
        return this;
    }

    public HomePage clickHomeButton(String text){
        this.homeButton.shouldExist().shouldHaveText(text).click();
        this.bankManagerLoginButton.shouldExist();
        return this;
    }

}
