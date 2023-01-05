import com.page.MainPage;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.page.MainPage.MAIN_PAGE_URL;
import static org.junit.Assert.assertTrue;

public class ConstructorTest extends Config {
    MainPage mainPage;

    @Before
    public void before() {
        mainPage = open(MAIN_PAGE_URL, MainPage.class);
    }

    @After
    public void tearDown() {
        webdriver().driver().close();
    }

    @Test
    @DisplayName("Проверка, что пользователь может перейти на вкладку «Соусы» на Главной")
    @Description("Отобразится секция с названием «Соусы» и соус «Соус Spicy-X»")
    public void saucesSectionTest(){
        boolean isSaucesSectionDisplayed =
                mainPage
                        .saucesTabClick()
                        .isSaucesTabSelected();
        assertTrue("Секция «Соусы» не появилась", isSaucesSectionDisplayed);
        assertTrue("Соус Spicy-X не появился", mainPage.isSauceSpicyVisible());
    }

    @Test
    @DisplayName("Проверка, что пользователь может перейти на вкладку «Булки» из других вкладок на Главной")
    @Description("Отобразится секция с названием «Булки» и булка «Флюоресцентная булка R2-D3»")
    public void bunsSectionTest(){
        boolean isBunsSectionDisplayed =
                mainPage
                        .saucesTabClick()
                        .bunsTabClick()
                        .isBunTabSelected();
        assertTrue("Секция «Булки» не появилась", isBunsSectionDisplayed);
        assertTrue("Флюоресцентная булка R2-D3 не появилась", mainPage.isBunFluVisible());
    }

    @Test
    @DisplayName("Проверка, что пользователь может перейти на вкладку «Начинки» на Главной")
    @Description("Отобразится секция с названием «Начинки» и начинка «Мясо бессмертных моллюсков Protostomia»")
    public void fillingsSectionTest(){
        boolean isFillingsSectionDisplayed =
                mainPage
                        .fillingsTabClick()
                        .isFillingsTabSelected();
        assertTrue("Секция «Начинки» не появилась", isFillingsSectionDisplayed);
        assertTrue("Мясо бессмертных моллюсков Protostomia не появилось", mainPage.isFillingMeatVisible());
    }
}
