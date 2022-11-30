package com.qaguru.lesson5.pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class Button {

    private SelenideElement button;

    public Button(SelenideElement element){
        button = element;
    }

    public void click(){
        button.click();
    }

    public Button shouldHaveText(String text){
        button.shouldHave(Condition.text(text));
        return this;
    }

    public Button shouldExist(){
        button.shouldBe(Condition.exist);
        return this;
    }

}
