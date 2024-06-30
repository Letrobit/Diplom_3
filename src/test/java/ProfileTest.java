import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.practikum.API.register.GenerateUser;
import ru.practikum.API.steps.UserSteps;
import ru.practikum.PageObjects.*;
import ru.practikum.WebDriverFactory.WebDriverFactory;

import static io.restassured.RestAssured.baseURI;
import static java.time.Duration.ofSeconds;
import static ru.practikum.CONSTANTS.STELLAR_BURGER.STELLAR_BURGER_URI;
import static ru.practikum.CONSTANTS.STELLAR_BURGER.STELLAR_BURGER_WEBSITE_URL;

public class ProfileTest {
    private UserSteps userSteps = new UserSteps();
    private MainPageObject mainPageObject;
    private ProfilePageObject profilePageObject;
    private LoginPageObject loginPageObject;
    String accessToken;
    private GenerateUser generateUser;
    private WebDriver driver;

    @Before
    public void setup() {
        //RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        driver = WebDriverFactory.getDriver();
        driver.get(STELLAR_BURGER_WEBSITE_URL);
        baseURI = STELLAR_BURGER_URI;
        generateUser = new GenerateUser();
        mainPageObject = new MainPageObject(driver);
        loginPageObject = new LoginPageObject(driver);
        profilePageObject = new ProfilePageObject(driver);


        accessToken = userSteps
                .createUser(generateUser)
                .extract().body().path("accessToken");
    }

    @After
    public void teardown() {
        driver.quit();

        if (accessToken != null) {
            userSteps.deleteUser(accessToken);
        }
    }

    @Test
    public void profilePageLoadTest() {
        mainPageObject.clickLoginButton();
        loginPageObject.loginToAccount(generateUser);
        mainPageObject.lichniyKabinetClick();
        Assert.assertTrue(profilePageObject.profileInputFieldIsVisible());
        Assert.assertTrue(profilePageObject.profileTextIsVisible());
    }

    @Test
    public void profilePageConstructorLoadTest() {
        mainPageObject.clickLoginButton();
        loginPageObject.loginToAccount(generateUser);
        mainPageObject.lichniyKabinetClick();
        profilePageObject.lichniyKabinetConstructorButtonClick();
        Assert.assertTrue(mainPageObject.constructorBlockIsVisible());
    }

    @Test
    public void profilePageLogoLoadTest() {
        mainPageObject.clickLoginButton();
        loginPageObject.loginToAccount(generateUser);
        mainPageObject.lichniyKabinetClick();
        profilePageObject.lichniyKabinetLogoClick();
        Assert.assertTrue(mainPageObject.constructorBlockIsVisible());
    }
}
