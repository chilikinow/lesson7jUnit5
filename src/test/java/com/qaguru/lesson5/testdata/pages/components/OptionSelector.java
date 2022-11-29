package com.qaguru.lesson5.testdata.pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class OptionSelector {

    SelenideElement optionSelector;

    public OptionSelector(SelenideElement element) {
        this.optionSelector = element;
    }

    public OptionSelector shouldExist(){
        optionSelector.shouldBe(Condition.exist);
        return this;
    }
}
