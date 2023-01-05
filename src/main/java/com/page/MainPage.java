package com.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {
    public final static String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";

    @FindBy(how = How.XPATH, using = ".//button [text()='Войти в аккаунт']")
    public SelenideElement signInButton;

    // вход по кнопке «Войти в аккаунт» на главной
    public AuthPage signInButtonClick (){
        signInButton.click();
        return page(AuthPage.class);
    }

    @FindBy(how = How.XPATH,using = "//p[text()='Личный Кабинет']")
    public SelenideElement profileButton;

    //вход через кнопку «Личный кабинет»
    public AuthPage profileButtonClick (){
        profileButton.click();
        return page(AuthPage.class);
    }

    //Переход в личный кабинет через кнопку «Личный кабинет»
    public ProfilePage authUserProfileButtonClick (){
        profileButton.click();
        return page(ProfilePage.class);
    }

    @FindBy (how = How.XPATH, using = ".//span [@class='text text_type_main-default'][text()='Булки']")
    private SelenideElement bunsTab;

    @Step("Нажать «Булки»")
    public MainPage bunsTabClick(){
        bunsTab.shouldBe(enabled).click();
        return this;
    }

    @FindBy (how = How.XPATH, using = ".//span [@class='text text_type_main-default'][text()='Соусы']")
    private SelenideElement saucesTab;

    @Step ("Нажать «Соусы»")
    public MainPage saucesTabClick(){
        saucesTab.shouldBe(enabled).click();
        return this;
    }

    @FindBy (how = How.XPATH, using = ".//span [@class='text text_type_main-default'][text()='Начинки']")
    private SelenideElement fillingsTab;

    @Step ("Нажать «Начинки»")
    public MainPage fillingsTabClick(){
        fillingsTab.shouldBe(enabled).click();
        return this;
    }

    @FindBy(how = How.XPATH,using = "//div[contains(@class, 'current')]/span[text()='Булки']")
    private SelenideElement bunsTabSelected;

    @Step("Проверить отображение выбранной вкладки «Булки».")
    public boolean isBunTabSelected() {
      return bunsTabSelected.shouldBe(visible).isDisplayed();
    }

    @FindBy(how = How.XPATH,using = "//div[contains(@class, 'current')]/span[text()='Начинки']")
    private SelenideElement fillingsTabSelected;

    @Step("Проверить отображение выбранной вкладки «Начинки».")
    public boolean isFillingsTabSelected() {
        return fillingsTabSelected.shouldBe(visible).isDisplayed();
    }

    @FindBy(how = How.XPATH,using = "//div[contains(@class, 'current')]/span[text()='Соусы']")
    private SelenideElement saucesTabSelected;

    @Step("Проверить отображение выбранной вкладки «Соусы».")
    public boolean isSaucesTabSelected() {
        return saucesTabSelected.shouldBe(visible).isDisplayed();
    }

    @FindBy(how = How.XPATH,using = "//p[text()='Флюоресцентная булка R2-D3']")
    private SelenideElement bunFlu;

    @Step("Проверить отображение булки «Флюоресцентная булка R2-D3»")
    public boolean isBunFluVisible() {
     return bunFlu.shouldBe(visible).isDisplayed();
    }

    @FindBy(how = How.XPATH,using = "//p[text()='Соус Spicy-X']")
    private SelenideElement sauceSpicy;

    @Step("Проверить отображение соуса «Соус Spicy-X»")
    public boolean isSauceSpicyVisible() {
       return sauceSpicy.shouldBe(visible).isDisplayed();
    }

    @FindBy(how = How.XPATH,using = "//p[text()='Мясо бессмертных моллюсков Protostomia']")
    private SelenideElement fillingMeat;

    @Step("Проверить отображение начинки «Мясо бессмертных моллюсков Protostomia»")
    public boolean isFillingMeatVisible() {
        return fillingMeat.shouldBe(visible).isDisplayed();
    }

    @FindBy (how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    private SelenideElement executeOrderButton;

    public boolean executeOrderButtonVisible (){
        return executeOrderButton.shouldBe(visible).isDisplayed();
    }

}
