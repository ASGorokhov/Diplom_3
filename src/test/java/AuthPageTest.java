import com.page.*;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

public class AuthPageTest extends Config {

    String email = newUser.get("email");
    String password = newUser.get("password");

    @Test
    @DisplayName("Проверка, что пользователь может войти по кнопке «Войти в аккаунт» на Главной")
    @Description("При успешном входе на Главной появится кнопка «Оформить заказ»")
    public void loginUserWithEnterButtonOnMainPageTest(){
        mainPage
                .signInButtonClick()
                .setEmail(email)
                .setPassword(password)
                .enterButtonClick();
        boolean isExecuteOrderButtonDisplayedNow = page(MainPage.class).executeOrderButtonVisible();
        assertTrue("Кнопка «Оформить заказ» не появилась", isExecuteOrderButtonDisplayedNow);
    }

    @Test
    @DisplayName("Проверка, что пользователь может войти по кнопке «Личный кабинет» на Главной")
    @Description("При успешном входе на Главной появится кнопка «Оформить заказ»")
    public void loginUserWithProfileButtonOnMainPageTest(){
        mainPage
                .profileButtonClick()
                .setEmail(email)
                .setPassword(password)
                .enterButtonClick();
        boolean isExecuteOrderButtonDisplayedNow = page(MainPage.class).executeOrderButtonVisible();
        assertTrue("Кнопка «Оформить заказ» не появилась", isExecuteOrderButtonDisplayedNow);
    }

    @Test
    @DisplayName("Проверка, что пользователь может войти по ссылке «Войти» на форме регистрации")
    @Description("При успешном входе на Главной появится кнопка «Оформить заказ»")
    public void loginUserWithLoginLinkOnRegPageTest(){
        mainPage
                .signInButtonClick()
                .registerLinkClick()
                .loginLinkClick()
                .setEmail(email)
                .setPassword(password)
                .enterButtonClick();
        boolean isExecuteOrderButtonDisplayedNow = page(MainPage.class).executeOrderButtonVisible();
        assertTrue("Кнопка «Оформить заказ» не появилась", isExecuteOrderButtonDisplayedNow);
    }

    @Test
    @DisplayName("Проверка, что пользователь может войти по ссылке «Войти» на форме восстановления пароля")
    @Description("При успешном входе на Главной появится кнопка «Оформить заказ»")
    public void loginUserWithSignInLinkOnRestorePageTest(){
        mainPage
                .signInButtonClick()
                .restorePasswordLinkClick()
                .signInLinkClick()
                .setEmail(email)
                .setPassword(password)
                .enterButtonClick();
        boolean isExecuteOrderButtonDisplayedNow = page(MainPage.class).executeOrderButtonVisible();
        assertTrue("Кнопка «Оформить заказ» не появилась", isExecuteOrderButtonDisplayedNow);
    }
}
