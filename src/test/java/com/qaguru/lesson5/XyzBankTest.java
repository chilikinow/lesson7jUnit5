package com.qaguru.lesson5;

import com.qaguru.lesson5.testdata.TestData;
import com.qaguru.lesson5.testdata.pages.HomePage;
import org.junit.jupiter.api.Test;

public class XyzBankTest extends TestData {

    @Test
    void homePageTest() {

        new HomePage().openPage()
                        .checkMainHeadingHaveText()
                        .clickHomeButton()
                        .checkCustomerLoginButton()
                        .clickHomeButton()
                        .checkBankManagerLoginButton()
                        .clickHomeButton();
    }
}
