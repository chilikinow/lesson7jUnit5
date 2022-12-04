package com.qaguru.lesson5;

import com.codeborne.selenide.Condition;
import com.qaguru.lesson5.pages.components.Button;
import com.qaguru.lesson5.testdata.TestData;
import com.qaguru.lesson5.pages.HomePage;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@Slf4j
public class XyzBankTest extends TestData {

    @DisplayName("check buttons on home page")
    @Tags({@Tag("origin"), @Tag("Home")})
    @Test
    void checkButtonsHomePageTest() {

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

    @ValueSource(strings = {
            "Hermoine Granger"
            ,"Harry Potter"
            ,"Ron Weasly"
            ,"Albus Dumbledore"
            ,"Neville Longbottom"
    })
    @Tag("origin")
    @ParameterizedTest(name = "check {0} login on customer page")
    void checkLoginOnCustomerPageTest(String arg) {
        open("/customer");
        $("#userSelect").selectOption(arg);
        new Button($(byText("Login"))).click();
        $(".fontBig").shouldHave(Condition.text(arg));
    }

    @Tag("origin")
    @CsvSource(value = {
            "Hermoine Granger|1001|5096|Dollar"
            ,"Harry Potter|1006|0|Rupee"
            ,"Ron Weasly|1008|0|Pound"
            }
            , delimiter = '|'
    )
    @ParameterizedTest(name = "check default attributes on personal account {0}")
    void checkDefaultAttributesOnPersonalAccountTest(String customerName, int accountNumber, int balance, String currency) {
        open("/customer");
        $("#userSelect").selectOption(customerName);
        new Button($(byText("Login"))).click();
        $("#accountSelect").selectOption(String.valueOf(accountNumber));
        $x("//strong[@class='ng-binding'][contains(text(),'" + accountNumber + "')]").shouldBe(Condition.exist);
        $x("//strong[@class='ng-binding'][contains(text(),'" + balance + "')]").shouldBe(Condition.exist);
        $x("//strong[@class='ng-binding'][contains(text(),'" + currency + "')]").shouldBe(Condition.exist);
    }

    @CsvFileSource(resources = "/sample.csv")
    @ParameterizedTest(name = "check default attributes on personal account {0}")
    @Tag("double")
    void checkDefaultAttributesOnPersonalAccountTest2 (String customerName, int accountNumber, int balance, String currency) {
        open("/customer");
        $("#userSelect").selectOption(customerName);
        new Button($(byText("Login"))).click();
        $("#accountSelect").selectOption(String.valueOf(accountNumber));
        $x("//strong[@class='ng-binding'][contains(text(),'" + accountNumber + "')]").shouldBe(Condition.exist);
        $x("//strong[@class='ng-binding'][contains(text(),'" + balance + "')]").shouldBe(Condition.exist);
        $x("//strong[@class='ng-binding'][contains(text(),'" + currency + "')]").shouldBe(Condition.exist);
    }

    private static Stream<Arguments> checkDefaultAttributesOnPersonalAccountTest3(){
        return Stream.of(
          Arguments.of("Hermoine Granger",1001,5096,"Dollar"),
          Arguments.of("Harry Potter",1006,0,"Rupee"),
          Arguments.of("Ron Weasly",1008,0,"Pound")
        );
    }

    @MethodSource
    @ParameterizedTest(name = "check default attributes on personal account {0}")
    @Tag("double")
    void checkDefaultAttributesOnPersonalAccountTest3(String customerName, int accountNumber, int balance, String currency) {
        open("/customer");
        $("#userSelect").selectOption(customerName);
        new Button($(byText("Login"))).click();
        $("#accountSelect").selectOption(String.valueOf(accountNumber));
        $x("//strong[@class='ng-binding'][contains(text(),'" + accountNumber + "')]").shouldBe(Condition.exist);
        $x("//strong[@class='ng-binding'][contains(text(),'" + balance + "')]").shouldBe(Condition.exist);
        $x("//strong[@class='ng-binding'][contains(text(),'" + currency + "')]").shouldBe(Condition.exist);
    }
}
