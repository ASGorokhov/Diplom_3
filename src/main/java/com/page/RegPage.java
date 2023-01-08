package com.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.page;

public class RegPage {
    public final static String REG_PAGE_URL = "https://stellarburgers.nomoreparties.site/register";

    @FindBy(how = How.XPATH, using = "//input[@type='text']")
    private SelenideElement nameInput;

    @FindBy(how = How.XPATH, using = ".//fieldset[2]//input")
    private SelenideElement emailInput;

    @FindBy(how = How.XPATH, using = "//input[@type='password']")
    private SelenideElement passwordInput;

    @FindBy(how = How.XPATH, using = ".//button[text()='Зарегистрироваться']")
    private SelenideElement regButton;

    @FindBy(how = How.XPATH, using = ".//*[@class='input__error text_type_main-default']")
    private SelenideElement wrongPassErrorMessage;

    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    private SelenideElement loginLink;

    @Step("Ввод имени")
    public RegPage setName(String name) {
        nameInput.shouldBe(Condition.enabled).click();
        nameInput.setValue(name);
        return this;
    }

    @Step ("Ввод почты")
    public RegPage setEmail(String email) {
        emailInput.shouldBe(Condition.enabled).click();
        emailInput.setValue(email);
        return this;
    }

    @Step ("Ввод пароля")
    public RegPage setPassword(String password) {
        passwordInput.shouldBe(Condition.enabled).click();
        passwordInput.setValue(password);
        return this;
    }

    @Step ("Нажать кнопку 'Зарегистрироваться'")
    public AuthPage regButtonClick() {
        regButton.shouldBe(Condition.enabled).scrollTo().click();
        return page(AuthPage.class);
    }

    // вход через кнопку в форме регистрации,
    @Step ("Перейти по ссылке 'Войти'")
    public AuthPage loginLinkClick() {
        loginLink.scrollTo().click();
        return page(AuthPage.class);
    }

    @Step ("Проверить, виден ли текст ошибки при некорректном пароле")
    public boolean isWrongPassErrorMessageVisible() {
        return wrongPassErrorMessage.isDisplayed();
    }

    @Step ("Проверить наличие ошибки при попытке зарегистрироваться с уже существующим логином")
    public boolean isEmailCorrect() {
        return wrongPassErrorMessage.shouldBe(visible).getText().contains("Такой пользователь уже существует");}
}
