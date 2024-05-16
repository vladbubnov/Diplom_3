import org.junit.Test;
import org.junit.Before;
import jdk.jfr.Description;
import pageobject.MainPage;
import functions.BaseFunctions;

import static org.junit.Assert.assertTrue;

public class ConstructorTest extends BaseFunctions {
    MainPage mainPage;

    @Before
    public void getPage() {
        initWebDriver();
        mainPage = new MainPage(driver);
    }

    @Test
    @Description("Проверка перехода к разделу 'Булки'")
    public void checkActiveBunInConstructor() {
        mainPage.clickInActiveSauceButton();
        mainPage.clickInactiveBunButton();
        assertTrue("Раздел 'Булки' не активен", mainPage.isActiveBunButton());
    }

    @Test
    @Description("Проверка перехода к разделу 'Соусы'")
    public void checkActiveSauceInConstructor() {
        mainPage.clickInActiveSauceButton();
        assertTrue("Раздел 'Булки' не активен", mainPage.isActiveSauceButton());
    }

    @Test
    @Description("Проверка перехода к разделу 'Начинки'")
    public void checkActiveFillingInConstructor() {
        mainPage.clickInActiveFillingButton();
        assertTrue("Раздел 'Булки' не активен", mainPage.isActiveFillingButton());
    }
}