import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import functions.DataUser;
import pageobject.MainPage;
import pageobject.LoginPage;
import functions.BaseFunctions;
import functions.UserFunctions;
import org.junit.runner.RunWith;
import io.restassured.RestAssured;
import pageobject.RegistrationPage;
import org.junit.runners.Parameterized;
import io.qameta.allure.junit4.DisplayName;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class RegistrationTest extends BaseFunctions {
    private final String name;
    private final String email;
    private final String password;
    private final Boolean isRegistrationError;

    MainPage mainPage;
    LoginPage loginPage;
    RegistrationPage registrationPage;

    public RegistrationTest(String name, String email, String password, Boolean isRegistrationError) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.isRegistrationError = isRegistrationError;
    }

    @Before
    public void getPage() {
        initWebDriver();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
    }

    @Parameters(name = "Test registration with: email - {1}, password - {2}")
    public static Object[][] getDataUser() {
        return new Object[][]{
                {"IvanovTest", "ivanov_test@gmail.com", "123456", false},
                {"IvanovTest", "ivanov_test@gmail.com", "12345", true}
        };
    }

    @Test
    @DisplayName("Регистрация")
    public void checkRegistration() {
        mainPage.clickLoginButton();
        loginPage.clickRegistrationButton();
        registrationPage.setDataRegistrationPage(name, email, password);
        registrationPage.clickRegistrationButton();
        if (!isRegistrationError) {
            assertTrue("Registration failed", loginPage.isDisplayedLoginButton());
        } else {
            assertTrue("Password less than 6 characters success", registrationPage.isDisplayedPasswordError());
        }
    }

    @After
    public void deleteUser() {
        UserFunctions userFunctions = new UserFunctions();
        DataUser dataUser = new DataUser("ivanov_test@gmail.com", "123456", "IvanovTest");
        userFunctions.sendDeleteRequestDeleteUser(dataUser);
    }
}