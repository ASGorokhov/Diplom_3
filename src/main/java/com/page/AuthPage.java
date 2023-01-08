package com.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class AuthPage {
    public final static String AUTH_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";

    @FindBy(how = How.XPATH,using = ".//input[@name='name']")
    private SelenideElement emailInput;

    @FindBy(how = How.XPATH,using = ".//input[@name='Пароль']")
    private SelenideElement passwordInput;

    @FindBy(how = How.XPATH,using = ".//button[text()='Войти']")
    private SelenideElement enterButton;

    @FindBy(how = How.XPATH,using = ".//a[text()='Зарегистрироваться']")
    private SelenideElement registerLink;

    @FindBy(how = How.XPATH,using = ".//a[text()='Восстановить пароль']")
    private SelenideElement restorePasswordLink;

    @Step("Ввод логина")
    public AuthPage setEmail(String email) {
        emailInput.shouldBe(empty).click();
        emailInput.setValue(email);
        return this;
    }

    @Step("Ввод пароля")
    public AuthPage setPassword(String password) {
        passwordInput.shouldBe(empty).click();
        passwordInput.setValue(password);
        return this;
    }

    @Step("Нажать на кнопку Войти")
    public MainPage enterButtonClick() {
        enterButton.shouldBe(Condition.enabled).click();
        return page(MainPage.class);
    }

    @Step ("Проверить наличие кнопки Войти")
    public boolean isEnterButtonVisible() {
        return enterButton.shouldBe(visible).isDisplayed();
    }

    @Step("Перейти по ссылке 'Зарегистрироваться'")
    public RegPage registerLinkClick() {
        registerLink.click();
        return page(RegPage.class);
    }

    @Step("Перейти по ссылке 'Восстановить пароль'")
    public RestorePassPage restorePasswordLinkClick() {
        restorePasswordLink.click();
        return page(RestorePassPage.class);
    }
}
