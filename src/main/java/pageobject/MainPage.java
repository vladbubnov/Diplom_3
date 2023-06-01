package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class MainPage {

    private final WebDriver driver;
    //Кнопка "Войти в аккаунт"
    private final By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");
    //Кнопка "Личный кабинет"
    private final By personalAreaButton = By.xpath(".//p[contains(text(),'Личный Кабинет')]");
    //Кнопка раздела "Булки" - активная
    private final By activeBunButton = By.xpath(".//div[@class='tab_tab__1SPyG " +
            "tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']");
    //Кнопка раздела "Булки" - неактивная
    private final By inactiveBunButton = By.xpath(".//div[@class='tab_tab__1SPyG  " +
            "pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']");
    //Кнопка раздела "Соусы" - активная
    private final By activeSauceButton = By.xpath(".//div[@class='tab_tab__1SPyG " +
            "tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']");
    //Кнопка раздела "Соусы" - неактивная
    private final By inactiveSauceButton = By.xpath(".//div[@class='tab_tab__1SPyG  " +
            "pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']");
    //Кнопка раздела "Начинки" - активная
    private final By activeFillingButton = By.xpath(".//div[@class='tab_tab__1SPyG " +
            "tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']");
    //Кнопка раздела "Начинки" - неактивная
    private final By inactiveFillingButton = By.xpath(".//div[@class='tab_tab__1SPyG  " +
            "pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']");
    //Кнопка Оформить заказ
    private final By orderButton = By.xpath(".//button[text()='Оформить заказ']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажатие на кнопку 'Войти в аккаунт'")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Нажатие на кнопку 'Личный кабинет'")
    public void clickPersonalAreaButton() {
        driver.findElement(personalAreaButton).click();
    }

    @Step("Нажатие на кнопку 'Булки'")
    public void clickInactiveBunButton() {
        driver.findElement(inactiveBunButton).click();
    }

    @Step("Проверка перехода к разделу 'Булки'")
    public boolean isActiveBunButton() {
        return driver.findElement(activeBunButton).isDisplayed();
    }

    @Step("Нажатие на кнопку 'Соусы'")
    public void clickInActiveSauceButton() {
        driver.findElement(inactiveSauceButton).click();
    }

    @Step("Проверка перехода к разделу 'Соусы'")
    public boolean isActiveSauceButton() {
        return driver.findElement(activeSauceButton).isDisplayed();
    }

    @Step("Нажатие на кнопку 'Начинки'")
    public void clickInActiveFillingButton() {
        driver.findElement(inactiveFillingButton).click();
    }

    @Step("Проверка перехода к разделу 'Начинки'")
    public boolean isActiveFillingButton() {
        return driver.findElement(activeFillingButton).isDisplayed();
    }

    @Step("Нажатие на кнопку 'Оформить заказ'")
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    @Step("Нажатие на кнопку 'Оформить заказ'")
    public void getTextOrderButton() {
        driver.findElement(orderButton).getText();
    }

    @Step("Ожидание отображения кнопки 'Войти в аккаунт'")
    public void waitForLoadProfileDataOrderButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(orderButton));
    }

    @Step("Проверка отображения кнопки 'Оформить заказ'")
    public boolean isDisplayedOrderButton() {
        return driver.findElement(orderButton).isDisplayed();
    }
}