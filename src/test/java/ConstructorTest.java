import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.practikum.PageObjects.MainPageObject;
import ru.practikum.WebDriverFactory.WebDriverFactory;

import static java.time.Duration.ofSeconds;
import static ru.practikum.CONSTANTS.STELLAR_BURGER.STELLAR_BURGER_WEBSITE_URL;

public class ConstructorTest {
    private MainPageObject mainPageObject;
    private WebDriver driver;

    @Before
    public void setup() {
        driver = WebDriverFactory.getDriver();
        driver.get(STELLAR_BURGER_WEBSITE_URL);
        mainPageObject = new MainPageObject(driver);
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void sauceConstructorSubdivisionTest() {
        mainPageObject.sauceSubdivisionButtonClick();
        Assert.assertTrue(mainPageObject.checkIfCurrentTabIsSauce());
    }

    @Test
    public void fillingConstructorSubdivisionTest() {
        mainPageObject.fillingsSubdivisionButtonClick();
        Assert.assertTrue(mainPageObject.checkIfCurrentTabIsFilling());
    }

    @Test
    public void bunsConstructorSubdivisionTest() {
        mainPageObject.sauceSubdivisionButtonClick();
        mainPageObject.bunsSubdivisionButtonClick();
        Assert.assertTrue(mainPageObject.checkIfCurrentTabIsBuns());
    }
}
