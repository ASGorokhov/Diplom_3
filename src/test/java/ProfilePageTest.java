import com.page.*;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import static org.junit.Assert.*;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;

public class ProfilePageTest extends Config {

    String email = newUser.get("email");
    String password = newUser.get("password");
    String name = newUser.get("name");
    AuthPage authPage = page(AuthPage.class);
    ProfilePage profilePage = page(ProfilePage.class);

    @Test
    @DisplayName("Проверка, что авторизованный пользователь может выйти по кнопке «Выход» из личного кабинета")
    @Description("При успешном выходе отобразится страница Входа c кнопкой «Войти»")
    public void logoutWithExitButtonTest()  {
        mainPage
                .signInButtonClick()
                .setEmail(email)
                .setPassword(password)
                .enterButtonClick()
                .authUserProfileButtonClick()
                .exitButtonClick();
        assertTrue("Кнопка «Войти» не появилась", authPage.isEnterButtonVisible());
    }

    @Test
    @DisplayName("Проверка, что авторизованный пользователь может перейти с главной страницы в Личный кабинет по кнопке «Личный кабинет»")
    @Description("При успешном переходе отобразится страница Профиля с именем и почтой")
    public void openAuthUserProfile()  {
        mainPage.signInButtonClick()
                .setEmail(email)
                .setPassword(password)
                .enterButtonClick()
                .profileButtonClick();
        assertNotNull("Логин не отображается", profilePage.getLoginInputValue());
        assertNotNull("Имя не отображается", profilePage.getNameInputValue());
        assertEquals("В профиле отображается неверный логин", email, profilePage.getLoginInputValue());
        assertEquals("В профиле отображается неверное имя", name, profilePage.getNameInputValue());
    }

    @Test
    @DisplayName("Проверка, что неавторизованный пользователь не может перейти с главной страницы в Личный кабинет по кнопке «Личный кабинет»")
    @Description("При переходе отобразится страница входа с кнопкой «Войти»")
    public void notOpenNonAuthUserProfile()  {
        mainPage.profileButtonClick();
        assertTrue("Кнопка «Войти» не появилась", authPage.isEnterButtonVisible());
    }

    @Test
    @DisplayName("Проверка, что авторизованный пользователь может перейти из Личного кабинета в Конструктор по кнопке «Конструктор»")
    @Description("При успешном переходе отобразится главная страница с кнопкой «Оформить заказ»")
    public void goToConstructorFromProfile()  {
        mainPage
                .signInButtonClick()
                .setEmail(email)
                .setPassword(password)
                .enterButtonClick()
                .authUserProfileButtonClick()
                .constructorButtonClick();
        assertTrue("Кнопка «Оформить заказ» не появилась", mainPage.executeOrderButtonVisible());
    }

    @Test
    @DisplayName("Проверка, что авторизованный пользователь может перейти из Личного кабинета на Главную по клику на Лого")
    @Description("При успешном переходе отобразится главная страница с кнопкой «Оформить заказ»")

    public void goToMainPageFromProfileWithBurgerLogo()  {
        mainPage.signInButtonClick()
                .setEmail(email)
                .setPassword(password)
                .enterButtonClick()
                .authUserProfileButtonClick()
                .burgerLogoClick();
        assertTrue("Кнопка «Оформить заказ» не появилась", mainPage.executeOrderButtonVisible());
    }
}
