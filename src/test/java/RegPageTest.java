import com.UserOperations;
import com.page.*;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.time.Instant;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;
import static com.page.MainPage.MAIN_PAGE_URL;
import static org.junit.Assert.*;

public class RegPageTest extends Config {
    UserOperations userOperations = new UserOperations();
    Map<String, String> newUser = userOperations.register();
    String email = newUser.get("email");
    String password = newUser.get("password");
    String name = newUser.get("name");
    MainPage mainPage;
    RegPage regPage = page(RegPage.class);


    Instant instant = Instant.now();
    long timeStampMillis = instant.toEpochMilli(); //префикс для сгенерированных email

    @Before
    public void before() {
        mainPage = open(MAIN_PAGE_URL, MainPage.class);

    }

    @After
    public void tearDown() {
        userOperations.delete();
        webdriver().driver().close();
    }

    @Test
    @DisplayName("Проверка, что пользователь может зарегистрироваться и затем авторизоваться")
    @Description("При успешном входе на Главной появится кнопка «Оформить заказ»")
    public void successRegistrationNewUserTest() {
        mainPage
                .signInButtonClick()
                .registerLinkClick()
                .setName(name)
                .setEmail(timeStampMillis+email) //добавлен префикс, чтобы сгенерированные email не повторялись
                .setPassword(password)
                .regButtonClick()
                .setEmail(timeStampMillis+email)
                .setPassword(password)
                .enterButtonClick();
        boolean isExecuteOrderButtonDisplayedNow = page(MainPage.class).executeOrderButtonVisible();
        assertTrue("Кнопка «Оформить заказ» не появилась", isExecuteOrderButtonDisplayedNow);
    }

    @Test
    @DisplayName("Проверка, что пользователь не может зарегистрироваться с уже ранее зарегистрированным email")
    @Description("Появится ошибка «Такой пользователь уже существует»")
    public void duplicatedRegistrationNewUserTest() {
        mainPage
                .signInButtonClick()
                .registerLinkClick()
                .setName(name)
                .setEmail(timeStampMillis+email)
                .setPassword(password)
                .regButtonClick()
                .registerLinkClick()
                .setName(name)
                .setEmail(timeStampMillis+email)
                .setPassword(password)
                .regButtonClick();
        assertTrue("Ошибка при создании пользователя с таким же email не отображается", regPage.isEmailCorrect());
    }

    @Test
    @DisplayName("Проверка, что пользователь не может зарегистрироваться с паролем 5 символов")
    @Description("Появится ошибка «Некорректный пароль»")
    public void registrationNewUserWithIncorrectPasswordTest() {
        String wrongPass = "55555";
        mainPage
                .signInButtonClick()
                .registerLinkClick()
                .setName(name)
                .setEmail(email)
                .setPassword(wrongPass)
                .regButtonClick();
        assertTrue("Ошибка «Некорректный пароль» не появилась", regPage.isWrongPassErrorMessageVisible());
    }
}
