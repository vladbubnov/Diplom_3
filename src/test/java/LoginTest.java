import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import functions.DataUser;
import pageobject.MainPage;
import pageobject.LoginPage;
import functions.BaseFunctions;
import functions.UserFunctions;
import io.restassured.RestAssured;
import pageobject.RegistrationPage;
import pageobject.ResetPasswordPage;
import io.qameta.allure.junit4.DisplayName;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseFunctions {
    UserFunctions userFunctions = new UserFunctions();
    DataUser dataUser = new DataUser("ivanov_test@gmail.com", "123456", "IvanovTest");
    MainPage mainPage;
    LoginPage loginPage;
    RegistrationPage registrationPage;
    ResetPasswordPage resetPasswordPage;

    @Before
    public void getPage() {
        initWebDriver();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        resetPasswordPage = new ResetPasswordPage(driver);
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
        userFunctions.sendPostRequestCreateUser(dataUser);
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void loginByMainButton() {
        mainPage.clickLoginButton();
        loginPage.setDataLoginPage("ivanov_test@gmail.com", "123456");
        loginPage.clickLoginButton();
        mainPage.waitForLoadProfileDataOrderButton();
        assertTrue("Ошибка авторизации", mainPage.isDisplayedOrderButton());
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void loginByAccountButton() {
        mainPage.clickPersonalAreaButton();
        loginPage.setDataLoginPage("ivanov_test@gmail.com", "123456");
        loginPage.clickLoginButton();
        mainPage.waitForLoadProfileDataOrderButton();
        assertTrue("Ошибка авторизации", mainPage.isDisplayedOrderButton());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginByRegistrationFormButton() {
        mainPage.clickLoginButton();
        loginPage.clickRegistrationButton();
        registrationPage.clickLoginButton();
        loginPage.setDataLoginPage("ivanov_test@gmail.com", "123456");
        loginPage.clickLoginButton();
        mainPage.waitForLoadProfileDataOrderButton();
        assertTrue("Ошибка авторизации", mainPage.isDisplayedOrderButton());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void loginByPasswordResetButton() {
        mainPage.clickLoginButton();
        loginPage.clickRecoverPasswordButton();
        resetPasswordPage.clickLoginButton();
        loginPage.setDataLoginPage("ivanov_test@gmail.com", "123456");
        loginPage.clickLoginButton();
        mainPage.waitForLoadProfileDataOrderButton();
        assertTrue("Ошибка авторизации", mainPage.isDisplayedOrderButton());
    }

    @After
    public void deleteUser() {
        userFunctions.sendDeleteRequestDeleteUser(dataUser);
    }
}