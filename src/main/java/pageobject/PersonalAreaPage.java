package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class PersonalAreaPage {

    private final WebDriver driver;
    //Кнопка "Конструктор"
    private final By constructorButton = By.xpath(".//p[contains(text(),'Конструктор')]");
    //Кнопка "Логотип"
    private final By logoButton = By.className("AppHeader_header__logo__2D0X2");
    //Кнопка "Профиль"
    private final By profileButton = By.xpath(".//a[@href='/account/profile']");
    //Кнопка "Выход"
    private final By logoutButton = By.xpath(".//button[text()='Выход']");

    public PersonalAreaPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик на кнопку 'Конструктор'")
    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    @Step("Клик на кнопку 'Логотип'")
    public void clickLogoButton() {
        driver.findElement(logoButton).click();
    }

    @Step("Клик на кнопку 'Выход'")
    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }

    @Step("Ожидание загрузки страницы 'Личный кабинет'")
    public void waitForLoadPersonalArea() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(profileButton));
    }

    @Step("Видимость кнопки 'Профиль'")
    public boolean isDisplayedProfileButton() {
        return driver.findElement(profileButton).isDisplayed();
    }
}