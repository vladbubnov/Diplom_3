import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import functions.DataUser;
import pageobject.MainPage;
import pageobject.LoginPage;
import functions.BaseFunctions;
import functions.UserFunctions;
import io.restassured.RestAssured;
import pageobject.PersonalAreaPage;
import io.qameta.allure.junit4.DisplayName;

import static org.junit.Assert.assertTrue;

public class PersonalAreaTest extends BaseFunctions {
    UserFunctions userFunctions = new UserFunctions();
    DataUser dataUser = new DataUser("ivanov_test@gmail.com", "123456", "IvanovTest");
    MainPage mainPage;
    LoginPage loginPage;
    PersonalAreaPage personalAreaPage;

    @Before
    public void getPage() {
        initWebDriver();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        personalAreaPage = new PersonalAreaPage(driver);
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
        userFunctions.sendPostRequestCreateUser(dataUser);
        mainPage.clickLoginButton();
        loginPage.setDataLoginPage("ivanov_test@gmail.com", "123456");
        loginPage.clickLoginButton();
    }

    @Test
    @DisplayName("Переход по клику на 'Личный кабинет'")
    public void navigateToPersonalAreaOnClick() {
        mainPage.clickPersonalAreaButton();
        personalAreaPage.waitForLoadPersonalArea();
        assertTrue("Переход в личный кабинет не выполнен", personalAreaPage.isDisplayedProfileButton());
    }

    @Test
    @DisplayName("Переход в конструктор по клику на 'Конструктор'")
    public void navigateToConstructorOnClick() {
        mainPage.clickPersonalAreaButton();
        personalAreaPage.clickConstructorButton();
        assertTrue("Переход в конструктор не выполнен", mainPage.isActiveBunButton());
    }

    @Test
    @DisplayName("Переход в конструктор по клику на логотип 'Stellar Burgers'")
    public void navigateToLogoOnClick() {
        mainPage.clickPersonalAreaButton();
        personalAreaPage.clickLogoButton();
        assertTrue("Переход в конструктор не выполнен", mainPage.isActiveBunButton());
    }

    @Test
    @DisplayName("Проверка выхода по кнопке 'Выйти' в личном кабинете")
    public void checkLogout() {
        mainPage.clickPersonalAreaButton();
        personalAreaPage.waitForLoadPersonalArea();
        personalAreaPage.clickLogoutButton();
        assertTrue("Переход в конструктор не выполнен", loginPage.isDisplayedLoginButton());
    }

    @After
    public void deleteUser() {
        userFunctions.sendDeleteRequestDeleteUser(dataUser);
    }
}