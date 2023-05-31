package functions;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseFunctions {
    protected WebDriver driver;
    private final String URL = "https://stellarburgers.nomoreparties.site";

    public void initWebDriver() {
        //Для запуска тестов на Yandex
//        System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver.exe");
//        driver = new ChromeDriver();
        //Для запуска тестов на Chrome
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}