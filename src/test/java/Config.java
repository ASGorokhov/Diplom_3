import com.UserOperations;
import com.codeborne.selenide.Configuration;
import com.page.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.page.MainPage.MAIN_PAGE_URL;

public class Config {

    UserOperations userOperations = new UserOperations();
    Map<String, String> newUser = userOperations.register();
    MainPage mainPage;

   @Before
    public void start() {
       WebDriverManager.chromedriver().setup();
       // по умолчанию тесты проходят в Chrome
       // для тестирования в Яндекс-браузере в Win раскомментить
       // System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
       Configuration.timeout = 40000;
       Configuration.startMaximized = true;

       mainPage = open(MAIN_PAGE_URL, MainPage.class);
    }

    @After
    public void tearDown() {
        userOperations.delete();
        webdriver().driver().close();
    }
}
