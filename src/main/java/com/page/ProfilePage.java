package com.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class ProfilePage {

   public final static String PROFILE_PAGE_URL = "https://stellarburgers.nomoreparties.site/account/profile";

    @FindBy(how = How.XPATH,using = ".//button[text()='Выход']")
    private SelenideElement logoutButton;

    //выход по кнопке «Выйти» в личном кабинете
    @Step("Нажать на кнопку 'Выход'")
    public MainPage exitButtonClick(){
        logoutButton.click();
        return page(MainPage.class);
    }

    @FindBy (how = How.XPATH, using = "//*[text()='Конструктор']")
    private SelenideElement constructorButton;

    //переход по клику на «Конструктор»
    @Step("Нажать на кнопку 'Конструктор'")
    public MainPage constructorButtonClick() {
        constructorButton.click();
        return page(MainPage.class);
    }

    @FindBy (how = How.XPATH, using = "//*[@class='AppHeader_header__logo__2D0X2']")
    private SelenideElement burgerLogo;

    //Переход из личного кабинета в конструктор
    @Step("Нажать на лого")
    public MainPage burgerLogoClick() {
        burgerLogo.click();
        return page(MainPage.class);
    }

    @FindBy(how = How.XPATH,using = "(//div[@class='input__container']//div/input[@type='text'])[1]")
    private SelenideElement nameInput;

    public String getNameInputValue () {
        return nameInput.getValue();
    }

    @FindBy(how = How.XPATH,using = "(//div[@class='input__container']//div/input[@type='text'])[2]")
    private SelenideElement loginInput;

    public String getLoginInputValue () {
        return loginInput.getValue();
    }

}
