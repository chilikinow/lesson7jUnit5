package com.qaguru.lesson5;

import com.qaguru.lesson5.testdata.TestData;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import static com.codeborne.selenide.Selenide.open;

public class BankManagerTest extends TestData {

    @Disabled
    @ParameterizedTest
    void addCustomerTest(String firstName, String lastName, int postCode) {
        open("/manager");

    }
}
