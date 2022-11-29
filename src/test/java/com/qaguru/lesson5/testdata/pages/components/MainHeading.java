package com.qaguru.lesson5.testdata.pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class MainHeading {
    private SelenideElement mainHeading;

    public MainHeading(SelenideElement element) {
        mainHeading = element;
    }

    public MainHeading shouldHaveText(String text){
        mainHeading.shouldHave(Condition.text(text));
        return this;
    }

    public MainHeading shouldExist(){
        mainHeading.shouldBe(Condition.exist);
        return this;
    }
}
