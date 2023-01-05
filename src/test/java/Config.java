import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;

public class Config {
   @Before
    public void start() {
       WebDriverManager.chromedriver().setup();
       // по умолчанию тесты проходят в Chrome
       // для тестирования в Яндекс-браузере в Win раскомментить
       // System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
       Configuration.timeout = 40000;
       Configuration.startMaximized = true;
    }

}
