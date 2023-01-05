package com.page;

import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.page;

public class RestorePassPage {
    public final static String RESTORE_PASS_URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    @FindBy(how = How.XPATH,using = ".//a[text()='Войти']")
    private SelenideElement signInLink;

    //вход через кнопку в форме восстановления пароля
    @Step("Перейти по ссылке 'Войти'")
    public AuthPage signInLinkClick (){
        signInLink.click();
        return page(AuthPage.class);
    }
}
