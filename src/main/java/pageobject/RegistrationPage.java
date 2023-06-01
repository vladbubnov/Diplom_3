package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    private WebDriver driver;
    //Поле ввода "Имя"
    private final By nameField = By.xpath(".//fieldset[1]//input");
    //Поле ввода "Email"
    private final By emailField = By.xpath(".//fieldset[2]//input");
    //Поле ввода "Password"
    private final By passwordField = By.xpath(".//fieldset[3]//input");
    //Кнопка "Зарегистрироваться"
    private final By registrationButton = By.xpath(".//button[contains(text(),'Зарегистрироваться')]");
    //Кнопка "Войти"
    private final By loginButton = By.xpath(".//a[text()='Войти']");
    //Надпись "Некорректный пароль"
    private final By passwordError = By.xpath(".//p[text()='Некорректный пароль']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Заполнение поля имя")
    public void setNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    @Step("Заполнение поля email")
    public void setEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Заполнение поля пароль")
    public void setPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Нажатие на кнопку 'Зарегистрироваться'")
    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    @Step("Нажатие на кнопку 'Войти'")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Проверка отображения надписи 'Некорректный пароль'")
    public boolean isDisplayedPasswordError() {
        return driver.findElement(passwordError).isDisplayed();
    }

    @Step("Заполнение всех полей на странице регистрации")
    public void setDataRegistrationPage(String name, String email, String password) {
        setNameField(name);
        setEmailField(email);
        setPasswordField(password);
    }
}