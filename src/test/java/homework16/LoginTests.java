package homework16;

import io.github.bonigarcia.wdm.WebDriverManager;
import homework16.page.factory.Header;
import homework16.page.factory.HomePage;
import homework16.page.factory.LoginPage;
import homework16.page.factory.ProfilePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class LoginTests {
    private WebDriver driver;
    @BeforeSuite
    protected final void setupTestSuite() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.edgedriver().setup();
    }
    @BeforeMethod
    protected final void setUpTest() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @AfterMethod
    protected final void tearDownTest() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }
    @DataProvider(name = "getUsers")
    public Object[][] getUsers() {
        return new Object[][]{{"realtester", "123456", "realtester"},
                {"realtester@yopmail.com", "123456", "realtester"},
                //tests fail with 2nd user credentials, because they are invalid;
                // there's a Bug in the SKILLO system which doesn't allow new user registration
        };
    }
    @Test(dataProvider = "getUsers")
    public void testLogin(String user, String password, String name) {
        HomePage homePage = new HomePage(driver);
        homePage.navigateTo();

        Header header = new Header(driver);
        header.clickLogin();

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isUrlLoaded(), "The Login URL is not correct!");
        String signInText = loginPage.getSignInElementText();
        Assert.assertEquals(signInText, "Sign in");
        loginPage.populateUsername(user);
        loginPage.populatePassword(password);
        loginPage.clickSignIn();

        Assert.assertTrue(homePage.isUrlLoaded(), "The Home URL is not correct!");
        header.clickProfile();

        ProfilePage profilePage = new ProfilePage(driver);
        Assert.assertTrue(profilePage.isUrlLoaded(), "The Profile URL is not correct!");
        String actualUserName = profilePage.getUsername();
        Assert.assertEquals(actualUserName, name, "The username is incorrect!");
    }
}