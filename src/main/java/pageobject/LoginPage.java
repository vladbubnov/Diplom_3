package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;
    //Поле ввода "Email"
    private final By emailField = By.xpath(".//fieldset[1]//input");
    //Поле ввода "Password"
    private final By passwordField = By.xpath(".//fieldset[2]//input");
    //Кнопка "Войти"
    private final By loginButton = By.xpath(".//button[@class=" +
            "'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    //Кнопка "Зарегистрироваться"
    private final By registrationButton = By.xpath(".//a[text()='Зарегистрироваться']");
    //Кнопка "Восстановить пароль"
    private final By recoverPasswordButton = By.xpath(".//a[text()='Восстановить пароль']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Заполнение поля email")
    public void setEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Заполнение поля пароль")
    public void setPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Нажатие на кнопку 'Войти'")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Нажатие на кнопку 'Зарегистрироваться'")
    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    @Step("Нажатие на кнопку 'Восстановить пароль'")
    public void clickRecoverPasswordButton() {
        driver.findElement(recoverPasswordButton).click();
    }

    @Step("Проверка отображения кнопки 'Войти'")
    public boolean isDisplayedLoginButton() {
        return driver.findElement(loginButton).isDisplayed();
    }

    @Step("Заполнение всех полей на странице авторизации")
    public void setDataLoginPage(String email, String password) {
        setEmailField(email);
        setPasswordField(password);
    }
}