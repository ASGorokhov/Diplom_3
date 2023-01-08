import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ConstructorTest extends Config {

    @Test
    @DisplayName("Проверка, что пользователь может перейти на вкладку «Соусы» на Главной")
    @Description("Отобразится секция с названием «Соусы» и соус «Соус Spicy-X»")
    public void saucesSectionTest(){
        boolean isSaucesSectionDisplayed =
                mainPage
                        .saucesTabClick()
                        .isSaucesTabIsDisplayed();
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
                        .fillingsTabClick()
                        .bunsTabClick()
                        .isBunTabIsDisplayed();
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
                        .isFillingsTabIsDisplayed();
        assertTrue("Секция «Начинки» не появилась", isFillingsSectionDisplayed);
        assertTrue("Мясо бессмертных моллюсков Protostomia не появилось", mainPage.isFillingMeatVisible());
    }
}
