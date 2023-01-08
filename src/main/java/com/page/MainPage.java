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

    @FindBy(how = How.XPATH,using = "//p[text()='Личный Кабинет']")
    public SelenideElement profileButton;

    @FindBy (how = How.XPATH, using = "//span[text()='Булки']")
    private SelenideElement bunsTab;

    @FindBy (how = How.XPATH, using = "//span[text()='Соусы']")
    private SelenideElement saucesTab;

    @FindBy (how = How.XPATH, using = "//span[text()='Начинки']")
    private SelenideElement fillingsTab;

    @FindBy(how = How.XPATH,using = "//h2[text()='Булки']") ////h2[text()='Булки']
    private SelenideElement bunsTabSelected;

    @FindBy(how = How.XPATH,using = "//h2[text()='Начинки']")//h2[text()='Начинки']
    private SelenideElement fillingsTabSelected;

    @FindBy(how = How.XPATH,using = "//h2[text()='Соусы']")//h2[text()='Соусы']
    private SelenideElement saucesTabSelected;

    @FindBy(how = How.XPATH,using = "//p[text()='Флюоресцентная булка R2-D3']")
    private SelenideElement bunFlu;

    @FindBy(how = How.XPATH,using = "//p[text()='Соус Spicy-X']")
    private SelenideElement sauceSpicy;

    @FindBy(how = How.XPATH,using = "//p[text()='Мясо бессмертных моллюсков Protostomia']")
    private SelenideElement fillingMeat;

    @FindBy (how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    private SelenideElement executeOrderButton;

    // вход по кнопке «Войти в аккаунт» на главной
    public AuthPage signInButtonClick (){
        signInButton.click();
        return page(AuthPage.class);
    }

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

    @Step("Нажать «Булки»")
    public MainPage bunsTabClick(){
        bunsTab.shouldBe(enabled).click();
        return this;
    }

    @Step ("Нажать «Соусы»")
    public MainPage saucesTabClick(){
        saucesTab.shouldBe(enabled).click();
        return this;
    }

    @Step ("Нажать «Начинки»")
    public MainPage fillingsTabClick(){
        fillingsTab.shouldBe(enabled).click();
        return this;
    }

    @Step("Проверить отображение выбранной вкладки «Булки».")
    public boolean isBunTabIsDisplayed() {
      return bunsTabSelected.shouldBe(visible).isDisplayed();
    }

    @Step("Проверить отображение выбранной вкладки «Начинки».")
    public boolean isFillingsTabIsDisplayed() {
        return fillingsTabSelected.shouldBe(visible).isDisplayed();
    }

    @Step("Проверить отображение выбранной вкладки «Соусы».")
    public boolean isSaucesTabIsDisplayed() {
        return saucesTabSelected.shouldBe(visible).isDisplayed();
    }

    @Step("Проверить отображение булки «Флюоресцентная булка R2-D3»")
    public boolean isBunFluVisible() {
     return bunFlu.shouldBe(visible).isDisplayed();
    }

    @Step("Проверить отображение соуса «Соус Spicy-X»")
    public boolean isSauceSpicyVisible() {
       return sauceSpicy.shouldBe(visible).isDisplayed();
    }

    @Step("Проверить отображение начинки «Мясо бессмертных моллюсков Protostomia»")
    public boolean isFillingMeatVisible() {
        return fillingMeat.shouldBe(visible).isDisplayed();
    }

    public boolean executeOrderButtonVisible (){
        return executeOrderButton.shouldBe(visible).isDisplayed();
    }
}
