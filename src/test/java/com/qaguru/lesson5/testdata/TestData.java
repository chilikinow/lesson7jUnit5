package com.qaguru.lesson5.testdata;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestData {

    protected String endPoint;
    protected String mainHeadingText;
    protected String homeButtonText;
    protected String customerLoginButtonText;
    protected String bankManagerLoginButtonText;

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#";
        Configuration.browserSize = "1920x1080";
//        Configuration.holdBrowserOpen = true;
    }

}
