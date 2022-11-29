package com.qaguru.lesson5.testdata.pages;

import com.qaguru.lesson5.testdata.pages.components.Button;
import com.qaguru.lesson5.testdata.pages.components.MainHeading;
import com.qaguru.lesson5.testdata.pages.components.OptionSelector;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage{

    private String endPoint;
    private String mainHeadingText;
    private String homeButtonText;
    private String customerLoginButtonText;
    private String bankManagerLoginButtonText;

    private MainHeading mainHeading;
    private Button homeButton;
    private Button customerLoginButton;
    private Button bankManagerLoginButton;

    private OptionSelector optionSelector;
    private Button addCustomerButton;

            {
        endPoint = "/login";
        mainHeadingText = "XYZ Bank";
        homeButtonText = "Home";
        customerLoginButtonText = "Customer Login";
        bankManagerLoginButtonText = "Bank Manager Login";

        mainHeading = new MainHeading($(".mainHeading"));
        homeButton = new Button($("[ng-click = 'home()']"));
        customerLoginButton = new Button($("[ng-click = 'customer()']"));
        bankManagerLoginButton = new Button($("[ng-click = 'manager()']"));

        addCustomerButton = new Button($("[ng-click = 'addCust()']"));
        optionSelector = new OptionSelector($("#userSelect"));
    }

    public HomePage openPage(){
        open(this.endPoint);
        return this;
    }

    public HomePage checkMainHeadingHaveText(){
        this.mainHeading.shouldExist().shouldHaveText(mainHeadingText);
        return this;
    }

    public HomePage checkCustomerLoginButton(){
        this.customerLoginButton.shouldExist().shouldHaveText(customerLoginButtonText).click();
        optionSelector.shouldExist();
        return this;
    }

    public HomePage checkBankManagerLoginButton(){
        this.bankManagerLoginButton.shouldExist().shouldHaveText(bankManagerLoginButtonText).click();
        addCustomerButton.shouldExist();
        return this;
    }

    public HomePage clickHomeButton(){
        this.homeButton.shouldExist().shouldHaveText(homeButtonText).click();
        this.bankManagerLoginButton.shouldExist();
        return this;
    }

}
