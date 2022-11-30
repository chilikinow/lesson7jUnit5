package com.qaguru.lesson5;

import com.qaguru.lesson5.testdata.TestData;
import com.qaguru.lesson5.pages.HomePage;
import org.junit.jupiter.api.Test;

public class XyzBankTest extends TestData {

    @Test
    void homePageTest() {

        endPoint = "/login";
        mainHeadingText = "XYZ Bank";
        homeButtonText = "Home";
        customerLoginButtonText = "Customer Login";
        bankManagerLoginButtonText = "Bank Manager Login";

        new HomePage(endPoint).openPage()
                        .checkMainHeadingHaveText(mainHeadingText)
                        .clickHomeButton(homeButtonText)
                        .checkCustomerLoginButton(customerLoginButtonText)
                        .clickHomeButton(homeButtonText)
                        .checkBankManagerLoginButton(bankManagerLoginButtonText)
                        .clickHomeButton(homeButtonText);
    }
}
