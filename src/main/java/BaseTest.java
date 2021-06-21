import Screens.POMScreen;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    SoftAssert softAssert = new SoftAssert();
    final String BROWSER_NAME = "BrowserName"; //Replace BrowserName for Firefox or Chrome
    POMScreen pomScreen;


    @BeforeClass
    public void setupClass() {
        webDriverSetup(BROWSER_NAME);
    }

    @BeforeMethod
    public void setUp() {
        browserSetup(BROWSER_NAME);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
        actions = new Actions(driver);
        pomScreen = new POMScreen(driver);
        wait = new WebDriverWait(driver, 5);
        actions = new Actions(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    private void browserSetup(String browserName) {
        if(browserName.equalsIgnoreCase("Firefox")){
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            driver = new FirefoxDriver(firefoxOptions);
        } else if(browserName.equalsIgnoreCase("Chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            driver = new ChromeDriver(chromeOptions);
        }
    }

    private void webDriverSetup(String browserName) {
        if(browserName.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
        } else if (browserName.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
        }
    }
}
